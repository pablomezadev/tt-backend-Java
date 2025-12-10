package ttspringboot.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends TTSpringBootException {

    public ProductNotFoundException(String queryTerm) {
        super("No se pudo encontrar el producto",
                String.format("No se encontró ningún producto al buscar con el término: <%s>", queryTerm),
                HttpStatus.NOT_FOUND);
    }
}
