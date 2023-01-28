package com.example.lab2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private CheckBox checkbox1;
    private CheckBox checkbox2;
    private RadioGroup paymentMethod;
    private NumberPicker numberPicker;
    private ProgressBar progressBar;
    private int totalPay = 0;
    public static final String key1="product";
    public static final String key2="method";
    public static final String key3="amount";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkbox1= (CheckBox) findViewById(R.id.checkbox1);
        checkbox2= (CheckBox) findViewById(R.id.checkbox2);
        paymentMethod = (RadioGroup) findViewById(R.id.group);
        numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        numberPicker.setMinValue(10);
        numberPicker.setMaxValue(1000);
        progressBar.setMax(10000);
    }
    public void ButtonPressed (View view){
        String product="";
//        Toast.makeText(this,"Pay what you buy",Toast.LENGTH_LONG).show();
        if (checkbox1.isChecked()) {
            product=(String)checkbox1.getText();
        }
        if (checkbox2.isChecked()) {
            product+=(String)checkbox2.getText();
        }
//        Toast.makeText(this,"You buy the following products"+product,Toast.LENGTH_LONG).show();
        int radioId = paymentMethod.getCheckedRadioButtonId();//بتجيب الايدي للراديو بوتون المختار
        String method="";
        if (radioId == R.id.radio1){
            method = "PayPal";
        }
        else if(radioId == R.id.radio2){
            method = "Credit Card";
        }
        else{
            method = "Direct";
        }
//        Toast.makeText(this,"You pay with the method"+method,Toast.LENGTH_LONG).show();
        int amount = numberPicker.getValue();
        Toast.makeText(this,"Pay Pressed! with amount " + amount + ", method: " + method+", products: "+product,Toast.LENGTH_LONG).show();
        totalPay = totalPay + amount;
        progressBar.setProgress(totalPay);
        Toast.makeText(this,"Current total " + totalPay,Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,MainActivity2.class);
        intent.putExtra(key1,product);
        intent.putExtra(key2,method);
        intent.putExtra(key3,""+amount);
        startActivity(intent);
    }
}