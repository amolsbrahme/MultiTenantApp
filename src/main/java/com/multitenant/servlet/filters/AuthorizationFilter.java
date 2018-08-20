package com.multitenant.servlet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multitenant.auth.service.AuthenticationManager;
import com.multitenant.auth.service.AuthenticationResponse;
import com.multitenant.auth.service.AuthenticationService;
import com.multitenant.domain.SimpleTenantManager;
import com.multitenant.domain.Tenant;
import com.multitenant.domain.TenantManager;
import com.multitenant.user.LDAPUserManager;
import com.multitenant.user.User;
import com.multitenant.user.UserManager;

@WebFilter("/AuthenticationFilter")
public class AuthorizationFilter implements Filter {

	private ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		this.context.log("Requested Resource::"+uri);
		
		HttpSession session = req.getSession(false);
		
		if(session == null) {
			// pass the request along the filter chain
			String userName = request.getParameter("user");
			String password = request.getParameter("pwd");
			
			TenantManager tenantManager = new SimpleTenantManager();
			int index = userName.indexOf("@");
			String emailDomain = userName.substring(index+1);
			Tenant tenant = tenantManager.getTenantByEmailDomain(emailDomain);
			AuthenticationService authSvc = AuthenticationManager
					.getAuthenticationService(userName);
			
			AuthenticationResponse authResult = authSvc.authenticate(tenant, userName, password);
			
			if(authResult.isResult()) {
				session = req.getSession();
				session.setAttribute("user", authResult.getUser().getUserName());
				session.setAttribute("tenantID", authResult.getUser().getTenantID());
				session.setAttribute("userBean", authResult.getUser());
				//setting session to expiry in 30 mins
				session.setMaxInactiveInterval(30*60);
				Cookie user = new Cookie("user", authResult.getUser().getUserName());
				user.setMaxAge(30*60);
				res.addCookie(user);
				chain.doFilter(request, response);
			} else {
				res.sendRedirect("relogin.html");
			}
		} else {
			res.sendRedirect("login.html");
		}
	}


	

	public void destroy() {
		//close any resources here
	}

}
