<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.model.*" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 11/29/22
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="bootstrapstyle.jsp"%>

</head>
<body>
<%
    User user=(User) request.getSession().getAttribute("currentUser");
%>
<%@include file="navbar2.jsp"%>
<%@include file="header.jsp"%>


<div class="container mt-3">
    <% ShopItem item=(ShopItem) request.getAttribute("shopik");
        if(item!=null){
    %>
    <form action="/shopsaveitem" method="post">
        <input type="hidden" value="<%=item.getId()%>" name="id">
    <table class="table" style="width:40%;">
        <tbody>
        <tr>
            <td>
                <img src="<%=item.getUrl()%>" style="width: 200px;height: 200px;">
            </td>
            <td>
                <input type="text" placeholder="insert url" name="item_url" value="<%=item.getUrl()%>">
            </td>
        </tr>
        <tr>
            <td> NAME : </td>
            <td><input type="text" placeholder="Insert name" name="item_name" value="<%=item.getName()%>"></td>
        </tr>
        <tr>
            <td> DESCRIPTION : </td>
            <td><input type="text" placeholder="Insert description" name="item_description" value="<%=item.getDescription()%>"></td>
        </tr>
        <tr>
            <td>Type : </td>
            <td>

                    <select name="item_type" class="form-select">
                        <%
                            ArrayList<Type> types=(ArrayList<Type>) request.getAttribute("tipki");
                            if(types!=null){
                                for(Type t:types){
                        %>
                        <option value="<%=t.getId()%>" <%=(item.getType().getId()==t.getId()?"selected":"")%>>
                            <%=t.getName()%>
                        </option>
                        <%
                                }
                            }
                        %>
                    </select>
            </td>
        </tr>
        <tr>
            <td>New Price : </td>
            <td><input type="number" placeholder="Insert new price" name="item_new_price" value="<%=item.getNewprice()%>"></td>
        </tr>
        <tr>
            <td>Old Price : </td>
            <td><input type="number" placeholder="Insert old price" name="item_old_price" value="<%=item.getOldprice()%>"></td>
        </tr>
        <tr>
            <td>OnSale</td>
            <td>
                <select name="item_on_sale">
                    <option value="true" <%=item.isOnSale()?"selected":""%>> true</option>
                    <option value="false" <%=!item.isOnSale()?"selected":""%>>false</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Popular :</td>
            <td>
                <select name="item_popular">
                    <option value="true" <%=item.isPopular()?"selected":""%>>true</option>
                    <option value="false" <%=!item.isPopular()?"selected":""%>>false</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Amount : </td>
            <td><input type="number" placeholder="Insert amount" name="item_amount" value="<%=item.getAmount()%>"></td>
        </tr>
        </tbody>
    </table>
        <button type="submit" class="btn btn-success btn-sm"> SAVE ITEM</button>
        <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#deleteModal">
            DELETE ITEM
        </button>
    </form>
</div>

    <!-- Button trigger modal -->


    <!-- Modal -->
    <div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/shopdeleteitem" method="post">
                    <input type="hidden" name="id" value="<%=item.getId()%>">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">Confirm Delete</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Are you sure?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                    <button type="submit" class="btn btn-primary">Yes</button>
                </div>
                </form>
            </div>
        </div>
    </div>

    <%}
        else{
            %>
                <h1 class="text-center">404 ITEM NOT FOUND!</h1>
            <%
        }
        %>


</body>
</html>
