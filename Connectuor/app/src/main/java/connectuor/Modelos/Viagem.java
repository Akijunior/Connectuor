package connectuor.Modelos;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by ljuni on 05/10/2017.
 */

public class Viagem extends SugarRecord{

    private int quantidade_dias;
    private int quantidade_de_pessoas;
    private String local;
    private double valor_total;
    private String data_inicio;

    public Viagem(){ }

    public Viagem(int quantidade_dias, int quantidade_de_pessoas, String local, double valor_total, String data_inicio) {
        this.quantidade_dias = quantidade_dias;
        this.quantidade_de_pessoas = quantidade_de_pessoas;
        this.local = local;
        this.valor_total = valor_total;
        this.data_inicio = data_inicio;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public int getQuantidade_dias() {
        return quantidade_dias;
    }

    public void setQuantidade_dias(int quantidade_dias) {
        this.quantidade_dias = quantidade_dias;
    }

    public int getQuantidade_de_pessoas() {
        return quantidade_de_pessoas;
    }

    public void setQuantidade_de_pessoas(int quantidade_de_pessoas) {
        this.quantidade_de_pessoas = quantidade_de_pessoas;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
}
