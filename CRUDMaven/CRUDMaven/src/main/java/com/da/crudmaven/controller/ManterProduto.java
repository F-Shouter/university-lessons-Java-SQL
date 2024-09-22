/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.da.crudmaven.controller;

import com.da.crudmaven.dao.ProdutoDAO;
import com.da.crudmaven.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author proft
 */
@WebServlet(name = "ManterProduto", urlPatterns = {"/ManterProduto"})
public class ManterProduto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String op = request.getParameter("op");
            String resultado = "";

            if (op.equals("CADASTRAR")) {
                String descricao = request.getParameter("txtdescricao");
                double preco = Double.parseDouble(request.getParameter("txtpreco"));

                ProdutoDAO pdao = new ProdutoDAO();
                Produto p = new Produto();
                p.setDescricao(descricao);
                p.setPreco(preco);
                try {
                    pdao.cadastrar(p);
                    resultado = "Cadastrado com muito Sucesso.";                    
                    request.setAttribute("msg", resultado);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                    resultado = "Erro ao cadastrar.";
                }
                //request.getRequestDispatcher("sucesso.jsp").forward(request, response);
            } else if (op.equals("DELETAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                ProdutoDAO pdao = new ProdutoDAO();
                Produto p = new Produto();
                p.setId(id);
                try {
                    pdao.deletar(p);
                    List<Produto> lprod = pdao.consultarTodos();
                    request.setAttribute("lprod", lprod);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);

                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                    resultado = "Erro ao deletar.";
                }
                request.getRequestDispatcher("sucesso.jsp").forward(request, response);
            } else if (op.equals("CONSULTARBYID")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                ProdutoDAO pdao = new ProdutoDAO();
                Produto p = new Produto();
                p.setId(id);
                try {
                    p = pdao.consultarById(p);
                    request.setAttribute("produto", p);
                    request.getRequestDispatcher("resultadoconsultarbyid.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                    resultado = "Erro ao consultar por ID.";
                }
            } else if (op.equals("CONSULTARTODOS")) {

                ProdutoDAO pdao = new ProdutoDAO();
                try {
                    List<Produto> lprod = pdao.consultarTodos();
                    request.setAttribute("lprod", lprod);
                    request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                    resultado = "Erro ao consultat todos.";
                }
            }  else if (op.equals("ATUALIZAR")) {
                String descricao = request.getParameter("txtdescricao");
                double preco = Double.parseDouble(request.getParameter("txtpreco"));
                int id = Integer.parseInt(request.getParameter("txtid"));
                
                ProdutoDAO pdao = new ProdutoDAO();
                Produto p = new Produto();
                p.setId(id);
                p.setDescricao(descricao);
                p.setPreco(preco);
                try{
                   pdao.atualizar(p);
                   resultado = "Atualizado com Sucesso.";
                   request.setAttribute("msg", resultado);
                } catch (ClassNotFoundException | SQLException ex){
                    System.out.println("ERRO: " + ex.getMessage());
                }
                request.getRequestDispatcher("sucesso.jsp").forward(request, response);
            } else if (op.equals("EDITAR")) {
                int id = Integer.parseInt(request.getParameter("txtid"));
                ProdutoDAO pdao = new ProdutoDAO();
                Produto p = new Produto();
                p.setId(id);
                try {
                    p = pdao.consultarById(p);
                    request.setAttribute("produto", p);
                    request.getRequestDispatcher("formularioeditar.jsp").forward(request, response);
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro: " + ex.getMessage());
                    resultado = "Erro ao editar.";
                }
            } 

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
