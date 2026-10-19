
WITH new_table AS (
    SELECT v.customer_id AS customer_id,
           v.visit_id AS visit_id,
           t.transaction_id AS transaction_id
    FROM Transactions t
    RIGHT JOIN Visits v
        ON v.visit_id = t.visit_id
)

SELECT customer_id,
       COUNT(*) AS count_no_trans
FROM new_table
WHERE transaction_id IS NULL
GROUP BY customer_id
ORDER BY count_no_trans DESC;
