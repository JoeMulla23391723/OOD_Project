# Payroll System
A payroll system for University of Limerick staff

# Features
Three types of user can access the payroll system; Employees, Admin, Human Resources
An full-time employee may view their current or past payslips and their details
A part-time employee may view their current payslip and their details
An admin may add an employee to the system
HR may initiate a new promotion for a full-time employee or execute promotion on an annual basis
HR may initiate a new promotion for a part-time employee

# Instructions on Usage
Open the source files in your IDE, run the system from the class entitled 'Main'
Upon running the system you will be prompted to choose your user type (Employee, Admin or HR)
After selecting user type you will be prompted to enter a username and password
Employee logins are based upon employees that exist in the system
There are set HR and Admin users also provided below

**Employee**
The employee logins that exist in the system are as follows ...
id: 107  password: password123 (full-time)
id: 108  password: password456 (full-time)
id: 109  password: password1 (part-time)
id: 105  password: password2 (part-time)
If you login successfully, you will be prompted to confirm your employment status (full-time or part-time)
If you have selected full-time you will then be prompted to choose what you would like to do 
You may view current or past payslips or view details associated with this employee
If you have selected part-time you may view current payslips or view details associated with this employee

**Admin**
The admin login that exists in the system is ...
id: 1234  password: admin_pass
If you login successfully, you will be prompted to either add an employee to the system or logout
Should you choose to add an employee you will then be prompted to choose whether you wish to add a full-time or part-time
You will then be prompted enter a series of inputs based on employee information

IMPORTANT!
Each input must be in String format except for the following exceptions
An employee ID must be entered in integer form
An employee age must be entered in integer form
If the employee is a medical card holder or is not a medical card holder the input must be a boolean
If the employee has or does not have health insurance the input must be in boolean
An employee's number of household incomes must be in integer format
If the employee is or is not the highest earner in their household must be input as a boolean

When entering **status** the options are as follows:
Single person
Lone parent
Married Couple/civil partners  
A status must be entered exactly as it appears here
An employee must have a status

When entering ** tax credits ** the options are as follows:
Employee Tax Credit
Single Person Child Carer Credit
Incapacitated Child Tax Credit
Dependent Relative Tax Credit
Age Tax Credit
Tuition Fees Tax Credit
Rent Tax Credit
Blind Person's Tax Credit
Disability Tax Credit
They must be entered exactly as they appear here
If the employee has more than one tax credit, they must be entered in the one line separated by a comma and with no spaces in between 
as such ...
Blind Person's Tax Credit,Age Tax Credit
An employee must have a tax credit

When entering **unions** the options are as follows:
Irish Federation of University Teachers
Unite
Services Industrial Professional and Technical Union
They must be entered exactly as they appear here
If the employee belongs to more than one union, they must be entered in the one line separated by a comma and with no spaces in between 
as such ...
Unite,Irish Federation of University Teachers
Should an employee not belong to a union, please input null

When entering **health plan** the options are as follows:
VHI One Plan 250
VHI HealthPlus Extra
They must be entered exactly as they appear here
Should an employee not have a health plan, please input null

When entering **health plan type** the options are as follows:
Single
Family
They must be entered exactly as they appear here
Should an employee not have a health plan, please input null


Specific to full time employees...
An employee's salary scale point must be entered in integer form
An employees salary must be entered in double form

Specific to part-time employees...
An employee's hourly rate must be entered in double form
If an employee has or has not submitted a pay claim bust be input as a boolean
The date on which the pay claim was submitted must be entered in the form yyyy-mm-dd
In the event that an employee did not submit a pay claim, please enter the date 0001-01-01
The hours worked by an employee in this pay period must be input in double form

**HR**
The HR login that exists in the system is ...
id: 5678  password: hr_pass
If you login successfully, you will be prompted to promote an employee
You may promote either a full-time or a part time employee
If you select full-time employee you will have the option to execute their annual promotion or 




