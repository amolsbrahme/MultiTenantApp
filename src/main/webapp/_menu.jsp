<%@ page language="java" contentType="text/html; charset=UTF-8"
   import="com.multitenant.user.User"
   pageEncoding="UTF-8"%>
    
<div style="padding: 5px;">
   <a href=<%=request.getContextPath() %>/homeView.jsp>Home</a>
   <%
        User user = (User) session.getAttribute("userBean");
   		String contextPath = request.getContextPath();
   		
   		if ("Manager".equalsIgnoreCase(user.getGroup())) {
			out.println("||<a href=\""+contextPath+"/managerView.jsp\">Manage Subordinates</a>");
   		}
   		
   		if ("Admin".equalsIgnoreCase(user.getGroup())) {
			out.println("||<a href=\""+contextPath+"/configView.jsp\">Configure Tenant</a>");
   		}
	%>
   <!--  <a href="/manageReporties">Manage Subordinates</a>
   |
   <a href="/configTenant">Configure Tenant</a>
   |  -->
   ||
   <a href=<%=request.getContextPath() %>"/profileView.jsp">My Account Info</a>
</div>