package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Agendamento;

public class AgendamentoDAO {

    private Connection connection;

    public AgendamentoDAO (Connection connection) {
        this.connection = connection;
    }

    public void adicionarAgendamento(int medicoId, int calendarioId, String pacienteNome) throws SQLException {
        String sql = "INSERT INTO agendamento (medico_id, calendario_id, paciente_nome) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, medicoId);
            stmt.setInt(2, calendarioId);
            stmt.setString(3, pacienteNome);
            stmt.executeUpdate();
        }
    }

    public Agendamento buscarAgendamentoPorId(int id) throws SQLException {
        String sql = "SELECT * FROM agendamento WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Agendamento(
                        rs.getInt("id"),
                        rs.getInt("medico_id"),
                        rs.getInt("calendario_id"),
                        rs.getString("paciente_nome")
                    );
                }
            }
        }
        return null;
    }

    public List<Agendamento> listarAgendamentos() throws SQLException {
        List<Agendamento> agendamentos = new ArrayList<>();
        String sql = "SELECT * FROM agendamento";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Agendamento agendamento = new Agendamento(
                    rs.getInt("id"),
                    rs.getInt("medico_id"),
                    rs.getInt("calendario_id"),
                    rs.getString("paciente_nome")
                );
                agendamentos.add(agendamento);
            }
        }
        return agendamentos;
    }

    public void atualizarAgendamento(int id, int medicoId, int calendarioId, String pacienteNome) throws SQLException {
        String sql = "UPDATE agendamento SET medico_id = ?, calendario_id = ?, paciente_nome = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, medicoId);
            stmt.setInt(2, calendarioId);
            stmt.setString(3, pacienteNome);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }

    public void deletarAgendamento(int id) throws SQLException {
        String sql = "DELETE FROM agendamento WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
