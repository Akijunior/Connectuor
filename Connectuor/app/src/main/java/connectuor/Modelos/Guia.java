package connectuor.Modelos;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.List;
import java.util.TreeSet;

/**
 * Created by ljuni on 04/10/2017.
 */

public class Guia extends SugarRecord {

    private String estado;
    private String nome;
    private String telefone;
    private double valor;

    public Guia(){ }

//    @Ignore
//    private TreeSet<String> serviços;
//    private TreeSet<Hospedagem> hospedagems_pertencentes;

    public Guia(String nome, String telefone, double valor, String estado) {
        this.nome = nome;
        this.telefone = telefone;
        this.valor = valor;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return this.getNome() + " - " + this.getEstado() + "\nR$ " + getValor() + " - " + getTelefone();
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public double getValor() {
        return valor;
    }

    public String getEstado() {
        return estado;
    }

}
