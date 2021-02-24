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
-- Table structure for table `details`
--

DROP TABLE IF EXISTS `details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `details` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `time_id` bigint NOT NULL,
  `professor_id` bigint NOT NULL,
  `room_id` bigint NOT NULL,
  `created_by` varchar(50) NOT NULL DEFAULT 'system',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_details_time_id` (`time_id`),
  KEY `fk_details_professor_id` (`professor_id`),
  KEY `fk_details_room_id` (`room_id`),
  CONSTRAINT `fk_details_professor_id` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`id`),
  CONSTRAINT `fk_details_room_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  CONSTRAINT `fk_details_time_id` FOREIGN KEY (`time_id`) REFERENCES `time` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `details`
--

LOCK TABLES `details` WRITE;
/*!40000 ALTER TABLE `details` DISABLE KEYS */;
INSERT INTO `details` VALUES (11,'1',26,11,11,'admin','2020-09-25 20:25:00','admin','2020-09-25 20:25:00'),(12,'1',32,12,12,'admin','2020-09-25 20:31:47','admin','2020-09-25 20:31:47'),(13,'2',27,11,11,'admin','2020-09-25 20:32:29','admin','2020-09-25 20:32:29'),(14,'2',33,12,12,'admin','2020-09-25 20:32:40','admin','2020-09-25 20:32:40'),(15,'3',29,13,11,'admin','2020-09-25 20:33:10','admin','2020-09-25 20:33:10'),(16,'3',35,14,12,'admin','2020-09-25 20:33:22','admin','2020-09-25 20:33:22'),(17,'4',30,13,11,'admin','2020-09-25 20:34:11','admin','2020-09-25 20:34:11'),(18,'4',36,14,12,'admin','2020-09-25 20:34:25','admin','2020-09-25 20:34:25'),(19,'5',32,15,11,'admin','2020-09-25 20:34:43','admin','2020-09-25 20:34:43'),(20,'5',38,15,12,'admin','2020-09-25 20:34:52','admin','2020-09-25 20:34:52'),(21,'6',33,15,11,'admin','2020-09-25 21:12:42','admin','2020-09-25 21:12:42'),(22,'6',39,15,12,'admin','2020-09-25 21:12:52','admin','2020-09-25 21:12:52'),(23,'7',11,13,12,'admin','2020-09-25 21:13:07','admin','2020-09-25 21:13:07'),(24,'7',35,13,11,'admin','2020-09-25 21:13:25','admin','2020-09-25 21:13:25'),(25,'8',12,13,12,'admin','2020-09-25 21:13:48','admin','2020-09-25 21:13:48'),(26,'8',36,13,11,'admin','2020-09-25 21:14:02','admin','2020-09-25 21:14:02'),(27,'9',14,13,12,'admin','2020-09-25 21:14:20','admin','2020-09-25 21:14:20'),(28,'9',38,13,11,'admin','2020-09-25 21:14:40','admin','2020-09-25 21:14:40'),(29,'10',39,13,11,'admin','2020-09-25 21:15:06','admin','2020-09-25 21:15:06'),(30,'10',15,13,12,'admin','2020-09-25 21:15:18','admin','2020-09-25 21:15:42'),(31,'b1',11,16,19,'admin','2020-09-26 04:27:57','admin','2020-09-26 04:27:57'),(32,'b1',26,16,17,'admin','2020-09-26 04:28:09','admin','2020-09-26 04:28:09'),(33,'b2',12,16,19,'admin','2020-09-26 04:28:26','admin','2020-09-26 04:28:26'),(34,'b2',32,16,18,'admin','2020-09-26 04:28:41','admin','2020-09-26 04:28:41'),(35,'b3',27,16,17,'admin','2020-09-26 04:28:58','admin','2020-09-26 04:29:07'),(36,'b3',14,16,19,'admin','2020-09-26 04:29:26','admin','2020-09-26 04:29:26'),(37,'b4',33,16,18,'admin','2020-09-26 04:29:44','admin','2020-09-26 04:29:44'),(38,'b4',15,16,19,'admin','2020-09-26 04:30:07','admin','2020-09-26 04:30:07'),(39,'b5',17,18,19,'admin','2020-09-26 04:30:32','admin','2020-09-26 04:30:32'),(40,'b5',29,17,17,'admin','2020-09-26 04:30:47','admin','2020-09-26 04:30:47'),(41,'b6',18,18,19,'admin','2020-09-26 04:31:36','admin','2020-09-26 04:31:36'),(42,'b6',35,16,18,'admin','2020-09-26 04:31:53','admin','2020-09-26 04:31:53'),(43,'b7',20,16,19,'admin','2020-09-26 04:32:16','admin','2020-09-26 04:32:16'),(44,'b7',30,17,17,'admin','2020-09-26 04:32:41','admin','2020-09-26 04:32:41'),(45,'b8',21,16,19,'admin','2020-09-26 04:33:04','admin','2020-09-26 04:33:04'),(46,'b8',36,16,18,'admin','2020-09-26 04:33:22','admin','2020-09-26 04:33:22'),(47,'b9',32,18,17,'admin','2020-09-26 04:33:38','admin','2020-09-26 04:33:38'),(48,'b9',27,19,20,'admin','2020-09-26 04:34:41','admin','2020-09-26 04:34:41'),(49,'b10',26,19,20,'admin','2020-09-26 04:35:07','admin','2020-09-26 04:35:07'),(50,'b10',38,20,18,'admin','2020-09-26 04:35:29','admin','2020-09-26 04:36:02');
/*!40000 ALTER TABLE `details` ENABLE KEYS */;
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
