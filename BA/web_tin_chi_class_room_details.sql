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
-- Table structure for table `class_room_details`
--

DROP TABLE IF EXISTS `class_room_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_room_details` (
  `details_id` bigint NOT NULL,
  `class_room_id` bigint NOT NULL,
  PRIMARY KEY (`class_room_id`,`details_id`),
  KEY `fk_class_room_details_details_id` (`details_id`),
  CONSTRAINT `fk_class_room_details_class_room_id` FOREIGN KEY (`class_room_id`) REFERENCES `class_room` (`id`),
  CONSTRAINT `fk_class_room_details_details_id` FOREIGN KEY (`details_id`) REFERENCES `details` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_room_details`
--

LOCK TABLES `class_room_details` WRITE;
/*!40000 ALTER TABLE `class_room_details` DISABLE KEYS */;
INSERT INTO `class_room_details` VALUES (11,12),(12,12),(13,13),(14,13),(15,14),(16,14),(17,15),(18,15),(19,16),(20,16),(21,17),(22,17),(23,18),(24,18),(25,19),(26,19),(27,20),(28,20),(29,21),(30,21),(31,22),(32,22),(33,23),(34,23),(35,24),(36,24),(37,25),(37,26),(38,25),(38,26),(39,27),(40,27),(41,28),(42,28),(43,29),(44,29),(45,30),(46,30),(47,31),(48,31),(49,32),(50,32);
/*!40000 ALTER TABLE `class_room_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-26 18:50:37
