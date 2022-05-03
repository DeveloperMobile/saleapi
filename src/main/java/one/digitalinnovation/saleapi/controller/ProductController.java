package one.digitalinnovation.saleapi.controller;

import one.digitalinnovation.saleapi.dto.request.ProductDTO;
import one.digitalinnovation.saleapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.saleapi.exception.ProductNotFoundExecption;
import one.digitalinnovation.saleapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    public ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createProduct(@RequestBody @Valid ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @GetMapping
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id) throws ProductNotFoundExecption {
        return productService.findById(id);
    }
}
