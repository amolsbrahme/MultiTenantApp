<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Tenant Info</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Tenant Config Page</h3>
 
    <table border="1" >
       <tr>
      		<td>Tenant Name</td>
            <td>${tenantBean.tenantName}</td>
       </tr>
       <tr>
      		<td>Background Color</td>
            <td>${tenantConfigBean.backgroundColor}</td>
       </tr>
    </table>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>