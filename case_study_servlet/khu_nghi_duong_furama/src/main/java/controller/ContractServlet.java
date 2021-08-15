package controller;

import model.bean.Contract;
import model.bean.Service;
import model.repository.contract.ContractRepository;
import model.service.contract.ContractService;
import model.service.contract.ContractServiceImlp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    ContractService contractService = new ContractServiceImlp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createContract(request, response);
                break;
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        String starDate = request.getParameter("starDate");
        String endDate = request.getParameter("endDate");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        double totalMoney = Double.parseDouble(request.getParameter("totalMoney"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));

        Contract contract = new Contract(starDate, endDate, deposit, totalMoney, employeeId, customerId, serviceId);
        Map<String, String> mapMessage = contractService.save(contract);

        if (mapMessage.isEmpty()){
            try {
                response.sendRedirect("/contract");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("messDeposit", mapMessage.get("deposit"));
            request.setAttribute("messTotalMoney", mapMessage.get("totalMoney"));
            request.setAttribute("contract",contract);
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
                showListContract(request, response);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contractList = contractService.findAll();
        request.setAttribute("contractList", contractList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract/list-contract.jsp");

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
