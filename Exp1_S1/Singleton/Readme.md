# Experiencia 1
## Semana 1 : Conceptos básicos de patrones de diseño simples

## Descripción

Este proyecto implementa una simulación básica de descuentos en productos de ropa utilizando el **patrón de diseño Singleton**. El objetivo principal es demostrar cómo aplicar este patrón en Java, manteniendo una única instancia de la clase `DiscountManager` que gestiona la lógica de descuentos.

## Patrón Singleton

El patrón Singleton se utiliza para garantizar que una clase tenga **una única instancia** accesible globalmente. En este proyecto, `DiscountManager`:

- Tiene un **constructor privado** para evitar instanciación externa.
- Declara una instancia **privada y estática** de sí misma.
- Proporciona un método público `getInstance()` para acceder a la instancia única.

## Productos disponibles

El sistema incluye tres productos:

- Polera Básica — $12.000
- Chaqueta Denim — $18.000
- Pantalón Cargo — $9.500

## Reglas de descuento por cantidad

El descuento se aplica según la cantidad comprada:

| Cantidad comprada | Descuento aplicado |
|-------------------|--------------------|
| 3 a 5 unidades     | 5%                 |
| 6 a 9 unidades     | 7%                 |
| 10 o más unidades  | 10%                |

## Cómo usar

1. Ejecuta el programa desde `Singleton.java`.
2. Selecciona un producto por número.
3. Ingresa la cantidad que deseas comprar.
4. El sistema mostrará:

   - Precio total sin descuento
   - Descuento aplicado
   - Precio final con descuento

## Estructura del proyecto
```
src\main\java\com\duoc\singleton
├─ Product.java 
├─ DiscountManager.java 
└─ Singleton.java
```