package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Model.Usuario;

public class LoginDAO {

    public static Usuario fazerLogin(Scanner scanner) {
        System.out.println("Login de usuário");

        System.out.print("Login: ");
        String cpf = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        try (Connection connection = ConexaoBD.obterConexao()) {
            String sql = "SELECT * FROM usuarios WHERE cpf =? AND senha =?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, cpf);
                statement.setString(2, senha);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String nome = resultSet.getString("nome");
                        String email = resultSet.getString("email");
                        String idade = resultSet.getString("idade");
                        String sexo = resultSet.getString("sexo");
                        String endereco = resultSet.getString("endereco");
                        String telefone = resultSet.getString("telefone");
                        String sus = resultSet.getString("sus");
                        
                        Usuario usuario = new Usuario(nome, email, senha, idade, sexo, endereco, telefone, cpf, sus);
                        return usuario;
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
