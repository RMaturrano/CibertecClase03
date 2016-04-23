package pe.cibertec.demo03;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pe.cibertec.demo03.entities.Persona;

/**
 * Created by Android-SAB-PM on 23/04/2016.
 */
public class SecondActivity extends AppCompatActivity {

    private EditText etSecondNombre, etSecondApellido, etSecondDNI, etSecondEdad;
    private Button btSecondGuardar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        etSecondNombre = (EditText) findViewById(R.id.etSecondNombre);
        etSecondApellido = (EditText) findViewById(R.id.etSecondApellido);
        etSecondDNI = (EditText) findViewById(R.id.etSecondDNI);
        etSecondEdad = (EditText) findViewById(R.id.etSecondEdad);
        btSecondGuardar = (Button) findViewById(R.id.btSecondGuardar);

        btSecondGuardar.setOnClickListener(btSecondGuardarOnClickListener);
    }

    View.OnClickListener btSecondGuardarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            Persona persona = new Persona();
            persona.setNombre(etSecondNombre.getText().toString().trim());
            persona.setApellido(etSecondApellido.getText().toString().trim());
            persona.setDni(etSecondDNI.getText().toString().trim());
            persona.setEdad(Integer.parseInt(etSecondEdad.getText().toString().trim()));
            intent.putExtra(FirstActivity.ARG_PERSONA, persona);
            setResult(RESULT_OK, intent);
            finish();
        }
    };
}
