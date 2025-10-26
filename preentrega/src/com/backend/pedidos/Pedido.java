package com.backend.pedidos;

import com.backend.productos.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un pedido dentro del sistema.
 * <p>
 * Cada pedido contiene una lista de productos asociados, y permite
 * agregar nuevos productos manteniendo la coherencia del stock.
 * </p>
 *
 * <p>La clase implementa una estructura básica para gestionar los
 * productos solicitados por un cliente o proceso interno.</p>
 *
 * @author
 * @version 1.0
 */
public class Pedido {

  /**
   * Lista de productos incluidos en el pedido.
   * <p>
   * Cada elemento de la lista contiene información como ID, nombre,
   * precio y cantidad solicitada.
   * </p>
   */
  private List<Producto> productos = new ArrayList<>();

  /**
   * Obtiene la lista actual de productos asociados al pedido.
   *
   * @return lista de objetos {@link Producto} del pedido.
   */
  public List<Producto> getProductos() {
    return productos;
  }

  /**
   * Agrega un producto al pedido.
   * <p>
   * Si el producto ya existe (mismo ID), incrementa su cantidad en lugar
   * de duplicarlo en la lista. Si no existe, se añade como un nuevo elemento.
   * </p>
   *
   * <p>Este método garantiza que el pedido no contenga productos repetidos
   * y que el stock total se mantenga actualizado.</p>
   *
   * @param producto producto a agregar al pedido.
   */
  public void agregarProducto(Producto producto) {

    for (Producto p : productos) {
      if (p.getId() == producto.getId()) {
        p.setStock(p.getStock() + producto.getStock());
        return;
      }
    }

    productos.add(producto);
  }
}
