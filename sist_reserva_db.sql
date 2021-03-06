-- MySQL Script generated by MySQL Workbench
-- 10/29/17 17:28:06
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sist_reserva_db
-- -----------------------------------------------------
-- El sistema de reservaciones de vuelos.

-- -----------------------------------------------------
-- Schema sist_reserva_db
--
-- El sistema de reservaciones de vuelos.
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sist_reserva_db` DEFAULT CHARACTER SET utf8 ;
USE `sist_reserva_db` ;

-- -----------------------------------------------------
-- Table `sist_reserva_db`.`Vuelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sist_reserva_db`.`Vuelo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `origen` VARCHAR(45) NOT NULL,
  `destino` VARCHAR(45) NOT NULL,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `capacidad` INT NOT NULL,
  `disponibilidad` INT NOT NULL,
  `jornada` VARCHAR(45) NOT NULL,
  `costo` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sist_reserva_db`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sist_reserva_db`.`Reserva` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cedula` VARCHAR(20) NOT NULL,
  `nombre` VARCHAR(100) NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `fecha_transac` DATETIME NOT NULL,
  `Vuelo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Reserva_Vuelo_idx` (`Vuelo_id` ASC),
  CONSTRAINT `fk_Reserva_Vuelo`
    FOREIGN KEY (`Vuelo_id`)
    REFERENCES `sist_reserva_db`.`Vuelo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
