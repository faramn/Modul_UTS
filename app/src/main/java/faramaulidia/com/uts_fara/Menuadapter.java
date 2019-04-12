package faramaulidia.com.uts_fara;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Menuadapter extends RecyclerView.Adapter<Menuadapter.MenuadapterViewHolder> {

    private ArrayList<Menu> menu;

    public Menuadapter(ArrayList<Menu> list) {
        this.menu= list;
    }

    @Override
    public MenuadapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_rvactivity, parent, false);
        return new MenuadapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuadapterViewHolder holder,final int position) {
        holder.txt_nama.setText(menu.get(position).getNama());
        holder.txt_harga.setText(menu.get(position).getHarga());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveDetail(position, v.getContext());
            }
        });
    }

    private void MoveDetail(int position, Context c) {
        Context context = c;
        Intent i = new Intent(context, Detail.class);
        i.putExtra("nama", menu.get(position).getNama());
        i.putExtra("bahan", menu.get(position).getBahanBaku());
        i.putExtra("harga", menu.get(position).getHarga());
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return (menu != null) ? menu.size() : 0;
    }


    public class MenuadapterViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_nama,txt_harga;

        public MenuadapterViewHolder(View itemView) {
            super(itemView);
            txt_nama = (TextView) itemView.findViewById(R.id.txt_nama);
            txt_harga = (TextView) itemView.findViewById(R.id.txt_harga);
        }
    }
}
