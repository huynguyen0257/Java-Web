USE [master]
GO
/****** Object:  Database [PresentPRJ321]    Script Date: 4/22/2019 9:23:31 AM ******/
CREATE DATABASE [PresentPRJ321]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PresentPRJ321', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\PresentPRJ321.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PresentPRJ321_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\PresentPRJ321_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [PresentPRJ321] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PresentPRJ321].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PresentPRJ321] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PresentPRJ321] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PresentPRJ321] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PresentPRJ321] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PresentPRJ321] SET ARITHABORT OFF 
GO
ALTER DATABASE [PresentPRJ321] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PresentPRJ321] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PresentPRJ321] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PresentPRJ321] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PresentPRJ321] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PresentPRJ321] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PresentPRJ321] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PresentPRJ321] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PresentPRJ321] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PresentPRJ321] SET  DISABLE_BROKER 
GO
ALTER DATABASE [PresentPRJ321] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PresentPRJ321] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PresentPRJ321] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PresentPRJ321] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PresentPRJ321] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PresentPRJ321] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PresentPRJ321] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PresentPRJ321] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PresentPRJ321] SET  MULTI_USER 
GO
ALTER DATABASE [PresentPRJ321] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PresentPRJ321] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PresentPRJ321] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PresentPRJ321] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PresentPRJ321] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PresentPRJ321] SET QUERY_STORE = OFF
GO
USE [PresentPRJ321]
GO
/****** Object:  Table [dbo].[tbl_Events]    Script Date: 4/22/2019 9:23:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Events](
	[EventID] [nvarchar](10) NOT NULL,
	[EventName] [nvarchar](50) NOT NULL,
	[Place] [nvarchar](50) NOT NULL,
	[Details] [nvarchar](500) NULL,
	[FromDate] [date] NOT NULL,
	[ToDate] [date] NOT NULL,
	[RewardID] [nvarchar](10) NOT NULL,
	[Status] [bit] NOT NULL,
 CONSTRAINT [PK_Event] PRIMARY KEY CLUSTERED 
(
	[EventID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_EventUser]    Script Date: 4/22/2019 9:23:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_EventUser](
	[EventID] [nvarchar](10) NOT NULL,
	[UserID] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_EventUserReward]    Script Date: 4/22/2019 9:23:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_EventUserReward](
	[EventID] [nvarchar](10) NULL,
	[UserID] [int] NULL,
	[RewardID] [nvarchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Rewards]    Script Date: 4/22/2019 9:23:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Rewards](
	[RewardID] [nvarchar](10) NOT NULL,
	[RewardName] [nvarchar](50) NOT NULL,
	[RewardValue] [int] NOT NULL,
	[Status] [bit] NOT NULL,
 CONSTRAINT [PK_tbl_Rewards] PRIMARY KEY CLUSTERED 
(
	[RewardID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbl_Users]    Script Date: 4/22/2019 9:23:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_Users](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Fullname] [nvarchar](50) NOT NULL,
	[Gender] [bit] NOT NULL,
	[Birthday] [date] NOT NULL,
	[Role] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_tbl_User] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tbl_Events] ([EventID], [EventName], [Place], [Details], [FromDate], [ToDate], [RewardID], [Status]) VALUES (N'E001', N'FPT Event Of Year', N'FPT University', N'', CAST(N'2018-10-29' AS Date), CAST(N'2018-10-31' AS Date), N'R001', 1)
INSERT [dbo].[tbl_Events] ([EventID], [EventName], [Place], [Details], [FromDate], [ToDate], [RewardID], [Status]) VALUES (N'E002', N'FPT Company Event', N'1', N'none', CAST(N'2018-10-31' AS Date), CAST(N'2018-11-28' AS Date), N'R002', 0)
INSERT [dbo].[tbl_Events] ([EventID], [EventName], [Place], [Details], [FromDate], [ToDate], [RewardID], [Status]) VALUES (N'E003', N'Event Every Year On FPT', N'FPT University', N'', CAST(N'2018-10-29' AS Date), CAST(N'2019-10-28' AS Date), N'R003', 1)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E001', 11)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E002', 10)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E002', 11)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E002', 6)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E003', 6)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E003', 11)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E002', 8)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E003', 8)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E001', 11)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E002', 10)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E002', 11)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E002', 6)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E003', 6)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E003', 11)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E002', 8)
INSERT [dbo].[tbl_EventUser] ([EventID], [UserID]) VALUES (N'E003', 8)
INSERT [dbo].[tbl_EventUserReward] ([EventID], [UserID], [RewardID]) VALUES (N'E002', 10, N'R002')
INSERT [dbo].[tbl_EventUserReward] ([EventID], [UserID], [RewardID]) VALUES (N'E002', 10, N'R002')
INSERT [dbo].[tbl_Rewards] ([RewardID], [RewardName], [RewardValue], [Status]) VALUES (N'R001', N'Dimond', 5000000, 0)
INSERT [dbo].[tbl_Rewards] ([RewardID], [RewardName], [RewardValue], [Status]) VALUES (N'R002', N'Cup Vang', 2000000, 0)
INSERT [dbo].[tbl_Rewards] ([RewardID], [RewardName], [RewardValue], [Status]) VALUES (N'R003', N'Cup Bac', 1000000, 0)
INSERT [dbo].[tbl_Rewards] ([RewardID], [RewardName], [RewardValue], [Status]) VALUES (N'R004', N'Cup Dong', 500000, 1)
SET IDENTITY_INSERT [dbo].[tbl_Users] ON 

INSERT [dbo].[tbl_Users] ([UserID], [UserName], [Password], [Fullname], [Gender], [Birthday], [Role]) VALUES (1, N'1', N'2', N'Nguyen Gia Huy', 1, CAST(N'1998-10-25' AS Date), N'admin')
INSERT [dbo].[tbl_Users] ([UserID], [UserName], [Password], [Fullname], [Gender], [Birthday], [Role]) VALUES (3, N'admin', N'1', N'Nguyen Nguyet Minh', 0, CAST(N'1998-10-01' AS Date), N'admin')
INSERT [dbo].[tbl_Users] ([UserID], [UserName], [Password], [Fullname], [Gender], [Birthday], [Role]) VALUES (6, N'huynguyen0257', N'1', N'Nguyen Gia Huy', 1, CAST(N'1998-07-25' AS Date), N'user')
INSERT [dbo].[tbl_Users] ([UserID], [UserName], [Password], [Fullname], [Gender], [Birthday], [Role]) VALUES (8, N'huy', N'huy', N'Huy Nguyen', 1, CAST(N'1995-10-28' AS Date), N'user')
INSERT [dbo].[tbl_Users] ([UserID], [UserName], [Password], [Fullname], [Gender], [Birthday], [Role]) VALUES (9, N'nhoxtyz1998', N'25071998', N'Gia Huy', 1, CAST(N'1995-10-28' AS Date), N'user')
INSERT [dbo].[tbl_Users] ([UserID], [UserName], [Password], [Fullname], [Gender], [Birthday], [Role]) VALUES (10, N'user1', N'1', N'USER 1', 0, CAST(N'1999-10-28' AS Date), N'user')
INSERT [dbo].[tbl_Users] ([UserID], [UserName], [Password], [Fullname], [Gender], [Birthday], [Role]) VALUES (11, N'huynguyen0257', N'tyz25071998', N'Nguyen Gia Huy', 1, CAST(N'1995-10-28' AS Date), N'user')
SET IDENTITY_INSERT [dbo].[tbl_Users] OFF
ALTER TABLE [dbo].[tbl_Events]  WITH CHECK ADD  CONSTRAINT [FK_tbl_Events_tbl_Rewards] FOREIGN KEY([RewardID])
REFERENCES [dbo].[tbl_Rewards] ([RewardID])
GO
ALTER TABLE [dbo].[tbl_Events] CHECK CONSTRAINT [FK_tbl_Events_tbl_Rewards]
GO
ALTER TABLE [dbo].[tbl_EventUser]  WITH CHECK ADD  CONSTRAINT [FK_tbl_EventUser_tbl_Events] FOREIGN KEY([EventID])
REFERENCES [dbo].[tbl_Events] ([EventID])
GO
ALTER TABLE [dbo].[tbl_EventUser] CHECK CONSTRAINT [FK_tbl_EventUser_tbl_Events]
GO
ALTER TABLE [dbo].[tbl_EventUser]  WITH CHECK ADD  CONSTRAINT [FK_tbl_EventUser_tbl_Users] FOREIGN KEY([UserID])
REFERENCES [dbo].[tbl_Users] ([UserID])
GO
ALTER TABLE [dbo].[tbl_EventUser] CHECK CONSTRAINT [FK_tbl_EventUser_tbl_Users]
GO
ALTER TABLE [dbo].[tbl_EventUserReward]  WITH CHECK ADD  CONSTRAINT [FK_tbl_EventUserReward_tbl_Events] FOREIGN KEY([EventID])
REFERENCES [dbo].[tbl_Events] ([EventID])
GO
ALTER TABLE [dbo].[tbl_EventUserReward] CHECK CONSTRAINT [FK_tbl_EventUserReward_tbl_Events]
GO
ALTER TABLE [dbo].[tbl_EventUserReward]  WITH CHECK ADD  CONSTRAINT [FK_tbl_EventUserReward_tbl_Rewards] FOREIGN KEY([RewardID])
REFERENCES [dbo].[tbl_Rewards] ([RewardID])
GO
ALTER TABLE [dbo].[tbl_EventUserReward] CHECK CONSTRAINT [FK_tbl_EventUserReward_tbl_Rewards]
GO
ALTER TABLE [dbo].[tbl_EventUserReward]  WITH CHECK ADD  CONSTRAINT [FK_tbl_EventUserReward_tbl_Users1] FOREIGN KEY([UserID])
REFERENCES [dbo].[tbl_Users] ([UserID])
GO
ALTER TABLE [dbo].[tbl_EventUserReward] CHECK CONSTRAINT [FK_tbl_EventUserReward_tbl_Users1]
GO
USE [master]
GO
ALTER DATABASE [PresentPRJ321] SET  READ_WRITE 
GO
