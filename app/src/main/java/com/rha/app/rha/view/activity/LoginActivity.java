package com.rha.app.rha.view.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.rha.app.rha.R;

public class LoginActivity extends Activity implements View.OnClickListener {
    private TextView txtSignIn, txtRegister, txtClickSignIn, txtClickRegister,txtCoupon;
    private View view_signin, view_register;
    private EditText sign_email, sign_password, register_email, register_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        initializeUI();
    }

    private void initializeUI() {
        txtRegister = (TextView) findViewById(R.id.txtRegister);
        txtRegister.setOnClickListener(this);
        txtSignIn = (TextView) findViewById(R.id.txtSignIn);
        txtSignIn.setOnClickListener(this);
        view_register = findViewById(R.id.view_register);
        view_signin = findViewById(R.id.view_signin);
        txtCoupon = (TextView) view_signin.findViewById(R.id.txtCoupon);
        txtCoupon.setOnClickListener(this);
        txtClickRegister = (TextView) view_register.findViewById(R.id.txtClickRegister);
        txtClickRegister.setOnClickListener(this);
        txtClickSignIn = (TextView) view_signin.findViewById(R.id.txtClickSignIn);
        txtClickSignIn.setOnClickListener(this);
        sign_email = (EditText) view_signin.findViewById(R.id.edtEmail);
        sign_password = (EditText) view_signin.findViewById(R.id.edtPassword);
        register_email = (EditText) view_register.findViewById(R.id.edtEmail);
        register_password = (EditText) view_register.findViewById(R.id.edtPassword);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.txtRegister) {
            view_register.setVisibility(View.VISIBLE);
            view_signin.setVisibility(View.GONE);
            txtRegister.setTextColor(Color.WHITE);
            txtSignIn.setTextColor(Color.parseColor("#bdb6b4"));
        } else if (i == R.id.txtSignIn) {
            view_signin.setVisibility(View.VISIBLE);
            view_register.setVisibility(View.GONE);
            txtSignIn.setTextColor(Color.WHITE);
            txtRegister.setTextColor(Color.parseColor("#bdb6b4"));
        } else if (i == R.id.txtClickRegister) {

            view_signin.setVisibility(View.VISIBLE);
            view_register.setVisibility(View.GONE);
        } else if (i == R.id.txtClickSignIn) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        }
        else if(i==R.id.txtCoupon)
        {
            showDialog();
        }
    }

    private void showDialog() {
        // create a Dialog component
        final Dialog dialog = new Dialog(LoginActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_referal_code);

        TextView txtSkip = (TextView) dialog.findViewById(R.id.dialog_skip);
        TextView txtSubmit = (TextView) dialog.findViewById(R.id.dialog_skip);

        txtSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }

        });
       txtSkip.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dialog.dismiss();
           }
       });
        dialog.show();

    }
        }


