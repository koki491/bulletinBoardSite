package bulletinBoard.repository;

import bulletinBoard.domain.Contributor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContributorMapper {

    void save(Contributor contributor);

    void delete(Integer id);
}
