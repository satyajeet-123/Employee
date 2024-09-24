<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.model.Employee,java.util.List"%>
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Employees</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Employee List</h1>
        <a href="index.jsp" class="btn btn-secondary mb-3">Back</a>
        <a href="addEmployee.jsp" class="btn btn-primary mb-3">Add Employee</a>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Position</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Employee> employees = (List<Employee>) request.getAttribute("employees");
                    for (Employee emp : employees) { 
                %>
                <tr>
                    <td><%= emp.getId() %></td>
                    <td><%= emp.getName() %></td>
                    <td><%= emp.getPosition() %></td>
                    <td>
                        <a href="employees?action=edit&id=<%= emp.getId() %>" class="btn btn-warning btn-sm">Edit</a>
                        <a href="employees?action=delete&id=<%= emp.getId() %>" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
