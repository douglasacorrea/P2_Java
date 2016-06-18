//** O banco usado foi o MYSQL */

-- Copiando estrutura do banco de dados para p2java
DROP DATABASE IF EXISTS `p2java`;
CREATE DATABASE IF NOT EXISTS `p2java` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `p2java`;


-- Copiando estrutura para tabela p2java.reserva
CREATE TABLE IF NOT EXISTS `reserva` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STARTDATE` date NOT NULL,
  `ENDDATE` date NOT NULL,
  `CARRO` varchar(50) NOT NULL,
  `NOMEMOTORISTA` varchar(50) NOT NULL,
  `IDUSUARIO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela p2java.reserva: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;


-- Copiando estrutura para tabela p2java.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `Login` varchar(25) NOT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Password` varchar(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
