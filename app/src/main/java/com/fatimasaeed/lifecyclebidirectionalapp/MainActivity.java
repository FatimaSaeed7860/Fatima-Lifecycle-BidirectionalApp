package com.fatimasaeed.lifecyclebidirectionalapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String TAG = "LifecycleMain";
    private EditText messageInput;
    private TextView replyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate called");

        messageInput = findViewById(R.id.messageInput);
        replyText = findViewById(R.id.replyText);
        Button sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageInput.getText().toString().trim();
                if (message.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a message", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, ReplyActivity.class);
                intent.putExtra("message_from_main", message);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            String reply = data.getStringExtra("reply_from_second");
            replyText.setText("Reply received: " + reply);
        }
    }

    @Override protected void onStart() { super.onStart(); Log.d(TAG, "onStart called"); }
    @Override protected void onResume() { super.onResume(); Log.d(TAG, "onResume called"); }
    @Override protected void onPause() { super.onPause(); Log.d(TAG, "onPause called"); }
    @Override protected void onStop() { super.onStop(); Log.d(TAG, "onStop called"); }
    @Override protected void onRestart() { super.onRestart(); Log.d(TAG, "onRestart called"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy called"); }
}
