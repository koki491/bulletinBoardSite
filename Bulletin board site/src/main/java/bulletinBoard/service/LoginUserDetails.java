package bulletinBoard.service;

import bulletinBoard.domain.User;
import lombok.Data;
//import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Optional;

@Data
public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
    private final User user;

    public LoginUserDetails(User user) {
        super(user.getUsername(), user.getEncoded_password(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.user = user;
    }
}