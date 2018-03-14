package com.example.bassem.thebestway;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main3Activity extends AppCompatActivity {
    EditText edit3, edit4;
    Button button;
    FirebaseAuth auth;
    //ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        auth = FirebaseAuth.getInstance();
    }

    public void buClick1(View view) {
        edit3 = (EditText)findViewById(R.id.editText5);
        edit4 = (EditText)findViewById(R.id.editText7);

        button = (Button)findViewById(R.id.btn_login);
        String a = edit3.getText().toString();
        final String b = edit4.getText().toString();
        if(TextUtils.isEmpty(a)){
            Toast.makeText(getApplicationContext(), "Enter The Email Address", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(b)){
            Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.createUserWithEmailAndPassword(a, b).addOnCompleteListener(Main3Activity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Toast.makeText(Main3Activity.this, task.getException().toString(), Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                    //Bundle b = new Bundle();
                    //b.putString("user", edit1.getText().toString());
                    //b.putString("pass", edit2.getText().toString());
                    intent.putExtra("user", edit3.getText().toString());
                    //intent.putExtra("pass", edit4.getText().toString());
                    startActivity(intent);
                }
            }
        });


    }
}

