package bulletinBoard.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import bulletinBoard.service.LoginUserDetails;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import bulletinBoard.domain.Customer;
import bulletinBoard.service.CustomerService;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;

//    dbの情報を一覧表示

@Controller
@RequestMapping(path = "customers")
public class BulletinBoardController {
    @Autowired
    private CustomerService customerService;
    
    @ModelAttribute
    BulletinBoardForm bulletinBoardForm() {
        return new BulletinBoardForm();
    }


//    @RequestMapping(value="customers", method = RequestMethod.GET)
//    @RequestMapping(value = "/loginForm", method = RequestMethod.POST)
    @GetMapping
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

    @PostMapping(path = "add")
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

//    @PutMapping("{id}")
//    String update(@PathVariable Integer id, @ModelAttribute Customer customer, @AuthenticationPrincipal LoginUserDetails userDetails) {
//        customer.setId(id);
//        customerService.update(customer, userDetails.getUser());
//        return "redirect:/customers";
//    }
//
//    @DeleteMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    void deleteCustomer(@PathVariable Integer id) {
//        customerService.delete(id);
//    }

    @GetMapping(path = "edit", params = "form")
    String editForm(@RequestParam Integer id, BulletinBoardForm bulletinBoardForm) {
        Customer customer = customerService.findById(id);
        BeanUtils.copyProperties(customer, bulletinBoardForm);
        return "customers/edit";
    }

    @RequestMapping(path = "edit", params = "goToTop", method = RequestMethod.POST)
    String goToTop() {
        return "redirect:/customers";
    }

    @PostMapping(path = "edit")
    String edit(@RequestParam Integer id, BulletinBoardForm bulletinBoardForm, @NotNull BindingResult result) {
        if (result.hasErrors()) {
            return editForm(id, bulletinBoardForm);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(bulletinBoardForm, customer);
        customer.setId(id);
        customerService.update(customer);
        return "redirect:/customers";
    }

    @PostMapping(path = "delete")
    String delete(@RequestParam Integer id) {
        customerService.delete(id);
        return "redirect:/customers";
    }

}
