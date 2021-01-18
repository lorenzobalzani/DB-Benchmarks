DROP TABLE accounts;
CREATE TABLE IF NOT EXISTS accounts (
    id SERIAL PRIMARY KEY,
	username VARCHAR (64) UNIQUE NOT NULL,
	password VARCHAR (128) NOT NULL,
	email VARCHAR (64) UNIQUE NOT NULL,
	firstname VARCHAR (64) NOT NULL,
	lastname VARCHAR (64) NOT NULL,
	gender VARCHAR (16) NOT NULL,
	created_on TIMESTAMP NOT NULL
);

\copy accounts(username, password, email, firstname, lastname, gender, created_on) FROM '<path_to_this_folder>/accounts.csv' DELIMITER ',' CSV HEADER;