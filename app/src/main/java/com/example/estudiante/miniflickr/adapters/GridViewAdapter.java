package com.example.estudiante.miniflickr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.estudiante.miniflickr.R;
import com.example.estudiante.miniflickr.modelos.Imagen;

import java.util.ArrayList;

/**
 * Created by ESTUDIANTE on 02/12/2015.
 */
public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Imagen> imagenes;

    public GridViewAdapter(Context context, ArrayList<Imagen> imagenes) {
        this.context = context;
        this.imagenes = imagenes;
    }

    @Override

    public int getCount() {
        return imagenes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView != null){
            gridView = new View(context);
            gridView = inflater.inflate(R.layout.img_item, null);

            ImageView imageView = (ImageView) gridView.findViewById(R.id.imageView);

            imageView.setImageResource(imagenes.get(position).getRecurso());
        }else{
            gridView = (View) convertView;
        }


        return gridView;
    }
}
