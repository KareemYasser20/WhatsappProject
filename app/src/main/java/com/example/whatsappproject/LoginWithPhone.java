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

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.concurrent.TimeUnit;

public class LoginWithPhone extends AppCompatActivity {

    private EditText Phonenumber;
    private Button next;
//    String number;
//    private String PhoneVerviectionid;
////    private PhoneAuthProvider.OnVerificationStateChangedCallbacks verificationCallbacks;
//    private PhoneAuthProvider.ForceResendingToken resendingToken;
    CountryCodePicker ccp;

  private   FirebaseAuth mAuth = FirebaseAuth.getInstance();

    String Codesent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_phone);

        Phonenumber = findViewById(R.id.Phone_number);
        next=findViewById(R.id.Next_btn);
        ccp=findViewById(R.id.Countery_code);
        ccp.registerCarrierNumberEditText(Phonenumber);
        ccp.registerCarrierNumberEditText(Phonenumber);
        ccp.setNumberAutoFormattingEnabled(true);
        ccp.setFullNumber("");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Toast.makeText(LoginWithPhone.this, "the number is" + ccp.getFormattedFullNumber(), Toast.LENGTH_LONG).show();

//                ShowConfirmnumberDialog();
                SendVerifcationcode();

            }
        });
    }

    private void SendVerifcationcode() {

        Toast.makeText(this, "number send" +  ccp.getFormattedFullNumber(), Toast.LENGTH_SHORT).show();

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                ccp.getFormattedFullNumber(),        // Phone number to verify
                60,                              // Timeout duration
                TimeUnit.SECONDS,                  // Unit of timeout
                this,                      // Activity (for callback binding)
                mCallbacks);                     // OnVerificationStateChangedCallbacks



    }


    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            Toast.makeText(LoginWithPhone.this, "onVerificationCompleted", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

            Toast.makeText(LoginWithPhone.this, "onVerificationFailed" + e  , Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            Codesent = s;

            Toast.makeText(LoginWithPhone.this, "Code sent " + Codesent, Toast.LENGTH_SHORT).show();

        }
    };

//    private void ShowConfirmnumberDialog() {
//        final Dialog dialog=new Dialog(this);
//        dialog.setContentView(R.layout.confirm_number_dialog);
//        TextView phoneenterd = findViewById(R.id.number_entered);
//        TextView Okbuttton = findViewById(R.id.Ok_choice);
//        TextView editbutton = findViewById(R.id.edit_choice);
//
//        phoneenterd.setText(ccp.getFormattedFullNumber());
//
//        Toast.makeText(this, "" + Phonenumber.getText().toString(), Toast.LENGTH_SHORT).show();
//
//
//       dialog.show();
//
//
//    }


}
