package com.example.lab2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity2 extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView1=(TextView) findViewById(R.id.tvv1);
        textView2=(TextView) findViewById(R.id.tvv2);
        textView3=(TextView) findViewById(R.id.tvv3);
        Intent intent=getIntent();
        String t1=intent.getStringExtra(MainActivity.key1);
        String t2=intent.getStringExtra(MainActivity.key2);
        String t3=(intent.getStringExtra(MainActivity.key3));
        textView1.setText(t1);
        textView2.setText(t3);
        textView3.setText(t2);
    }
}