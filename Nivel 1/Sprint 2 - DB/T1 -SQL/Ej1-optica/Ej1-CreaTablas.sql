-- MySQL Workbench Synchronization
-- Generated: 2022-09-02 15:54
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Guido

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `Optica` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `Optica`.`proveedores` (
  `proveedor_id` INT(11) NOT NULL AUTO_INCREMENT,
  `proveedor_nombre` VARCHAR(45) NOT NULL,
  `proveedor_telefono` VARCHAR(30) NULL DEFAULT NULL,
  `proveedor_fax` VARCHAR(30) NULL DEFAULT NULL,
  `proveedor_nif` VARCHAR(9) NOT NULL,
  `calle` VARCHAR(45) NULL DEFAULT NULL,
  `numero` INT(11) NULL DEFAULT NULL,
  `piso` INT(11) NULL DEFAULT NULL,
  `puerta` VARCHAR(5) NULL DEFAULT NULL,
  `ciudad` VARCHAR(45) NULL DEFAULT NULL,
  `cp` VARCHAR(10) NULL DEFAULT NULL,
  `pais` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`proveedor_id`),
  UNIQUE INDEX `NIF_UNIQUE` (`proveedor_nif` ASC) VISIBLE,
  UNIQUE INDEX `proveedor_nombre_UNIQUE` (`proveedor_nombre` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Optica`.`gafas` (
  `gafas_id` INT(11) NOT NULL AUTO_INCREMENT,
  `graduacion_izq` DECIMAL(9,2) NULL DEFAULT 0.00,
  `graduacion_der` DECIMAL(9,2) NULL DEFAULT 0.00,
  `montura` CHAR(1) NOT NULL COMMENT 'F=Flotante\nP=Pasta\nM=Metálica',
  `color_montura` VARCHAR(20) NOT NULL,
  `color_vidrio` VARCHAR(20) NOT NULL,
  `precio` DECIMAL(9,2) NOT NULL,
  `marca_id` INT(11) NOT NULL,
  PRIMARY KEY (`gafas_id`),
  INDEX `fk_gafas_marca1_idx` (`marca_id` ASC) VISIBLE,
  CONSTRAINT `fk_gafas_marca1`
    FOREIGN KEY (`marca_id`)
    REFERENCES `Optica`.`marca` (`marca_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Optica`.`clientes` (
  `clientes_id` INT(11) NOT NULL AUTO_INCREMENT,
  `cliente_nombre` VARCHAR(45) NOT NULL,
  `cliente_apellido` VARCHAR(45) NOT NULL,
  `cliente_cod_postal` VARCHAR(10) NULL DEFAULT NULL,
  `cliente_telefono` VARCHAR(30) NULL DEFAULT NULL,
  `cliente_email` VARCHAR(45) NULL DEFAULT NULL,
  `fecha_registro` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `recomendado_por-->cliente_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`clientes_id`),
  UNIQUE INDEX `cliente_email_UNIQUE` (`cliente_email` ASC) VISIBLE,
  UNIQUE INDEX `cliente_telefono_UNIQUE` (`cliente_telefono` ASC) VISIBLE,
  INDEX `fk_clientes_clientes_idx` (`recomendado_por-->cliente_id` ASC) VISIBLE,
  CONSTRAINT `fk_clientes_clientes`
    FOREIGN KEY (`recomendado_por-->cliente_id`)
    REFERENCES `Optica`.`clientes` (`clientes_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Optica`.`empleados` (
  `empleado_id` INT(11) NOT NULL AUTO_INCREMENT,
  `empleado_nombre` VARCHAR(45) NOT NULL,
  `empleado_apellido` VARCHAR(45) NOT NULL,
  `empleado_dni` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`empleado_id`),
  UNIQUE INDEX `empleado_dni_UNIQUE` (`empleado_dni` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Optica`.`facturas` (
  `facturas_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL DEFAULT (CURDATE()),
  `clientes_id` INT(11) NOT NULL,
  `empleado_id` INT(11) NOT NULL,
  `total_importe` DECIMAL(9,2) NULL DEFAULT NULL,
  PRIMARY KEY (`facturas_id`),
  INDEX `fk_facturas_clientes1_idx` (`clientes_id` ASC) VISIBLE,
  INDEX `fk_facturas_empleados1_idx` (`empleado_id` ASC) VISIBLE,
  CONSTRAINT `fk_facturas_clientes1`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `Optica`.`clientes` (`clientes_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_empleados1`
    FOREIGN KEY (`empleado_id`)
    REFERENCES `Optica`.`empleados` (`empleado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Optica`.`marca` (
  `marca_id` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `proveedor_id` INT(11) NOT NULL,
  PRIMARY KEY (`marca_id`),
  INDEX `fk_marca_proveedores1_idx` (`proveedor_id` ASC) VISIBLE,
  CONSTRAINT `fk_marca_proveedores1`
    FOREIGN KEY (`proveedor_id`)
    REFERENCES `Optica`.`proveedores` (`proveedor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `Optica`.`detalle_factura` (
  `facturas_id` INT(11) NOT NULL,
  `gafas_id` INT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  PRIMARY KEY (`facturas_id`, `gafas_id`),
  INDEX `fk_facturas_has_gafas_gafas1_idx` (`gafas_id` ASC) VISIBLE,
  INDEX `fk_facturas_has_gafas_facturas1_idx` (`facturas_id` ASC) VISIBLE,
  CONSTRAINT `fk_facturas_has_gafas_facturas1`
    FOREIGN KEY (`facturas_id`)
    REFERENCES `Optica`.`facturas` (`facturas_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_has_gafas_gafas1`
    FOREIGN KEY (`gafas_id`)
    REFERENCES `Optica`.`gafas` (`gafas_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
