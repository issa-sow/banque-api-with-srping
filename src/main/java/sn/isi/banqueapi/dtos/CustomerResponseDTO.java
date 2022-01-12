package sn.isi.banqueapi.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.isi.banqueapi.entities.Account;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Customer Response Modele")
@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerResponseDTO {
    @ApiModelProperty(value = "Customer id")
    private Long id;
    @ApiModelProperty(value = "Customer last name")
    private String lastName;
    @ApiModelProperty(value = "Customer first name")
    private String firstName;
    @ApiModelProperty(value = "Customer email")
    private String email;
    @ApiModelProperty(value = "Customer list accounts")
    private List<Account> accounts = new ArrayList<Account>();
}
