package sn.isi.banqueapi.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.banqueapi.dtos.CustomerRequestDTO;
import sn.isi.banqueapi.dtos.CustomerResponseDTO;
import sn.isi.banqueapi.entities.Customer;
import sn.isi.banqueapi.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/api")
@Api(value = "Customer Rest Controller: contains all operations for managing customer")
public class CustomerRestController {
    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    @ApiOperation(value = "List customers of banque in a list", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: customers successfully listed"),
            @ApiResponse(code = 204, message = "No Content: no result found")
    })
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        List<CustomerResponseDTO> customerResponseDTOS = customerService.getAllCustomers();
        if(customerResponseDTOS.isEmpty()) {
            return new ResponseEntity<List<CustomerResponseDTO>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CustomerResponseDTO>>(customerResponseDTOS, HttpStatus.OK);
    }

    @GetMapping(path = "/customer/{id}")
    @ApiOperation(value = "Get a customer by his id", response = CustomerResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: customer successfully found"),
            @ApiResponse(code = 500, message = "Internal Server Error: No customer found")
    })
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable Long id) {
        if(customerService.getCustomerById(id) == null) {
            return new ResponseEntity<CustomerResponseDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        CustomerResponseDTO  customerResponseDTO = customerService.getCustomerById(id);
        return new ResponseEntity<>(customerResponseDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/customer/email/{email}")
    @ApiOperation(value = "Get a customer by his email", response = CustomerResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: customer successfully found"),
            @ApiResponse(code = 500, message = "Internal Server Error: No customer found")
    })
    public ResponseEntity<CustomerResponseDTO> getCustomerByEmail(@PathVariable String email) {
        if(customerService.getCustomerByEmail(email) == null) {
            return new ResponseEntity<CustomerResponseDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        CustomerResponseDTO  customerResponseDTO = customerService.getCustomerByEmail(email);
        return new ResponseEntity<>(customerResponseDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/customer/checkId/{checkId}")
    @ApiOperation(value = "Check if customer id exists", response = Boolean.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: customer successfully found"),
            @ApiResponse(code = 404, message = "Not Found: No customer found")
    })
    public ResponseEntity<Boolean> checkIfIdExists(@PathVariable Long checkId) {
        if(customerService.checkIfIdExists(checkId)) {
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/customer/saveCustomer")
    @ApiOperation(value = "Save a customer", response = CustomerResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created: Customer successfully created"),
            @ApiResponse(code = 304, message = "Not Modified: Customer unsuccessfully inserted")
    })
    public ResponseEntity<CustomerResponseDTO> saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        if(customerRequestDTO != null) {
            CustomerResponseDTO customerResponseDTO = customerService.saveCustomer(customerRequestDTO);
            return new ResponseEntity<CustomerResponseDTO>(customerResponseDTO, HttpStatus.CREATED);
        }
        return new ResponseEntity<CustomerResponseDTO>(HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(path = "/customer/{id}")
    @ApiOperation(value = "Update a customer by his id", response = CustomerResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok: the customer is successfully updated"),
            @ApiResponse(code = 304, message = "Not Modified: the customer is unsuccessfully updated")
    })
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@PathVariable Long id,
                                                              @RequestBody CustomerRequestDTO customerRequestDTO) {
        if(customerService.getCustomerById(id) == null) {
            return new ResponseEntity<CustomerResponseDTO>(HttpStatus.NOT_MODIFIED);
        }
        CustomerResponseDTO customerResponseDTO = customerService.updateCustomer(id, customerRequestDTO);
        return new ResponseEntity<CustomerResponseDTO>(customerResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/customer/{id}")
    @ApiOperation(value = "Delete the customer by his id", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "No Content: customer successfully deleted"),
    })
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
