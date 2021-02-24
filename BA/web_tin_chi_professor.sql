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
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `major` varchar(255) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL DEFAULT 'system',
  `created_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (11,'N.Đ.T.1','english','admin','2020-09-25 19:55:54','admin','2020-09-25 19:55:54'),(12,'B.S.Thắng','english','admin','2020-09-25 19:56:02','admin','2020-09-25 19:56:02'),(13,'P.T.N.Thư','english','admin','2020-09-25 19:56:09','admin','2020-09-25 19:56:09'),(14,'N.T.T.Hà','english','admin','2020-09-25 19:56:20','admin','2020-09-25 19:56:20'),(15,'N.Q.Giao','english','admin','2020-09-25 19:58:15','admin','2020-09-25 19:58:15'),(16,'N.T.Thiết','english','admin','2020-09-26 04:27:24','admin','2020-09-26 04:27:24'),(17,'N.T.P.Nhung','english','admin','2020-09-26 04:27:32','admin','2020-09-26 04:27:32'),(18,'V.T.Sâm','english','admin','2020-09-26 04:27:38','admin','2020-09-26 04:27:38'),(19,'N.D.Ngọc','english','admin','2020-09-26 04:34:15','admin','2020-09-26 04:34:15'),(20,'Đ.P.Thúy','english','admin','2020-09-26 04:35:41','admin','2020-09-26 04:35:41');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
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
