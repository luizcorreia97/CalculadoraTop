package com.example.luizh.calculadora_top;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    float num = 0;
    float result = 0;
    float memoria = 0;
    private String op = "";
    boolean vez = true;
    boolean calcok = true;

    DecimalFormat format = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_0 = (Button)findViewById(R.id.btn_0);
        Button btn_1 = (Button)findViewById(R.id.btn_1);
        Button btn_2 = (Button)findViewById(R.id.btn_2);
        Button btn_3 = (Button)findViewById(R.id.btn_3);
        Button btn_4 = (Button)findViewById(R.id.btn_4);
        Button btn_5 = (Button)findViewById(R.id.btn_5);
        Button btn_6 = (Button)findViewById(R.id.btn_6);
        Button btn_7 = (Button)findViewById(R.id.btn_7);
        Button btn_8 = (Button)findViewById(R.id.btn_8);
        Button btn_9 = (Button)findViewById(R.id.btn_9);
        Button btn_mais = (Button)findViewById(R.id.btn_mais);
        Button btn_menos = (Button)findViewById(R.id.btn_menos);
        Button btn_vezes = (Button)findViewById(R.id.btn_vezes);
        Button btn_dividir = (Button)findViewById(R.id.btn_dividir);
        Button btn_porcentagem = (Button)findViewById(R.id.btn_porcentagem);
        Button btn_igual = (Button)findViewById(R.id.btn_igual);
        Button btn_ponto = (Button)findViewById(R.id.btn_ponto);
        Button btn_guarda_memoria = (Button)findViewById(R.id.btn_guarda_memoria);
        Button btn_mostra_memoria = (Button)findViewById(R.id.btn_mostra_memoria);
        Button btn_limpa_tudo = (Button)findViewById(R.id.btn_limpa_tudo);
        Button btn_limpa = (Button)findViewById(R.id.btn_limpa);

        final TextView visor_baixo = (TextView)findViewById(R.id.visor_baixo);
        final TextView visor_resultado = (TextView)findViewById(R.id.visor_resultado);
        final TextView visor_historico = (TextView)findViewById(R.id.visor_historico);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_baixo.setText(visor_baixo.getText().toString()+"0");
                num = Float.parseFloat(visor_baixo.getText().toString());
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_baixo.setText(visor_baixo.getText().toString()+"1");
                num = Float.parseFloat(visor_baixo.getText().toString());
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_baixo.setText(visor_baixo.getText().toString()+"2");
                num = Float.parseFloat(visor_baixo.getText().toString());
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_baixo.setText(visor_baixo.getText().toString()+"3");
                num = Float.parseFloat(visor_baixo.getText().toString());
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_baixo.setText(visor_baixo.getText().toString()+"4");
                num = Float.parseFloat(visor_baixo.getText().toString());
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_baixo.setText(visor_baixo.getText().toString()+"5");
                num = Float.parseFloat(visor_baixo.getText().toString());
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_baixo.setText(visor_baixo.getText().toString()+"6");
                num = Float.parseFloat(visor_baixo.getText().toString());
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_baixo.setText(visor_baixo.getText().toString()+"7");
                num = Float.parseFloat(visor_baixo.getText().toString());
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_baixo.setText(visor_baixo.getText().toString()+"8");
                num = Float.parseFloat(visor_baixo.getText().toString());
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_baixo.setText(visor_baixo.getText().toString()+"9");
                num = Float.parseFloat(visor_baixo.getText().toString());
            }
        });

        btn_ponto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_baixo.setText(visor_baixo.getText().toString()+".");
                num = Float.parseFloat(visor_baixo.getText().toString());
            }
        });

        btn_guarda_memoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                memoria = result;
                Toast.makeText(getApplicationContext(),"Saved in Memory: "+format.format(memoria), Toast.LENGTH_LONG).show();
            }
        });

        btn_mostra_memoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Memory: "+format.format(memoria), Toast.LENGTH_LONG).show();
                visor_baixo.setText(""+format.format(memoria));
            }
        });

        btn_limpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_baixo.setText(null);
                visor_resultado.setBackgroundColor(Color.TRANSPARENT);
            }
        });

        btn_limpa_tudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_baixo.setText(null);
                visor_resultado.setText(null);
                visor_historico.setText(null);
                op = "";
                result = 0;
                vez = true;
                visor_resultado.setBackgroundColor(Color.TRANSPARENT);
            }
        });

        btn_mais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_resultado.setBackgroundColor(Color.TRANSPARENT);
                valida_calculo();
                op = "+";

                if(calcok ==  true){
                    visor_resultado.setText("= "+format.format(result));
                    visor_historico.setText(visor_historico.getText().toString()+visor_baixo.getText().toString()+"+");
                    visor_baixo.setText(null);
                }
                else{
                    visor_baixo.setText(null);
                    op = "";
                }
            }
        });

        btn_menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_resultado.setBackgroundColor(Color.TRANSPARENT);
                valida_calculo();
                op = "-";

                if(calcok ==  true){
                    visor_resultado.setText("= "+format.format(result));
                    visor_historico.setText(visor_historico.getText().toString()+visor_baixo.getText().toString()+"-");
                    visor_baixo.setText(null);
                }
                else{
                    visor_baixo.setText(null);
                    op = "";
                }
            }
        });

        btn_vezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_resultado.setBackgroundColor(Color.TRANSPARENT);
                valida_calculo();
                op = "*";

                if(calcok ==  true){
                    visor_resultado.setText("= "+format.format(result));
                    visor_historico.setText(visor_historico.getText().toString()+visor_baixo.getText().toString()+"*");
                    visor_baixo.setText(null);
                }
                else{
                    visor_baixo.setText(null);
                    op = "";
                }

            }
        });

        btn_dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_resultado.setBackgroundColor(Color.TRANSPARENT);
                valida_calculo();
                op = "/";

                if(calcok ==  true){
                    visor_resultado.setText("= "+format.format(result));
                    visor_historico.setText(visor_historico.getText().toString()+visor_baixo.getText().toString()+"/");
                    visor_baixo.setText(null);
                }
                else{
                    visor_baixo.setText(null);
                    op = "";
                }

            }
        });

        btn_porcentagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                visor_resultado.setBackgroundColor(Color.TRANSPARENT);
                num = Float.parseFloat(visor_baixo.getText().toString());

                if (op == "+") {

                    result = (result + num);

                    visor_resultado.setText(format.format(result));
                    visor_baixo.setText(null);
                    visor_historico.setText(visor_historico.getText().toString() + format.format(num) + "%");
                }
                else if (op == "-"){

                    result = (result - num);

                    visor_resultado.setText(format.format(result));
                    visor_baixo.setText(null);
                    visor_historico.setText(visor_historico.getText().toString() + format.format(num) + "%");
                }
                else if (op == "*"){

                    result = (result * num);

                    visor_resultado.setText(format.format(result));
                    visor_baixo.setText(null);
                    visor_historico.setText(visor_historico.getText().toString() + format.format(num) + "%");
                }
                else if ((op == "/")&&(num !=0)){

                    result = (result / num);

                    visor_resultado.setText(format.format(result));
                    visor_baixo.setText(null);
                    visor_historico.setText(visor_historico.getText().toString() + format.format(num) + "%");
                }
                else{

                    Toast.makeText(getApplicationContext(),"Invalid Operation !!", Toast.LENGTH_LONG).show();
                    visor_baixo.setText(null);
                }
            }
        });

        btn_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                valida_calculo();

                if(calcok ==  true){
                    visor_resultado.setText("= "+format.format(result));
                    visor_historico.setText(visor_historico.getText().toString()+visor_baixo.getText().toString()+"="+format.format(result));
                    visor_resultado.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    visor_baixo.setText(null);
                    num = 0;
                    calcok = false;
                }
                else{
                    visor_baixo.setText(null);
                }
            }
        });

    }

    public void valida_calculo(){

        if(vez == true){
            result = num;
            vez = false;
            calcok = true;
        }

        if(op == "+"){
            result+= num;
            calcok = true;
        }

        if(op == "-"){
            result-= num;
            calcok = true;
        }

        if(op == "*"){
            result*= num;
            calcok = true;
        }

        if(op == "/"){
            if(num == 0){
                Toast.makeText(getApplicationContext()," I Can't Divide By Zero !!", Toast.LENGTH_LONG).show();
                calcok = false;
            }
            else{
                result/= num;
                calcok = true;
            }
        }
    }
}