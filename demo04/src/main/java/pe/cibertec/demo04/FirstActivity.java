package pe.cibertec.demo04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pe.cibertec.demo04.entities.Persona;

public class FirstActivity extends AppCompatActivity {
    public final static String ARG_PERSONA = "arg_persona";
    private final int REQUEST_CODE = 1;

    private TextView tvFirstNombre, tvFirstApellido, tvFirstDNI, tvFirstEdad;
    private Button btFirstCapturar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        tvFirstNombre = (TextView) findViewById(R.id.tvFirstNombre);
        tvFirstApellido = (TextView) findViewById(R.id.tvFirstApellido);
        tvFirstDNI = (TextView) findViewById(R.id.tvFirstDNI);
        tvFirstEdad = (TextView) findViewById(R.id.tvFirstEdad);
        btFirstCapturar = (Button) findViewById(R.id.btFirstCapturar);
        btFirstCapturar.setOnClickListener(btFirstCapturarOnClickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                Persona persona = data.getParcelableExtra(ARG_PERSONA);
                tvFirstNombre.setText(persona.getNombre());
                tvFirstApellido.setText(persona.getApellido());
                tvFirstDNI.setText(persona.getDni());
                tvFirstEdad.setText(String.valueOf(persona.getEdad()));
            }
        } else {
            tvFirstNombre.setText("");
            tvFirstApellido.setText("");
            tvFirstDNI.setText("");
            tvFirstEdad.setText("");
        }
    }

    View.OnClickListener btFirstCapturarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    };
}
