INSERT INTO TBL_GUEST (firstName, lastName, age, gender) VALUES
('Lokesh', 'Gupta', 27, 'male'),
('Deja', 'Vu', 35, 'female'),
('Caption', 'America', 18, 'undefined'),
('Wenshuo', 'Li', 27, 'male'),
('Tim', 'Horton', 35, 'female'),
('James', 'Bone', 18, 'undefined');

INSERT INTO TBL_HOTELDETAIL (hotel_name, price, availability) VALUES
('Holiday Inn', 375, true),
('Hilton Season Inn', 250, false),
('Saint Lawrence Residences and Suites',  435, true),
('Staybridge Suites', 340, true),
('Embassy Suites by Hilton', 550, false),
('Fairmont Royal York',  475, false);

INSERT INTO TBL_RESERVATION  (hotel_name, checkin, checkout, confirm) VALUES
('Staybridge Suites', '2021-05-06', '2021-05-07', '123456'),
('Embassy Suites by Hilton', '2021-05-03', '2021-06-06', '233456'),
('Fairmont Royal York',  '2021-05-01', '2021-05-10', '546897');

INSERT INTO TBL_RESERVATIONGUEST  (gid, rid) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3);