package ttspringboot.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ttspringboot.dto.request.ProductRequestDTO;
import ttspringboot.dto.response.ProductResponseDTO;
import ttspringboot.entity.Product;
import ttspringboot.exception.ProductNotFoundException;
import ttspringboot.repository.ProductRepository;
import java.util.List;

@Service
public class ProductService {

  private ProductRepository repository;

  public ProductService(ProductRepository repository) {
    this.repository = repository;
  }

  public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
    Product product = new Product();
    BeanUtils.copyProperties(productRequestDTO, product);

    System.out.println("producto recibido para agregar: "+product);

    this.repository.save(product);

    ProductResponseDTO productResponseDTO = new ProductResponseDTO();
    BeanUtils.copyProperties(product, productResponseDTO);
    return productResponseDTO;
  }

  public List<ProductResponseDTO> getProducts() {
    return this.repository.findAll()
        .stream()
        .map(this::mapperToDTO)
        .toList();
  }

  public List<ProductResponseDTO> searchProductByName(String queryName) {
    List<Product> foundProducts = this.repository.findByNameContainingIgnoreCase(queryName);

    if (foundProducts.isEmpty()) {
      throw new ProductNotFoundException(queryName);
    }

    return foundProducts
        .stream()
        .map(this::mapperToDTO)
        .toList();
  }

  public ProductResponseDTO searchProductById(Long id) {
    Product product = this.repository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(id.toString()));

    return this.mapperToDTO(product);
  }

  public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
    Product product = this.repository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(id.toString()));
    BeanUtils.copyProperties(productRequestDTO, product);

    this.repository.save(product);

    return this.mapperToDTO(product);
  }

  public ProductResponseDTO deleteProduct(Long id) {
    Product product = this.repository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(id.toString()));
    this.repository.delete(product);

    return this.mapperToDTO(product);
  }

  /**
   * Convertir la entidad de *Product* en un *ProductResponseDTO* para la respuesta
   *
   * @param p - producto a convertir
   * @return ProductResponseDTO
   */
  private ProductResponseDTO mapperToDTO(Product p) {
    ProductResponseDTO dto = new ProductResponseDTO();
    BeanUtils.copyProperties(p, dto);
    return dto;
  }
}
