package com.example.servlet;

import java.io.IOException;
import java.util.List;

import com.example.dao.EmployeeDAO;
import com.example.dao.EmployeeDAOImpl;
import com.example.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Employee employee = employeeDAO.getEmployee(id);
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("/editEmployee.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            employeeDAO.deleteEmployee(id);
            response.sendRedirect("employees");
        } else {
            List<Employee> employees = employeeDAO.getAllEmployees();
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("/listEmployees.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String position = request.getParameter("position");
            Employee newEmployee = new Employee(0, name, position);
            employeeDAO.addEmployee(newEmployee);
            response.sendRedirect("employees");
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String position = request.getParameter("position");
            Employee updatedEmployee = new Employee(id, name, position);
            employeeDAO.updateEmployee(updatedEmployee);
            response.sendRedirect("employees");
        }
    }
}
