/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.Command;

/**
 *
 * @author MSI
 */
 @WebServlet("/mmm")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RequestHelper requestHelper = RequestHelper.getInstance();

    public Index() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
                request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("command");
		Command command = requestHelper.getCommand(action);
		InDataWrapper inData = new InDataWrapper(request);
		
		String page;
		try {
			page = command.execute(inData);		
			
		} catch (Exception e) {
			page = "/WEB-INF/jsp/error_page.jsp";
		}
		
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(page);
		dispatch.forward(request, response);
	}

}