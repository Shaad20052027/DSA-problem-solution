
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      WITH new_table AS (
          SELECT salary,
                 DENSE_RANK() OVER (ORDER BY salary DESC) AS rk
          FROM Employee
      )
      SELECT MAX(salary)
      FROM new_table
      WHERE rk = N
  );
END
