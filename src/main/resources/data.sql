-- Personen
INSERT INTO person (id, vorname, nachname, telefonnummer, typ)
VALUES (1, 'Anna', 'Fischer', '01234 111111', 'Meldende');

INSERT INTO person (id, vorname, nachname, telefonnummer, typ)
VALUES (2, 'Max', 'Müller', '01234 222222', 'Meldende');

INSERT INTO person (id, vorname, nachname, telefonnummer, typ, passwort)
VALUES (3, 'Lisa', 'Berger', '01234 333333', 'Bergende', '$2a$10$aS3DNMy59uDFZ.VIrv2rtuizEgYb8yBQvXKTt84FujgDVtmdnwxI6');

INSERT INTO person (id, vorname, nachname, telefonnummer, typ)
VALUES (4, 'Tom', 'Schneider', '01234 444444', 'Meldende');


-- Geisternetze
INSERT INTO geisternetz (id, breitengrad, laengengrad, geschaetzte_groesse, status, meldende_person_id, bergende_person_id)
VALUES (1, 37.6934, 10.5608, 50, 'GEMELDET', 1, NULL);

INSERT INTO geisternetz (id, breitengrad, laengengrad, geschaetzte_groesse, status, meldende_person_id, bergende_person_id)
VALUES (2, 55.9876, 11.3456, 120, 'BERGUNG_BEVORSTEHEND', 2, 3);

INSERT INTO geisternetz (id, breitengrad, laengengrad, geschaetzte_groesse, status, meldende_person_id, bergende_person_id)
VALUES (3, 53.5432, 9.8765, 200, 'GEBORGEN', 4, 3);

INSERT INTO geisternetz (id, breitengrad, laengengrad, geschaetzte_groesse, status, meldende_person_id, bergende_person_id)
VALUES (4, 54.8765, 10.2345, 80, 'VERSCHOLLEN', 2, NULL);



-- Für die Tabelle geisternetz
-- Prüfen, welche Sequenz für die ID-Spalte verwendet wird
SELECT pg_get_serial_sequence('geisternetz', 'id');

-- Optional: aktuellen Sequenzwert prüfen
SELECT last_value FROM geisternetz_id_seq;

-- Sequenz auf den maximalen Wert zurücksetzen
SELECT setval('geisternetz_id_seq', (SELECT COALESCE(MAX(id), 1) FROM geisternetz));

-- Für die Tabelle person
-- Prüfen, welche Sequenz für die ID-Spalte verwendet wird
SELECT pg_get_serial_sequence('person', 'id');

-- Optional: aktuellen Sequenzwert prüfen
SELECT last_value FROM person_id_seq;

-- Sequenz auf den maximalen Wert zurücksetzen
SELECT setval('person_id_seq', (SELECT COALESCE(MAX(id), 1) FROM person));