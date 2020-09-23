
<%@tag description="Authentication Layout" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<h2>${message}</h2>

<!DOCTYPE html>
<html lang="en">

    <head>

      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <meta name="author" content="">

      <title>SB Admin 2 - Login</title>
      <!-- Custom fonts for this template-->
      <link rel="stylesheet" type="text/css"  href="static/vendor/fontawesome-free/css/all.min.css">
      <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" >

      <!-- Custom styles for this template-->
      <link href="static/css/sb-admin-2.min.css" rel="stylesheet" type="text/css">

    </head>

    <body class="bg-gradient-primary">

      <div class="container">

          <jsp:doBody/>

      </div>

      <!-- Bootstrap core JavaScript-->
      <script src="static/vendor/jquery/jquery.min.js" async></script>
      <script src="static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

      <!-- Core plugin JavaScript-->
      <script src="static/vendor/jquery-easing/jquery.easing.min.js"></script>

      <!-- Custom scripts for all pages-->
      <script src="static/js/sb-admin-2.min.js"></script>

    </body>

</html>
