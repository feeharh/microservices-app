package customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest){
       Customer customer = Customer.builder()
               .firstName(customerRegistrationRequest.firstName())
               .lastName(customerRegistrationRequest.lastName())
               .email(customerRegistrationRequest.email())
               .build();

       //todo: validations: 1. check if email is valid
        // todo: validations: 1. check if email is not taken


        //todo: validations: 1.storecustomer in database
       customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }
}
