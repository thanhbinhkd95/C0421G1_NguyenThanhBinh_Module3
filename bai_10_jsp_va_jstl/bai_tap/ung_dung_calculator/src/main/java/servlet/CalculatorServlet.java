package servlet;

import model.Calculator;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        float firstOperand = Integer.parseInt(request.getParameter("first-operand"));
        float secondOperand = Integer.parseInt(request.getParameter("second-operand"));
        char operator = request.getParameter("operator").charAt(0);
        float result = 0;
        String string = null;

        try {
            result = Calculator.calculate(firstOperand, secondOperand, operator);
            string = firstOperand + " " + operator + " " + secondOperand + " = " + result;
        }catch (Exception ex){
            string = "Error: " + ex.getMessage();
        }

        request.setAttribute("string",string);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
