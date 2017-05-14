
CREATE DATABASE kmp;
USE kmp;
SET FOREIGN_KEY_CHECKS=0;
CREATE TABLE kmp_questions_category(
  id INTEGER NOT NULL auto_increment,
  version INTEGER NOT NULL DEFAULT 0,
  name VARCHAR(8),
  description MEDIUMTEXT,
  created_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
 )ENGINE=InnoDB;
 
CREATE TABLE kmp_questions_type(
  id INTEGER NOT NULL auto_increment,
  version INTEGER NOT NULL DEFAULT 0,
  name VARCHAR(8),
  description VARCHAR(255),
  created_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
 )ENGINE=InnoDB;
 
 CREATE TABLE kmp_questions_question(
  id INTEGER NOT NULL,
  q_no INTEGER NOT NULL,
  text MEDIUMTEXT,
  category_id INTEGER,
  type_id INTEGER,
  image BLOB,
  created_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  KEY(category_id),
  KEY(type_id),
  PRIMARY KEY (id),
  FOREIGN KEY fk_question_to_category(category_id) REFERENCES kmp_questions_category(id),
  FOREIGN KEY fk_question_to_type(type_id) REFERENCES kmp_questions_type(id)
)ENGINE=InnoDB;

CREATE TABLE kmp_questions_option(
  id INTEGER NOT NULL auto_increment,
  name VARCHAR(8),
  text MEDIUMTEXT,
  question_id INTEGER NOT NULL,
  created_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  KEY(question_id),
  PRIMARY KEY (id),
  FOREIGN KEY fk_type_to_question(question_id) REFERENCES kmp_questions_question(id)
)ENGINE=InnoDB;

CREATE TABLE kmp_questions_answer(
  id INTEGER NOT NULL auto_increment,
  option_id INTEGER,
  text MEDIUMTEXT,
  question_id INTEGER NOT NULL,
  created_ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  KEY(question_id),
  KEY(option_id),
  PRIMARY KEY (id),
  FOREIGN KEY fk_answer_to_option(option_id) REFERENCES kmp_questions_option(id),
  FOREIGN KEY fk_answer_to_question(question_id) REFERENCES kmp_questions_question(id)
)ENGINE=InnoDB;
-- Question Type
INSERT INTO kmp_questions_type(
   id,name,description,created_ts) VALUES
   (1,'cpp','C Plus Plus Programming',now()),
   (2,'java','Java Programming',now()),
   (3,'design','Design Patterns/principles, Architectral patterns/principles',now()),
   (4,'db','Relational Database Management System, SQL',now()),
   (5,'os','Linux/Unix Operating system',now());  
   
-- Question category
INSERT INTO kmp_questions_category (id, name, description, created_ts)VALUES
('1','CS','Classes and Structures',now()),
('2','DPT','Object Oriented Design Patterns',now()),
('3','DBMS','Database Management System',now()),
('4','DGN','Software Design',now()),
('5','OS','Operating System(Unix)',now()),
('6','DPP','Object Oriented Design Principles',now()),
('7','IP','Inheritance and Polymorphism',now()),
('8','IO','Input/Output and Files',now()),
('9','FSP','Functions and Static Polymorphism',now()),
('10','PKG','Package',now()),
('11','OOTCF','Operator Overloading and Type Conversion Functions',now()),
('12','N','Namespace',now()),
('13','DS','Data Structure',now()),
('14','GT','Generic Types',now()),
('15','APT','Architectural Patterns',now()),
('16','MT','Multithreading',now()),
('17','TLT','Template',now()),
('18','DTOPCS','Data Types, Operators and Control Structures',now()),
('19','AI','Abstraction and Interfaces',now()),
('20','RTTI','Run Time Type Information',now()),
('21','FCT','Functions and Class Templates',now()),
('22','JC','Java Collections',now()),
('23','EDH','Encapsulation and Data Hiding',now()),
('24','IDP','Inheritance and Dynamic Polymorphism',now()),
('25','JAVA','Java Programming',now()),
('26','STL','Standard Template Library',now()),
('27','OOP','Object Oriented Programming',now()),
('28','EH','Exception Handling',now());