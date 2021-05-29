package bulletinBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import bulletinBoard.repository.CustomerRepository;

@SpringBootApplication
public class Main implements CommandLineRunner{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void run(String... strings) throws Exception {
        
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
