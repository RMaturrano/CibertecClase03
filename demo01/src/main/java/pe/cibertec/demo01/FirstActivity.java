package pe.cibertec.demo01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    public final static String ARG_NOMBRE = "arg_nombre";
    private final int REQUEST_CODE = 1;

    private TextView tvFirstNombre;
    private Button btFirstCapturar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        tvFirstNombre = (TextView) findViewById(R.id.tvFirstNombre);
        btFirstCapturar = (Button) findViewById(R.id.btFirstCapturar);
        btFirstCapturar.setOnClickListener(btFirstCapturarOnClickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                String nombre = data.getStringExtra(ARG_NOMBRE);
                tvFirstNombre.setText(nombre);
            }
        } else {
            tvFirstNombre.setText("");
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
