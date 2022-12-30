/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 5.7.33 : Database - rumah_sakit
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rumah_sakit` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `rumah_sakit`;

/*Table structure for table `level_pengguna` */

DROP TABLE IF EXISTS `level_pengguna`;

CREATE TABLE `level_pengguna` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `level_pengguna` */

insert  into `level_pengguna`(`id`,`level`) values 
(1,'admin'),
(2,'user'),
(3,'guest');

/*Table structure for table `medicine_data` */

DROP TABLE IF EXISTS `medicine_data`;

CREATE TABLE `medicine_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kodeobat` varchar(16) DEFAULT NULL,
  `namaobat` varchar(16) DEFAULT NULL,
  `merkobat` varchar(16) DEFAULT NULL,
  `typeobat` varchar(16) DEFAULT NULL,
  `tglexpire` varchar(16) DEFAULT NULL,
  `stock` varchar(16) DEFAULT NULL,
  `harga` int(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `medicine_data` */

insert  into `medicine_data`(`id`,`kodeobat`,`namaobat`,`merkobat`,`typeobat`,`tglexpire`,`stock`,`harga`) values 
(1,'0410','PanadolExtra','Panadol','Tablet','2024-05-03','11',1000),
(3,'3010','TOLAKANGIN','SIDOMUNCUL','Obat Cair','2024-06-14','21',2000),
(4,'4122','DECOLGEN4TAB','DARYAVLAB','Tablet','2024-06-17','214',1500);

/*Table structure for table `pengguna` */

DROP TABLE IF EXISTS `pengguna`;

CREATE TABLE `pengguna` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) DEFAULT NULL,
  `katasandi` text,
  `nama` varchar(16) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `lastmodified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;

/*Data for the table `pengguna` */

insert  into `pengguna`(`id`,`username`,`katasandi`,`nama`,`level`,`lastmodified`) values 
(3,'awkdbawu','aodughauiapdhu','akhsdgahi ',1,'2022-08-26 17:44:08'),
(4,'iiTzMiksky','5021','marcell',1,'2022-08-26 17:46:36'),
(5,'asdsdads','asdasda','asdasd',1,'2022-08-26 18:22:51'),
(7,'aa','aa','aa',1,'2022-08-26 19:29:38'),
(9,'i20004','wakwawwww!','akhsdgahi ',1,'2022-08-27 14:21:28'),
(10,'aaa','aaaa','aaa',1,'2022-08-27 15:19:28'),
(11,'aaa','aaa','aaa',1,'2022-08-27 15:34:18'),
(12,'dor','tinggaldjendela','meletusbalnhijo',1,'2022-08-27 15:36:38'),
(13,'awawaw','awawwaw','wakwaw',1,'2022-08-27 22:01:18'),
(14,'ddfg','hhhhg','weff',1,'2022-08-27 22:42:11'),
(15,'qweqweqe','eqeqwqweqwe','aaaaaaa',1,'2022-08-29 15:14:11'),
(16,'dua','tiga','satu',1,'2022-08-30 16:45:13'),
(17,'dua','tiga','aaa',1,'2022-08-31 18:58:10'),
(19,'dua','aaaa','marcell',1,'2022-08-31 19:01:05'),
(20,'dua','tiga','a',1,'2022-08-31 19:05:30'),
(25,'aduhqwu8','qweuyh7u9q','aaa',1,'2022-09-02 15:04:13'),
(28,'dsa','a','dsa',NULL,'2022-09-02 17:38:18'),
(29,'jadiapa','prakprakprak','simselebew',NULL,'2022-09-02 20:53:05'),
(30,'13212313','132131313','13213',NULL,'2022-09-05 11:18:26'),
(31,'DA JIA HAOOO','312415512','HAOOOO',NULL,'2022-09-08 17:39:32'),
(40,'23 5125 ','g23bb36','da12d1',NULL,'2022-09-08 16:13:37'),
(42,'56736736m3','63n356m3n8','363456w45n7',NULL,'2022-09-08 16:26:14'),
(43,'2131232','123123213','21323',NULL,'2022-09-08 16:30:29'),
(44,'123123','v2322g634','dasasd',NULL,'2022-09-08 16:52:43'),
(45,'wewewewe','wewewewewew','marcell ewewew',NULL,'2022-09-08 17:40:54'),
(46,'2142142','r134 12','dasads21312',NULL,'2022-09-09 14:58:20'),
(47,'3zz12312z3','231z1z231z23','z1231z2331z2',NULL,'2022-09-09 14:58:24'),
(48,'3z21z32z231','3z12z123z123','z3121z23312z',NULL,'2022-09-09 14:58:30'),
(51,'231z31z231z2','113z132z132','z3121z32z123',NULL,'2022-09-09 14:58:42'),
(52,'wieiw','1231241','satu',NULL,'2022-09-16 20:27:57'),
(53,'412142142','124142142','12414',NULL,'2022-09-16 20:28:01'),
(54,'w123','321w','wiwiw',NULL,'2022-09-16 21:00:37');

/*Table structure for table `transchild` */

DROP TABLE IF EXISTS `transchild`;

CREATE TABLE `transchild` (
  `idChild` int(11) NOT NULL AUTO_INCREMENT,
  `kodeTransaksi` varchar(16) DEFAULT NULL,
  `namaObat` varchar(16) DEFAULT NULL,
  `jumlahObat` varchar(16) DEFAULT NULL,
  `idObat` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`idChild`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=latin1;

/*Data for the table `transchild` */

insert  into `transchild`(`idChild`,`kodeTransaksi`,`namaObat`,`jumlahObat`,`idObat`) values 
(36,'sims/422822/1821','PanadolExtra','2','1'),
(37,'sims/422822/1821','TOLAKANGIN','2','3'),
(38,'sims/422822/1821','DECOLGEN4TAB','4','4'),
(53,'marc/09922/84','PanadolExtra','11','1'),
(54,'satu/321822/2028','','3',''),
(55,'satu/321822/2028','','2',''),
(59,'marc/624822/1429','','3',''),
(60,'marc/624822/1429','','3',''),
(61,'marc/624822/1429','','4',''),
(81,'mele/09922/812','PanadolExtra','7','1'),
(82,'mele/09922/812','DECOLGEN4TAB','6','4'),
(83,'mele/09922/812','TOLAKANGIN','4','3'),
(84,'marc/413922/1554','PanadolExtra','6','1'),
(85,'marc/413922/1554','TOLAKANGIN','5','3');

/*Table structure for table `transparent` */

DROP TABLE IF EXISTS `transparent`;

CREATE TABLE `transparent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `namaCustomer` varchar(16) DEFAULT NULL,
  `kodeTransaksi` varchar(16) DEFAULT NULL,
  `tglTransaksi` varchar(24) DEFAULT NULL,
  `totalHargaTransaksi` int(16) DEFAULT NULL,
  `totalItemTransaksi` int(16) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

/*Data for the table `transparent` */

insert  into `transparent`(`id`,`namaCustomer`,`kodeTransaksi`,`tglTransaksi`,`totalHargaTransaksi`,`totalItemTransaksi`,`deleted`) values 
(15,'','satu/321822/2028','2022-09-21 20:28:06',7000,5,1),
(16,'simselebew','sims/422822/1821','2022-09-22 18:21:24',NULL,NULL,1),
(17,'marcell','marc/624822/1429','2022-09-24 14:29:22',15500,10,1),
(29,'marcell','marc/09922/84','2022-10-09 08:04:43',11000,11,1),
(30,'akhsdgahi ','mele/09922/812','2022-10-09 08:12:38',24000,17,0),
(31,'marcell ewewew','marc/413922/1554','2022-10-13 15:54:56',16000,11,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
