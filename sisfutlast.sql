CREATE DATABASE  IF NOT EXISTS `sisfut` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sisfut`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sisfut
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `arbitro`
--

DROP TABLE IF EXISTS `arbitro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `arbitro` (
  `idArb` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idArb`),
  KEY `cf_arb_user` (`idUser`),
  CONSTRAINT `cf_arb_user` FOREIGN KEY (`idUser`) REFERENCES `usuarios` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `arbitro`
--

LOCK TABLES `arbitro` WRITE;
/*!40000 ALTER TABLE `arbitro` DISABLE KEYS */;
INSERT INTO `arbitro` VALUES (2,11),(3,18),(4,19);
/*!40000 ALTER TABLE `arbitro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compite`
--

DROP TABLE IF EXISTS `compite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compite` (
  `idTor` int(11) NOT NULL,
  `idEq` int(11) NOT NULL,
  `puntos` int(11) DEFAULT '0',
  KEY `cf_compite_tor` (`idTor`),
  KEY `cf_compite_eq` (`idEq`),
  CONSTRAINT `cf_compite_eq` FOREIGN KEY (`idEq`) REFERENCES `equipo` (`idEq`),
  CONSTRAINT `cf_compite_tor` FOREIGN KEY (`idTor`) REFERENCES `torneo` (`idTor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compite`
--

LOCK TABLES `compite` WRITE;
/*!40000 ALTER TABLE `compite` DISABLE KEYS */;
INSERT INTO `compite` VALUES (6,9,0),(6,8,0),(6,7,0),(6,6,0),(6,5,0),(6,4,0),(6,3,0),(6,2,0),(6,1,0),(6,11,0),(7,12,0),(7,11,0),(7,10,0),(7,9,0),(7,8,0),(7,7,0),(7,6,0),(7,5,0),(7,4,0),(7,3,0),(14,1,1),(14,17,1),(14,16,1),(14,15,1),(14,12,1),(14,11,1),(14,10,2),(14,8,1),(14,7,2),(14,6,1);
/*!40000 ALTER TABLE `compite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrenador`
--

DROP TABLE IF EXISTS `entrenador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrenador` (
  `idEnt` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idEnt`),
  KEY `cf_ent_user` (`idUser`),
  CONSTRAINT `cf_ent_user` FOREIGN KEY (`idUser`) REFERENCES `usuarios` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenador`
--

LOCK TABLES `entrenador` WRITE;
/*!40000 ALTER TABLE `entrenador` DISABLE KEYS */;
INSERT INTO `entrenador` VALUES (3,10),(4,12),(5,15),(6,16),(7,17);
/*!40000 ALTER TABLE `entrenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipo` (
  `idEq` int(11) NOT NULL AUTO_INCREMENT,
  `idEnt` int(11) NOT NULL,
  `eqEmail` varchar(50) NOT NULL,
  `eqDir` varchar(255) NOT NULL,
  `eqNumTar` varchar(15) NOT NULL,
  `eqFechaIns` datetime NOT NULL,
  `eqTel` varchar(15) NOT NULL,
  `eqColor` varchar(30) NOT NULL,
  `eqDel` int(11) NOT NULL,
  `eqNombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idEq`),
  KEY `cf_eq_ent` (`idEnt`),
  CONSTRAINT `cf_eq_ent` FOREIGN KEY (`idEnt`) REFERENCES `entrenador` (`idEnt`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (1,3,'aguila@gmail.com','calle la lambada 15','123456','2017-06-07 22:57:38','2229-4354','verde/azul',1,'Aguila'),(2,3,'mantarraya@gmail.com','calle la esfera 15','123456','2017-06-07 23:14:22','(+503)2227-7777','blanco/negro',1,'Mantarraya'),(3,3,'naranja@gmail.com','calle la naranja 15','123456','2017-06-07 23:17:36','2227-7777','azul/amarillo',1,'naranja'),(4,4,'pelota@gmail.com','calle la pelota 15','123456','2017-06-07 23:18:50','2227-7777','azul/amarillo',0,'pelota'),(5,3,'sandia@gmail.com','calle la sandia 15','123456','2017-06-07 23:19:23','2227-7777','azul/amarillo',1,'sandia'),(6,3,'toronja@gmail.com','calle la toronja 15','123456','2017-06-07 23:20:17','(+503)2227-7777','azul/amarillo',1,'Toronja'),(7,3,'zanahoria@gmail.com','calle la zanahoria 15','123456','2017-06-07 23:20:55','(+503)2227-7777','azul/amarillo',1,'Zanahoria'),(8,3,'tiburon@gmail.com','calle la tiburon 15','123456','2017-06-07 23:21:35','2227-7777','azul/amarillo',1,'tiburon'),(9,3,'furies@gmail.com','calle la furies 15','123456','2017-06-07 23:22:10','2227-7777','azul/amarillo',0,'furies'),(10,3,'ferrari@gmail.com','calle la ferrari 15','123456','2017-06-07 23:23:05','2227-7777','azul/amarillo',1,'ferrari'),(11,4,'Arsenal@gmail.com','calle la Arsenal 15','123777','2017-06-09 17:28:10','2227-7744','negro',1,'Arsenal'),(12,4,'selecta@gmail.com','calle la selecta 15','123777','2017-06-09 18:13:43','2227-7744','azul y blanco',1,'SelectaxD'),(13,4,'ok@gmail.com','santa tecla','123456','2017-06-11 18:33:35','(+503)2222-2222','rojo',0,'ok'),(14,7,'cr@gmail.com','san salvador','123456','2017-06-11 20:19:07','(+503)    -    ','black',0,'Crooked'),(15,5,'leones@gmail.com','santa ana','123456','2017-06-11 21:49:53','(+503)2222-2222','cafe',1,'leones'),(16,6,'cond@gmail.com','La Union','123456','2017-06-11 22:14:21','(+503)    -    ','Cafe',1,'Condores'),(17,4,'tigres@gmail.com','Soyapango','123456','2017-06-11 22:21:46','(+503)    -    ','amarillo',1,'Tigres');
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gol`
--

DROP TABLE IF EXISTS `gol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gol` (
  `idGol` int(11) NOT NULL AUTO_INCREMENT,
  `idInc` int(11) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  PRIMARY KEY (`idGol`),
  KEY `cf_inc_gol` (`idInc`),
  CONSTRAINT `cf_inc_gol` FOREIGN KEY (`idInc`) REFERENCES `incidencia` (`idInc`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gol`
--

LOCK TABLES `gol` WRITE;
/*!40000 ALTER TABLE `gol` DISABLE KEYS */;
INSERT INTO `gol` VALUES (35,64,'Gol de penalti'),(36,65,'Gol libre directo'),(37,66,'Gol de penalti'),(38,67,'Gol de penalti');
/*!40000 ALTER TABLE `gol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidencia`
--

DROP TABLE IF EXISTS `incidencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `incidencia` (
  `idInc` int(11) NOT NULL AUTO_INCREMENT,
  `idPart` int(11) NOT NULL,
  `idJug` int(11) NOT NULL,
  `minuto` varchar(20) NOT NULL,
  `tiempo` varchar(30) NOT NULL,
  `Eq` varchar(10) NOT NULL,
  PRIMARY KEY (`idInc`),
  KEY `cf_part` (`idPart`),
  KEY `cf_jug` (`idJug`),
  CONSTRAINT `cf_jug` FOREIGN KEY (`idJug`) REFERENCES `jugador` (`idJug`),
  CONSTRAINT `cf_part` FOREIGN KEY (`idPart`) REFERENCES `partido` (`idPart`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidencia`
--

LOCK TABLES `incidencia` WRITE;
/*!40000 ALTER TABLE `incidencia` DISABLE KEYS */;
INSERT INTO `incidencia` VALUES (64,91,4,'33:45','Primer tiempo','l'),(65,91,4,'15:15','Segundo Tiempo','l'),(66,92,13,'33:45','Primer tiempo','l'),(67,96,4,'15:03','Primer tiempo','v');
/*!40000 ALTER TABLE `incidencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `juega`
--

DROP TABLE IF EXISTS `juega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `juega` (
  `idPart` int(11) NOT NULL,
  `idJug` int(11) NOT NULL,
  PRIMARY KEY (`idPart`,`idJug`),
  KEY `cf_juega_jug` (`idJug`),
  CONSTRAINT `cf_juega_jug` FOREIGN KEY (`idJug`) REFERENCES `jugador` (`idJug`),
  CONSTRAINT `cf_juega_part` FOREIGN KEY (`idPart`) REFERENCES `partido` (`idPart`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `juega`
--

LOCK TABLES `juega` WRITE;
/*!40000 ALTER TABLE `juega` DISABLE KEYS */;
/*!40000 ALTER TABLE `juega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugador`
--

DROP TABLE IF EXISTS `jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jugador` (
  `idJug` int(11) NOT NULL AUTO_INCREMENT,
  `idEq` int(11) NOT NULL,
  `jugNom` varchar(100) NOT NULL,
  `jugDui` varchar(15) NOT NULL,
  `jugPos` varchar(15) NOT NULL,
  `jugFnac` date NOT NULL,
  `jugEmail` varchar(50) NOT NULL,
  `jugNumTar` varchar(15) NOT NULL,
  `jugNum` int(11) NOT NULL,
  `jugTel` varchar(15) NOT NULL,
  `jugDel` int(11) NOT NULL,
  PRIMARY KEY (`idJug`),
  KEY `cf_jug_eq` (`idEq`),
  CONSTRAINT `cf_jug_eq` FOREIGN KEY (`idEq`) REFERENCES `equipo` (`idEq`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador`
--

LOCK TABLES `jugador` WRITE;
/*!40000 ALTER TABLE `jugador` DISABLE KEYS */;
INSERT INTO `jugador` VALUES (1,1,'Samuel Martinez','12345678-9','Defensa','1991-11-25','samy@gmail.com','123456',12,'2229-0156',1),(2,1,'Elias Fernandez','98765432-1','Delantero','1992-11-14','Elias@gmail.com','123456',45,'2229-0157',0),(3,1,'Matias Quintanilla','98765432-1','Portero','1992-11-14','Elias@gmail.com','123456',11,'2229-0157',0),(4,10,'Jose Perez','98765432-1','Delantero','1992-11-14','Elias@gmail.com','123456',13,'2229-0157',1),(5,10,'Pedro Herrera','98765432-1','Delantero','1992-11-14','Elias@gmail.com','123456',5,'2229-0157',1),(6,10,'Carlos Lopez','98765432-1','Delantero','1992-11-14','Elias@gmail.com','123456',99,'2229-0157',1),(7,1,'Luis Valdez','12131654-6','Portero','1991-11-25','eduardo@gmail.com','123456',11,'2222-2222',0),(8,2,'San Garcia','13464654-6','Seleccionar','1980-11-15','stan@gmail.com','112316',1,'1213-2415',1),(9,3,'Matias Argueta','13468464-1','Seleccionar','1991-11-25','edu@gmail.com','123465',1,'1324-6543',1),(10,1,'ricky espinosa','16464646-4','Volante','1991-11-25','ricky@gmail.com','166546',11,'1646-5464',1),(11,5,'axel rose','64646464-6','Defensa','1980-11-25','axel@gmail.com','654646',11,'1646-4645',1),(12,6,'ezekiel menjivar','46764646-4','Defensa','1990-11-25','eze@gmail.com','465465',1,'6465-4654',1),(13,7,'len paul','64654654-6','Defensa','1980-12-13','len@gmail.com','465465',1,'6464-6546',1),(14,8,'isaias menjivar','46464654-6','Defensa','1991-12-15','isai@gmail.com','654564',21,'4646-5465',1),(15,15,'jose luis','16465465-4','Volante','1992-12-12','jose@gmail.com','465465',81,'1646-5465',1);
/*!40000 ALTER TABLE `jugador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partido` (
  `idPart` int(11) NOT NULL AUTO_INCREMENT,
  `idTor` int(11) NOT NULL,
  `idArb` int(11) DEFAULT NULL,
  `idEqVis` int(11) NOT NULL,
  `idEqLoc` int(11) NOT NULL,
  `partFecha` date DEFAULT NULL,
  `partHora` time DEFAULT NULL,
  `partFin` time DEFAULT NULL,
  `partGanador` varchar(100) DEFAULT NULL,
  `partScoreLoc` int(11) DEFAULT NULL,
  `partScoreVis` int(11) DEFAULT NULL,
  `partEstado` varchar(30) NOT NULL,
  `partJornada` varchar(50) NOT NULL,
  PRIMARY KEY (`idPart`),
  KEY `cf_tor_part` (`idTor`),
  KEY `cf_eqv_part` (`idEqVis`),
  KEY `cf_eql_part` (`idEqLoc`),
  KEY `cf_arb_part` (`idArb`),
  CONSTRAINT `cf_arb_part` FOREIGN KEY (`idArb`) REFERENCES `arbitro` (`idArb`),
  CONSTRAINT `cf_eql_part` FOREIGN KEY (`idEqLoc`) REFERENCES `equipo` (`idEq`),
  CONSTRAINT `cf_eqv_part` FOREIGN KEY (`idEqVis`) REFERENCES `equipo` (`idEq`),
  CONSTRAINT `cf_tor_part` FOREIGN KEY (`idTor`) REFERENCES `torneo` (`idTor`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
INSERT INTO `partido` VALUES (81,13,3,1,8,'2017-11-26','19:00:00','21:00:00','tiburon',1,0,'Completado','Primera'),(82,13,2,10,6,'2017-11-28','15:00:00','16:45:00','Toronja',1,0,'Completado','Primera'),(83,13,2,7,12,'2017-11-30','19:00:00','21:00:00','Zanahoria',0,1,'Completado','Primera'),(84,13,NULL,3,11,NULL,NULL,NULL,'Por Det',0,0,'Pendiente','Primera'),(85,13,2,5,2,'2017-12-05','17:00:00','19:00:00','Mantarraya',2,0,'Completado','Primera'),(86,13,NULL,8,1,NULL,NULL,NULL,'Por Det',0,0,'Pendiente','Segunda'),(87,13,NULL,6,10,NULL,NULL,NULL,'Por Det',0,0,'Pendiente','Segunda'),(88,13,NULL,12,7,NULL,NULL,NULL,'Por Det',0,0,'Pendiente','Segunda'),(89,13,NULL,11,3,NULL,NULL,NULL,'Por Det',0,0,'Pendiente','Segunda'),(90,13,3,2,5,'2017-11-30','19:00:00','21:00:00','Mantarraya',0,2,'Completado','Primera'),(91,14,2,11,10,'2017-11-26','17:00:00','19:00:00','ferrari',2,0,'Completado','Primera'),(92,14,2,15,7,'2017-11-27','17:00:00','19:00:00','Zanahoria',1,0,'Completado','Primera'),(93,14,NULL,16,17,NULL,NULL,NULL,'Por Det',0,0,'Pendiente','Primera'),(94,14,NULL,8,6,NULL,NULL,NULL,'Por Det',0,0,'Pendiente','Primera'),(95,14,NULL,1,12,NULL,NULL,NULL,'Por Det',0,0,'Pendiente','Primera'),(96,14,2,10,11,'2017-11-30','17:00:00','19:00:00','ferrari',0,1,'Completado','Primera'),(97,14,NULL,7,15,NULL,NULL,NULL,'Por Det',0,0,'Pendiente','Segunda'),(98,14,NULL,17,16,NULL,NULL,NULL,'Por Det',0,0,'Pendiente','Segunda'),(99,14,NULL,6,8,NULL,NULL,NULL,'Por Det',0,0,'Pendiente','Segunda'),(100,14,NULL,12,1,NULL,NULL,NULL,'Por Det',0,0,'Pendiente','Segunda');
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjeta`
--

DROP TABLE IF EXISTS `tarjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tarjeta` (
  `idTar` int(11) NOT NULL AUTO_INCREMENT,
  `idInc` int(11) NOT NULL,
  `color` varchar(30) NOT NULL,
  PRIMARY KEY (`idTar`),
  KEY `cf_inc_tar` (`idInc`),
  CONSTRAINT `cf_inc_tar` FOREIGN KEY (`idInc`) REFERENCES `incidencia` (`idInc`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjeta`
--

LOCK TABLES `tarjeta` WRITE;
/*!40000 ALTER TABLE `tarjeta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tarjeta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiros`
--

DROP TABLE IF EXISTS `tiros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tiros` (
  `idTiro` int(11) NOT NULL AUTO_INCREMENT,
  `idInc` int(11) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  PRIMARY KEY (`idTiro`),
  KEY `cf_inc_tir` (`idInc`),
  CONSTRAINT `cf_inc_tir` FOREIGN KEY (`idInc`) REFERENCES `incidencia` (`idInc`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiros`
--

LOCK TABLES `tiros` WRITE;
/*!40000 ALTER TABLE `tiros` DISABLE KEYS */;
/*!40000 ALTER TABLE `tiros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `torneo`
--

DROP TABLE IF EXISTS `torneo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `torneo` (
  `idTor` int(11) NOT NULL AUTO_INCREMENT,
  `torNom` varchar(50) NOT NULL,
  `torFechIni` date NOT NULL,
  `torFechFin` date NOT NULL,
  `torChamp` varchar(50) DEFAULT NULL,
  `tor2nd` varchar(50) DEFAULT NULL,
  `tor3rd` varchar(50) DEFAULT NULL,
  `torEstado` varchar(30) NOT NULL,
  `torDel` int(11) NOT NULL,
  `tor4th` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idTor`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torneo`
--

LOCK TABLES `torneo` WRITE;
/*!40000 ALTER TABLE `torneo` DISABLE KEYS */;
INSERT INTO `torneo` VALUES (5,'Lions Cup 1','2005-02-15','2006-03-15','Por Det','Por Det','Por Det','Segunda',0,NULL),(6,'Wolrd Tournament','2008-08-15','2009-09-15','Por Det','Por Det','Por Det','Pendiente',0,'Por Det'),(7,'Luis','1991-11-25','1991-11-26','Por Det','Por Det','Por Det','Pendiente',0,NULL),(8,'Tigers Cup 1','2017-06-09','2017-07-09','Por Det','Por Det','Por Det','Segunda',0,'Por Det'),(9,'Chalchuapa cup','2017-11-25','2017-12-25','Por Det','Por Det','Por Det','Segunda',0,NULL),(10,'Santa Ana Cup','2017-06-15','2017-06-30','Por Det','Por Det','Por Det','Primera',0,NULL),(11,'Santa Tecla Cup','2017-11-15','2017-12-15','Por Det','Por Det','Por Det','Segunda',0,'Por Det'),(12,'Leo Cup 1','2017-11-25','2017-12-30','Por Det','Por Det','Por Det','Segunda',0,NULL),(13,'Santa Ana cup','2017-11-25','2017-12-25','Por Det','Por Det','Por Det','Segunda',0,NULL),(14,'Santa Ana Cup','2017-11-25','2017-12-25','Por Det','Por Det','Por Det','Segunda',1,NULL);
/*!40000 ALTER TABLE `torneo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `userNombre` varchar(50) NOT NULL,
  `userApellido` varchar(50) NOT NULL,
  `userName` varchar(30) NOT NULL,
  `userPass` varchar(50) NOT NULL,
  `userDui` varchar(15) NOT NULL,
  `userTel` varchar(15) NOT NULL,
  `userEmail` varchar(50) NOT NULL,
  `userLevel` varchar(50) NOT NULL,
  `userFnac` date NOT NULL,
  `userFechaIns` datetime NOT NULL,
  `userDel` int(11) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Luis','Valdez','legion','123','12345678-9','2222-2222','eduardoc1112@gmail.com','Administrador','1991-11-25','2017-05-31 20:17:03',1),(2,'Juan','Karlos','juan','11111111','11111111-1','2222-2222','juan@gmail.com','Administrador','1985-11-14','2017-05-31 20:41:36',1),(3,'Maria','López','maria','11111111','12345678-9','2222-2222','maria@gmail.com','Regular','1997-08-15','2017-06-01 09:12:52',1),(4,'Tania','Argueta','tania','11111111','11111111-1','1111-1111','tania@gmail.com','Regular','1995-11-18','2017-06-01 09:15:07',1),(5,'Elias','Antonela','Elias','11111111','11111111-1','1111-1111','papa@gmail.com','Regular','1970-12-25','2017-06-01 10:06:41',0),(10,'Marcelo','Garcia','marcelo','11111111','12345678-9','2222-2222','m_garcia@gmail.com','Entrenador','1995-11-05','2017-06-06 19:01:05',1),(11,'Tony','Ferguson','tony','11111111','12345678-9','1234-5647','tony_ferg@gmail.com','Arbitro','1985-11-23','2017-06-06 19:02:20',1),(12,'Rodrigo','Lopez','Rodrigo','55555555','12345678-9','2222-2222','ro_lo@gmail.com','Entrenador','1993-12-25','2017-06-06 19:12:25',1),(13,'pacaya','papaya','pacayaA','11111111','11111111-1','1111-1111','papa@gmail.com','Regular','1970-12-25','2017-06-06 21:41:26',0),(14,'mario','montes','mario','22222222','11111111-1','2223-4545','mario@gmail.com','Administrador','1991-12-15','2017-06-08 22:00:20',0),(15,'Samuel','Quintanilla','samuel','11111111','12345678-9','7046-8945','samy@gmail.com','Entrenador','1987-02-28','2017-06-09 17:50:04',1),(16,'Manuel','Ferrara','manuel','11111111','12345678-9','7017-9815','manuel@gmail.com','Entrenador','1991-11-25','2017-06-09 19:27:56',1),(17,'Alberto','Cisneros','albert','11111111','10111111-1','2222-2222','alberto@gmail.com','Entrenador','1991-11-25','2017-06-09 19:33:36',1),(18,'Mark','Hunt','mark','11111111','12346546-5','2456-8745','mark@gmail.com','Arbitro','1970-11-03','2017-06-10 19:11:35',1),(19,'Derek','Lewis','lewis','11111111','45465167-6','7046-8951','lewis@gmail.com','Arbitro','1989-05-04','2017-06-10 19:12:12',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-12  0:26:06
