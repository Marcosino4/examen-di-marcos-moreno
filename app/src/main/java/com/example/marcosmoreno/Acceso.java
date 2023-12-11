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

public class Acceso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        ImageView logo = findViewById(R.id.logo);
        TextView appName = findViewById(R.id.appName);
        TextInputLayout username = findViewById(R.id.usernameInput);
        TextInputLayout password = findViewById(R.id.passwordInput);
        CheckBox remember = findViewById(R.id.remember);
        TextView gotAccount = findViewById(R.id.noAccount);
        Button enterButton = findViewById(R.id.LogIn);
        TextView forgotPassword = findViewById(R.id.forgotAccount);




        gotAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Acceso.this, Registro.class);
                Pair[] pairs = new Pair[8];
                pairs[0] = new Pair<View, String>(logo, "logo");
                pairs[1] = new Pair<View, String>(appName, "appName");
                pairs[2] = new Pair<View, String>(username, "username");
                pairs[3] = new Pair<View, String>(password, "password");
                pairs[4] = new Pair<View, String>(remember, "remember");
                pairs[5] = new Pair<View, String>(gotAccount, "gotAccount");
                pairs[6] = new Pair<View, String>(enterButton, "LogIn");
                pairs[7] = new Pair<View, String>(forgotPassword, "forgotPassword");


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Acceso.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }
            }
        });

        forgotPassword.setOnClickListener(view -> {
            new AlertDialog.Builder(this)
                    .setTitle("¿Olvidaste tu contraseña?")
                    .setMessage("Te hemos enviado un correo para que la recuperes")
                    //.setView(taskEditText)

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton(android.R.string.search_go, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        });
    }

    public void openMain(View view) {
        Toast toast = Toast.makeText(Acceso.this, "Entrar al Main", Toast.LENGTH_LONG);
        toast.show();
    }
    public void goToRegister(View view){
        Intent nIntent = new Intent(Acceso.this, Registro.class);
        startActivity(nIntent);
    }
}