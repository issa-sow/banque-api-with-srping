package sn.isi.banqueapi.mappers;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import sn.isi.banqueapi.dtos.CustomerRequestDTO;
import sn.isi.banqueapi.dtos.CustomerResponseDTO;
import sn.isi.banqueapi.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    //Page<CustomerResponseDTO> paginatedCustomerToPaginetedResponseCustomer(Page<Customer> customerPage);
}
