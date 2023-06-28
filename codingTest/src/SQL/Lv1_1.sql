-- 20230628
-- 조건에 부합하는 중고거래 댓글 조회하기
DROP DATABASE IF EXISTS codingtest;
CREATE DATABASE IF NOT EXISTS codingtest DEFAULT CHARACTER SET = 'utf8mb4';
Use codingtest;

DROP TABLE IF EXISTS USED_GOODS_BOARD;
DROP TABLE IF EXISTS USED_GOODS_REPLY;
CREATE TABLE USED_GOODS_BOARD( -- 게시글
BOARD_ID	VARCHAR(5) NOT NULL PRIMARY KEY,
WRITER_ID	VARCHAR(50) NOT NULL,
TITLE	VARCHAR(100) NOT NULL,
CONTENTS	VARCHAR(1000) NOT NULL,
PRICE	INT NOT NULL,
CREATED_DATE	DATE NOT NULL,
STATUS	VARCHAR(10) NOT NULL,
VIEWS	INT NOT NULL
);
CREATE TABLE USED_GOODS_REPLY( -- 게시글 작성자
REPLY_ID	VARCHAR(10) NOT NULL PRIMARY KEY,
BOARD_ID	VARCHAR(5) NOT NULL,
WRITER_ID	VARCHAR(50) NOT NULL,
CONTENTS	VARCHAR(1000),
CREATED_DATE	DATE NOT NULL,
FOREIGN KEY (BOARD_ID) REFERENCES USED_GOODS_BOARD(BOARD_ID)
);

SELECT B.TITLE, B.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, DATE_FORMAT(R.CREATED_DATE,'%Y-%m-%d') FROM USED_GOODS_BOARD  AS B
INNER JOIN USED_GOODS_REPLY AS R ON B.BOARD_ID = R.BOARD_ID
WHERE B.CREATED_DATE BETWEEN '2022-10-01 00:00:00' AND '2022-10-31 23:59:59'
ORDER BY R.CREATED_DATE, B.TITLE;