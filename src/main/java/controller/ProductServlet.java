package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceIpml;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceIpml();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action="";
        }
            switch (action){
                case "create":
                    showCreateForm(request,response);
                    break;
                case "edit":
                    showEditForm(request,response);
                    break;
                case "view":
                    viewProduct(request,response);
                    break;
                case "delete":
                    showDeleteForm(request,response);
                    break;
                default:
                    listProduct(request,response);
                    break;
            }
        }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;
        if(product==null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else {
            dispatcher = request.getRequestDispatcher("product/delete.jsp");
            request.setAttribute("product",product);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;
        if(product==null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else {
            dispatcher = request.getRequestDispatcher("product/view.jsp");
            request.setAttribute("product",product);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else {
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
            request.setAttribute("product",product);
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = productService.findAll();
        request.setAttribute("products",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action = request.getParameter("action");
if(action == null){
    action="";
}
    switch (action){
        case "create":
            createProduct(request,response);
            break;
        case "edit":
            editProduct(request,response);
            break;
        case "delete":
            deleteProduct(request,response);
            break;
        default:
            listProduct(request,response);
            break;
    }
}

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;
        if(product==null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            productService.delete(id);
        }
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String des = request.getParameter("des");
        String producer = request.getParameter("producer");
        Product product = productService.findById(id);
        RequestDispatcher dispatcher ;
        if( product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        else {
            product.setName(name);
            product.setPrice(price);
            product.setDes(des);
            product.setProducer(producer);
            this.productService.update(id,product);
            dispatcher = request.getRequestDispatcher("product/edit.jsp");
            request.setAttribute("product",product);
            request.setAttribute("message","Products was updated");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String des = request.getParameter("des");
        String producer = request.getParameter("producer");
        int id = (int)(Math.random()*1000);
        Product product = new Product(id,name,price,des,producer);
        productService.save(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message","Product was created");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
