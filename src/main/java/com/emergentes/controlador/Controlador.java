
package com.emergentes.controlador;

import com.emergentes.modelo.Prioridad;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses =request.getSession();
        
        if(ses.getAttribute("listaprio")==null){
            ArrayList<Prioridad> listaux=new ArrayList<Prioridad>();
            ses.setAttribute("listaprio", listaux);
        }
        
        ArrayList<Prioridad> lista= (ArrayList<Prioridad>) ses.getAttribute("listaprio");
        
        String op=request.getParameter("op");
        String option=(op!=null)? op:"view";
        
        Prioridad obj1=new Prioridad();
        int id=0,pos;
        switch(option){
            case "nuevo":
                request.setAttribute("miPrioridad",obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                
                id=Integer.parseInt(request.getParameter("id"));
                pos=buscarIndice(request,id);
                obj1=lista.get(pos);
                request.setAttribute("miPrioridad", obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
                
            case "eliminar":
                id=Integer.parseInt(request.getParameter("id"));
                pos=buscarIndice(request,id);
                lista.remove(pos);
                ses.setAttribute("listaprio",lista);
                response.sendRedirect("index.jsp");
                break;
                
            case "view":
                response.sendRedirect("index.jsp");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses=request.getSession();
        ArrayList<Prioridad> lista=(ArrayList<Prioridad>)ses.getAttribute("listaprio");
        
       Prioridad obj1=new Prioridad();
       
       obj1.setId(Integer.parseInt(request.getParameter("id")));
       obj1.setTarea(request.getParameter("tarea"));
       obj1.setPrioridad(request.getParameter("prioridad"));
       obj1.setCompletado(request.getParameter("completado"));
       
       int idt=obj1.getId();
       if(idt==0){
           
           int ultId;
           ultId=ultimoId(request);
           obj1.setId(ultId);
           lista.add(obj1);
       }
       else{
           lista.set(buscarIndice(request,idt),obj1);
       }
       ses.setAttribute("listaprio", lista);
       response.sendRedirect("index.jsp");
    }
    private int buscarIndice(HttpServletRequest request, int id){
        HttpSession ses =request.getSession();
        ArrayList<Prioridad> lista=(ArrayList<Prioridad>)ses.getAttribute("listaprio");
        
        int i=0;
        
        if(lista.size()>0){
            while(i<lista.size()){
                if(lista.get(i).getId()==id){
                    break;
                }
                else{
                    i++;
                }
            }
        }
        return i;
    }
    
    private int ultimoId(HttpServletRequest request){
        HttpSession ses =request.getSession();
        ArrayList<Prioridad> lista=(ArrayList<Prioridad>)ses.getAttribute("listaprio");
        
        int idaux=0;
        for(Prioridad item: lista){
            idaux=item.getId();
        }
        return idaux+1;
            
    }

}
