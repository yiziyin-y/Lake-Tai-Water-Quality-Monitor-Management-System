<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>${message}</h2>

<c:forEach items="${images}" var="image">
    tu
<input type="image" src="${image.imagePath}" alt="">
</c:forEach>
111
</body>
</html>