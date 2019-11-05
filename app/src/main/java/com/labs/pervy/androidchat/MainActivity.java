package com.labs.pervy.androidchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    private Button btn;
    private EditText nickname;
    private EditText password;
    private EditText server;
    public static final String NICKNAME = "usernickname";
    public static final String SERVER="server";
    public static final String PASS="pass";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //call UI component  by id
        btn = (Button) findViewById(R.id.enterchat) ;
        nickname = (EditText) findViewById(R.id.nickname);
        server =(EditText) findViewById(R.id.etServer);
        password = (EditText) findViewById(R.id.etPass);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if the nickname is not empty go to chatbox activity and add the nickname to the intent extra
                 if(!nickname.getText().toString().isEmpty()){
                     Intent i  = new Intent(MainActivity.this,RoomActivity.class);
                     //retreive nickname from textview and add it to intent extra
                     i.putExtra(NICKNAME,nickname.getText().toString());
                     i.putExtra(SERVER,server.getText().toString());
                     i.putExtra(PASS,password.getText().toString());
                     startActivity(i);
                 }
            }
        });

    }
}
