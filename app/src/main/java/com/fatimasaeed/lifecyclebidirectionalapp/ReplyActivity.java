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

public class ReplyActivity extends Activity {
    private static final String TAG = "LifecycleReply";
    private EditText replyInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);
        Log.d(TAG, "onCreate called");

        TextView receivedMessage = findViewById(R.id.receivedMessage);
        replyInput = findViewById(R.id.replyInput);
        Button replyButton = findViewById(R.id.replyButton);

        String message = getIntent().getStringExtra("message_from_main");
        receivedMessage.setText("Message received: " + (message == null ? "" : message));

        replyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reply = replyInput.getText().toString().trim();
                if (reply.isEmpty()) {
                    Toast.makeText(ReplyActivity.this, "Please enter a reply", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent result = new Intent();
                result.putExtra("reply_from_second", reply);
                setResult(RESULT_OK, result);
                finish();
            }
        });
    }

    @Override protected void onStart() { super.onStart(); Log.d(TAG, "onStart called"); }
    @Override protected void onResume() { super.onResume(); Log.d(TAG, "onResume called"); }
    @Override protected void onPause() { super.onPause(); Log.d(TAG, "onPause called"); }
    @Override protected void onStop() { super.onStop(); Log.d(TAG, "onStop called"); }
    @Override protected void onRestart() { super.onRestart(); Log.d(TAG, "onRestart called"); }
    @Override protected void onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy called"); }
}
