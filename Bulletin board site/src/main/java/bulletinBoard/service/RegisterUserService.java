package bulletinBoard.service;

import bulletinBoard.repository.UserMapper;
import bulletinBoard.web.RegisterUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterUserService {

    @Autowired
    private UserMapper userMapper;

    public void create(RegisterUserForm registerUserForm) {
        userMapper.save(registerUserForm);
    }
}
