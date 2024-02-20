package life.majiang.community.model;

import lombok.Data;

@Data//pom文件引入lombok后添加该注解就会自动生成get、set方法
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
}
