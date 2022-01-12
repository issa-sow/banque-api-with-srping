package sn.isi.banqueapi.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.isi.banqueapi.entities.Account;

@ApiModel(value = "Operation Request")
@Data @NoArgsConstructor @AllArgsConstructor
public class OperationRequestDTO {
    @ApiModelProperty(value = "Operation label")
    private String label;
    @ApiModelProperty(value = "Operation account")
    private Account account;
}
