package Model;
import java.sql.Timestamp;

public class Agendamento {
    private int id;
    private int medicoId;
    private int calendarioId;
    private String pacienteNome;

    public Agendamento(int id, int medicoId, int calendarioId, String pacienteNome) {
        this.id = id;
        this.medicoId = medicoId;
        this.calendarioId = calendarioId;
        this.pacienteNome = pacienteNome;
    }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getmedicoId() {
        return medicoId;
    }

    public void setmedicoId(int medicoId) {
        this.medicoId = medicoId;
    }

    public int getcalendarioId() {
        return calendarioId;
    }

    public void setcalendarioId(int calendarioId) {
        this.calendarioId = calendarioId;
    }

    public String getpacienteNome() {
        return pacienteNome;
    }

    public void setpacienteNome(String pacienteNome) {
        this.pacienteNome = pacienteNome;
    }

    
}
