# Experiencia 1 – Semana 3 
## Patrones de diseño de mediana y avanzada complejidad

## Descripción

## Objetivo académico

## Patrones de diseño utilizados

### Singleton

### Decorator

### Command

### Como usar

## Estructura del proyecto
```
src/main/java/com/duoc/exp3_s3/
├── controller/
│   ├── AddToCartCommand.java
│   ├── Invoker.java
│   ├── OrderController.java
│   ├── ProductController.java
│   ├── RemoveFromCartCommand.java
│   └── UserController.java
│
├── model/
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
├── view/
│   ├── CartView.java
│   ├── DiscountView.java
│   └── ProductView.java
│
└── Exp1_S3.java
```