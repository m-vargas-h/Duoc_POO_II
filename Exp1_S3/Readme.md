# Experiencia 1 – Semana 3 
## Patrones de diseño de mediana y avanzada complejidad

## Descripción
Este proyecto implementa un sistema de compras modular y extensible, desarrollado en Java bajo el patrón arquitectónico MVC y utilizando los patrones de diseño Singleton, Decorator y Command. El sistema permite a usuarios registrados o invitados seleccionar productos, visualizar descuentos aplicables, gestionar su carrito y realizar pagos simulados, todo a través de una interfaz por consola clara y profesional.

## Características principales
- Registro de usuarios con validación (RUT, correo, tipo de usuario).
- Persistencia de usuarios mediante archivo CSV (`data/users.csv`).
- Aplicación automática de descuentos por tipo de usuario y categoría de producto.
- Gestión de productos y carrito con control de stock.
- Flujo de pago interactivo con resumen de compra y simulación de boleta.
- Separación clara de responsabilidades en controladores, vistas y modelos.

## Patrones de diseño utilizados
| Patron    | Implementación destacada                                                                  |
|-----------|-------------------------------------------------------------------------------------------|
| Singleton | `DiscountManager` centraliza y gestiona descuentos globales.                              |
| Decorator | `UserTypeDiscountDecorator` y `CategoryDiscountDecorator` aplican descuentos acumulativos.|
| Command   | `AddToCartCommand` y `RemoveFromCartCommand` encapsulan acciones del usuario.             |

## Estructura del proyecto
```
src/main/java/com/duoc/exp3_s3/
├── controller/                             → Entidades del sistema
│   ├── AddToCartCommand.java
│   ├── Invoker.java
│   ├── MenuController.java
│   ├── OrderController.java
│   ├── PaymentProcessor.java
│   ├── ProductController.java
│   ├── RemoveFromCartCommand.java
│   ├── SessionManager.java
│   └── UserController.java
│
├── model/                                  → Lógica de negocio y coordinación
│   ├── CategoryDiscountDecorator.java
│   ├── Command.java
│   ├── Component.java
│   ├── DiscountedProduct.java
│   ├── DiscountManager.java
│   ├── Order.java
│   ├── PercentDiscountDecorator.java
│   ├── Product.java
│   └── User.java
│
├── util/                                   → Persistencia y utilidades
│   └── UserCsvManager.java
│
├── view/                                   → Interfaces de usuario por consola
│   ├── CartView.java
│   ├── DiscountView.java
│   └── ProductView.java
│
└── Exp1_S3.java                            → Clase principal del sistema
```

## Ejecución
Al iniciar el sistema, el usuario puede:
- Registrarse como nuevo usuario.
- Ingresar con RUT si ya está registrado.
- Ingresar como invitado (sin descuentos por tipo de usuario).
Luego podrá navegar por el menú principal, agregar productos al carrito, visualizar descuentos y proceder al pago.

## Persistencia
- Los usuarios registrados se almacenan en data/users.csv.
- La carpeta data/ se crea automáticamente si no existe.
