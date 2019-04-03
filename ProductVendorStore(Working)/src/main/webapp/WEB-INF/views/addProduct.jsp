<%@page import="com.cts.model.Product"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book Form</title>
</head>
<body>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.addbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.addbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>
<body>


<form action="saveProduct" method="Post" modelAttribute="product">
  <div class="container">
    <h1>Add product</h1>
    <hr>
    
    <input id=productId type="hidden" value="${product.id}" name="id" required>
 	
    <label for="name"><b>Name</b></label>
    <input id=nameId type="text"  placeholder="Enter Product Name" value="${product.name}" name="name"  required  >
 
   <label for="brand"><b>Brand</b></label>
    <input id=brandId type="text"  placeholder="Enter Brand" value="${product.brand}" name="brand"  required  >
  

    <label for="price"><b>Price</b></label>
    <input id=priceId type="text" placeholder="Enter Price" value="${product.price}" name="price"  required>
    
    <label for="category"><b>Category</b></label>
    <input id=categoryId type="text"  placeholder="Enter Category" value="${product.category}" name="category"  required  >
 
   <label for="rating"><b>Ratings</b></label>
    <input id=ratingId type="text"  placeholder="Enter Ratings" value="${product.rating}" name="rating"  required  >
    
    <label for="vendor_id"><b>Vendor ID</b></label>
    <input id=vendorId type="text"  placeholder="Enter Vendor's ID" value="${product.vendor_id}" name="vendor_id"  required  >
    

    <button type="submit" class="addbtn">Add Product</button>
  </div>

</form>
</body>
</html>