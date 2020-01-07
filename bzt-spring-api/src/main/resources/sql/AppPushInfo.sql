/*
 Navicat Premium Data Transfer

 Source Server         : 139.129.206.58-sainput-sa1527ef
 Source Server Type    : SQL Server
 Source Server Version : 10501600
 Source Host           : 139.129.206.58:1433
 Source Catalog        : CCNBZB20191129
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 10501600
 File Encoding         : 65001

 Date: 31/12/2019 18:06:30
*/


-- ----------------------------
-- Table structure for AppPushInfo
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[AppPushInfo]') AND type IN ('U'))
	DROP TABLE [dbo].[AppPushInfo]
GO

CREATE TABLE [dbo].[AppPushInfo] (
  [Id] int  IDENTITY(1,1) NOT NULL,
  [ExhId] int  NOT NULL,
  [StfID] int  NOT NULL,
  [StfFullName] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [RegistrationId] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [NeedLinkCount] int  NOT NULL,
  [sendno] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [msg_id] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [CreatTime] datetime  NOT NULL,
  [ModifyTime] datetime  NULL,
  [SendDay] date  NOT NULL,
  [DataType] int  NOT NULL
)
GO

ALTER TABLE [dbo].[AppPushInfo] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'主键Id,自增',
'SCHEMA', N'dbo',
'TABLE', N'AppPushInfo',
'COLUMN', N'Id'
GO

EXEC sp_addextendedproperty
'MS_Description', N'展会Id',
'SCHEMA', N'dbo',
'TABLE', N'AppPushInfo',
'COLUMN', N'ExhId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'用户名Id',
'SCHEMA', N'dbo',
'TABLE', N'AppPushInfo',
'COLUMN', N'StfID'
GO

EXEC sp_addextendedproperty
'MS_Description', N'用户名称',
'SCHEMA', N'dbo',
'TABLE', N'AppPushInfo',
'COLUMN', N'StfFullName'
GO

EXEC sp_addextendedproperty
'MS_Description', N'设备唯一标识Id',
'SCHEMA', N'dbo',
'TABLE', N'AppPushInfo',
'COLUMN', N'RegistrationId'
GO

EXEC sp_addextendedproperty
'MS_Description', N'需要联系展商数量',
'SCHEMA', N'dbo',
'TABLE', N'AppPushInfo',
'COLUMN', N'NeedLinkCount'
GO

EXEC sp_addextendedproperty
'MS_Description', N'推送返回的sendno',
'SCHEMA', N'dbo',
'TABLE', N'AppPushInfo',
'COLUMN', N'sendno'
GO

EXEC sp_addextendedproperty
'MS_Description', N'推送返回的msg_id',
'SCHEMA', N'dbo',
'TABLE', N'AppPushInfo',
'COLUMN', N'msg_id'
GO

EXEC sp_addextendedproperty
'MS_Description', N'创建时间',
'SCHEMA', N'dbo',
'TABLE', N'AppPushInfo',
'COLUMN', N'CreatTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'修改时间',
'SCHEMA', N'dbo',
'TABLE', N'AppPushInfo',
'COLUMN', N'ModifyTime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'那一天的数据',
'SCHEMA', N'dbo',
'TABLE', N'AppPushInfo',
'COLUMN', N'SendDay'
GO

EXEC sp_addextendedproperty
'MS_Description', N'数据类型：1：今天待联系  2：明天待联系  3：催款',
'SCHEMA', N'dbo',
'TABLE', N'AppPushInfo',
'COLUMN', N'DataType'
GO

EXEC sp_addextendedproperty
'MS_Description', N'消息推送',
'SCHEMA', N'dbo',
'TABLE', N'AppPushInfo'
GO


-- ----------------------------
-- Auto increment value for AppPushInfo
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[AppPushInfo]', RESEED, 71)
GO


-- ----------------------------
-- Primary Key structure for table AppPushInfo
-- ----------------------------
ALTER TABLE [dbo].[AppPushInfo] ADD CONSTRAINT [PK__AppPushI__3214EC074AB0BEE8] PRIMARY KEY CLUSTERED ([Id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

