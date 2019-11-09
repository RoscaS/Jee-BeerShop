<%@ page import="models.Beer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%String title = (String) request.getAttribute("title");%>
    <%List<Beer> beers = (List<Beer>) request.getAttribute("items");%>
    <title><%out.print(title);%></title>
</head>
<body>

<a href="/jee-kotlin">🡀 Back</a>
<h1><%out.print(title);%></h1>

<ul>
    <%for (Beer beer : beers) {%>
    <li>
        <a href="beer/<%out.print(beer.getId());%>">
            <%out.print(beer.getName());%>
        </a>
    </li>
    <%}%>
</ul>

</body>
</html>
