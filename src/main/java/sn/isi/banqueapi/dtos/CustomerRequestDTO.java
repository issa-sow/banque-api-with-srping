package sn.isi.banqueapi.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Customer Request Modele")
@Data @NoArgsConstructor @AllArgsConstructor
public class CustomerRequestDTO {
    @ApiModelProperty(value = "Customer last name")
    private String lastName;
    @ApiModelProperty(value = "Customer first name")
    private String firstName;
    @ApiModelProperty(value = "Customer email")
    private String email;
}
