# Write your MySQL query statement below
select email from 
        (select count(id) as cnt, email from Person group by email) as subq
where cnt > 1;