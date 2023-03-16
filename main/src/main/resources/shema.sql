CREATE SCHEMA `online_school` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;


CREATE TABLE `course` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  PRIMARY KEY (`course_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `person` (
  `person_id` int NOT NULL AUTO_INCREMENT,
  `lastname` varchar(100) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `role` enum('teacher','student') NOT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `lecture` (
  `lecture_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  `creation_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `course_id` int DEFAULT NULL,
  `lecture_date` datetime DEFAULT NULL,
  PRIMARY KEY (`lecture_id`),
  KEY `fk_lecture_to_course` (`course_id`),
  CONSTRAINT `fk_lecture_to_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `homework` (
  `homework_id` int NOT NULL AUTO_INCREMENT,
  `task` varchar(400) DEFAULT NULL,
  `lecture_id` int DEFAULT NULL,
  PRIMARY KEY (`homework_id`),
  KEY `fk_homework_to_lecture` (`lecture_id`),
  CONSTRAINT `fk_homework_to_lecture` FOREIGN KEY (`lecture_id`) REFERENCES `lecture` (`lecture_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `additional_materials` (
  `additional_materials_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `resource_type` enum('URL','VIDEO','BOOK') NOT NULL,
  `lecture_id` int DEFAULT NULL,
  PRIMARY KEY (`additional_materials_id`),
  KEY `fk_additional_materials_to_lecture` (`lecture_id`),
  CONSTRAINT `fk_additional_materials_to_lecture` FOREIGN KEY (`lecture_id`) REFERENCES `lecture` (`lecture_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `course_with_student` (
  `course_with_student_id` int NOT NULL AUTO_INCREMENT,
  `course_id` int DEFAULT NULL,
  `person_id` int DEFAULT NULL,
  PRIMARY KEY (`course_with_student_id`),
  KEY `fk_course` (`course_id`),
  KEY `fk_student` (`person_id`),
  CONSTRAINT `fk_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `fk_student` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci









