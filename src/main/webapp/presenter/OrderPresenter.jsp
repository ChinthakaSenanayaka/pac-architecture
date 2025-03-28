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
    // document.getElementById("demo").innerHTML = "My First JavaScript";
</script> 
</head>
<body>

<p>This is the sample order presenter
    
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
              <td>${order.products[0].name}</td>
          </tr>
        </c:forEach>
      </table>
    </p>

</body>
</html> 