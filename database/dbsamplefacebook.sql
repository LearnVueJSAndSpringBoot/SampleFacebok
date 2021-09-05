
CREATE DATABASE `samplefacebook`;

USE `samplefacebook`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(9);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`created_by`,`created_date`,`modified_by`,`modified_date`,`address`,`dob`,`email`,`gender`,`name`,`phone`) values 
(1,'truongtv','2021-09-05','truongtv','2021-09-05','Ha Noi','1999-01-13','truongtv1399it@gmail.com','Male','Tran Vu Truong','0382945665');


/*Table structure for table `tb_post` */

DROP TABLE IF EXISTS `tb_post`;

CREATE TABLE `tb_post` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` date DEFAULT NULL,
  `content` text,
  `date_post` date DEFAULT NULL,
  `id_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7o6r5mn5p2j27pvdga1rrog4x` (`id_user`),
  CONSTRAINT `FK7o6r5mn5p2j27pvdga1rrog4x` FOREIGN KEY (`id_user`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_post` */

insert  into `tb_post`(`id`,`created_by`,`created_date`,`modified_by`,`modified_date`,`content`,`date_post`,`id_user`) values 
(2,'truongtv','2021-09-05','truongtv','2021-09-05','If you work with the Spring JDBC module, you are probably familiar with the support for populating a DataSource with SQL scripts. A similar abstraction is available on the repositories level, although it does not use SQL as the data definition language because it must be store-independent. Thus, the populators support XML (through Spring’s OXM abstraction) and JSON (through Jackson) to define data with which to populate the repositories.','2021-09-05',1),
(3,'truongtv','2021-09-05','truongtv','2021-09-05','You can use the type shown in the preceding example as a Spring MVC handler method argument or by using ParameterizedTypeReference on one of methods of the RestTemplate. The preceding method declarations would try to find firstname anywhere in the given document. The lastname XML lookup is performed on the top-level of the incoming document. The JSON variant of that tries a top-level lastname first but also tries lastname nested in a user sub-document if the former does not return a value. That way, changes in the structure of the source document can be mitigated easily without having clients calling the exposed methods (usually a drawback of class-based payload binding).','2021-09-05',1);



/*Table structure for table `tb_comment` */

DROP TABLE IF EXISTS `tb_comment`;

CREATE TABLE `tb_comment` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` date DEFAULT NULL,
  `content` text,
  `date_comment` date DEFAULT NULL,
  `id_parent` bigint DEFAULT NULL,
  `level` int DEFAULT NULL,
  `id_post` bigint DEFAULT NULL,
  `id_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6ihqo97y4h6eak1q4uh8t7yek` (`id_post`),
  KEY `FKxhy4h5vq95kdnrt70y285bge` (`id_user`),
  CONSTRAINT `FK6ihqo97y4h6eak1q4uh8t7yek` FOREIGN KEY (`id_post`) REFERENCES `tb_post` (`id`),
  CONSTRAINT `FKxhy4h5vq95kdnrt70y285bge` FOREIGN KEY (`id_user`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_comment` */

insert  into `tb_comment`(`id`,`created_by`,`created_date`,`modified_by`,`modified_date`,`content`,`date_comment`,`id_parent`,`level`,`id_post`,`id_user`) values 
(4,'truongtv','2021-09-05','truongtv','2021-09-05','Qua hay','2021-09-05',0,1,2,1),
(5,'truongtv','2021-09-05','truongtv','2021-09-05','Chat luong','2021-09-05',0,1,2,1),
(6,'truongtv','2021-09-05','truongtv','2021-09-05','ok','2021-09-05',4,2,2,1),
(7,'truongtv','2021-09-05','truongtv','2021-09-05','qua on','2021-09-05',6,3,2,1),
(8,'truongtv','2021-09-05','truongtv','2021-09-05','ok','2021-09-05',0,1,3,1);



