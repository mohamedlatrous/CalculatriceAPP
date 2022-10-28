package com.example.calculatrice;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;



public class MainActivity extends AppCompatActivity {

    TextView filedResult;
    String Calcul = "" ;
    String CalculSave = "" ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filedResult = (TextView) findViewById(R.id.result);

    }

    private void calcul(String value) {
        Calcul = Calcul + value;
        filedResult.setText(Calcul);
    }

    public void calculer(View view) {

        try {
            Double resultat;
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
            resultat = (double) engine.eval(Calcul);
            if (resultat.toString() == "Infinity")
                Toast.makeText(this, "Calcul impossible", Toast.LENGTH_SHORT).show();
            else
            if (resultat != null) {
                if(resultat % 1 == 0)
                    filedResult.setText(String.valueOf(resultat.intValue()));
                else
                    filedResult.setText(String.valueOf(resultat.doubleValue()));
            }
        } catch (ScriptException e) {
            Toast.makeText(this, "Erreur ! ", Toast.LENGTH_SHORT).show();
        }

    }

    public void clear (View view) {
        filedResult.setText("");
        Calcul = "";
    }


    public void divisionClick(View view) {
        calcul("/");
    }

    public void sevenClick(View view) {
        calcul("7");
    }

    public void eightClick(View view) {
        calcul("8");
    }

    public void nineClick(View view) {
        calcul("9");
    }

    public void multipliClick(View view) {
        calcul("*");
    }

    public void fourClick(View view) {
        calcul("4");
    }

    public void fiveClick(View view) {
        calcul("5");
    }

    public void sixClick(View view) {
        calcul("6");
    }

    public void moinClick(View view) {
        calcul("-");
    }

    public void oneClick(View view) {
        calcul("1");
    }

    public void twoClick(View view) {
        calcul("2");
    }

    public void threeClick(View view) {
        calcul("3");
    }

    public void plusClick(View view) {
        calcul("+");
    }

    public void vergulClick(View view) {
        calcul(".");
    }

    public void zeroClick(View view) {
        calcul("0");
    }


    @Override
    protected void onPause() {
        super.onPause();
        CalculSave = Calcul;
    }
    @Override
    protected void onResume() {
        super.onResume();
        Calcul = CalculSave;
        filedResult.setText(Calcul);

    }




}