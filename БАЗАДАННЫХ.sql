create database WebTech;
use WebTech;

CREATE TABLE `apartment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apartmentName` varchar(45) NOT NULL,
  `roomCount` int NOT NULL DEFAULT '1',
  `price` int NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) unique,
  `userPassword` varchar(45) NOT NULL,
  `userRole` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  `idApartment` int ,
  KEY `FK_Apartment` (`idApartment`),
  CONSTRAINT `FK_Apartment` FOREIGN KEY (`idApartment`) REFERENCES `apartment` (`id`)
);

INSERT INTO `webtech`.`apartment` (`apartmentName`, `roomCount`, `price`, `isBooked`) VALUES ('Room1', '1', '250', '0');
INSERT INTO `webtech`.`apartment` (`apartmentName`, `roomCount`, `price`, `isBooked`) VALUES ('Room2', '2', '500', '0');
INSERT INTO `webtech`.`apartment` (`apartmentName`, `roomCount`, `price`, `isBooked`) VALUES ('Room3', '3', '750', '0');
INSERT INTO `webtech`.`apartment` (`apartmentName`, `roomCount`, `price`, `isBooked`) VALUES ('Room4', '4', '1000', '0');

INSERT INTO `webtech`.`user` (`userName`, `userPassword`, `userRole`) VALUES ('Admin', 'Admin', '1');