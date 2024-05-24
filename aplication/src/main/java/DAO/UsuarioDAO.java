package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import Model.Usuario;


public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void adicionarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuarios (nome, email, senha, idade, sexo, endereco, telefone, cpf, sus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getIdade());
            stmt.setString(5, usuario.getSexo());
            stmt.setString(6, usuario.getEndereco());
            stmt.setString(7, usuario.getTelefone());
            stmt.setString(8, usuario.getCpf());
            stmt.setString(9, usuario.getSus());
            stmt.executeUpdate();
        }
    }
    
    public static void cadastrarUsuario(Scanner scanner) {
        System.out.println("Cadastro usuário");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Idade: ");
        String idade = scanner.nextLine();

        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Cpf: ");
        String cpf = scanner.nextLine();

        System.out.print("Cartão do SUS: ");
        String sus = scanner.nextLine();

        Usuario usuario = new Usuario(nome, email, senha, idade, sexo, telefone, endereco, cpf, sus);

        try (Connection connection = ConexaoBD.obterConexao()) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
            usuarioDAO.adicionarUsuario(usuario);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Usuario buscarUsuarioPorId(int id) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("idade"), 
                        rs.getString("sexo"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("cpf"),
                        rs.getString("sus")
                    );
                }
            }
        }
        return null;
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("idade"), 
                    rs.getString("sexo"),
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getString("cpf"),
                    rs.getString("sus")
                );
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    public void atualizarUsuario(Usuario usuario) throws SQLException {
        // Verificar se o usuário existe
        if (!usuarioExiste(usuario.getId())) {
            System.out.println("Usuário com ID " + usuario.getId() + " não encontrado.");
            return;
        }

        String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ?, idade = ?, sexo = ?, endereco = ?, telefone = ?, cpf = ?, sus = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getIdade());
            stmt.setString(5, usuario.getSexo());
            stmt.setString(6, usuario.getEndereco());
            stmt.setString(7, usuario.getTelefone());
            stmt.setString(8, usuario.getCpf());
            stmt.setString(9, usuario.getSus());
            stmt.setInt(10, usuario.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private boolean usuarioExiste(int id) throws SQLException {
        String sql = "SELECT id FROM usuarios WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    public void deletarUsuario(int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
