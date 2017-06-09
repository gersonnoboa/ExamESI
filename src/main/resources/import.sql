INSERT INTO USER(_ID, BITCOINS, NAME, USER_ROLE) VALUES ('1', 1000, 'Guest 1', 'GUEST');
INSERT INTO USER(_ID, BITCOINS, NAME, USER_ROLE) VALUES ('2', 1000, 'Guest 2', 'GUEST');
INSERT INTO USER(_ID, BITCOINS, NAME, USER_ROLE) VALUES ('3', 1000, 'Guest 3', 'GUEST');
INSERT INTO USER(_ID, BITCOINS, NAME, USER_ROLE) VALUES ('4', 100, 'Host', 'HOST');

INSERT INTO PROPERTY(_ID, ADDRESS, AMENITIES, AREA, BEDS, CITY, FLOOR, HAS_AIR_CONDITIONING, HAS_INTERNET_ACCESS, HAS_KITCHEN, PRICE, OWNER__ID, FREE) VALUES('1', 'Address', 'None', 30, 2, 'Guayaquil', 3, TRUE, TRUE, TRUE, 10, '4', FALSE);
INSERT INTO PROPERTY(_ID, ADDRESS, AMENITIES, AREA, BEDS, CITY, FLOOR, HAS_AIR_CONDITIONING, HAS_INTERNET_ACCESS, HAS_KITCHEN, PRICE, OWNER__ID, FREE) VALUES('2', 'Address', 'None', 30, 2, 'Quito', 3, TRUE, TRUE, TRUE, 20, '4', TRUE);
INSERT INTO PROPERTY(_ID, ADDRESS, AMENITIES, AREA, BEDS, CITY, FLOOR, HAS_AIR_CONDITIONING, HAS_INTERNET_ACCESS, HAS_KITCHEN, PRICE, OWNER__ID, FREE) VALUES('3', 'Address', 'None', 30, 2, 'Cuenca', 3, TRUE, TRUE, TRUE, 30, '4', TRUE);
INSERT INTO PROPERTY(_ID, ADDRESS, AMENITIES, AREA, BEDS, CITY, FLOOR, HAS_AIR_CONDITIONING, HAS_INTERNET_ACCESS, HAS_KITCHEN, PRICE, OWNER__ID, FREE) VALUES('4', 'Address', 'None', 30, 2, 'Ambato', 3, TRUE, TRUE, TRUE, 40, '4', TRUE);

INSERT INTO RENTAL(_ID, END_DATE, START_DATE, STATUS, PROPERTY__ID, USER__ID) VALUES('1', '2017-07-15', '2017-07-01', 'ACCEPTED', '1', '1');