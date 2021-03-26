<%--
  Created by IntelliJ IDEA.
  User: Tharindu
  Date: 3/25/2021
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Progress and estimate</title>
</head>
<body>
<p>Sid : <%=session.getAttribute("sid")%></p>
         <form method="post" action="<%=request.getContextPath()%>/CreateWorkProgressServlet">
                <input type="hidden" name="sid" value="<%=session.getAttribute("sid")%>">
                <button type="submit">Create new Progress</button>
         </form>
</body>
</html>
