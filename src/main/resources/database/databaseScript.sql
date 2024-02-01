Select operations:
1. Find the title of each film
SELECT title FROM cinema.movies;

2. Find the director of each film
SELECT director FROM cinema.movies;

3. Find the title and director of each film
SELECT title, director FROM cinema.movies;

4. Find the title and year of each film
SELECT title, year FROM cinema.movies;

5. Find all the information about each film
SELECT cinema.movies.*, cinema.boxoffice.rating,
cinema.boxoffice.domestic_sale,
cinema.boxoffice.international_sale
FROM cinema.movies
JOIN cinema.boxoffice ON movie_id = boxoffice.movie_id;

Condition operation:
1. Find the movies released in the years between 2000 and 2010
SELECT * FROM cinema.movies
WHERE year between 2000 AND 2010

2. Find the movies not released in the years between 2000 and 2010
SELECT * FROM cinema.movies
WHERE year IS NULL OR year NOT BETWEEN 2000 AND 2010;

3. Find the movies and their year released in years (2000, 2010, 2020)
SELECT * FROM cinema.movies
WHERE year = '2000' OR  year = '2010' OR year = '2020';

4. Find the movies with title starting with either "b", "s", or "p":
SELECT * FROM cinema.movies
WHERE title LIKE 'b%' OR title LIKE 's%' OR title LIKE 'p%';

Filtering and sorting:
1. List all directors ordered (alphabetically) without duplicates for movies after 2005
SELECT DISTINCT director FROM cinema.Movies
WHERE year > 2005
ORDER BY director;

JOINs:
1. Find title, domestic_sale, international_sales for each movie
SELECT title, domestic_sale, international_sale
FROM cinema.movies
JOIN cinema.boxoffice ON movies.id = boxoffice.movie_id;

2.Find title, director, rating of each movie where international_sales > domestic_sales
SELECT title, director, rating
FROM cinema.movies
JOIN cinema.boxoffice ON movies.id = boxoffice.movie_id
WHERE international_sale > boxoffice.domestic_sale;

3. List all the movies by their ratings in descending order
SELECT * FROM cinema.movies
JOIN cinema.boxoffice ON movies.id = boxoffice.movie_id
ORDER BY rating DESC;

4. List all movies titles and their combined sales
SELECT m.title, COALESCE(b.domestic_sale, 0) + COALESCE(b.international_sale, 0) AS combined_sales
FROM cinema.Movies m
LEFT JOIN cinema.Boxoffice b ON m.id = b.movie_id;

5. List all movies that were released on even number years
SELECT * FROM cinema.movies
join cinema.boxoffice on movies.id = boxoffice.movie_id
WHERE year % 2 = 0;

6. Find director, the number of movies and average rating each director has directed
SELECT director, COUNT(*) AS number_of_movies, AVG(b.rating) AS average_rating
FROM cinema.Movies m
JOIN cinema.Boxoffice b ON m.id = b.movie_id
GROUP BY director;

7. Find director, the total domestic and international sales made by each director
SELECT m.director,
SUM(b.domestic_sale) AS total_domestic_sales,
SUM(b.international_sale) AS total_international_sales
FROM cinema.Movies m
JOIN cinema.Boxoffice b ON m.id = b.movie_id
GROUP BY m.director;