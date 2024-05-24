package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:mysql://localhost:3306/chc";
    private static final String USUARIO = "root";
    private static final String SENHA = "l#%WbVDFT$j3";
    private static Connection conexao;

    public static Connection obterConexao() {
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            return conexao;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão fechada com sucesso.");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
