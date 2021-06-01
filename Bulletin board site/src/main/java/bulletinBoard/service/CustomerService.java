package bulletinBoard.service;

import java.util.List;
import java.util.Optional;
//import java.util.Optional;

import bulletinBoard.domain.User;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bulletinBoard.domain.Customer;
import bulletinBoard.repository.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

//    public Customer create(Customer customer) {
//        return customerRepository.save(customer);
//    }
//
//    public Customer update(Customer customer ) {
//        return customerRepository.save(customer);
//    }
//
    public Customer create(Customer customer, User user) {
        customer.setUser(user);
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer, User user) {
        customer.setUser(user);
        return customerRepository.save(customer);
    }

}
