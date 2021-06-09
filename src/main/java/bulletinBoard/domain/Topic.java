package bulletinBoard.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    private int id;
    private String title;
    private String contents;
    private int post_num;
    private String category_name;
}
