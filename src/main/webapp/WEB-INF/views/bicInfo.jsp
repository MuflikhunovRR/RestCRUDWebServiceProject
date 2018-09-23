<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>PersonInfo</title>

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
<a href="../../bics">Back to main menu</a>
<h1>Schindler's List info</h1>

<table class="table">
    <tr>
        <th width="20">id</th>
        <th width="120">bic</th>
        <th width="120">rc</th>
        <th width="120">nm</th>
        <th width="120">rb</th>
        <th width="120">rn</th>
        <th width="120">intCode</th>
    </tr>
    <tr>
        <td>${bic.id}</td>
        <td>${bic.bic}</td>
        <td>${bic.rc}</td>
        <td>${bic.nm}</td>
        <td>${bic.rb}</td>
        <td>${bic.rn}</td>
        <td>${bic.intCode}</td>
    </tr>
</table>
</body>
</html>