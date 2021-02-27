package sv.edu.udb.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ejecutarEscrutinio(View view){

        TextView tv = (TextView)findViewById(R.id.mtVotos);
        String voteString = tv.getText().toString();

        String[] votes = voteString.split(",");
        if(validarVotos(votes)){

            int c1 = 0, c2 = 0, c3 = 0, c4 = 0, nulo = 0;
            for (String voto: votes){

                switch (voto.trim()){
                    case "1":
                        c1++;
                        break;
                    case  "2":
                        c2++;
                        break;
                    case "3":
                        c3++;
                        break;
                    case "4":
                        c4++;
                        break;
                    default:
                        nulo++;
                        break;
                }
            }

            double totalVotos = c1 + c2 + c3 + c4 + nulo;

            double porcentajeC1 = c1 * 100 / totalVotos;
            double porcentajeC2 = c2 * 100 / totalVotos;
            double porcentajeC3 = c3 * 100 / totalVotos;
            double porcentajeC4 = c4 * 100 / totalVotos;
            double porcentajeNulos = nulo * 100 / totalVotos;

            DecimalFormat df2 = new DecimalFormat("##.##");

            Intent intent = new Intent(this, MostrarResultados.class);

            String[] dataC1 = new String[2];
            dataC1[0] = String.valueOf(c1);
            dataC1[1] = String.valueOf(df2.format(porcentajeC1));
            intent.putExtra("C1", dataC1);

            String[] dataC2 = new String[2];
            dataC2[0] = String.valueOf(c2);
            dataC2[1] = String.valueOf(df2.format(porcentajeC2));
            intent.putExtra("C2", dataC2);

            String[] dataC3 = new String[2];
            dataC3[0] = String.valueOf(c3);
            dataC3[1] = String.valueOf(df2.format(porcentajeC3));
            intent.putExtra("C3", dataC3);

            String[] dataC4 = new String[2];
            dataC4[0] = String.valueOf(c4);
            dataC4[1] = String.valueOf(df2.format(porcentajeC4));
            intent.putExtra("C4", dataC4);

            String[] dataNulo = new String[2];
            dataNulo[0] = String.valueOf(nulo);
            dataNulo[1] = String.valueOf(df2.format(porcentajeNulos));
            intent.putExtra("Nulo", dataNulo);

            startActivity(intent);

        }else{

            Toast.makeText(this, "Formato de voto inválido", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validarVotos(String[] votos){

        try{

            Integer candidato;
            for (String voto: votos){

                candidato = Integer.parseInt(voto.trim());
            }

            return true;
        }catch(Exception e){

            return false;
        }

    }
}