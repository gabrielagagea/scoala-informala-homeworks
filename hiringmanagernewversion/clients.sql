DROP TABLE IF EXISTS clients;
CREATE TABLE clients(id serial PRIMARY KEY, first_name VARCHAR(100), last_name VARCHAR(100), email VARCHAR(100));
INSERT INTO clients(first_name, last_name, email) values('Olesea', 'Solodcov', 'olesea_solodcov@yahoo.com');
INSERT INTO clients(first_name, last_name, email) values('Roxana', 'Ilis', 'ilis_roxana@yahoo.com' );
INSERT INTO clients(first_name, last_name, email) values('Ioana', 'Rosca', 'ioanarosca20@yahoo.com');
