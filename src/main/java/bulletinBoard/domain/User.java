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
@ToString(exclude = "customers")
public class User {
    private String username; //primary key
    @JsonIgnore
    private String encoded_password;
    @JsonIgnore
    private List<Post> post;
}
