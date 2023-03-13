-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: appdb
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `details` varchar(100) DEFAULT NULL,
  `tag` varchar(20) DEFAULT NULL,
  `thumbnail` varchar(45) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'XPG XENIA 15',999,'Intel i7 9750H, GTX 1660 Ti, 512GB, 16GB','laptop','laptop1.webp',4,'2022-12-31 23:59:59'),(2,'MSI Crosshair 15',959,'Intel i7 11800H, RTX 3050, 512GB SSD, 16GB','laptop','laptop2.webp',4,'2022-12-31 23:59:59'),(3,'MSI Prestige Evo',899,'Intel I7-1185G7, 512GB SSD, 16GB, Webcam Warrenty','laptop','laptop3.webp',5,'2022-12-31 23:59:59'),(4,'S Galaxy S10 +',289,'Factory Unlocked, Face Unlock, Shipping','phone','phone-1.png',3,'2022-12-31 23:59:59'),(5,'Apple iPhone 11 ',309,'64GB, Factory Unlocked, Good Condition','phone','phone-2.png',5,'2022-12-31 23:59:59'),(6,'New Balance Men\'s',64,'Men\'s Shoes, White With Navi, Good Condition','shoe','shoe-1.png',5,'2022-12-31 23:59:59'),(7,'Apple iPad 10.2',369,'64GB, Retina Display, Silver, Stylus','tablet','tablet-1.png',5,'2022-12-31 23:59:59');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-26  4:52:54
