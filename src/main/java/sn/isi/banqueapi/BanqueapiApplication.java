package sn.isi.banqueapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.isi.banqueapi.dtos.CustomerRequestDTO;
import sn.isi.banqueapi.dtos.CustomerResponseDTO;
import sn.isi.banqueapi.repositories.AccountRepository;
import sn.isi.banqueapi.repositories.CustomerRepository;
import sn.isi.banqueapi.repositories.OperationRepository;
import sn.isi.banqueapi.services.CustomerService;

@SpringBootApplication
public class BanqueapiApplication implements CommandLineRunner {
    @Autowired
    private CustomerRepository repos;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(BanqueapiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*Customer c = new Customer(null, "sow", "issa", "issasow@gmail.com", null);
        Account a = new Account(null, "xxxxxxx", "individuel", new Date(), 200_000, new ArrayList<>(), new ArrayList<>());
        a.getCustomer().add(c);
        repos.save(c);
        accountRepository.save(a);
        Operation operation = new Operation();
        operation.setAccount(a);
        System.out.println(a.getSolde());
        operation.retrait(150_000);
        System.out.println(a.getSolde());
        operationRepository.save(operation);*/

        customerService.saveCustomer(new CustomerRequestDTO("Daillo", "Moustapha", "moustapha@gmail.com"));
        customerService.saveCustomer(new CustomerRequestDTO("Sow", "Yoro", "yoro@gmail.com"));
        customerService.saveCustomer(new CustomerRequestDTO("Ndiaye", "Aliou", "aliou@gmail.com"));
        CustomerResponseDTO customerResponseDTO = customerService.getCustomerById(1L);
        CustomerRequestDTO customerRequestDTO = new CustomerRequestDTO();
        customerRequestDTO.setLastName("Ka");
        customerRequestDTO.setFirstName(customerResponseDTO.getFirstName());
        customerRequestDTO.setEmail(customerResponseDTO.getEmail());
        customerService.updateCustomer(customerResponseDTO.getId(), customerRequestDTO);
    }
}
