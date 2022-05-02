package one.digitalinnovation.saleapi.controller;

import one.digitalinnovation.saleapi.dto.request.ProviderDTO;
import one.digitalinnovation.saleapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.saleapi.exception.ProviderNotFoundExecption;
import one.digitalinnovation.saleapi.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/provider")
public class ProviderController {
    @Autowired
    public ProviderService providerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createProvider(@RequestBody @Valid ProviderDTO providerDTO) {
        return providerService.createProvider(providerDTO);
    }

    @GetMapping
    public List<ProviderDTO> findAll() {
        return providerService.findAll();
    }

    @GetMapping("/{id}")
    public ProviderDTO findById(@PathVariable Long id) throws ProviderNotFoundExecption {
        return providerService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody ProviderDTO providerDTO) throws ProviderNotFoundExecption {
        return providerService.updateById(id, providerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ProviderNotFoundExecption {
        providerService.deleteById(id);
    }
}
