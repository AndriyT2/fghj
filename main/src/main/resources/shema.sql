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




====================================================================================================================

SELECT * FROM person where role = 'student' ORDER BY lastname;



SELECT l.name, COUNT(am.additional_materials_id) AS am_count
FROM lecture l
LEFT JOIN additional_materials am ON l.lecture_id = am.lecture_id
WHERE l.lecture_date < '2023-01-01 00:00:00'
GROUP BY l.lecture_id
ORDER BY l.lecture_date;



SELECT l.name, l.creation_date, COUNT(h.homework_id)  AS hw_count
FROM lecture l
LEFT JOIN homework h ON l.lecture_id = h.lecture_id
WHERE l.creation_date = (SELECT MIN(creation_date) FROM lecture)
GROUP BY l.lecture_id
ORDER BY hw_count DESC
LIMIT 1;



SELECT resource_type, count(*) as type_total FROM online_school.additional_materials group by resource_type;



SELECT lastname, firstname FROM online_school.person where role = 'teacher' AND lastname REGEXP '^[A-N]|^[А-Н]';



SELECT  p.lastname, p.firstname,  COUNT(cws.course_with_student_id) AS course_total_count
FROM person p  LEFT  JOIN course_with_student cws ON p.person_id = cws.person_id
WHERE p.role = 'student'
    GROUP BY p.person_id
    HAVING course_total_count =1
ORDER BY lastname;



SELECT  p.lastname, p.firstname,  COUNT(cws.course_with_student_id) AS course_total_count
FROM person p  LEFT  JOIN course_with_student cws ON p.person_id = cws.person_id
WHERE p.role = 'student'
    GROUP BY p.person_id
    HAVING course_total_count =2
ORDER BY lastname;



SELECT  p.lastname, p.firstname,  COUNT(cws.course_with_student_id) AS course_total_count
FROM person p  LEFT  JOIN course_with_student cws ON p.person_id = cws.person_id
WHERE p.role = 'student'
    GROUP BY p.person_id
    HAVING course_total_count >=3
ORDER BY lastname;









