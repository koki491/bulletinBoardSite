package bulletinBoard.web;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
public class BulletinBoardForm {
    @NotNull
    @Size(min=1, max=16)
    private String name;
    @NotNull
    @Size(min=1, max=400)
    private String message;
    private LocalDateTime time;
}
