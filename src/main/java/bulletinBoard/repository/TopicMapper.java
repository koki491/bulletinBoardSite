package bulletinBoard.repository;

import bulletinBoard.domain.Topic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopicMapper {
    List<Topic> findAll();

    Topic findById(Topic topic);

    void update(Topic topic);
}
