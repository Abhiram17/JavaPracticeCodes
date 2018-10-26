

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostExample
 */

public class PostExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
     //private String message = "Hello World";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
	}
// TODO do this!!
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
