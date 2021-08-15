package controller;

import model.bean.Contract;
import model.bean.ContractDetail;
import model.service.contract_detail.ContractDetailService;
import model.service.contract_detail.ContractDetailServiceImlp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/contractDetail")
public class ContractDetailServlet extends HttpServlet {
    ContractDetailService contractDetailService = new ContractDetailServiceImlp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createContractDetail(request, response);
                break;
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int contractId = Integer.parseInt(request.getParameter("contractId"));
        int attachServiceId = Integer.parseInt(request.getParameter("attachServiceId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        ContractDetail contractDetail = new ContractDetail(contractId, attachServiceId, quantity);
        contractDetailService.save(contractDetail);

        try {
            response.sendRedirect("/contractDetail");
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
            default:
                showListContractDetail(request, response);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/contract_detail/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListContractDetail(HttpServletRequest request, HttpServletResponse response) {
        List<ContractDetail> contractDetailList = contractDetailService.findAll();
        request.setAttribute("contractDetailList", contractDetailList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/contract_detail/list-contract-detail.jsp");

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
