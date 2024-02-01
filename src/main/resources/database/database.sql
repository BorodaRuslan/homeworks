--  Schema creation
CREATE SCHEMA IF NOT EXISTS cinema;

-- Creating a Table Movies
CREATE TABLE cinema.Movies (
    id SERIAL PRIMARY KEY NOT NULL,
    title VARCHAR(255),
    director VARCHAR(255),
    year SMALLINT CHECK (year >= 1800 AND year <= 9999),
    length_min INT
);

-- Creating a Boxoffice Table
CREATE TABLE cinema.Boxoffice (
    id SERIAL PRIMARY KEY NOT NULL,
    movie_id INT REFERENCES cinema.Movies(id),
    rating INT,
    domestic_sale BIGINT,
    international_sale BIGINT
);


-- Inserting Movies into the Table
INSERT INTO cinema.Movies (title, director, year, length_min)
VALUES
    ('The Matrix', 'Lana Wachowski, Lilly Wachowski', 1999, 136),
    ('Inception', 'Christopher Nolan', 2010, 148),
    ('Pulp Fiction', 'Quentin Tarantino', 1994, 154),
    ('The Shawshank Redemption', 'Frank Darabont', 1994, 142),
    ('Forrest Gump', 'Robert Zemeckis', 1994, 142);

-- Inserting Data into a Boxoffice Table
INSERT INTO cinema.Boxoffice (movie_id, rating, domestic_sale, international_sale)
VALUES
    (1, 8.7, 463517383, 465453000),
    (2, 8.8, 829895144, 532950503),
    (3, 8.9, 213928762, 191000000),
    (4, 9.3, 28341469, 314000000),
    (5, 8.8, 330455270, 678226752);