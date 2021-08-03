import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductDiscountServlet", urlPatterns = "/productDiscount")
public class ProductDiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        double discount = Double.parseDouble(request.getParameter("percent"));
        double discountAmount = price * discount * 0.01;
        double discountPrice = price - discountAmount;
        request.setAttribute("description", description);
        request.setAttribute("discountPrice", discountPrice);
        request.setAttribute("discountAmount", discountAmount);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/result/result.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
