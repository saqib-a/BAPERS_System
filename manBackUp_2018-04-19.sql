-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: bapers
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `bapers`
--

/*!40000 DROP DATABASE IF EXISTS `bapers`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bapers` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bapers`;

--
-- Table structure for table `cardpayment`
--

DROP TABLE IF EXISTS `cardpayment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cardpayment` (
  `expiryDate` varchar(6) NOT NULL,
  `type` varchar(45) NOT NULL,
  `last_digits` varchar(45) NOT NULL,
  `amountPaid` float DEFAULT NULL,
  `jobId` varchar(45) DEFAULT NULL,
  `paymentDate` date DEFAULT NULL,
  `jobPaid` varchar(3) DEFAULT NULL,
  `customeraccount_accountNo` varchar(45) NOT NULL,
  `sePin` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`expiryDate`,`customeraccount_accountNo`),
  KEY `fk_cardpayment_customeraccount1_idx` (`customeraccount_accountNo`),
  CONSTRAINT `fk_cardpayment_customeraccount1` FOREIGN KEY (`customeraccount_accountNo`) REFERENCES `customeraccount` (`accountNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardpayment`
--

LOCK TABLES `cardpayment` WRITE;
/*!40000 ALTER TABLE `cardpayment` DISABLE KEYS */;
INSERT INTO `cardpayment` VALUES ('01/19','Visa','2132132132129999',309.6,'ACC1BorisBridgeJ1','2018-04-19','yes','ACC1BorisBridge','888'),('0120','Visa','251642142',465.7,'1','2018-04-19','yes','acs1212','251'),('123521','test','1234',29.26,'1','2018-04-24','yes','acs1212',NULL);
/*!40000 ALTER TABLE `cardpayment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customeraccount`
--

DROP TABLE IF EXISTS `customeraccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customeraccount` (
  `accountNo` varchar(45) NOT NULL,
  `accountName` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `postcode` varchar(8) NOT NULL,
  `city` varchar(45) NOT NULL,
  `phoneNo` varchar(11) NOT NULL,
  `valuedCustomer` varchar(3) DEFAULT NULL,
  `statues` varchar(45) DEFAULT 'vaild',
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`accountNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customeraccount`
--

LOCK TABLES `customeraccount` WRITE;
/*!40000 ALTER TABLE `customeraccount` DISABLE KEYS */;
INSERT INTO `customeraccount` VALUES ('ACC0001','Mr','City, University London','City University','City University','Northampton Square','EC1V 0HB','London','0207048000','YES','vaild','David.Rhind@city.ac.uk'),('ACC0002','Mr','InfoPharma Ltd','Alex','Wright','25, Bond Street','WC1V 8LS','London','02073218001','YES','vaild','Alex.Wright@infopharma.ac.uk'),('ACC0003','Mr','Hello Magazine','Sarah','Brocklehurst','12, Bond Street','WC1V 8NS','London','02034567809','YES','vaild','Sarah.Brocklehurst@hello.ac.uk'),('ACC0004','Mr','EvaBauyer','Eva','Bauyer','1, Liverpool street','EC2V 8NS','London','02085558989','YES','vaild','eva.bauyer@gmail.ac.uk'),('ACC1BorisBridge','Mr ','Boris Bridge','Broris','Bridge','N/a','n/a','n/a','0','NO','vaild','saamran.gul@city.ac.uk'),('ACC1IvanGrey','Mr','Ivan Grey','Ivan','Grey','N/A','N/A','N/A','0','NO','vaild','sarath.vaman@city.ac.uk'),('acs1212','q','q','q','q','q','q','q','0478545','YES','vaild','sarath.vaman@city.ac.uk');
/*!40000 ALTER TABLE `customeraccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discounttype`
--

DROP TABLE IF EXISTS `discounttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discounttype` (
  `discountID` int(11) NOT NULL,
  `CustomerAccount_accountNo` varchar(45) NOT NULL,
  `discountType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`discountID`),
  KEY `fk_Discount_CustomerAccount1_idx` (`CustomerAccount_accountNo`),
  CONSTRAINT `fk_Discount_CustomerAccount1` FOREIGN KEY (`CustomerAccount_accountNo`) REFERENCES `customeraccount` (`accountNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discounttype`
--

LOCK TABLES `discounttype` WRITE;
/*!40000 ALTER TABLE `discounttype` DISABLE KEYS */;
INSERT INTO `discounttype` VALUES (1,'acs1212','1'),(2,'acs1212','1'),(3,'acs1212','1'),(4,'acs1212','3'),(5,'acs1212','2'),(6,'acs1212','1'),(7,'acs1212','2'),(8,'acs1212','1'),(11,'acs1212','1');
/*!40000 ALTER TABLE `discounttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fixed`
--

DROP TABLE IF EXISTS `fixed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fixed` (
  `discountRate` int(11) NOT NULL,
  `DiscountType_discountID` int(11) NOT NULL,
  PRIMARY KEY (`DiscountType_discountID`),
  KEY `fk_Fixed_DiscountType1_idx` (`DiscountType_discountID`),
  CONSTRAINT `fk_Fixed_DiscountType1` FOREIGN KEY (`DiscountType_discountID`) REFERENCES `discounttype` (`discountID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fixed`
--

LOCK TABLES `fixed` WRITE;
/*!40000 ALTER TABLE `fixed` DISABLE KEYS */;
INSERT INTO `fixed` VALUES (5,4);
/*!40000 ALTER TABLE `fixed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flexible`
--

DROP TABLE IF EXISTS `flexible`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flexible` (
  `discountRate` varchar(45) DEFAULT NULL,
  `DiscountType_discountID` int(11) NOT NULL,
  `task_taskId` int(11) NOT NULL,
  PRIMARY KEY (`DiscountType_discountID`,`task_taskId`),
  KEY `fk_Flexible_DiscountType1_idx` (`DiscountType_discountID`),
  KEY `fk_Flexible_task1_idx` (`task_taskId`),
  CONSTRAINT `fk_Flexible_DiscountType1` FOREIGN KEY (`DiscountType_discountID`) REFERENCES `discounttype` (`discountID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Flexible_task1` FOREIGN KEY (`task_taskId`) REFERENCES `task` (`taskId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flexible`
--

LOCK TABLES `flexible` WRITE;
/*!40000 ALTER TABLE `flexible` DISABLE KEYS */;
INSERT INTO `flexible` VALUES ('1',2,1),('1',3,2),('4',5,1);
/*!40000 ALTER TABLE `flexible` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `jobId` varchar(45) NOT NULL,
  `due_amount` varchar(45) NOT NULL,
  `urgent_job` varchar(3) NOT NULL,
  `CustomerAccount_accountNo` varchar(45) NOT NULL,
  `jobDescription` varchar(45) NOT NULL,
  `Date` date NOT NULL,
  `Alerted` varchar(5) DEFAULT 'false',
  `isCompleted` varchar(45) DEFAULT 'no',
  `active` varchar(45) DEFAULT 'no',
  `status` varchar(45) DEFAULT 'in progress',
  PRIMARY KEY (`jobId`),
  KEY `fk_Job_CustomerAccount1_idx` (`CustomerAccount_accountNo`),
  CONSTRAINT `fk_Job_CustomerAccount1` FOREIGN KEY (`CustomerAccount_accountNo`) REFERENCES `customeraccount` (`accountNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES ('1','100.0','NO','acs1212','awsedrfgyhuj','2018-05-15','true','no','no','Completed'),('2','100.0','YES','acs1212','NO','2018-04-24','true','no','no','in progress'),('ACC0001J1','100.0','NO','ACC0001','5 B&W films for 10x8 processin ','2018-04-25','true','no','no','in progress'),('ACC0001J2','200.0','NO','ACC0001','5 x 4 B&W copy negatives','2018-04-25','true','no','no','in progress'),('ACC0001J3','200.0','NO','ACC0001','10 films for 5 x 4 Colour copy negative','2018-04-25','true','no','no','in progress'),('ACC0001J4','200.0','NO','ACC0001','10 films for 10 x 8 C41 processing','2018-04-25','true','no','no','in progress'),('ACC0002J1','100.0','VU','ACC0002','3 items for 10 x 8 Colour copy transparency','2018-05-15','true','no','no','in progress'),('ACC0003J1','100.0','NO','ACC0003','10 films 5 x 4 Colour copy negatives:','2018-04-26','true','no','no','in progress'),('ACC0003J2','100.0','NO','ACC0003','10 films 10 x 8 C41 processing','2018-04-26','true','no','no','in progress'),('ACC0003J3','100.0','NO','ACC0003','10 films 10 x 8 C41 processing','2018-04-26','true','no','no','in progress'),('ACC0003J4','200.0','NO','ACC0003','10 films for 5 x 4 Colour copy negatives','2018-05-15','true','no','no','in progress'),('ACC0003J5','500.0','NO','ACC0003','10 films for 10 x 8 C41 processing','2018-05-15','true','no','no','in progress'),('ACC1BorisBridgeJ1','125.2','NO','ACC1BorisBridge','3 items for 10 x 8 Colour copy transparency','2018-04-24','true','no','no','in progress'),('ACC1IvanGreyJ1','100.0','YES','ACC1IvanGrey','3 items for 10 x 8 Colour copy transparency:','2018-04-19','true','no','no','in progress');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_has_task`
--

DROP TABLE IF EXISTS `job_has_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_has_task` (
  `Job_jobId` varchar(45) NOT NULL,
  `Task_taskId` int(11) NOT NULL,
  `completedBy` varchar(45) DEFAULT NULL,
  `jobDate` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT 'pending',
  `staff_staffId` varchar(45) NOT NULL,
  `urgent_task` varchar(3) DEFAULT NULL,
  `taskAlert` varchar(45) DEFAULT 'true',
  KEY `fk_Job_has_Task_Task1_idx` (`Task_taskId`),
  KEY `fk_Job_has_Task_Job1_idx` (`Job_jobId`),
  KEY `fk_job_has_task_staff1_idx` (`staff_staffId`),
  CONSTRAINT `fk_Job_has_Task_Job1` FOREIGN KEY (`Job_jobId`) REFERENCES `job` (`jobId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Job_has_Task_Task1` FOREIGN KEY (`Task_taskId`) REFERENCES `task` (`taskId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_job_has_task_staff1` FOREIGN KEY (`staff_staffId`) REFERENCES `staff` (`staffId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_has_task`
--

LOCK TABLES `job_has_task` WRITE;
/*!40000 ALTER TABLE `job_has_task` DISABLE KEYS */;
INSERT INTO `job_has_task` VALUES ('1',2,'Samreen khan',NULL,'in progress','test','NO','true'),('1',2,'Samreen khan',NULL,'in progress','test','NO','true'),('1',2,'Samreen khan',NULL,'in progress','test','NO','true'),('1',2,'Samreen khan',NULL,'in progress','test','NO','true'),('1',2,'Samreen khan',NULL,'in progress','test','NO','true'),('1',2,'Samreen khan',NULL,'in progress','test','NO','true'),('1',2,'Samreen khan',NULL,'in progress','test','NO','true'),('1',2,'Samreen khan',NULL,'in progress','test','NO','true'),('ACC0001J1',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J1',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J1',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J1',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J1',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J1',2,'Development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J1',2,'Development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J1',2,'Development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J1',2,'Development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J1',2,'Development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J2',2,'Development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J2',2,'Development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J2',2,'Development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J2',2,'Development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J2',2,'Development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J2',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J2',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J2',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J2',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J2',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J3',4,'development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J3',4,'development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J3',4,'development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J3',4,'development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J3',4,'development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J3',4,'development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J3',4,'development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J3',4,'development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J3',4,'development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J3',4,'development tech',NULL,'pending','Development',NULL,'true'),('ACC0001J3',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J3',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J3',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J3',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J3',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J3',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J3',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J3',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J3',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J3',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0001J2',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J2',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J2',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J2',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J2',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J3',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J3',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J3',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J3',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J3',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J3',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J3',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J3',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J3',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J3',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J4',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J4',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J4',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J4',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J4',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J4',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J4',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J4',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J4',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J4',3,'packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0001J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0001J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0001J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0001J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0001J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0001J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0001J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0001J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0001J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0001J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC1IvanGreyJ1',3,'James Bond',NULL,'Complete','Packer','YES','true'),('ACC1IvanGreyJ1',3,'James Bond',NULL,'Complete','Packer','YES','true'),('ACC1IvanGreyJ1',3,'James Bond',NULL,'Complete','Packer','YES','true'),('ACC1IvanGreyJ1',4,'DevelopmentRoom tech',NULL,'Complete','Development','YES','true'),('ACC1IvanGreyJ1',4,'DevelopmentRoom tech',NULL,'Complete','Development','YES','true'),('ACC1IvanGreyJ1',4,'DevelopmentRoom tech',NULL,'Complete','Development','YES','true'),('ACC0003J1',4,'Development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J1',4,'Development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J1',4,'Development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J1',4,'Development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J1',4,'Development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J1',4,'Development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J1',4,'Development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J1',4,'Development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J1',4,'Development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J1',4,'Development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J1',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J1',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J1',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J1',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J1',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J1',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J1',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J1',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J1',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J1',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J2',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J2',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J2',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J2',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J2',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J2',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J2',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J2',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J2',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J2',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J2',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J2',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J2',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J2',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J2',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J2',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J2',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J2',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J2',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J2',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J3',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J3',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J3',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J3',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J3',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J3',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J3',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J3',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J3',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J3',4,'Development  room tech',NULL,'pending','Development',NULL,'true'),('ACC0002J1',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0002J1',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0002J1',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0002J1',4,'developement room tech',NULL,'pending','Development',NULL,'true'),('ACC0002J1',4,'developement room tech',NULL,'pending','Development',NULL,'true'),('ACC0002J1',4,'developement room tech',NULL,'pending','Development',NULL,'true'),('ACC1BorisBridgeJ1',3,'Packing Room tech',NULL,'Complete','Packer',NULL,'true'),('ACC1BorisBridgeJ1',3,'Packing Room tech',NULL,'Complete','Packer',NULL,'true'),('ACC1BorisBridgeJ1',3,'Packing Room tech',NULL,'Complete','Packer',NULL,'true'),('ACC1BorisBridgeJ1',4,'developemnt  Room tech',NULL,'Complete','Development',NULL,'true'),('ACC1BorisBridgeJ1',4,'developemnt  Room tech',NULL,'Complete','Development',NULL,'true'),('ACC1BorisBridgeJ1',4,'developemnt  Room tech',NULL,'Complete','Development',NULL,'true'),('ACC0003J4',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0003J4',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0003J4',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0003J4',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0003J4',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0003J4',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0003J4',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0003J4',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0003J4',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0003J4',1,'Copy room tech',NULL,'pending','Copy',NULL,'true'),('ACC0003J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J4',4,'development room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J4',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J4',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J4',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J4',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J4',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J4',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J4',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J4',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J4',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J4',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J5',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J5',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J5',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J5',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J5',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J5',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J5',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J5',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J5',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J5',3,'Packing room tech',NULL,'pending','Packer',NULL,'true'),('ACC0003J5',4,'Developemnt  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J5',4,'Developemnt  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J5',4,'Developemnt  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J5',4,'Developemnt  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J5',4,'Developemnt  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J5',4,'Developemnt  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J5',4,'Developemnt  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J5',4,'Developemnt  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J5',4,'Developemnt  room tech',NULL,'pending','Development',NULL,'true'),('ACC0003J5',4,'Developemnt  room tech',NULL,'pending','Development',NULL,'true'),('2',1,'sajawal kiani',NULL,'pending','Manager','YES','true');
/*!40000 ALTER TABLE `job_has_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `paymentId` int(11) NOT NULL AUTO_INCREMENT,
  `amountPaid` float NOT NULL,
  `paymentType` varchar(45) NOT NULL,
  `CustomerAccount_accountNo` varchar(45) NOT NULL,
  `paymentDate` date DEFAULT NULL,
  `jobPaid` varchar(3) DEFAULT 'no',
  `jobId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`paymentId`,`CustomerAccount_accountNo`),
  KEY `fk_Payment_CustomerAccount1_idx` (`CustomerAccount_accountNo`),
  CONSTRAINT `fk_Payment_CustomerAccount1` FOREIGN KEY (`CustomerAccount_accountNo`) REFERENCES `customeraccount` (`accountNo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (5,140.45,'cash','acs1212','2018-04-18','yes',NULL),(6,309.6,'cash','ACC1IvanGrey','2018-04-18','yes',NULL),(7,451.44,'cash','acs1212','2018-04-19','yes',NULL);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `staffId` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `jobTitle` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`staffId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES ('Accountant','acc','name','Shift Manager','Count_money','sajawal.kiani@city.ac.uk'),('Clerk','acc','name','Shift Manager','Paperwork','sajawal.kiani@city.ac.uk'),('Copy','james ','Khan','CopyRoom Technician','Too_dark','sugan.nathan@city.ac.uk'),('Development','lot','smell','Development Technician','Lot_smell','sugan.nathan@city.ac.uk'),('Finish','sama','bell','FinishingRoom Technician','Fine_touch','sugan.nathan@city.ac.uk'),('Hello','hello','there','Receptionist','Hello_there','sugan.nathan@city.ac.uk'),('Manager','man','man','Office Manager','Get_it_done','sarath.vaman@city.ac.uk'),('packer','hamzah','vaman','PackingRoom Technician','Pack_it','sugan.nathan@city.ac.uk'),('qq','connor','same','Shift Manager','qq','sajawal.kiani@city.ac.uk'),('test','Sajawal','Kiani','Office Manager','1','sajawal.kiani@city.ac.uk');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `taskId` int(11) NOT NULL,
  `location` varchar(45) NOT NULL,
  `shelfslot` varchar(45) NOT NULL,
  `price` varchar(45) NOT NULL,
  `duration` varchar(45) NOT NULL,
  `taskDescription` varchar(45) NOT NULL,
  `StartTime` int(6) NOT NULL,
  `TaskCompleted` varchar(3) DEFAULT 'no',
  PRIMARY KEY (`taskId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,'Copy Room','CR25','19.0','120','Use of Large copy camera',13,'no'),(2,'Development area','DR12','49.50','60','Black and white film',1220,'no'),(3,'Packing Departments','Pr10','6.0','30','Bag up',1120,'no'),(4,'Development Area','DR25','80.0','90','Colour film processing',1118,'no'),(5,'Development Area','DR100','100.3','180','Colour Transparency processing',1119,'no'),(6,'Copy Room','CR16','8.3','75','Use of small copy camera',1120,'no'),(7,'Finishing Room','Fr5','55.5','45','Mount Transparencies',1123,'no');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volumediscount`
--

DROP TABLE IF EXISTS `volumediscount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volumediscount` (
  `volumeDiscountId` varchar(45) NOT NULL,
  `DiscountType_discountID` int(11) NOT NULL,
  `discountRate` varchar(45) DEFAULT NULL,
  `volume` varchar(45) NOT NULL,
  PRIMARY KEY (`volumeDiscountId`,`DiscountType_discountID`),
  KEY `fk_VolumeDiscount_DiscountType1_idx` (`DiscountType_discountID`),
  CONSTRAINT `fk_VolumeDiscount_DiscountType1` FOREIGN KEY (`DiscountType_discountID`) REFERENCES `discounttype` (`discountID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volumediscount`
--

LOCK TABLES `volumediscount` WRITE;
/*!40000 ALTER TABLE `volumediscount` DISABLE KEYS */;
INSERT INTO `volumediscount` VALUES ('1',4,'2','>100'),('4',11,'1','100');
/*!40000 ALTER TABLE `volumediscount` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-19 12:34:01
