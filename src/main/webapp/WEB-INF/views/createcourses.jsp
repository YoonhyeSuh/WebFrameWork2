<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>수강 신청하기</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/createcourses.css" >
</head>
<body>
<H2>수강 신청하기</H2>
<sf:form method="post" action="${pageContext.request.contextPath}/coursescreated" modelAttribute="courses">
    <table class="formtable">
        <tr>
            <td class="label"> Year:</td>
            <td><sf:input class="control" type="text" path="year"/>  <br/>
                <sf:errors path="year" class="error"/>
            </td>
        </tr>
        <tr>
            <td class="label"> Semester:</td>
            <td><sf:input class="control" type="text" path="semester"/> <br/>
                <sf:errors path="semester" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> CourseId:</td>
            <td><sf:input class="control" type="text" path="courseId"/> <br/>
                <sf:errors path="courseId" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> CourseName:</td>
            <td><sf:input class="control" type="text" path="courseName"/> <br/>
                <sf:errors path="courseName" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> Classification:</td>
            <td><sf:input class="control" type="text" path="classification"/> <br/>
                <sf:errors path="classification" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> Professor:</td>
            <td><sf:input class="control" type="text" path="professor"/> <br/>
                <sf:errors path="professor" class="error" />
            </td>
        </tr>
        <tr>
            <td class="label"> Credit:</td>
            <td><sf:input class="control" type="text" path="Credit"/> <br/>
                <sf:errors path="Credit" class="error" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="submit"/> </td>
        </tr>
    </table>
</sf:form>
<p><a href="${pageContext.request.contextPath}/">Home</a></p>
</body>
</html>
