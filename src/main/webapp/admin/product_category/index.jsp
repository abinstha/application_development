<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="g"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:admin>
    <div class="container-fluid">
        <h1 style="color:green">${msg!=null?msg:""}</h1>
        <h1 style="color: #000; font-weight: 700" class="float-left">Categories</h1>
        <a href="${pageContext.request.contextPath}/admin/product_category/create.jsp" class="btn btn-primary float-right">New Category</a>
    </div>
    
    
    <table id="dataList" class="table table-hover table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Category</th>
                <th>Description</th>
                <th>Created At</th>
                <th colspan="2">Action(s)</th>
            </tr>
        </thead>
        <tbody>
                <g:forEach items="${allCategoriesList}" var="cat">
                    <tr> 
                        <td>${cat.id}</td>
                        <td>${cat.category}</td>
                        <td>${cat.description}</td>
                        <td>${cat.created_at}</td>
                        <td><a href="CategoryController?id=${cat.id}&act=edit" class="btn btn-danger"><i class="far fa-edit"></i></a></td>
                        <td><a href="CategoryController?id=${cat.id}&act=delete" class="btn btn-info" ><i class="far fa-trash-alt"></i></a></td>
                    </tr>
                </g:forEach>
        </tbody>
    </table>
</t:admin>