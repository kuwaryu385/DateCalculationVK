--CREATE DATABASE IF NOT EXISTS同じ名前のデータベースがあっても複製できるよー
--CREATE DATABASE IF NOT EXISTS `datecalculationvk`;
--データベースを指定
--USE `datecalculationvk`;
-- テーブルが存在していればテーブルを消す
--DROP TABLE IF EXISTS `dateformula`;
--同じテーブル名があっても複製できるよー
CREATE TABLE IF NOT EXISTS dateformula(
          dateId          varchar  (6)               NOT NULL  PRIMARY KEY
         ,dateName        varchar  (32)
         ,adjustmentYear  int      (2)    Default 0  NOT NULL
         ,adjustmentMonth int      (3)    Default 0  NOT NULL
         ,adjustmentDay   int      (4)    Default 0  NOT NULL
);

