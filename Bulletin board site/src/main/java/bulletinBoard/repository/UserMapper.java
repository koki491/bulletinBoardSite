package bulletinBoard.repository;

import bulletinBoard.domain.User;
import org.apache.ibatis.annotations.Mapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//public interface UserRepository  extends JpaRepository<User, String> {
//
//}

@Mapper
public interface UserMapper {
    //User findById(String username);
    User findById(User user);

    List<User> findAll();
}
