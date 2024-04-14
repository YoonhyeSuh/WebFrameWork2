<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>학년별 이수 학점 조회</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>

<body>
<h2>수강 신청 내역</h2>
<table>
    <thead>
    <tr>
        <th>수강년도</th>
        <th>학기</th>
        <th>교과목코드</th>
        <th>교과목명</th>
        <th>교과구분</th>
        <th>담당교수</th>
        <th>학점</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="courses" items="${courses20211}">
        <tr>
            <td>${courses.year}</td>
            <td>${courses.semester}</td>
            <td>${courses.courseId}</td>
            <td>${courses.courseName}</td>
            <td>${courses.classification}</td>
            <td>${courses.professor}</td>
            <td>${courses.credit}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="${pageContext.request.contextPath}/showcourseslist">이전</a></p>
</body>
</html>
