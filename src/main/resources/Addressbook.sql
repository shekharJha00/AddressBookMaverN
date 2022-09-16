CREATE DATABASE Address_Book_Service;
use Address_book_Service;
CREATE  TABLE address_book(`firstName` VARCHAR(120)  NOT NULL , `lastName` VARCHAR(120) NOT NULL , `Address`  VARCHAR(150) NOT NULL , `City` VARCHAR(150) NOT NULL , `State` VARCHAR(120) NOT NULL , `Zip` INT NOT NULL , `PhoneNumber`  DOUBLE NOT NULL   ,   PRIMARY KEY (`firstName`)  );
SELECT * From address_book;
INSERT INTO `address_book_service`.`address_book` (`firstName`, `lastName`, `Address`, `City`, `State`, `Zip`, `PhoneNumber`) VALUES ('Shekhar', 'Jha', 'Namkum,ranchi', 'Ranchi', 'Jharkhand', '834010', '8340180222');
INSERT INTO `address_book_service`.`address_book` (`firstName`, `lastName`, `Address`, `City`, `State`, `Zip`, `PhoneNumber`) VALUES ('Naman', 'Nagwani', 'Chattisgarh', 'Chattisgarh', 'Chattisgarh', '12345', '8888888888');
UPDATE address_book SET Address = ‘Chennai’ WHERE firstName = ‘Shekhar’ ;
UPDATE address_book SET PhoneNumber = 1234567788 WHERE firstName = ‘Naman’ ;
DELETE FROM address_book WHERE firstName = 'Naman' ;
SELECT * FROM address_book WHERE City = 'Ranchi' OR State = 'Jharkhand' ;
SELECT COUNT (city OR state )  FROM address_book ;
SELECT firstName, City FROM address_book ORDER BY firstName ;
ALTER TABLE  address_book ADD type VARCHAR(35) AFTER lastName;
UPDATE address_book SET type = ‘Family’ WHERE firstName = ‘Shekhar’;
UPDATE address_book SET type = ‘Friends’ WHERE firstName = ‘Naman’;
UPDATE address_book SET type = ‘Professional’ WHERE firstName = ‘Tekesh’;
SELECT * FROM address_book;
SELECT COUNT (type) AS  Number_of_ContactPerson  FROM address_book;