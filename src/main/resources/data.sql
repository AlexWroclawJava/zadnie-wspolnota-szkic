INSERT INTO wspolnota(id, name, address_number, address_street, voivodship ) VALUES('1', 'Tęczowe Osiedle', 17, 'Malinowa', 'Sląskie');
INSERT INTO wspolnota(id, name, address_number, address_street, voivodship ) VALUES('2', 'Radosne Domki', 19, 'Sloneczna', 'Dolnośląskie');
INSERT INTO wspolnota(id, name, address_number, address_street, voivodship ) VALUES('3', 'Osiedle Marzeń', 25, 'Radosna', 'Dolnośląskie');
INSERT INTO wspolnota(id, name, address_number, address_street, voivodship ) VALUES('4', 'Wspólnota Bajka', 27, 'Przepiekna', 'Slaskie');

INSERT INTO mieszkaniec(id, name, surname, plec, wspolnota_id) VALUES(1, 'Marcin', 'Abacki', 'M', 1);
INSERT INTO mieszkaniec(id, name, surname, plec, wspolnota_id) VALUES(2, 'Daniel', 'Wojtkowiak', 'M', 1);

INSERT INTO mieszkaniec(id, name, surname, plec, wspolnota_id) VALUES(3, 'Mariusz', 'Wojtkowiak', 'M', 2);
INSERT INTO mieszkaniec(id, name, surname, plec, wspolnota_id) VALUES(4, 'Maria', 'Filozof', 'K', 2);

INSERT INTO mieszkaniec(id, name, surname, plec, wspolnota_id) VALUES(5, 'Dorota', 'Jakastam', 'K', 3);
INSERT INTO mieszkaniec(id, name, surname, plec, wspolnota_id) VALUES(6, 'Kamil', 'Czorny', 'M', 3);

INSERT INTO mieszkaniec(id, name, surname, plec, wspolnota_id) VALUES(7, 'Wojtek', 'Babacki', 'M', 4);
INSERT INTO mieszkaniec(id, name, surname, plec, wspolnota_id) VALUES(8, 'Michal', 'Balicki', 'M', 4);