<%@page import="com.emergentes.modelo.Prioridad"%>
<%
    Prioridad item = (Prioridad)request.getAttribute("miPrioridad");
    %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=(item.getId()==0)?"Nuevo registro":"Editar registro"%></h1>
        
        <form action="Controlador" method="post">
            <input type="hidden" name="id" value="<%=item.getId()%>">
            <label>Tarea</label>
            <select name="tarea">
                <option value="Reunion">Reunion con estudiantes</option>
                <option value="Estudiar">Estudiar para el examen</option>
                <option value="Partido">Partido e futbol</option>
            </select>
            <br><br>
            <label>Prioridad</label>
            <select name="prioridad">
                <option value="Alta">Alta</option>
                <option value="Media">Media</option>
                <option value="Baja">Baja</option>
            </select>
            <br><br>
            <label>Completado</label>
            <select name="completado">
                <option value="concluido">Concluido</option>
                <option value="pendiente">Pendiente</option>
                
            </select>
            <br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
