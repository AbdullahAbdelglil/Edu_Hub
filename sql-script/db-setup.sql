DROP DATABASE IF EXISTS `al_awael`;
CREATE DATABASE `al_awael`;
USE `al_awael`;

DROP TABLE IF EXISTS `instructor_detail`;
CREATE TABLE `instructor_detail` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `youtube_channel` VARCHAR(128) DEFAULT NULL,
	`hobby` VARCHAR(45) DEFAULT NULL,
    
	PRIMARY KEY (`id`)

)ENGINE= InnoDB AUTO_INCREMENT= 1 DEFAULT CHAR SET= latin1;

DROP TABLE IF EXISTS `instructor`;
CREATE TABLE `instructor` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) DEFAULT NULL,
	`last_name` VARCHAR(45) DEFAULT NULL,
	`email` VARCHAR(45) DEFAULT NULL,
    `instructor_detail_id` INT(11) DEFAULT NULL,
     PRIMARY KEY (`id`),
     
	KEY `FK_DETAIL_idx` (`instructor_detail_id`),
	CONSTRAINT `FK_DETAIL` 
    FOREIGN KEY (`instructor_detail_id`)
	REFERENCES instructor_detail (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
    
)ENGINE= InnoDB AUTO_INCREMENT= 1 DEFAULT CHAR SET= latin1;

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`(
	`id` INT(11) NOT NULL AUTO_INCREMENT, 
    `title` VARCHAR(45) DEFAULT NULL,
    `instructor_id` INT(11) DEFAULT NULL,

	PRIMARY KEY(`id`),
    UNIQUE KEY `TITLE_UNIQUE`(`title`),
	
    CONSTRAINT `FK_INSTRUCTOR_idx`
    FOREIGN KEY (`instructor_id`)
    REFERENCES instructor (`id`)
    
    ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE= InnoDB AUTO_INCREMENT= 1 DEFAULT CHAR SET= latin1;

DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`(
	`id` INT(11) NOT NULL AUTO_INCREMENT, 
    `comment` VARCHAR(256) DEFAULT NULL,
    `stars` INT DEFAULT NULL,
    `course_id` INT(11) DEFAULT NULL,

	PRIMARY KEY(`id`),
	
    CONSTRAINT `FK_COURSE_idx`
    FOREIGN KEY (`course_id`)
    REFERENCES course (`id`)
    
    ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE= InnoDB AUTO_INCREMENT= 1 DEFAULT CHAR SET= latin1;
