package connectuor.Adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import connectuor.Modelos.Viagem;
import com.example.ljuni.connectuor.R;

import java.util.List;

/**
 * Created by ljuni on 05/10/2017.
 */

public class ListaDeViagensRVAdapter extends RecyclerView.Adapter<ListaDeViagensRVAdapter.ViewHolder> {


    private final Context context;
    private final List<Viagem> viagens;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_viagens, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListaDeViagensRVAdapter.ViewHolder holder, final int position) {

        final Viagem viagem = this.viagens.get(position);

        holder.tv_viagem_destino.setText(viagem.getLocal());
        holder.tv_viagem_dt_inicio.setText(viagem.getData_inicio());

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Destino: " + viagem.getLocal(), Snackbar.LENGTH_LONG).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu pop = new PopupMenu(context, view);
                MenuInflater inflater = pop.getMenuInflater();
                inflater.inflate(R.menu.popup_menu_lista_viagens, pop.getMenu());

                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        if(item.getItemId() == R.id.item_ver_detalhes_da_viagem){
                            Toast.makeText(context, "Mostrar detalhes", Toast.LENGTH_SHORT).show();
                        }
                        else if(item.getItemId() == R.id.item_falar_com_guia){
                            viagem.delete();
                            ListaDeViagensRVAdapter.this.notifyItemRemoved(position);
                            Toast.makeText(context, "Fazer chamada pelo telefone", Toast.LENGTH_LONG).show();
                        }
                        else if(item.getItemId() == R.id.item_remover_viagem){
                            viagem.delete();
                            ListaDeViagensRVAdapter.this.notifyItemRemoved(position);
                            Toast.makeText(context, "Removido", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });

                pop.show();


                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return viagens.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        protected TextView tv_viagem_destino;
        protected TextView tv_viagem_dt_inicio;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_viagem_destino = (TextView) itemView.findViewById(R.id.tv_nome_destino);
            tv_viagem_dt_inicio = (TextView) itemView.findViewById(R.id.tv_data_inicio);
        }
    }

    public ListaDeViagensRVAdapter(Context context, List<Viagem> viagens){

        this.context = context;
        this.viagens = viagens;
    }
}
