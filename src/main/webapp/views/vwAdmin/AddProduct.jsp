<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:main>
    <jsp:body>
        <form action="" method="post">
            <div class="card">
                <h4 class="card-header">
                    New Product
                </h4>
                <div class="card-body">
                    <div class="form-group">
                        <label for="txtProName">Product</label>
                        <input type="text" class="form-control" id="txtProName" name="ProName" autofocus>
                    </div>
                    <div class="form-group">
                        <label for="intPrice">Price</label>
                        <input type="number" class="form-control" id="intPrice" name="Price" >
                    </div>
                    <div class="form-group">
                        <label for="txtColor">Color</label>
                        <input type="text" class="form-control" id="txtColor" name="Color" >
                    </div>
                    <div class="form-group">
                        <label for="intType">Type</label>
                        <input type="number" class="form-control" id="intType" name="Type" >
                    </div>
                    <div class="form-group">
                        <label for="txtTrademark">Trademark</label>
                        <input type="text" class="form-control" id="txtTrademark" name="Trademark" >
                    </div>
                    <div class="form-group">
                        <label for="intQuantity">Quantity</label>
                        <input type="number" class="form-control" id="intQuantity" name="Quantity" >
                    </div>
                    <div class="form-group">
                        <label for="txtTinyDes">TinyDes</label>
                        <input type="text" class="form-control" id="txtTinyDes" name="TinyDes" >
                    </div>
                    <div class="form-group">
                        <label for="txtFullDes">FullDes</label>
                        <input type="text" class="form-control" id="txtFullDes" name="FullDes" >
                    </div>
                </div>
                <div class="card-footer">
                    <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/Admin/Product/" role="button">
                        <i class="fa fa-backward" aria-hidden="true"></i>
                        List
                    </a>
                    <button type="submit" class="btn btn-primary">
                        <i class="fa fa-check" aria-hidden="true"></i>
                        Save
                    </button>
                </div>
            </div>
        </form>
    </jsp:body>
</t:main>