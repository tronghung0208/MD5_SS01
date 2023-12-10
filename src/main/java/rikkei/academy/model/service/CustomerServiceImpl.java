package rikkei.academy.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.academy.model.entity.Customer;
import rikkei.academy.model.repository.CustomerRepository;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Boolean saveOrUpdate(Customer customer) {
        return customerRepository.saveOrUpdate(customer);
    }

    @Override
    public void delete(Integer integer) {

    }
}
