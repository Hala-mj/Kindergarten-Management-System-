-- Kindergarten Management System - MySQL schema
-- Based on the project's original projectAI.sql (table definitions), with
-- demo rows matching the sample accounts in data/.

CREATE DATABASE IF NOT EXISTS `projectai`;
USE `projectai`;

-- Tasks assigned by a teacher to a child (entity: project.Task)
CREATE TABLE IF NOT EXISTS `task` (
    `chid`   INT NOT NULL,        -- child ID
    `title`  VARCHAR(45) NULL,
    `sub`    VARCHAR(45) NULL,    -- subject
    `target` VARCHAR(45) NULL,    -- target skill
    `tasks`  VARCHAR(45) NULL,
    PRIMARY KEY (`chid`)
);

-- Daily behaviour ratings recorded by a teacher (entity: project.Behavior)
CREATE TABLE IF NOT EXISTS `Behavior` (
    `chname`        VARCHAR(45) NOT NULL,   -- child name
    `subname`       VARCHAR(45) NULL,
    `day`           VARCHAR(45) NULL,
    `date`          VARCHAR(45) NULL,
    `respect`       INT,
    `active`        INT,
    `focus`         INT,
    `collaboration` INT,
    PRIMARY KEY (`chname`)
);

-- Demo rows (teacher screens update existing rows)
INSERT INTO `task` (`chid`, `title`, `sub`, `target`, `tasks`) VALUES
    (1, 'Letters', 'Arabic', 'Reading', 'Trace the letters A-D'),
    (2, 'Numbers', 'Math', 'Counting', 'Count to 10');

INSERT INTO `Behavior` (`chname`, `subname`, `day`, `date`, `respect`, `active`, `focus`, `collaboration`) VALUES
    ('Omar', 'Arabic', 'Sunday', '2024-01-14', 3, 3, 2, 3),
    ('Lina', 'Math',   'Sunday', '2024-01-14', 3, 2, 3, 3);
