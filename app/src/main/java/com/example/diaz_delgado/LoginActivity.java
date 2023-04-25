package com.example.diaz_delgado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText User,Password;
    private SharedPreferences preferences;  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        referenciar();
        preferences = getSharedPreferences("Tienda_App",0);

        if(preferences.getBoolean("Logged",false)==true){
            Intent Login = new Intent(this,MainActivity.class);
            startActivity(Login);
            finish();
        }
    }

    private void referenciar(){
        User = findViewById(R.id.eduserlogin);
        Password = findViewById(R.id.edpasswordlogin);
    }

    public void clicLogin(View view){
        String PASS = "123456";
        String USER = "Fabian";

        String passUser = Password.getText().toString();
        String userUser = User.getText().toString();

        if (PASS.equals(passUser)&&USER.equals(userUser)) {
            Intent Login = new Intent(this,MainActivity.class);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("Logged",true);
            editor.apply();
            startActivity(Login);
            finish();
        } else {
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }
    }
}
