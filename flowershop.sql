USE [master]
GO
/****** Object:  Database [PlantShop]    Script Date: 2/19/2023 7:14:17 PM ******/
CREATE DATABASE [PlantShop]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PlantShop', FILENAME = N'D:\Student\SQL\MSSQL15.MSSQLSERVER\MSSQL\DATA\PlantShop.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PlantShop_log', FILENAME = N'D:\Student\SQL\MSSQL15.MSSQLSERVER\MSSQL\DATA\PlantShop_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [PlantShop] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PlantShop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PlantShop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PlantShop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PlantShop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PlantShop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PlantShop] SET ARITHABORT OFF 
GO
ALTER DATABASE [PlantShop] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PlantShop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PlantShop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PlantShop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PlantShop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PlantShop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PlantShop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PlantShop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PlantShop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PlantShop] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PlantShop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PlantShop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PlantShop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PlantShop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PlantShop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PlantShop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PlantShop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PlantShop] SET RECOVERY FULL 
GO
ALTER DATABASE [PlantShop] SET  MULTI_USER 
GO
ALTER DATABASE [PlantShop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PlantShop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PlantShop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PlantShop] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PlantShop] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PlantShop] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'PlantShop', N'ON'
GO
ALTER DATABASE [PlantShop] SET QUERY_STORE = OFF
GO
USE [PlantShop]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 2/19/2023 7:14:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accounts](
	[accID] [int] IDENTITY(1,1) NOT NULL,
	[email] [varchar](30) NULL,
	[password] [varchar](30) NULL,
	[fullname] [varchar](30) NULL,
	[phone] [varchar](12) NULL,
	[status] [int] NULL,
	[role] [int] NULL,
	[token] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[accID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 2/19/2023 7:14:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[CateID] [int] IDENTITY(1,1) NOT NULL,
	[CateName] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[CateID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetails]    Script Date: 2/19/2023 7:14:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetails](
	[DetailId] [int] IDENTITY(1,1) NOT NULL,
	[OrderID] [int] NULL,
	[FID] [int] NULL,
	[quantity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[DetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 2/19/2023 7:14:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [int] IDENTITY(1,1) NOT NULL,
	[OrdDate] [date] NULL,
	[shipdate] [date] NULL,
	[status] [int] NULL,
	[AccID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Plants]    Script Date: 2/19/2023 7:14:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Plants](
	[PID] [int] IDENTITY(1,1) NOT NULL,
	[PName] [varchar](30) NULL,
	[price] [int] NULL,
	[imgPath] [varchar](50) NULL,
	[description] [text] NULL,
	[status] [int] NULL,
	[CateID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[PID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Accounts] ON 

INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (1, N'ff@gmail.com', N'2222', N'fAccount', N'0939273929', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (2, N'aa@gmail.com', N'1111', N'aAccount', N'0983739281', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (3, N'c@gmail.com', N'3333', N'cAccount', N'0293844203', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (4, N'd@gmail.com', N'4444', N'dAccount', N'4848229548', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (5, N'e@gmail.com', N'5555', N'eAccount', N'0448773929', 0, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (6, N'admin@gmail.com', N'1102', N'Admin', N'0948239433', 1, 1, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (7, N'kiet@gmail.com', N'2911', N'LeTuanKiet', N'0973961369', 1, 1, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (8, N'g@gmail.com', N'8888', N'gAccount', N'0937483929', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (9, N'test@gmail.com', N'test', N'testaccount', N'0949823991', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (10, N'acc1@gmail.com', N'1111', N'Account1', N'0948733822', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (11, N'acc2@gmail.com', N'2222', N'Account2', N'0394744288', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (12, N'acc3@gmail.com', N'3333', N'Account3', N'0393484939', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (13, N'acc4@gmail.com', N'4444', N'Account4', N'0393849332', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (15, N'acc5@gmail.com', N'5555', N'Account5', N'0948338263', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (1002, N'tester1@gmail.com', N'1111', N'tester1', N'0937428172', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (1018, N'test3@gmail.com', N'3333', N'test3', N'0987372823', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (1019, N'test4@gmail.com', N'4444', N'newaccount', N'0938293020', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (1020, N'acc6@gmail.com', N'6666', N'Account6', N'0937283910', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (1022, N'acc7@gmail.com', N'7777', N'Account7', N'0938474822', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (2033, N'f@gmail.com', N'5555', N'fAccount', N'0938473829', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (2082, N'2082@gmail.com', N'aaav', N'aa', N'111', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (2101, N'ak@gmail.com', N'111', N'akAccount', N'0393884922', 1, 0, N'ABC123')
INSERT [dbo].[Accounts] ([accID], [email], [password], [fullname], [phone], [status], [role], [token]) VALUES (2130, N'aaaa@gmail.com', N'111', N'aaa', N'11', 0, 0, N'ABC123')
SET IDENTITY_INSERT [dbo].[Accounts] OFF
GO
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([CateID], [CateName]) VALUES (1, N'Hoa Hong')
INSERT [dbo].[Categories] ([CateID], [CateName]) VALUES (2, N'Hoa Cuc')
INSERT [dbo].[Categories] ([CateID], [CateName]) VALUES (3, N'HoaTulip')
INSERT [dbo].[Categories] ([CateID], [CateName]) VALUES (4, N'Hoa Lan')
INSERT [dbo].[Categories] ([CateID], [CateName]) VALUES (5, N'Hoa Huong Duong')
INSERT [dbo].[Categories] ([CateID], [CateName]) VALUES (6, N'Hoa Ly')
INSERT [dbo].[Categories] ([CateID], [CateName]) VALUES (7, N'Hoa Tong Hop')
INSERT [dbo].[Categories] ([CateID], [CateName]) VALUES (8, N'Hoa Cam Chuong')
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO
SET IDENTITY_INSERT [dbo].[OrderDetails] ON 

INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (2, 1, 1, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (3, 2, 2, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (4, 2, 3, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (5, 1, 4, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (6, 3, 5, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (7, 4, 3, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (8, 5, 2, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (9, 3, 2, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (10, 4, 6, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (11, 4, 5, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (12, 2, 4, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (13, 11, 3, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (14, 4, 5, 9)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (15, 2, 4, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (16, 5, 5, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (17, 1, 4, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (18, 3, 4, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (19, 6, 8, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (20, 6, 7, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (21, 19, 7, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (22, 2, 8, 10)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (23, 20, 1, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (24, 20, 3, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (25, 20, 4, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1006, 1019, 1, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1007, 1020, 1, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1008, 1020, 2, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1009, 1020, 3, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1010, 1021, 1, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1011, 1021, 2, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1012, 1022, 1, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1013, 1022, 2, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1014, 1022, 3, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1015, 1023, 1, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1016, 1023, 3, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1017, 1023, 4, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1018, 1023, 5, 2)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1019, 1024, 2, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1020, 1024, 3, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1021, 1024, 4, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1022, 1025, 22, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1023, 1025, 1, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1024, 1025, 18, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1025, 1026, 1, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1026, 1026, 24, 3)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1027, 1026, 14, 1)
INSERT [dbo].[OrderDetails] ([DetailId], [OrderID], [FID], [quantity]) VALUES (1028, 1026, 16, 3)
SET IDENTITY_INSERT [dbo].[OrderDetails] OFF
GO
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (1, CAST(N'2022-10-22' AS Date), CAST(N'2022-11-10' AS Date), 2, 1)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (2, CAST(N'2022-09-19' AS Date), CAST(N'2022-09-19' AS Date), 2, 1)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (3, CAST(N'2022-09-12' AS Date), NULL, 1, 2)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (4, CAST(N'2022-08-22' AS Date), CAST(N'2022-11-09' AS Date), 2, 3)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (5, CAST(N'2022-09-15' AS Date), NULL, 1, 4)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (6, CAST(N'2022-09-30' AS Date), NULL, 1, 5)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (7, CAST(N'2022-09-12' AS Date), CAST(N'2022-09-12' AS Date), 2, 2)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (8, CAST(N'2022-08-11' AS Date), CAST(N'2022-11-17' AS Date), 2, 2)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (9, CAST(N'2022-06-21' AS Date), NULL, 1, 5)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (10, CAST(N'2022-08-19' AS Date), CAST(N'2022-08-19' AS Date), 2, 6)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (11, CAST(N'2022-09-21' AS Date), NULL, 3, 7)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (12, CAST(N'2022-09-21' AS Date), NULL, 3, 3)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (13, CAST(N'2022-09-21' AS Date), CAST(N'2022-11-09' AS Date), 2, 4)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (17, CAST(N'2022-09-21' AS Date), NULL, 3, 7)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (18, CAST(N'2022-09-21' AS Date), CAST(N'2022-11-09' AS Date), 2, 2)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (19, CAST(N'2022-11-03' AS Date), CAST(N'2022-11-09' AS Date), 2, 1)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (20, CAST(N'2022-11-04' AS Date), NULL, 3, 1)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (1019, CAST(N'2022-11-05' AS Date), CAST(N'2022-11-05' AS Date), 2, 1)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (1020, CAST(N'2022-11-05' AS Date), NULL, 1, 1)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (1021, CAST(N'2022-11-07' AS Date), NULL, 1, 1)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (1022, CAST(N'2022-11-07' AS Date), CAST(N'2022-11-09' AS Date), 2, 1019)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (1023, CAST(N'2022-11-08' AS Date), NULL, 1, 1)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (1024, CAST(N'2022-11-08' AS Date), CAST(N'2022-11-09' AS Date), 2, 2101)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (1025, CAST(N'2022-11-09' AS Date), NULL, 1, 1019)
INSERT [dbo].[Orders] ([OrderID], [OrdDate], [shipdate], [status], [AccID]) VALUES (1026, CAST(N'2022-11-09' AS Date), NULL, 1, 1019)
SET IDENTITY_INSERT [dbo].[Orders] OFF
GO
SET IDENTITY_INSERT [dbo].[Plants] ON 

INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (1, N'Hoa ly', 100000, N'images/1.png', N'Hoa trang tri', 1, 6)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (2, N'Hoa Hong 1', 80000, N'images/2.png', N'Hoa hoi tiec', 1, 1)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (3, N'Hoa Hong 2', 50000, N'images/3.png', N'Hoa theo bo', 2, 1)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (4, N'Hoa Hong 3', 50000, N'images/4.png', N'Hoa theo bo', 1, 1)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (5, N'Hoa Hong 4', 60000, N'images/5.png', N'Hoa theo bo', 1, 1)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (6, N'Hoa Hong 5', 60000, N'images/6.png', N'Hoa theo bo', 2, 1)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (7, N'Hoa Lan', 120000, N'images/7.png', N'Hoa trang tri', 1, 4)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (8, N'Hoa Cuc 1', 80000, N'images/8.png', N'Hoa trang tri', 1, 2)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (9, N'Hoa Hong 6', 70000, N'images/9.png', N'Hoa trang tri', 1, 1)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (10, N'Hoa Cuc 2', 80000, N'images/10.png', N'Hoa theo bo', 1, 2)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (11, N'Hoa Hong 7', 60000, N'images/11.png', N'Hoa hoi tiec', 1, 1)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (12, N'Hoa Hong 8', 60000, N'images/12.png', N'Hoa hoi tiec', 1, 1)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (13, N'Hoa Hong 9', 80000, N'images/13.png', N'Hoa theo bo', 1, 1)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (14, N'Hoa Hong 10', 80000, N'images/14.png', N'Hoa hoi tiec', 1, 1)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (15, N'Hoa Tong Hop 1', 70000, N'images/15.png', N'Hoa trang tri', 1, 7)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (16, N'Hoa Ly 2', 130000, N'images/16.png', N'Hoa trang tri', 1, 6)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (17, N'Hoa Cuc 3', 80000, N'images/17.png', N'Hoa hoi tiec', 1, 2)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (18, N'Hoa Cam Chuong', 80000, N'images/18.png', N'Hoa theo bo', 1, 8)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (19, N'Hoa Hong 13', 140000, N'images/19.png', N'Hoa theo bo', 1, 1)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (20, N'Hoa Hong 11', 120000, N'images/20.png', N'Hoa trang tri', 1, 1)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (21, N'Hoa Cuc 4', 90000, N'images/21.png', N'Hoa theo bo', 1, 2)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (22, N'Hoa Tulip', 100000, N'images/22.png', N'Hoa theo bo', 1, 1)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (23, N'Hoa Hong 12', 90000, N'images/23.png', N'Hoa theo bo', 1, 1)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (24, N'Hoa Tulip 2', 120000, N'images/24.png', N'Hoa trang tri', 1, 3)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (25, N'Hoa Huong Duong', 130000, N'images/25.png', N'Hoa trang tri', 1, 5)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (26, N'Hoa Cuc 5', 100000, N'images/26.png', N'Hoa trang tri', 1, 2)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (1006, N'Hoa Tulip 2', 100000, N'images/22.png', N'Hoa theo bo', 1, 3)
INSERT [dbo].[Plants] ([PID], [PName], [price], [imgPath], [description], [status], [CateID]) VALUES (1007, N'Hoa Tulip 3', 130000, N'images/22.png', N'Hoa theo bo', 1, 3)
SET IDENTITY_INSERT [dbo].[Plants] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Accounts__AB6E616439F4E09B]    Script Date: 2/19/2023 7:14:17 PM ******/
ALTER TABLE [dbo].[Accounts] ADD UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD FOREIGN KEY([OrderID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD FOREIGN KEY([FID])
REFERENCES [dbo].[Plants] ([PID])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([AccID])
REFERENCES [dbo].[Accounts] ([accID])
GO
ALTER TABLE [dbo].[Plants]  WITH CHECK ADD FOREIGN KEY([CateID])
REFERENCES [dbo].[Categories] ([CateID])
GO
ALTER TABLE [dbo].[Accounts]  WITH CHECK ADD CHECK  (([role]=(1) OR [role]=(0)))
GO
ALTER TABLE [dbo].[Accounts]  WITH CHECK ADD CHECK  (([status]=(1) OR [status]=(0)))
GO
ALTER TABLE [dbo].[OrderDetails]  WITH CHECK ADD CHECK  (([quantity]>=(1)))
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD CHECK  (([status]=(1) OR [status]=(2) OR [status]=(3)))
GO
ALTER TABLE [dbo].[Plants]  WITH CHECK ADD CHECK  (([price]>=(0)))
GO
USE [master]
GO
ALTER DATABASE [PlantShop] SET  READ_WRITE 
GO
