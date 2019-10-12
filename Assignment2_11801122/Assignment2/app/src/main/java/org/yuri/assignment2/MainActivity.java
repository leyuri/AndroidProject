package org.yuri.assignment2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends Activity {

    TabHost tabHost;
    Button btnAdd, btnSubmit, btnReset ;
    EditText productCode,productName, category;
    EditText productionDate, expirationDate, price, amount;

    TextView textView1, textView2, textView3;
    TextView textView1Tab2,textView2Tab2,textView3Tab2,textView4Tab2,textView5Tab2 ;
    TextView textView1Tab3,textView2Tab3,textView3Tab3,textView4Tab3;

    TextView productNameTab3,categoryTab3,productionExp,priceOfBox;
    TextView nameCode;
    CheckBox checkBox;

    int a,b,res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkBox = (CheckBox)findViewById(R.id.checkBox);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        productCode = findViewById(R.id.productCode);
        productName = findViewById(R.id.productName);
        category = findViewById(R.id.category);

        textView1Tab2 = findViewById(R.id.textView1Tab2);
        textView2Tab2 = findViewById(R.id.textView2Tab2);
        textView3Tab2 = findViewById(R.id.textView3Tab2);
        textView4Tab2 = findViewById(R.id.textView4Tab2);
        textView5Tab2 = findViewById(R.id.textView5Tab2);

        textView1Tab3 = findViewById(R.id.textView1Tab3);
        textView2Tab3 = findViewById(R.id.textView2Tab3);
        textView3Tab3 = findViewById(R.id.textView3Tab3);
        textView4Tab3 = findViewById(R.id.textView4Tab3);


        nameCode = findViewById(R.id.nameCode);



        productionDate = findViewById(R.id.productionDate);
        expirationDate = findViewById(R.id.expirationDate);
        price = findViewById(R.id.price);
        amount = findViewById(R.id.amount);


        btnSubmit = findViewById(R.id.btnSubmit);
        btnAdd = findViewById(R.id.btnAdd);
        btnReset = findViewById(R.id.btnReset);


        productNameTab3 = findViewById(R.id.productNameTab3);
        categoryTab3 = findViewById(R.id.categoryTab3);
        productionExp = findViewById(R.id.productionExp);
        priceOfBox = findViewById(R.id.priceOfBox);


        tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tabSpec;

        //tab_one
        tabSpec= tabHost.newTabSpec("Screen-1");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Clock",null);
        tabSpec.setIndicator("PRODUCT REGISTRATION");
        tabHost.addTab(tabSpec);
        tabHost.setCurrentTab(0); //default tab

        //tab_two
        tabSpec= tabHost.newTabSpec("Screen-2");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("Login",null);
        tabSpec.setIndicator("DETAILED INFO");
        tabHost.addTab(tabSpec);


        //tba_three
        tabSpec= tabHost.newTabSpec("Screen-3");
        tabSpec.setContent(R.id.tab3);
        tabSpec.setIndicator("Image",null);
        tabSpec.setIndicator("REGISTERED PRODUCT");
        tabHost.addTab(tabSpec);




        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameCode.setText(productCode.getText().toString() + "(" + productName.getText().toString()+ ")");
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                productCode.setText(" ");
//                productName.setText(" ");
//                category.setText(" ");
//                nameCode.setText(" ");
                productionDate.setText(" ");
                expirationDate.setText(" ");
                price.setText(" ");
                amount.setText(" ");
                productNameTab3.setText(" ");
                categoryTab3.setText(" ");
                productionExp.setText(" ");
                priceOfBox.setText(" ");
            }
        });


        //checkBoxEnable
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    btnSubmit.setEnabled(true);
                    btnSubmit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            productNameTab3.setText(productCode.getText().toString() + "(" + productName.getText().toString()+ ")");
                            categoryTab3.setText(category.getText());
                            productionExp.setText(expirationDate.getText());

                            a = Integer.parseInt(price.getText().toString());
                            b = Integer.parseInt(amount.getText().toString());

                            res = a * b;
                            priceOfBox.setText(String.valueOf(res));
                        }
                    });


                }else{
                    btnSubmit.setEnabled(false);
                }

            }
        });
    }
}
