package com.syahrul.pariwisatayogyakarta.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.syahrul.pariwisatayogyakarta.R;
import com.syahrul.pariwisatayogyakarta.presenter.PresenterDaftar;
import com.syahrul.pariwisatayogyakarta.presenter.PresenterDaftarImp;
import com.syahrul.pariwisatayogyakarta.view.ViewDaftar;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, ViewDaftar {

    private Button register;
    private EditText inEmail, inPass;
    private ProgressDialog pd;
    private String valEmail, valPass, statusLogin;

    private PresenterDaftar presenterDaftar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = findViewById(R.id.buttonRegister);
        inEmail = findViewById(R.id.editTextUsername);
        inPass = findViewById(R.id.editTextPassword);

        presenterDaftar = new PresenterDaftarImp(this);
        pd = new ProgressDialog(this);
        pd.setMessage("Harap Tunggu ...");
        pd.setTitle("Verifikasi Akun");
        pd.setCanceledOnTouchOutside(false);
        pd.setCancelable(false);

        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        pd.show();
        valEmail = inEmail.getText().toString();
        valPass = inPass.getText().toString();
        presenterDaftar.registrasi(valEmail, valPass);
    }

    @Override
    public void showDaftarnSuccess(String text) {
        inEmail.getText().clear();
        inPass.getText().clear();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        Intent intentMain = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intentMain);
        finish();
        pd.dismiss();
    }

    @Override
    public void showDaftarFailed(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        pd.dismiss();
    }

    @Override
    public void showValidationError(String field) {
        pd.dismiss();

        if (field.equals("inEmail")){
            inEmail.setError("Email Tidak Boleh Kosong");
        }else if(field.equals("inPass")){
            inPass.setError("Password Tidak Boleh Kosong");
        }
    }
}
