package com.example.marcosmoreno;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ImageView logo = findViewById(R.id.logo);
        TextView appName = findViewById(R.id.appName);
        TextInputLayout username = findViewById(R.id.usernameInput);
        TextInputLayout password = findViewById(R.id.passwordInput);
        TextView gotAccount = findViewById(R.id.gotAccount);
        Button enterButton = findViewById(R.id.LogIn);


        gotAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registro.this, Acceso.class);
                Pair[] pairs = new Pair[6];
                pairs[0] = new Pair<View, String>(logo, "logo");
                pairs[1] = new Pair<View, String>(appName, "appName");
                pairs[2] = new Pair<View, String>(username, "username");
                pairs[3] = new Pair<View, String>(password, "password");
                pairs[4] = new Pair<View, String>(gotAccount, "gotAccount");
                pairs[5] = new Pair<View, String>(enterButton, "enterButton");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Registro.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    public void openMain(View view) {
        Toast toast = Toast.makeText(Registro.this, "Entrar al Main", Toast.LENGTH_LONG);
        toast.show();
    }
    public void goToLogin(View view){
        Intent nIntent = new Intent(Registro.this, Acceso.class);
        startActivity(nIntent);
    }
}