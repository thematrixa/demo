package com.example.GorchyGames;

/**
	 * 
	 */

/**
 * @author vspolimenov
 *
 */
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCORSFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		String origin = request.getHeader("origin");
		if (allowedAccess(origin)) {
			response.setHeader("Access-Control-Allow-Origin", origin);
		}

		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"content-type, accept, x-requested-with, authorization, x-ajax-call, language");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-control", "max-age=0");
		response.setHeader("Cache-control", "no-cache");

		if (!request.getMethod().toString().equals("OPTIONS")) {
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

	private boolean allowedAccess(String ref) {

		Map<String, Boolean> accessMap = new HashMap<>();
		accessMap.put("http://localhost:4200", true);
		return accessMap.getOrDefault(ref, false);
	}

}
