DROP TABLE IF EXISTS TBL_EMPLOYEES;

CREATE TABLE TBL_GUEST (
                               id INT AUTO_INCREMENT  PRIMARY KEY,
                               firstName VARCHAR(250) NOT NULL,
                               lastName VARCHAR(250) NOT NULL,
                               age INT,
                               gender INT DEFAULT 3
);

DROP TABLE IF EXISTS TBL_HOTELDETAIL;

CREATE TABLE TBL_HOTELDETAIL (
                           id INT AUTO_INCREMENT  PRIMARY KEY,
                           hotel_name VARCHAR(250) NOT NULL,
                           price INT,
                           availability BOOL DEFAULT false
);