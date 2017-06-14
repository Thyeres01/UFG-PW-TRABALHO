package controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FuncionarioDAO;
import model.Funcionario;

@WebServlet(name="ServletBuscaFuncionario", urlPatterns = "/buscafuncionario")
public class ServletBuscaFuncionario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	private Funcionario funcionario = new Funcionario();
	private int idfuncionario;
	private String destino = "";
	private String acao;
	private String message;

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
			acao = request.getParameter("acao");	
			if(acao!=null){
				if(acao.equalsIgnoreCase("Consultar")){
					consultareditarfuncionario(request, response);
					RequestDispatcher rd = request.getRequestDispatcher(destino);
				    rd.forward(request, response); 
				}		
			}					
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {	

			buscarfuncionario(request, response);
		
		
	}
	protected void buscarfuncionario(HttpServletRequest request,
		    HttpServletResponse response) throws ServletException, IOException {

			String textopesquisa1 = request.getParameter("txtpesquisa1");
			String textopesquisa2 = request.getParameter("txtpesquisa2");		
			String textopesquisa3 = request.getParameter("txtpesquisa3");		
			
	        if((textopesquisa1!="" && textopesquisa1!=null)  || (textopesquisa2!="" && textopesquisa2!=null) ||(textopesquisa3!="" && textopesquisa3!=null)){
		   	 
	        	List<Funcionario> listafuncionario = new ArrayList<Funcionario>();    		
	        	listafuncionario = funcionarioDAO.listar(textopesquisa1, textopesquisa2, textopesquisa3);
				request.setAttribute("listafuncionario", listafuncionario);
				
				RequestDispatcher rd = request.getRequestDispatcher("/c_funcionario.jsp");
		 	     rd.forward(request, response);
		     }else{
		    	 message = "Informa um parametro para pesquisa";				
			   	 request.setAttribute("message", message);
			   	 destino = "/c_funcionario.jsp";
		    	 RequestDispatcher rd = request.getRequestDispatcher(destino);
		     	 rd.forward(request, response);
		     }	 
	}  
	 protected void consultareditarfuncionario(HttpServletRequest request,
	 		    HttpServletResponse response) throws ServletException, IOException {
			 
			 	idfuncionario = Integer.parseInt(request.getParameter("idfuncionario")); 			
				funcionario.setIdfuncionario(idfuncionario);			
				request.setAttribute("funcionario", funcionario);
				funcionario = funcionarioDAO.consultar_editar(funcionario);		
				destino = "/funcionario.jsp";	
		}
}