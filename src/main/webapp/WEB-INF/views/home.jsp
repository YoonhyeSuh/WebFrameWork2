<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>CseInfoSystem</title>
  <style>
    body {
      margin: 0;
      padding: 10px;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      background-color: #f4f4f4;
    }

    .container {
      display: flex;
      align-items: center;
      justify-content: space-between;
      background-color: #0056b3;
      padding: 20px;
      color: #ffffff;
    }

    .title {
      font-size: 24px;
      font-weight: bold;
    }

    .user-actions {
      display: flex;
      align-items: center;
    }

    .user-actions span {
      margin-right: 10px;
    }

    .login-button {
      color: #ffffff;
      background-color: #007bff;
      border: none;
      padding: 8px 16px;
      border-radius: 5px;
      cursor: pointer;
      text-decoration: none;
    }

    .login-button:hover {
      background-color: #0056b3;
    }

    .menu {
      margin-top: 20px;
      padding: 0;
      list-style-type: none;
    }

    .menu-item {
      margin-bottom: 10px;
    }

    .menu-item a {
      color: #0056b3;
      text-decoration: none;
      font-weight: bold;
    }

    .menu-item a:hover {
      color: #007bff;
    }

    .logout-link {
      color: #ffffff;
      text-decoration: none;
      margin-left: 10px;
    }

    .logout-link:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="logo">
    <span class="title">한성대학교 학사 정보 시스템</span>
  </div>
  <div class="user-actions">
    <c:choose>
      <c:when test="${empty pageContext.request.userPrincipal.name}">
        <a href="<c:url value='/login'/>" class="login-button">Login</a>
      </c:when>
      <c:otherwise>
        <span>Welcome, ${pageContext.request.userPrincipal.name}!</span>
        <a href="javascript:document.getElementById('logout').submit()" class="logout-link">Logout</a>
        <form id="logout" action="<c:url value="/logout" />" method="post">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
      </c:otherwise>
    </c:choose>
  </div>
</div>
<ul class="menu">
  <li class="menu-item"><a href="${pageContext.request.contextPath}/showcourseslist">학년별 이수 학점 조회</a></li>
  <li class="menu-item"><a href="${pageContext.request.contextPath}/createcourses">수강 신청하기</a></li>
  <li class="menu-item"><a href="${pageContext.request.contextPath}/showcourses">수강 신청 조회하기</a></li>
</ul>
</body>
</html>
