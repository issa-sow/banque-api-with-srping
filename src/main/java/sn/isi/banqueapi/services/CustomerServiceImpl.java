package sn.isi.banqueapi.services;

import org.springframework.stereotype.Service;
import sn.isi.banqueapi.dtos.CustomerRequestDTO;
import sn.isi.banqueapi.dtos.CustomerResponseDTO;
import sn.isi.banqueapi.entities.Customer;
import sn.isi.banqueapi.mappers.CustomerMapper;
import sn.isi.banqueapi.repositories.CustomerRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream().map(customer -> customerMapper.customerToCustomerResponseDTO(customer) )
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDTO getCustomerById(Long id) {
        return customerMapper.customerToCustomerResponseDTO(customerRepository.findById(id).get());
    }

    @Override
    public CustomerResponseDTO getCustomerByEmail(String email) {
        return customerMapper.customerToCustomerResponseDTO(customerRepository.findCustomerByEmail(email));
    }

    @Override
    public CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customerRequest = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        Customer customerResponse = customerRepository.save(customerRequest);
        return customerMapper.customerToCustomerResponseDTO(customerResponse);
    }

    @Override
    public CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO customerRequestDTO) {
        Customer customerRequest = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        customerRequest.setId(id);
        Customer customerResponse = customerRepository.save(customerRequest);
        return customerMapper.customerToCustomerResponseDTO(customerResponse);
    }

    @Override
    public boolean checkIfIdExists(Long id) {
        return customerRepository.existsById(id);
    }

    @Override
    public void deleteCustomer(Long id) {
        if (this.getCustomerById(id) == null) return;
        customerRepository.deleteById(id);
    }

    /*@Override
    public Page<CustomerResponseDTO> getPaginatedCustomersList(int begin, int end) {
        Pageable page = PageRequest.of(begin, end);
        Page customerpages = customerRepository.findAll(page);
        return customerMapper.paginatedCustomerToPaginetedResponseCustomer(customerpages);
    }*/
}
