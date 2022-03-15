# Write your MySQL query statement below
select distinct(
    select distinct salary from employee
    order by salary desc
    limit 1,1) as SecondHighestSalary
    from employee;