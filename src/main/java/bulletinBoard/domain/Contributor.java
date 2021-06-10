package bulletinBoard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contributor {
    private Integer contributor_id;
    private String username;
    private Integer user_id;
}
