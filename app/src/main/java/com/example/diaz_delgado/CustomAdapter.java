package com.example.diaz_delgado;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private ArrayList<Producto> DataSet;

    public CustomAdapter(ArrayList<Producto> dataSet) {
        DataSet = dataSet;
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

        private TextView tv1;
        private TextView tv2;
        private ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1= itemView.findViewById(R.id.tv_name);
            tv2= itemView.findViewById(R.id.tv_cost);
            img= itemView.findViewById(R.id.iv_url);


        }

        public void link(Producto myprod){
            tv1.setText(myprod.getNombre());
            tv2.setText(myprod.getPrecio().toString());
    }
}
}