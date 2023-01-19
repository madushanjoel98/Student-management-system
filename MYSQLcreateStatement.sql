CREATE DATABASE `student_mangment` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `admin` (
  `id_admin` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_no` bigint(20) NOT NULL,
  `email` varchar(25) NOT NULL,
  `pasword` longtext NOT NULL,
  `type` int(11) DEFAULT NULL,
  `branch_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_admin`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `emp_no_UNIQUE` (`emp_no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
CREATE TABLE `student` (
  `student_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `image_namel` varchar(35) DEFAULT NULL,
  `joindate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mobile_no` varchar(15) NOT NULL,
  `nic` varchar(15) NOT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `email` varchar(25) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
CREATE TABLE `branch` (
  `branch_id` int(11) NOT NULL AUTO_INCREMENT,
  `branch_location` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
CREATE TABLE `courses` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
CREATE TABLE `branch` (
  `branch_id` int(11) NOT NULL AUTO_INCREMENT,
  `branch_location` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
CREATE TABLE `batch` (
  `batch_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Batch_name` varchar(45) DEFAULT NULL,
  `branch_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `close_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`batch_id`),
  KEY `cid_idx` (`course_id`),
  KEY `br_ids_idx` (`branch_id`),
  CONSTRAINT `FKdcq6voi5kdf4uc8yom5dym82i` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`),
  CONSTRAINT `FKwbvier2l7k2qwiwg1hsak9iw` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`),
  CONSTRAINT `br_ids` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cid` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `enroll` (
  `enroll_id` int(11) NOT NULL AUTO_INCREMENT,
  `batch_id` bigint(20) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  `course_id` int(11) NOT NULL,
  `enroll_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`enroll_id`),
  KEY `bid_idx` (`batch_id`),
  KEY `sids_idx` (`student_id`),
  KEY `cids_idx` (`course_id`),
  CONSTRAINT `FK4woy7t9k2h8fvdyeddvyyyjfy` FOREIGN KEY (`batch_id`) REFERENCES `batch` (`batch_id`),
  CONSTRAINT `FKfd69f3wpcwjgmwoom5pr74su6` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`),
  CONSTRAINT `FKr5hq653kinipvyshfdl738ouc` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `bid` FOREIGN KEY (`batch_id`) REFERENCES `batch` (`batch_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cids` FOREIGN KEY (`course_id`) REFERENCES `courses` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `sids` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
CREATE TABLE `payment_type` (
  `idpayment_type` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(45) NOT NULL,
  PRIMARY KEY (`idpayment_type`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `payment_type` int(11) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  `batchid` bigint(20) NOT NULL,
  `payment` double NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `_idx` (`student_id`),
  KEY `ptid_idx` (`payment_type`),
  KEY `batch_id_idx` (`batchid`),
  CONSTRAINT `FKlujl6kt6wwuag5mnsu1v7ujlb` FOREIGN KEY (`payment_type`) REFERENCES `payment_type` (`idpayment_type`),
  CONSTRAINT `FKq0mpbhvyrwyggk1gwjams69wf` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `FKtabjbd7whcmfy2816hpywxotm` FOREIGN KEY (`batchid`) REFERENCES `batch` (`batch_id`),
  CONSTRAINT `batch_id` FOREIGN KEY (`batchid`) REFERENCES `batch` (`batch_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ptid` FOREIGN KEY (`payment_type`) REFERENCES `payment_type` (`idpayment_type`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ssid` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
