<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<div style="background: ${tenantConfigBean.backgroundColor}; height: 55px; padding: 5px;">
  <div style="float: left">
  <table>
  	<tr>
  	    <th><img src="logo/${tenantBean.tenantAbbrev}.png" height="60" width="120"/></th>
    	<th><h1>${tenantBean.tenantName}</h1></th>

    	
  	</tr>
  </table> 
  
     
	 
  </div>
 
  <div style="float: right; padding: 10px; text-align: right;">
 
     <!-- User store in session with attribute: loginedUser -->
     Hello <b>${userBean.userName}</b>
   <br/>
    <!-- Search <input name="search"> -->
    <form action="LogoutServlet" method="post">
	<input type="submit" value="Logout" >
 	</form>
  </div>
 
</div>