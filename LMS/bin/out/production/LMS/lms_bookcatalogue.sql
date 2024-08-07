-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lms
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `bookcatalogue`
--

DROP TABLE IF EXISTS `bookcatalogue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookcatalogue` (
  `ISBN` int NOT NULL AUTO_INCREMENT,
  `GENRE` varchar(20) NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `AUTHOR` varchar(25) NOT NULL,
  `BOOK_STATUS` varchar(15) DEFAULT NULL,
  `DUE_DATE` date DEFAULT NULL,
  PRIMARY KEY (`ISBN`),
  UNIQUE KEY `ISBN` (`ISBN`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookcatalogue`
--

LOCK TABLES `bookcatalogue` WRITE;
/*!40000 ALTER TABLE `bookcatalogue` DISABLE KEYS */;
INSERT INTO `bookcatalogue` VALUES (1,'HORROR','THE SHINNING','STEPHEN KING','CHECKED-IN',NULL),(2,'HORROR','DRACULA','BRAM STOKER',NULL,NULL),(3,'HORROR','FRANKENSTIEN','MARY SHELLY',NULL,NULL),(4,'HORROR','THE HAUNTING OF HILL HOUSE','SHIRLEY JACKSON',NULL,NULL),(5,'SCI-FI','DUNE','FRANK HERBERT',NULL,NULL),(6,'SCI-FI','NEUROMANCER','WILLIAM GIBSON',NULL,NULL),(7,'SCI-FI','FOUNDATION','ISAAC ASIMOV',NULL,NULL),(8,'SCI-FI','THE LEFT HAND OF DARKNESS','URSULA K. LE GUIN',NULL,NULL),(9,'NON-FICTION','SAPIENS: A BRIEF HISTORY OF HUMANKIND','YUVAL NOAH HARARI',NULL,NULL),(10,'NON-FICTION','EDUCATED','TARA WESTOVER',NULL,NULL),(11,'NON-FICTION','BECOMING','MICHELLE OBAMA',NULL,NULL),(12,'NON-FICTION','THE IMMORTAL LIFE OF HENRIETTA LACKS','REBECCA SKLOOT',NULL,NULL),(13,'THRILLER','THE GIRL WITH THE DRAGON TATTOO','STIEG LARSSON',NULL,NULL),(14,'THRILLER','GONE GIRL','GILLIAN FLYNN',NULL,NULL),(15,'THRILLER','THE SILENT PATIENT','ALEX MICHAELIDES',NULL,NULL),(16,'THRILLER','BEFORE I GO TO SLEEP','S.J. WATSON',NULL,NULL),(17,'BIOGRAPHY','STEVE JOBS','WALTER ISAACSON',NULL,NULL),(18,'BIOGRAPHY','THE DIARY OF A YOUNG GIRL','ANNE FRANK',NULL,NULL),(19,'BIOGRAPHY','LONG WALK TO FREEDOM','NELSON MANDELA',NULL,NULL),(20,'BIOGRAPHY','A BEAUTIFUL MIND','SYLVIA NASAR',NULL,NULL),(21,'DRAMA','TO KILL A MOCKINGBIRD','HARPER LEE',NULL,NULL),(22,'DRAMA','LITTLE FIRES EVERYWHERE','CELESTE NG',NULL,NULL),(23,'DRAMA','THE KITE RUNNER','KHALED HOSSEINI',NULL,NULL),(24,'DRAMA','A MAN CALLED OVE','FREDRIK BACKMAN',NULL,NULL),(25,'CHILDREN','HARRY POTTER AND THE SORCERER\'S STONE','J.K. ROWLING',NULL,NULL),(26,'CHILDREN','CHARLIE AND THE CHOCOLATE FACTORY','ROALD DAHL',NULL,NULL);
/*!40000 ALTER TABLE `bookcatalogue` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-14 20:21:18
