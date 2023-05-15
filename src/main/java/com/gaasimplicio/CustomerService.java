package com.gaasimplicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getACustomer(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer addCustomer(CustomerRecord customerData) {
        Customer customer = new Customer();
        customer.setName(customerData.name());
        customer.setAge(customerData.age());
        customer.setEmail(customerData.email());
        customerRepository.save(customer);
        return customer;
    }

    public Customer updateCustomer(Integer id, CustomerRecord updatedCustomer) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setName(updatedCustomer.name());
            customer.setAge(updatedCustomer.age());
            customer.setEmail(updatedCustomer.email());
            customerRepository.save(customer);
        }
        return customer;
    }

    public String deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
        return "User deleted";
    }
}
