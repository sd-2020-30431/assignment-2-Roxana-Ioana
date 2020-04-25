<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <title>User Login Page</title>

    <spring:url value="/resources/login.css" var="crunchifyCSS" />
    <spring:url value="/resources/login.js" var="crunchifyJS" />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <!-- Google Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Poppins:400,300,500,600,700' rel='stylesheet' type='text/css'>
    <!-- Font Awesome -->
    <link href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css' rel='stylesheet'
          type='text/css'>
    <!-- Style -->
    <link href="css/style1.css" rel="stylesheet" type="text/css">
</head>

<body>

<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <h2 class="section-title">Log In</h2>
            </div>
            <div class="col-md-8 col-md-offset-2">
                <form id="contact" method="post" action="/" class="form" role="form">
                    <div class="row">
                        <div class="col-md-6 form-group">
                            <input class="form-control" id="name" name="username" placeholder="Name" type="text" required />
                        </div>
                        <div class="col-md-6 form-group">
                            <input class="form-control" id="email" name="password" placeholder="Password" type="password" required />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group">
                            <button class="btn btn-primary" type="submit">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div><!--/.row-->
    </div><!--/.container-->
</div>
</body>
</html>