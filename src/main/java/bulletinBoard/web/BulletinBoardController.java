package bulletinBoard.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import bulletinBoard.domain.Contributor;
import bulletinBoard.service.ContributorService;
import bulletinBoard.service.LoginUserDetails;
import bulletinBoard.service.TopicService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import bulletinBoard.domain.Topic;
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
    @Autowired
    private TopicService topicService;
    
    @ModelAttribute
    BulletinBoardForm bulletinBoardForm() {
        return new BulletinBoardForm();
    }

    @GetMapping(path = "topicPage")
    public String topicPage(Model model) {
        List<Topic> topics = topicService.findAll();
        model.addAttribute("topics", topics);
        return "posts/topicPage";
    }

    @GetMapping
    public String index(@RequestParam Integer id, BulletinBoardForm bulletinBoardForm, Model model) {
        List<Post> posts = postService.findByTopicId(id);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @PostMapping(path = "add")
    String create(@Validated BulletinBoardForm bulletinBoardForm, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return index(model);
//        }
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter javaFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Post post = new Post();
        bulletinBoardForm.setDt(nowDateTime.format(javaFormat));
        //後々topicテーブルのidをいれる
        bulletinBoardForm.setTopic_id(1);
        //messageとdtをpostにいれる
        BeanUtils.copyProperties(bulletinBoardForm, post);
        Contributor contributor = new Contributor();
        //usernameをcontributorにいれる
        BeanUtils.copyProperties(bulletinBoardForm, contributor);
        Topic topic = new Topic();
        topic.setId(1);
        postService.create(post);
        contributorService.create(contributor);
        topicService.update(topic);
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
        Topic topic = new Topic();
        topic.setId(1);
        topicService.update(topic);
        return "redirect:/posts";
    }

}
