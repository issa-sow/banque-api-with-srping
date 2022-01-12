package sn.isi.banqueapi.mappers;

import org.mapstruct.Mapper;
import sn.isi.banqueapi.dtos.OperationRequestDTO;
import sn.isi.banqueapi.dtos.OperationResponseDTO;
import sn.isi.banqueapi.entities.Operation;

@Mapper(componentModel = "spring")
public interface OperationMapper {
    Operation operationRequestDTOToOperation(OperationRequestDTO operationRequestDTO);
    OperationResponseDTO operationToOperationResponseDTO(Operation operation);
}
