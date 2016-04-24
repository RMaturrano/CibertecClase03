package pe.cibertec.demo04;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pe.cibertec.demo04.entities.Persona;

/**
 * Created by Android-SAB-PM on 23/04/2016.
 */
public class SecondActivity extends AppCompatActivity {

    private EditText etSecondNombre, etSecondApellido, etSecondDNI, etSecondEdad;
    private TextView tvSecondNombre, tvSecondApellido, tvSecondDNI, tvSecondEdad;
    private Button btSecondGuardar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        etSecondNombre = (EditText) findViewById(R.id.etSecondNombre);
        etSecondApellido = (EditText) findViewById(R.id.etSecondApellido);
        etSecondDNI = (EditText) findViewById(R.id.etSecondDNI);
        etSecondEdad = (EditText) findViewById(R.id.etSecondEdad);
        tvSecondNombre = (TextView) findViewById(R.id.tvSecondNombre);
        tvSecondApellido = (TextView) findViewById(R.id.tvSecondApellido);
        tvSecondDNI = (TextView) findViewById(R.id.tvSecondDNI);
        tvSecondEdad = (TextView) findViewById(R.id.tvSecondEdad);
        btSecondGuardar = (Button) findViewById(R.id.btSecondGuardar);

        btSecondGuardar.setOnClickListener(btSecondGuardarOnClickListener);
    }

    View.OnClickListener btSecondGuardarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tvSecondNombre.setVisibility(View.GONE);
            tvSecondApellido.setVisibility(View.GONE);
            tvSecondEdad.setVisibility(View.GONE);
            tvSecondDNI.setVisibility(View.GONE);
            boolean isValid = true;

            if(etSecondNombre.getText().toString().trim().isEmpty()) {
                tvSecondNombre.setVisibility(View.VISIBLE);
                isValid =false;
            }

            if(etSecondApellido.getText().toString().trim().isEmpty()) {
                tvSecondApellido.setVisibility(View.VISIBLE);
                isValid=false;
            }

            if(etSecondDNI.getText().toString().trim().isEmpty()) {
                tvSecondDNI.setText("*Ingrese su DNI");
                tvSecondDNI.setVisibility(View.VISIBLE);
                isValid=false;
            }

            if(etSecondDNI.getText().toString().trim().length()<8) {
                tvSecondDNI.setText("*El DNI tiene que ser de 8 digitos");
                tvSecondDNI.setVisibility(View.VISIBLE);
                isValid=false;
            }

            if(etSecondEdad.getText().toString().trim().isEmpty()) {
                tvSecondEdad.setVisibility(View.VISIBLE);
                isValid=false;
            }

            if(!isValid)
                return;

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
