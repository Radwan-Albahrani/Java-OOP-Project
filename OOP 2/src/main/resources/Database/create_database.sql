DROP Database if exists informationsystem;
CREATE database informationsystem;
USE informationsystem;

CREATE TABLE User (
    UserID varchar(255) PRIMARY KEY,
    Username VARCHAR(255) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL,
    Type ENUM('Admin', 'Instructor', 'Student') NOT NULL,
    status ENUM("Inactive", "Active")
);

CREATE TABLE Profile (
    UserID varchar(255) PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    Sex ENUM("Male", "Female") NOT NULL,
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
    StudentID varchar(255) PRIMARY KEY,
    UserID varchar(255) NOT NULL,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);


CREATE TABLE Courses (
    CourseID  VARCHAR(10) PRIMARY KEY,
    CourseName VARCHAR(255) NOT NULL,
    CreditHours INT NOT NULL,
    MaxCap INT NOT NULL,
    InstructorID VARCHAR(255),
    FOREIGN KEY (InstructorID) REFERENCES Instructors(InstructorID)
);

CREATE TABLE StudentCourses (
    StudID VARCHAR(255) NOT NULL,
    CourseID VARCHAR(10) NOT NULL,
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
    CourseID VARCHAR(10) NOT NULL,
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
CREATE PROCEDURE generate_user(IN username varchar(255), IN password varchar(255), IN type ENUM('Admin','Instructor','Student'), IN firstName VARCHAR(255), IN lastName VARCHAR(255), IN sex ENUM('Male','Female','Other'), IN birthdate DATE, IN major VARCHAR(255), IN email VARCHAR(255), IN phone VARCHAR(255), IN personalEmail VARCHAR(255))
BEGIN
    DECLARE last_id INT;
    SET @last_id = (SELECT COALESCE(MAX(SUBSTR(UserID, -7)), 0) FROM User);
    SET @last_id = @last_id + 1;
    SET @year = YEAR(CURRENT_DATE);
    SET @custom_id = CONCAT(LEFT(CONCAT(@year,''),1), RIGHT(CONCAT(@year,''),2), LPAD(@last_id, 7, '0'));
    INSERT INTO User (UserID, Username, Password, Type, Status) VALUES (@custom_id, username, password, type, "Inactive");
    INSERT INTO Profile (UserID,FirstName, LastName,Sex, Birthdate,Major) VALUES (@custom_id, firstName, lastName,sex, birthdate, major);
    INSERT INTO WorkContactDetails (UserID, Email, Phone) VALUES (@custom_id, email, phone);
    INSERT INTO PersonalContactDetails (UserID, Email) VALUES (@custom_id, personalEmail);
    IF type='Admin' THEN
        INSERT INTO Admins (AdminID, UserID) VALUES (@custom_id, @custom_id);
    ELSEIF type='Instructor' THEN
        INSERT INTO Instructors (InstructorID, UserID) VALUES (@custom_id, @custom_id);
    ELSEIF type='Student' THEN
        INSERT INTO Students (StudentID, UserID) VALUES (@custom_id, @custom_id);
    END IF;
END $$
DELIMITER ;

CREATE VIEW `View All Admin` AS
SELECT User.UserID, Profile.FirstName, Profile.LastName, Profile.Sex, Profile.Birthdate, Profile.Major, WorkContactDetails.Email, workcontactdetails.Phone, personalcontactdetails.Email as "Personal Email"
FROM User
JOIN Profile ON User.UserID = Profile.UserID
JOIN WorkContactDetails ON User.UserID = WorkContactDetails.UserID
JOIN PersonalContactDetails ON User.UserID = PersonalContactDetails.UserID
Where user.Type = "Admin";

CREATE VIEW `View All Admin Full` AS
SELECT User.UserID, User.Username, User.Type, Profile.FirstName, Profile.LastName, Profile.Sex, Profile.Birthdate, Profile.Major, WorkContactDetails.Email, workcontactdetails.Phone, personalcontactdetails.Email as "Personal Email", personalcontactdetails.Phone as "Personal Phone", User.Status
FROM User
JOIN Profile ON User.UserID = Profile.UserID
JOIN WorkContactDetails ON User.UserID = WorkContactDetails.UserID
JOIN PersonalContactDetails ON User.UserID = PersonalContactDetails.UserID
Where user.Type = "Admin";

CREATE VIEW `View All Student` AS
SELECT User.UserID, Profile.FirstName, Profile.LastName, Profile.Sex, Profile.Birthdate, Profile.Major, WorkContactDetails.Email, workcontactdetails.Phone, personalcontactdetails.Email as "Personal Email"
FROM User
JOIN Profile ON User.UserID = Profile.UserID
JOIN WorkContactDetails ON User.UserID = WorkContactDetails.UserID
JOIN PersonalContactDetails ON User.UserID = PersonalContactDetails.UserID
Where user.Type = "Student";

CREATE VIEW `View All Student Full` AS
SELECT User.UserID, User.Username, User.Type, Profile.FirstName, Profile.LastName, Profile.Sex, Profile.Birthdate, Profile.Major, WorkContactDetails.Email, workcontactdetails.Phone, personalcontactdetails.Email as "Personal Email", personalcontactdetails.Phone as "Personal Phone", User.Status
FROM User
JOIN Profile ON User.UserID = Profile.UserID
JOIN WorkContactDetails ON User.UserID = WorkContactDetails.UserID
JOIN PersonalContactDetails ON User.UserID = PersonalContactDetails.UserID
Where user.Type = "Student";

CREATE VIEW `View All Instructor` AS
SELECT User.UserID, Profile.FirstName, Profile.LastName, Profile.Sex, Profile.Birthdate, Profile.Major, WorkContactDetails.Email, workcontactdetails.Phone, personalcontactdetails.Email as "Personal Email"
FROM User
JOIN Profile ON User.UserID = Profile.UserID
JOIN WorkContactDetails ON User.UserID = WorkContactDetails.UserID
JOIN PersonalContactDetails ON User.UserID = PersonalContactDetails.UserID
Where user.Type = "Instructor";

CREATE VIEW `View All Instructor Full` AS
SELECT User.UserID, User.Username, User.Type, Profile.FirstName, Profile.LastName, Profile.Sex, Profile.Birthdate, Profile.Major, WorkContactDetails.Email, workcontactdetails.Phone, personalcontactdetails.Email as "Personal Email", personalcontactdetails.Phone as "Personal Phone", User.Status
FROM User
JOIN Profile ON User.UserID = Profile.UserID
JOIN WorkContactDetails ON User.UserID = WorkContactDetails.UserID
JOIN PersonalContactDetails ON User.UserID = PersonalContactDetails.UserID
Where user.Type = "Instructor";

CREATE VIEW `View All Users` AS
SELECT User.UserID, Profile.FirstName, Profile.LastName, Profile.Sex, Profile.Birthdate, Profile.Major, WorkContactDetails.Email, workcontactdetails.Phone
FROM User
JOIN Profile ON User.UserID = Profile.UserID
JOIN WorkContactDetails ON User.UserID = WorkContactDetails.UserID
JOIN PersonalContactDetails ON User.UserID = PersonalContactDetails.UserID;

CREATE VIEW `View All Users Full` AS
SELECT User.UserID, User.Username, User.Type, Profile.FirstName, Profile.LastName, Profile.Sex, Profile.Birthdate, Profile.Major, WorkContactDetails.Email, workcontactdetails.Phone, personalcontactdetails.Email as "Personal Email", personalcontactdetails.Phone as "Personal Phone", User.Status
FROM User
JOIN Profile ON User.UserID = Profile.UserID
JOIN WorkContactDetails ON User.UserID = WorkContactDetails.UserID
JOIN PersonalContactDetails ON User.UserID = PersonalContactDetails.UserID;

CREATE VIEW `View All Inactive Users` AS
SELECT User.UserID, User.Username, User.Type, Profile.FirstName, Profile.LastName, Profile.Sex, Profile.Birthdate, Profile.Major, WorkContactDetails.Email, workcontactdetails.Phone, User.Status
FROM User
JOIN Profile ON User.UserID = Profile.UserID
JOIN WorkContactDetails ON User.UserID = WorkContactDetails.UserID
JOIN PersonalContactDetails ON User.UserID = PersonalContactDetails.UserID
WHERE User.Status = "Inactive";

CREATE VIEW `View All Active Users` AS
SELECT User.UserID, User.Username, User.Type, Profile.FirstName, Profile.LastName, Profile.Sex, Profile.Birthdate, Profile.Major, WorkContactDetails.Email, workcontactdetails.Phone, User.Status
FROM User
JOIN Profile ON User.UserID = Profile.UserID
JOIN WorkContactDetails ON User.UserID = WorkContactDetails.UserID
JOIN PersonalContactDetails ON User.UserID = PersonalContactDetails.UserID
WHERE User.Status = "Active";
 
 
## ----------------------Testing Dummy Data-------------------------------------
CALL generate_user('admin0', 'admin0', 'Admin', 'admin0FirstName', 'admin0LastName', 'Male', '1999-01-01', 'testing', 'admin0@university.com', '0', 'admin0@gmail.com');
CALL generate_user('admin1', 'admin1', 'Admin', 'admin1FirstName', 'admin1LastName', 'Male', '1999-01-01', 'testing', 'admin1@university.com', '0', 'admin1@gmail.com');

CALL generate_user('instructor0', 'Instructor', 'Instructor', 'instructor0FirstName', 'instructor0LastName', 'Male', '1999-01-01', 'testing', 'instructor0@university.com', '1', 'instructor0@gmail.com');
CALL generate_user('instructor1', 'Instructor', 'Instructor', 'instructor1FirstName', 'instructor1LastName', 'Male', '1999-01-01', 'testing', 'instructor1@university.com', '1', 'instructor1@gmail.com');

CALL generate_user('student0', 'student0', 'Student', 'student0FirstName', 'student0LastName', 'Male', '1999-01-01', 'testing', 'student0@university.com', '2', 'student0@gmail.com');
CALL generate_user('student1', 'student1', 'Student', 'student1FirstName', 'student1LastName', 'Male', '1999-01-01', 'testing', 'student1@university.com', '2', 'student1@gmail.com');

INSERT INTO courses
VALUES('CS111', 'CS', '3', '30', '2230000003');
INSERT INTO courses
VALUES('Math111', 'Math', '2', '29', '2230000004');

INSERT INTO studentcourses(StudID, CourseID, QuizGrade, MidtermGrade, FinalGrade, ProjectGrade)
VALUES('2230000005', 'CS111', 10, 10, 10, 10);
INSERT INTO studentcourses(StudID, CourseID, QuizGrade, MidtermGrade, FinalGrade, ProjectGrade)
VALUES('2230000005', 'Math111', 10, 10, 10, 10);
INSERT INTO studentcourses(StudID, CourseID, QuizGrade, MidtermGrade, FinalGrade, ProjectGrade)
VALUES('2230000006', 'CS111', 10, 10, 10, 10);
 INSERT INTO studentcourses(StudID, CourseID, QuizGrade, MidtermGrade, FinalGrade, ProjectGrade)
VALUES('2230000006', 'Math111', 10, 10, 10, 10);