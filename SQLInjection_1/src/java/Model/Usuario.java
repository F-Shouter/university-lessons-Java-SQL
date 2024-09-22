/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.FabricaConexao;

/**
 *
 * @author proft
 */
public class Usuario {

    private int id;
    private String nome;
    private String login;
    private String senha;
    private String nivelacesso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelacesso() {
        return nivelacesso;
    }

    public void setNivelacesso(String nivelacesso) {
        this.nivelacesso = nivelacesso;
    }

    public boolean autenticar() throws ClassNotFoundException, SQLException {
        boolean aux = false;

        //Carregar Driver  e criar conexao
        Connection con = FabricaConexao.getConexao();

        //contruir string sql bem formada e vinculada com a conexao
        //String sql = "select id, nome, login, senha, nivelacesso "
          //      + "   from tb_usuario "
            //    + "   where login = '" + login + "' and senha = '" + senha + "'";
        

        //System.out.println("SQL:" + sql);
        
        //Statement comando = con.createStatement();

        String sql = "select id, nome, login, senha, nivelacesso "
                + "   from tb_usuario "
                + "   where login = ? and senha = ?";
        
        PreparedStatement comando = con.prepareStatement(sql);
        comando.setString(1, login);
        comando.setString(2, senha);
        
        //executar e tratar resultados
        ResultSet resultado = comando.executeQuery(sql);
        if (resultado.next()) {
            setId(resultado.getInt("id"));
            setNome(resultado.getString("nome"));
            setLogin(resultado.getString("login"));
            setSenha(resultado.getString("senha"));
            setNivelacesso(resultado.getString("nivelacesso"));
            aux = true;
        }

        //Fecha conexao
        con.close();

        return aux;
    }

}
