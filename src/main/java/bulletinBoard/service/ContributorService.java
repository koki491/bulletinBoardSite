package bulletinBoard.service;

import bulletinBoard.domain.User;
import bulletinBoard.domain.Contributor;
import bulletinBoard.repository.ContributorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContributorService {

    @Autowired
    private ContributorMapper contributorMapper;

    public void create(Contributor contributor, String username, String encoded_password) {
        contributor.setUsername1(username);
        contributor.setEncoded_password1(encoded_password);
        contributorMapper.save(contributor);
    }

    public void delete(Integer id) {
        contributorMapper.delete(id);
    }
}
