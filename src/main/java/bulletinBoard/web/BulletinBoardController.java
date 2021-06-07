package bulletinBoard.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import bulletinBoard.domain.Contributor;
import bulletinBoard.service.ContributorService;
import bulletinBoard.service.LoginUserDetails;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import bulletinBoard.domain.Post;
import bulletinBoard.service.PostService;

//    dbの情報を一覧表示

@Controller
@RequestMapping(path = "posts")
public class BulletinBoardController {
    @Autowired
    private PostService postService;
    @Autowired
    private ContributorService contributorService;
    
    @ModelAttribute
    BulletinBoardForm bulletinBoardForm() {
        return new BulletinBoardForm();
    }

    @GetMapping
    public String index(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @PostMapping(path = "add")
    String create(@Validated BulletinBoardForm bulletinBoardForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return index(model);
        }
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter javaFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Post post = new Post();
        bulletinBoardForm.setDt(nowDateTime.format(javaFormat));
        BeanUtils.copyProperties(bulletinBoardForm, post);
        Contributor contributor = new Contributor();
        BeanUtils.copyProperties(bulletinBoardForm, contributor);
        postService.create(post);
        contributorService.create(contributor);
        return "redirect:/posts";
    }

    @GetMapping(path = "edit", params = "form")
    String editForm(@RequestParam Integer id, BulletinBoardForm bulletinBoardForm) {
        Post post = postService.findById(id);
        BeanUtils.copyProperties(post, bulletinBoardForm);
        return "posts/edit";
    }

    @RequestMapping(path = "edit", params = "goToTop", method = RequestMethod.POST)
    String goToTop() {
        return "redirect:/posts";
    }

    @PostMapping(path = "edit")
    String edit(@RequestParam Integer id, BulletinBoardForm bulletinBoardForm, @NotNull BindingResult result) {
        if (result.hasErrors()) {
            return editForm(id, bulletinBoardForm);
        }
        Post post = new Post();
        BeanUtils.copyProperties(bulletinBoardForm, post);
        post.setId(id);
        postService.update(post);
        return "redirect:/posts";
    }

    @PostMapping(path = "delete")
    String delete(@RequestParam Integer id) {
        postService.delete(id);
        contributorService.delete(id);
        return "redirect:/posts";
    }

}
