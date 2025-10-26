package com.backend.productos;

/**
 * Representa un producto dentro del sistema.
 * <p>
 * Cada producto contiene información básica como identificador,
 * nombre, precio y cantidad en stock. Además, ofrece métodos
 * para gestionar su inventario y calcular su precio total.
 * </p>
 *
 * @author
 * @version 1.0
 */
public class Producto {

  /** Contador estático para generar IDs únicos de producto. */
  private static int idContador = 1;

  private int id;
  private String nombre;
  private double precio;
  private int stock;

  /**
   * Constructor principal utilizado al crear un nuevo producto.
   * <p>
   * Asigna un ID autoincremental de manera automática.
   * </p>
   *
   * @param nombre nombre del producto
   * @param precio precio unitario del producto
   * @param stock  cantidad inicial disponible
   */
  public Producto(String nombre, double precio, int stock) {
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;

    // ID única autoincremental
    id = idContador;
    idContador++;
  }

  /**
   * Constructor alternativo utilizado al generar pedidos.
   * <p>
   * Permite asignar un ID personalizado, sin autoincrementar.
   * </p>
   *
   * @param id     identificador del producto
   * @param nombre nombre del producto
   * @param precio precio unitario del producto
   * @param stock  cantidad solicitada
   */
  public Producto(int id, String nombre, double precio, int stock) {
    this.id = id;
    this.nombre = nombre;
    this.precio = precio;
    this.stock = stock;
  }

  /**
   * Devuelve una representación en texto del producto.
   *
   * @return cadena con los datos principales del producto.
   */
  public String toString() {
    return String.format("ID: %d | Nombre: %s | Precio: %.2f | Stock: %d",
            id, nombre, precio, stock);
  }

  /** @return identificador único del producto. */
  public int getId() {
    return id;
  }

  /** @return nombre del producto. */
  public String getNombre() {
    return nombre;
  }

  /** @param nombre nuevo nombre del producto. */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /** @return precio unitario del producto. */
  public double getPrecio() {
    return precio;
  }

  /** @param precio nuevo valor unitario del producto. */
  public void setPrecio(double precio) {
    this.precio = precio;
  }

  /** @return cantidad disponible en stock. */
  public int getStock() {
    return stock;
  }

  /** @param stock nueva cantidad de stock disponible. */
  public void setStock(int stock) {
    this.stock = stock;
  }

  /**
   * Reduce el stock del producto según la cantidad solicitada.
   *
   * @param cantidad unidades a descontar del stock actual.
   */
  public void reducirStock(int cantidad) {
    stock -= cantidad;
  }

  /**
   * Calcula el valor total del producto en función del stock actual.
   *
   * @return precio total (precio unitario × cantidad en stock)
   */
  public double precioTotal() {
    return precio * stock;
  }
}