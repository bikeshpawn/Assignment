package com.example.bks.assignment1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.service.chooser.ChooserTarget;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    String name2;
    Intent i=null, chooser=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ChangeTextLister();
        CallingOn();
        GoogleMap();
    }

    public void ChangeTextLister() {
        t1 = (TextView) findViewById(R.id.textView6);
        t2 = (TextView) findViewById(R.id.textView7);
        t3 = (TextView) findViewById(R.id.textView8);
        t4 = (TextView) findViewById(R.id.textView9);
        t5 = (TextView) findViewById(R.id.textView10);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        String name1 = intent.getStringExtra("lastname");
        name2 = intent.getStringExtra("call");
        String name3 = intent.getStringExtra("address");
        String name4 = intent.getStringExtra("email");
        t1.setText(name);
        t2.setText(name1);
        t3.setText(name2);
        t4.setText(name3);
        t5.setText(name4);

    }

    public void CallingOn() {
        t3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent apple = new Intent(Intent.ACTION_CALL);
                        apple.setData(Uri.parse("tel:" + t3.getText()));
                        if (ActivityCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        startActivity(apple);



                    }
                }
        );
    }

    public void GoogleMap(){

        t4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse("geo:27.671498,85.438391"));
                        chooser=Intent.createChooser(i,"Location");
                        startActivity(chooser);
                    }
                }
        );
    }
}
