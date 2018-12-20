<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>UXP Systems Update User</title>
 </head>
 <body>
  <h2>Update User Data</h2>
  <form:form method="PUT" var="user" action="/user" modelAttribute="updateUser">
      <table>
      <tr>
           <td><form:label path="id">User Id:</form:label></td>
           <td><form:input path="id" value="${user.id}" type="text"/></td>
       </tr>
       <tr>
           <td><form:label path="username">User Name:</form:label></td>
           <td><form:input path="username" value="${user.username}" type="text"/></td>
       </tr>
       <tr>
           <td><form:label path="password">Password</form:label></td>
           <td><form:input path="password" value="${user.password}" type="text"/></td>
       </tr>
       <tr>
           <td><form:label path="status">Status:</form:label></td>
           <td><form:input path="status" value="${user.status}" type="text"/></td>
       </tr>
       
      
          <tr>
         <td colspan="2"><input type="submit" value="Submit"/></td>
        </tr>
   </table> 
  </form:form>
  </body>