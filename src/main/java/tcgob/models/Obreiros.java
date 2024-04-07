package tcgob.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Obreiros {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private int cim;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataIniciacao;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataElevacao;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataExaltacao;
    @JsonIgnore
    private boolean ativo;
    private String email;
    @JsonIgnore
    private int altBenemerito = 0;
    @JsonIgnore
    private int altGranBenemerito = 0;
    @JsonIgnore
    private int altEstrela = 0;
    @JsonIgnore
    private int altCruz = 0;
    @JsonIgnore
    private int altDomPedro = 0;

}
