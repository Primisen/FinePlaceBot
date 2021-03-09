CREATE DATABASE  IF NOT EXISTS `tourist_guide` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tourist_guide`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tourist_guide
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (3);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `place`
--

DROP TABLE IF EXISTS `place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `place` (
  `place_id` int(11) NOT NULL AUTO_INCREMENT,
  `place_name` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  PRIMARY KEY (`place_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `place`
--

LOCK TABLES `place` WRITE;
/*!40000 ALTER TABLE `place` DISABLE KEYS */;
INSERT INTO `place` VALUES (12,'Троицкое предместье','Минск'),(13,'Верхний город','Минск'),(14,'Улица Октябрьская и Галерея «Ў»','Минск'),(16,'Галерея «Арт-Беларусь»','Минск'),(18,'Ботанический сад','Минск'),(20,'Красная площадь','Москва'),(21,'Галерея Шилова','Москва'),(23,'Музей Булгакова','Москва'),(24,'Сад имени Баумана','Москва'),(25,'Театр кукол Образцова','Москва'),(26,'Киево-Печерская лавра','Киев'),(27,'Николаевский костёл','Киев'),(28,'Андреевский спуск','Киев'),(29,'Замок Ричарда — Львиное сердце','Киев'),(30,'Оперный театр Тараса Шевченко','Киев'),(31,'Дворцовая площадь Варшавы','Варшава'),(32,'Королевский замок','Варшава'),(33,'Рыночная площадь','Варшава'),(34,'Старе Място','Варшава'),(35,'Вилянувский дворец','Варшава'),(36,'Башня Гедимина','Вильнюс'),(37,'Президентский дворец','Вильнюс'),(38,'Центр современного искусства','Вильнюс'),(39,'Дворец великих князей литовских','Вильнюс'),(40,'Храм святой Анны','Вильнюс'),(41,'Кошкин дом','Рига'),(42,'Рижский замок','Рига'),(43,'Даугавгривская крепость','Рига'),(44,'Большая и Малая гильдии','Рига'),(45,'Латвийский Национальный художественный музей','Рига'),(46,'Брестская крепость','Брест'),(47,'Монумент «Мужество»','Брест'),(48,'Музей «5-й форт»','Брест'),(49,'Археологическая экспозиция «Берестье»','Брест'),(50,'Борисоглебская церковь','Гродно'),(51,'Новогрудский замок','Новогрудок'),(52,'Бобруйская крепость','Бобруйск'),(53,'Браславские озера','Браслав'),(54,'Здание историко-краеведческого музея','Браслав'),(55,'Здание бывшего железнодорожного вокзала','Браслав'),(56,'Памятник Бобру','Бобруйск'),(57,'Центральный рынок','Бобруйск'),(58,'Старый замок','Гродно'),(59,'Новый замок','Гродно');
/*!40000 ALTER TABLE `place` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-09 18:39:29
