DROP TABLE IF EXISTS TBL_EMPLOYEES;

CREATE TABLE TBL_GUEST (
    gid INT AUTO_INCREMENT  PRIMARY KEY,
    firstName VARCHAR(250) NOT NULL,
    lastName VARCHAR(250) NOT NULL,
    age INT,
    gender VARCHAR(50)
);

DROP TABLE IF EXISTS TBL_HOTELDETAIL;

CREATE TABLE TBL_HOTELDETAIL (
    hid INT AUTO_INCREMENT  PRIMARY KEY,
    hotel_name VARCHAR(250) NOT NULL,
    price INT,
    availability BOOLEAN DEFAULT false
);

DROP TABLE IF EXISTS TBL_RESERVATION;

CREATE TABLE TBL_RESERVATION (
    rid INT AUTO_INCREMENT  PRIMARY KEY,
    hotel_name VARCHAR(250) NOT NULL,
    checkin DATE NOT NULL,
    checkout DATE NOT NULL
);

DROP TABLE IF EXISTS TBL_RESERVATIONGUEST;

CREATE TABLE TBL_RESERVATIONGUEST (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    gid INT NOT NULL,
    rid INT NOT NULL
);