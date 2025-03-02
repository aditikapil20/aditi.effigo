<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <h2 class="text-center text-primary">Add a New Product</h2>

        <form action="addProduct" method="post" class="mt-4">
            <div class="mb-3">
                <label class="form-label">Product Name</label>
                <input type="text" name="name" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Product Description</label>
                <textarea name="description" class="form-control" rows="3" required></textarea>
            </div>

            <div class="mb-3">
                <label class="form-label">Quantity</label>
                <input type="number" name="quantity" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Cost</label>
                <input type="number" name="cost" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-success">Submit</button>
            <a href="dashboard" class="btn btn-secondary">Back to Dashboard</a>
        </form>
    </div>

</body>
</html>
