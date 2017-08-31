-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: hearth
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `kingdoms`
--

DROP TABLE IF EXISTS `kingdoms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kingdoms` (
  `kingdomid` int(11) NOT NULL AUTO_INCREMENT,
  `playerid` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `gold` int(11) DEFAULT '20',
  `land` int(11) DEFAULT '10',
  `housing` int(11) DEFAULT '10',
  `pop` int(11) DEFAULT NULL,
  `civs` int(11) DEFAULT NULL,
  `soldiers` int(11) DEFAULT '10',
  `upkeep` int(11) DEFAULT NULL,
  `troopcap` int(11) DEFAULT NULL,
  `infantry` int(11) DEFAULT NULL,
  `archers` int(11) DEFAULT NULL,
  `cavalry` int(11) DEFAULT NULL,
  `goods` int(11) DEFAULT NULL,
  `marketrate` decimal(5,5) DEFAULT '0.50000',
  `civincome` int(11) DEFAULT NULL,
  `taxrate` decimal(5,5) DEFAULT '0.40000',
  `dailyprofit` int(11) DEFAULT NULL,
  PRIMARY KEY (`kingdomid`),
  UNIQUE KEY `kingdomid_UNIQUE` (`kingdomid`),
  UNIQUE KEY `playerid_UNIQUE` (`playerid`),
  CONSTRAINT `playerid` FOREIGN KEY (`playerid`) REFERENCES `players` (`playerid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kingdoms`
--

LOCK TABLES `kingdoms` WRITE;
/*!40000 ALTER TABLE `kingdoms` DISABLE KEYS */;
INSERT INTO `kingdoms` VALUES (4,1,'test3',530,10,10,100,90,10,10,10,10,0,0,900,0.50000,450,0.40000,180),(5,2,'test for player 2',530,10,10,100,90,10,10,10,10,0,0,900,0.50000,450,0.40000,180);
/*!40000 ALTER TABLE `kingdoms` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-31 18:06:05
