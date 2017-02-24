<%--
  Created by IntelliJ IDEA.
  User: VinDiesel
  Date: 2017/2/9
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <h1>登录</h1>
      <table>
        <form method="get" action="/tc/user/login">
          <input type="text" name="username" value=""><br>
          <input type="password" name="password" value=""><br>
          <input type="submit" value="登录">
        </form>
      </table>
      <form method="post" action="/tc/user/image" enctype="multipart/form-data">
        <input type="file" name="img" value=""><br>
        <input type="submit" value="上传">
      </form>
  <hr/>
      <h1>注册</h1>
      <table>
          <form method="post" action="/tc/user/register">
              <input type="text" name="username" value=""><br>
              <input type="password" name="password" value=""><br>
              <input type="submit" value="注册">
          </form>
      </table>
   <c:forEach items="${list}" var="item">
       ${item.username}--${item.id}
   </c:forEach>
  </body>
</html>
