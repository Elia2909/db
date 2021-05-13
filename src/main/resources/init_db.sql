CREATE DATABASE `liblary_db` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `library` (
                           `formate` varchar(255) DEFAULT NULL,
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `delted` tinyint NOT NULL DEFAULT '0',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
