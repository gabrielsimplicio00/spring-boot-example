package com.gaasimplicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCostumers() {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getACostumer(@PathVariable Integer id) {
        return new ResponseEntity<>(customerService.getACustomer(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerRecord customerData) {
        return new ResponseEntity<>(customerService.addCustomer(customerData), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody CustomerRecord updatedCustomer) {
        return new ResponseEntity<>(customerService.updateCustomer(id, updatedCustomer), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
    }
}
