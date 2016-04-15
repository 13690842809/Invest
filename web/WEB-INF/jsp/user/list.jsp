<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2016/4/15
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>user_list</title>
</head>
<body>
    <s:iterator value="userList">
        ${id}---->${userName}<br/>
    </s:iterator>
</body>
</html>
