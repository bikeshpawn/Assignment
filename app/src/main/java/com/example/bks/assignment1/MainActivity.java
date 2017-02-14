package com.example.bks.assignment1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    Button b;
    EditText e1;
    EditText e2;
    EditText e3;
    EditText e4;
    EditText e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Onclicklistner();

    }

    public void Onclicklistner(){
        b=(Button)findViewById(R.id.button);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText1);
        e3=(EditText)findViewById(R.id.editText2);
        e4=(EditText)findViewById(R.id.editText3);
        e5=(EditText)findViewById(R.id.editText4);
        b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String username=e1.getText().toString();
                        String lastname=e2.getText().toString();
                       // int val = Integer.parseInt( e3.getText().toString());
                        String val=e3.getText().toString();
                        String address=e4.getText().toString();
                        String email=e5.getText().toString();



                        Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                        intent.putExtra("username", username);
                        intent.putExtra("lastname", lastname);
                        intent.putExtra("call", val);
                        intent.putExtra("address", address);
                        intent.putExtra("email",email);
                        startActivity(intent);
                    }
                }
        );
    }
}
