

import java.io.IOException;
import java.sql.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FilterExample
 */
@WebFilter("/FilterExample")
public class FilterExample implements Filter {

    /**
     * Default constructor. 
     */
    public FilterExample() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Get the IP address of client machine.
	      String ipAddress = request.getRemoteAddr();

	      // Log the IP address and current timestamp.
	      System.out.println("IP "+ ipAddress + ", Time " + new Date(0).toString());

	      // Pass request back down the filter chain
	      
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		 String testParam = fConfig.getInitParameter("test-param"); 

	      //Print the init parameter 
	      System.out.println("Test Param: " + testParam); 
	}

}
