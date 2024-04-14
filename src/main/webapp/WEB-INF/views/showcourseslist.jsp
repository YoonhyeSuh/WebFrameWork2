<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
<h2>학년별 이수 학점 조회</h2>
<table>
    <thead>
    <tr>
        <th>년도</th>
        <th>학기</th>
        <th>취득학점</th>
        <th>상세보기</th>
    </tr>
    </thead>
    <tbody>
        <tr>
        <tr><td>2021</td><td>1</td><td>${creditSum20211}</td><td><a href = "${pageContext.request.contextPath}/detail20211">클릭</a></td>
        <tr><td>2021</td><td>2</td><td>${creditSum20212}</td><td><a href = "${pageContext.request.contextPath}/detail20212">클릭</a></td>
        <tr><td>2022</td><td>1</td><td>${creditSum20221}</td><td><a href = "${pageContext.request.contextPath}/detail20221">클릭</a></td>
        <tr><td>2022</td><td>2</td><td>${creditSum20222}</td><td><a href = "${pageContext.request.contextPath}/detail20222">클릭</a></td>
        <tr><td>2023</td><td>1</td><td>${creditSum20231}</td><td><a href = "${pageContext.request.contextPath}/detail20231">클릭</a></td>
        <tr><td>2023</td><td>2</td><td>${creditSum20232}</td><td><a href = "${pageContext.request.contextPath}/detail20232">클릭</a></td>
        <tr><td>2024</td><td>1</td><td>${creditSum20241}</td><td><a href = "${pageContext.request.contextPath}/detail20241">클릭</a></td>
        </tr>
    </tbody>
    <tfoot>
    <tr><td>총계</td><td> </td><td>${creditTotalSum}</td><td> </td></tr>
    </tfoot>
</table>
<p><a href="${pageContext.request.contextPath}/">Home</a></p>
</body>
</html>
