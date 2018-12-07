CREATE TABLE `user` (
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `repassword` VARCHAR(45) NULL,
  `usertype` VARCHAR(45) NULL);

CREATE TABLE `orders` (
  `OrderId` INT NOT NULL,
  `userName` VARCHAR(45) NOT NULL,
  `orderName` VARCHAR(85) NOT NULL,
  `orderPrice` VARCHAR(85) NULL,
  `userAddress` VARCHAR(85) NULL,
  `creditCardNo` VARCHAR(85) NULL,
  `orderTime` DATE NULL,
  `Location` VARCHAR(85) NULL,
  `totalcost` DOUBLE NULL,
  `days` DOUBLE NULL
  );

CREATE TABLE `productdetails` (
  `ProductType` VARCHAR(85) NULL,
  `id` VARCHAR(11) NULL,
  `productName` VARCHAR(85) NULL,
  `productPrice` DOUBLE NULL,
  `productImage` VARCHAR(85) NULL,
  `productCondition` VARCHAR(85) NULL,
  `productDiscount` DOUBLE NULL,
  `inventory` INT NOT NULL DEFAULT '5',
  `HrPrice` DOUBLE NULL,
  `FullPrice` DOUBLE NULL);

SELECT * FROM orders;

select * from user;

select * from productdetails;