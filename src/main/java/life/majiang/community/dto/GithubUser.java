package life.majiang.community.dto;

import lombok.Data;

@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;//fastjson将可以自动地将接收到的下划线属性改为驼峰属性，所以这里的命名可以不遵循github官方命名格式，而是用更符合java命名习惯的格式，并不会影响使用
}
