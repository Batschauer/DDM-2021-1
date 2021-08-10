package com.example.carlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class CarroAdapter extends ArrayAdapter {
    private Context mContext;
    private int mResource;

    public CarroAdapter(Context context, int resource, ArrayList<Carro> carros) {
        super(context, resource, carros);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvCodigo = (TextView) convertView.findViewById(R.id.tvCodigo);
        TextView tvModelo = (TextView) convertView.findViewById(R.id.tvModelo);
        TextView tvPreco = (TextView) convertView.findViewById(R.id.tvPreco);
        TextView tvPrecoVenda = (TextView) convertView.findViewById(R.id.tvPrecoVenda);
        ImageView ivFoto = (ImageView) convertView.findViewById(R.id.ivFoto);

        Carro carro = (Carro) getItem(position);
        NumberFormat formatter = new DecimalFormat("#,###.00");
        tvCodigo.setText(Integer.toString(carro.getCodigo()));
        tvModelo.setText(carro.getModelo());
        tvPreco.setText(formatter.format(carro.getPreco()));
        tvPrecoVenda.setText(formatter.format(carro.getPrecoVenda()));
        ivFoto.setImageResource(carro.getFoto());

        return convertView;
    }
}
