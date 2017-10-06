package connectuor.Paginas_de_redirecionamento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ljuni.connectuor.R;

import connectuor.Modelos.Estados;
import connectuor.Modelos.Viagem;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class FormularioNovaViagem extends AppCompatActivity {

    private EditText ed_quantidade_dias;
    private EditText ed_quantidade_de_pessoas;
    private EditText ed_data_inicio;
    private AutoCompleteTextView acEstadoDeDestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_nova_viagem);

        ed_quantidade_dias = (EditText) findViewById(R.id.ed_qtd_dias);
        ed_quantidade_de_pessoas = (EditText) findViewById(R.id.ed_qtd_pessoas);
        ed_data_inicio = (EditText) findViewById(R.id.ed_dt_inicio);
        acEstadoDeDestino = (AutoCompleteTextView) findViewById(R.id.ac_estado_destino);

        acEstadoDeDestino.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String estadoSelecionado = (String) adapterView.getItemAtPosition(position);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        String[] todos_estados = Estados.povoar();

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, todos_estados);
        acEstadoDeDestino.setAdapter(adapter);
    }

    public void SalvarViagem(View view) {

        String local = acEstadoDeDestino.getText().toString();
        int quantidade_pessoas = Integer.valueOf(ed_quantidade_de_pessoas.getText().toString());
        int quantidade_dias = Integer.valueOf(ed_quantidade_dias.getText().toString());
        String data_de_inicio = ed_data_inicio.getText().toString();

        Viagem viagem = new Viagem(quantidade_dias, quantidade_pessoas, local, 15.5, data_de_inicio);
        viagem.save();

        Toast.makeText(this, "Viagem salva.", Toast.LENGTH_LONG).show();

        finish();

    }
}