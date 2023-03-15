package com.example.diaz_delgado;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private ArrayList<Producto> DataSet;
    private onItemClickListener onItemClickListener;

    public void setDataSet(ArrayList<Producto> dataSet) {
        DataSet = dataSet;
        notifyDataSetChanged();
    }

    public CustomAdapter(ArrayList<Producto> dataSet) {
        DataSet = dataSet;
        this.onItemClickListener = null;
    }

    public void setOnItemClickListener(CustomAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_productos,parent,false);
        return new ViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        Producto myprod = DataSet.get(position);
        holder.link(myprod);
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
}
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv1,tv2;
        private ImageView img;
        private Button btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1= itemView.findViewById(R.id.tv_name);
            tv2= itemView.findViewById(R.id.tv_cost);
            img= itemView.findViewById(R.id.iv_url);
            btn= itemView.findViewById(R.id.btn_eliminar);
        }

        public void link(Producto myprod){
            tv1.setText(myprod.getNombre());
            tv2.setText(myprod.getPrecio().toString());
            Picasso.get()
                    .load(myprod.getUrlImg())
                    .error(R.drawable.ic_launcher_background)
                    .into(img);

            if(onItemClickListener!=null){

                itemView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        onItemClickListener.onItemClick(myprod,getAdapterPosition());
                    }
                });
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemBtnClick(myprod,getAdapterPosition());
                    }
                });
            }
        }
    }
    public interface onItemClickListener{
        void onItemClick(Producto myprod, int posicion);
        void onItemBtnClick(Producto myprod, int posicion);
    }
}