-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: bookaplication
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booksaler`
--

DROP TABLE IF EXISTS `booksaler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booksaler` (
  `salerId` bigint NOT NULL,
  `salerName` varchar(100) NOT NULL,
  `salerPassword` varchar(50) NOT NULL,
  PRIMARY KEY (`salerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booksaler`
--

LOCK TABLES `booksaler` WRITE;
/*!40000 ALTER TABLE `booksaler` DISABLE KEYS */;
INSERT INTO `booksaler` VALUES (11,'Ram','112'),(12,'Priya','122');
/*!40000 ALTER TABLE `booksaler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booktype`
--

DROP TABLE IF EXISTS `booktype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booktype` (
  `bookId` bigint NOT NULL,
  `booknm` varchar(100) NOT NULL,
  `bookauther` varchar(100) NOT NULL,
  `bookdesc` varchar(100) NOT NULL,
  `bookprice` double NOT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booktype`
--

LOCK TABLES `booktype` WRITE;
/*!40000 ALTER TABLE `booktype` DISABLE KEYS */;
INSERT INTO `booktype` VALUES (1,'ABC','XYZ','abagga',1200),(2,'PQR','JKL','mndue',2300),(3,'Cprogramming','abc','nmkjdhgters',8900),(4,'Success','Abc','Successja',9088);
/*!40000 ALTER TABLE `booktype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `custId` bigint NOT NULL,
  `custName` varchar(100) NOT NULL,
  `custPassword` varchar(50) NOT NULL,
  `custAddress` varchar(100) NOT NULL,
  `phone` bigint NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`custId`,`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Kajal','Jalagaon','001',9098954213,'kajal@gmail.com'),(101,'Tina','101','Sangali',8907653421,'tina@gmail.com'),(102,'Rina','102','Jalgaon',7763890122,'rina@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saledetaile`
--

DROP TABLE IF EXISTS `saledetaile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `saledetaile` (
  `SaleDetId` bigint NOT NULL,
  `bookId` bigint NOT NULL,
  `custId` bigint NOT NULL,
  `bookPrice` double NOT NULL,
  PRIMARY KEY (`SaleDetId`),
  KEY `bookId` (`bookId`),
  CONSTRAINT `saledetaile_ibfk_1` FOREIGN KEY (`bookId`) REFERENCES `booktype` (`bookId`),
  CONSTRAINT `saledetaile_ibfk_2` FOREIGN KEY (`bookId`) REFERENCES `booktype` (`bookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saledetaile`
--

LOCK TABLES `saledetaile` WRITE;
/*!40000 ALTER TABLE `saledetaile` DISABLE KEYS */;
INSERT INTO `saledetaile` VALUES (1,2,102,1200);
/*!40000 ALTER TABLE `saledetaile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-02 15:27:55
