/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Category;
import entity.Product;
import java.io.IOException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.CategoryFacade;
import session.ProductFacade;

/**
 *
 * @author KarinaRomero
 */
@WebServlet(name = "Controller",
            loadOnStartup = 1,
            urlPatterns = {"/category",
                           "/addToCart",
                           "/viewCart",
                           "/updateCart",
                           "/checkout",
                           "/purchase",
                           "/chooseLanguage"})

public class ControllerServlet extends HttpServlet {

    @EJB
    private CategoryFacade categoryFacade;
    @EJB
    private ProductFacade productFacade;
    
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        this.getServletContext().setAttribute("categories", categoryFacade.findAll());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        Category selectedCategory;
        Collection<Product> categoryProducts;

    if (userPath.equals("/category")) {
            String categoryId = request.getQueryString();

            if (categoryId != null) {

                selectedCategory = categoryFacade.find(Short.parseShort(categoryId));
                session.setAttribute("selectedCategory", selectedCategory);
                categoryProducts = selectedCategory.getProductList();
                session.setAttribute("categoryProducts", categoryProducts);
            }
        } else if (userPath.equals("/chooseLanguage")) {

            String language = request.getParameter("language");
            request.setAttribute("language", language);

            String userView = (String) session.getAttribute("view");

            if ((userView != null)
                    && (!userView.equals("/index"))) {

                userPath = userView;
            } else {

                try {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } catch (ServletException | IOException ex) {
                }
                return;
            }
        }

        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (ServletException | IOException ex) {
        }
    }
}
