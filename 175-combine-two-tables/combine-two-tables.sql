# Write your MySQL query statement below
select p.firstname,p.lastname,a.city,a.state
FROM person p
left join Address a
ON p.personId=a.personId