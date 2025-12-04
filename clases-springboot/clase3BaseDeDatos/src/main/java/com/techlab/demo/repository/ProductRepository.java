package com.techlab.demo.repository;

import com.techlab.demo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Es buen practica dejar la etiqueta pero en este caso no es obligatorio, ya que jpa en alguna parte de la cadena
// ya existe
@Repository
public interface ProductRepository extends JpaRepository<Producto, Long> {

}
