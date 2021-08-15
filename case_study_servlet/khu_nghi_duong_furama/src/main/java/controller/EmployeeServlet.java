package controller;

import model.bean.Customer;
import model.bean.Employee;
import model.service.employee.EmployeeService;
import model.service.employee.EmployeeServiceImlp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImlp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "delete" :
                deleteEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "search" :
                searchEmployee(request, response);
                break;
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Employee> employeeList = employeeService.findByName(name);

        request.setAttribute("employeeList", employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list-employee.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String username = request.getParameter("username");
        Employee employee = new Employee(id, name,birthday, idCard, salary, phone, email, address, positionId, educationDegreeId,divisionId,username);

        Map<String, String> mapMessage = employeeService.update(employee);
        if (mapMessage.isEmpty()){
            try {
                response.sendRedirect("/employee");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("messEmail", mapMessage.get("email"));
            request.setAttribute("messPhone", mapMessage.get("phone"));
            request.setAttribute("messIdCard", mapMessage.get("idCard"));
            request.setAttribute("messSalary", mapMessage.get("salary"));
            request.setAttribute("employee",employee);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String username = request.getParameter("username");
        Employee employee = new Employee(name,birthday, idCard, salary, phone, email, address, positionId, educationDegreeId,divisionId,username);
        Map<String, String> mapMessage = employeeService.save(employee);

        if (mapMessage.isEmpty()){
            try {
                response.sendRedirect("/employee");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("messEmail", mapMessage.get("email"));
            request.setAttribute("messPhone", mapMessage.get("phone"));
            request.setAttribute("messIdCard", mapMessage.get("idCard"));
            request.setAttribute("messSalary", mapMessage.get("salary"));
            request.setAttribute("employee",employee);
            showFormCreate(request, response);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        employeeService.remove(id);

        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            default:
                showListEmployee(request, response);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        Employee employee = employeeService.findById(id);
        request.setAttribute("employee", employee);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.findAll();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list-employee.jsp");

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
