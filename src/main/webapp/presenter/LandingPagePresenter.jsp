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
            window.setInterval("refreshEvery1Sec();", 1000); // 1 sec refresh rate

            function refreshEvery1Sec() {
                document.getElementById('ProductsViewId').contentWindow.location.reload();
                document.getElementById('OrdersViewId').contentWindow.location.reload();
            }
        </script> 
    </head>
    <body>

    <p>This is the sample landing page presenter</p>
    <p>Logged in user ID: ${user.id}, name: ${user.firstName} ${user.lastName}</p>
    <p>User role: ${user.userType}</p>
        
    <iframe src="/product/${user.id}" title="Products" id="ProductsViewId" width="45%" height="500"></iframe> 

    <iframe src="/order/${user.id}" title="Orders" id="OrdersViewId" width="45%" height="500"></iframe> 

    </body>
</html>