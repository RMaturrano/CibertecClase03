package pe.cibertec.demo06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import pe.cibertec.demo06.adapter.spinner.SPFirstAdapter;
import pe.cibertec.demo06.entities.Persona;

public class FirstActivity extends AppCompatActivity {

    private SPFirstAdapter mSPFirstAdapter;
    private Spinner spFirstPersona;
    private TextView tvFirstPersona;
    private boolean isFirst=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        tvFirstPersona = (TextView) findViewById(R.id.tvFirstPersona);
        spFirstPersona = (Spinner) findViewById(R.id.spFirstPersonas);

        ArrayList<Persona> lstPersona= new ArrayList<>();
        Persona persona = new Persona();
        persona.setNombre("Luis");
        persona.setApellido("Rios");
        persona.setEdad(27);
        persona.setDni("12345678");
        lstPersona.add(persona);

        persona = new Persona();
        persona.setNombre("Alonso");
        persona.setApellido("Aguilar");
        persona.setEdad(25);
        persona.setDni("12312678");
        lstPersona.add(persona);

        persona = new Persona();
        persona.setNombre("Luis");
        persona.setApellido("Burgos");
        persona.setEdad(27);
        persona.setDni("12345600");
        lstPersona.add(persona);

        persona = new Persona();
        persona.setNombre("Franco");
        persona.setApellido("Castellano");
        persona.setEdad(22);
        persona.setDni("67345678");
        lstPersona.add(persona);

        mSPFirstAdapter = new SPFirstAdapter(FirstActivity.this,lstPersona);

        spFirstPersona.setAdapter(mSPFirstAdapter);

        spFirstPersona.setOnItemSelectedListener(spFirstPersonaOnItemSelectedListener);
    }

    AdapterView.OnItemSelectedListener spFirstPersonaOnItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(isFirst){
                isFirst=false;
                return;
            }
            Persona persona = (Persona) parent.getSelectedItem();
            tvFirstPersona.setText("Seleccionó: " + persona.getNombre() + " " + persona.getApellido());
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
