package org.yuri.cal;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtResult;
    private EditText numberOne, numberTwo, numberThree;
    private Button btnBilgi;
    private Bilgi b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult= (TextView)findViewById(R.id.txtThree);
        numberOne= (EditText)findViewById(R.id.editOne);
        numberTwo= (EditText)findViewById(R.id.editTwo);
        numberThree= (EditText)findViewById(R.id.editThree);

        btnBilgi=(Button)findViewById(R.id.btnCalculate);
        b= new Bilgi();


    }

    public void bilgi(View v){

        String one= numberOne.getText().toString();
        double bir= Double.parseDouble(one);

        double iki= Double.parseDouble(numberTwo.getText().toString());
        double uc= Double.parseDouble(numberThree.getText().toString());

        //int result=bir+iki;

        //Bilgi b= new Bilgi();
        double result= b.add(bir,iki,uc);

        txtResult.setText(result+"");
    }

    public void onClick(View v){
        String one= numberOne.getText().toString();
        int bir= Integer.parseInt(one);

        int iki= Integer.parseInt(numberTwo.getText().toString());
        int uc= Integer.parseInt(numberThree.getText().toString());


    }
}







