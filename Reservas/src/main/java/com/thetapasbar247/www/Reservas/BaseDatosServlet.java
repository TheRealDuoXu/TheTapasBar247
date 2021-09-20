package com.thetapasbar247.www.Reservas;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="BaseDatos", urlPatterns={"/servlet/BaseDatos"})
public class BaseDatosServlet extends HttpServlet{

	/**
	 * Mediador entre la base de datos y persistencia
	 */
	private static final long serialVersionUID = 5187541661872976422L;
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	//we will use the response to confirm the reservation and display the data 
    	response.setContentType("text/html;charset=UTF-8");
        PrintWriter output = response.getWriter();
        
        //Get all parameter names, and prepare to persist to txt
        Enumeration<String> headers = request.getParameterNames();
        //leave a txt for debug
        Iterator<String> ite = headers.asIterator();
    	StringBuilder buffer = new StringBuilder();
        while(ite.hasNext()) {
        	buffer.append(request.getParameter(ite.next()+"\n"));
        }
        try(FileWriter fout = new FileWriter("reserva"+Math.random()+".txt")){
        	fout.append(buffer);
        }catch(IOException e) {
        	e.printStackTrace();
        }
        
        //create entity, persist to JPA
        PersistenceManager pm = new PersistenceManager();
        String[] param = new String[7];
        
        //atencion aqui, actualizar formulrio requiere actualizar este codigo
        	param[0]=request.getParameter("fname");
        	param[1]=request.getParameter("lname");
        	param[2]=request.getParameter("email");
        	param[3]=request.getParameter("phone");
        	param[4]=request.getParameter("bdate");
        	param[5]=request.getParameter("btime");
        	param[6]=request.getParameter("comensales");
        	param[7]=request.getParameter("extras");
        	
        	Date date;
			try {
				date = new SimpleDateFormat("MM/dd/yyyy").parse(param[4]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				date = null;
			}
        	String fullname = param[0]+" "+param[1];
        	pm.doPersist(fullname, param[2], Integer.parseInt(param[3]),date, param[5],
        			Integer.parseInt(param[6]),param[7]);
        	
        	output.println(fullname+ param[2]+ Integer.parseInt(param[3])+date+ param[5]+
        			Integer.parseInt(param[6])+param[7]);
        	
    }
}