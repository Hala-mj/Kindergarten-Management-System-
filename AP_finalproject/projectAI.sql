CREATE SCHEMA `projectai` ;
CREATE DATABASE IF NOT EXISTS `task` ;
USE task;
CREATE TABLE `projectai`.`task` (
    `chid` INT NOT NULL,
    `title` VARCHAR(45) NULL,
    `sub` VARCHAR(45) NULL,
    `target` VARCHAR(45) NULL,
    `tasks` VARCHAR(45) NULL,
    PRIMARY KEY (`chid`)
);
  
INSERT INTO `projectai`.`task` (`chid`, `title`, `sub`, `target`, `tasks`) VALUES ('0101', 'hm', 'hm', 'hm', 'hm');
INSERT INTO `projectai`.`task` (`chid`, `title`, `sub`, `target`, `tasks`) VALUES ('0102', 'hm', 'hm', 'hm', 'hm');
INSERT INTO `projectai`.`task` (`chid`, `title`, `sub`, `target`, `tasks`) VALUES ('0103', 'hm', 'hm', 'hm', 'hm');
INSERT INTO `projectai`.`task` (`chid`, `title`, `sub`, `target`, `tasks`) VALUES ('0104', 'hm', 'hm', 'hm', 'hm');
INSERT INTO `projectai`.`task` (`chid`, `title`, `sub`, `target`, `tasks`) VALUES ('0105', 'hm', 'hm', 'hm', 'hm');
INSERT INTO `projectai`.`task` (`chid`, `title`, `sub`, `target`, `tasks`) VALUES ('0106', 'hm', 'hm', 'hm', 'hm');
INSERT INTO `projectai`.`task` (`chid`, `title`, `sub`, `target`, `tasks`) VALUES ('0107', 'hm', 'hm', 'hm', 'hm');
INSERT INTO `projectai`.`task` (`chid`, `title`, `sub`, `target`, `tasks`) VALUES ('0108', 'hm', 'hm', 'hm', 'hm');
INSERT INTO `projectai`.`task` (`chid`, `title`, `sub`, `target`, `tasks`) VALUES ('0109', 'hm', 'hm', 'hm', 'hm');
INSERT INTO `projectai`.`task` (`chid`, `title`, `sub`, `target`, `tasks`) VALUES ('0110', 'hm', 'hm', 'hm', 'hm');
UPDATE `projectai`.`task` 
SET 
    `chid` = '0101'
WHERE
    (`chid` = '101');
UPDATE `projectai`.`task` 
SET 
    `chid` = '0102'
WHERE
    (`chid` = '102');
UPDATE `projectai`.`task` 
SET 
    `chid` = '0103'
WHERE
    (`chid` = '103');
UPDATE `projectai`.`task` 
SET 
    `chid` = '0104'
WHERE
    (`chid` = '104');
UPDATE `projectai`.`task` 
SET 
    `chid` = '0105'
WHERE
    (`chid` = '105');
UPDATE `projectai`.`task` 
SET 
    `chid` = '0106'
WHERE
    (`chid` = '106');
UPDATE `projectai`.`task` 
SET 
    `chid` = '0107'
WHERE
    (`chid` = '107');
UPDATE `projectai`.`task` 
SET 
    `chid` = '0108'
WHERE
    (`chid` = '108');
UPDATE `projectai`.`task` 
SET 
    `chid` = '0109'
WHERE
    (`chid` = '109');
UPDATE `projectai`.`task` 
SET 
    `chid` = '0110'
WHERE
    (`chid` = '110');

USE task;
CREATE TABLE `projectai`.`Behavior` (
    `chname` VARCHAR(45) NOT NULL,
    
    `subname` VARCHAR(45) NULL,
    `day` VARCHAR(45) NULL,
    `date` VARCHAR(45) NULL,
    `respect` INT,
    `active` INT,
    `focus` INT,
    `collaboration` INT,
    PRIMARY KEY (`chname`)
);

INSERT INTO `projectai`.`Behavior` (`chname`, `subname`, `day`, `date`, `respect`, `active`, `focus`, `collaboration`) VALUES ('Renad', 'w', 'w', 'w', '1', '1', '1', '1');
INSERT INTO `projectai`.`Behavior` (`chname`, `subname`, `day`, `date`, `respect`, `active`, `focus`, `collaboration`) VALUES ('Mohamed', 'w', 'w', 'w', '1', '1', '1', '1');
INSERT INTO `projectai`.`Behavior` (`chname`, `subname`, `day`, `date`, `respect`, `active`, `focus`, `collaboration`) VALUES ('Rana', 'w', 'w', 'ww', '1', '1', '1', '1');
INSERT INTO `projectai`.`Behavior` (`chname`, `subname`, `day`, `date`, `respect`, `active`, `focus`, `collaboration`) VALUES ('Khalid', 'w', 'w', 'w', '1', '1', '1', '1');
INSERT INTO `projectai`.`Behavior` (`chname`, `subname`, `day`, `date`, `respect`, `active`, `focus`, `collaboration`) VALUES ('Rawan', 'w', 'w', 'w', '1', '1', '1', '11');
INSERT INTO `projectai`.`Behavior` (`chname`, `subname`, `day`, `date`, `respect`, `active`, `focus`, `collaboration`) VALUES ('Sami', 'w', 'w', 'w', '1', '1', '1', '1');
INSERT INTO `projectai`.`Behavior` (`chname`, `subname`, `day`, `date`, `respect`, `active`, `focus`, `collaboration`) VALUES ('Reem', 'w', 'ww', 'w', '11', '1', '1', '1');
INSERT INTO `projectai`.`Behavior` (`chname`, `subname`, `day`, `date`, `respect`, `active`, `focus`, `collaboration`) VALUES ('Yazan', 'w', 'w', 'w', '1', '1', '1', '1');
INSERT INTO `projectai`.`Behavior` (`chname`, `subname`, `day`, `date`, `respect`, `active`, `focus`, `collaboration`) VALUES ('Maya', 'w', 'w', 'w', '11', '1', '1', '1');
INSERT INTO `projectai`.`Behavior` (`chname`, `subname`, `day`, `date`, `respect`, `active`, `focus`, `collaboration`) VALUES ('Wisam', 'w', 'w', 'w', '1', '1', '1', '1');



