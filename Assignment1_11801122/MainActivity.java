package org.yuri.coffeeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    EditText editText;

    GridView gridView;
    CoffeeAdapter adapter;


    private static final String TAG = MainActivity.class.getSimpleName();

    private final int PRICE_COFFEE = 2;
    private final int PRICE_WHIP = 1;
    private final int PRICE_CARAMEL = 1;
    private final int PRICE_Marshmallow = 1;
    private final int PRICE_ExtraShot = 1;

    private int mQuantity = 0;
    //    private TextView quantityTextView;
    private TextView mPriceTextView;
    private TextView mQuantityTextView;
    private CheckBox mToppingCheckBox;

    private CheckBox mCaramelCheckBox;
    private CheckBox mMarshmallowCheckBox;
    private CheckBox mExtraShotCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);
        mPriceTextView = (TextView) findViewById(R.id.price_text_view);
        mQuantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        mToppingCheckBox = (CheckBox) findViewById(R.id.topping_checkbox);
        mCaramelCheckBox = (CheckBox) findViewById(R.id.caramel_checkbox);
        mMarshmallowCheckBox = (CheckBox) findViewById(R.id.marshmallow_checkbox);
        mExtraShotCheckBox = (CheckBox) findViewById(R.id.extraShot_checkbox);


        adapter = new CoffeeAdapter();

        adapter.addItem(new CoffeeItem("Espresso", "strong black coffee made by forcing steam", 1, R.drawable.coffee1));
        adapter.addItem(new CoffeeItem("Latte", "milk and a single shot of coffee", 1, R.drawable.coffee2));
        adapter.addItem(new CoffeeItem("Capuccino", " three layers (kind of like a cake)", 1, R.drawable.coffee3));
        adapter.addItem(new CoffeeItem("Macchiato", "latte with added chocolate", 1, R.drawable.coffee4));
        adapter.addItem(new CoffeeItem("Shakerato", "using espresso and ice cubes", 1, R.drawable.coffee5));
        adapter.addItem(new CoffeeItem("Vienna", "two shots and whipped cream", 1, R.drawable.coffee6));
        adapter.addItem(new CoffeeItem("Affogato", "a shot of espresso poured over a desert ", 1, R.drawable.coffee7));


        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                CoffeeItem item = (CoffeeItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "choice : " +item.getName() + " & " + "price : $" + item.getPrice(), Toast.LENGTH_LONG).show();
            }

        });


    }

    class CoffeeAdapter extends BaseAdapter {
        ArrayList<CoffeeItem> items = new ArrayList<CoffeeItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(CoffeeItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            CoffeeItemView view = new CoffeeItemView(getApplicationContext());

            CoffeeItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getContent());
            view.setAge(item.getPrice());
            view.setImage(item.getResId());

            int numColumns = gridView.getNumColumns();
            int rowIndex = position / numColumns;
            int columnIndex = position % numColumns;
            Log.d("CoffeeAdapter", "index : " + rowIndex + ", " + columnIndex);

            return view;
        }
    }

    public void btnOrder(View view) {



        String name = "Name : yuri lee";
        String quantity = "Quantity : " + mQuantity;
        String topping = "Add whipped cream?"+ mToppingCheckBox.isChecked();
        String caramel = "Add caramel?"+ mCaramelCheckBox.isChecked();
        String marshmallow = "Add marshmallow?" + mMarshmallowCheckBox.isChecked();
        String Extra = "Add extra shot?" + mExtraShotCheckBox.isChecked();



        int price = PRICE_COFFEE * mQuantity;

        if (mToppingCheckBox.isChecked()){

            price += mQuantity * PRICE_WHIP;

        }else if(mCaramelCheckBox.isChecked()){

            price += mQuantity * PRICE_CARAMEL;

        }else if(mMarshmallowCheckBox.isChecked()){

            price += mQuantity * PRICE_Marshmallow;

        }else if(mExtraShotCheckBox.isChecked()){

            price += mQuantity * PRICE_ExtraShot;

        }

        String formattedPrice = "Total : "
                + NumberFormat.getCurrencyInstance().format(price);
        String message = name + "\n" + topping + "\n" + caramel + "\n"
                + marshmallow + "\n" + Extra + "\n"

                + quantity + "\n" + formattedPrice;

//                getString(R.string.total) + price + "\n"+ getString(R.string.thank_you);

        displayMessage(message);

    }

    public void btnBasket(View view){


    }

    public void btnPay(View view){



        String name = "Name : yuri lee";
        String quantity = "Quantity : " + mQuantity;
        String topping = "Add whipped cream?"+ mToppingCheckBox.isChecked();
        String caramel = "Add caramel?"+ mCaramelCheckBox.isChecked();
        String marshmallow = "Add marshmallow?" + mMarshmallowCheckBox.isChecked();
        String Extra = "Add extra shot?" + mExtraShotCheckBox.isChecked();



        int price = PRICE_COFFEE * mQuantity;

        if (mToppingCheckBox.isChecked()){

            price += mQuantity * PRICE_WHIP;

        }else if(mCaramelCheckBox.isChecked()){

            price += mQuantity * PRICE_CARAMEL;

        }else if(mMarshmallowCheckBox.isChecked()){

            price += mQuantity * PRICE_Marshmallow;

        }else if(mExtraShotCheckBox.isChecked()){

            price += mQuantity * PRICE_ExtraShot;

        }

        String formattedPrice = "Total : "
                + NumberFormat.getCurrencyInstance().format(price);
        String message = name + "\n" + topping + "\n" + caramel + "\n"
                + marshmallow + "\n" + Extra + "\n"

                + quantity + "\n" + formattedPrice;

//                getString(R.string.total) + price + "\n"+ getString(R.string.thank_you);

        displayMessage(message);






    }

    public void increment(View view){
        mQuantity++;
        display(mQuantity);
        displayPrice(PRICE_COFFEE * mQuantity);
    }

    public void decrement(View view){
        mQuantity--;

        if(mQuantity < 0){
            mQuantity = 0;
        }

        display(mQuantity);
        displayPrice(PRICE_COFFEE * mQuantity);
    }

    private void display(int number) {
        mQuantityTextView.setText("" + number);

    }

    private void displayPrice(int number){
        mPriceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


    private void displayMessage(String message) {
        mPriceTextView.setText(message);
    }

}
