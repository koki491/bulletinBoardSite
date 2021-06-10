package bulletinBoard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    private Integer id;
    private String title;
    private String contents;
    private Integer post_num;
    private String category_name;
}
