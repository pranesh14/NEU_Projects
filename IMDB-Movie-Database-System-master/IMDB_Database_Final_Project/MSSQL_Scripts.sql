
--USE master

--CREATE DATABASE [IMDB]
-- CONTAINMENT = NONE
-- ON  PRIMARY 
--( NAME = N'IMDB', FILENAME = N'C:\neu_sqlserver\IMDB.mdf' , SIZE = 25600KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
-- LOG ON 
--( NAME = N'IMDB_log', FILENAME = N'C:\neu_sqlserver\IMDB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
--GO


---- Table User

--CREATE TABLE [User].[User]
--(
-- [UserID] Int IDENTITY(1,1) NOT NULL,
-- [FirstName] Char(40) NULL,
-- [LastName] Char(20) NULL,
-- [Email] Char(30) NULL,
-- [PhoneNumber] Char(12) NULL,
-- [DateOfBirth] Date NULL
--)
--go

---- Add keys for table User

--ALTER TABLE [User].[User] ADD CONSTRAINT [PK_UserID] PRIMARY KEY ([UserID])
--GO

-- Table User_Review

--CREATE TABLE [User].[User_Review]
--(
-- [UserReviewID] Int IDENTITY(1,1) NOT NULL,
-- [UserID] Int NOT NULL,
-- [Review] Char(500) NULL,
-- [ReviewedDate] Datetime NULL,
-- [MovieID] Int NOT NULL,
--)
--go

---- Add keys for table User_Review

--ALTER TABLE [User].[User_Review] ADD CONSTRAINT [PK_UserReviewID] PRIMARY KEY ([UserReviewID])
--go
-- Table TimeSlot

--CREATE TABLE [TVShows].[Timeslot]
--(
-- [TimeSlotID] Int NOT NULL,
-- [Slot] Varchar(150) NULL
--)
--go

---- Add keys for table TimeSlot

--ALTER TABLE [TVShows].[TimeSlot] ADD CONSTRAINT [PK_TimeSlotID] PRIMARY KEY ([TimeSlotID])
--go
-- Table Channels

--CREATE TABLE [TVShows].[Channels]
--(
-- [ChannelID] Int IDENTITY(1,1) NOT NULL,
-- [ChannelName] Varchar(150) NULL,
-- [Description] Varchar(500) NULL
--)
--go

---- Add keys for table Channels

--ALTER TABLE [TVShows].[Channels] ADD CONSTRAINT [PK_ChannelID] PRIMARY KEY ([ChannelID])
--go
-- Table Channel_TV_Show_Time_Slot

--CREATE TABLE [TVShows].[Channel_TV_Show_Time_Slot]
--(
-- [ChannelID] Int NOT NULL,
-- [TimeSlotID] Int NOT NULL,
-- [ShowID] Int NOT NULL,
-- [Date] Date NULL
--)
--go

---- Add keys for table Channel_TV_Show_Time_Slot

--ALTER TABLE [TVShows].[Channel_TV_Show_Time_Slot] ADD CONSTRAINT [PK_ChannelID_TimeSlotID_ShowID] PRIMARY KEY ([ChannelID],[TimeSlotID],[ShowID])
--go
-- Table Poll

--CREATE TABLE [User].[Poll]
--(
-- [PollID] Int IDENTITY(1,1) NOT NULL,
-- [OptionA] Varchar(150) NULL,
-- [OptionB] Varchar(150) NULL,
-- [CountA] Int NULL,
-- [CountB] Int NULL,
-- [Question] Varchar(300) NULL
--)
--go

---- Add keys for table Poll

--ALTER TABLE [User].[Poll] ADD CONSTRAINT [PK_PollID] PRIMARY KEY ([PollID])
--go
-- Table Season_Episodes

--CREATE TABLE [TVShows].[Season_Episodes]
--(
-- [ReleaseDate] Date NULL,
-- [ShowID] Int NOT NULL,
-- [SeasonID] Int NOT NULL,
-- [EpisodeID] Int NOT NULL
--)
--go

---- Create indexes for table Season_Episodes

--CREATE INDEX [IX_Relationship41] ON [TVShows].[Season_Episodes] ([ShowID],[SeasonID],[EpisodeID])
--go

---- Add keys for table Season_Episodes

--ALTER TABLE [TVShows].[Season_Episodes] ADD CONSTRAINT [PK_SeasonID_EpisodeID] PRIMARY KEY ([SeasonID],[EpisodeID])
--go
-- Table TVShows_Certification_Cnfg

--CREATE TABLE [TVShows].[TVShows_Certification_Cnfg]
--(
-- [CertificateID] Int IDENTITY(1,1) NOT NULL,
-- [Name] Char(10) NULL
--)
--go

---- Add keys for table TVShows_Certification_Cnfg

--ALTER TABLE [TVShows].[TVShows_Certification_Cnfg] ADD CONSTRAINT [PK_CertificateID] PRIMARY KEY ([CertificateID])
--go
---- Table TV_Shows

--CREATE TABLE [TVShows].[TV_Shows]
--(
-- [ShowID] Int IDENTITY(1,1) NOT NULL,
-- [Name] Char(30) NULL,
-- [Description] Char(100) NULL,
-- [ProductionCompanyID] Int NULL,
-- [Runtime] Char(5) NULL,
-- [SoundMix] Char(20) NULL,
-- [ColorID] Int NULL,
-- [AspectRatioID] Int NULL,
-- [Views] Int NULL,
-- [CountryID] Int NULL,
-- [Language] Char(15) NULL,
-- [CertificateID] Int NOT NULL,
--)
--go

---- Add keys for table TV_Shows

--ALTER TABLE [TVShows].[TV_Shows] ADD CONSTRAINT [PK_ShowID] PRIMARY KEY ([ShowID])
--go
---- Table Production_Company

--CREATE TABLE [Features].[Production_Company]
--(
-- [ProductionCompanyID] Int NOT NULL,
-- [ProductionCompanyName] Varchar(150) NULL,
-- [AddressID] Int NULL
--)
--go

---- Add keys for table Production_Company

--ALTER TABLE [Features].[Production_Company] ADD CONSTRAINT [PK_ProductionCompanyID] PRIMARY KEY ([ProductionCompanyID])
--go

-- Table Color

--CREATE TABLE [Features].[Color]
--(
-- [ColorID] Int IDENTITY(1,1) NOT NULL,
-- [ColorName] Nvarchar(15) NULL
--)
--go

---- Add keys for table Color

--ALTER TABLE [Features].[Color] ADD CONSTRAINT [PK_ColorID] PRIMARY KEY ([ColorID])
--go
-- Table Aspect_Ratio

--CREATE TABLE [Features].[Aspect_Ratio]
--(
-- [AspectRatioID] Int IDENTITY(1,1) NOT NULL,
-- [AspectRatio] Nvarchar(15) NULL
--)
--go

---- Add keys for table Aspect_Ratio

--ALTER TABLE [Features].[Aspect_Ratio] ADD CONSTRAINT [PK_AspectRatioID] PRIMARY KEY ([AspectRatioID])
--GO	
-- Table TVShow_Celebrity

--CREATE TABLE [Celebrity].[TVShow_Celebrity]
--(
-- [ShowID] Int NOT NULL,
-- [CelebrityID] Int NOT NULL,
--)
--go

---- Add keys for table TVShow_Celebrity

--ALTER TABLE [Celebrity].[TVShow_Celebrity] ADD CONSTRAINT [PK_ShowID_CelebrityID] PRIMARY KEY ([ShowID],[CelebrityID])
--go
-- Table Movie_Rating

--CREATE TABLE [Movies].[Movie_Rating]
--(
-- [MovieRatingID] Int IDENTITY(1,1) NOT NULL,
-- [MovieRatingName] Nvarchar(5) NULL
--)
--go

---- Add keys for table Movie_Rating

--ALTER TABLE [Movies].[Movie_Rating] ADD CONSTRAINT [PK_MovieRatingID] PRIMARY KEY ([MovieRatingID])
--go
---- Table Show_Cnfg

--CREATE TABLE [Theatre].[Show_Cnfg]
--(
-- [ShowTypeID] Int IDENTITY(1,1) NOT NULL,
-- [Name] Char(10) NULL
--)
--go

---- Add keys for table Show_Cnfg

--ALTER TABLE [Theatre].[Show_Cnfg] ADD CONSTRAINT [PK_ShowTypeID] PRIMARY KEY ([ShowTypeID])
--go
---- Table Showtimes

--CREATE TABLE [Theatre].[Showtimes]
--(
-- [ShowtimesID] Int IDENTITY(1,1) NOT NULL,
-- [Timeslot] Char(10) NULL,
-- [ShowTypeID] Int NOT NULL
--)
--go

---- Add keys for table Showtimes

--ALTER TABLE [Theatre].[Showtimes] ADD CONSTRAINT [PK_ShowtimesID] PRIMARY KEY ([ShowtimesID])
--go
-- Table Genre_Cnfg

--CREATE TABLE [Movies].[Genre_Cnfg]
--(
-- [GenreID] Int IDENTITY(1,1) NOT NULL,
-- [Name] Char(20) NULL
--)
--go

---- Add keys for table Genre_Cnfg

--ALTER TABLE [Movies].[Genre_Cnfg] ADD CONSTRAINT [PK_GenreID] PRIMARY KEY ([GenreID])
--go

---- Table Movie

--CREATE TABLE [Movies].[Movie]
--(
-- [MovieID] Int IDENTITY(1,1) NOT NULL,
-- [MovieName] Nvarchar(20) NULL,
-- [MovieDescription] Nvarchar(100) NULL,
-- [MetacriticReview] Float NULL,
-- [StoryLine] Nvarchar(50) NULL,
-- [Language] Char(10) NULL,
-- [Budget] Money NULL,
-- [ReleaseDate] Date NULL,
-- [CountryID] Int NOT NULL,
-- [RunTime] Int NULL,
-- [AspectRatioID] Int NOT NULL,
-- [ColorID] Int NOT NULL,
-- [ProductionCompanyID] Int NOT NULL,
-- [Views] Int NULL,
-- [GrossRevenue] Money NULL,
-- [MovieRatingID] Int NOT NULL,
-- [GenreID] Int NOT NULL
--)
--go

---- Add keys for table Movie

--ALTER TABLE [Movies].[Movie] ADD CONSTRAINT [PK_MovieID] PRIMARY KEY ([MovieID])
--go
---- Table Celebrity

--CREATE TABLE [Celebrity].[Celebrity]
--(
-- [CelebrityID] Int IDENTITY(1,1) NOT NULL,
-- [CelebrityName] Nvarchar(15) NULL,
-- [CelebrityDOB] Date NULL,
-- [Country] Nvarchar(15) NULL,
-- [Description] Nvarchar(30) NULL,
-- [AlternateName] Nvarchar(15) NULL,
-- [PersonalQuote] Nvarchar(20) NULL,
-- [StarSign] Nvarchar(10) NULL,
-- [Height] Nvarchar(5) NULL,
-- [Views] Int NULL,
-- [CelebrityTypeID] Int NOT NULL
--)
--go

---- Add keys for table Celebrity

--ALTER TABLE [Celebrity].[Celebrity] ADD CONSTRAINT [PK_CelebrityID] PRIMARY KEY ([CelebrityID])
--go
-- Table Movie_Celebrity

--CREATE TABLE [Celebrity].[Movie_Celebrity]
--(
-- [MovieID] Int NOT NULL,
-- [CelebrityID] Int NOT NULL,
--)
--go

---- Add keys for table Movie_Celebrity

--ALTER TABLE [Celebrity].[Movie_Celebrity] ADD CONSTRAINT [PK_MovieID_CelebrityID] PRIMARY KEY ([MovieID],[CelebrityID])
--go
---- Table Theatre_Movie_Showtime

--CREATE TABLE [Theatre].[Theatre_Movie_Showtime]
--(
-- [ShowtimesID] Int NOT NULL,
-- [TheatreID] Int NOT NULL,
-- [MovieID] Int NOT NULL,
--)
--go

---- Add keys for table Theatre_Movie_Showtime

--ALTER TABLE [Theatre].[Theatre_Movie_Showtime] ADD CONSTRAINT [PK_ShowtimesID_TheatreID_MovieID] PRIMARY KEY ([ShowtimesID],[TheatreID],[MovieID])
--go
---- Table Phone

--CREATE TABLE [Theatre].[Phone]
--(
-- [PhoneID] Int IDENTITY(1,1) NOT NULL,
-- [Number] Char(12) NULL
--)
--go

---- Add keys for table Phone

--ALTER TABLE [Theatre].[Phone] ADD CONSTRAINT [PK_PhoneID] PRIMARY KEY ([PhoneID])
--go
---- Table Address

--CREATE TABLE [Features].[Address]
--(
-- [AddressID] Int IDENTITY(1,1) NOT NULL,
-- [AddressLine] Char(100) NULL,
-- [City] Char(30) NULL,
-- [StateID] Int NOT NULL,
-- [CountryID] Int NOT NULL,
-- [PostalCode] Char(6) NULL
--)
--go

---- Add keys for table Address

--ALTER TABLE [Features].[Address] ADD CONSTRAINT [PK_AddressID] PRIMARY KEY ([AddressID])
--GO

---- Table Theatre

--CREATE TABLE [Theatre].[Theatre]
--(
-- [TheatreID] Int IDENTITY(1,1) NOT NULL,
-- [AddressID] Int NOT NULL,
-- [Name] Char(50) NULL,
-- [PhoneID] Int NOT NULL,
--)
--go

---- Add keys for table Theatre

--ALTER TABLE [Theatre].[Theatre] ADD CONSTRAINT [PK_TheatreID] PRIMARY KEY ([TheatreID])
--go
---- Table State_Cnfg

--CREATE TABLE [Features].[State_Cnfg]
--(
-- [StateID] Int IDENTITY(1,1) NOT NULL,
-- [Name] Char(30) NULL
--)
--go

---- Add keys for table State_Cnfg

--ALTER TABLE [Features].[State_Cnfg] ADD CONSTRAINT [PK_StateID] PRIMARY KEY ([StateID])
--go
---- Table Country_Cnfg

--CREATE TABLE [Features].[Country_Cnfg]
--(
-- [CountryID] Int IDENTITY(1,1) NOT NULL,
-- [Name] Char(30) NULL
--)
--go

---- Add keys for table Country_Cnfg

--ALTER TABLE [Features].[Country_Cnfg] ADD CONSTRAINT [PK_CountryID] PRIMARY KEY ([CountryID])
--go

---- Table Week_Gross

--CREATE TABLE [Movies].[Week_Gross]
--(
-- [WeekGrossID] Int IDENTITY(1,1) NOT NULL,
-- [WeekNumber] Int NULL,
-- [Collection] Money NULL,
-- [MovieID] Int NOT NULL,
--)
--go

---- Add keys for table Week_Gross

--ALTER TABLE [Movies].[Week_Gross] ADD CONSTRAINT [PK_WeekGrossID] PRIMARY KEY ([WeekGrossID])
--go
---- Table Celebrity_Type

--CREATE TABLE [Celebrity].[Celebrity_Type]
--(
-- [CelebrityTypeID] Int IDENTITY(1,1) NOT NULL,
-- [CelebrityTypeName] Nvarchar(1) NULL
--)
--go

---- Add keys for table Celebrity_Type

--ALTER TABLE [Celebrity].[Celebrity_Type] ADD CONSTRAINT [PK_CelebrityTypeID] PRIMARY KEY ([CelebrityTypeID])
--go
---- Table Video_Type

--CREATE TABLE [Details].[Video_Type]
--(
-- [VideoTypeID] Int IDENTITY(1,1) NOT NULL,
-- [VideoName] Nvarchar(10) NULL,
--)
--go

---- Add keys for table Video_Type

--ALTER TABLE [Details].[Video_Type] ADD CONSTRAINT [PK_VideoTypeID] PRIMARY KEY ([VideoTypeID])
--go
---- Table Amazon_Videos

--CREATE TABLE [Details].[Amazon_Videos]
--(
-- [AmazonVideoID] Int IDENTITY(1,1) NOT NULL,
-- [URL] Char(30) NULL,
-- [EntityID] Int NOT NULL,
-- [EntityTypeID] Int NOT NULL,
-- [Views] Int NULL,
-- [DateAdded] Date NULL
--)
--go

---- Add keys for table Amazon_Videos

--ALTER TABLE [Details].[Amazon_Videos] ADD CONSTRAINT [PK_AmazonVideoID] PRIMARY KEY ([AmazonVideoID])
--go
---- Table Videos

--CREATE TABLE [Details].[Videos]
--(
-- [VideosID] Int IDENTITY(1,1) NOT NULL,
-- [EntityID] Int NOT NULL,
-- [EntityTypeID] Int NOT NULL,
-- [URL] Nvarchar(30) NULL,
-- [VideoTypeID] Int NULL
--)
--go

---- Add keys for table Videos

--ALTER TABLE [Details].[Videos] ADD CONSTRAINT [PK_VideosID] PRIMARY KEY ([VideosID])
--go
---- Table [Details].[Images]

--CREATE TABLE [Details].[Images]
--(
-- [ImageID] Int IDENTITY(1,1) NOT NULL,
-- [EntityID] Int NOT NULL,
-- [EntityTypeID] Int NOT NULL,
-- [ImageBlob] Varbinary(max) NULL
--)
--go

---- Add keys for table [Details].[Images]

--ALTER TABLE [Details].[Images] ADD CONSTRAINT [PK_ImageID] PRIMARY KEY ([ImageID])
--go
---- Table Recently_Viewed

--CREATE TABLE [Details].[Recently_Viewed]
--(
-- [RecentlyViewedID] Int IDENTITY(1,1) NOT NULL,
-- [EntityID] Int NOT NULL,
-- [EntityTypeID] Int NOT NULL
--)
--go

---- Add keys for table Recently_Viewed

--ALTER TABLE [Details].[Recently_Viewed] ADD CONSTRAINT [PK_RecentlyViewdID] PRIMARY KEY ([RecentlyViewedID])
--go
---- Table Blue_Ray_DVD

--CREATE TABLE [Details].[Blue_Ray_DVD]
--(
-- [BlueRayDvdID] Int IDENTITY(1,1) NOT NULL,
-- [EntityID] Int NOT NULL,
-- [EntityTypeID] Int NOT NULL
--)
--go

---- Add keys for table Blue_Ray_DVD

--ALTER TABLE [Details].[Blue_Ray_DVD] ADD CONSTRAINT [BlueRayDvdID] PRIMARY KEY ([BlueRayDvdID])
--go
---- Table Trivias

--CREATE TABLE [Details].[Trivias]
--(
-- [TriviasID] Int IDENTITY(1,1) NOT NULL,
-- [EntityID] Int NOT NULL,
-- [EntityTypeID] Int NOT NULL,
-- [Trivia] Char(200) NULL
--)
--go

---- Add keys for table Trivias

--ALTER TABLE [Details].[Trivias] ADD CONSTRAINT [PK_TriviasID] PRIMARY KEY ([TriviasID])
--go

---- Table Goofs

--CREATE TABLE [Details].[Goofs]
--(
-- [GoofsID] Int IDENTITY(1,1) NOT NULL,
-- [EntityID] Int NOT NULL,
-- [EntityTypeID] Int NOT NULL,
-- [Goof] Char(200) NULL
--)
--go

---- Add keys for table Goofs

--ALTER TABLE [Details].[Goofs] ADD CONSTRAINT [PK_GoofsID] PRIMARY KEY ([GoofsID])
--go
---- Table Winers

---- Table News

--CREATE TABLE [Details].[News]
--(
-- [NewsID] Int IDENTITY(1,1) NOT NULL,
-- [News] Char(500) NULL,
-- [EntityID] Int NOT NULL,
-- [EntityTypeID] Int NOT NULL,
-- [Views] Int NULL,
-- [Headlines] Char(50) NULL
--)
--go

---- Add keys for table News

--ALTER TABLE [Details].[News] ADD CONSTRAINT [PK_NewsID] PRIMARY KEY ([NewsID])
--go
---- Table Winners

--CREATE TABLE [Awards].[Winners]
--(
-- [WinnerID] Int IDENTITY(1,1) NOT NULL,
-- [AwardID] Int NOT NULL,
-- [CategoryID] Int NOT NULL,
-- [EntityID] Int NOT NULL,
-- [EntityTypeID] Int NOT NULL,
-- [Year] Int NULL
--)
--go

---- Add keys for table Winners

--ALTER TABLE [Awards].[Winners] ADD CONSTRAINT [PK_WinnerID] PRIMARY KEY ([WinnerID])
--go
---- Table EntityType_Cnfg

--CREATE TABLE [Details].[EntityType_Cnfg]
--(
-- [EntityTypeID] Int IDENTITY(1,1) NOT NULL,
-- [EntityType] Char(20) NULL
--)
--go

---- Add keys for table EntityType_Cnfg

--ALTER TABLE [Details].[EntityType_Cnfg] ADD CONSTRAINT [PK_EntityTypeID] PRIMARY KEY ([EntityTypeID])
--go
---- Table Award_Category

--CREATE TABLE [Awards].[Award_Category]
--(
-- [CategoryID] Int IDENTITY(1,1) NOT NULL,
-- [CategoryName] Varchar(150) NULL
--)
--go

---- Add keys for table Award_Category

--ALTER TABLE [Awards].[Award_Category] ADD CONSTRAINT [PK_CategoryID] PRIMARY KEY ([CategoryID])
--go
---- Table Awards_Cnfg

--CREATE TABLE [Awards].[Awards_Cnfg]
--(
-- [AwardID] Int IDENTITY(1,1) NOT NULL,
-- [AwardName] Varchar(100) NULL
--)
--go

---- Add keys for table Awards_Cnfg

--ALTER TABLE [Awards].[Awards_Cnfg] ADD CONSTRAINT [PK_AwardID] PRIMARY KEY ([AwardID])
--GO


---- Table Soundtracks

--CREATE TABLE [Details].[Soundtracks]
--(
-- [SoundtrackID] Int IDENTITY(1,1) NOT NULL,
-- [EntityID] Int NULL,
-- [EntityTypeID] Int NULL,
-- [Name] Char(20) NULL,
-- [Playtime] Char(10) NULL,
-- [MusicDirectorID] Int NOT NULL,
-- [SingerID] Int NOT NULL,
--)
--GO
---- Add keys for table Soundtracks

--ALTER TABLE [Details].[Soundtracks] ADD CONSTRAINT [PK_Soundtrack] PRIMARY KEY ([SoundtrackID])
--GO

---- Table Nominee

--CREATE TABLE [Awards].[Nominee]
--(
-- [NomineeID] Int IDENTITY(1,1) NOT NULL,
-- [AwardID] Int NOT NULL,
-- [CategoryID] Int NOT NULL,
-- [EntityID] Int NOT NULL,
-- [EntityTypeID] Int NOT NULL,
-- [Year] Int NULL
--)
--go

---- Add keys for table Nominee

--ALTER TABLE [Awards].[Nominee] ADD CONSTRAINT [PK_NomineeID] PRIMARY KEY ([NomineeID])
--go


--FK

--ALTER TABLE [Awards].[Nominee] ADD CONSTRAINT [FK_CategoryID_AwardCategory] FOREIGN KEY ([CategoryID]) REFERENCES [Awards].[Award_Category] ([CategoryID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--GO

--ALTER TABLE [Awards].[Winners] ADD CONSTRAINT [FK_CategoryID_AwardCategory_Winners] FOREIGN KEY ([CategoryID]) REFERENCES [Awards].[Award_Category] ([CategoryID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Awards].[Winners] ADD CONSTRAINT [FK_AwardID_AwardsCnfg] FOREIGN KEY ([AwardID]) REFERENCES [Awards].[Awards_Cnfg] ([AwardID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Awards].[Nominee] ADD CONSTRAINT [FK_AwardID_AwardsCnfg_Nominee] FOREIGN KEY ([AwardID]) REFERENCES [Awards].[Awards_Cnfg] ([AwardID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [TVShows].[Channel_TV_Show_Time_Slot] ADD CONSTRAINT [FK_ShowID_TV_Shows] FOREIGN KEY ([ShowID]) REFERENCES [TVShows].[TV_Shows] ([ShowID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [TVShows].[Season_Episodes] ADD CONSTRAINT [FK_ShowID_TV_Shows_Season_Episodes] FOREIGN KEY ([ShowID]) REFERENCES [TVShows].[TV_Shows] ([ShowID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [TVShows].[Channel_TV_Show_Time_Slot] ADD CONSTRAINT [FK_TimeSlotID_Time_Slot] FOREIGN KEY ([TimeSlotID]) REFERENCES [TVShows].[TimeSlot] ([TimeSlotID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [TVShows].[Channel_TV_Show_Time_Slot] ADD CONSTRAINT [FK_ChannelID_Channels] FOREIGN KEY ([ChannelID]) REFERENCES [TVShows].[Channels] ([ChannelID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [TVShows].[TV_Shows] ADD CONSTRAINT [FK_CertificateID_TVSHows_Certification_Cnfg] FOREIGN KEY ([CertificateID]) REFERENCES [TVShows].[TVShows_Certification_Cnfg] ([CertificateID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [User].[User_Review] ADD CONSTRAINT [FK_UserID_User] FOREIGN KEY ([UserID]) REFERENCES [User].[User] ([UserID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [User].[User_Review] ADD CONSTRAINT [FK_MovieID_Movie] FOREIGN KEY ([MovieID]) REFERENCES [Movies].[Movie] ([MovieID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Movies].[Movie] ADD CONSTRAINT [FK_ProductionCompanyID_ProductionCompany] FOREIGN KEY ([ProductionCompanyID]) REFERENCES [Features].[Production_Company] ([ProductionCompanyID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--GO

--ALTER TABLE [Movies].[Movie] ADD CONSTRAINT [FK_ColorID_Color] FOREIGN KEY ([ColorID]) REFERENCES [Features].[Color] ([ColorID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Movies].[Movie] ADD CONSTRAINT [FK_AspectRatioID_AspectRatio] FOREIGN KEY ([AspectRatioID]) REFERENCES [Features].[Aspect_Ratio] ([AspectRatioID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Features].[Address] ADD CONSTRAINT [FK_CountryID_Country_Cnfg] FOREIGN KEY ([CountryID]) REFERENCES [Features].[Country_Cnfg] ([CountryID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Features].[Address] ADD CONSTRAINT [FK_StateID_State_Cnfg] FOREIGN KEY ([StateID]) REFERENCES [Features].[State_Cnfg] ([StateID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go

--ALTER TABLE [Theatre].[Theatre] ADD CONSTRAINT [FK_PhoneID_Phone] FOREIGN KEY ([PhoneID]) REFERENCES [Theatre].[Phone] ([PhoneID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Theatre].[Theatre] ADD CONSTRAINT [FK_AddressID_Address] FOREIGN KEY ([AddressID]) REFERENCES [Features].[Address] ([AddressID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Theatre].[Showtimes] ADD CONSTRAINT [FK_ShowTypeID_Show_Cnfg] FOREIGN KEY ([ShowTypeID]) REFERENCES [Theatre].[Show_Cnfg] ([ShowTypeID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Movies].[Movie] ADD CONSTRAINT [FK_MovieRatingID_Movie_Rating] FOREIGN KEY ([MovieRatingID]) REFERENCES [Movies].[Movie_Rating] ([MovieRatingID]) ON UPDATE NO ACTION ON DELETE NO ACTION
----go
--ALTER TABLE [Theatre].[Theatre_Movie_Showtime] ADD CONSTRAINT [FK_MovieID_Movie_Theatre_Movie_Showtime] FOREIGN KEY ([MovieID]) REFERENCES [Movies].[Movie] ([MovieID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--GO	

--ALTER TABLE [Movies].[Week_Gross] ADD CONSTRAINT [FK_MovieID_Movie_Week_Gross] FOREIGN KEY ([MovieID]) REFERENCES [Movies].[Movie] ([MovieID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Details].[Trivias] ADD CONSTRAINT [FK_EntityTypeID_EntityTypeCnfg] FOREIGN KEY ([EntityTypeID]) REFERENCES [Details].[EntityType_Cnfg] ([EntityTypeID]) ON UPDATE NO ACTION ON DELETE NO ACTION
----go
--ALTER TABLE [Awards].[Nominee] ADD CONSTRAINT [FK_EntityTypeID_EntityTypeCnfg_Nominee] FOREIGN KEY ([EntityTypeID]) REFERENCES [Details].[EntityType_Cnfg] ([EntityTypeID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Details].[Recently_Viewed] ADD CONSTRAINT [FK_EntityTypeID_EntityTypeCnfg_Recently_Viewed] FOREIGN KEY ([EntityTypeID]) REFERENCES [Details].[EntityType_Cnfg] ([EntityTypeID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Details].[Images] ADD CONSTRAINT [FK_EntityTypeID_EntityTypeCnfg_Images] FOREIGN KEY ([EntityTypeID]) REFERENCES [Details].[EntityType_Cnfg] ([EntityTypeID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Details].[Videos] ADD CONSTRAINT [FK_EntityTypeID_EntityTypeCnfg_Videos] FOREIGN KEY ([EntityTypeID]) REFERENCES [Details].[EntityType_Cnfg] ([EntityTypeID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Details].[Amazon_Videos] ADD CONSTRAINT [FK_EntityTypeID_EntityTypeCnfg_Amazon_Videos] FOREIGN KEY ([EntityTypeID]) REFERENCES [Details].[EntityType_Cnfg] ([EntityTypeID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--GO	

--ALTER TABLE [Details].[Goofs] ADD CONSTRAINT [FK_EntityTypeID_EntityTypeCnfg_Goofs] FOREIGN KEY ([EntityTypeID]) REFERENCES [Details].[EntityType_Cnfg] ([EntityTypeID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Awards].[Winners] ADD CONSTRAINT [FK_EntityTypeID_EntityTypeCnfg_Winners] FOREIGN KEY ([EntityTypeID]) REFERENCES [Details].[EntityType_Cnfg] ([EntityTypeID]) ON UPDATE NO ACTION ON DELETE NO ACTION
----go
--ALTER TABLE [Details].[News] ADD CONSTRAINT [FK_EntityTypeID_EntityTypeCnfg_News] FOREIGN KEY ([EntityTypeID]) REFERENCES [Details].[EntityType_Cnfg] ([EntityTypeID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Details].[Soundtracks] ADD CONSTRAINT [FK_EntityTypeID_EntityTypeCnfg_Sound_Tracks] FOREIGN KEY ([EntityTypeID]) REFERENCES [Details].[EntityType_Cnfg] ([EntityTypeID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go

--ALTER TABLE [Details].[Videos] ADD CONSTRAINT [FK_VideoTypeID_Video_type] FOREIGN KEY ([VideoTypeID]) REFERENCES [Details].[Video_Type] ([VideoTypeID]) ON UPDATE NO ACTION ON DELETE NO ACTION
----go
--ALTER TABLE [Details].[Blue_Ray_DVD] ADD CONSTRAINT [FK_EntityTypeID_EntityTypeCnfg_Blue_Ray_DVD] FOREIGN KEY ([EntityTypeID]) REFERENCES [Details].[EntityType_Cnfg] ([EntityTypeID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Celebrity].[TVShow_Celebrity] ADD CONSTRAINT [FK_CelebrityID_Celebrity] FOREIGN KEY ([CelebrityID]) REFERENCES [Celebrity].[Celebrity] ([CelebrityID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Celebrity].[TVShow_Celebrity] ADD CONSTRAINT [FK_ShowID_TV_Shows] FOREIGN KEY ([ShowID]) REFERENCES [TVShows].[TV_Shows] ([ShowID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Celebrity].[Movie_Celebrity] ADD CONSTRAINT [FK_CelebrityID_Celebrity_Movie_Celebrity] FOREIGN KEY ([CelebrityID]) REFERENCES [Celebrity].[Celebrity] ([CelebrityID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Celebrity].[Movie_Celebrity] ADD CONSTRAINT [FK_MovieID_Movie_Movie_Celebrity] FOREIGN KEY ([MovieID]) REFERENCES [Movies].[Movie] ([MovieID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Theatre].[Theatre_Movie_Showtime] ADD CONSTRAINT [FK_ShowTimesID_Showtimes] FOREIGN KEY ([ShowtimesID]) REFERENCES [Theatre].[Showtimes] ([ShowtimesID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Celebrity].[Celebrity] ADD CONSTRAINT [FK_CelebrityTypeID_Celebrity_Type] FOREIGN KEY ([CelebrityTypeID]) REFERENCES [Celebrity].[Celebrity_Type] ([CelebrityTypeID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Theatre].[Theatre_Movie_Showtime] ADD CONSTRAINT [FK_TheatreID_Theatre] FOREIGN KEY ([TheatreID]) REFERENCES [Theatre].[Theatre] ([TheatreID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--GO

--ALTER TABLE [Details].[Soundtracks] ADD CONSTRAINT [FK_SingerID_Celebrity] FOREIGN KEY ([SingerID]) REFERENCES [Celebrity].[Celebrity] ([CelebrityID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Details].[Soundtracks] ADD CONSTRAINT [FK_MusicDirector_Celebrity] FOREIGN KEY ([MusicDirectorID]) REFERENCES [Celebrity].[Celebrity] ([CelebrityID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Movies].[Movie] ADD CONSTRAINT [FK_GenreID_Genre_Cnfg] FOREIGN KEY ([GenreID]) REFERENCES [Movies].[Genre_Cnfg] ([GenreID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [Movies].[Movie] ADD CONSTRAINT [FK_CountryID_Country_Cnfg_Movie] FOREIGN KEY ([CountryID]) REFERENCES [Features].[Country_Cnfg] ([CountryID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [TVShows].[TV_Shows] ADD CONSTRAINT [FK_ColorID_Color_Movie] FOREIGN KEY ([ColorID]) REFERENCES [Features].[Color] ([ColorID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [TVShows].[TV_Shows] ADD CONSTRAINT [FK_ProductionCompanyID_Production_Company_TVShows] FOREIGN KEY ([ProductionCompanyID]) REFERENCES [Features].[Production_Company] ([ProductionCompanyID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--GO

--ALTER TABLE [TVShows].[TV_Shows] ADD CONSTRAINT [FK_AspectRatioID_Aspect_Ratio_TVSHows] FOREIGN KEY ([AspectRatioID]) REFERENCES [Features].[Aspect_Ratio] ([AspectRatioID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--go
--ALTER TABLE [TVShows].[TV_Shows] ADD CONSTRAINT [FK_CountryID_Country_Cnfg_TVShows] FOREIGN KEY ([CountryID]) REFERENCES [Features].[Country_Cnfg] ([CountryID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--GO


--ALTER TABLE [Features].[Production_Company] ADD CONSTRAINT [FK_AddressID_Address_ProductionCompany] FOREIGN KEY ([AddressID]) REFERENCES [Features].[Address] ([AddressID]) ON UPDATE NO ACTION ON DELETE NO ACTION
--GO
