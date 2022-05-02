package one.digitalinnovation.saleapi.mapper;

import one.digitalinnovation.saleapi.dto.request.ClientDTO;
import one.digitalinnovation.saleapi.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    Client toModel(ClientDTO clientDTO);
    ClientDTO toDTO(Client client);
}
