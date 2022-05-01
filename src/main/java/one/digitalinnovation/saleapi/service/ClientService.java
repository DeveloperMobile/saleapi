package one.digitalinnovation.saleapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.saleapi.dto.request.ClientDTO;
import one.digitalinnovation.saleapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.saleapi.entity.Client;
import one.digitalinnovation.saleapi.mapper.ClientMapper;
import one.digitalinnovation.saleapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    public ClientRepository repository;
    public MessageResponseDTO createClient(ClientDTO clientDTO) {
        Client clientToSave = ClientMapper.INSTANCE.toModel(clientDTO);
        Client savedClient = repository.save(clientToSave);
        return createMessageResponse(savedClient.getId(), "Created person with ID ");
    }

    public List<ClientDTO> findAll() {
        List<Client> clients = repository.findAll();
        return clients.stream()
                .map(ClientMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
