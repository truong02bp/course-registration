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
-- Table structure for table `class_room`
--

DROP TABLE IF EXISTS `class_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_room` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nhm` int NOT NULL,
  `tth` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `slot` int DEFAULT NULL,
  `subject_id` bigint NOT NULL,
  `created_by` varchar(50) NOT NULL DEFAULT 'system',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_class_room_subject_id` (`subject_id`),
  CONSTRAINT `fk_class_room_subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_room`
--

LOCK TABLES `class_room` WRITE;
/*!40000 ALTER TABLE `class_room` DISABLE KEYS */;
INSERT INTO `class_room` VALUES (12,1,NULL,37,37,11,'admin','2020-09-25 20:32:08','admin','2020-09-25 20:32:08'),(13,2,NULL,37,37,11,'admin','2020-09-25 20:32:51','admin','2020-09-25 20:32:51'),(14,3,NULL,37,37,11,'admin','2020-09-25 20:33:37','admin','2020-09-25 20:33:37'),(15,4,NULL,37,37,11,'admin','2020-09-25 21:07:02','admin','2020-09-25 21:07:02'),(16,5,NULL,37,37,11,'admin','2020-09-25 21:07:12','admin','2020-09-25 21:07:12'),(17,6,NULL,37,37,11,'admin','2020-09-25 21:16:02','admin','2020-09-25 21:16:02'),(18,7,NULL,37,37,11,'admin','2020-09-25 21:16:23','admin','2020-09-25 21:16:23'),(19,8,NULL,37,37,11,'admin','2020-09-25 21:16:39','admin','2020-09-25 21:16:39'),(20,9,NULL,37,37,11,'admin','2020-09-25 21:16:54','admin','2020-09-25 21:16:54'),(21,10,NULL,37,37,11,'admin','2020-09-25 21:17:08','admin','2020-09-25 21:17:08'),(22,1,NULL,35,35,12,'admin','2020-09-26 04:40:50','admin','2020-09-26 04:40:50'),(23,2,NULL,35,35,12,'admin','2020-09-26 04:41:01','admin','2020-09-26 04:41:01'),(24,3,NULL,35,35,12,'admin','2020-09-26 04:41:10','admin','2020-09-26 04:42:57'),(25,4,NULL,35,35,12,'admin','2020-09-26 04:41:18','admin','2020-09-26 04:42:46'),(26,5,NULL,35,35,12,'admin','2020-09-26 04:41:28','admin','2020-09-26 04:41:28'),(27,5,NULL,35,35,12,'admin','2020-09-26 04:41:39','admin','2020-09-26 04:41:39'),(28,6,NULL,35,35,12,'admin','2020-09-26 04:41:50','admin','2020-09-26 04:41:50'),(29,7,NULL,35,35,12,'admin','2020-09-26 04:42:00','admin','2020-09-26 04:42:00'),(30,8,NULL,35,35,12,'admin','2020-09-26 04:42:09','admin','2020-09-26 04:42:09'),(31,9,NULL,35,35,12,'admin','2020-09-26 04:42:21','admin','2020-09-26 04:42:21'),(32,10,NULL,35,35,12,'admin','2020-09-26 04:42:31','admin','2020-09-26 04:42:31');
/*!40000 ALTER TABLE `class_room` ENABLE KEYS */;
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
