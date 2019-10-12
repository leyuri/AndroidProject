package org.yuri.databasetest;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //전역 변수

    private TextView txtMsg;
    private EditText editName, editLastName, editAge, editGender;
    private ListView listView;

    private ArrayAdapter<String> adapter;
    private SQLiteDatabase myDataBase;
    private String path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txtMsg = findViewById(R.id.msgText);
        editName = findViewById(R.id.editName);
        editLastName = findViewById(R.id.editLastName);
        editAge = findViewById(R.id.editAge);
        editGender = findViewById(R.id.editGender);
        listView = findViewById(R.id.listView);


        //start to create database

        File myDbPath = getApplication().getFilesDir();
        path = myDbPath + "/" + "new";
        txtMsg.setText(path.toString());





        try{

            if(!databasesExist()) {


                myDataBase = SQLiteDatabase.openDatabase(path, null,

                        SQLiteDatabase.CREATE_IF_NECESSARY);

                //Create the table
                String table = "create table student("
                        + "id integer primary key autoincrement,"
                        + "name text,"
                        + "lastname text,"
                        + "age text,"
                        + "gender text)";

//                String table = "create table student("
//                        + "id integer primary key autoincrement,"
//                        + "name text,"
//                        + "lastname text,"
//                        + "gender text,"
//                        + "age text)";


                //Execute the query to create the query
                myDataBase.execSQL(table); //now we have the table



                /*
                //insert one row of data
                String name, lastName, age;
                name = "Ali";
                lastName = "Erhan";
                age = "23";

                String input = "insert into student (name,lastname,age)"
                        + "values('" + name + "','" + lastName + "','" + age + "')";


                //insert this data into table

                myDataBase.execSQL(input);
                Toast.makeText(this, "input is finished", Toast.LENGTH_LONG).show();

                */
            }



        }catch (SQLException e){
            txtMsg.setText(e.getMessage());
        }




    }


    //helper method to check if a databases is exist
    private boolean databasesExist(){

        File dbFile = new File(path);
        return dbFile.exists();

        //존재하면 ture로 반환한다구?
    }


    //read data from the table
    public void read(View view){

        myDataBase = SQLiteDatabase.openDatabase(path,null,
                SQLiteDatabase.CREATE_IF_NECESSARY);


        String read = "Select * from student";
        Cursor cursor = myDataBase.rawQuery(read,null);

        ArrayList<String> students = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,students);


        String name, lastname, age,gender;
        while (cursor.moveToNext()){
            name = cursor.getString(cursor.getColumnIndex("name"));
            lastname = cursor.getString(cursor.getColumnIndex("lastname"));
            age = cursor.getString(cursor.getColumnIndex("age"));
            gender = cursor.getString(cursor.getColumnIndex("gender"));


            String result = name + "   " + lastname + "   " + age + "   " + gender;
            //put this result into the arraylist
            students.add(result);

        }   //end of loop, record is finished
        listView.setAdapter(adapter);   //어뎁터 setting!
        myDataBase.close();


    }

    //write data from the table
    public void write(View view){


        //read data from fields
        //three data have
        String name = editName.getText().toString();
        String lastName = editLastName.getText().toString();
        String age = editAge.getText().toString();
        String gender = editGender.getText().toString();


        //open my data base
        myDataBase = SQLiteDatabase.openDatabase(path,null,
                SQLiteDatabase.CREATE_IF_NECESSARY);


        String input = "insert into student (name,lastname,age,gender)"
                + "values('" + name + "','" + lastName + "','" + age + "','" + gender +"')";

//        String input = "insert into student (name,lastname,age)"
//                + "values('" + name + "','" + lastName + "','" + age + "')";

        myDataBase.execSQL(input);

        Toast.makeText(this,"one row data is inserted",
                Toast.LENGTH_LONG).show();



        editName.setText(" ");
        editLastName.setText(" ");
        editAge.setText(" ");
        editGender.setText(" ");
        myDataBase.close();



    }



    //clear data from the table
    public void clear(View view){


        adapter.clear();
        listView.setAdapter(adapter);

    }


}
