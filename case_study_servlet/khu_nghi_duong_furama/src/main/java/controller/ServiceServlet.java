package controller;

import model.bean.Customer;
import model.bean.Service;
import model.service.common.Validate;
import model.service.service.ServiceService;
import model.service.service.ServiceServiceImlp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    ServiceService serviceService = new ServiceServiceImlp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createService(request, response);
                break;
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberFloor = Integer.parseInt(request.getParameter("numberFloor"));

        Service service = new Service(code, name, area, cost, maxPeople, rentTypeId, serviceTypeId, standardRoom, description, poolArea, numberFloor);
        Map<String, String> mapMessage = serviceService.save(service);
        if (mapMessage.isEmpty()){
            try {
                response.sendRedirect("/service");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("messCode", mapMessage.get("code"));
            request.setAttribute("messArea", mapMessage.get("area"));
            request.setAttribute("messCost", mapMessage.get("cost"));
            request.setAttribute("messMaxpeople", mapMessage.get("maxPeople"));
            request.setAttribute("messPoolArea", mapMessage.get("poolArea"));
            request.setAttribute("messNumberFloor", mapMessage.get("numberFloor"));
            request.setAttribute("service",service);
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
            default:
                showListEmployee(request, response);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = serviceService.findAll();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/list-service.jsp");

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
