package com.example.ordering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity = 1;
    private String addresses = "owaissbashir26@gmail.com";
    private String subject = "order";
    private Object String;
    boolean whippingcream;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setText("helllllllo");
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        String a;
        int price = quantity * 5;
        if (whippingcream = true) {
            Log.v("MainActivity", "in if");
            price += 2 * quantity;
        }
        String pr = java.lang.String.valueOf(price);
        Log.v("MainActivity", pr);
        EditText text = findViewById(R.id.name);
        String name = text.getText().toString();

        a = checkout(quantity, price, name);

        Log.v("MainActivity",a);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "owaissbashir26@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT,a);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }


    public void increment(View view) {

        quantity = quantity + 1;
        display(quantity);
        displayprice(quantity * 5);


    }


    public void decrement(View view) {
        if (quantity > 0) {
            quantity = quantity - 1;


            display(quantity);
            displayprice(quantity * 5);
        }

    else

    {
        Toast.makeText(this, "cannot have less than 1", Toast.LENGTH_LONG).show();
    }

}
    private void display(int i) {
        TextView quantities = findViewById(R.id.quantityno);
        quantities.setText("" + i);

    }

    private void displayprice(int i) {
        TextView quantities = findViewById(R.id.price);
        quantities.setText("" + i);


    }

    private String checkout(int quantity, int i, java.lang.String name) {
        TextView quantities = findViewById(R.id.finish);
        quantities.setText(name+"You have ordered " + quantity + " cups of tea " + " and your balance is " + i);
        String a = "You have ordered " + quantity;
        return (a);

    }

    public void checkboxclick(View view) {
        Boolean checked1 = ((CheckBox) view).isChecked();
        String s1 = Boolean.toString(checked1);
        Log.v("MainActivity", s1);
        if (checked1==true) {
            boolean whippingcream = true;
            Log.v("MainActivity","first if");
        }
    }
}