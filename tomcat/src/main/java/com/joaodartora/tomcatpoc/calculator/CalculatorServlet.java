package com.joaodartora.tomcatpoc.calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.joaodartora.tomcatpoc.operations.MathOperation;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 355111841111881495L;
	
	private static ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	private static Calculator calculator = (Calculator) context.getBean("calculator");
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{  
			response.setContentType("text/html");
			try(PrintWriter out = response.getWriter()){
			  
			out.println("<html><body>");  
			out.println("Welcome to Calculator Servlet <br>");  
			out.println("Instructions to use the calculator: <br>");
			out.println("Type in URL: ?firstNumber=x&secondNumber=y&operation=z <br>");
			out.println("Replacing X and Y with numbers and z with the selected operation between: SUM | SUB | MULTI | DIV | POW");
			out.println("<br><br>");
			  
			String firstNumber = request.getParameter("firstNumber");
	        String secondnumber = request.getParameter("secondNumber");
	        String operation = request.getParameter("operation");
	        
	        out.println("Values: " + firstNumber + "  &  " + secondnumber + "- Operation Type:  " + operation);
	        out.println("<br>");
	        out.println("Result of the last operation = " );
	        out.println(calculator.executeOperation(operation, Double.parseDouble(firstNumber), Double.parseDouble(secondnumber)));
	        
	        out.println("<br><br> History of operations: <br>");
	        for(MathOperation mathOperation:calculator.getCalculatorHistory()){
	            out.println(mathOperation.toString() + "<br>");
	        }
	        
	        out.println("</body></html>"); 
			out.close(); 
			}
	}

}
