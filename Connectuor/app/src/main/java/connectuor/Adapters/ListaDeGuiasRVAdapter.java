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

import connectuor.Modelos.Guia;
import com.example.ljuni.connectuor.R;

import java.util.List;

/**
 * Created by ljuni on 06/10/2017.
 */

public class ListaDeGuiasRVAdapter extends RecyclerView.Adapter<ListaDeGuiasRVAdapter.ViewHolder> {

    private final Context context;
    private final List<Guia> guias;

    public ListaDeGuiasRVAdapter(Context context, List<Guia> guias){

        this.context = context;
        this.guias = guias;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        protected TextView tv_guia_nome;
        protected TextView tv_guia_estado;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_guia_nome = (TextView) itemView.findViewById(R.id.tv_guia_nome);
            tv_guia_estado = (TextView) itemView.findViewById(R.id.tv_guia_estado);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_guias, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListaDeGuiasRVAdapter.ViewHolder holder, final int position) {

        final Guia guia = this.guias.get(position);

        holder.tv_guia_nome.setText(guia.getNome());
        holder.tv_guia_estado.setText(guia.getEstado());

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Guia: " + guia.getNome(), Snackbar.LENGTH_LONG).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu pop = new PopupMenu(context, view);
                MenuInflater inflater = pop.getMenuInflater();
                inflater.inflate(R.menu.popup_menu_lista_guias, pop.getMenu());

                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        if(item.getItemId() == R.id.item_remover_guia){
                            guia.delete();
                            ListaDeGuiasRVAdapter.this.guias.remove(position);
                            ListaDeGuiasRVAdapter.this.notifyItemRemoved(position);
                            ListaDeGuiasRVAdapter.this.notifyItemRangeChanged(position,
                                    ListaDeGuiasRVAdapter.this.guias.size());
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
        return guias.size();
    }
}
