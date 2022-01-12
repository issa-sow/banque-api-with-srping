package sn.isi.banqueapi.services;

import sn.isi.banqueapi.dtos.CustomerRequestDTO;
import sn.isi.banqueapi.dtos.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDTO> getAllCustomers();
    CustomerResponseDTO getCustomerById(Long id);
    CustomerResponseDTO getCustomerByEmail(String email);
    CustomerResponseDTO saveCustomer(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO customerRequestDTO);
    boolean checkIfIdExists(Long id);
    void deleteCustomer(Long id);
   //Page<CustomerResponseDTO> getPaginatedCustomersList(int begin, int end);
}
