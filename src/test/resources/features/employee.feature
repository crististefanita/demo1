@Regression
Business Need: verification of the api working fine

  @Sanity
  @EmployeeDetails
  Scenario: Employee details for a existing id
    Then  details of employee with id "5" and status code 200 is received

  @Sanity
  @EmployeeDetails
  Scenario: Employee details api with no id passed
    Given  a employee record is not added
    Then  status code 404 is received

  @AllEmployees
  Scenario: Employee details api
    Then  details of employees with status code 200 is received

  @DeleteEmployee
  Scenario: deleting an existing employee
    Given a employee record is added
    Then the employee id "6" is deleted and response status code 200 is returned


  @AddEmployee
  Scenario: adding a new employee
    Then a random employee is added and status code 200 is returned


  @UpdateEmployee
  Scenario: Updating a existing employee record
    Given a employee record is already added
    Then the employee with id "4" is updated and response status code 200 is returned
