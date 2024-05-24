package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Ubs;

public class UbsDAO {
    
    private Connection connection;

    public UbsDAO(Connection connection) {
        this.connection = connection;
    }

    public void adicionarUbs(Ubs ubs) throws SQLException {
        String sql = "INSERT INTO ubs (nome, email, localizacao, telefone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ubs.getNome());
            stmt.setString(2, ubs.getEmail());
            stmt.setString(3, ubs.getLocalizacao());
            stmt.setString(4, ubs.getTelefone());
            stmt.executeUpdate();
        }
    }

    public Ubs buscarUbsPorId(int id) throws SQLException {
        String sql = "SELECT * FROM ubs WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Ubs(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("localizacao"),
                        rs.getString("telefone")
                    );
                }
            }
        }
        return null;
    }

    public List<Ubs> listarUbs() throws SQLException {
        List<Ubs> ubss = new ArrayList<>();
        String sql = "SELECT * FROM ubs";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Ubs ubs = new Ubs(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("localizacao"),
                    rs.getString("telefone")
                );
                ubss.add(ubs);
            }
        }
        return ubss;
    }

    public void atualizarUbs(Ubs ubs) throws SQLException {
        String sql = "UPDATE ubs SET nome = ?, email = ?, localizacao = ?, telefone = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, ubs.getNome());
            stmt.setString(2, ubs.getEmail());
            stmt.setString(3, ubs.getLocalizacao());
            stmt.setString(4, ubs.getTelefone());
            stmt.setInt(5, ubs.getId());
            stmt.executeUpdate();
        }
    }

    public void deletarUbs(int id) throws SQLException {
        String sql = "DELETE FROM ubs WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

