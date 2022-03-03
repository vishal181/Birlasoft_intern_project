-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bp_data
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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `Emp_Id` varchar(50) NOT NULL DEFAULT 'Emp_',
  `EmpName` char(50) NOT NULL,
  `EmpDept` varchar(45) NOT NULL,
  `Location` char(50) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Emp_email` varchar(45) NOT NULL,
  `Emp_contact` varchar(10) NOT NULL,
  PRIMARY KEY (`Emp_Id`),
  UNIQUE KEY `Emp_contact_UNIQUE` (`Emp_contact`),
  UNIQUE KEY `Emp_email_UNIQUE` (`Emp_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Emp_001','Raghav','Business','Pune','0000','abc@gmail.com','9100000001'),('Emp_0010','Mridul','FAQ','Banglore','0000','abc45@gmail.com','9100000011'),('Emp_0011','Muskan','Software','Hyderabad','0000','abcd@gmail.com','9100000022'),('Emp_002','Preet','Finance','Banglore','0000','def@gmail.com','9100000002'),('Emp_003','Reet','Dev','Pune','0000','ghi@gmail.com','9100000003'),('Emp_004','Raghav','Analyst','Mumbai','0000','jkl@gmail.com','9100000004'),('Emp_005','Yash','Dev','Indore','0000','mno@gmail.com','9100000005'),('Emp_006','Ritik','Finance','Chennai','0000','pqr@gmail.com','9100000006'),('Emp_007','Aditi','Hardware','Gwalior','0000','stu@gmail.com','9100000007'),('Emp_008','Pranav','Software','Ujjain','0000','vwx@gmail.com','9100000008'),('Emp_009','Tushar','Network','Pune','0000','yz@gmail.com','9100000009');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-03 17:16:25
