package one.digitalinnovation.saleapi.mapper;

import one.digitalinnovation.saleapi.dto.request.ProviderDTO;
import one.digitalinnovation.saleapi.entity.Provider;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProviderMapper {
    ProviderMapper INSTANCE = Mappers.getMapper(ProviderMapper.class);
    Provider toModel(ProviderDTO providerDTO);
    ProviderDTO toDTO(Provider provider);
}
