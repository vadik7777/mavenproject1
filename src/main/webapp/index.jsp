<%-- 
    Document   : index
    Created on : 21.02.2018, 5:50:57
    Author     : Вадик
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta charset="utf-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="jquery.min.js"></script>
        <script type="text/javascript" src="ajaxpost.js"></script>
    </head>
    <body>
        <h1>Найти человека</h1>
        <form>
            <div>Фамилия</div> 
            <input id="family" type="text">
            <div>Имя</div> 
            <input id="name" type="text">
            <div>Отчество</div> 
            <input id="lastname" type="text">
            <div>Город проживания</div> 
            <input id="city" type="text">
            <div>Марка автомобиля</div> 
            <input id="marka" type="text">
            <div>Модель автомобиля</div> 
            <input id="model" type="text">
            <div>Гос. номер автомобиля</div> 
            <input id="nomer" type="text">
            <br/>
            <br/>
            <input onclick="send();" value="Найти" type="button"/>
        </form>
        <br/>
        <div id="response"/>
    </body>
</html>
