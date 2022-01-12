package sn.isi.banqueapi.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Account Request Modele")
@Data @NoArgsConstructor @AllArgsConstructor
public class AccountRequestDTO {
    @ApiModelProperty(value = "Account num cad")
    private String numCard;
    @ApiModelProperty(value = "Account type")
    private String accountType;
    @ApiModelProperty(value = "Account solde")
    private double solde;
}
