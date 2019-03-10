    CREATE TABLE `dolar` (
      `id` bigint(20) NOT NULL AUTO_INCREMENT,
      `activo` tinyint(1) DEFAULT '1',
      `compra` double NOT NULL,
      `fecha_guardado` datetime DEFAULT NULL,
      `fecha_ultima_actualizacion` datetime DEFAULT NULL,
      `venta` double NOT NULL,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB;

          CREATE TABLE `euro` (
        `id` bigint(20) NOT NULL AUTO_INCREMENT,
        `compra` double DEFAULT NULL,
        `fecha_guardado` datetime DEFAULT NULL,
        `fecha_ultima_actualizacion` datetime DEFAULT NULL,
        `venta` double DEFAULT NULL,
        `activo` bit(1) DEFAULT NULL,
        PRIMARY KEY (`id`)
      ) ENGINE=InnoDB;

CREATE TABLE `banco_euro` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `nombre` varchar(20) DEFAULT NULL,
    `compra` double DEFAULT NULL,
    `venta` double DEFAULT NULL,
    `fk_euro` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_euro` (`fk_euro`),
    CONSTRAINT `banco_euro_ibfk_1` FOREIGN KEY (`fk_euro`) REFERENCES `euro` (`id`)
  ) ENGINE=InnoDB;

CREATE TABLE `banco_dolar` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `nombre` varchar(20) DEFAULT NULL,
    `compra` double DEFAULT NULL,
    `venta` double DEFAULT NULL,
    `fk_dolar` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_dolar` (`fk_dolar`),
    CONSTRAINT `banco_dolar_ibfk_1` FOREIGN KEY (`fk_dolar`) REFERENCES `dolar` (`id`)
  ) ENGINE=InnoDB;


