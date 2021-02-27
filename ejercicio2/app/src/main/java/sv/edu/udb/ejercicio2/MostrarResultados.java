package sv.edu.udb.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MostrarResultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_resultados);

        TextView tv;

        Bundle bundle = getIntent().getExtras();

        String[] data = new String[2];

        data = bundle.getStringArray("C1");

        tv = (TextView) findViewById(R.id.tvVotosC1);
        tv.setText(data[0]);
        tv = (TextView) findViewById(R.id.tvPorcentajeC1);
        tv.setText(data[1]);

        data = bundle.getStringArray("C2");

        tv = (TextView) findViewById(R.id.tvVotosC2);
        tv.setText(data[0]);
        tv = (TextView) findViewById(R.id.tvPorcentajeC2);
        tv.setText(data[1]);

        data = bundle.getStringArray("C3");

        tv = (TextView) findViewById(R.id.tvVotosC3);
        tv.setText(data[0]);
        tv = (TextView) findViewById(R.id.tvPorcentajeC3);
        tv.setText(data[1]);

        data = bundle.getStringArray("C4");

        tv = (TextView) findViewById(R.id.tvVotosC4);
        tv.setText(data[0]);
        tv = (TextView) findViewById(R.id.tvPorcentajeC4);
        tv.setText(data[1]);

        data = bundle.getStringArray("Nulo");

        tv = (TextView) findViewById(R.id.tvVotosNulos);
        tv.setText(data[0]);
        tv = (TextView) findViewById(R.id.tvPorcentajeNulos);
        tv.setText(data[1]);
    }
}