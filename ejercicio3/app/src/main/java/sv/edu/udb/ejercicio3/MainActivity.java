package sv.edu.udb.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private String[][] formData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.positions_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spE1 = (Spinner)findViewById(R.id.spPositionE1);
        Spinner spE2 = (Spinner)findViewById(R.id.spPositionE2);
        Spinner spE3 = (Spinner)findViewById(R.id.spPositionE3);

        spE1.setAdapter(adapter);
        spE2.setAdapter(adapter);
        spE3.setAdapter(adapter);
    }

    public void sendInfo(View view){

        formData = getData();
        if(analyzeInformation()){

            Intent intent = new Intent(this, resultados.class);
            intent.putExtra("data", formData);

            startActivity(intent);
        }
    }

    private String[][] getData(){

        String[][] data = new String[3][9];
        /*
        * 0->Nombre
        * 1->Apellido
        * 2->Horas
        * 3->Cargo
        * 4->ISSS
        * 5->AFP
        * 6->Renta
        * 7->Aumento
        * 8->Liquido
        * */
        TextView tv = (TextView)findViewById(R.id.etNombreE1);
        data[0][0] = tv.getText().toString();
        tv = (TextView)findViewById(R.id.etApellidoE1);
        data[0][1] = tv.getText().toString();
        tv = (TextView)findViewById(R.id.etHorasE1);
        data[0][2] = tv.getText().toString();
        Spinner sp = (Spinner)findViewById(R.id.spPositionE1);
        data[0][3] = sp.getSelectedItem().toString();

        tv = (TextView)findViewById(R.id.etNombreE2);
        data[1][0] = tv.getText().toString();
        tv = (TextView)findViewById(R.id.etApellidoE2);
        data[1][1] = tv.getText().toString();
        tv = (TextView)findViewById(R.id.etHorasE2);
        data[1][2] = tv.getText().toString();
        sp = (Spinner)findViewById(R.id.spPositionE2);
        data[1][3] = sp.getSelectedItem().toString();

        tv = (TextView)findViewById(R.id.etNombreE3);
        data[2][0] = tv.getText().toString();
        tv = (TextView)findViewById(R.id.etApellidoE3);
        data[2][1] = tv.getText().toString();
        tv = (TextView)findViewById(R.id.etHorasE3);
        data[2][2] = tv.getText().toString();
        sp = (Spinner)findViewById(R.id.spPositionE3);
        data[2][3] = sp.getSelectedItem().toString();

        return data;
    }

    private boolean analyzeInformation(){

        String aux;
        int workedHours = 0;
        int hoursLeft = 0;
        Double salary = 0.0;
        Double isss = 0.0;
        Double afp = 0.0;
        Double renta = 0.0;
        Double liquid = 0.0;
        DecimalFormat df2 = new DecimalFormat("###.##");
        for(int i = 0; i <= 2; i++){

            for(int j = 0; j <= 3; j++){

                aux = formData[i][j];
                switch (j){
                    case 0:
                    case 1:
                        if(aux.trim().length() == 0){

                            Toast.makeText(this, "Revisar datos de empleado" + String.valueOf(i + 1), Toast.LENGTH_SHORT).show();
                            return false;
                        }
                        break;
                    case 2:
                        try{

                            workedHours = Integer.parseInt(aux);
                            if(workedHours <= 0){

                                Toast.makeText(this, "Revisar horas del empleado" + String.valueOf(i+1), Toast.LENGTH_SHORT).show();
                                return false;
                            }else if(workedHours <= 160){

                                salary = workedHours * 9.75;
                            }else if(workedHours > 160){

                                hoursLeft = workedHours - 160;
                                salary = 160 * 9.75;
                                salary += hoursLeft * 11.50;
                            }

                            isss = salary * 0.0525;
                            afp = salary * 0.0688;
                            renta = salary * 0.1;

                            liquid = salary - isss - afp - renta;

                            formData[i][4] = df2.format(isss);
                            formData[i][5] = df2.format(afp);
                            formData[i][6] = df2.format(renta);
                            formData[i][8] = df2.format(liquid);
                        }catch (Exception e){

                            Toast.makeText(this, "Revisar horas del empleado" + String.valueOf(i+1), Toast.LENGTH_SHORT).show();
                            return false;
                        }
                    break;
                    case 3:

                        double extraMoney = 0;

                        switch (formData[i][3]){

                            case "Gerente":
                                extraMoney = liquid * 0.1;
                                break;
                            case "Asistente":
                                extraMoney = liquid * 0.05;
                                break;
                            case "Secretaria":
                                extraMoney = liquid * 0.03;
                                break;
                            default:
                                extraMoney = liquid * 0.02;
                                break;
                        }

                        liquid += extraMoney;
                        formData[i][8] = df2.format(liquid);
                        formData[i][7] = df2.format(extraMoney);

                        break;
                }
            }
        }

        return true;
    }
}