package com.example.whatsappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t = findViewById(R.id.Privacy_tv);
        String text = "Read our Privacy Policy. Tap \" Agree and continue\" to" +
                "        \n                        accept the Terms of Service.";
        SpannableString ss = new SpannableString(text);
        ForegroundColorSpan fcsbabyblue = new ForegroundColorSpan(Color.rgb(52 , 183 , 241));
        ForegroundColorSpan fcsblue = new ForegroundColorSpan(Color.rgb(52 , 183 , 241));

        ss.setSpan(fcsbabyblue ,8 , 23 , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        ss.setSpan(fcsblue ,97, 113 , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        t.setText(ss);

        Button Agree_button = findViewById(R.id.Agree_btn_homepage);
        Agree_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(MainActivity.this , LoginWithPhone.class);
                startActivity(login);
            }
        });

    }
}
