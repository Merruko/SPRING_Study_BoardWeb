CREATE TABLE b_board (
	seq NUMBER(5) PRIMARY KEY,
    title VARCHAR2(200),
    writer VARCHAR2(20),
    content VARCHAR2(2000),
    regdate DATE DEFAULT SYSDATE,
    cnt NUMBER(5) DEFAULT 0
);

SELECT * FROM b_board;

DELETE FROM b_board;


CREATE TABLE b_users (
	id VARCHAR2(8) PRIMARY KEY,
    password VARCHAR2(8),
    name VARCHAR2(20),
    role VARCHAR2(5)
);

INSERT INTO b_users VALUES ('test','test123','kim','admin');

SELECT * FROM b_users;