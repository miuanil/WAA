-- USERS

INSERT INTO users (id, email, first_name, last_name, password)
VALUES (111, 'john@doe.com', 'John', 'Doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

INSERT INTO users (id, email, first_name, last_name, password)
VALUES (222, 'jerry@doe.com', 'Jerry', 'Doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

INSERT INTO users (id, email, first_name, last_name, password)
VALUES (333, 'kramer@doe.com', 'Kramer', 'Doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

INSERT INTO users (id, email, first_name, last_name, password)
VALUES (444, 'george@doe.com', 'George', 'Doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

INSERT INTO users (id, email, first_name, last_name, password)
VALUES (555, 'newman@doe.com', 'Newman', 'Doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

INSERT INTO users (id, email, first_name, last_name, password)
VALUES (666, 'elaine@doe.com', 'Elaine', 'Doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

INSERT INTO users (id, email, first_name, last_name, password)
VALUES (777, 'henry@doe.com', 'Henry', 'Doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');


INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'USER');


INSERT INTO users_roles (user_id, roles_id)
VALUES (111, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (222, 2);
INSERT INTO users_roles (user_id, roles_id)
VALUES (333, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (444, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (555, 2);
INSERT INTO users_roles (user_id, roles_id)
VALUES (666, 2);
INSERT INTO users_roles (user_id, roles_id)
VALUES (777, 2);

-- POSTS

INSERT INTO posts (id, title, content, author, user_id)
VALUES (1111, 'Post Title 1', 'Post Content 1', 'John Doe', 111);

INSERT INTO posts (id, title, content, author, user_id)
VALUES (2222, 'Post Title 2', 'Post Content 2', 'John Doe', 111);

INSERT INTO posts (id, title, content, author, user_id)
VALUES (3333, 'Post Title 3', 'Post Content 3', 'Jerry Doe', 222);

INSERT INTO posts (id, title, content, author, user_id)
VALUES (4444, 'Post Title 4', 'Post Content 4', 'Jerry Doe', 222);

INSERT INTO posts (id, title, content, author, user_id)
VALUES (5555, 'Post Title 5', 'Post Content 5', 'Jerry Doe', 222);

INSERT INTO posts (id, title, content, author, user_id)
VALUES (6666, 'Post Title 6', 'Post Content 6', 'Kramer Doe', 333);

INSERT INTO posts (id, title, content, author, user_id)
VALUES (7777, 'Post Title 7', 'Post Content 7', 'George Doe', 444);

INSERT INTO posts (id, title, content, author, user_id)
VALUES (8888, 'Post Title 8', 'Post Content 8', 'Newman Doe', 555);

INSERT INTO posts (id, title, content, author, user_id)
VALUES (9999, 'Post Title 9', 'Post Content 9', 'Elaine Doe', 666);

INSERT INTO posts (id, title, content, author, user_id)
VALUES (1010, 'Post Title 10', 'Post Content 10', 'Henry Doe', 777);

-- COMMENTS
INSERT INTO comments (id, name, post_id)
VALUES (11111, 'Comment 1', 1111);
INSERT INTO comments (id, name, post_id)
VALUES (22222, 'Comment 2', 1111);
INSERT INTO comments (id, name, post_id)
VALUES (33333, 'Comment 3', 1111);
INSERT INTO comments (id, name, post_id)
VALUES (44444, 'Comment 4', 2222);
INSERT INTO comments (id, name, post_id)
VALUES (55555, 'Comment 5', 3333);
INSERT INTO comments (id, name, post_id)
VALUES (66666, 'Comment 6', 4444);
INSERT INTO comments (id, name, post_id)
VALUES (77777, 'Comment 7', 5555);
INSERT INTO comments (id, name, post_id)
VALUES (88888, 'Comment 8', 6666);
INSERT INTO comments (id, name, post_id)
VALUES (99999, 'Comment 9', 7777);
INSERT INTO comments (id, name, post_id)
VALUES (10101, 'Comment 10', 7777);