CREATE SCHEMA IF NOT EXISTS `bdproyectop3120222` DEFAULT CHARACTER SET utf8 ;
USE `bdproyectop3120222` ;

CREATE TABLE IF NOT EXISTS usuario (
	id_usuario INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(45) NOT NULL,
	password  VARCHAR(25) NOT NULL,
	PRIMARY KEY (id_usuario) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_aplicacion (
	aplid int NOT NULL AUTO_INCREMENT,
	aplnombre VARCHAR(50),
	aplestatus VARCHAR(50),
	PRIMARY KEY (aplid)
) ENGINE=InnoDB CHARACTER SET = latin1;    


 CREATE TABLE IF NOT EXISTS tbl_aplicacionPerfil(
	aplid INT NOT NULL,
    perid INT NOT NULL,
    PRIMARY KEY(aplid, perid),
    FOREIGN KEY (aplid) REFERENCES tbl_aplicacion (aplid),     
    FOREIGN KEY (perid) REFERENCES tbl_perfil (perid)
 ) ENGINE=InnoDB CHARACTER SET = latin1;     

