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
<title>Product List</title>
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


<input type="button" value="Add Product"
 onclick="window.location.href='showForm'; return false;" class="btn btn-primary"/>
 
 
<input type="button" value="Logout" style="float: right;"
 onclick="window.location.href='logout'; return false;" class="btn btn-primary"/>


<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
    
      <div style="background-color:#B7B7B5; text-align:center ;"> <h3 align="center" style="padding: 11px;" >Profile</h3></div>
   <div class="profile-data">
     <span class="border" style=" padding:10px;" >
    <img class="manImg" src="http://simpleicon.com/wp-content/uploads/user1.png" style="max-height: 150px; max-width: 150px; padding-left:45px;" ></img>
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
        <a class="navbar-brand" href="#" style="background-color: #B7B7B5; width: auto; text-align: center ; " >Product</a>
    </div>
    
    <div class="navbar-header">
      <a class="navbar-brand" href="/demo/vendor/vendorlist" style="background-color: #C1BFBC ; margin-left:0px ;width: auto ; text-align: center ;">Vendors</a>
    </div>
  </div>
</nav>


<br><br>
<div class="container">
  <h2>Product Table</h2>  
        <table class="table">
    <thead>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Brand</th>
        <th>Category</th>
        <th>Price</th>
        <th>Ratings</th>
    	<th>View</th>
        <th>Update</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="tempproduct" items="${product}">
    
    <c:url var="viewLink" value="/product/view">
    <c:param name="productId" value="${tempproduct.id}"/>
    </c:url>
    
    <c:url var="updateLink" value="/product/updateForm">
    <c:param name="productId" value="${tempproduct.id}"/>
    </c:url>
    
     <c:url var="deleteLink" value="/product/delete">
    <c:param name="productId" value="${tempproduct.id}"/>
    </c:url>
    
    
    <tr>

       <td>${tempproduct.id}</td>
      <td>${tempproduct.name}</td>
     <td>${tempproduct.brand}</td>
     <td>${tempproduct.category}</td>
      <td>${tempproduct.price}</td>
      <td>${tempproduct.rating}</td>
      <td><a href="${viewLink }">View</a>
        <td><a href="${updateLink}">Update</a>
       <td><a href="${deleteLink}" onclick="id(!(confirm('Are you sure you want to delete this Product?'))return false)">Delete</a> 
      
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