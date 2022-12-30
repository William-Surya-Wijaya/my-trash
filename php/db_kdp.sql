/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 5.7.33 : Database - db_kdp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_kdp` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_kdp`;

/*Table structure for table `ad_user` */

DROP TABLE IF EXISTS `ad_user`;

CREATE TABLE `ad_user` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `nik` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `no` varchar(16) DEFAULT NULL,
  `ktp` varchar(255) DEFAULT NULL,
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `ad_user` */

insert  into `ad_user`(`id`,`nik`,`nama`,`alamat`,`no`,`ktp`,`deleted_at`) values 
(1,'1000000000000001','William Surya Wijaya','Permata Cimohai','081313489781','1000000000000001.jpeg',NULL),
(2,'6123223242999999','rey','jl koper','08997186197','6123223242999999.jpeg',NULL),
(3,'1234567890123456','Rivaldiw GODJALIW','SOETTA','1234567890123','1234567890123456.jpeg',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
