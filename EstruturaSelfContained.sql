-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: siscarnes
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `cod_cli` int(11) NOT NULL AUTO_INCREMENT,
  `nom_cli` longtext,
  `cpf_cli` longtext,
  `tel_cli` longtext,
  `eml_cli` longtext,
  `dta_cad_cli` datetime DEFAULT NULL,
  `lmt_crd` double DEFAULT NULL,
  PRIMARY KEY (`cod_cli`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (13,'Joao Vitor','134.472.216-40','992330906','joaovitor@hotmail.com','2018-11-26 20:56:29',10000),(14,'Tiago','196.417.190-33','2608236291','tiago@hotmail.com','2018-11-26 20:57:24',10000),(15,'Eduardo','527.886.140-12','123456789','eduardo@gmail.com','2018-11-26 20:57:47',100000),(16,'Rafael','644.474.630-24','25896314','rafael@fumec.br','2018-11-26 20:58:08',10000),(17,'Gabriel','291.335.380-00','123659889','gabriel@fumec.br','2018-11-26 20:58:25',10000);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `num_cmp` int(11) NOT NULL AUTO_INCREMENT,
  `id_itm_cmp` int(11) DEFAULT NULL,
  `cod_frn` int(11) DEFAULT NULL,
  `dta_cmp` datetime DEFAULT NULL,
  PRIMARY KEY (`num_cmp`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (5,11,2,'2018-11-24 17:41:24'),(7,13,2,'2018-11-24 17:48:09'),(8,10,2,'2018-11-24 17:49:47'),(9,15,2,'2018-11-24 18:03:40'),(10,14,2,'2018-11-24 18:04:43'),(11,12,2,'2018-11-24 18:04:51'),(12,16,3,'2018-11-26 21:02:10');
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedores`
--

DROP TABLE IF EXISTS `fornecedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedores` (
  `cod_frn` int(11) NOT NULL AUTO_INCREMENT,
  `nom_frn` varchar(45) DEFAULT NULL,
  `tel_frn` varchar(45) DEFAULT NULL,
  `cnpj_frn` varchar(45) DEFAULT NULL,
  `eml_frn` varchar(45) DEFAULT NULL,
  `dta_cad_frn` datetime DEFAULT NULL,
  `nom_cto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_frn`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedores`
--

LOCK TABLES `fornecedores` WRITE;
/*!40000 ALTER TABLE `fornecedores` DISABLE KEYS */;
INSERT INTO `fornecedores` VALUES (1,'Puoal','998877553','18.048.936/0001-58','puoal@siscarnes.com','2018-11-26 20:53:56','Gettings'),(2,'Riuno','132546897','89.180.274/0001-13','riuno@hotmail.com','2018-11-26 20:54:18','Gettings'),(3,'Dulon','928376222','73.780.783/0001-47','dulon@gmail.com','2018-11-26 20:54:35','Gettings'),(4,'Clobu','887765695','54.703.635/0001-84','Clobu@gmail.com','2018-11-26 20:55:04','Gettings');
/*!40000 ALTER TABLE `fornecedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemcompra`
--

DROP TABLE IF EXISTS `itemcompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemcompra` (
  `id_itm_cmp` int(10) NOT NULL AUTO_INCREMENT,
  `cod_prod` int(11) NOT NULL,
  `qnt_cmp` int(11) DEFAULT NULL,
  `vlr_cmp` double DEFAULT NULL,
  `cmp_fnl` char(1) DEFAULT NULL,
  PRIMARY KEY (`id_itm_cmp`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemcompra`
--

LOCK TABLES `itemcompra` WRITE;
/*!40000 ALTER TABLE `itemcompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemcompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemvenda`
--

DROP TABLE IF EXISTS `itemvenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemvenda` (
  `num_vnd` int(11) NOT NULL AUTO_INCREMENT,
  `cod_prod` int(11) DEFAULT NULL,
  `vlr_vnd` double DEFAULT NULL,
  `qnt_vnd` int(11) DEFAULT NULL,
  `vnd_fnl` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`num_vnd`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemvenda`
--

LOCK TABLES `itemvenda` WRITE;
/*!40000 ALTER TABLE `itemvenda` DISABLE KEYS */;
INSERT INTO `itemvenda` VALUES (16,22,1000,10,'S');
/*!40000 ALTER TABLE `itemvenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtos` (
  `cod_prod` int(11) NOT NULL AUTO_INCREMENT,
  `nome_prod` longtext,
  `vlr_unid` float DEFAULT NULL,
  `qnt_estoq` int(11) DEFAULT NULL,
  `qnt_estoq_min` int(11) DEFAULT NULL,
  `data_cad` datetime DEFAULT NULL,
  PRIMARY KEY (`cod_prod`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (22,'Picanha',100,38,20,'2018-11-25 18:38:46'),(23,'Alcatra',300,240,20,'2018-11-25 18:38:58'),(24,'File Mignon',80,170,20,'2018-11-26 20:55:33'),(25,'Patinho',40,90,30,'2018-11-26 20:55:44'),(26,'Maminha',99,1,30,'2018-11-26 20:55:56'),(27,'File de Costela',100,30,20,'2018-11-26 20:56:07');
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` longtext,
  `senha` longtext,
  `nome` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'y038675','1234','Joao');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `num_vnd` int(11) NOT NULL AUTO_INCREMENT,
  `cod_vnd` int(11) DEFAULT NULL,
  `cod_cli` int(11) DEFAULT NULL,
  `dta_vnd` datetime DEFAULT NULL,
  `frm_pgt` int(11) DEFAULT NULL,
  `id_itm_vnd` int(11) DEFAULT NULL,
  PRIMARY KEY (`num_vnd`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (12,10,17,'2018-11-26 21:20:20',2,16);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedores`
--

DROP TABLE IF EXISTS `vendedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendedores` (
  `cod_vnd` int(11) NOT NULL AUTO_INCREMENT,
  `nom_vnd` longtext,
  `tel_vnd` longtext,
  `cpf_vnd` longtext,
  `eml_vnd` longtext,
  `dta_cad_vnd` datetime DEFAULT NULL,
  `mta_mes_vnd` double DEFAULT NULL,
  PRIMARY KEY (`cod_vnd`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedores`
--

LOCK TABLES `vendedores` WRITE;
/*!40000 ALTER TABLE `vendedores` DISABLE KEYS */;
INSERT INTO `vendedores` VALUES (10,'Linzie','123456789','597.031.970-86','linzie@hotmail.com','2018-11-26 20:51:07',50000),(11,'Nixyuloy','98765432','734.400.210-84','nixyuloy@hotmail.com','2018-11-26 20:51:32',50000),(12,'Gashmaor','36985214','820.809.020-40','Gashmaor@hotmail.com','2018-11-26 20:51:50',50000),(13,'Maoril','22367878','233.449.310-40','Maoril@gmail.com','2018-11-26 20:52:09',50000),(14,'Ziedin','996633225','153.935.780-59','ziedin@siscarnes.com','2018-11-26 20:52:58',40000);
/*!40000 ALTER TABLE `vendedores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-26 22:35:26
