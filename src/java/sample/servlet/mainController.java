/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tuank
 */
public class mainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                
            String url = "errorpage.html";
            String action = request.getParameter("action");
            
            if(action==null && action.equals("") && action.equals("search")){
                url = "index.jsp";
            }else if(action.equals("login")){
                url = "loginServlet";
            }else if(action.equals("register")){
                url = "registerServlet";
            }else if(action.equals("logout")){
                url = "logoutServet";
            }else if(action.equals("search")){
                url = "searchServlet";
            }else if(action.equals("addtocart")){
                url = "addToCartServlet";
            }else if(action.equals("viewcart")){
                url = "viewCart.jsp";
            }else if(action.equals("update")){
                url = "updateCartServlet";
            }else if(action.equals("delete")){
                url = "deleteCartServlet";
            }else if(action.equals("saveOrder")){
                url = "saveShoppingCartServlet";
            // phần này của admin
            }else if(action.equals("manageAccounts")){
                // sửa lại theo hàm search chuyển từ manager qua search Acc
                url = "searchAccountServlet";
                
            }else if(action.equals("updateStatusAccount")){
                url = "updateStatusAccountServlet";
            }else if(action.equals("manageOrders")){
                url = "manageOrdersServlet";
            }else if(action.equals("updateStatusOrder")){
                url = "updateStatusOrderServlet";
                // đổi lại Plants về hàm search
            }else if(action.equals("managePlants")) {
                url = "searchPlantServlet";
                // đang kiểm tra
            }else if(action.equals("updateStatusPlant")){
                url = "updateStatusPlantServlet";
            }else if(action.equals("managerCategories")){
                url = "managerCategoriesServlet";
                
            // phần này của user
            }else if(action.equals("updateProfile")){
                url = "updateProfileServlet";
            }else if(action.equals("completedOrders")){
                url = "completedOrdersServlet";
                
                // đang lỗi 
            }else if(action.equals("cancelOrder")){
                url = "cancelOrdersServlet";
            }else if(action.equals("orderAgian")){
                url = "orderAgianServlet";
            }else if(action.equals("processingOrders")){
                url = "processingOrdersServlet";
                
            // các hàm search
            }else if(action.equals("searchAccount")){
                url = "searchAccountServlet";
            }else if(action.equals("searchOrder")){
                url = "searchOrderServlet";
            }else if(action.equals("searchPlant")){
                url = "searchPlantServlet";
                // update profile
            }else if(action.equals("updateProfile")){
                url ="updateProfileServlet";
            }else if(action.equals("searchWithDate")){
                url = "searchWithDateServlet";
            }else if(action.equals("AddPlant")){
                url ="addPlant.jsp";
            }else if(action.equals("saveAddPlant")){
                url= "saveAddPlantServlet";
            }else if(action.equals("UpdatePlant")){
                url="updatePlant.jsp";
            }else if(action.equals("SaveUpdatePlant")){
                url ="SaveUpdatePlantServlet";
            }
            
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
