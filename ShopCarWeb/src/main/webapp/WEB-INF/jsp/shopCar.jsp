<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<table>
    <tr>
        <td>序号</td>
        <td>书名</td>
        <td>单价</td>
        <td>数量</td>
        <td>小计</td>
    </tr>

    <c:forEach items="${pairList}" var="pair" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${pair.key.bkName}</td>
            <td>${pair.key.bkPrice}</td>
            <td>${pair.value}</td>
            <td>${pair.key.bkPrice * pair.value}</td>
            <c:set var="sum" value="${pair.key.bkPrice * pair.value+sum}"/>
        </tr>
    </c:forEach>
    <tr>
        <td align="right" colspan="5">总计￥${sum}</td>
    </tr>
</table>
</body>
</html>