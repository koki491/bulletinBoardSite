package bulletinBoard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Integer id;
    private String username;
    private String message;
    private String dt;
    private Integer topic_id;
}
