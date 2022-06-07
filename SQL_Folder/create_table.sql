create table Student (
	studentID nvarchar(11) NOT NULL PRIMARY KEY,
	stuName nvarchar(100) NOT NULL,
	email nvarchar(100) NOT NULL,
	gender nvarchar(15),
	DoB nvarchar(50) NOT NULL
)
create table Teacher(
	teacherID nvarchar(11) NOT NULL PRIMARY KEY ,
	teacherName nvarchar(100) NOT NULL
)
create table Class_Info(
	classID nvarchar(11) NOT NULL PRIMARY KEY,
	className nvarchar(100) NOT NULL,
	room nvarchar(11) NOT NULL,
	startWeek int NOT NULL,
	endWeek int NOT NULL,
	dateOfWeek nvarchar(20)
)
create table Class(
	classID nvarchar(11) NOT NULL,
	studentID nvarchar(11) NOT NULL,
	teacherID nvarchar(11) NOT NULL
	PRIMARY KEY (classID, studentID, teacherID),
	FOREIGN KEY (classID) REFERENCES Class_Info(classID) ON DELETE CASCADE,
	FOREIGN KEY (studentID) REFERENCES Student(studentID) ON DELETE CASCADE,
	FOREIGN KEY (teacherID) REFERENCES Teacher(teacherID) ON DELETE CASCADE
	
)
create table Absence(
	classID nvarchar(11) NOT NULL,
	studentID nvarchar(11) NOT NULL,
	absenceDate date
	PRIMARY KEY (classID,studentID, absenceDate)
	FOREIGN KEY (classID) REFERENCES Class_Info(classID) ON DELETE CASCADE,
	FOREIGN KEY (studentID) REFERENCES Student(studentID) ON DELETE CASCADE,
)