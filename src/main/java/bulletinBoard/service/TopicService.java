package bulletinBoard.service;

import bulletinBoard.domain.Topic;
import bulletinBoard.repository.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TopicService {

    @Autowired
    private TopicMapper topicMapper;

    public List<Topic> findAll() {
        return this.topicMapper.findAll();
    }

    public Topic findById(Integer id) {
        Topic topic = new Topic();
        topic.setId(id);
        return this.topicMapper.findById(topic);
    }
}
