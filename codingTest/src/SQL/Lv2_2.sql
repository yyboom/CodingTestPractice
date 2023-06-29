-- 20230629
-- 조건에 부합하는 중고거래 상태 조회하기
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, 
CASE 
    WHEN STATUS ='SALE' THEN '판매중'
    WHEN STATUS ='RESERVED' THEN '예약중'
    WHEN STATUS = 'DONE' THEN '거래완료'
END AS STATUS
FROM USED_GOODS_BOARD
WHERE YEAR(CREATED_DATE)='2022' AND MONTH(CREATED_DATE) ='10' AND DAY(CREATED_DATE)='05'
ORDER BY BOARD_ID DESC;