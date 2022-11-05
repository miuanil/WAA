-- USERS

INSERT INTO users (id, name)
VALUES (111, 'John Doe');

INSERT INTO users (id, name)
VALUES (222, 'Jerry Doe');

INSERT INTO users (id, name)
VALUES (333, 'Kramer Doe');

INSERT INTO users (id, name)
VALUES (444, 'George Doe');

INSERT INTO users (id, name)
VALUES (555, 'Newman Doe');

INSERT INTO users (id, name)
VALUES (666, 'Elaine Doe');

INSERT INTO users (id, name)
VALUES (777, 'Henry Doe');

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