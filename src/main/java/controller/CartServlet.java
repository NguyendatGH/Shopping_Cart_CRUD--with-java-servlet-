
package controller;

import bussiness.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        String url = "/view/Cart.jsp";

        if (action.equals("addItem")) {
            String code = request.getParameter("prodCode");
            HttpSession session = request.getSession(true);

            Cart cart = (Cart) session.getAttribute("cart");

            if (cart == null) {
                cart = new Cart();
            }
            cart.addItem(code);
            session.setAttribute("cart", cart);

        } else if (action.equals("removeItem")) {
            String prodCode = request.getParameter("prodCode");
            System.out.println("Item code to remove: " + prodCode);

            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");

            cart.removeItem(prodCode);

            session.setAttribute("cart", cart);
        }else if(action.equals("updateQuantity")){
           String code = request.getParameter("prodCode");
           String quantityString = request.getParameter("quantity");
           
           int quantity = Integer.parseInt(quantityString);
           
           HttpSession session = request.getSession();
           Cart cart = (Cart)session.getAttribute("cart");
           
           cart.updateQuantity(code, quantity);
           
           session.setAttribute("cart", cart);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("CartServlet is running...");
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
