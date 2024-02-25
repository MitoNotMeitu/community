function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();

    //校验一下回复内容就可以了，id本来就不能为空，交给服务器端校验就好了
    if (!content){
        alert("不能回复空内容~~~");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/Json',
        data: JSON.stringify({
            "parentId": questionId,
            "content": content,
            "type": 1
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                if (response.code == 2003) {//当用户未登录时
                    var isAccepted = confirm(response.message);//弹窗，提示是否登录
                    if (isAccepted){//用户选择登录，打开新窗口
                        window.open("https://github.com/login/oauth/authorize?client_id=a6b42dc8758b5ca4c457&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        //localStorage用于存储web的长期信息，除非手动删除不然没有过期时间。这里以键值对形式存入是否要关闭页面的指示值
                        window.localStorage.setItem("closable",true);
                    }
                } else {
                    alert(response.message);
                }
            }
        },
        dataType: "json"
    });
}