package sn.isi.banqueapi.mappers;

import org.mapstruct.Mapper;
import sn.isi.banqueapi.dtos.AccountRequestDTO;
import sn.isi.banqueapi.dtos.AccountResponseDTO;
import sn.isi.banqueapi.entities.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account accountRequestDTOToAccount(AccountRequestDTO accountRequestDTO);
    AccountResponseDTO accountToAccountResponseDTO(Account account);
}
