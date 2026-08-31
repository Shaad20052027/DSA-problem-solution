WITH new_table AS (
    SELECT 
        u.name AS name,
        t.account AS account,
        SUM(t.amount) AS balance,
        DENSE_RANK() OVER (
            PARTITION BY t.account 
            ORDER BY t.amount DESC
        ) AS rank_num
    FROM Users u
    JOIN Transactions t
        ON t.account = u.account
    GROUP BY u.name, t.account
)
SELECT name, balance
FROM new_table
WHERE balance > 10000;