# Write your MySQL query statement below
Select unique_id, name
from Employees as e
Left Join EmployeeUNI as uni on e.id = uni.id