/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.17 : Database - ssa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ssa` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ssa`;

/*Table structure for table `teretana` */

DROP TABLE IF EXISTS `teretana`;

CREATE TABLE `teretana` (
  `teretanaid` int(11) NOT NULL AUTO_INCREMENT,
  `teretanaime` varchar(40) NOT NULL,
  `teretanaadresa` varchar(70) NOT NULL,
  `teretanadelatnost` varchar(40) NOT NULL,
  PRIMARY KEY (`teretanaid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `teretana` */

insert  into `teretana`(`teretanaid`,`teretanaime`,`teretanaadresa`,`teretanadelatnost`) values (1,'FIT ZUM','Prve pruge bb','Kardio i tegovi'),(2,'Titan','Jevremova 44','Bodybuilding'),(3,'Healty life','Dobracina 14','Kardio'),(4,'Mir','Bana Ivanisa 87','Joga');

/*Table structure for table `trener` */

DROP TABLE IF EXISTS `trener`;

CREATE TABLE `trener` (
  `trenerid` int(11) NOT NULL AUTO_INCREMENT,
  `trenerime` varchar(15) NOT NULL,
  `trenerprezime` varchar(15) NOT NULL,
  `trenergodiste` int(4) NOT NULL,
  `trenersport` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`trenerid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `trener` */

insert  into `trener`(`trenerid`,`trenerime`,`trenerprezime`,`trenergodiste`,`trenersport`) values (1,'Vladimir','Radojicic',1977,'fudbal'),(2,'Sale','Radovanovic',1981,'fudbal'),(3,'Dragan','Perisic',1958,'kosarka'),(4,'Nikola','Todoric',1984,'rukomet'),(6,'Jovana','Miladinovic',1987,'odbojka'),(7,'Marko','Markovic',1976,'veslanje');

/*Table structure for table `trening` */

DROP TABLE IF EXISTS `trening`;

CREATE TABLE `trening` (
  `treningid` int(11) NOT NULL AUTO_INCREMENT,
  `treningnaziv` varchar(40) NOT NULL,
  `treningdatum` date NOT NULL,
  `vezbacid` int(11) NOT NULL,
  PRIMARY KEY (`treningid`),
  KEY `vezbacid` (`vezbacid`),
  CONSTRAINT `trening_ibfk_1` FOREIGN KEY (`vezbacid`) REFERENCES `vezbac` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `trening` */

insert  into `trening`(`treningid`,`treningnaziv`,`treningdatum`,`vezbacid`) values (1,'Ledja','2015-09-17',1),(2,'Biceps','2015-10-01',2),(3,'Triceps','2015-09-09',2),(7,'Kardio','2015-09-10',6),(9,'Kardio','2015-09-09',12);

/*Table structure for table `vezbac` */

DROP TABLE IF EXISTS `vezbac`;

CREATE TABLE `vezbac` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(15) NOT NULL,
  `prezime` varchar(15) NOT NULL,
  `bmi` float NOT NULL,
  `trener` int(11) NOT NULL,
  `teretana` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `trener` (`trener`),
  KEY `teretana` (`teretana`),
  CONSTRAINT `vezbac_ibfk_3` FOREIGN KEY (`trener`) REFERENCES `trener` (`trenerid`),
  CONSTRAINT `vezbac_ibfk_4` FOREIGN KEY (`teretana`) REFERENCES `teretana` (`teretanaid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `vezbac` */

insert  into `vezbac`(`id`,`ime`,`prezime`,`bmi`,`trener`,`teretana`) values (1,'Petar','Milisavljevic',20,1,1),(2,'Ivan','Milanovic',18,3,1),(6,'Marko','Ilic',17,1,2),(7,'Milos','Radulovic',22,3,2),(9,'Milica','Stanisic',14,2,4),(10,'Stefan','Stefanovic',12,3,3),(11,'Nemanja','Nikolic',19,2,4),(12,'Olga','Obradovic',20.8,1,1),(13,'Tanja','Milisavljevic',17.4,1,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
