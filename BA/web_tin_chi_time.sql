-- MySQL dump 10.13  Distrib 8.0.21, for Linux (x86_64)
--
-- Host: localhost    Database: web_tin_chi
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `lesson` int DEFAULT NULL,
  `day` varchar(255) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL DEFAULT 'system',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` VALUES (11,'T2-1',1,'Hai','admin','2020-09-25 19:46:55','admin','2020-09-25 19:46:55'),(12,'T2-3',3,'Hai','admin','2020-09-25 19:47:13','admin','2020-09-25 19:47:13'),(13,'T2-5',5,'Hai','admin','2020-09-25 19:47:49','admin','2020-09-25 19:47:49'),(14,'T2-7',7,'Hai','admin','2020-09-25 19:47:59','admin','2020-09-25 19:47:59'),(15,'T2-9',9,'Hai','admin','2020-09-25 19:48:15','admin','2020-09-25 19:48:15'),(16,'T2-11',11,'Hai','admin','2020-09-25 19:48:31','admin','2020-09-25 19:48:31'),(17,'T3-1',1,'Ba','admin','2020-09-25 19:49:07','admin','2020-09-25 19:49:07'),(18,'T3-3',3,'Ba','admin','2020-09-25 19:49:19','admin','2020-09-25 19:49:19'),(19,'T3-5',5,'Ba','admin','2020-09-25 19:49:29','admin','2020-09-25 19:49:29'),(20,'T3-7',7,'Ba','admin','2020-09-25 19:49:40','admin','2020-09-25 19:49:40'),(21,'T3-9',9,'Ba','admin','2020-09-25 19:49:50','admin','2020-09-25 19:49:50'),(22,'T3-11',11,'Ba','admin','2020-09-25 19:50:01','admin','2020-09-25 19:50:01'),(23,'TƯ-1',1,'Tư','admin','2020-09-25 19:50:18','admin','2020-09-25 19:50:18'),(24,'TƯ-3',3,'Tư','admin','2020-09-25 19:50:34','admin','2020-09-25 19:50:34'),(25,'TƯ-5',5,'Tư','admin','2020-09-25 19:50:47','admin','2020-09-25 19:50:47'),(26,'TƯ-7',7,'Tư','admin','2020-09-25 19:50:58','admin','2020-09-25 19:50:58'),(27,'TƯ-9',9,'Tư','admin','2020-09-25 19:51:14','admin','2020-09-25 19:51:14'),(28,'TƯ-11',11,'Tư','admin','2020-09-25 19:51:24','admin','2020-09-25 19:51:24'),(29,'NĂM-1',1,'Năm','admin','2020-09-25 19:51:35','admin','2020-09-25 19:51:35'),(30,'NĂM-3',3,'Năm','admin','2020-09-25 19:51:50','admin','2020-09-25 19:51:50'),(31,'NĂM-5',5,'Năm','admin','2020-09-25 19:52:02','admin','2020-09-25 19:52:02'),(32,'NĂM-7',7,'Năm','admin','2020-09-25 19:52:17','admin','2020-09-25 19:52:17'),(33,'NĂM-9',9,'Năm','admin','2020-09-25 19:52:48','admin','2020-09-25 19:52:48'),(34,'NĂM-11',11,'Năm','admin','2020-09-25 19:53:04','admin','2020-09-25 19:53:04'),(35,'SÁU-1',1,'Sáu','admin','2020-09-25 19:53:22','admin','2020-09-25 19:53:22'),(36,'SÁU-3',3,'Sáu','admin','2020-09-25 19:53:35','admin','2020-09-25 19:53:35'),(37,'SÁU-5',5,'Sáu','admin','2020-09-25 19:53:49','admin','2020-09-25 19:53:49'),(38,'SÁU-7',7,'Sáu','admin','2020-09-25 19:54:01','admin','2020-09-25 19:54:01'),(39,'SÁU-9',9,'Sáu','admin','2020-09-25 19:54:13','admin','2020-09-25 19:54:13'),(40,'SÁU-11',11,'Sáu','admin','2020-09-25 19:54:29','admin','2020-09-25 19:54:29');
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-26 18:50:38
