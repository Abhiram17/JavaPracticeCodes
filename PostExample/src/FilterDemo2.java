

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class FilterDemo
 */
@WebFilter("/getit")
public class FilterDemo2 implements Filter {

   

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	//HttpServletRequest req = (HttpServletRequest)response;
		PrintWriter out = response.getWriter();
		System.out.println("Inside filter 2");
	int num = Integer.parseInt(request.getParameter("last_name"));
	if(num>10) {
		chain.doFilter(request, response);
	}
	else
		out.println("<Html><h1>Value less than 10</h1></Html>");
	
	}
	
	 
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
