<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
          }
    </style>
    <script>
    </script> 
  </head>
  <body>

    <p><b style="font-size:150%">Products:</b></p>
      
    <table>
      <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Quantity</th>
        <th>Seller Name</th>
      </tr>
      <c:forEach items="${products}" var="product">
        <tr>      
          <td>${product.id}</td>
          <td>${product.name}</td>
          <td>${product.quantity}</td>
          <td>${product.seller.firstName}</td>
        </tr>
      </c:forEach>
    </table>

  </body>
</html> 