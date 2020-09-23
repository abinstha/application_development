<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:admin>
    <h1 style="color:green">${msg!=null?msg:""}</h1>
    <form class="" method="post" action="${pageContext.request.contextPath}/CategoryController">
        <div class="form-group">
            <label for="product_category">Category Name</label>
            <input type="text" class="form-control" name="category" id="product_category" value="${category.category}">
        </div>
        <div class="form-group">
            <label form="category_description">Description</label>
            <textarea class="form-control" name="description" id="description">${category.description}</textarea>
        </div>
        <input type="hidden" name="act" value="update">
        <input type="hidden" name="id" value="${category.id}">
        <button type="submit" class="btn btn-primary">
            Update
        </button>
    </form>
</t:admin>