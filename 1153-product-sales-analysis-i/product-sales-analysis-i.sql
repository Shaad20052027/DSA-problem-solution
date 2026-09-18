# Write your MySQL query statement below
SELECT p.product_name, t.year, t.price
FROM Product p
INNER JOIN Sales t
ON p.product_id = t.product_id;