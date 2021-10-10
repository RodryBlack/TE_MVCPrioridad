     
         
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Prioridad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% ArrayList<Prioridad> lista=(ArrayList<Prioridad>) session.getAttribute("listaprio");

    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Tareas</h1>
        
        <a href="Controlador?op=nuevo">Nuevo</a>
        
        <table border="1">
            <tr>
                <th>Id</th> 
                <th>Tarea</th>
                <th>Prioridad</th>
                <th>Completado</th>
                <th></th>
                <th></th>
                
            </tr>
            <%
                if(lista!=null){
                    for(Prioridad puntero: lista){
                        
                 
            %>
            <tr>
                <td><%=puntero.getId()%></td>
                <td><%=puntero.getTarea()%></td>
                <td><%=puntero.getPrioridad()%></td>
                <td><%=puntero.getCompletado()%></td>
                <td><a href="Controlador?op=editar&id=<%=puntero.getId()%>">Editar</a></td>
                <td><a href="Controlador?op=eliminar&Id=<%=puntero.getId()%>"
                       onclick="return confirm('Esta seguro que desea eliminar');">Eliminar</a></td>
            </tr>
            <%
                   }
                }
            %>
            
        </table>
    </body>
</html>
