package bulletinBoard.web;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BulletinBoardForm {
    @NotNull
    @Size(min=1, max=16)
    private String username;
    private Integer contributor_id;
    private String message;
    private String dt;
    private Integer topic_id;
}
