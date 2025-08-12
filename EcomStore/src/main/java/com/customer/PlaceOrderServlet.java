package com.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.ProductService;

@WebServlet("/user/placeOrder")
public class PlaceOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("customer");

        if (username == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        try {
            int addressId = Integer.parseInt(request.getParameter("address_id"));
            String paymentMethod = request.getParameter("paymentMethod");
            double grandTotal = Double.parseDouble(request.getParameter("grandTotal"));

            ProductService productService = new ProductService();
            int orderId = productService.placeOrder(username, addressId, paymentMethod, grandTotal);

            if (orderId > 0) {
                response.sendRedirect(request.getContextPath() + "/customer/orderConfirmation.jsp?orderId=" + orderId);
            } else {
                response.sendRedirect(request.getContextPath() + "/customer/checkout.jsp?error=OrderFailed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/customer/checkout.jsp?error=InvalidData");
        }
    }
}
