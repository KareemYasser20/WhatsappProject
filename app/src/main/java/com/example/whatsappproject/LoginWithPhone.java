package com.example.whatsappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

public class LoginWithPhone extends AppCompatActivity {

    private EditText Phonenumber;
    private Button next;
    String number;
    private String PhoneVerviectionid;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks verificationCallbacks;
    private PhoneAuthProvider.ForceResendingToken resendingToken;
    private FirebaseAuth auth;
    CountryCodePicker ccp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_phone);

        Phonenumber = findViewById(R.id.Phone_number);
        next=findViewById(R.id.Next_btn);
        ccp=findViewById(R.id.Countery_code);
        ccp.registerCarrierNumberEditText(Phonenumber);
        auth=FirebaseAuth.getInstance();
        ccp.registerCarrierNumberEditText(Phonenumber);
        ccp.setNumberAutoFormattingEnabled(true);
        ccp.setFullNumber("");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginWithPhone.this, "the number is" + ccp.getFormattedFullNumber(), Toast.LENGTH_LONG).show();

                ShowConfirmnumberDialog();

            }
        });
    }

    private void ShowConfirmnumberDialog() {
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.confirm_number_dialog);
        TextView phonenumber = findViewById(R.id.number_entered);
        TextView Okbuttton = findViewById(R.id.Ok_choice);
        Button editbutton = findViewById(R.id.edit_choice);

            String phone = "+201092665188";
        SpannableStringBuilder ssb = new SpannableStringBuilder(phone);
        ssb.clear();
        ssb.append(ccp.getFormattedFullNumber());
        Phonenumber.setText(ssb);

        Toast.makeText(this, "" + Phonenumber.getText().toString(), Toast.LENGTH_SHORT).show();

        editbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginWithPhone.this, "Edieeeeeeeeeeeeeeeeeeeeeeeettttttttttttt", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
       dialog.show();


    }


}
