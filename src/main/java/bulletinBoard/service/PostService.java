package bulletinBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bulletinBoard.domain.Post;
import bulletinBoard.repository.PostMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public List<Post> findAll() {
        return this.postMapper.findAll();
    }

    public List<Post> findByTopicId(Integer id) {
        Post post = new Post();
        post.setTopic_id(id);
        return this.postMapper.findByTopicId(post);
    }

    public Post findById(Integer id) {
        Post post = new Post();
        post.setId(id);
        return this.postMapper.findById(post);
    }

    public void create(Post post) {
        postMapper.save(post);
    }

    public void update(Post post) {
        postMapper.update(post);
    }

    public void delete(Integer id) {
        postMapper.delete(id);
    }

}
