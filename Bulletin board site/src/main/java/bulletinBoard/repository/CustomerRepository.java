package bulletinBoard.repository;

//import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bulletinBoard.domain.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

//@Mapper
//public interface CustomerRepository {
//    List<Customer> findAll();
//    Customer findById(Long id);
//
//    Customer save(Customer customer);
//}
