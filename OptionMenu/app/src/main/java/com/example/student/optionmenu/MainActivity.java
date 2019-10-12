package com.example.student.optionmenu;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText inputText;
    private TextView textDisplay;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        textDisplay = findViewById(R.id.textDisplay);


    }

    public void submit(View view) {
        textDisplay.setText(inputText.getText().toString());
    }

    //helper method to create menu items...

    private void myMenu(Menu menu) {
        int groupID = 0;

        menu.add(groupID, 1, 2, "20 pints");
        menu.add(groupID, 2, 2, "30 pints");
        menu.add(groupID, 3, 3, "40 pints");
        menu.add(groupID, 4, 4, "50 pints");


        menu.add(groupID, 5, 5, "Green");
        menu.add(groupID, 6, 6, "Red");
        menu.add(groupID, 7, 7, "Yellow");


        menu.add(groupID, 8, 8, "Bold");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //myMenu(menu);
        getMenuInflater().inflate(R.menu.my_option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if(item.getTitle().equals("20 pixels"))
            textDisplay.setTextSize(20);
        else if(item.getItemId()==R.id.size_30)
            textDisplay.setTextSize(30);
        else {
            return  false;
        }



        return  true;

    }


    /*

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1)
            textDisplay.setTextSize(20);
        else if (item.getItemId() == 2)
            textDisplay.setTextSize(30);
        else if (item.getItemId() == 3)
            textDisplay.setTextSize(40);
        else if (item.getItemId() == 4)
            textDisplay.setTextSize(50);
        else if (item.getItemId() == 5)
            textDisplay.setTextColor(Color.GREEN);
        else if (item.getItemId() == 6)
            textDisplay.setTextColor(Color.RED);
        else if (item.getItemId() == 7)
            textDisplay.setTextColor(Color.YELLOW);
        else if (item.getItemId() == 8) {
            //String text = textDisplay.getText().toString();
            textDisplay.setTypeface(null, Typeface.BOLD);

        }
        return true;
    }

    */
}