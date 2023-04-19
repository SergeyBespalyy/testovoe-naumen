CREATE TABLE IF NOT EXISTS person (
    person_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    person_name varchar(100),
    age int,
    count int);

CREATE TABLE IF NOT EXISTS personOut(
    person_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    person_name varchar(100),
    count int);