import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        /*Produto p = new Produto();
        p.setDescricao("SSD");
        p.setPreco(350);
        ProdutoDAO pdao = new ProdutoDAO();
        try {
        pdao.cadastrar(p);
        System.out.println("Cadastrado com Sucesso");
        } catch (ClassNotFoundException ex) {
        System.out.println("Erro ClassNotFound: " + ex.getMessage());
        } catch (SQLException ex) {
        System.out.println("Erro SQL: " + ex.getMessage());
        }*/

        Produto p = new Produto();
        p.setId(2);
        ProdutoDAO pdao = new ProdutoDAO();
        try {
        pdao.deletarById(p);
        System.out.println("Deletado com Sucesso");
        } catch (ClassNotFoundException ex) {
        System.out.println("Erro ClassNotFound: " + ex.getMessage());
        } catch (SQLException ex) {
        System.out.println("Erro SQL: " + ex.getMessage());
        }
    }
}

