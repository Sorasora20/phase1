<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <title>1000回叩いたら割れる卵</title>
        <link rel="stylesheet" href="style.css">
    </head>

    <body>
        <h1>クリックしてね</h1>

        <form action="/egg/click" method="post">
            <div class="count">
                <% Integer count=(Integer) session.getAttribute("count"); %>
                <% if (count == null) count = 0; %>
                <% session.setAttribute("count", count); %>
                <%= count %>
            </div>
            <br>
            <% String lv = (String) session.getAttribute("lv"); %>
            <% if (lv == null) lv = "lv1"; %>
            <% session.setAttribute("lv", lv); %>
            <% String path = "./" + lv + ".png"; %>
            <a href = "/egg/click" class="egg">
                <img src="<%= path %>" width="100">
            </a>
        </form>
    </body>

    </html>