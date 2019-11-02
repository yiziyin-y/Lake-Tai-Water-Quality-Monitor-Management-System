<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>TestCluster</title>
</head>
<body>
Server Info:
<%
    String dtm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
    System.out.println("["+request.getLocalAddr()+":"+ request.getLocalPort()+"]" + dtm);
    out.println("<br>["+request.getLocalAddr()+":" +request.getLocalPort()+"]" + dtm+"<br>");
%>
Session Info:
<%
    session.setAttribute("name","dennisit");
    System.out.println("[Session Info] Session ID:"+session.getId());
    out.println("<br>[Session Info] Session ID:" + session.getId()+"<br>");
%>
</body>
</html>
