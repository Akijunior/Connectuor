package connectuor.Modelos;

import com.orm.SugarRecord;

import java.util.TreeSet;

/**
 * Created by ljuni on 05/10/2017.
 */

public class Estados {

    public static String[] povoar(){
        String[] todos_estados = new String[] {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará",
                "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso",
                "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco",
                "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
                "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};
      return todos_estados;
    }

}
