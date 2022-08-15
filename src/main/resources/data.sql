INSERT INTO USER(name, email, password) VALUES('Player 1', 'player1@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO USER(name, email, password) VALUES('Player 2', 'player2@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO USER(name, email, password) VALUES('Player 3', 'player3@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO USER(name, email, password) VALUES('Moderator', 'moderator@email.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');

INSERT INTO PROFILE(id, name) VALUES(1, 'ROLE_USER');
INSERT INTO PROFILE(id, name) VALUES(2, 'ROLE_MODERATOR');

INSERT INTO USER_PROFILES(user_id, profiles_id) VALUES(1, 1);
INSERT INTO USER_PROFILES(user_id, profiles_id) VALUES(2, 1);
INSERT INTO USER_PROFILES(user_id, profiles_id) VALUES(3, 1);
INSERT INTO USER_PROFILES(user_id, profiles_id) VALUES(4, 2);

insert into movie(imdbid, imdb_rating, imdb_votes, poster, title, year) values('tt0096895', 7.5, 373505, 'https://m.media-amazon.com/images/M/MV5BZTM2NmZlOTEtYTI5NS00N2JjLWJkNzItMmZkNDBlYmQzNDA2XkEyXkFqcGdeQXVyMTAxODYyODI@._V1_SX300.jpg', 'Batman', 1989);
insert into movie(imdbid, imdb_rating, imdb_votes, poster, title, year) values('tt0106062', 7.7, 192, 'https://m.media-amazon.com/images/M/MV5BZTM2NmZlOTEtYTI5NS00N2JjLWJkNzItMmZkNDBlYmQzNDA2XkEyXkFqcGdeQXVyMTAxODYyODI@._V1_SX300.jpg', 'Matrix', 1993);
insert into movie(imdbid, imdb_rating, imdb_votes, poster, title, year) values('tt0137523', 8.8, 2057512, 'https://m.media-amazon.com/images/M/MV5BZTM2NmZlOTEtYTI5NS00N2JjLWJkNzItMmZkNDBlYmQzNDA2XkEyXkFqcGdeQXVyMTAxODYyODI@._V1_SX300.jpg', 'Fight Club', 1999);

