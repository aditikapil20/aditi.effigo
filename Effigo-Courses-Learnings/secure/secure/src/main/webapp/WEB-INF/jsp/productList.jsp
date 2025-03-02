<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <nav class="navbar navbar-expand-lg navbar-dark bg-success">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Product List</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="dashboard">Dashboard</a></li>
                    <li class="nav-item"><a class="nav-link" href="about">About</a></li>
                    <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <h2 class="text-center text-success">Product List</h2>

        <!-- Sorting Buttons -->
        <div class="mb-3">
            <a href="productList?sort=price" class="btn btn-outline-primary btn-sm">Sort by Price</a>
            <a href="productList?sort=quantity" class="btn btn-outline-primary btn-sm">Sort by Quantity</a>
        </div>

        <c:choose>
            <c:when test="${not empty products}">
                <table class="table table-bordered mt-4">
                    <thead class="table-success">
                        <tr>
                            <th>ID</th>
                            <th>Product Name</th>
                            <th>Description</th>
                            <th>Quantity</th>
                            <th>Cost</th>
                            <th>Total Cost</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="totalProductsCost" value="0" />
                        <c:forEach var="product" items="${products}">
                            <c:set var="totalCost" value="${product.cost * product.quantity}" />
                            <tr>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.description}</td>
                                <td>${product.quantity}</td>
                                <td>${product.cost}</td>
                                <td>${totalCost}</td>
                            </tr>
                            <c:set var="totalProductsCost" value="${totalProductsCost + totalCost}" />
                        </c:forEach>
                        <tr class="table-warning">
                            <td colspan="5" class="text-end fw-bold">Total Products Cost:</td>
                            <td class="fw-bold">${totalProductsCost}</td>
                        </tr>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p class="text-center text-danger">No products available.</p>
            </c:otherwise>
        </c:choose>

        <a href="dashboard" class="btn btn-outline-primary">Go Back To Dashboard</a>
        <a href="product" class="btn btn-success">Add Product</a>
    </div>

</body>
</html>
