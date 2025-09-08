# Experiencia 2 – Semana 4 
## Creando un ambiente de ciclo de vida de software

Proyecto desarrollado en Java como parte del curso **Programación Orientada a Objetos II (PRY2203)**. El sistema permite gestionar un inventario de productos, aplicando patrones de diseño y buenas prácticas de arquitectura.

---

## 📚 Índice

1. [Requisitos del Sistema](#requisitos-del-sistema)  
2. [Diseño y Arquitectura](#diseño-y-arquitectura)  
3. [Implementación](#implementación)  
4. [Pruebas](#pruebas)  
5. [Despliegue](#despliegue)  
6. [Documentación Técnica](#documentación-técnica)  
7. [Mantenimiento y Evolución](#mantenimiento-y-evolución)

---

## 📝 Requisitos del Sistema

### Funcionales
- Agregar, buscar, modificar y eliminar productos.
- Aplicar decoradores como etiquetas y descuentos.
- Persistencia automática en archivo CSV.
- Carga de inventario al iniciar el sistema.

### No Funcionales
- Portabilidad sin configuración adicional.
- Validación de formato en CSV.
- Modularidad y documentación del código.
- Pruebas automatizadas con Maven y JUnit.

---

## 📐 Diseño y Arquitectura

El sistema está organizado en paquetes:

```
Exp2_S4/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/duoc/exp2_s4/
│   │           ├── Exp2_S4.java
│   │           ├── command/                            → Acciones encapsuladas (Command Pattern) 
│   │           │   ├── ComandoActualizarProducto.java
│   │           │   ├── ComandoAgregarProducto.java
│   │           │   ├── ComandoBuscarPorTexto.java
│   │           │   ├── ComandoEliminarProducto.java
│   │           │   ├── ComandoListarProductos.java
│   │           │   └── ComandoPrincipal.java
│   │           ├── controller/                         → Lógica del inventario 
│   │           │   └── Inventario.java
│   │           ├── model/                              → Clases de dominio y decoradores 
│   │           │   ├── InventarioController.java
│   │           │   ├── EtiquetaProducto.java
│   │           │   ├── Producto.java
│   │           │   ├── ProductoConDescuento.java
│   │           │   └── ProductoConIVA.java
│   │           ├── util/                               → Utilidades como generador de códigos 
│   │           │   ├── CodigoProductoGenerator.java
│   │           │   └── InputManager.java
│   │           └── view/
│   │               └── MenuPrincipal.java              → Menú principal
│
│   └── test/
│       └── java/
│           └── com/duoc/exp2_s4/
│               ├── controller/
│               │   └── InventarioIntegracionTest.java
│               └── model/
│                   └── ProductoTest.java
│
├── data/
│   └── inventario.csv
├── pom.xml
└── README.md
```

### Patrones aplicados
- Singleton (`Inventario`)
- Decorator (`ProductoConEtiqueta`, `ProductoConDescuento`)
- Command (`ComandoAgregarProducto`, etc.)

---

## 💻 Implementación

- Proyecto Maven con estructura estándar.
- Uso de `Map<String, Producto>` para gestión eficiente.
- Decoradores aplicados dinámicamente.
- Persistencia en `data/inventario.csv`.

---

## 🧪 Pruebas

### Unitarias
- `ProductoTest`: creación, modificación de atributos.
- `InventarioTest`: agregar, eliminar, buscar, listar.

### Integración
- `InventarioIntegracionTest`: flujo completo entre `Producto` e `Inventario`.

### Resultado
- Todas las pruebas ejecutadas con `mvn test`
- Estado: `BUILD SUCCESS`

---

## 🚀 Despliegue

### Requisitos
- JDK 21
- Maven
- NetBeans 25 o compatible

### Instrucciones
1. Clonar o descomprimir el proyecto.
2. Ejecutar `mvn clean install` para compilar y testear.
3. Ejecutar `Exp2_S4.java` desde el IDE.

---

## 📄 Documentación Técnica

La documentación Javadoc se encuentra en:
- target/reports/apidocs/index.html

Incluye descripción de clases, métodos y atributos.

---

## 🔧 Mantenimiento y Evolución

### Mejoras aplicadas
- Validación de entradas nulas.
- Refactorización de métodos de búsqueda.
- Corrección de formato en CSV.

### Propuestas futuras
- Interfaz gráfica con JavaFX.
- Exportación a PDF o Excel.
- Migración a base de datos con JDBC.
- Refactorización hacia MVC completo.

---

## 📌 Autor

**Miguel [Valdivia, Chile]**  
Curso: Programación Orientada a Objetos II  
Institución: Duoc UC  
Año: 2025
