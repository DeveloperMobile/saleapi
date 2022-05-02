package one.digitalinnovation.saleapi.service;

import one.digitalinnovation.saleapi.dto.request.ProviderDTO;
import one.digitalinnovation.saleapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.saleapi.entity.Provider;
import one.digitalinnovation.saleapi.exception.ProviderNotFoundExecption;
import one.digitalinnovation.saleapi.mapper.ProviderMapper;
import one.digitalinnovation.saleapi.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProviderService {
    @Autowired
    public ProviderRepository repository;
    public MessageResponseDTO createProvider(ProviderDTO providerDTO) {
        Provider providerToSave = ProviderMapper.INSTANCE.toModel(providerDTO);
        Provider savedProvider = repository.save(providerToSave);
        return createMessageResponse(savedProvider.getId(), "Created provider with ID ");
    }

    public List<ProviderDTO> findAll() {
        List<Provider> providers = repository.findAll();
        return providers.stream()
                .map(ProviderMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public ProviderDTO findById(Long id) throws ProviderNotFoundExecption {
        Provider provider = verifyIfExists(id);
        return ProviderMapper.INSTANCE.toDTO(provider);
    }

    public MessageResponseDTO updateById(Long id, ProviderDTO providerDTO) throws ProviderNotFoundExecption {
        verifyIfExists(id);
        Provider providerToUpdate = ProviderMapper.INSTANCE.toModel(providerDTO);
        Provider updateProvider = repository.save(providerToUpdate);
        return createMessageResponse(updateProvider.getId(), "Update Provider with ID ");
    }

    public void deleteById(Long id) throws ProviderNotFoundExecption {
        verifyIfExists(id);
        repository.deleteById(id);
    }

    private Provider verifyIfExists(Long id) throws ProviderNotFoundExecption {
        return repository.findById(id)
                .orElseThrow(() -> new ProviderNotFoundExecption(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
