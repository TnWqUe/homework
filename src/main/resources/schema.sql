DROP TABLE IF EXISTS CURRENT;

CREATE TABLE CURRENT
(
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
    IA      DOUBLE PRECISION    NOT NULL,
    IB      DOUBLE PRECISION    NOT NULL,
    IC      DOUBLE PRECISION    NOT NULL,
    primary key (ID)

);