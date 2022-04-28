CREATE SCHEMA IF NOT EXISTS `inventario` DEFAULT CHARACTER SET latin1 ;
USE `inventario` ;

CREATE TABLE IF NOT EXISTS tbl_proveedores (
	provid INT NOT NULL AUTO_INCREMENT,
	provnombre VARCHAR(60) NOT NULL,
	provstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (provid))
	ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_marcas (
	marid INT NOT NULL AUTO_INCREMENT,
	marnombre VARCHAR(60) NOT NULL,
	marstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (marid))
	ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_lineas (
	linid INT NOT NULL AUTO_INCREMENT,
    marid INT NOT NULL,
	linnombre VARCHAR(60) NOT NULL,
	linstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (linid),
    FOREIGN KEY (marid) references tbl_marcas (marid))
	ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_productos (
	proid INT NOT NULL AUTO_INCREMENT,
    marid INT NOT NULL,
    linid INT NOT NULL,
	pronombre VARCHAR(60) NOT NULL,
    procantidad INT NOT NULL,
    proprecio INT NOT NULL,
	proestatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (proid),
    FOREIGN KEY (marid) references tbl_marcas (marid),
    FOREIGN KEY (linid) references tbl_lineas (linid))
	ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_bodegas (
	bodid INT NOT NULL AUTO_INCREMENT,
    proid INT NOT NULL,
	bodnombre VARCHAR(60) NOT NULL,
    bodubicacion VARCHAR(100) NOT NULL,
    bodingresos DATETIME,
    bodegresos DATETIME,
	bodstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (bodid),
    FOREIGN KEY (proid) references tbl_productos (proid))
    ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_bodegas_existencias (
	exisid INT NOT NULL AUTO_INCREMENT,
    proid INT NOT NULL,
    bodid INT NOT NULL,
    PRIMARY KEY (exisid),
    FOREIGN KEY (proid) references tbl_productos (proid),
    FOREIGN KEY (bodid) references tbl_bodegas (bodid))
	ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_traslados (
	trasid INT NOT NULL AUTO_INCREMENT,
    proid INT NOT NULL,
    bodid INT NOT NULL,
    trascantidad INT NOT NULL,
    trasdireccion VARCHAR(70) NOT NULL,
	trasstatus VARCHAR(1) NOT NULL,
	PRIMARY KEY (trasid),
    FOREIGN KEY (proid) references tbl_productos (proid),
    FOREIGN KEY (bodid) references tbl_bodegas (bodid))
	ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_inventario (
	invid INT NOT NULL AUTO_INCREMENT,
    provid INT NOT NULL,
    marid INT NOT NULL,
    linid INT NOT NULL,
    proid INT NOT NULL,
    bodid INT NOT NULL,
    invstatus VARCHAR(1),
    PRIMARY KEY (invid),
    FOREIGN KEY (provid) references tbl_proveedores (provid),
    FOREIGN KEY (marid) references tbl_marcas (marid),
    FOREIGN KEY (linid) references tbl_lineas (linid),
    FOREIGN KEY (proid) references tbl_productos (proid),
    FOREIGN KEY (bodid) references tbl_bodegas (bodid))
    ENGINE = InnoDB CHARACTER SET = latin1;

