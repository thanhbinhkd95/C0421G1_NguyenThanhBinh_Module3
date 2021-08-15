package controller;

import model.bean.Customer;
import model.service.customer.CustomerService;
import model.service.customer.CustomerServiceImlp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImlp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "delete" :
                deleteCustomer(request, response);
                break;
            case "edit" :
                editCustomer(request, response);
                break;
            case "search" :
                searchCustomer(request, response);
                break;
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> customerList = customerService.findByName(name);

        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list-customer.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id, code, customerTypeId, name, birthday, gender, idCard, phone, email,address);
        Map<String, String> mapMessage = customerService.update(customer);
        System.out.println(mapMessage);
        if (mapMessage.isEmpty()){
            try {
                response.sendRedirect("/customer");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("messCustomercode", mapMessage.get("customerCode"));
            request.setAttribute("messEmail", mapMessage.get("email"));
            request.setAttribute("messPhone", mapMessage.get("phone"));
            request.setAttribute("messIdCard", mapMessage.get("idCard"));
            request.setAttribute("customer",customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        customerService.remove(id);

        try {
            response.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
       String code = request.getParameter("code");
       int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
       String name = request.getParameter("name");
       String birthday = request.getParameter("birthday");
       int gender = Integer.parseInt(request.getParameter("gender"));
       String idCard = request.getParameter("idCard");
       String phone = request.getParameter("phone");
       String email = request.getParameter("email");
       String address = request.getParameter("address");
       Customer customer = new Customer(code, customerTypeId, name, birthday, gender, idCard, phone, email,address);
       Map<String, String> mapMessage = customerService.save(customer);

       if (mapMessage.isEmpty()){
           try {
               response.sendRedirect("/customer");
           } catch (IOException e) {
               e.printStackTrace();
           }
       } else {
           request.setAttribute("messCustomercode", mapMessage.get("customerCode"));
           request.setAttribute("messEmail", mapMessage.get("email"));
           request.setAttribute("messPhone", mapMessage.get("phone"));
           request.setAttribute("messIdCard", mapMessage.get("idCard"));
           request.setAttribute("customer",customer);
           showFormCreate(request, response);
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
            case "customerUseService" :
                showListCustomerUseService(request, response);
                break;
            default:
                showListCustomer(request, response);
        }
    }

    private void showListCustomerUseService(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.selectAllCustomerUseService();
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list-customer-use-service.jsp");

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
       int id = Integer.parseInt(request.getParameter("id"));
       Customer customer = customerService.findById(id);
       request.setAttribute("customer", customer);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list-customer.jsp");

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
