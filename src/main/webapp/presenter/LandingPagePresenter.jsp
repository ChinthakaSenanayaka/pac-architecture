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

    <p>This is the sample landing page presenter</p>
    <p>Logged in user ID: ${user.id}, name: ${user.firstName} ${user.lastName}</p>
    <p>User role: ${user.userType}</p>
        
    <iframe src="/product/${user.id}" title="Products"  width="500" height="500"></iframe> 

    <iframe src="/order/${user.id}" title="Orders"  width="500" height="500"></iframe> 

    </body>
</html>