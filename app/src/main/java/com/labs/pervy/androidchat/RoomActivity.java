package com.labs.pervy.androidchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.labs.pervy.androidchat.MainActivity.NICKNAME;
import static com.labs.pervy.androidchat.MainActivity.SERVER;

public class RoomActivity extends AppCompatActivity {

    private Button btnChatThis;
    private Button btnChatOthers;

    public static final String TYPE = "type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        final String serverUrl = getIntent().getStringExtra(SERVER);
        final String nick = getIntent().getStringExtra(NICKNAME);
        btnChatThis = (Button) findViewById(R.id.btnChatThisServer);
        btnChatOthers = (Button) findViewById(R.id.btnChatOther);

        btnChatThis.setText("Chat on " + serverUrl);

        btnChatThis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RoomActivity.this, ChatBoxActivity.class);
                i.putExtra(SERVER, serverUrl);
                i.putExtra(TYPE, "cen");
                i.putExtra(NICKNAME, nick);
                startActivity(i);
            }
        });

        btnChatOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RoomActivity.this, ChatBoxActivity.class);
                i.putExtra(SERVER, serverUrl);
                i.putExtra(TYPE, "decen");
                i.putExtra(NICKNAME, nick);
                startActivity(i);
            }
        });
    }
}
