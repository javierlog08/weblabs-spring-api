CREATE TABLE public.books
(
    book_id serial ,
    name character varying,
    author character varying,
    publish_date date,
    CONSTRAINT books_pkey PRIMARY KEY (book_id)
);

INSERT INTO books VALUES(1,'The Little Prince', 'Antoine de Saint-Exupéry', '1951-09-02' );
INSERT INTO books VALUES(2,'To Kill a Mockingbird', 'Harper Lee', '1960-06-11' );
INSERT INTO books VALUES(3,'Pride and Prejudic', 'Jane Austen,  Anna Quindlen', '2000-10-10' );
INSERT INTO books VALUES(4,'The Book Thief', 'Markus Zusak', '2006-03-14' );
INSERT INTO books VALUES(5,'Animal Farm', 'George Orwell', '2006-05-06' );
INSERT INTO books VALUES(6,'The Fault in Our Stars', 'John Green', '2012-01-10' );
INSERT INTO books VALUES(7,'The Giving Tree', 'Shel Silverstein', '1964-10-07' );
INSERT INTO books VALUES(8,'Romeo and Juliet ', 'William Shakespeare', '1597-01-01' );