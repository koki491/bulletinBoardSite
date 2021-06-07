package bulletinBoard.web;

import bulletinBoard.service.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private RegisterUserService registerUserService;

    //トップページ
    @RequestMapping(value = "/")
    public String topPage() {
        return "topPage";
    }

    //ログイン画面
    @RequestMapping(value = "/loginForm", method = RequestMethod.GET)
    public String loginForm(Model model) {
        return "loginForm";
    }

    @PostMapping("/loginForm")
    public String postLogin(Model model) {
        return "/loginForm";
    }

    //ユーザー登録画面
    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String newUser() {
        return "newUser";
    }

    //ユーザー登録実装
    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public ModelAndView register(
            ModelAndView mav,
            @RequestParam("username") String username,
            @RequestParam("encoded_password") String encoded_password) {

        RegisterUserForm registerUserForm = new RegisterUserForm();
        registerUserForm.setUsername(username);
        registerUserForm.setEncoded_password(encoded_password);
        try {
            //ユーザー情報を登録
            registerUserService.create(registerUserForm);
            mav.setViewName("loginForm");
        } catch (Exception e) {
            mav.setViewName("newUser");
            mav.addObject("error", "ユーザー名は使用できません。：" + username);
        }
        return mav;
    }

}
