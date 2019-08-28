<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        function toAddShopCar(_id){
            var _data = "bkId=" + _id;
            $.ajax({
                type:'post',
                url:'/shopCar/addShopCar',
                data:_data,
                success:function(msg){
                    alert(msg);
                }
            });
        }
        function toViewShopCar(){
            location.href="/shopCar/showShopCar?"+Math.random();
        }
    </script>
</head>
<body>
<input type="button" value="查看购物车" onclick="toViewShopCar()">
<table>
    <tr>
        <td>序号</td>
        <td>书名</td>
        <td>单价</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${bookList}" var="book" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${book.bkName}</td>
            <td>${book.bkPrice}</td>
            <td><input type="button" value="加入购物车" onclick="toAddShopCar('${book.bkId}')"/> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>