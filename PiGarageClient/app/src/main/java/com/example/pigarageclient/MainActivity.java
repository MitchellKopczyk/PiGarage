package com.example.pigarageclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_IP = "KEY_IP";
    public static final String KEY_PORT = "KEY_PORT";
    public static final String KEY_KEY = "KEY_KEY";

    private Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonSave;
    private EditText textIP, textPort, textKey;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOne = findViewById(R.id.door1);
        buttonTwo = findViewById(R.id.door2);
        buttonThree = findViewById(R.id.door3);
        buttonFour = findViewById(R.id.door4);
        buttonSave = findViewById(R.id.save);
        textIP = findViewById(R.id.ipAddress);
        textPort = findViewById(R.id.portNum);
        textKey = findViewById(R.id.key);


        sp = getSharedPreferences(KEY_IP, this.MODE_PRIVATE);
        sp = getSharedPreferences(KEY_PORT, this.MODE_PRIVATE);
        sp = getSharedPreferences(KEY_KEY, this.MODE_PRIVATE);

        if (sp.contains(KEY_IP)){
            textIP.setText(sp.getString(KEY_IP, ""));
        }

        if (sp.contains(KEY_PORT)){
            textPort.setText(sp.getString(KEY_PORT, ""));
        }

        if (sp.contains(KEY_KEY)){
            textKey.setText(sp.getString(KEY_KEY, ""));
        }




        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new SignalDoor().execute(textIP.getText().toString(),
                            textPort.getText().toString(), textKey.getText().toString(),"DOOR 1");
                }
                catch (Exception ex){
                    Toast.makeText(getApplicationContext(),"Failed To Open Door 1",Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    new SignalDoor().execute(textIP.getText().toString(),
                            textPort.getText().toString(), textKey.getText().toString(),"DOOR 2");
                }
                catch (Exception ex){
                    Toast.makeText(getApplicationContext(),"Failed To Open Door 2",Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    new SignalDoor().execute(textIP.getText().toString(),
                            textPort.getText().toString(), textKey.getText().toString(),"DOOR 3");
                }
                catch (Exception ex){
                    Toast.makeText(getApplicationContext(),"Failed To Open Door 3",Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    new SignalDoor().execute(textIP.getText().toString(),
                            textPort.getText().toString(), textKey.getText().toString(),"DOOR 4");
                }
                catch (Exception ex){
                    Toast.makeText(getApplicationContext(),"Failed To Open Door 4",Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ipAddress = textIP.getText().toString();
                String portNum = textPort.getText().toString();
                String key = textKey.getText().toString();

                SharedPreferences.Editor editor = sp.edit();
                editor.putString(KEY_IP, ipAddress);
                editor.putString(KEY_PORT, portNum);
                editor.putString(KEY_KEY, key);
                editor.commit();

                Toast.makeText(getApplicationContext(),"Saved :)",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
