

INSERT INTO `online_school`.`course` (`name`) VALUES ('course1');
INSERT INTO `online_school`.`course` (`name`) VALUES ('course2');
INSERT INTO `online_school`.`course` (`name`) VALUES ('course3');

INSERT INTO `online_school`.`person` (`lastname`, `firstname`, `phone`, `email`, `role`) VALUES ('AAA', 'aaa', '+111111111111', 'aaa@aa.aa', 'student');
INSERT INTO `online_school`.`person` (`lastname`, `firstname`, `phone`, `email`, `role`) VALUES ('BBB', 'bbb', '+222222222222', 'bbb@bb.bb', 'student');
INSERT INTO `online_school`.`person` (`lastname`, `firstname`, `phone`, `email`, `role`) VALUES ('CCC', 'ccc', '+333333333333', 'ccc@cc.cc', 'student');
INSERT INTO `online_school`.`person` (`lastname`, `firstname`, `phone`, `email`, `role`) VALUES ('DDD', 'ddd', '+444444444444', 'ddd@dd.dd', 'student');
INSERT INTO `online_school`.`person` (`lastname`, `firstname`, `phone`, `email`, `role`) VALUES ('ATA', 'ata', '+555555555555', 'ata@at.at', 'teacher');
INSERT INTO `online_school`.`person` (`lastname`, `firstname`, `phone`, `email`, `role`) VALUES ('NTN', 'ntn', '+666666666666', 'ntn@nt.nt', 'teacher');
INSERT INTO `online_school`.`person` (`lastname`, `firstname`, `phone`, `email`, `role`) VALUES ('WTW', 'wtw', '+777777777777', 'wtw@wt.wt', 'teacher');


INSERT INTO `online_school`.`course_with_student` (`course_id`, `person_id`) VALUES ('1', '4');
INSERT INTO `online_school`.`course_with_student` (`course_id`, `person_id`) VALUES ('2', '4');
INSERT INTO `online_school`.`course_with_student` (`course_id`, `person_id`) VALUES ('3', '4');
INSERT INTO `online_school`.`course_with_student` (`course_id`, `person_id`) VALUES ('2', '5');
INSERT INTO `online_school`.`course_with_student` (`course_id`, `person_id`) VALUES ('3', '5');
INSERT INTO `online_school`.`course_with_student` (`course_id`, `person_id`) VALUES ('3', '6');



INSERT INTO `online_school`.`additional_materials` (`name`, `resource_type`, `lecture_id`) VALUES ('AMu', 'URL', '1');
INSERT INTO `online_school`.`additional_materials` (`name`, `resource_type`, `lecture_id`) VALUES ('AMv', 'VIDEO', '2');
INSERT INTO `online_school`.`additional_materials` (`name`, `resource_type`, `lecture_id`) VALUES ('AMb', 'BOOK', '3');
INSERT INTO `online_school`.`additional_materials` (`name`, `resource_type`, `lecture_id`) VALUES ('AMu', 'URL', '4');
INSERT INTO `online_school`.`additional_materials` (`name`, `resource_type`, `lecture_id`) VALUES ('AMv', 'VIDEO', '5');
INSERT INTO `online_school`.`additional_materials` (`name`, `resource_type`, `lecture_id`) VALUES ('AMv', 'VIDEO', '6');
INSERT INTO `online_school`.`additional_materials` (`name`, `resource_type`, `lecture_id`) VALUES ('AMv', 'VIDEO', '1');


INSERT INTO `online_school`.`lecture` (`name`, `description`, `course_id`, `lecture_date`) VALUES ('lecture11', 'd1', '1', '2023-04-04 04:04:04');
INSERT INTO `online_school`.`lecture` (`name`, `description`, `course_id`, `lecture_date`) VALUES ('lecture22', 'd2', '2', '2023-05-05 05:05:05');
INSERT INTO `online_school`.`lecture` (`name`, `description`, `course_id`, `lecture_date`) VALUES ('lecture32', 'd3', '2', '2023-06-06 06:06:06');
INSERT INTO `online_school`.`lecture` (`name`, `description`, `course_id`, `lecture_date`) VALUES ('lecture43', 'd4', '3', '2023-07-07 07:07:07');
INSERT INTO `online_school`.`lecture` (`name`, `description`, `course_id`, `lecture_date`) VALUES ('lecture53', 'd5', '3', '2023-08-08 08:08:08');
INSERT INTO `online_school`.`lecture` (`name`, `description`, `course_id`, `lecture_date`) VALUES ('lecture63', 'd6', '3', '2023-09-09 09:09:09');

INSERT INTO `online_school`.`homework` (`task`, `lecture_id`) VALUES ('HWT1', '1');
INSERT INTO `online_school`.`homework` (`task`, `lecture_id`) VALUES ('HWT2', '2');
INSERT INTO `online_school`.`homework` (`task`, `lecture_id`) VALUES ('HWT3', '3');
INSERT INTO `online_school`.`homework` (`task`, `lecture_id`) VALUES ('HWT4', '4');
INSERT INTO `online_school`.`homework` (`task`, `lecture_id`) VALUES ('HWT5', '5');
INSERT INTO `online_school`.`homework` (`task`, `lecture_id`) VALUES ('HWT6', '6');

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

INSERT INTO `online_school`.`additional_materials` (`name`, `resource_type`, `lecture_id`) VALUES ('AMu', 'URL', '8');
INSERT INTO `online_school`.`additional_materials` (`name`, `resource_type`, `lecture_id`) VALUES ('AMu', 'URL', '8');
INSERT INTO `online_school`.`additional_materials` (`name`, `resource_type`, `lecture_id`) VALUES ('AMu', 'URL', '7');


INSERT INTO `online_school`.`lecture` (`name`, `description`, `course_id`, `lecture_date`) VALUES ('lecture73', 'd7', '3', '2022-02-02 02:02:02');
INSERT INTO `online_school`.`lecture` (`name`, `description`, `course_id`, `lecture_date`) VALUES ('lecture83', 'd8', '3', '2022-01-01 01:01:01');
INSERT INTO `online_school`.`lecture` (`name`, `description`, `course_id`, `lecture_date`) VALUES ('lecture93', 'd9', '1', '2022-01-01 01:01:01');


INSERT INTO `online_school`.`homework` (`task`, `lecture_id`) VALUES ('HWT8', '8');
INSERT INTO `online_school`.`homework` (`task`, `lecture_id`) VALUES ('HWT9.1', '9');
INSERT INTO `online_school`.`homework` (`task`, `lecture_id`) VALUES ('HWT9.2', '9');


++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


INSERT INTO `online_school`.`lecture_with_teacher` (`lecture_id`, `person_id`) VALUES ('1', '10');
INSERT INTO `online_school`.`lecture_with_teacher` (`lecture_id`, `person_id`) VALUES ('2', '9');
INSERT INTO `online_school`.`lecture_with_teacher` (`lecture_id`, `person_id`) VALUES ('3', '8');
INSERT INTO `online_school`.`lecture_with_teacher` (`lecture_id`, `person_id`) VALUES ('4', '10');
INSERT INTO `online_school`.`lecture_with_teacher` (`lecture_id`, `person_id`) VALUES ('5', '9');
INSERT INTO `online_school`.`lecture_with_teacher` (`lecture_id`, `person_id`) VALUES ('6', '8');
INSERT INTO `online_school`.`lecture_with_teacher` (`lecture_id`, `person_id`) VALUES ('7', '10');
INSERT INTO `online_school`.`lecture_with_teacher` (`lecture_id`, `person_id`) VALUES ('8', '9');
INSERT INTO `online_school`.`lecture_with_teacher` (`lecture_id`, `person_id`) VALUES ('9', '8');
