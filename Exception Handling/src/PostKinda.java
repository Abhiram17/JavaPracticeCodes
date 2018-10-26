

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostKinda
 */
@WebServlet("/PostKinda")
public class PostKinda implements Servlet {

   
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title= "Using Data from url";
		String doctype = 
				"<!doctype html>";
	      out.println(doctype+
	    		  "<html>\n"+
	    		  "<head><title >"+title+"</title></head>"
	    		  +"<body bgcolor = \"#f0f0f0\">"+
	    		  "<h1 align = \"center\">"+title+"</h1>"+
	    		  "<ul>\n"+
	    		  "<li><b>Physics: </b> "
	    		  +request.getParameter("physics")+ "\n" 
	    		  +"<li><b>Chemistry: </b> "
	    		  +request.getParameter("chemistry")+ "\n" +
	    		  "<li><b>Math: </b>"+ "\n"+
	    		  request.getParameter("math")+
	    		  "</ul>\n"+
	    		  "</body>"+
	    		  "</html>"
	    		  );
	      try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		//	((HttpServletResponse) response).sendError(401,"Unotherized");

	  
	}


	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
