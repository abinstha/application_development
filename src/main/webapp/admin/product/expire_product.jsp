<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="g"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:admin>
    <div class="container-fluid">
        <h1 style="color: #000; font-weight: 700" class="float-left">Expired Product</h1>
        <a href="${pageContext.request.contextPath}/ProductController?act=create" class="btn btn-primary float-right">New Product</a>
    </div>
        <table id="dataList" class="table table-hover table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Category</th>
                    <th>Product Code</th>
                    <th>Product Name</th>
                    <th>Retail Price</th>
                    <th>Stock</th>
                    <th>Brand Name</th>
                    <th>Manufactured Date</th>
                    <th>Expiry Date</th>
                    <th>Amount (in grams)</th>
                    <th>Description</th>
                    <th>Action(s)</th>
                </tr>
            </thead>
            <tbody>
                <g:forEach items="${allExpiredProducts}" var="pro">
                <tr>
                    <td>${pro.id}</td>
                    <td>${pro.category_id}</td>
                    <td>${pro.product_code}</td>
                    <td>${pro.name}</td>
                    <td>${pro.price}</td>
                    <td>${pro.stock}</td>
                    <td>${pro.brand_name}</td>
                    <td>
                        <g:choose>
                            <g:when test="${pro.weight != 0.0}">
                                ${pro.weight}
                            </g:when>
                            <g:otherwise>
                                --
                            </g:otherwise>
                        </g:choose>
                    </td>
                    <td>
                        <g:choose>
                            <g:when test="${pro.manufacture_date != '0002-11-30'}">
                                ${pro.manufacture_date}
                            </g:when>
                            <g:otherwise>
                                --
                            </g:otherwise>
                        </g:choose>
                    </td>
                    <td>
                        <g:choose>
                            <g:when test="${pro.expire_date != '0002-11-30'}">
                                ${pro.expire_date}
                            </g:when>
                            <g:otherwise>
                                --
                            </g:otherwise>
                        </g:choose>
                    </td>
                    <td>
                        <g:choose>
                            <g:when test="${pro.amount != 0.0}">
                                ${pro.amount}
                            </g:when>
                            <g:otherwise>
                                --
                            </g:otherwise>
                        </g:choose>
                    </td>
                    <td>${pro.description}</td>
                    <td><a href="ProductController?id=${pro.id}&act=delete" class="btn btn-info" ><i class="far fa-trash-alt"></i></a></td>
                </tr>
                
            </g:forEach>
            </tbody>
        </table>
</t:admin>