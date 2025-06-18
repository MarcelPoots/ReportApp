-- Create a sequence
CREATE SEQUENCE my_sequence START WITH 1;

CREATE TABLE report_row (
    id INT NOT NULL default NEXTVAL('my_sequence') ,
    name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    department VARCHAR(50) NOT NULL
);


INSERT INTO report_row (name, age, department) VALUES ('Alice', 30, 'Engineering');
INSERT INTO report_row (name, age, department) VALUES ('Bob', 25, 'Marketing');
INSERT INTO report_row (name, age, department) VALUES ('Charlie', 35, 'Finance');
INSERT INTO report_row (name, age, department) VALUES ('David', 28, 'Engineering');
INSERT INTO report_row (name, age, department) VALUES ('Eve', 32, 'Sales');
INSERT INTO report_row (name, age, department) VALUES ('Frank', 29, 'Marketing');
INSERT INTO report_row (name, age, department) VALUES ('Grace', 27, 'HR');
INSERT INTO report_row (name, age, department) VALUES ('Hank', 31, 'Engineering');
INSERT INTO report_row (name, age, department) VALUES ('Ivy', 26, 'Design');
INSERT INTO report_row (name, age, department) VALUES ('Jack', 33, 'Finance');
INSERT INTO report_row (name, age, department) VALUES ('Karen', 34, 'HR');
INSERT INTO report_row (name, age, department) VALUES ('Leo', 28, 'Sales');
INSERT INTO report_row (name, age, department) VALUES ('Mona', 30, 'Engineering');
INSERT INTO report_row (name, age, department) VALUES ('Nina', 29, 'Marketing');
INSERT INTO report_row (name, age, department) VALUES ('Oscar', 36, 'Finance');
INSERT INTO report_row (name, age, department) VALUES ('Paul', 37, 'Engineering');
INSERT INTO report_row (name, age, department) VALUES ('Quinn', 26, 'Design');
INSERT INTO report_row (name, age, department) VALUES ('Rita', 32, 'Marketing');
INSERT INTO report_row (name, age, department) VALUES ('Steve', 35, 'Engineering');
INSERT INTO report_row (name, age, department) VALUES ('Tina', 27, 'Sales');
INSERT INTO report_row (name, age, department) VALUES ('Uma', 31, 'HR');
INSERT INTO report_row (name, age, department) VALUES ('Victor', 30, 'Finance');
INSERT INTO report_row (name, age, department) VALUES ('Wendy', 33, 'Engineering');
INSERT INTO report_row (name, age, department) VALUES ('Xander', 28, 'Marketing');
INSERT INTO report_row (name, age, department) VALUES ('Yara', 29, 'Design');
INSERT INTO report_row (name, age, department) VALUES ('Zoe', 24, 'Support');
INSERT INTO report_row (name, age, department) VALUES ('Andy', 31, 'Design');
INSERT INTO report_row (name, age, department) VALUES ('Bella', 29, 'Engineering');
INSERT INTO report_row (name, age, department) VALUES ('Carl', 27, 'Finance');
INSERT INTO report_row (name, age, department) VALUES ('Dana', 35, 'Marketing');
INSERT INTO report_row (name, age, department) VALUES ('Elon', 40, 'Engineering');
INSERT INTO report_row (name, age, department) VALUES ('Fay', 33, 'Sales');
INSERT INTO report_row (name, age, department) VALUES ('Gina', 28, 'HR');
INSERT INTO report_row (name, age, department) VALUES ('Harry', 38, 'Finance');
INSERT INTO report_row (name, age, department) VALUES ('Isla', 26, 'Marketing');
INSERT INTO report_row (name, age, department) VALUES ('Jake', 30, 'Sales');
INSERT INTO report_row (name, age, department) VALUES ('Kira', 34, 'Design');
INSERT INTO report_row (name, age, department) VALUES ('Liam', 25, 'Support');
INSERT INTO report_row (name, age, department) VALUES ('Mila', 32, 'Engineering');
INSERT INTO report_row (name, age, department) VALUES ('Noah', 29, 'HR');
INSERT INTO report_row (name, age, department) VALUES ('Olive', 27, 'Marketing');
INSERT INTO report_row (name, age, department) VALUES ('Peter', 36, 'Finance');
INSERT INTO report_row (name, age, department) VALUES ('Queen', 31, 'Sales');
INSERT INTO report_row (name, age, department) VALUES ('Rick', 33, 'Design');
INSERT INTO report_row (name, age, department) VALUES ('Sara', 26, 'Support');
INSERT INTO report_row (name, age, department) VALUES ('Tom', 35, 'Engineering');
INSERT INTO report_row (name, age, department) VALUES ('Ursula', 29, 'Marketing');
INSERT INTO report_row (name, age, department) VALUES ('Vik', 37, 'Finance');
INSERT INTO report_row (name, age, department) VALUES ('Will', 30, 'Support');
INSERT INTO report_row (name, age, department) VALUES ('Xena', 28, 'HR');
