-- Create a sequence
CREATE SEQUENCE my_sequence START WITH 1;

CREATE TABLE report_row (
    id INT NOT NULL default NEXTVAL('my_sequence') ,
    name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    department VARCHAR(50) NOT NULL,
    language VARCHAR(50) NOT NULL
);


INSERT INTO report_row (name, age, department, language) VALUES ('Alice', 30, 'Engineering', 'English');
INSERT INTO report_row (name, age, department, language) VALUES ('Bob', 25, 'Marketing', 'German');
INSERT INTO report_row (name, age, department, language) VALUES ('Charlie', 35, 'Finance', 'English');
INSERT INTO report_row (name, age, department, language) VALUES ('David', 28, 'Engineering', 'English');
INSERT INTO report_row (name, age, department, language) VALUES ('Eve', 32, 'Sales', 'English');
INSERT INTO report_row (name, age, department, language) VALUES ('Frank', 29, 'Marketing', 'Dutch');
INSERT INTO report_row (name, age, department, language) VALUES ('Grace', 27, 'HR', 'English');
INSERT INTO report_row (name, age, department, language) VALUES ('Hank', 31, 'Engineering', 'Spanish');
INSERT INTO report_row (name, age, department, language) VALUES ('Ivy', 26, 'Design', 'Russian');
INSERT INTO report_row (name, age, department, language) VALUES ('Jack', 33, 'Finance', 'Dutch');
INSERT INTO report_row (name, age, department, language) VALUES ('Karen', 34, 'HR', 'English');
INSERT INTO report_row (name, age, department, language) VALUES ('Leo', 28, 'Sales', 'English');
INSERT INTO report_row (name, age, department, language) VALUES ('Mona', 30, 'Engineering', 'English');
INSERT INTO report_row (name, age, department, language) VALUES ('Nina', 29, 'Marketing', 'English');
INSERT INTO report_row (name, age, department, language) VALUES ('Oscar', 36, 'Finance', 'German');
INSERT INTO report_row (name, age, department, language) VALUES ('Paul', 37, 'Engineering', 'Swedish');
INSERT INTO report_row (name, age, department, language) VALUES ('Quinn', 26, 'Design', 'Danish');
INSERT INTO report_row (name, age, department, language) VALUES ('Rita', 32, 'Marketing', 'Portuguese');
INSERT INTO report_row (name, age, department, language) VALUES ('Steve', 35, 'Engineering', 'French');
INSERT INTO report_row (name, age, department, language) VALUES ('Tina', 27, 'Sales', 'French');
INSERT INTO report_row (name, age, department, language) VALUES ('Uma', 31, 'HR', 'English');
INSERT INTO report_row (name, age, department, language) VALUES ('Victor', 30, 'Finance', 'English');
INSERT INTO report_row (name, age, department, language) VALUES ('Wendy', 33, 'Engineering', 'English');
INSERT INTO report_row (name, age, department, language) VALUES ('Xander', 28, 'Marketing', 'English');
