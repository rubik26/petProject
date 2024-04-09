<!DOCTYPE html>
<html>
<head>
    <title>myShop</title>
    <meta charset=»UTF-8″>
</head>
<body>
<h1> Hello, its my shop</h1><hr>
<h4>մանրամասն տեղեկություններ ապրանքի մասին</h4>
<b>ապրանքային անուն: </b>${product.name}<br>
<b>նկարագրությունը: </b>${product.description}<br>
<b>գինը: </b>${product.price}<br>
<b>քաղաք: </b>${product.city}<br>
<b>հեղինակ: </b>${product.author}<br>
<#list images as img>
    <img src="/images/${img.getId()}"><br><br>
</#list>
<img src="/images/${product.imageList.get(0)}" height="240px"><br><br>


<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="ջնջել">
</form><br>

</body>
</html>