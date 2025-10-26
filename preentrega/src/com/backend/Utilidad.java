package com.backend;

import com.backend.excepciones.*;
import com.backend.productos.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utilidad {

  /**
   * Solicita al usuario un número entero válido a través del teclado.
   * Repite la solicitud hasta que el valor ingresado sea un entero.
   *
   * @param teclado objeto {@link Scanner} utilizado para la entrada del usuario
   * @param mensaje mensaje que se muestra al usuario solicitando el dato
   * @return un número entero válido ingresado por el usuario
   */
  public static int numeroIntValido(Scanner teclado, String mensaje) {
    int numero;
    while (true) {
      try {
        System.out.print(mensaje);
        numero = teclado.nextInt();
        teclado.nextLine();
        break;
      } catch (InputMismatchException e) {
        System.out.println("El número ingresado no es válido.");
        teclado.nextLine();
      }
    }
    return numero;
  }

  /**
   * Solicita al usuario un número decimal válido (double).
   * Valida que el valor ingresado sea un número de tipo double.
   *
   * @param teclado objeto {@link Scanner} utilizado para la entrada del usuario
   * @param mensaje mensaje que se muestra al usuario solicitando el dato
   * @return un número double válido ingresado por el usuario
   */
  public static double numeroDoubleValido(Scanner teclado, String mensaje) {
    double numero;
    while (true) {
      try {
        System.out.print(mensaje);
        numero = teclado.nextDouble();
        teclado.nextLine();
        break;
      } catch (InputMismatchException e) {
        System.out.println("El número ingresado no es válido.");
        teclado.nextLine();
      }
    }
    return numero;
  }

  /**
   * Solicita al usuario un número decimal positivo (double).
   * Si el número es negativo, lanza y captura una excepción personalizada.
   *
   * @param teclado objeto {@link Scanner} utilizado para la entrada del usuario
   * @param mensaje mensaje que se muestra al usuario solicitando el dato
   * @return un número double positivo ingresado por el usuario
   */
  public static double numeroDoublePositivo(Scanner teclado, String mensaje) {
    double numero;
    while (true) {
      try {
        numero = numeroDoubleValido(teclado, mensaje);
        if (numero < 0) {
          throw new NumeroException("El número no puede ser negativo");
        }
        break;
      } catch (NumeroException e) {
        System.out.println("Ingrese un número positivo");
      }
    }
    return numero;
  }

  /**
   * Solicita al usuario un número entero positivo.
   * Valida que sea un entero y mayor o igual a cero.
   *
   * @param teclado objeto {@link Scanner} utilizado para la entrada del usuario
   * @param mensaje mensaje que se muestra al usuario solicitando el dato
   * @return un número entero positivo ingresado por el usuario
   */
  public static int numeroIntPositivo(Scanner teclado, String mensaje) {
    int numero;
    while (true) {
      try {
        numero = numeroIntValido(teclado, mensaje);
        if (numero < 0) {
          throw new NumeroException("El número no puede ser negativo");
        }
        break;
      } catch (NumeroException e) {
        System.out.println("Ingrese un número positivo");
      }
    }
    return numero;
  }

  /**
   * Imprime una cantidad determinada de líneas vacías en la consola.
   *
   * @param cantidad número de líneas vacías a imprimir
   */
  public static void dejarEspacios(int cantidad) {
    for (int i = 0; i < cantidad; i++) {
      System.out.println();
    }
  }

  /**
   * Pausa la ejecución del programa hasta que el usuario presione Enter.
   *
   * @param scanner objeto {@link Scanner} utilizado para la entrada del usuario
   */
  public static void presioneEnterParaContinuar(Scanner scanner) {
    System.out.print("\nPresione 'ENTER' para continuar...");
    String enter = scanner.nextLine();
  }

  /**
   * Busca la posición de un producto en una lista según su ID.
   * Devuelve -1 si no existe el producto o si la lista está vacía.
   *
   * @param id identificador único del producto
   * @param productos lista de objetos {@link Producto} donde se realiza la búsqueda
   * @return posición del producto en la lista, o -1 si no se encuentra
   */
  public static int posicionProductoId(int id, List<Producto> productos) {
    if (productos.isEmpty()) {
      return -1;
    }

    if (id == 0) {
      return -1;
    }

    for (int i = 0; i < productos.size(); i++) {
      if (productos.get(i).getId() == id) {
        return i;
      }
    }

    return -1;
  }

  /**
   * Solicita un ID al usuario y devuelve la posición del producto correspondiente.
   * Si la lista está vacía o la ID no existe, devuelve un valor indicador (-1 o -2).
   *
   * @param teclado objeto {@link Scanner} utilizado para la entrada del usuario
   * @param productos lista de objetos {@link Producto} donde se realiza la búsqueda
   * @return posición del producto si existe, -1 si no existe, o -2 si la lista está vacía
   */
  public static int posicionId(Scanner teclado, List<Producto> productos) {
    if (productos.isEmpty()) {
      System.out.println("La lista de productos se encuentra vacía");
      return -2;
    }

    int id = Utilidad.numeroIntPositivo(teclado, "Ingrese la ID solicitada: ");

    if (Utilidad.posicionProductoId(id, productos) == -1) {
      System.out.println("No existe un producto con la ID solicitada");
      return -1;
    }

    return Utilidad.posicionProductoId(id, productos);
  }
}