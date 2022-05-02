package one.digitalinnovation.saleapi.controller;

import one.digitalinnovation.saleapi.dto.request.ClientDTO;
import one.digitalinnovation.saleapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.saleapi.exception.ClientNotFoundExecption;
import one.digitalinnovation.saleapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    @Autowired
    public ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createClient(@RequestBody @Valid ClientDTO clientDTO) {
        return clientService.createClient(clientDTO);
    }

    @GetMapping
    public List<ClientDTO> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id) throws ClientNotFoundExecption {
        return clientService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody ClientDTO clientDTO) throws ClientNotFoundExecption {
        return clientService.updateById(id, clientDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ClientNotFoundExecption {
        clientService.deleteById(id);
    }
}
