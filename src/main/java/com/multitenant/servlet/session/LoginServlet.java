package com.multitenant.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multitenant.domain.SimpleTenantConfiManager;
import com.multitenant.domain.SimpleTenantManager;
import com.multitenant.domain.Tenant;
import com.multitenant.domain.TenantConfig;
import com.multitenant.domain.TenantConfigManger;
import com.multitenant.domain.TenantManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		int tenantID = (Integer)session.getAttribute("tenantID");
		
		TenantManager tenantManager = new SimpleTenantManager();
		Tenant tenant = tenantManager.getTenantByID(tenantID);
		session.setAttribute("tenantBean", tenant);
        
        TenantConfigManger tenantConfigManger = new SimpleTenantConfiManager();
        TenantConfig tenantConfig = tenantConfigManger.getTenantConfigByID(tenantID);
        session.setAttribute("tenantConfigBean", tenantConfig);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("homeView.jsp");
        dispatcher.forward(request, response);
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doPost(request, response);
    }

}
