CREATE TABLE customers
(
    id             INT PRIMARY KEY,
    city           VARCHAR(100),
    age            INT,
    salary         INT,
    first_name     VARCHAR(100),
    last_name      VARCHAR(100),
    identification VARCHAR(100)
);

insert into customers
values (1, 'Baku', 25, 3000, 'Test', 'Testov', '111111');
