package cs.spring.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class CustomFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse lResponse = (HttpServletResponse) response;
		lResponse.setHeader("Access-Control-Allow-Origin", "*");
		lResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		lResponse.setHeader("Access-Control-Max-Age", "3600");
		lResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        chain.doFilter(request, response);
	}

}
