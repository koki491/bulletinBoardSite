package bulletinBoard.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import bulletinBoard.service.LoginUserDetails;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import bulletinBoard.domain.Customer;
import bulletinBoard.service.CustomerService;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;

//    dbの情報を一覧表示

@Controller
@RequestMapping("customers")
public class BulletinBoardController {
    @Autowired
    private CustomerService customerService;
    
    @ModelAttribute
    BulletinBoardForm bulletinBoardForm() {
        return new BulletinBoardForm();
    }


//    @RequestMapping(value="customers", method = RequestMethod.GET)
//    @RequestMapping(value = "/loginForm", method = RequestMethod.POST)
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/index";
    }

    //メッセージの新規登録
//    @PostMapping("add")
//    public String create(@RequestParam String name, @RequestParam String message) {
//        LocalDateTime nowDateTime = LocalDateTime.now();
//        DateTimeFormatter javaFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        Customer customer = new Customer(null, name, message, nowDateTime.format(javaFormat));
//        customerService.create(customer);
//        return "redirect:/customers";
//    }

    @PostMapping("add")
    String create(@Validated BulletinBoardForm bulletinBoardForm, BindingResult result, Model model, @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return index(model);
        }
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter javaFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Customer customer = new Customer();
        bulletinBoardForm.setDt(nowDateTime.format(javaFormat));
        BeanUtils.copyProperties(bulletinBoardForm, customer);
        customerService.create(customer, userDetails.getUser());
        return "redirect:/customers";
    }

//    @PostMapping("add")
//    String create(@AuthenticationPrincipal LoginUserDetails userDetails, @RequestParam String message) {
//        LocalDateTime nowDateTime = LocalDateTime.now();
//        DateTimeFormatter javaFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        Customer customer = new Customer();
//        customer.setTime(nowDateTime.format(javaFormat));
//        customerService.create(customer, userDetails.getUser());
//        return "redirect:/customers";
//    }

//    @PutMapping("{id}")
//    String update(@PathVariable Integer id, @ModelAttribute Customer customer) {
//        customer.setId(id);
//        customerService.update(customer);
//        return "redirect:/customers";
//    }

    @PutMapping("{id}")
    String update(@PathVariable Integer id, @ModelAttribute Customer customer, @AuthenticationPrincipal LoginUserDetails userDetails) {
        customer.setId(id);
        customerService.update(customer, userDetails.getUser());
        return "redirect:/customers";
    }

}
