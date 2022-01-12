package sn.isi.banqueapi.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.isi.banqueapi.entities.Customer;
import sn.isi.banqueapi.entities.Operation;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Account Response Modele")
@Data @NoArgsConstructor @AllArgsConstructor
public class AccountResponseDTO {
    @ApiModelProperty(value = "Account Id")
    private Long id;
    @ApiModelProperty(value = "Account num card")
    private String numCard;
    @ApiModelProperty(value = "Account type")
    private String accountType;
    @ApiModelProperty(value = "Account solde")
    private double solde;
    @ApiModelProperty(value = "Account custoùmer list")
    private List<Customer> customer = new ArrayList<Customer>();
    @ApiModelProperty(value = "Account operations list")
    private List<Operation> operations = new ArrayList<Operation>();
}
