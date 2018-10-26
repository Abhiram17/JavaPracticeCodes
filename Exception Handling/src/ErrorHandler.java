

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ErrorHandler
 */
@WebServlet("/ErrorHandler")
public class ErrorHandler implements Servlet {

    /**
     * Default constructor. 
     */
    public ErrorHandler() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		 // Analyze the servlet exception       
	      Throwable throwable = (Throwable)
	      request.getAttribute("javax.servlet.error.exception");
	      Integer statusCode = (Integer)
	      request.getAttribute("javax.servlet.error.status_code");
	      String servletName = (String)
	      request.getAttribute("javax.servlet.error.servlet_name");
	         
	      if (servletName == null) {
	         servletName = "Unknown";
	      }
	      String requestUri = (String)
	      request.getAttribute("javax.servlet.error.request_uri");
	      
	      if (requestUri == null) {
	         requestUri = "Unknown";
	      }

	      // Set response content type
	      response.setContentType("text/html");

	      PrintWriter out = response.getWriter();
	      String title = "Error/Exception Information";
	      String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " +
	         "transitional//en\">\n";
	         
	      out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title></head>\n" +
	         "<body bgcolor = \"#f0f0f0\">\n");

	      if (throwable == null && statusCode == null) {
	         out.println("<h2>Error information is missing</h2>");
	         out.println("Please return to the <a href=\"" + 
	           ("http://localhost:8080/") + 
	            "\">Home Page</a>.");
	      } else if (statusCode != null) {
	         out.println("The status code : " + statusCode);
	      } else {
	         out.println("<h2>Error information</h2>");
	         out.println("Servlet Name : " + servletName + "</br></br>");
	         out.println("Exception Type : " + throwable.getClass( ).getName( ) + "</br></br>");
	         out.println("The request URI: " + requestUri + "<br><br>");
	         out.println("The exception message: " + throwable.getMessage( ));
	      }
	      out.println("</body>");
	      out.println("</html>");
		System.out.println("got it!!!!!");
	}

}
