INSERT INTO movie(id, title, premiere_date, budget, target_audience) VALUES
 (1, 'Titanic', '1995-12-12', 50000000, 'ALL'),
 (2, 'Matrix', '1992-05-12', 5000000, 'ALL'),
 (3, 'Piła', '1995-12-12', 200000, 'ADULTS'),
 (4, 'Spongebob Kanciastoporty', '2000-12-12', 200000, 'KIDS');

INSERT INTO comment(content, added_time, movie_id) VALUES
('Leo ginie!', '2019-04-03 18:36:00', 1),
('A zmieściłby się na tych drzwiach', '2019-04-03 18:37:00', 1),
('No niby tak', '2019-04-03 18:38:00', 1),
('Za gruby był', '2019-04-03 18:40:00', 1);


INSERT INTO actor(id, name) VALUES
(1, 'Dicaprio'),
(2, 'Reevs'),
(3, 'Cezary Żak'),
(4, 'Kate Winslet');

INSERT INTO role(actor_id, movie_id, name) VALUES
(1, 1, 'Jack'),
(4, 1, 'Rose'),
(2, 2, 'Neo'),
(3, 1, 'Wójt'),
(3, 1, 'Proboszcz');