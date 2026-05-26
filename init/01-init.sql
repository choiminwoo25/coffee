USE daelim;

    CREATE TABLE IF NOT EXISTS MEMBER(
        ID int auto_increment primary key,
        EMAIL varchar(255),
        PASSWORD varchar(100),
        NAME varchar(100),
        REGDATE datetime,
        unique key (EMAIL)
    ) engine=InnoDB character set = utf8;

    -- 테스트 데이터
    INSERT INTO MEMBER (EMAIL, PASSWORD, NAME, REGDATE)
    VALUES ('a@a.com', '1234', 'AAA', now());