<%@ page import="models.Beer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%Beer beer = (Beer) request.getAttribute("item");%>
    <%int count = Beer.Companion.getCount();%>
    <title><%out.print(beer.getName());%></title>
</head>
<body>

<a href="/jee-kotlin/beer">🡀 Back</a>
<h1>
    # <%out.print(beer.getId());%>
    <%out.print(beer.getName());%>
</h1>

<ul>
    <li><b>Name:</b> <%out.print(beer.getName());%></li>
    <li><b>Manufacturer:</b> <%out.print(beer.getManufacturer());%></li>
    <li><b>Price:</b> <%out.print(beer.getPrice());%> chf</li>
    <li><b>Quantity:</b> <%out.print(beer.getQuantity());%></li>
</ul>


<div style="margin-left: 25px">
    <a href="<%out.print(beer.getPrevious());%>">🡀 Previous</a>
    <span style="margin-left: 20px"></span>
    <a href="<%out.print(beer.getNext());%>">Next 🠾</a>
</div>

</body>
</html>
