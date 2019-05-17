<html>
    <head>
      <title>Emp</title>
    </head>
    <body>
      <h1>Emp List</h1>
      <ul>
        <#list employees as emp>
          <li>${emp.employeeId}</li>
          <li>${emp.firstName}</li>
          <li>${emp.lastName}</li>
        </#list>
	  </ul>
    </body>
</html>