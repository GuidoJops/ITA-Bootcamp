-- MySQL Workbench Synchronization
-- Generated: 2022-09-02 19:45
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Guido

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `Pizzeria` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`cliente` (
  `cliente_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `cp` VARCHAR(10) NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  `localidad` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cliente_id`),
  UNIQUE INDEX `clientes_id_UNIQUE` (`cliente_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`pedido` (
  `pedido_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cliente_id` INT(11) NOT NULL,
  `tienda_id` INT(11) NOT NULL,
  `tipo_pedido_id` INT(11) NOT NULL,
  `empleado_id` INT(11) NOT NULL COMMENT 'Empleado que toma el pedido',
  `cantidad_productos` INT(11) NULL DEFAULT NULL,
  `precio_total` DECIMAL(9,2) NULL DEFAULT NULL,
  `fecha_entrega` DATETIME NULL DEFAULT NULL,
  `repartidor_id` INT(11) NULL DEFAULT NULL COMMENT 'Empleado que hace el reparto',
  PRIMARY KEY (`pedido_id`),
  UNIQUE INDEX `pedidos_id_UNIQUE` (`pedido_id` ASC) VISIBLE,
  INDEX `fk_pedidos_tiendas1_idx` (`tienda_id` ASC) VISIBLE,
  INDEX `fk_pedidos_clientes1_idx` (`cliente_id` ASC) VISIBLE,
  INDEX `fk_pedido_empleado1_idx` (`empleado_id` ASC) VISIBLE,
  INDEX `fk_pedido_tipo_pedido1_idx` (`tipo_pedido_id` ASC) VISIBLE,
  INDEX `fk_pedido_empleado2_idx` (`repartidor_id` ASC) VISIBLE,
  CONSTRAINT `fk_pedidos_tiendas1`
    FOREIGN KEY (`tienda_id`)
    REFERENCES `Pizzeria`.`tienda` (`tienda_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedidos_clientes1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `Pizzeria`.`cliente` (`cliente_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_empleado1`
    FOREIGN KEY (`empleado_id`)
    REFERENCES `Pizzeria`.`empleado` (`empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_tipo_pedido1`
    FOREIGN KEY (`tipo_pedido_id`)
    REFERENCES `Pizzeria`.`tipo_pedido` (`tipo_pedido_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_empleado2`
    FOREIGN KEY (`repartidor_id`)
    REFERENCES `Pizzeria`.`empleado` (`empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`producto` (
  `producto_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(200) NULL DEFAULT NULL,
  `imagen_producto` LONGBLOB NULL DEFAULT NULL,
  `precio` DECIMAL(9,2) NOT NULL,
  `tipo_producto_id` INT(11) NOT NULL,
  `categoria_pizza_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`producto_id`),
  UNIQUE INDEX `productos_id_UNIQUE` (`producto_id` ASC) VISIBLE,
  INDEX `fk_productos_tipo_producto1_idx` (`tipo_producto_id` ASC) VISIBLE,
  INDEX `fk_productos_categorias_pizzas1_idx` (`categoria_pizza_id` ASC) VISIBLE,
  CONSTRAINT `fk_productos_tipo_producto1`
    FOREIGN KEY (`tipo_producto_id`)
    REFERENCES `Pizzeria`.`tipo_producto` (`tipo_producto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productos_categorias_pizzas1`
    FOREIGN KEY (`categoria_pizza_id`)
    REFERENCES `Pizzeria`.`categoria_pizza` (`categoria_pizza_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`categoria_pizza` (
  `categoria_pizza_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`categoria_pizza_id`),
  UNIQUE INDEX `categorias_pizzas_id_UNIQUE` (`categoria_pizza_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`tienda` (
  `tienda_id` INT(11) NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(45) NOT NULL,
  `cp` VARCHAR(10) NOT NULL,
  `localidad` VARCHAR(45) NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tienda_id`),
  UNIQUE INDEX `tiendas_id_UNIQUE` (`tienda_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`empleado` (
  `empleado_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `nif` VARCHAR(9) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `tienda_id` INT(11) NOT NULL,
  `tipo_empleado_id` INT(11) NOT NULL,
  PRIMARY KEY (`empleado_id`),
  UNIQUE INDEX `empleados_id_UNIQUE` (`empleado_id` ASC) VISIBLE,
  INDEX `fk_empleado_tienda1_idx` (`tienda_id` ASC) VISIBLE,
  INDEX `fk_empleado_tipo_empleado1_idx` (`tipo_empleado_id` ASC) VISIBLE,
  UNIQUE INDEX `nif_UNIQUE` (`nif` ASC) VISIBLE,
  CONSTRAINT `fk_empleado_tienda1`
    FOREIGN KEY (`tienda_id`)
    REFERENCES `Pizzeria`.`tienda` (`tienda_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleado_tipo_empleado1`
    FOREIGN KEY (`tipo_empleado_id`)
    REFERENCES `Pizzeria`.`tipo_empleado` (`tipo_empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`tipo_producto` (
  `tipo_producto_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tipo_producto_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`detalle_pedido` (
  `pedido_id` INT(11) NOT NULL,
  `producto_id` INT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  PRIMARY KEY (`pedido_id`, `producto_id`),
  INDEX `fk_productos_has_pedidos_pedidos1_idx` (`pedido_id` ASC) VISIBLE,
  INDEX `fk_productos_has_pedidos_productos1_idx` (`producto_id` ASC) VISIBLE,
  CONSTRAINT `fk_productos_has_pedidos_productos1`
    FOREIGN KEY (`producto_id`)
    REFERENCES `Pizzeria`.`producto` (`producto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productos_has_pedidos_pedidos1`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `Pizzeria`.`pedido` (`pedido_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`tipo_empleado` (
  `tipo_empleado_id` INT(11) NOT NULL AUTO_INCREMENT,
  `puesto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tipo_empleado_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Pizzeria`.`tipo_pedido` (
  `tipo_pedido_id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tipo_pedido_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
