package com.example.prateekbajaj.opencv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button b,b1,b2,b3,b4,b5,b6;
Intent i=new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b=(Button)findViewById(R.id.bg);
        b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button4);
        b3=(Button)findViewById(R.id.button5);
        i=new Intent(MainActivity.this,original_image.class);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i.putExtra("key","1");
              startActivity(i);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            i.putExtra("key","2");
                startActivity(i);
            }
        });
    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            i.putExtra("key","3");
                    startActivity(i);
        }
    });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("key",4);
                startActivity(i);
            }
        });
    }
}
