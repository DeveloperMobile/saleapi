package one.digitalinnovation.saleapi.service;

import one.digitalinnovation.saleapi.dto.request.ProductDTO;
import one.digitalinnovation.saleapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.saleapi.entity.Product;
import one.digitalinnovation.saleapi.mapper.ProductMapper;
import one.digitalinnovation.saleapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    public ProductRepository repository;

    public MessageResponseDTO createProduct(ProductDTO productDTO) {
        Product productToSave = ProductMapper.INSTANCE.toModel(productDTO);
        Product savedProduct = repository.save(productToSave);
        return createMessageResponse(savedProduct.getId(), "Created product with ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
