<!DOCTYPE html>
<html>
    <head>
        <title>myShop</title>
    </head>
    <body>
        <h1> Hello, its my shop</h1><hr>
        <h4>ապրանքներ ամբողջ Հայաստանից</h4>
        <form action="/" method="get">
            որոնել ըստ ապրանքի անվանման <label>
                <input type="text" name = "name">
            </label>
            <input type="submit" value="որոնում">
        </form>

        <#if products?size == 0>
        <p>ապրանքներ չկա<hr>
        <#else>
        <#list products as product>
    <div>
        <p>${product.name} | <a href="/product/${product.id}">ավելի մանրամասն...</a></p>
    </div>
        </#list><hr>
        </#if>
        <form action="/product/create" method="post" ENCTYPE="multipart/form-data">
            անուն: <label>
                <input type="text" name="name"/>
            </label><br><br>
            նկարագրությունը: <label>
                <input type="text" name="description"/>
            </label><br><br>
            գինը: <label>
                <input type="number" name="price"/>
            </label><br><br>
            քաղաք: <label>
                <input type="text" name="city"/>
            </label><br><br>
            հեղինակ: <label>
                <input type="text" name="author"/>
            </label><br><br>
            առաջին լուսանկարը <label>
                <input type="file" name="file1">
            </label><br><br>
            երկրորդ  լուսանկարը <label>
                <input type="file" name="file2">
            </label><br><br>
            երրորդ լուսանկարը <label>
                <input type="file" name="file3">
            </label><br><br>
            <input type="submit" value="ավելացնել արտադրանքը"/>
        </form>
    </body>
</html>