package bulletinBoard.repository;

import bulletinBoard.domain.User;
import bulletinBoard.web.RegisterUserForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findById(User user);

    List<User> findAll();

    void save(RegisterUserForm registerUserForm);
}
