SHOW DATABASES; 
 USE `project1`; 
SHOW FULL TABLES FROM `project1` WHERE table_type = 'BASE TABLE'; 
SHOW CHARSET; 

CREATE TABLE `project1`.`Administrator_Login`( 
    `User_Id` VARCHAR(30) NOT NULL,
    `Password` VARCHAR(30), 
     PRIMARY KEY (`User_Id`)
 );


/*[5:06:56 AM][346 ms]*/ 
CREATE TABLE `project1`.`Property_Approval`(
     `User_Id` VARCHAR(30) NOT NULL,
     `Property_Id` VARCHAR(30) NOT NULL,
     `Approval_Status` VARCHAR(30) NOT NULL,
     `Approval_Description` TEXT NOT NULL,
      CONSTRAINT `fk_userid` FOREIGN KEY (`User_Id`)
      REFERENCES `project1`.`administrator_login`(`User_Id`) 
); 



/*[5:09:05 AM][187 ms]*/ 
CREATE TABLE `project1`.`Property_Location_Master`( 
    `Location_id` VARCHAR(30) NOT NULL,
    `Country` VARCHAR(50) NOT NULL,
    `State` VARCHAR(50) NOT NULL,
    `City` VARCHAR(50),
    `Locality` VARCHAR(50),
    PRIMARY KEY (`Location_id`)
 ); 

 
/*[5:11:45 AM][370 ms]*/ 
CREATE TABLE `project1`.`Advertisement_Subscription_Detail`( 
    `Package_Id` VARCHAR(10) NOT NULL,
    `Requestor_Id` VARCHAR(30) NOT NULL,
    `Duration` INT UNSIGNED NOT NULL,
    `Dimension` VARCHAR(10) NOT NULL,
    `Advertisement_Start_Date` DATETIME NOT NULL,
    `Advertisement_End_Date` DATETIME 
); 


/*[5:14:55 AM][3203 ms]*/ 
CREATE TABLE `project1`.`Advertisement_Package`( 
    `Package_Id` VARCHAR(10) NOT NULL, 
    `BannerDimension` VARCHAR(50) NOT NULL, 
    `BannerImageSize` VARCHAR(10) NOT NULL, 
    `BannerTextSize` VARCHAR(20) NOT NULL, 
    `CostPerDay` FLOAT(12,2) NOT NULL, 
    `Week_Discount` INT UNSIGNED NOT NULL, 
    `Month_Discount` INT UNSIGNED NOT NULL, 
    `Year_Discount` INT UNSIGNED NOT NULL, 
     PRIMARY KEY (`Package_Id`) 
); 


/*[5:18:10 AM][422 ms]*/ 
CREATE TABLE `project1`.`Buyer_Member_Detail`( 
    `Member_Id` VARCHAR(30) NOT NULL, 
    `Location_Id` VARCHAR(30) NOT NULL, 
    `Property_Area` INT UNSIGNED NOT NULL, 
    `Property_Budget` FLOAT(12,2) NOT NULL, 
    CONSTRAINT `fk_locationid` FOREIGN KEY (`Location_Id`) 
    REFERENCES `project1`.`property_location_master`(`Location_id`)
 ); 



/*[5:19:50 AM][388 ms]*/ 
CREATE TABLE `project1`.`Agent_Member_Detail`( 
    `Member_Id` VARCHAR(30) NOT NULL, 
    `Agent_Type` VARCHAR(30) NOT NULL, 
    `Location_Id` VARCHAR(30) NOT NULL, 
    CONSTRAINT `fk_locationid` FOREIGN KEY (`Location_Id`) 
    REFERENCES `project1`.`property_location_master`(`Location_id`)
 ); 


/*[5:20:20 AM][300 ms]*/ 
CREATE TABLE `project1`.`Agent_Member_Detail`( 
    `Member_Id` VARCHAR(30) NOT NULL, 
    `Agent_Type` VARCHAR(30) NOT NULL, 
    `Location_Id` VARCHAR(30) NOT NULL, 
    CONSTRAINT `fk1_locationid` FOREIGN KEY (`Location_Id`) 
    REFERENCES `project1`.`property_location_master`(`Location_id`) 
); 



/*[5:25:00 AM][357 ms]*/ 
CREATE TABLE `project1`.`Member_Detail`( 
    `Member_Id` VARCHAR(30) NOT NULL, 
    `Member_Name` VARCHAR(50) NOT NULL, 
    `Address` VARCHAR(256) NOT NULL, 
    `Pincode` CHAR(6) NOT NULL, 
    `Phone_Number` VARCHAR(20) NOT NULL, 
    `Mobile_Number` VARCHAR(15) NOT NULL, 
    `Email_Id` VARCHAR(50) NOT NULL, 
    `Newsletter_Subscription` ENUM('yes','no'), 
    `Password` VARCHAR(15) NOT NULL,
    `Member_Category_Id` VARCHAR(10) NOT NULL, 
    PRIMARY KEY (`Member_Id`)
 ); 


/*[5:26:54 AM][261 ms]*/ 
CREATE TABLE `project1`.`Member_Category_Master`( 
    `Member_Category_Id` VARCHAR(10) NOT NULL, 
    `Member_Category_Name` VARCHAR(50) NOT NULL, 
    `Member_Category_Description` VARCHAR(256) NOT NULL, 
    PRIMARY KEY (`Member_Category_Id`) 
); 


/*[5:28:52 AM][212 ms]*/ 
CREATE TABLE `project1`.`Property_Category_Master`( 
    `Category_Id` VARCHAR(10) NOT NULL, 
    `Category_Description` TEXT NOT NULL, 
    `Buyer_Commission` FLOAT(12,2) NOT NULL, 
    `Seller_Commission` FLOAT(12,2) NOT NULL, 
    `Agent_Commission` FLOAT(12,2) NOT NULL, 
    PRIMARY KEY (`Category_Id`) 
); 


/*[5:33:24 AM][226 ms]*/ 
CREATE TABLE `project1`.`Property_Details`( 
    `Property_Id` VARCHAR(30) NOT NULL, 
    `Category_Id` VARCHAR(10) NOT NULL, 
    `Country` VARCHAR(126) NOT NULL, 
    `State` VARCHAR(126) NOT NULL, 
    `City` VARCHAR(126), 
    `Region` VARCHAR(126), 
    `Posted_By` VARCHAR(30) NOT NULL, 
    `Area` INT(30) NOT NULL, 
    `Rate` FLOAT(12,2), 
    `Lumpsum_Cost` FLOAT(12,2), 
    `Image` BLOB, 
    PRIMARY KEY (`Property_Id`), 
    CONSTRAINT `fk_categoryid` FOREIGN KEY (`Category_Id`) 
    REFERENCES `project1`.`property_category_master`(`Category_Id`)
 ); 


/*[5:33:32 AM][64 ms]*/ 
DESCRIBE `project1`.`administrator_login`; 


/*[5:35:32 AM][745 ms]*/ 
ALTER TABLE `project1`.`Property_Approval` ADD CONSTRAINT `fk_propertyid` FOREIGN KEY (`Property_Id`) REFERENCES `project1`.`property_details`(`Property_Id`); 


/*[5:39:38 AM][650 ms]*/ 
ALTER TABLE `project1`.`Advertisement_Subscription_Detail` ADD CONSTRAINT `fk_packageid` FOREIGN KEY (`Package_Id`) REFERENCES `project1`.`advertisement_package`(`Package_Id`); 



/*[5:40:58 AM][740 ms]*/ 
ALTER TABLE `project1`.`Advertisement_Subscription_Detail` ADD CONSTRAINT `fk_requestorid` FOREIGN KEY (`Requestor_Id`) REFERENCES `project1`.`member_detail`(`Member_Id`); 


/*[5:42:53 AM][527 ms]*/ 
ALTER TABLE `project1`.`Buyer_Member_Detail` DROP FOREIGN KEY `fk_locationid`, ADD CONSTRAINT `fk_memberid` FOREIGN KEY (`Member_Id`) REFERENCES `project1`.`member_detail`(`Member_Id`); 


/*[5:43:23 AM][1410 ms]*/ 
ALTER TABLE `project1`.`Buyer_Member_Detail` ADD CONSTRAINT `fk_locationid` FOREIGN KEY (`Location_Id`) REFERENCES `project1`.`property_location_master`(`Location_id`); 


/*[5:44:01 AM][218 ms]*/ 
ALTER TABLE `project1`.`Agent_Member_Detail` DROP FOREIGN KEY `fk1_locationid`, ADD CONSTRAINT `fk_memberid` FOREIGN KEY (`Member_Id`) REFERENCES `project1`.`member_detail`(`Member_Id`); 

/*[5:44:08 AM][623 ms]*/ 
ALTER TABLE `project1`.`Agent_Member_Detail` DROP FOREIGN KEY `fk1_locationid`, ADD CONSTRAINT `fk1_memberid` FOREIGN KEY (`Member_Id`) REFERENCES `project1`.`member_detail`(`Member_Id`); 


/*[5:44:31 AM][222 ms]*/ 
ALTER TABLE `project1`.`Agent_Member_Detail` ADD CONSTRAINT `fk_locationid` FOREIGN KEY (`Location_Id`) REFERENCES `project1`.`property_location_master`(`Location_id`); 

/*[5:44:38 AM][580 ms]*/ 
ALTER TABLE `project1`.`Agent_Member_Detail` ADD CONSTRAINT `fk1_locationid` FOREIGN KEY (`Location_Id`) REFERENCES `project1`.`property_location_master`(`Location_id`); 


/*[5:45:24 AM][510 ms]*/ 
ALTER TABLE `project1`.`Member_Detail` ADD CONSTRAINT `fk_membercategoryid` FOREIGN KEY (`Member_Category_Id`) REFERENCES `project1`.`member_category_master`(`Member_Category_Id`); 
