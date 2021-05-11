USE master
GO

IF(EXISTS(SELECT * FROM SYSDATABASES WHERE NAME='TracNghiemCNPM'))
	DROP DATABASE TracNghiemCNPM

CREATE DATABASE TracNghiemCNPM
GO

USE TracNghiemCNPM
GO

CREATE TABLE Account(
	Account_ID INT IDENTITY PRIMARY KEY, --khoá chính tự tăng
	UserName NCHAR(50),
	PassWord NCHAR(200),
	Name NVARCHAR(50),
	Roles BIT DEFAULT 0, --1 : TK Admin, 0 : TK Student
	Status BIT DEFAULT 1, --1 : Đã được kích hoạt, 0 : Bị vô hiệu hóa
)
GO

CREATE TABLE Chapter(
	Chapter_ID INT IDENTITY PRIMARY KEY,
	Chapter INT, --Chương thứ mấy
	Chapter_Name NVARCHAR(100)
)
GO

CREATE TABLE Lesson(
	Lesson_ID INT IDENTITY PRIMARY KEY,
	Lesson INT, --Bài thứ mấy
	Lesson_Name NVARCHAR(100),
	Chapter_ID INT FOREIGN KEY REFERENCES Chapter(Chapter_ID) ON UPDATE CASCADE ON DELETE CASCADE
)
GO

CREATE TABLE Level(
	Level_ID INT IDENTITY PRIMARY KEY,
	Level_Name NVARCHAR(20) -- Dễ Trung Bình Khó
)
GO

CREATE TABLE Question(
	Question_ID INT IDENTITY PRIMARY KEY,
	Question NVARCHAR(200),
	Level_ID INT FOREIGN KEY REFERENCES Level(Level_ID) ON UPDATE CASCADE ON DELETE CASCADE,
	Lesson_ID INT FOREIGN KEY REFERENCES Lesson(Lesson_ID) ON UPDATE CASCADE ON DELETE CASCADE
)
GO

CREATE TABLE Answer (
	Answer_ID INT IDENTITY PRIMARY KEY,
	Answer NVARCHAR(200),
	Correct BIT, --1 là đúng, 0 là sai
	Question_ID INT FOREIGN KEY REFERENCES Question(Question_ID) ON UPDATE CASCADE ON DELETE CASCADE
)
GO

CREATE TABLE Test(
	Test_ID INT IDENTITY PRIMARY KEY,
	Test_Name NVarCHAR(200), --tên đề
	Time INT, --Thời gian làm đề. Tính là phút, nếu thời gian dài hơn sẽ làm hàm convert ở phía xử lý code.
	Level_ID INT FOREIGN KEY REFERENCES Level(Level_ID) ON UPDATE CASCADE ON DELETE CASCADE,
	Status BIT DEFAULT 1 --1 : Đã được kích hoạt, 0 : Bị vô hiệu hóa
)
GO

CREATE TABLE Test_Question(
	T_QT_ID INT IDENTITY PRIMARY KEY,
	Test_ID INT FOREIGN KEY REFERENCES Test(Test_ID) ,
	Question_ID INT FOREIGN KEY REFERENCES Question(Question_ID) ON UPDATE CASCADE ON DELETE CASCADE
)
GO

CREATE TABLE Result(
	Result_ID INT IDENTITY PRIMARY KEY,
	Account_ID INT FOREIGN KEY REFERENCES Account(Account_ID) ,
	Test_ID INT FOREIGN KEY REFERENCES Test(Test_ID) ,
	Time INT, --Thời gian làm bài = Thời gian làm đề - Thời gian còn lại
	Correct_QT int, --Số cấu TL đúng => Tính điểm = số câu đúng / số câu trong đề (Correct_QT / Number_Of_Question)
	Result_Date DATE,
	Mark float
)

GO

INSERT [dbo].[Account] ([UserName], [PassWord], [Name], [Roles], [Status]) VALUES (N'loc2909', N'1', NULL, 1, 1)
INSERT [dbo].[Account] ([UserName], [PassWord], [Name], [Roles], [Status]) VALUES (N'loc2909', N'123456', N'Lộc đẹp trai', 0, 1)

GO


INSERT [dbo].[Chapter] ([Chapter], [Chapter_Name]) VALUES (1, N'Đây là chương 1')
INSERT [dbo].[Chapter] ([Chapter], [Chapter_Name]) VALUES (2, N'Đây là chương 2')
INSERT [dbo].[Chapter] ([Chapter], [Chapter_Name]) VALUES (3, N'Đây là chương 3')

GO

INSERT [dbo].[Lesson] ([Lesson], [Lesson_Name], [Chapter_ID]) VALUES (1, N'Đây là bài 1 chương 1', 1)
INSERT [dbo].[Lesson] ([Lesson], [Lesson_Name], [Chapter_ID]) VALUES (1, N'Đây là bài 1 chương 2', 2)
INSERT [dbo].[Lesson] ([Lesson], [Lesson_Name], [Chapter_ID]) VALUES (2, N'Đây là bài 2 chương 2', 2)
INSERT [dbo].[Lesson] ([Lesson], [Lesson_Name], [Chapter_ID]) VALUES (1, N'Đây là bài 1 chương 3', 3)
INSERT [dbo].[Lesson] ([Lesson], [Lesson_Name], [Chapter_ID]) VALUES (2, N'Đây là bài 2 chương 3', 3)
INSERT [dbo].[Lesson] ([Lesson], [Lesson_Name], [Chapter_ID]) VALUES (3, N'Đây là bài 3 chương 3', 3)

GO

INSERT [dbo].[Level] ([Level_Name]) VALUES (N'Dễ')
INSERT [dbo].[Level] ([Level_Name]) VALUES (N'Trung Bình')
INSERT [dbo].[Level] ([Level_Name]) VALUES (N'Khó')

GO


INSERT [dbo].[Test] ([Test_Name], [Time], [Level_ID], [Status]) VALUES (N'Đề kiểm tra CNTT1', 1, 1, 1)

GO

INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp án đúng 1', 1, 1)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp án đúng 2', 1, 1)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp án đúng 3', 1, 2)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp án đúng 4', 2, 2)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp án đúng 5', 2, 3)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp án đúng 6', 2, 3)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp án đúng 7', 3, 4)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp án đúng 8', 3, 4)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp án đúng 9', 3, 4)

GO

INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu trả lời đúng', 1, 1)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu trả lời sai Câu trả lời sai Câu trả lời sai Câu trả lời sai Câu trả lời sai Câu trả lời sai', 0, 1)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Đây vẫn là một câu trả lời sai nhưng ghi dài ra', 0, 1)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Tiếp tục là câu trả lời sai', 0, 1)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu trả lời sai câu 2', 0, 2)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Tiếp tục là sai câu 2', 0, 2)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Đây là câu đúng câu 2 nè', 1, 2)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Đây là đúng ! Nhưng mà là câu khác', 0, 2)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Sai câu 3', 0, 3)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Đúng 3 nè', 1, 3)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Giờ là sai 3 nè', 0, 3)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Tiếp tục sai 3 nữa nè', 0, 3)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Sai 4 lần 1', 0, 4)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Sai 4 lần 2', 0, 4)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Sai 4 lần 3', 0, 4)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Sai 4. À đâu đúng 4', 1, 4)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 5', 0, 5)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 5', 0, 5)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 5', 0, 5)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu đúng 5', 1, 5)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 6', 0, 6)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 6', 0, 6)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 6', 0, 6)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu đúng 6', 1, 6)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 7', 0, 7)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 7', 0, 7)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 7', 0, 7)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu đúng 7', 1, 7)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 8', 0, 8)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 8', 0, 8)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 8', 0, 8)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu đúng 8', 1, 8)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 9', 0, 9)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 9', 0, 9)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu sai 9', 0, 9)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question_ID]) VALUES (N'Câu đúng 9', 1, 9)


GO

INSERT [dbo].[Test_Question] ([Test_ID], [Question_ID]) VALUES (1, 1)
INSERT [dbo].[Test_Question] ([Test_ID], [Question_ID]) VALUES (1, 2)
INSERT [dbo].[Test_Question] ([Test_ID], [Question_ID]) VALUES (1, 3)
INSERT [dbo].[Test_Question] ([Test_ID], [Question_ID]) VALUES (1, 4)

GO
--PROC Get List Question By Id Test
CREATE PROC STP_GetQuestionByIdTest
@IdTest INT
AS 
BEGIN
	SELECT Q.Question_ID, Q.Question, Q.Level_ID, Q.Lesson_ID
	FROM Test_Question AS TQ,Question AS Q
	WHERE TQ.Question_ID = Q.Question_ID
	AND TQ.Test_ID = @IdTest
END

--EXEC STP_GetQuestionByIdTest 1
--DROP PROC STP_GetQuestionByIdTest
GO

--PROC Get List Question By Level
CREATE PROC STP_GetQuestionByLevel
@level INT
AS 
BEGIN
	SELECT Q.Question_ID, Q.Question, Q.Level_ID, Q.Lesson_ID
	FROM Level as L,Question AS Q
	WHERE L.Level_ID = Q.Level_ID
	AND Q.Level_ID = @level
END

--EXEC STP_GetQuestionByLevel 1
--DROP PROC STP_GetQuestionByLevel
GO


--Proc get questions by chapter and lesson
CREATE PROC GetQuestionsByChapterLesson
@chapter INT,
@lesson INT,
@level INT
AS
BEGIN
	SELECT * 
	FROM Chapter AS C, LESSON AS L, Question AS Q
	WHERE C.Chapter_ID = L.Chapter_ID
	AND L.Lesson_ID = Q.Lesson_ID
	AND C.Chapter = @chapter
	AND L.Lesson = @lesson
	AND Q.Level_ID = @level
END

--EXEC GetQuestionsByChapterLesson 2,1,2
--DROP PROC GetQuestionsByChapterLesson
GO

--Proc Edit Test by IdTest
Create Proc EditTestById
@idTest INT,
@testCode NVarCHAR(200),
@time INT
AS
BEGIN
	UPDATE Test 
	SET Test_Name = @testCode,TIME = @time
	WHERE Test_ID = @idTest
END

--EXEC EditTestById 1,N'Edited',3
--DROP PROC EditTestById

SELECT Q.Question ,Q.Level_ID
FROM Question AS Q, Chapter AS C, Lesson AS L
WHERE Q.Lesson_ID = L.Lesson
AND L.Chapter_ID = C.Chapter
AND C.Chapter = 3
AND L.Lesson = 2

GO
--Get Chapter from TestID
CREATE PROC STP_GetChapterByTestID
@TestID INT
AS 
BEGIN
	Select * from Chapter where Chapter_ID = 
(Select top(1) Chapter_ID from Lesson
where Lesson_ID = (select top(1)Lesson_ID from Question
Where Question_ID = (select top (1) Question_ID from Test_Question where Test_ID = @TestID)))
END

GO

CREATE PROC STP_GetListQuestionByChapter @chapter int
AS
SELECT Q.Question_ID, Question, Level_ID, Q.Lesson_ID
FROM Question Q INNER JOIN Lesson L ON Q.Lesson_ID = L.Lesson_ID
WHERE Chapter_ID = @chapter

GO
CREATE PROC STP_GetListQuestionByChapterAndLevel @chapter int,@level int
AS
SELECT Q.Question_ID, Question, Level_ID, Q.Lesson_ID
FROM Question Q INNER JOIN Lesson L ON Q.Lesson_ID = L.Lesson_ID
WHERE Chapter_ID = @chapter And Level_ID = @level
