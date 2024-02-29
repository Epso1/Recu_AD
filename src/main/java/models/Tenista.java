package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tenista implements Serializable {
    @JsonProperty("uuid")
    private String uid;
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("ranking")
    private int ranking;
    @JsonProperty("birthday")
    private LocalDate fechaNacimiento;
    @JsonProperty("turnedPro")
    private int anyoProfesional;
    @JsonProperty("height")
    private int altura;
    @JsonProperty("weight")
    private int peso;
    @JsonProperty("plays")
    private String manoDominante;
    @JsonProperty("backhand")
    private String tipoReves;
    @JsonProperty("country")
    private String pais;
    @JsonProperty("coaching")
    private ArrayList<String> entrenadores;
    @JsonProperty("titles")
    private int titulos;
    @JsonProperty("prizeMoney")
    private long ganancias;

    @Override
    public String toString() {
        return "Tenista{" +
                "uid='" + uid + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ranking=" + ranking +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", anyoProfesional=" + anyoProfesional +
                ", altura=" + altura +
                ", peso=" + peso +
                ", manoDominante='" + manoDominante + '\'' +
                ", tipoReves='" + tipoReves + '\'' +
                ", pais='" + pais + '\'' +
                ", entrenadores=" + entrenadores +
                ", titulos=" + titulos +
                ", ganancias=" + ganancias +
                '}';
    }
}
