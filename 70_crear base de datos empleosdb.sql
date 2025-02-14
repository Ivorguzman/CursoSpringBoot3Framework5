create database empleosdb;
use empleosdb;

CREATE TABLE `Categorias` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(100) NOT NULL,
    `descripcion` TEXT,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=utf8mb4;


CREATE TABLE Perfiles (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `perfil` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `Usuarios` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(11) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `estatus` INT(11) NOT NULL DEFAULT '1',
    `fechaRegistro` DATE DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `username_UNIQUE` (`username`),
    UNIQUE KEY `email_UNIQUE` (`email`)
)  ENGINE=INNODB DEFAULT CHARSET=utf8mb4;




CREATE TABLE `Vacantes` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(200) NOT NULL,
    `descripcion` TEXT not null,
    `fecha` DATE NOT NULL,
    `salario` DOUBLE NOT NULL,
    `estatus` ENUM('Creada', 'Aprobada', 'Eliminada') NOT NULL,
    `idCategoria` INT(11) NOT NULL,
	`destacado` INT(11) NOT NULL,
	`imagen`  VARCHAR(200) NOT NULL,
	`detalles` TEXT not null,
    PRIMARY KEY (`id`),
    KEY `fk_vacantes_categorias1_idx` (`idCategoria`),
    CONSTRAINT `fk_vacantes_categorias1` FOREIGN KEY (`idCategoria`)
        REFERENCES `categorias` (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=utf8mb4;
     
     
     

CREATE TABLE `Solicitudes` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `fecha` DATE NOT NULL,
    `archivo`varchar(250) not null,
    `comentarios` TEXT,
    `idVacante` INT(11) NOT NULL,
    `idUsuario` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `Vacante_Usuario_UNIQUE` (`idVacante` , `idUsuario`),
    KEY `fk_Solicitudes_Vacantes1_idx` (`idVacante`),
    KEY `fk_Solicitudes_Usuarios1_idx` (`idUsuario`),
    CONSTRAINT `fk_Solicitudes_Usuarios1` FOREIGN KEY (`idUsuario`)
        REFERENCES `Usuarios` (`id`),
    CONSTRAINT `fk_Solicitudes_Vacantes1` FOREIGN KEY (`idVacante`)
        REFERENCES `Vacantes` (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `UsuarioPerfil` (
    `idUsuario` INT(11) NOT NULL,
    `idPerfil` INT(11) NOT NULL,
    UNIQUE KEY `Usuario_Perfil_UNIQUE` (`idUsuario` , `idPerfil`),
    KEY `fk_Usuarios1_idx` (`idUsuario`),
    KEY `fk_Perfiles1_idx` (`idPerfil`),
    CONSTRAINT `fk_Usuarios1` FOREIGN KEY (`idUsuario`)
        REFERENCES `Usuarios` (`id`),
    CONSTRAINT `fk_Perfiles1` FOREIGN KEY (`idPerfil`)
        REFERENCES `Perfiles` (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;