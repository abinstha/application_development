<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="g"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:admin>
    <form class="category-form" action="${pageContext.request.contextPath}/ProductController" method="post">
        <div class="form-group">
            <label for="category_id">Category</label>
            <select class="form-control product-category" id="category_id" name="category_id">
                <option>Select a category...</option>
                <g:forEach items="${allCategoriesList}" var="cat">   

                    <script>console.log(${cat.id})</script>
                    <option value="${cat.id}">${cat.category}</option>
                </g:forEach>
                
            </select>
        </div>
        <div class="form-group">
            <label for="product_code">Product Code</label>
            <input type="text" name="product_code" class="form-control" id="product_code">
        </div>
        <div class="form-group">
            <label for="product_name">Product Name</label>
            <input type="text" class="form-control" name="product_name" id="product_name">
        </div>
        <div class="form-group">
            <label for="price">Retail Price</label>
            <input type="number" class="form-control" name="price" id="price">
        </div>
        <div class="form-group">
            <label for="stock">Stock</label>
            <input type="number" class="form-control" name="stock" id="stock">
        </div>
        <div class="form-group">
            <label for="brand_name">Brand Name</label>
            <input type="text" class="form-control" name="brand_name" id="brand_name">
        </div>
        <div class="cloth hidden">
            <div class="form-group">
                <label for="size">Size</label>
                <select class="form-control" name="size">
                    <option value="XS">XS</option>
                    <option value="S">S</option>
                    <option value="M">M</option>
                    <option value="L">L</option>
                    <option value="XL">XL</option>
                    <option value="XXL">XXL</option>
                </select>
            </div>
            <div class="form-group">
                <label for="gender">Gender</label>
                <select class="form-control" name="gender">
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                    <option value="other">Other</option>
                </select>
            </div>
        </div>
        <div class="fitness hidden">
            <div class="form-group">
                <label for="weight">Weight</label>
                <input type="number" class="form-control" name="weight" id="weight" value="0">
            </div>
        </div>
        <div class="protein hidden">
            <div class="form-group">
                <label for="m_date">Manufactured Date</label>
                <input type="text" class="form-control" name="m_date" id="m_date" value="0000-00-00">
            </div>
            <div class="form-group">
                <label for="e_date">Expiry Date</label>
                <input type="text" class="form-control" name="e_date" id="e_date" value="0000-00-00">
            </div>
            <div class="form-group">
                <label for="amount">Amount(in grams)</label>
                <input type="number" class="form-control" name="amount" id="amount" value="0">
            </div>
        </div>
        <div class="form-group">
            <label for="description">Product Description</label>
            <textarea class="form-control" name="description" id="description"></textarea>
        </div>
        <input type="hidden" name="act" value="add">
        <button type="submit" class="btn btn-primary">
            Create
        </button>
    </form>
</t:admin>