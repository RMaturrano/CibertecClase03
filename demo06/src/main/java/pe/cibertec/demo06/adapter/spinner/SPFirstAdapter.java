package pe.cibertec.demo06.adapter.spinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import pe.cibertec.demo06.R;
import pe.cibertec.demo06.entities.Persona;

/**
 * Created by Android-SAB-PM on 23/04/2016.
 */
public class SPFirstAdapter extends ArrayAdapter<Persona> {

    public SPFirstAdapter(Context context, List<Persona> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.first_item_selected, parent, false);

        TextView tv = (TextView) convertView.findViewById(R.id.tvFirstItemPersona);

        Persona persona = getItem(position);
        tv.setText(persona.getNombre()+" "+persona.getApellido());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.first_item_dropdown, parent, false);

        TextView tv = (TextView) convertView.findViewById(R.id.tvFirstItemPersona);

        Persona persona = getItem(position);
        tv.setText(persona.getNombre()+" "+persona.getApellido());

        return convertView;
    }
}
