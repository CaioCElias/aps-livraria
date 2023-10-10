CREATE TABLE Books (
  title varchar(255) NOT NULL,
  isbn varchar(13) NOT NULL,
  publisher_id int, 
  price DECIMAL(10,2),
  PRIMARY KEY (isbn), 
  FOREIGN KEY (publisher_id) REFERENCES Publishers (publisher_id)
);
INSERT INTO Books VALUES ('A Guide to the SQL Standard', '0-201-96426-0', '0201', 47.95);
INSERT INTO Books VALUES ('A Pattern Language: Towns, Buildings, Construction', '0-19-501919-9', '019', 65.00);
INSERT INTO Books VALUES ('Applied Cryptography', '0-471-11709-9', '0471', 60.00);
INSERT INTO Books VALUES ('Computer Graphics: Principles and Practice', '0-201-84840-6', '0201', 79.99);
INSERT INTO Books VALUES ('Cuckoo''s Egg', '0-7434-1146-3', '07434', 13.95);
INSERT INTO Books VALUES ('Design Patterns', '0-201-63361-2', '0201', 54.99);
INSERT INTO Books VALUES ('Introduction to Algorithms', '0-262-03293-7', '0262', 80.00);
INSERT INTO Books VALUES ('Introduction to Automata Theory, Languages, and Computation', '0-201-44124-1', '0201', 105.00);
INSERT INTO Books VALUES ('JavaScript: The Definitive Guide', '0-596-00048-0', '0596', 44.95);
INSERT INTO Books VALUES ('The Art of Computer Programming vol. 1', '0-201-89683-4', '0201', 59.99);
INSERT INTO Books VALUES ('The Art of Computer Programming vol. 2', '0-201-89684-2', '0201', 59.99);
INSERT INTO Books VALUES ('The Art of Computer Programming vol. 3', '0-201-89685-0', '0201', 59.99);
INSERT INTO Books VALUES ('The C Programming Language', '0-13-110362-8', '013', 42.00);
INSERT INTO Books VALUES ('The C++ Programming Language', '0-201-70073-5', '0201', 64.99);
INSERT INTO Books VALUES ('The Cathedral and the Bazaar', '0-596-00108-8', '0596', 16.95);
INSERT INTO Books VALUES ('The Codebreakers', '0-684-83130-9', '07434', 70.00);
INSERT INTO Books VALUES ('The Mythical Man-Month', '0-201-83595-9', '0201', 29.95);
INSERT INTO Books VALUES ('The Soul of a New Machine', '0-679-60261-5', '0679', 18.95);
INSERT INTO Books VALUES ('The UNIX Hater''s Handbook', '1-56884-203-1', '0471', 16.95);
INSERT INTO Books VALUES ('UNIX System Administration Handbook', '0-13-020601-6', '013', 68.00);
SELECT * FROM Books;
