package com.example.bassem.thebestway;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=(TextView)findViewById(R.id.textView);
        //Bundle c = getIntent().getExtras();
        String username = getIntent().getExtras().getString("user");
        textView.setText("Welcome\n" + username);
    }
}
