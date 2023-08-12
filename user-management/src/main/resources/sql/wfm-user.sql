  create database wfm_user;
  use wfm_user;
  
  CREATE TABLE `wfm_user`.`module` (
    `module_id` INT NOT NULL AUTO_INCREMENT,
    `module_name` VARCHAR(45) NULL,
    `module_description` VARCHAR(45) NULL,
    PRIMARY KEY (`module_id`));

CREATE TABLE `wfm_user`.`screen` (
  `screen_id` INT NOT NULL AUTO_INCREMENT,
  `screen_name` VARCHAR(45) NULL,
  `screen_description` VARCHAR(45) NULL,
  `erf_module_id` VARCHAR(45) NULL,
  PRIMARY KEY (`screen_id`));

ALTER TABLE `wfm_user`.`screen` 
CHANGE COLUMN `erf_module_id` `erf_module_id` INT NULL DEFAULT NULL ;

ALTER TABLE `wfm_user`.`screen` 
ADD CONSTRAINT `FK_Module`
  FOREIGN KEY (`erf_module_id`)
  REFERENCES `wfm_user`.`module` (`module_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `wfm_user`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email_id` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`));

CREATE TABLE `wfm_user`.`user_roles` (
  `user_role_id` INT NOT NULL,
  `user_role_name` VARCHAR(45) NULL,
  `user_role_description` VARCHAR(45) NULL,
  `product_id` VARCHAR(45) NULL,
  PRIMARY KEY (`user_role_id`));

CREATE TABLE `wfm_user`.`user_to_role` (
  `user_to_role_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `user_role_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_to_role_id`));

CREATE TABLE `wfm_user`.`role_to_module` (
  `role_to_module_id` INT NOT NULL AUTO_INCREMENT,
  `role_id` VARCHAR(45) NULL,
  `module_id` VARCHAR(45) NULL,
  PRIMARY KEY (`role_to_module_id`));
  
  CREATE TABLE `wfm_user`.`screen_access` (
    `screen_access_id` INT NOT NULL AUTO_INCREMENT,
    `screen_id` VARCHAR(45) NULL,
    `access` VARCHAR(45) NULL,
    PRIMARY KEY (`screen_access_id`));

CREATE TABLE `wfm_user`.`role_to_screen_access` (
  `role_to_screen_access_id` INT NOT NULL AUTO_INCREMENT,
  `erf_role_id` VARCHAR(45) NULL,
  `erf_screen_access_id` VARCHAR(45) NULL,
  PRIMARY KEY (`role_to_screen_access_id`));

ALTER TABLE `wfm_user`.`role_to_screen_access` 
CHANGE COLUMN `erf_role_id` `erf_role_id` INT NULL DEFAULT NULL ,
CHANGE COLUMN `erf_screen_access_id` `erf_screen_access_id` INT NULL DEFAULT NULL ,
ADD INDEX `FK_role_idx` (`erf_role_id` ASC) VISIBLE,
ADD INDEX `FK_role_screen_idx` (`erf_screen_access_id` ASC) VISIBLE;
;
ALTER TABLE `wfm_user`.`role_to_screen_access` 
ADD CONSTRAINT `FK_role`
  FOREIGN KEY (`erf_role_id`)
  REFERENCES `wfm_user`.`user_roles` (`user_role_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `FK_role_screen`
  FOREIGN KEY (`erf_screen_access_id`)
  REFERENCES `wfm_user`.`screen_access` (`screen_access_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `wfm_user`.`user` 
ADD COLUMN `erf_company_id` VARCHAR(45) NULL AFTER `email_id`;

ALTER TABLE `wfm_user`.`user` 
ADD COLUMN `phone_number` VARCHAR(45) NULL AFTER `erf_company_id`;

ALTER TABLE `wfm_user`.`user` 
ADD COLUMN `status` VARCHAR(45) NULL AFTER `phone_number`;

ALTER TABLE `wfm_user`.`user` 
ADD COLUMN `created_by` VARCHAR(45) NULL AFTER `status`,
ADD COLUMN `created_date` DATETIME NULL AFTER `created_by`,
ADD COLUMN `updated_by` VARCHAR(45) NULL AFTER `created_date`,
ADD COLUMN `updated_date` DATETIME NULL AFTER `updated_by`;

ALTER TABLE `wfm_user`.`module` 
ADD COLUMN `erf_product_id` INT NULL AFTER `module_description`;

ALTER TABLE `wfm_user`.`user_roles` 
RENAME TO  `wfm_user`.`user_role` ;

ALTER TABLE `wfm_user`.`user_role` 
CHANGE COLUMN `product_id` `erf_product_id` INT NULL DEFAULT NULL ;

ALTER TABLE `wfm_user`.`user_to_role` 
CHANGE COLUMN `user_role_id` `user_role_id` INT NOT NULL ;

ALTER TABLE `wfm_user`.`user_to_role` 
ADD INDEX `Fk_user_role_idx` (`user_role_id` ASC) VISIBLE,
ADD INDEX `Fk_user_idx` (`user_id` ASC) VISIBLE;
;
ALTER TABLE `wfm_user`.`user_to_role` 
ADD CONSTRAINT `Fk_user_role`
  FOREIGN KEY (`user_role_id`)
  REFERENCES `wfm_user`.`user_role` (`user_role_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `Fk_user`
  FOREIGN KEY (`user_id`)
  REFERENCES `wfm_user`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  ALTER TABLE `wfm_user`.`screen_access` 
CHANGE COLUMN `screen_id` `screen_id` INT NULL DEFAULT NULL ;

ALTER TABLE `wfm_user`.`role_to_module` 
CHANGE COLUMN `role_id` `role_id` INT NULL DEFAULT NULL ,
CHANGE COLUMN `module_id` `module_id` INT NULL DEFAULT NULL ;

ALTER TABLE `wfm_user`.`role_to_screen_access` 
DROP FOREIGN KEY `FK_role`;
ALTER TABLE `wfm_user`.`role_to_screen_access` 
ADD CONSTRAINT `FK_role`
  FOREIGN KEY (`erf_role_id`)
  REFERENCES `wfm_user`.`user_role` (`user_role_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  ALTER TABLE `wfm_user`.`role_to_screen_access` 
DROP FOREIGN KEY `FK_role`;
ALTER TABLE `wfm_user`.`role_to_screen_access` 
DROP INDEX `FK_role_idx` ;
;

ALTER TABLE `wfm_user`.`user_role` 
CHANGE COLUMN `user_role_id` `user_role_id` INT NOT NULL AUTO_INCREMENT ;

ALTER TABLE `wfm_user`.`user_to_role` 
DROP FOREIGN KEY `Fk_user_role`;
ALTER TABLE `wfm_user`.`user_to_role` 
DROP INDEX `Fk_user_role_idx` ;
;

ALTER TABLE `wfm_user`.`user_role` 
ADD COLUMN `erf_user_id` INT NULL AFTER `erf_product_id`,
CHANGE COLUMN `erf_product_id` `erf_product_id` INT NULL DEFAULT NULL AFTER `user_role_id`;

ALTER TABLE `wfm_user`.`user_role` 
ADD INDEX `FK_user_id_idx` (`erf_user_id` ASC) VISIBLE;
;
ALTER TABLE `wfm_user`.`user_role` 
ADD CONSTRAINT `FK_user_id`
  FOREIGN KEY (`erf_user_id`)
  REFERENCES `wfm_user`.`user` (`user_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `wfm_user`.`screen_access` 
CHANGE COLUMN `screen_id` `erf_screen_id` INT NULL DEFAULT NULL ;

ALTER TABLE `wfm_user`.`screen_access` 
ADD INDEX `FK_Screen_id_idx` (`erf_screen_id` ASC) VISIBLE;
;
ALTER TABLE `wfm_user`.`screen_access` 
ADD CONSTRAINT `FK_Screen_id`
  FOREIGN KEY (`erf_screen_id`)
  REFERENCES `wfm_user`.`screen` (`screen_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `wfm_user`.`user_role` 
DROP FOREIGN KEY `FK_user_id`;
ALTER TABLE `wfm_user`.`user_role` 
DROP COLUMN `erf_user_id`,
DROP INDEX `FK_user_id_idx` ;
;
 
ALTER TABLE `wfm_user`.`user_to_role` 
DROP FOREIGN KEY `Fk_user`;
ALTER TABLE `wfm_user`.`user_to_role` 
CHANGE COLUMN `user_id` `erf_user_id` INT NOT NULL ,
CHANGE COLUMN `user_role_id` `erf_user_role_id` INT NOT NULL ;
ALTER TABLE `wfm_user`.`user_to_role` 
ADD CONSTRAINT `Fk_user`
  FOREIGN KEY (`erf_user_id`)
  REFERENCES `wfm_user`.`user` (`user_id`);

ALTER TABLE `wfm_user`.`user_to_role` 
ADD INDEX `FK_user_role_id_idx` (`erf_user_role_id` ASC) VISIBLE;
;
ALTER TABLE `wfm_user`.`user_to_role` 
ADD CONSTRAINT `FK_user_role_id`
  FOREIGN KEY (`erf_user_role_id`)
  REFERENCES `wfm_user`.`user_role` (`user_role_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `wfm_user`.`role_to_module` 
CHANGE COLUMN `role_id` `erf_role_id` INT NULL DEFAULT NULL ,
CHANGE COLUMN `module_id` `erf_module_id` INT NULL DEFAULT NULL ;

CREATE TABLE `wfm_user`.`refreshtoken` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `refresh_token` VARCHAR(45) NULL,
  `erf_user_id` INT NULL,
  `expiry_date` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_user_id_idx` (`erf_user_id` ASC) VISIBLE,
  CONSTRAINT `FK_user_id`
    FOREIGN KEY (`erf_user_id`)
    REFERENCES `wfm_user`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    CREATE TABLE `wfm_user`.`authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `wfm_user`.`users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `wfm_user`.`users` (`username`,`password`,`enabled`) VALUES ('bala','test123',1);
INSERT INTO `wfm_user`.`users` (`username`,`password`,`enabled`) VALUES ('mani','test123',1);

INSERT INTO `wfm_user`.`authorities`(`username`,`authority`) VALUES ('bala','ROLE_SUPERVISOR');
INSERT INTO `wfm_user`.`authorities` (`username`,`authority`) VALUES ('mani','ROLE_MANAGER');  

INSERT INTO `wfm_user`.`user` (`user_id`,`user_name`,`first_name`,`last_name`,`password`,`email_id`,`erf_company_id`,`phone_number`,`status`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (11,'mkbala123','muthu karthik bala','manikandan','test123','mkbala.krishnan@gmail.com','100','9789066952','Active',NULL,'2021-10-04 13:14:56',NULL,'2021-10-04 13:14:56');
INSERT INTO `wfm_user`.`user` (`user_id`,`user_name`,`first_name`,`last_name`,`password`,`email_id`,`erf_company_id`,`phone_number`,`status`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (12,'mani123','manikandan','ramasamy','test123456789','mkbala.krishnan@gmail.com','100','9789066952','Active',NULL,'2021-10-04 13:15:42',NULL,'2021-10-04 13:15:42');
INSERT INTO `wfm_user`.`user` (`user_id`,`user_name`,`first_name`,`last_name`,`password`,`email_id`,`erf_company_id`,`phone_number`,`status`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES (13,'bhupesh123','manikandan','ramasamy','test123','mkbala.krishnan@gmail.com','100','9789066952','Active',NULL,'2021-10-05 17:57:27',NULL,'2021-10-05 17:57:27');
