<%--
  Created by IntelliJ IDEA.
  User: Tharindu
  Date: 3/23/2021
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Work progress</title>
</head>
<body>
     <form method="post" action="<%=request.getContextPath()%>/WorkProgressServlet">
         <p1>Sid :<%=session.getAttribute("sid")%></p1>
         <input type="hidden" name="sid" value="<%=session.getAttribute("sid")%>">
         <button type="submit">Create Service</button>
     </form>

</body>
</html>
