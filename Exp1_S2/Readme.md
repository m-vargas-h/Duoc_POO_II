# Experiencia 1 – Semana 2  
## Patrones de diseño de mediana y avanzada complejidad

## Descripción

Este proyecto extiende la simulación de descuentos en productos de ropa incorporando los patrones de diseño **Decorator**, **Singleton** y **Command**. El objetivo es demostrar cómo estos patrones pueden trabajar en conjunto para construir un sistema modular, extensible y fácil de mantener.

## Objetivo académico
Este proyecto forma parte de la evaluación de la asignatura Programación Orientada a Objetos II, y busca aplicar buenas prácticas de diseño en sistemas reales.


## Patrones de diseño utilizados

### Singleton
Se utiliza para mantener una única instancia de configuración global del sistema (`Configuracion.java`), evitando duplicación de estado y facilitando el acceso centralizado.

- Constructor privado  
- Instancia estática privada  
- Método público `getInstance()`  

### Decorator
Permite aplicar descuentos acumulativos sin modificar la clase base. Cada decorador añade una lógica adicional de forma dinámica.

Ejemplo:
```java
Descuento base = new DescuentoFijo(1000);
Descuento decorado = new DescuentoPorcentaje(base, 0.10);
System.out.println("Total con descuento: " + decorado.calcular());
```

### Command
Encapsula acciones como comandos reutilizables. Por ejemplo, generar informes o aplicar descuentos se realiza mediante objetos `Command`.

### Como usar
- Ejecuta el programa desde `App.java`.
- Selecciona un producto por número.
- Ingresa la cantidad deseada.
- El sistema mostrará:
    - Precio total sin descuento
    - Descuento aplicado
    - Precio final con descuento

## Estructura del proyecto
```
src\main\java\com\duoc\exp1_s2
├─ app
    └─ Exp1_S2.java
├─ command
    ├─ AddToCartCommand.java
    ├─ Command.java
    ├─ Invoker.java
    ├─ RemoveFromCartCommand.java
    └─ ShoppingCart.java
├─ decorator
    ├─ CategoryDiscountDecorator.java
    ├─ Component.java
    ├─ Decorator.java
    ├─ PercentDiscountDecorator.java
    ├─ Product.java
    └─ QuantityDiscountDecorator.java
└─ singleton
    └─ DiscountManager.java
```

