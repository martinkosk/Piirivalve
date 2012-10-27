package ee.itcollege.borderproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ee.itcollege.borderproject.dao.GuardDao;
import ee.itcollege.borderproject.dao.GuardDaoJdbc;
import ee.itcollege.borderproject.model.Guard;
import ee.itcollege.borderproject.util.GuardGenerator;

@WebServlet("/generateGuards")
public class GenerateGuardsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final String GUARD_COUNT_PARAMETER = "count";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		try {
			int guardCount = Integer.parseInt(request.getParameter(GUARD_COUNT_PARAMETER));
            List<Guard> generatedGuards = new GuardGenerator().generate(guardCount);  
            
            GuardDao guardDao = new GuardDaoJdbc();
            guardDao.saveGuards(generatedGuards);
            request.setAttribute("generatedGuards", generatedGuards);
            
            RequestDispatcher dispatcher = 
            		  getServletContext().getRequestDispatcher("/ViewGeneratedGuards.jsp");
            dispatcher.forward(request, response);           
		} catch (NumberFormatException e) {
			
		}
	}
	
	
}
