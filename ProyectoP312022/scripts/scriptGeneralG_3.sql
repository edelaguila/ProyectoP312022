USE bdproyectop312022;


CREATE TABLE IF NOT EXISTS tbl_clientes (
  Id_cliente INT NOT NULL AUTO_INCREMENT,
  Nombre VARCHAR(60) NOT NULL,
  Direccion VARCHAR(60) NOT NULL,
  Telefono INT NOT NULL,
  Correo VARCHAR(60) NOT NULL,
  Estado VARCHAR(60) NOT NULL,
  Tipo VARCHAR(60) NOT NULL,
  Id_vendedor INT NOT NULL,
  Id_cobrador INT NOT NULL,
  Id_documento INT NOT NULL,
  PRIMARY KEY (Id_cliente) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_cobradores (
  Id_cobrador INT NOT NULL AUTO_INCREMENT,
  Nombre VARCHAR(60) NOT NULL,
  Direccion VARCHAR(60) NOT NULL,
  Telefono INT NOT NULL,
  Correo VARCHAR(60) NOT NULL,
  Estado VARCHAR(60) NOT NULL,
  Tipo VARCHAR(60) NOT NULL,
  PRIMARY KEY (Id_cobrador) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_tipo_de_documentos (
  Id_documento INT NOT NULL AUTO_INCREMENT,
  Material VARCHAR(60) NOT NULL,
  Tipo VARCHAR(60) NOT NULL,
  Vista VARCHAR(60) NOT NULL,
  Uso VARCHAR(60) NOT NULL,
  PRIMARY KEY (Id_documento) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_vendedores (
  Id_vendedor INT NOT NULL AUTO_INCREMENT,
  Nombre VARCHAR(60) NOT NULL,
  Direccion VARCHAR(60) NOT NULL,
  Telefono INT NOT NULL,
  Correo VARCHAR(60) NOT NULL,
  Estado VARCHAR(60) NOT NULL,
  Tipo VARCHAR(60) NOT NULL,
  PRIMARY KEY (Id_vendedor) )
ENGINE = InnoDB CHARACTER SET = latin1;
