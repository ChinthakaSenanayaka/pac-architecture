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

    <p><b style="font-size:150%">Orders:</b></p>
        
    <table>
      <tr>
        <th>Order ID</th>
        <th>Customer Name</th>
        <th>Products</th>
      </tr>
      <c:forEach items="${orders}" var="order">
        <tr>      
          <td>${order.id}</td>
          <td>${order.customer.firstName}</td>
          <td>
            <c:forEach items="${order.products}" var="product">
              ${product.name},
            </c:forEach>
          </td>
        </tr>
      </c:forEach>
    </table>
    
  </body>
</html> 