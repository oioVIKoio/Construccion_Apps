# L4D2 Fan Store

Aplicación de terminal desarrollada en Java que simula una tienda de productos temáticos para fanáticos del videojuego **Left 4 Dead 2**.

## Funcionalidades

- **Agregar productos**: Permite registrar nuevos artículos ingresando nombre, precio y stock.
- **Listar productos**: Muestra en consola el catálogo con el detalle de precios y unidades disponibles.
- **Comprar productos**: Permite seleccionar artículos para compra, validando disponibilidad y actualizando el stock.
- **Cálculo de compras**: Calcula el total a pagar según las cantidades adquiridas.

## Tecnologías y Conceptos

- **Lenguaje**: Java 21
- **Gestor de proyectos y dependencias**: Apache Maven
- **Conceptos aplicados**:
  - Programación Orientada a Objetos (POO): Clases, encapsulamiento y constructores.
  - Colecciones: `ArrayList` para la gestión dinámica de productos.
  - Control de flujo: Estructuras `switch` y bucles interactivos.
  - Métodos modulares para cada funcionalidad del sistema.

## Compilación y Ejecución

### 1. Compilar el proyecto

Desde la raíz de este proyecto (`Semana_01/L4D2FanStore`), ejecutar:

```bash
mvn clean package
```

### 2. Ejecutar la aplicación

Una vez generado el archivo JAR en la carpeta `target/`, ejecutar:

```bash
java -jar target/L4D2FanStore-1.0-SNAPSHOT.jar
```

---

> **Nota académica**: Este proyecto fue desarrollado con el apoyo de un agente de Inteligencia Artificial como parte de la actividad práctica de la **Semana 01** del curso Construcción y Pruebas de Software.