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
	Chapter INT FOREIGN KEY REFERENCES Chapter(Chapter_ID)
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
	Level INT FOREIGN KEY REFERENCES Level(Level_ID) ON DELETE CASCADE,
	Lesson INT FOREIGN KEY REFERENCES Lesson(Lesson_ID) ON DELETE CASCADE
)
GO

CREATE TABLE Answer (
	Answer_ID INT IDENTITY PRIMARY KEY,
	Answer NVARCHAR(200),
	Correct BIT, --1 là đúng, 0 là sai
	Question INT FOREIGN KEY REFERENCES Question(Question_ID) ON DELETE CASCADE
)
GO

CREATE TABLE Test(
	Test_ID INT IDENTITY PRIMARY KEY,
	Test_Code NCHAR(20), --mã đề
	Number_Of_Question INT,
	Time INT, --Thời gian làm đề. Tính là phút, nếu thời gian dài hơn sẽ làm hàm convert ở phía xử lý code.
	Level INT FOREIGN KEY REFERENCES Level(Level_ID),
	Status BIT DEFAULT 1 --1 : Đã được kích hoạt, 0 : Bị vô hiệu hóa
)
GO

CREATE TABLE Test_Question(
	T_QT_ID INT IDENTITY PRIMARY KEY,
	Test INT FOREIGN KEY REFERENCES Test(Test_ID),
	Question INT FOREIGN KEY REFERENCES Question(Question_ID) ON DELETE CASCADE
)
GO

CREATE TABLE Result(
	Result_ID INT IDENTITY PRIMARY KEY,
	Account INT FOREIGN KEY REFERENCES Account(Account_ID),
	Test INT FOREIGN KEY REFERENCES Test(Test_ID),
	Time INT, --Thời gian làm bài = Thời gian làm đề - Thời gian còn lại
	Correct_QT int, --Số cấu TL đúng => Tính điểm = số câu đúng / số câu trong đề (Correct_QT / Number_Of_Question)
	Result_Date DATE
)

GO

INSERT [dbo].[Account] ([UserName], [PassWord], [Name], [Roles], [Status]) VALUES (N'loc2909', N'1', NULL, 1, 1)
INSERT [dbo].[Account] ([UserName], [PassWord], [Name], [Roles], [Status]) VALUES (N'loc2909', N'123456', N'Lộc đẹp trai', 0, 1)

GO


INSERT [dbo].[Chapter] ([Chapter], [Chapter_Name]) VALUES (1, N'Đây là chương 1')
INSERT [dbo].[Chapter] ([Chapter], [Chapter_Name]) VALUES (2, N'Đây là chương 2')
INSERT [dbo].[Chapter] ([Chapter], [Chapter_Name]) VALUES (3, N'Đây là chương 3')

GO

INSERT [dbo].[Lesson] ([Lesson], [Lesson_Name], [Chapter]) VALUES (1, N'Đây là bài 1 chương 1', 1)
INSERT [dbo].[Lesson] ([Lesson], [Lesson_Name], [Chapter]) VALUES (1, N'Đây là bài 1 chương 2', 2)
INSERT [dbo].[Lesson] ([Lesson], [Lesson_Name], [Chapter]) VALUES (2, N'Đây là bài 2 chương 2', 2)
INSERT [dbo].[Lesson] ([Lesson], [Lesson_Name], [Chapter]) VALUES (1, N'Đây là bài 1 chương 3', 3)
INSERT [dbo].[Lesson] ([Lesson], [Lesson_Name], [Chapter]) VALUES (2, N'Đây là bài 2 chương 3', 3)
INSERT [dbo].[Lesson] ([Lesson], [Lesson_Name], [Chapter]) VALUES (3, N'Đây là bài 3 chương 3', 3)

GO

INSERT [dbo].[Level] ([Level_Name]) VALUES (N'Dễ')
INSERT [dbo].[Level] ([Level_Name]) VALUES (N'Trung Bình')
INSERT [dbo].[Level] ([Level_Name]) VALUES (N'Khó')

GO


INSERT [dbo].[Test] ([Test_Code], [Number_Of_Question], [Time], [Level], [Status]) VALUES (N'HK_001              ', 4, 1, 1, 1)
INSERT [dbo].[Test] ([Test_Code], [Number_Of_Question], [Time], [Level], [Status]) VALUES (N'HK_002              ', 10, 20, 2, 1)
INSERT [dbo].[Test] ([Test_Code], [Number_Of_Question], [Time], [Level], [Status]) VALUES (N'ABC_123             ', 8, 8, 1, 1)
INSERT [dbo].[Test] ([Test_Code], [Number_Of_Question], [Time], [Level], [Status]) VALUES (N'MT_001              ', 12, 9, 3, 1)
INSERT [dbo].[Test] ([Test_Code], [Number_Of_Question], [Time], [Level], [Status]) VALUES (N'MT_002              ', 15, 10, 3, 1)
INSERT [dbo].[Test] ([Test_Code], [Number_Of_Question], [Time], [Level], [Status]) VALUES (N'MT_003              ', 15, 10, 2, 1)
INSERT [dbo].[Test] ([Test_Code], [Number_Of_Question], [Time], [Level], [Status]) VALUES (N'MT_004              ', 10, 8, 1, 1)
INSERT [dbo].[Test] ([Test_Code], [Number_Of_Question], [Time], [Level], [Status]) VALUES (N'MT_005              ', 10, 7, 1, 1)
INSERT [dbo].[Test] ([Test_Code], [Number_Of_Question], [Time], [Level], [Status]) VALUES (N'MT_006              ', 10, 7, 1, 1)
INSERT [dbo].[Test] ([Test_Code], [Number_Of_Question], [Time], [Level], [Status]) VALUES (N'MT_007              ', 12, 8, 3, 1)

GO

INSERT [dbo].[Question] ([Question], [Level], [Lesson]) VALUES (N'Đâu là đáp án đúng 1', 1, 1)
INSERT [dbo].[Question] ([Question], [Level], [Lesson]) VALUES (N'Đâu là đáp án đúng 2', 1, 1)
INSERT [dbo].[Question] ([Question], [Level], [Lesson]) VALUES (N'Đâu là đáp án đúng 3', 1, 2)
INSERT [dbo].[Question] ([Question], [Level], [Lesson]) VALUES (N'Đâu là đáp án đúng 4', 2, 2)
INSERT [dbo].[Question] ([Question], [Level], [Lesson]) VALUES (N'Đâu là đáp án đúng 5', 2, 3)
INSERT [dbo].[Question] ([Question], [Level], [Lesson]) VALUES (N'Đâu là đáp án đúng 6', 2, 3)
INSERT [dbo].[Question] ([Question], [Level], [Lesson]) VALUES (N'Đâu là đáp án đúng 7', 3, 4)
INSERT [dbo].[Question] ([Question], [Level], [Lesson]) VALUES (N'Đâu là đáp án đúng 8', 3, 4)
INSERT [dbo].[Question] ([Question], [Level], [Lesson]) VALUES (N'Đâu là đáp án đúng 9', 3, 4)

GO
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu trả lời đúng', 1, 1)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu trả lời sai Câu trả lời sai Câu trả lời sai Câu trả lời sai Câu trả lời sai Câu trả lời sai', 0, 1)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Đây vẫn là một câu trả lời sai nhưng ghi dài ra', 0, 1)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Tiếp tục là câu trả lời sai', 0, 1)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu trả lời sai câu 2', 0, 2)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Tiếp tục là sai câu 2', 0, 2)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Đây là câu đúng câu 2 nè', 1, 2)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Đây là đúng ! Nhưng mà là câu khác', 0, 2)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Sai câu 3', 0, 3)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Đúng 3 nè', 1, 3)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Giờ là sai 3 nè', 0, 3)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Tiếp tục sai 3 nữa nè', 0, 3)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Sai 4 lần 1', 0, 4)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Sai 4 lần 2', 0, 4)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Sai 4 lần 3', 0, 4)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Sai 4. À đâu đúng 4', 1, 4)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 5', 0, 5)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 5', 0, 5)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 5', 0, 5)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu đúng 5', 1, 5)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 6', 0, 6)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 6', 0, 6)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 6', 0, 6)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu đúng 6', 1, 6)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 7', 0, 7)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 7', 0, 7)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 7', 0, 7)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu đúng 7', 1, 7)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 8', 0, 8)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 8', 0, 8)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 8', 0, 8)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu đúng 8', 1, 8)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 9', 0, 9)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 9', 0, 9)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu sai 9', 0, 9)
INSERT [dbo].[Answer] ([Answer], [Correct], [Question]) VALUES (N'Câu đúng 9', 1, 4)


GO

INSERT [dbo].[Test_Question] ([Test], [Question]) VALUES (1, 1)
INSERT [dbo].[Test_Question] ([Test], [Question]) VALUES (1, 2)
INSERT [dbo].[Test_Question] ([Test], [Question]) VALUES (1, 3)
INSERT [dbo].[Test_Question] ([Test], [Question]) VALUES (1, 4)

GO
--PROC Get List Question By Id Test
CREATE PROC STP_GetQuestionByIdTest
@IdTest INT
AS 
BEGIN
	SELECT Q.Question_ID, Q.Question, Q.Level, Q.Lesson
	FROM Test_Question AS TQ,Question AS Q
	WHERE TQ.Question = Q.Question_ID
	AND TQ.Test = @IdTest
END

--EXEC STP_GetQuestionByIdTest 1
--DROP PROC STP_GetQuestionByIdTest
GO

--PROC Get List Question By Level
CREATE PROC STP_GetQuestionByLevel
@level INT
AS 
BEGIN
	SELECT Q.Question_ID, Q.Question, Q.Level, Q.Lesson
	FROM Level as L,Question AS Q
	WHERE L.Level_ID = Q.Level
	AND Q.Level = @level
END

--EXEC STP_GetQuestionByLevel 1
--DROP PROC STP_GetQuestionByLevel
GO

--PROC Get Max Id of Question By Level
CREATE PROC STP_GetMaxIdOfQuestionByLevel
@level int
AS
BEGIN
SELECT MAX(Q.Question_ID) AS Max
FROM Question AS Q
WHERE LEVEL = @level
END

--EXEC STP_GetMaxIdOfQuestionByLevel 1
--DROP PROC STP_GetMaxIdOfQuestionByLevel
GO

--PROC Get Min Id of Question By Level
CREATE PROC STP_GetMinIdOfQuestionByLevel
@level int
AS
BEGIN
SELECT MIN(Q.Question_ID) AS MIN
FROM Question AS Q
WHERE LEVEL = @level
END

--EXEC STP_GetMinIdOfQuestionByLevel 1
--DROP PROC STP_GetMinIdOfQuestionByLevel
GO

SELECT * FROM Test