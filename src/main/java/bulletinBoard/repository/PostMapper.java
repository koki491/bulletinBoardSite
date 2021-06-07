package bulletinBoard.repository;

import org.apache.ibatis.annotations.Mapper;

import bulletinBoard.domain.Post;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> findAll();

    Post findById(Post post);

    void save(Post post);

    void update(Post post);

    void delete(Integer id);
}
