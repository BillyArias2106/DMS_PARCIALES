package sv.edu.udb.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class resultados extends AppCompatActivity {

    private String[][] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        Bundle bundle = getIntent().getExtras();
        data = (String[][])bundle.get("data");
        setInfo();
    }

    private void setInfo(){

        TextView tv = (TextView)findViewById(R.id.tvNombreE1);
        tv.setText(data[0][0] + " " + data[0][1]);
        tv = (TextView)findViewById(R.id.tvISSSE1);
        tv.setText("ISSS: $" + data[0][4]);
        tv = (TextView)findViewById(R.id.tvAFPE1);
        tv.setText("AFP: $" + data[0][5]);
        tv = (TextView)findViewById(R.id.tvRentaE1);
        tv.setText("Renta: $" + data[0][6]);
        tv = (TextView)findViewById(R.id.tvLiquidoE1);
        tv.setText("Liquido: $" + data[0][8]);

        tv = (TextView)findViewById(R.id.tvNombreE2);
        tv.setText(data[1][0] + " " + data[1][1]);
        tv = (TextView)findViewById(R.id.tvISSSE2);
        tv.setText("ISSS: $" + data[1][4]);
        tv = (TextView)findViewById(R.id.tvAFPE2);
        tv.setText("AFP: $" + data[1][5]);
        tv = (TextView)findViewById(R.id.tvRentaE2);
        tv.setText("Renta: $" + data[1][6]);
        tv = (TextView)findViewById(R.id.tvLiquidoE2);
        tv.setText("Liquido: $" + data[1][8]);

        tv = (TextView)findViewById(R.id.tvNombreE3);
        tv.setText(data[2][0] + " " + data[2][1]);
        tv = (TextView)findViewById(R.id.tvISSSE3);
        tv.setText("ISSS: $" + data[2][4]);
        tv = (TextView)findViewById(R.id.tvAFPE3);
        tv.setText("AFP: $" + data[2][5]);
        tv = (TextView)findViewById(R.id.tvRentaE3);
        tv.setText("Renta: $" + data[2][6]);
        tv = (TextView)findViewById(R.id.tvLiquidoE3);
        tv.setText("Liquido: $" + data[2][8]);

        double liquidoE1 = Double.parseDouble(data[0][8]);
        double liquidoE2 = Double.parseDouble(data[1][8]);
        double liquidoE3 = Double.parseDouble(data[2][8]);

        tv = (TextView)findViewById(R.id.tvMayorSalario);
        if(liquidoE1 > liquidoE2){

            if(liquidoE1 > liquidoE3){

                tv.setText(data[0][0] + " " + data[0][1]);
            }else{

                tv.setText(data[2][0] + " " + data[2][1]);
            }
        }else if(liquidoE2 > liquidoE3){

            tv.setText(data[1][0] + " " + data[1][1]);
        }else{

            tv.setText(data[2][0] + " " + data[2][1]);
        }

        tv = (TextView)findViewById(R.id.tvMenorSalario);

        if(liquidoE1 < liquidoE2){

            if(liquidoE1 < liquidoE3){

                tv.setText(data[0][0] + " " + data[0][1]);
            }else{

                tv.setText(data[2][0] + " " + data[2][1]);
            }
        }else if(liquidoE2 < liquidoE3){

            tv.setText(data[1][0] + " " + data[1][1]);
        }else{

            tv.setText(data[2][0] + " " + data[2][1]);
        }

        if(liquidoE1 > 300.00){

            tv = (TextView)findViewById(R.id.tvMayorMinimo1);
            tv.setText(data[0][0] + " " + data[0][1]);
        }

        if(liquidoE2 > 300.00){

            tv = (TextView)findViewById(R.id.tvMayorMinimo2);
            tv.setText(data[1][0] + " " + data[1][1]);
        }

        if(liquidoE3 > 300.00){

            tv = (TextView)findViewById(R.id.tvMayorMinimo3);
            tv.setText(data[2][0] + " " + data[2][1]);
        }

    }
}