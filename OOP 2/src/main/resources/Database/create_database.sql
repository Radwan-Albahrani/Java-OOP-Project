DROP Database if exists informationsystem;
CREATE database informationsystem;
USE informationsystem;

CREATE TABLE User (
    UserID varchar(255) PRIMARY KEY,
    Username VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Type ENUM('Admin', 'Instructor', 'Student') NOT NULL,
    status ENUM("Inactive", "Active")
);

CREATE TABLE Profile (
    UserID varchar(255) PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    Sex ENUM("M", "F") NOT NULL,
    Birthdate DATE NOT NULL,
    Major VARCHAR(255) NOT NULL,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);

CREATE TABLE WorkContactDetails (
    UserID varchar(255) PRIMARY KEY,
    Email VARCHAR(255) NOT NULL,
    Phone VARCHAR(255) NOT NULL,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);

CREATE TABLE PersonalContactDetails (
    UserID varchar(255) PRIMARY KEY,
    Email VARCHAR(255) NOT NULL UNIQUE,
    Phone VARCHAR(255),
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);

CREATE TABLE Admins (
    AdminID VARCHAR(255) PRIMARY KEY,
    UserID varchar(255) NOT NULL,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);

CREATE TABLE Instructors (
    InstructorID VARCHAR(255) PRIMARY KEY,
    UserID varchar(255) NOT NULL,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);

CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    UserID varchar(255) NOT NULL,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);


CREATE TABLE Courses (
    CourseID INT PRIMARY KEY,
    CourseName VARCHAR(255) NOT NULL,
    CreditHours INT NOT NULL,
    MaxCap INT NOT NULL,
    InstructorID VARCHAR(255) NOT NULL,
    FOREIGN KEY (InstructorID) REFERENCES Instructors(InstructorID)
);

CREATE TABLE StudentCourses (
    StudID INT NOT NULL,
    CourseID INT NOT NULL,
    QuizGrade FLOAT NOT NULL,
    MidtermGrade FLOAT NOT NULL,
    FinalGrade FLOAT NOT NULL,
    ProjectGrade FLOAT NOT NULL,
    TotalGrade FLOAT NOT NULL,
    PRIMARY KEY (StudID, CourseID),
    FOREIGN KEY (StudID) REFERENCES Students(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);



CREATE TABLE Announcements (
    AnnouncementID INT PRIMARY KEY,
    Announcement VARCHAR(255) NOT NULL,
    CourseID INT NOT NULL,
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);

CREATE TABLE Alerts (
    AlertID INT PRIMARY KEY,
    Alert VARCHAR(255) NOT NULL
);

CREATE TABLE ViewAlerts (
    Type ENUM('Admin') NOT NULL,
    AlertID INT NOT NULL,
	PRIMARY KEY (Type, AlertID),
	FOREIGN KEY (AlertID) REFERENCES Alerts(AlertID)
);

CREATE INDEX type_index ON User(Type);

ALTER TABLE ViewAlerts
ADD FOREIGN KEY (Type) REFERENCES User(Type) ON DELETE CASCADE;

ALTER TABLE  Admins
ADD FOREIGN KEY (UserID) REFERENCES User(UserID) ON DELETE CASCADE;

ALTER TABLE  Students
ADD FOREIGN KEY (UserID) REFERENCES User(UserID) ON DELETE CASCADE;

ALTER TABLE  WorkContactDetails
ADD FOREIGN KEY (UserID) REFERENCES User(UserID) ON DELETE CASCADE;

ALTER TABLE  PersonalContactDetails
ADD FOREIGN KEY (UserID) REFERENCES User(UserID) ON DELETE CASCADE;

ALTER TABLE  Profile
ADD FOREIGN KEY (UserID) REFERENCES User(UserID) ON DELETE CASCADE;

ALTER TABLE  Courses
ADD FOREIGN KEY (InstructorID) REFERENCES Instructors(InstructorID) ON DELETE CASCADE;

ALTER TABLE  StudentCourses
ADD FOREIGN KEY (StudID) REFERENCES Students(StudentID) ON DELETE CASCADE;

ALTER TABLE  Announcements
ADD FOREIGN KEY (CourseID) REFERENCES Courses(CourseID) ON DELETE CASCADE;

DELIMITER $$
CREATE TRIGGER calculate_total_grade_insert
BEFORE INSERT ON StudentCourses
FOR EACH ROW
BEGIN
    SET NEW.TotalGrade = NEW.QuizGrade + NEW.MidtermGrade + NEW.FinalGrade + NEW.ProjectGrade;
END$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER calculate_total_grade_update
BEFORE UPDATE ON StudentCourses
FOR EACH ROW
BEGIN
    SET NEW.TotalGrade = NEW.QuizGrade + NEW.MidtermGrade + NEW.FinalGrade + NEW.ProjectGrade;
END$$
DELIMITER ;

ALTER TABLE StudentCourses
ADD CONSTRAINT quiz_grade_check CHECK (QuizGrade >= 0 AND QuizGrade <= 10),
ADD CONSTRAINT midterm_grade_check CHECK (MidtermGrade >= 0 AND MidtermGrade <= 20),
ADD CONSTRAINT final_grade_check CHECK (FinalGrade >= 0 AND FinalGrade <= 40),
ADD CONSTRAINT project_grade_check CHECK (ProjectGrade >= 0 AND ProjectGrade <= 30),
ADD CONSTRAINT total_grade_check CHECK (TotalGrade <= 100);

DELIMITER $$
CREATE PROCEDURE generate_user_id(IN username varchar(255), IN password varchar(255), IN type ENUM('Admin','Instructor','Student'))
BEGIN
    DECLARE last_id INT;
    SET @last_id = (SELECT MAX(UserID) FROM User);
    SET @last_id = @last_id + 1;
    SET @year = YEAR(CURRENT_DATE);
    SET @custom_id = CONCAT(LEFT(CONCAT(@year,''),1), RIGHT(CONCAT(@year,''),2), LPAD(@last_id, 7, '0'));
    INSERT INTO User (UserID, Username, Password, Type) VALUES (@custom_id, username, password, type);
END $$
DELIMITER ;




