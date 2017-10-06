package connectuor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ljuni.connectuor.R;

public class Main extends AppCompatActivity {

    private TextView mensagem_da_pagina;
    private ImageView praia;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.inicio:
                    mensagem_da_pagina.setText("Inicio");
                    praia.setVisibility(View.VISIBLE);
                    return true;
                case R.id.viajar:
                    mensagem_da_pagina.setText("Viagens");
                    praia.setVisibility(View.INVISIBLE);
                    Redireciona_a_pagina_de_viagens();
                    return true;
                case R.id.serGuia:
                    mensagem_da_pagina.setText("Ser um guia");
                    praia.setVisibility(View.INVISIBLE);
                    Redireciona_a_pagina_seja_um_guia();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensagem_da_pagina = (TextView) findViewById(R.id.mensagem);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        praia = (ImageView) findViewById(R.id.praia);
        Glide.with(this).load(R.drawable.tenor).asGif().into(praia);
    }

    public void Redireciona_a_pagina_de_viagens(){
        Toast.makeText(this, "Abrir pagina de viagens... ", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, PaginaDeViagens.class);
        startActivity(intent);
    }

    public void  Redireciona_a_pagina_seja_um_guia(){
        Toast.makeText(this, "Abrir pagina de guias... ", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, PaginaDosGuias.class);
        startActivity(intent);
    }

}
