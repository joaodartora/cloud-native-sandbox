package com.joaodartora.devopsjobs.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/hello")
public class HelloServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");

		try (PrintWriter printWriter = response.getWriter()) {
			printWriter.write("<html> <h1> " + getMessage() + " </h1> </html>");
		}
	}

	public String getMessage() {
		return "Hello";
	}

}
