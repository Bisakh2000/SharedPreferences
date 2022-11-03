package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName,passWord;
    TextView data1,data2;
    Button save,display;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.et_username);
        passWord = findViewById(R.id.et_password);
        save=findViewById(R.id.bt_save);
        display=findViewById(R.id.bt_getData);
        data1=findViewById(R.id.tx_username);
        data2=findViewById(R.id.tx_password);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userName.getText().toString();
                String pass = passWord.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", user);
                editor.putString("password", pass);
                editor.apply();
            }
        });



            display.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences sh = getSharedPreferences("prefs", MODE_PRIVATE);
                    String value1 = sh.getString("username","");
                    String value2 = sh.getString("password","");

                    //Toast.makeText(MainActivity.this, "data"+value1+"value2"+value2, Toast.LENGTH_SHORT).show();
                data1.setText(value1);
                data2.setText(value2);
                }
            });
    }
}