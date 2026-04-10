
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Agendamento {
    
    public enum Status{
    AGENDADO("Agendado"),
    CONFIRMADO("Confirmado"),
    CONCLUIDO("Concluído"),
    CANCELADO("Cancelado");
    
    private final String descricao;
    
    Status(String descricao) { this.descricao = descricao;}
    
    public String getDescricap() { return descricao;}
    
   @Override
   public String toString() {return descricao;}
   
   public static Status fromString(String valor) {
            for (Status s : values()) {
                if (s.descricao.equalsIgnoreCase(valor)) return s;
            }
            return AGENDADO;
        }
    }
 
    private int id;
    private int clienteId;
    private String clienteNome;
    private int servicoId;
    private String servicoNome;
    private int barbeiroId;
    private String barbeiroNome;
    private LocalDate data;
    private LocalTime horarioInicio;
    private int duracaoMinutos;
    private Status status;
    private String observacao;
    private double valorCobrado;
 
    private static final DateTimeFormatter FMT_DATA    = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FMT_HORARIO = DateTimeFormatter.ofPattern("HH:mm");
 
    public Agendamento() {
        this.status = Status.AGENDADO;
    }
 
    public Agendamento(int clienteId, int servicoId, int barbeiroId,
                       LocalDate data, LocalTime horarioInicio, int duracaoMinutos) {
        this.clienteId      = clienteId;
        this.servicoId      = servicoId;
        this.barbeiroId     = barbeiroId;
        this.data           = data;
        this.horarioInicio  = horarioInicio;
        this.duracaoMinutos = duracaoMinutos;
        this.status         = Status.AGENDADO;
    }
 
    public LocalTime getHorarioFim() {
        if (horarioInicio == null) return null;
        return horarioInicio.plusMinutes(duracaoMinutos);
    }
 
    public boolean sobrepoeA(Agendamento outro) {
        if (outro.getStatus() == Status.CANCELADO) return false;
        if (this.barbeiroId != outro.getBarbeiroId()) return false;
        if (!this.data.equals(outro.getData())) return false;
 
        LocalTime meuInicio   = this.horarioInicio;
        LocalTime meuFim      = this.getHorarioFim();
        LocalTime outroInicio = outro.getHorarioInicio();
        LocalTime outroFim    = outro.getHorarioFim();
 
        if (meuInicio == null || meuFim == null || outroInicio == null || outroFim == null)
            return false;
 
        return meuInicio.isBefore(outroFim) && meuFim.isAfter(outroInicio);
    }
}

 

