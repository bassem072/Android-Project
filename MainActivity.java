package com.example.bassem.thebestway;

import android.app.ProgressDialog;
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

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button button;
    FirebaseAuth auth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();


    }



    public void buClick(View view) {
        edit1 = (EditText)findViewById(R.id.editText3);
        edit2 = (EditText)findViewById(R.id.editText4);
        button = (Button)findViewById(R.id.btn_login);
        String x = edit1.getText().toString();
        final String y = edit2.getText().toString();
        if(TextUtils.isEmpty(x)){
            Toast.makeText(getApplicationContext(), "Enter The Email Address", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(y)){
            Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.signInWithEmailAndPassword(x, y).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Toast.makeText(MainActivity.this, task.getException().toString(), Toast.LENGTH_LONG).show();

                }else {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    //Bundle b = new Bundle();
                    //b.putString("user", edit1.getText().toString());
                    //b.putString("pass", edit2.getText().toString());
                    intent.putExtra("user", edit1.getText().toString());
                    //intent.putExtra("pass", edit2.getText().toString());
                    startActivity(intent);
                }
            }
        });


    }

    public void buClick3(View view) {
        Intent intent = new Intent(MainActivity.this, Main3Activity.class);

        startActivity(intent);
    }
}
