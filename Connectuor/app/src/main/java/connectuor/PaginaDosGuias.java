package connectuor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.example.ljuni.connectuor.R;
import connectuor.Adapters.ListaDeGuiasRVAdapter;
import connectuor.Modelos.Estados;
import connectuor.Modelos.Guia;

import java.util.List;

public class PaginaDosGuias extends AppCompatActivity {

    private RecyclerView rvGuias;
    private ListaDeGuiasRVAdapter adapter;
    private String estadoSelecionado;
    private Estados estados;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_dos_guias);

        rvGuias = (RecyclerView) findViewById(R.id.rv_guias);

    }

    @Override
    protected void onResume() {
        super.onResume();

        CarregarGuias();
    }

    private void CarregarGuias() {
        List<Guia> guias = Guia.listAll(Guia.class);

        adapter = new ListaDeGuiasRVAdapter(this, guias);
        rvGuias.setAdapter(adapter);

        rvGuias.setLayoutManager(new LinearLayoutManager(this));
    }

    public void NovoGuia(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final View viewDialog = getLayoutInflater().inflate(R.layout.dialog_novo_guia, null);

        builder.setView(viewDialog)
                .setTitle("Novo guia")
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        EditText edGuiaNome = (EditText) viewDialog.findViewById(R.id.ed_guia_nome);
                        EditText edGuiaTelefone = (EditText) viewDialog.findViewById(R.id.ed_guia_fone);
                        EditText edGuiaValor = (EditText) viewDialog.findViewById(R.id.ed_guia_preco);
                        AutoCompleteTextView acGuiaEstado = (AutoCompleteTextView) viewDialog.findViewById(R.id.ed_guia_estado);

                        String[] todos_estados = Estados.povoar();

                        arrayAdapter = new ArrayAdapter(PaginaDosGuias.this, android.R.layout.simple_list_item_1, todos_estados);
                        acGuiaEstado.setAdapter(arrayAdapter);

                        acGuiaEstado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                                estadoSelecionado = (String) adapterView.getItemAtPosition(position);
                            }
                        });

                        String nome = edGuiaNome.getText().toString();
                        String telefone = edGuiaTelefone.getText().toString();
                        String estado = acGuiaEstado.getText().toString();
                        double valor = Double.valueOf(edGuiaValor.getText().toString());

                        Guia guia = new Guia(nome, telefone, valor, estado);
                        guia.save();

                        CarregarGuias();
                    }
                })
                .setNegativeButton("Cancelar", null)
                .show();
    }
}