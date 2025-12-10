package ttspringboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttspringboot.dto.request.ProductRequestDTO;
import ttspringboot.dto.response.ProductResponseDTO;
import ttspringboot.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "${frontend.url}")
public class ProductController {

  private ProductService service;

  public ProductController(ProductService service) {
    this.service = service;
  }

  // @Operation sirve para generar documentacion en swagger
  @Operation(summary = "Crear producto", description = "Agrega un nuevo producto al sistema")
  @ApiResponse(responseCode = "201", description = "Producto creado")
  @PostMapping("")
  public ResponseEntity<ProductResponseDTO> createProduct(
      @RequestBody ProductRequestDTO requestDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createProduct(requestDTO));
  }

  @Operation(summary = "Listar Productos", description = "Obtiene un listado de todos los productos del sistema")
  @GetMapping("")
  public List<ProductResponseDTO> getProducts() {
    return this.service.getProducts();
  }

  @Operation(summary = "Buscar por nombre", description = "Obtiene un listado de todos los productos que contenga el termino buscado en su nombre")
  @GetMapping("/search")
  public List<ProductResponseDTO> searchProductsByName(@RequestParam String queryName) {
    return this.service.searchProductByName(queryName);
  }

  @Operation(summary = "Buscar por ID", description = "Obtiene un producto que coincida con el ID")
  @GetMapping("/{id}")
  public ProductResponseDTO searchProductsById(@PathVariable Long id) {
    return this.service.searchProductById(id);
  }

  @Operation(summary = "Actualizar producto", description = "Actualiza un producto usando las propiedades pasadas en la request, esto pasa si el ID es valido")
  @PutMapping("/{id}")
  public ProductResponseDTO updateProduct(@PathVariable Long id,
      @RequestBody ProductRequestDTO requestDTO) {
    return this.service.updateProduct(id, requestDTO);
  }

  @Operation(summary = "Eliminar producto", description = "Elimina un producto del sistema, esto pasa si el ID es valido")
  @DeleteMapping("/{id}")
  public ProductResponseDTO deleteProduct(@PathVariable Long id) {
    return this.service.deleteProduct(id);
  }
}
