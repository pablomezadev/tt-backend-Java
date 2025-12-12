# TTSpringBoot – Backend para plataforma de e-commerce

Este repositorio contiene el backend desarrollado durante el curso Talentotech, 
implementado con Spring Boot y diseñado para ofrecer servicios sólidos y escalables 
para aplicaciones de comercio electrónico.

---

## Descripción general

La API proporciona un sistema completo de gestión de productos, 
permitiendo realizar operaciones esenciales para un e-commerce moderno. El proyecto 
está estructurado siguiendo buenas prácticas, con uso de DTOs, control de CORS y 
endpoints pensados para integrarse fácilmente con un frontend.

## Funciones incluidas

- Administración completa de productos (crear, consultar, actualizar y eliminar).
- Búsqueda de productos por nombre.
- Manejo de atributos como imágenes, stock, categorías y descripciones.
- Configuración de CORS para comunicación segura entre servicios.
- Respuestas estandarizadas mediante DTOs.
- Arquitectura construida sobre Spring Boot, priorizando estabilidad y escalabilidad.

---

## Enlaces importantes

| Recurso                       | Enlace                                                                                                                                                                                                     |
|-------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Sitio Frontend                | [https://mezattspringboot.netlify.app](https://mezattspringboot.netlify.app)                                                                                                                               |
| Sitio Frontend - admin (crud) | [https://mezattspringboot.netlify.app](https://mezattspringboot.netlify.app/admin)                                                                                                                         |
| Backend API                   | [https://backendp](https://tt-backend-java.onrender.com)                                                                                                                                                                       |
| Documentación de la API       | [https://backend](https://tt-backend-java)                                                                                                                                                                         |
| Repositorio del Frontend      | [https://github.com/pablomezadev/TT-React/tree/proyectoReact-para-final-backend-ecommerce-pablo-meza](https://github.com/pablomezadev/TT-React/tree/proyectoReact-para-final-backend-ecommerce-pablo-meza) |

---

## 📋 Endpoints disponibles

- `POST /products` – Crear un nuevo producto.
- `GET /products` – Listar todos los productos.
- `GET /products/search?queryName=` – Buscar productos por nombre.
- `GET /products/{id}` – Obtener un producto por ID.
- `PUT /products/{id}` – Actualizar un producto existente.
- `DELETE /products/{id}` – Eliminar un producto por ID.

---

## 🛠️ Tecnologías utilizadas

- Java
- Spring Boot
- Maven
- REST API
- DTO pattern
- CORS
- React (en el frontend)

---

## ⚙️ Instalación y ejecución local

1. **Clonar el repositorio**

   ```bash
   git clone git@github.com:pablomezadev/tt-backend-Java.git
   ```

2. **Ejecuta la aplicación**
    * Puedes abrir la aplicación con tu IDE favorito y ejecutar el archivo **TTSpringBootJavaApplicationTests**
    * Si tienes maven instalado puedes usar:
   ```bash
    cd tt-backend-Java
    git chekout proyecto-final-backend-ecommerce-pablo-meza
    mvn spring-boot:run
   ```