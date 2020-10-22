delete from user;
delete from specialties;
delete from vet_specialties;
delete from types;
delete from pets;
delete from visits;
delete from authority;
delete from user_authority;

INSERT INTO authority(ID, ROLE) VALUES ( 1, 'ADMIN');
INSERT INTO authority(ID, ROLE) VALUES ( 2, 'OWNER');
INSERT INTO authority(ID, ROLE) VALUES ( 3, 'VETS');
INSERT INTO authority(ID, ROLE) VALUES ( 4, 'GUEST');

--password = adminPass
INSERT INTO user(ID, USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED, FIRST_NAME, LAST_NAME, TELEPHONE, ADDRESS, CITY, DTYPE ) VALUES (1, 'admin',        '$2a$10$5LFYga2EHufPNbW/FNfpr.cT/SFlcNaXpf6KNiPkRZd9WM4iBOXma', 'TRUE', 'TRUE', 'TRUE', 'TRUE', 'James', 'Carter','01012345678','seoul','city', 'Vets');
INSERT INTO user(ID, USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED, FIRST_NAME, LAST_NAME, TELEPHONE, ADDRESS, CITY, DTYPE ) VALUES (2, 'username1',    '$2a$10$5LFYga2EHufPNbW/FNfpr.cT/SFlcNaXpf6KNiPkRZd9WM4iBOXma', 'TRUE', 'TRUE', 'TRUE', 'TRUE', 'Helen', 'Leary','01012345678','seoul','city', 'Vets');
INSERT INTO user(ID, USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED, FIRST_NAME, LAST_NAME, TELEPHONE, ADDRESS, CITY, DTYPE ) VALUES (3, 'username2',    '$2a$10$5LFYga2EHufPNbW/FNfpr.cT/SFlcNaXpf6KNiPkRZd9WM4iBOXma', 'TRUE', 'TRUE', 'TRUE', 'TRUE', 'Linda', 'Douglas','01012345678','seoul','city', 'Vets');
INSERT INTO user(ID, USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED, FIRST_NAME, LAST_NAME, TELEPHONE, ADDRESS, CITY, DTYPE ) VALUES (4, 'username3',    '$2a$10$5LFYga2EHufPNbW/FNfpr.cT/SFlcNaXpf6KNiPkRZd9WM4iBOXma', 'TRUE', 'TRUE', 'TRUE', 'TRUE', 'Rafael', 'Ortega','01012345678','seoul','city', 'Vets');
INSERT INTO user(ID, USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED, FIRST_NAME, LAST_NAME, TELEPHONE, ADDRESS, CITY, DTYPE ) VALUES (5, 'username4',    '$2a$10$5LFYga2EHufPNbW/FNfpr.cT/SFlcNaXpf6KNiPkRZd9WM4iBOXma', 'TRUE', 'TRUE', 'TRUE', 'TRUE', 'Henry', 'Stevens','01012345678','seoul','city', 'Vets');
INSERT INTO user(ID, USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED, FIRST_NAME, LAST_NAME, TELEPHONE, ADDRESS, CITY, DTYPE ) VALUES (6, 'username5',    '$2a$10$5LFYga2EHufPNbW/FNfpr.cT/SFlcNaXpf6KNiPkRZd9WM4iBOXma', 'TRUE', 'TRUE', 'TRUE', 'TRUE', 'Sharon', 'Jenkins','01012345678','seoul','city', 'Vets');

INSERT INTO user(ID, USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED, FIRST_NAME, LAST_NAME, TELEPHONE, ADDRESS, CITY, DTYPE ) VALUES (7, 'username6',    '$2a$10$5LFYga2EHufPNbW/FNfpr.cT/SFlcNaXpf6KNiPkRZd9WM4iBOXma', 'TRUE', 'TRUE', 'TRUE', 'TRUE', 'James', 'Carter','01012345678','seoul','city', 'Owner');
INSERT INTO user(ID, USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED, FIRST_NAME, LAST_NAME, TELEPHONE, ADDRESS, CITY, DTYPE ) VALUES (8, 'username7',    '$2a$10$5LFYga2EHufPNbW/FNfpr.cT/SFlcNaXpf6KNiPkRZd9WM4iBOXma', 'TRUE', 'TRUE', 'TRUE', 'TRUE', 'Helen', 'Leary','01012345678','seoul','city', 'Owner');
INSERT INTO user(ID, USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED, FIRST_NAME, LAST_NAME, TELEPHONE, ADDRESS, CITY, DTYPE ) VALUES (9, 'username8',    '$2a$10$5LFYga2EHufPNbW/FNfpr.cT/SFlcNaXpf6KNiPkRZd9WM4iBOXma', 'TRUE', 'TRUE', 'TRUE', 'TRUE', 'Linda', 'Douglas','01012345678','seoul','city', 'Owner');
INSERT INTO user(ID, USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED, FIRST_NAME, LAST_NAME, TELEPHONE, ADDRESS, CITY, DTYPE ) VALUES (10, 'username9',   '$2a$10$5LFYga2EHufPNbW/FNfpr.cT/SFlcNaXpf6KNiPkRZd9WM4iBOXma', 'TRUE', 'TRUE', 'TRUE', 'TRUE', 'Rafael', 'Ortega','01012345678','seoul','city', 'Owner');
INSERT INTO user(ID, USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED, FIRST_NAME, LAST_NAME, TELEPHONE, ADDRESS, CITY, DTYPE ) VALUES (11, 'username10',  '$2a$10$5LFYga2EHufPNbW/FNfpr.cT/SFlcNaXpf6KNiPkRZd9WM4iBOXma', 'TRUE', 'TRUE', 'TRUE', 'TRUE', 'Henry', 'Stevens','01012345678','seoul','city', 'Owner');
INSERT INTO user(ID, USERNAME, PASSWORD, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED, FIRST_NAME, LAST_NAME, TELEPHONE, ADDRESS, CITY, DTYPE ) VALUES (12, 'username11',  '$2a$10$5LFYga2EHufPNbW/FNfpr.cT/SFlcNaXpf6KNiPkRZd9WM4iBOXma', 'TRUE', 'TRUE', 'TRUE', 'TRUE', 'Sharon', 'Jenkins','01012345678','seoul','city', 'Owner');

INSERT INTO user_authority(USER_ID, authorities_id) VALUES (1,1);
-- INSERT INTO owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023');
-- INSERT INTO owners VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749');
-- INSERT INTO owners VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763');
-- INSERT INTO owners VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198');
-- INSERT INTO owners VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765');
-- INSERT INTO owners VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654');
-- INSERT INTO owners VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387');
-- INSERT INTO owners VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683');
-- INSERT INTO owners VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435');
-- INSERT INTO owners VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487');
-- INSERT INTO vets VALUES (1, 'James', 'Carter');
-- INSERT INTO vets VALUES (2, 'Helen', 'Leary');
-- INSERT INTO vets VALUES (3, 'Linda', 'Douglas');
-- INSERT INTO vets VALUES (4, 'Rafael', 'Ortega');
-- INSERT INTO vets VALUES (5, 'Henry', 'Stevens');
-- INSERT INTO vets VALUES (6, 'Sharon', 'Jenkins');

INSERT INTO specialties VALUES (1, 'radiology');
INSERT INTO specialties VALUES (2, 'surgery');
INSERT INTO specialties VALUES (3, 'dentistry');

INSERT INTO vet_specialties VALUES (2, 1);
INSERT INTO vet_specialties VALUES (3, 2);
INSERT INTO vet_specialties VALUES (3, 3);
INSERT INTO vet_specialties VALUES (4, 2);
INSERT INTO vet_specialties VALUES (5, 1);

INSERT INTO types VALUES (1, 'cat');
INSERT INTO types VALUES (2, 'dog');
INSERT INTO types VALUES (3, 'lizard');
INSERT INTO types VALUES (4, 'snake');
INSERT INTO types VALUES (5, 'bird');
INSERT INTO types VALUES (6, 'hamster');


INSERT INTO pets VALUES (1, 'Leo', '2010-09-07', 1, 1);
INSERT INTO pets VALUES (2, 'Basil', '2012-08-06', 6, 2);
INSERT INTO pets VALUES (3, 'Rosy', '2011-04-17', 2, 3);
INSERT INTO pets VALUES (4, 'Jewel', '2010-03-07', 2, 3);
INSERT INTO pets VALUES (5, 'Iggy', '2010-11-30', 3, 4);
INSERT INTO pets VALUES (6, 'George', '2010-01-20', 4, 5);
INSERT INTO pets VALUES (7, 'Samantha', '2012-09-04', 1, 6);
INSERT INTO pets VALUES (8, 'Max', '2012-09-04', 1, 6);
INSERT INTO pets VALUES (9, 'Lucky', '2011-08-06', 5, 1);
INSERT INTO pets VALUES (10, 'Mulligan', '2007-02-24', 2, 2);
INSERT INTO pets VALUES (11, 'Freddy', '2010-03-09', 5, 3);
INSERT INTO pets VALUES (12, 'Lucky', '2010-06-24', 2, 4);
INSERT INTO pets VALUES (13, 'Sly', '2012-06-08', 1, 5);

INSERT INTO visits(ID, PET_ID, VISIT_DATE, DESCRIPTION) VALUES (1, 7, '2013-01-01', 'rabies shot');
INSERT INTO visits(ID, PET_ID, VISIT_DATE, DESCRIPTION) VALUES (2, 8, '2013-01-02', 'rabies shot');
INSERT INTO visits(ID, PET_ID, VISIT_DATE, DESCRIPTION) VALUES (3, 8, '2013-01-03', 'neutered');
INSERT INTO visits(ID, PET_ID, VISIT_DATE, DESCRIPTION) VALUES (4, 7, '2013-01-04', 'spayed');
