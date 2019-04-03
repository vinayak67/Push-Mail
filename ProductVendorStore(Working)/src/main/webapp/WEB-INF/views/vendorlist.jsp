<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Vendors List</title>
<style>
.jumbotron {
padding-top: 0;
    padding-bottom: 0;
}
</style>
</head>
<body>



<div class="jumbotron">
	<div class="container">
  
    <h3 align="center">Welcome ${ pageContext.request.userPrincipal.name}!</h3> 
  
  </div>
</div>
 
 <input type="button" value="Logout" style="float: right;"
 onclick="window.location.href='logout'; return false;" class="btn btn-primary"/>
 
 <br>
 <div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
    
      <div style="background-color:#B7B7B5; text-align:center ;"> <h3 align="center" style="padding: 11px;" >Profile</h3></div>
   <div class="profile-data">
     <span class="border" style=" padding:10px;" >
    <img class="manImg" src="http://simpleicon.com/wp-content/uploads/user1.png" style="max-height: 150px; max-width: 150px;padding-left:45px" ></img>
    </span>
    <ul class="nav nav-pills nav-stacked">
        <li><a>Username :</a></li>
        <p style="padding-left: 35px;">${ pageContext.request.userPrincipal.name}<p>
     
        <li><a>Designation :</a></li>
        <p style="padding-left: 35px;">Administrator<p>
        <li><a>Office :</a></li>
        <p style="padding-left: 35px;">CTS<p>
      </ul>
      <br>
    
    </div>
</div>
<br>
    <div class="col-sm-9">
    
<nav class="navbar navbar-default"  style="background-color:#EFEDEA; width:600px;" >
  <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="/demo/product/list" style="background-color: #B7B7B5; width: auto; text-align: center ; " >Product</a>
    </div>
    
    <div class="navbar-header">
      <a class="navbar-brand" href="#" style="background-color: #C1BFBC ; margin-left:0px ;width: auto ; text-align: center ;">Vendors</a>
    </div>
  </div>
</nav>

  <a href="showForm" class="btn " role="button">Add Vendor </a>

<br><br>
<div class="container">
    
        <table class="table">
    <thead>
      <tr>
        <th>Name</th>
        <th>ID</th>
        <th>Location</th>
        <th>Contact</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="tempvendor" items="${vendor}">
    
      <c:url var="showProductLink" value="/vendor/showProduct">
    <c:param name="vendorId" value="${tempvendor.id}"/>
    </c:url>
    
    
    <tr>

       <td>${tempvendor.name}</td>
      <td>${tempvendor.id}</td>
     <td>${tempvendor.location}</td>
     <td>${tempvendor.contact}</td>
     
     <td>
     <input type="button" value="Show Products"
      onclick="window.location.href='${showProductLink}'; return false" class="btn btn-primary"/>
     </td>
     
      
      
    </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</div>
</div>
</div>
</body>
</html>