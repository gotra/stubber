
CREATE TABLE  stubs(
id BIGINT GENERATED BY DEFAULT AS IDENTITY,
name VARCHAR(255),
description VARCHAR(1000),
urlpath VARCHAR(2083),
httpmethod VARCHAR(50),
headers CLOB,
response CLOB);



--INSERT INTO PUBLIC.STUBS (NAME, DESCRIPTION, URLPATH, HTTPMETHOD, HEADERS, RESPONSE) VALUES ('dfsdf', 'fsdfsdf', 'fsdfs', 'ertertete','sdfsdf', 'rtertertert');
