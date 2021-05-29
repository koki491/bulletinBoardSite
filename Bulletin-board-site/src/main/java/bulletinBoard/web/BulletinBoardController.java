package bulletinBoard.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMethod;
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
    
//    @ModelAttribute
//    BulletinBoardForm bulletinBoardForm() {
//        return new BulletinBoardForm();
//    }


//    @RequestMapping(value="customers", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/index";
    }

    //メッセージの新規登録
    @PostMapping("add")
    public String create(@RequestParam String name, @RequestParam String message) {
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter javaFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Customer customer = new Customer(null, name, message, nowDateTime.format(javaFormat));
        customerService.create(customer);
        return "redirect:/customers";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Customer customer) {
        customer.setId(id);
        customerService.update(customer);
        return "redirect:/customers";
    }

}
