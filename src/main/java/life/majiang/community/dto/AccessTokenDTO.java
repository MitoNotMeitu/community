package life.majiang.community.dto;

import lombok.Data;

//类与类之间之间传输用DTO对象
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
