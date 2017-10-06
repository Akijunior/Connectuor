package connectuor.Modelos;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.TreeSet;

/**
 * Created by ljuni on 05/10/2017.
 */

public class Usuario extends SugarRecord {

    private String nome;
    private String telefone;
    private String email;
    private String estado;
    @Ignore
    private TreeSet<Viagem> viagens;

    public Usuario(){ }

    public Usuario(String nome, String telefone, String email, String estado) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}