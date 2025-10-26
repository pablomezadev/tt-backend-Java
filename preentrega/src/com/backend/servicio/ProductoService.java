package com.backend.servicio;

import com.backend.Utilidad;
import com.backend.pedidos.Pedido;
import com.backend.productos.Producto;
import java.util.List;
import java.util.Scanner;

/**
 * Clase de servicio que gestiona las operaciones relacionadas con los productos
 * y pedidos. Permite agregar, listar, buscar, actualizar, eliminar productos y
 * crear pedidos a partir de los mismos.
 */
public class ProductoService {

  /**
   * Agrega un nuevo producto a la lista de productos solicitando los datos al usuario.
   *
   * @param teclado objeto {@link Scanner} utilizado para la entrada de datos
   * @param productos lista de objetos {@link Producto} donde se agregará el nuevo producto
   */
  public void agregarProducto(Scanner teclado, List<Producto> productos) {
    Utilidad.dejarEspacios(30);
    System.out.println("========== AGREGAR PRODUCTO ==========\n");

    System.out.println("Datos del nuevo producto");
    System.out.print("Nombre: ");
    String nombre = teclado.nextLine();
    double precio = Utilidad.numeroDoublePositivo(teclado, "Precio: ");
    int stock = Utilidad.numeroIntPositivo(teclado, "Stock: ");

    Producto producto = new Producto(nombre, precio, stock);
    productos.add(producto);
  }

  /**
   * Muestra en consola la lista completa de productos registrados.
   *
   * @param productos lista de objetos {@link Producto} a mostrar
   */
  public void listarProductos(List<Producto> productos) {
    Utilidad.dejarEspacios(30);
    System.out.println("========== LISTA DE PRODUCTOS ==========\n");

    for (Producto p : productos) {
      System.out.println(p.toString());
    }
  }

  /**
   * Busca y muestra un producto según su identificador (ID).
   *
   * @param teclado objeto {@link Scanner} utilizado para la entrada de datos
   * @param productos lista de objetos {@link Producto} donde se realiza la búsqueda
   */
  public void buscarProductoPorId(Scanner teclado, List<Producto> productos) {
    Utilidad.dejarEspacios(30);
    System.out.println("========== BUSCAR PRODUCTO POR ID ==========\n");

    int posicion = Utilidad.posicionId(teclado, productos);

    if (posicion >= 0) {
      System.out.println(productos.get(posicion).toString());
    }
  }

  /**
   * Actualiza los datos de un producto existente a partir de su ID.
   * Solicita al usuario los nuevos valores y los reemplaza en la lista.
   *
   * @param teclado objeto {@link Scanner} utilizado para la entrada de datos
   * @param productos lista de objetos {@link Producto} donde se encuentra el producto a actualizar
   */
  public void actualizarProducto(Scanner teclado, List<Producto> productos) {
    Utilidad.dejarEspacios(30);
    System.out.println("========== ACTUALIZAR PRODUCTO POR ID ==========\n");

    int posicion = Utilidad.posicionId(teclado, productos);

    if (posicion >= 0) {
      System.out.println("Esta por actualizar el producto:");
      System.out.println(productos.get(posicion).toString());
      System.out.println("\nIngrese los nuevos valores");

      System.out.print("Nombre: ");
      String nombre = teclado.nextLine();
      double precio = Utilidad.numeroDoublePositivo(teclado, "Precio: ");
      int stock = Utilidad.numeroIntPositivo(teclado, "Stock: ");

      productos.get(posicion).setNombre(nombre);
      productos.get(posicion).setPrecio(precio);
      productos.get(posicion).setStock(stock);
    }
  }

  /**
   * Elimina un producto de la lista según su ID, previa confirmación del usuario.
   *
   * @param teclado objeto {@link Scanner} utilizado para la entrada de datos
   * @param productos lista de objetos {@link Producto} de la cual se eliminará el producto
   */
  public void eliminarProductoPorId(Scanner teclado, List<Producto> productos) {
    Utilidad.dejarEspacios(30);
    System.out.println("========== ELIMINAR PRODUCTO POR ID ==========\n");

    int posicion = Utilidad.posicionId(teclado, productos);
    String opcion;

    if (posicion >= 0) {
      System.out.println("Esta por eliminar el producto:");
      System.out.println(productos.get(posicion).toString());

      System.out.print("\nConfirmar si/no: ");
      opcion = teclado.nextLine();

      if (opcion.equalsIgnoreCase("si")) {
        productos.remove(posicion);
      } else if (opcion.equalsIgnoreCase("no")) {
        System.out.println("Se ha cancelado la eliminación del producto.");
      } else {
        System.out.println("La opción ingresada no es válida.");
      }
    }
  }

  /**
   * Crea un nuevo pedido a partir de un producto seleccionado y la cantidad solicitada.
   * Valida el stock disponible y actualiza las existencias del producto.
   *
   * @param teclado objeto {@link Scanner} utilizado para la entrada de datos
   * @param productos lista de objetos {@link Producto} disponibles para el pedido
   * @param pedido objeto {@link Pedido} donde se agregará el producto solicitado
   */
  public void crearPedido(Scanner teclado, List<Producto> productos, Pedido pedido) {
    Utilidad.dejarEspacios(30);
    System.out.println("========== CREAR PEDIDO ==========\n");

    int stock;
    int posicion = Utilidad.posicionId(teclado, productos);

    if (posicion >= 0) {

      System.out.println("\nProducto solicitado: ");
      System.out.println(productos.get(posicion).toString());

      stock = Utilidad.numeroIntPositivo(teclado, "\nStock solicitado: ");

      if (stock == 0) {
        System.out.println("\nNo se puede solicitar la cantidad 0 de un producto.");
        return;
      }

      if (stock > productos.get(posicion).getStock()) {
        System.out.println("\nNo hay stock suficiente.");
        return;
      }

      productos.get(posicion).reducirStock(stock);

      int id = productos.get(posicion).getId();
      String nombre = productos.get(posicion).getNombre();
      double precio = productos.get(posicion).getPrecio();

      Producto producto = new Producto(id, nombre, precio, stock);
      pedido.agregarProducto(producto);
    }
  }

  /**
   * Muestra en consola la lista de productos agregados al pedido actual.
   * También calcula y muestra el precio total del pedido.
   *
   * @param pedido objeto {@link Pedido} que contiene los productos seleccionados
   */
  public void listarPedidos(Pedido pedido) {
    Utilidad.dejarEspacios(30);
    System.out.println("========== LISTA DE PEDIDOS ==========\n");

    if (pedido.getProductos().isEmpty()) {
      System.out.println("La lista de pedidos se encuentra vacía.");
      return;
    }

    double total = 0;

    for (Producto p : pedido.getProductos()) {
      System.out.println(p.toString());
      total += p.precioTotal();
    }

    System.out.printf("%nPrecio final: $%.2f%n", total);
  }
}