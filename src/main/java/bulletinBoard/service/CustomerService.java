package bulletinBoard.service;

import java.util.List;
//import java.util.Optional;

import bulletinBoard.domain.User;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bulletinBoard.domain.Customer;
import bulletinBoard.repository.CustomerMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer> findAll() {
        return this.customerMapper.findAll();
    }

    public Customer findById(Integer id) {
        Customer customer = new Customer();
        customer.setId(id);
        return this.customerMapper.findById(customer);
    }

//    public Customer create(Customer customer) {
//        return customerRepository.save(customer);
//    }
//
//    public Customer update(Customer customer ) {
//        return customerRepository.save(customer);
//    }
//
    public void create(Customer customer, User user) {
        customer.setUser(user);
        customerMapper.save(customer);
    }

    public void update(Customer customer) {
        customerMapper.update(customer);
    }

    public void delete(Integer id) {
        customerMapper.delete(id);
    }

}
