# Pre-Entrega: TT-Backend-Java

## Descripción General
Esta es la pre entrega para el curso java back end 2025 dictada por TT.

## Propuestas de Implementación

### 1. Gestión de Productos
- Implementar la eliminación de productos de la lista general al ejecutar una operación de borrado.
- Permitir que la clase `Producto` calcule sus propios precios individuales y totales, mejorando la cohesión de responsabilidades.
- Incluir validaciones para controlar el **stock** disponible antes de confirmar pedidos, lanzando excepciones específicas en caso de stock insuficiente.

### 2. Filtrado y Búsquedas
- Ampliar las funcionalidades de filtrado permitiendo búsquedas por nombre u otros atributos.
- Retornar o mostrar una lista de productos cuyos nombres contengan la cadena buscada.

### 3. Manipulación de Pedidos
- Incorporar la posibilidad de modificar o eliminar productos dentro de un pedido existente.
- Sincronizar los cambios entre los pedidos y el inventario para mantener la coherencia de datos.

### 4. Refactorización del Main
- Extraer el bucle `do/while` principal que maneja el menú de opciones a un método independiente, dejando el método `main` más limpio y legible.
- Dividir las operaciones del menú en métodos específicos:
    - Un método para mostrar las opciones disponibles.
    - Otro para gestionar la opción seleccionada mediante un bloque `switch`.

### 5. Validaciones y Utilidades
- Implementar un verificador que evite la aceptación de cadenas vacías en los ingresos de texto.
- Agregar un método utilitario que elimine los espacios en blanco innecesarios al inicio y final de las cadenas ingresadas.
- Incluir una opción que permita al usuario cancelar una acción en curso (por ejemplo, cancelar la creación de un producto).

## Objetivo
Estas mejoras buscan promover e incorporar en el aprendizaje, un código más limpio, modular y robusto, siguiendo buenas prácticas de desarrollo orientado a objetos y manteniendo la escalabilidad del proyecto.