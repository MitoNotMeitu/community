package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeCotroller {

    @Autowired//GithubProvider中由于注解了@Component，所以这里直接注解Autowired就可以直接用了，不用再去new。
    private GithubProvider githubProvider;

    @Value("${github.client.id}")//与Autowired功能类似，Value注解会去配置文件找到相应key的值并赋给下面的变量。
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request){//使用HttpServletRequest后，Springboot会自动将上下文中的request传进来。而session就是在request当中的。
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        if (user !=null){
            //登陆成功，写入cookie和session
            request.getSession().setAttribute("user",user);
            return "redirect:/";
        }else {
            //不成功，重新登陆
            return "redirect:/";
        }
    }
}
