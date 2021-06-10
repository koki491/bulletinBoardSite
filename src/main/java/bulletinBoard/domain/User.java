package bulletinBoard.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "contributor")
public class User {
    private Integer user_id;
    private String username; //primary key
    private String encoded_password;
}
