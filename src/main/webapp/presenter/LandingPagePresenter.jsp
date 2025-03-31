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
    
    <p><b style="font-size:200%">Welcome ${user.firstName} ${user.lastName}</b></p>
    <p>Your user ID: ${user.id} and role: ${user.userType}</p>
        
    <iframe src="/product/${user.id}" title="Products" id="ProductsViewId" width="48%" height="600"></iframe> 

    <iframe src="/order/${user.id}" title="Orders" id="OrdersViewId" width="48%" height="600"></iframe> 

    </body>
</html>