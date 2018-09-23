<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ page session="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Bic's Page</title>

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

<c:if test="${!empty listBics}">
    <table class="table">
        <tr>
            <th width="20">id</th>
            <th width="120">bic</th>
            <th width="120">rc</th>
            <th width="120">nm</th>
            <th width="120">rb</th>
            <th width="120">rn</th>
            <th width="120">intCode</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listBics}" var="bic">
            <tr>
                <td>${bic.id}</td>
                <td><a href="/bicInfo/${bic.id}" target="_blank">${bic.bic}</a></td>
<%--
                <td>${bic.bic}</td>
--%>
                <td>${bic.rc}</td>
                <td>${bic.nm}</td>
                <td>${bic.rb}</td>
                <td>${bic.rn}</td>
                <td>${bic.intCode}</td>
                <td><a href="<c:url value='/edit/${bic.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${bic.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br/>
<h1>Include person to Schindler's List</h1>
<c:url var="addAction" value="/bics/add"/>

<form:form action="${addAction}" commandName="bic">
    <table>

        <c:if test="${!empty bic.id}">
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
            <td colspan="2">
                <c:if test="${!empty bic.id}">
                    <input type="submit"
                           value="<spring:message text="Edit Bic"/>"/>
                </c:if>
                <c:if test="${empty bic.id}">
                    <input type="submit"
                           value="<spring:message text="Add Bic"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
