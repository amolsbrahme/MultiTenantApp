<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>User Profile</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>User Profile Page</h3>
 
    <table border="1" >
       <tr>
      		<td>User Name</td>
            <td>${userBean.userName}</td>
       </tr>
       <tr>
      		<td>Email</td>
            <td>${userBean.email}</td>
       </tr>
        <tr>
      		<td>Groups</td>
            <td>${userBean.group}</td>
       </tr>
    </table>

    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>