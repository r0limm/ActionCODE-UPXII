import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelas {

    public static void criarTUsuarios() {
        String sqlCriarTabelaUsuario = "CREATE TABLE IF NOT EXISTS Usuario ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "nome VARCHAR(100) NOT NULL,"
                + "email VARCHAR(100) NOT NULL,"
                + "senha VARCHAR(100) NOT NULL,"
                + "idade VARCHAR(100) NOT NULL,"
                + "sexo VARCHAR(100) NOT NULL,"
                + "telefone VARCHAR(15),"
                + "endereco VARCHAR(255),"
                + "cpf VARCHAR(11) NOT NULL,"
                + "sus VARCHAR(20) NOT NULL"
                + ")";

        try (Connection conexao = ConexaoBD.obterConexao();
             Statement stmt = conexao.createStatement()) {
            stmt.execute(sqlCriarTabelaUsuario);
            System.out.println("Tabela Usuario criada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        criarTUsuarios();
        criarTMedicos();
        criarTUbs();
        criarTAgendamentos();
        criarTCalendario();
    }
}

