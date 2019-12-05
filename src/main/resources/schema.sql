
CREATE TABLE TEACHERS (
  teacherId INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR NOT NULL
);
  

CREATE TABLE COURSES (
  courseId      INT PRIMARY KEY AUTO_INCREMENT,
  title   		VARCHAR NOT NULL,
  level			VARCHAR NOT NULL DEFAULT 'Principiante' CHECK level in ('Principiante', 'Intermedio', 'Avanzado'),
  hours		   	INT,
  teacherId		INT NOT NULL,
  active		BOOLEAN DEFAULT FALSE
);


ALTER TABLE COURSES 
ADD FOREIGN KEY (teacherId) 
REFERENCES TEACHERS(teacherId);