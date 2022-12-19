<%@ page import="kz.bitlab.model.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="constants.jsp"%>
<html>
    <head>
        <%@include file="head.jsp"%>
    </head>
    <body>
        <%@include file="navbar.jsp"%>
        <div class="container mt-3" style="min-height: 800px;">
            <h1 class="text-center my-5">Welcome to <%=siteName%></h1>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>ID </th>
                        <th>NAME </th>
                        <th>COUNTRY </th>
                        <th>PRICE </th>
                        <th>AMOUNT </th>
                        <th width="10%">DETAILS </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("tovary");
                        if(items!=null){
                            for(Item item : items){
                    %>
                        <tr>
                            <td>
                                <%=item.getId()%>
                            </td>
                            <td>
                                <%=item.getName()%>
                            </td>
                            <td>
                                <%=item.getCountry().getName() + " / " + item.getCountry().getCode()%>
                            </td>
                            <td>
                                <%=item.getPrice()%> KZT
                            </td>
                            <td>
                                <%=item.getAmount()%>
                            </td>
                            <td>
                                <a href="/details?id=<%=item.getId()%>" class="btn btn-success btn-sm">DETAILS</a>
                            </td>
                        </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>
