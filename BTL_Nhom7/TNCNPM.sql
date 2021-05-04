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
	Question_ID INT FOREIGN KEY REFERENCES Question(Question_ID)
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
	Test_ID INT FOREIGN KEY REFERENCES Test(Test_ID),
	Question_ID INT FOREIGN KEY REFERENCES Question(Question_ID)
)
GO

CREATE TABLE Result(
	Result_ID INT IDENTITY PRIMARY KEY,
	Account_ID INT FOREIGN KEY REFERENCES Account(Account_ID),
	Test_ID INT FOREIGN KEY REFERENCES Test(Test_ID),
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
INSERT [dbo].[Test] ([Test_Name], [Time], [Level_ID], [Status]) VALUES (N'Đề kiểm tra CNTT2', 20, 2, 1)
INSERT [dbo].[Test] ([Test_Name], [Time], [Level_ID], [Status]) VALUES (N'Đề kiểm tra CNTT3', 8, 1, 1)
INSERT [dbo].[Test] ([Test_Name], [Time], [Level_ID], [Status]) VALUES (N'Đề kiểm tra CNTT4', 9, 3, 1)
INSERT [dbo].[Test] ([Test_Name], [Time], [Level_ID], [Status]) VALUES (N'Đề kiểm tra CNTT5', 10, 3, 1)
INSERT [dbo].[Test] ([Test_Name], [Time], [Level_ID], [Status]) VALUES (N'Đề kiểm tra CNTT6', 10, 2, 1)
INSERT [dbo].[Test] ([Test_Name], [Time], [Level_ID], [Status]) VALUES (N'Đề kiểm tra CNTT7', 8, 1, 1)
INSERT [dbo].[Test] ([Test_Name], [Time], [Level_ID], [Status]) VALUES (N'Đề kiểm tra CNTT1', 7, 1, 1)
INSERT [dbo].[Test] ([Test_Name], [Time], [Level_ID], [Status]) VALUES (N'Đề kiểm tra CNTT1', 7, 1, 0)
INSERT [dbo].[Test] ([Test_Name], [Time], [Level_ID], [Status]) VALUES (N'Đề kiểm tra CNTT1', 8, 3, 0)

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
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 10', 1, 1)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 11', 1, 1)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 12', 1, 1)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 13', 2, 1)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 14', 2, 1)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 15', 2, 1)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 16', 3, 1)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 17', 3, 1)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 18', 3, 1)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 19', 1, 2)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 20', 1, 2)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 21', 1, 2)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 22', 2, 2)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 23', 2, 2)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 24', 2, 2)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 25', 3, 2)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 26', 3, 2)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 27', 3, 2)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 28', 1, 3)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 29', 1, 3)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 30', 2, 3)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 31', 2, 3)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 32', 2, 3)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 33', 3, 3)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 34', 3, 3)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 35', 3, 3)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 36', 1, 4)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 37', 1, 4)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 38', 1, 4)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 39', 2, 4)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 40', 2, 4)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 41', 2, 4)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 42', 3, 4)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 43', 3, 4)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 44', 3, 4)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 45', 1, 5)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 46', 1, 5)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 47', 1, 5)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 48', 2, 5)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 49', 2, 5)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 50', 2, 5)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 51', 3, 5)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 52', 3, 5)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 53', 3, 5)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 54', 1, 6)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 55', 1, 6)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 56', 1, 6)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 57', 2, 6)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 58', 2, 6)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 59', 2, 6)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 60', 3, 6)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 61', 3, 6)
INSERT [dbo].[Question] ([Question], [Level_ID], [Lesson_ID]) VALUES (N'Đâu là đáp đúng câu 62', 3, 6)
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

--PROC Get Max Id of Question By Level
CREATE PROC STP_GetMaxIdOfQuestionByLevel
@level int
AS
BEGIN
SELECT MAX(Q.Question_ID) AS Max
FROM Question AS Q
WHERE LEVEL_ID = @level
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
WHERE LEVEL_ID = @level
END

--EXEC STP_GetMinIdOfQuestionByLevel 1
--DROP PROC STP_GetMinIdOfQuestionByLevel
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
--Proc Active Test by IdTest
Create Proc ActiveTestById
@idTest INT,
@status bit
AS
BEGIN
	UPDATE Test 
	SET Status = @status
	WHERE Test_ID = @idTest
END
--EXEC ActiveTestById 1,0
--DROP PROC ActiveTestById
GO