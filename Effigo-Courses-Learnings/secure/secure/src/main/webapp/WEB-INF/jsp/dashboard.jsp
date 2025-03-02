<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <nav class="navbar navbar-expand-lg navbar-dark bg-success">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Dashboard</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="about">About</a></li>
                    <li class="nav-item"><a class="nav-link" href="contact">Contact</a></li>
                    <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container text-center mt-5">
        <h2 class="text-success">Welcome to Your Dashboard</h2>
                <p class="lead">You are logged in as <b>${pageContext.request.userPrincipal.name}</b>.</p>


        <div class="mt-4">
            <a href="product" class="btn btn-info m-2">Manage Products</a>  <%-- New Button --%>
            <a href="productList" class="btn btn-warning m-2">Products List</a>
            <a href="logout" class="btn btn-danger m-2">Logout</a>
        </div>
    </div>

</body>
</html>
