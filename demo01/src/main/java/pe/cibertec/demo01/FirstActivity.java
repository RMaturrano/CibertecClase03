package pe.cibertec.demo01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

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

    View.OnClickListener btFirstCapturarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
