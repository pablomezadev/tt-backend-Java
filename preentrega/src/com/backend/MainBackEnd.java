package com.backend;

import com.backend.excepciones.NumeroException;
import com.backend.pedidos.Pedido;
import com.backend.productos.Producto;
import com.backend.servicio.ProductoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal del módulo de servicios.
 * <p>
 * Permite la gestión de productos y pedidos mediante un menú interactivo en consola.
 * </p>
 *
 * @author
 * @version 1.0
 */
public class MainBackEnd {

  /**
   * Método principal que inicia la ejecución del sistema.
   * <p>
   * Controla el flujo del menú, gestiona las opciones del usuario y
   * delega las operaciones correspondientes al {@link ProductoService}.
   * </p>
   *
   * @param args argumentos de línea de comando (no utilizados)
   */
  public static void main(String[] args) {

    Scanner teclado = new Scanner(System.in);
    int opcion;

    List<Producto> productos = new ArrayList<>();
    Pedido pedido = new Pedido();
    ProductoService servicio = new ProductoService();

    do {

      System.out.println("""
          1) Agregar un producto
          2) Listar los productos disponibles
          3) Buscar producto por id
          4) Actualizar producto por id
          5) Eliminar producto por id
          6) Crear un pedido por id
          7) Listar pedidos relizados
          8) Salir del programa
          """);

      while (true) {
        opcion = Utilidad.numeroIntValido(teclado, "Elija una opción: ");
        try {
          if (opcion < 1 || opcion > 8) {
            throw new NumeroException("Opción inválida");
          }
          break;
        } catch (NumeroException e) {
          System.out.println("Opción inválida");
        }
      }

      switch (opcion) {
        case 1:
          servicio.agregarProducto(teclado, productos);
          Utilidad.presioneEnterParaContinuar(teclado);
          Utilidad.dejarEspacios(30);
          break;

        case 2:
          servicio.listarProductos(productos);
          Utilidad.presioneEnterParaContinuar(teclado);
          Utilidad.dejarEspacios(30);
          break;

        case 3:
          servicio.buscarProductoPorId(teclado, productos);
          Utilidad.presioneEnterParaContinuar(teclado);
          Utilidad.dejarEspacios(30);
          break;

        case 4:
          servicio.actualizarProducto(teclado, productos);
          Utilidad.presioneEnterParaContinuar(teclado);
          Utilidad.dejarEspacios(30);
          break;

        case 5:
          servicio.eliminarProductoPorId(teclado, productos);
          Utilidad.presioneEnterParaContinuar(teclado);
          Utilidad.dejarEspacios(30);
          break;

        case 6:
          servicio.crearPedido(teclado, productos, pedido);
          Utilidad.presioneEnterParaContinuar(teclado);
          Utilidad.dejarEspacios(30);
          break;

        case 7:
          servicio.listarPedidos(pedido);
          Utilidad.presioneEnterParaContinuar(teclado);
          Utilidad.dejarEspacios(30);
          break;

        case 8:
          break;
      }

    } while (opcion != 8);

    teclado.close();
  }
}