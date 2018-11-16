package com.syahrul.pariwisatayogyakarta.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.syahrul.pariwisatayogyakarta.R;
import com.syahrul.pariwisatayogyakarta.presenter.PresenterLogin;
import com.syahrul.pariwisatayogyakarta.presenter.PresenterLoginImp;
import com.syahrul.pariwisatayogyakarta.view.ViewLogin;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, ViewLogin {

    private Button login;
    private EditText inEmail, inPass;
    private ProgressDialog pd;
    private String valEmail, valPass, statusLogin;
    private PresenterLogin presenterLogin;
    private TextView daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pd = new ProgressDialog(this);
        pd.setMessage("Harap Tunggu ...");
        pd.setTitle("Verifikasi Akun");
        pd.setCanceledOnTouchOutside(false);
        pd.setCancelable(false);

        login = findViewById(R.id.buttonLogin);
        inEmail = findViewById(R.id.editTextUsername);
        inPass = findViewById(R.id.editTextPassword);
        daftar = findViewById(R.id.textViewDaftar);

        login.setOnClickListener(this);
        daftar.setOnClickListener(this);

        presenterLogin = new PresenterLoginImp(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textViewDaftar :
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonLogin :
                pd.show();
                valEmail = inEmail.getText().toString();
                valPass = inPass.getText().toString();
                presenterLogin.cekLogin(valEmail, valPass);
                break;
        }
    }

    @Override
    public void showLoginSuccess(String text) {
        inEmail.getText().clear();
        inPass.getText().clear();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        Intent intentMain = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intentMain);
        finish();
        pd.dismiss();
    }

    @Override
    public void showLoginFailed(String text) {
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
