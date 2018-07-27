<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Persons Page</title>

    <style type="text/css">
        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            font-size: 14px;
            border-radius: 10px;
            border-spacing: 0;
            text-align: center;
        }
        th {
            background: #BCEBDD;
            color: white;
            text-shadow: 0 1px 1px #2D2020;
            padding: 10px 20px;
        }
        th, td {
            border-style: solid;
            border-width: 0 1px 1px 0;
            border-color: white;
        }
        th:first-child, td:first-child {
            text-align: left;
        }
        th:first-child {
            border-top-left-radius: 10px;
        }
        th:last-child {
            border-top-right-radius: 10px;
            border-right: none;
        }
        td {
            padding: 10px 20px;
            background: #F8E391;
        }
        tr:last-child td:first-child {
            border-radius: 0 0 0 10px;
        }
        tr:last-child td:last-child {
            border-radius: 0 0 10px 0;
        }
        tr td:last-child {
            border-right: none;
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Schindler's List</h1>

<c:if test="${!empty listPersons}">
    <table class="table">
        <tr>
            <th width="80">ID</th>
            <th width="120">First_name</th>
            <th width="120">Second_name</th>
            <th width="120">Birthday</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPersons}" var="person">
            <tr>
                <td>${person.id}</td>
                <td><a href="/personInfo/${person.id}" target="_blank">${person.firstName}</a></td>
                <td>${person.lastName}</td>
                <td>${person.birthday}</td>
                <td><a href="<c:url value='/edit/${person.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${person.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br/>
<h1>Include person to Schindler's List</h1>

<c:url var="addAction" value="/persons/add"/>

<form:form action="${addAction}" commandName="person">
    <table>

        <c:if test="${!empty person.firstName}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message text="FirstName"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="lastName">
                    <spring:message text="LastName"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="birthday">
                    <spring:message text="Birthday"/>
                </form:label>
            </td>
            <td>
                <form:input path="birthday"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty person.firstName}">
                    <input type="submit"
                           value="<spring:message text="Edit Person"/>"/>
                </c:if>
                <c:if test="${empty person.firstName}">
                    <input type="submit"
                           value="<spring:message text="Add Person"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
