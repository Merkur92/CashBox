package pe.qwando.cashbox.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pe.qwando.cashbox.R;
import pe.qwando.cashbox.models.User;
import pe.qwando.cashbox.repositories.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = RegisterActivity.class.getSimpleName();

    TextInputEditText inputNombres, inputApellidos, inputEmail, inputPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        inputNombres = findViewById(R.id.inputNombresRegister);
        inputApellidos = findViewById(R.id.inputApellidosRegister);
        inputEmail = findViewById(R.id.inputEmailRegister);
        inputPassword = findViewById(R.id.inputPasswordRegister);
        btnRegister = findViewById(R.id.btnRegistrar);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        try{
            String nombres = inputNombres.getText().toString();
            String apellidos = inputApellidos.getText().toString();
            String email = inputEmail.getText().toString();
            String password = inputPassword.getText().toString();
            if (nombres.isEmpty() || apellidos.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Por favor completar todo los datos.", Toast.LENGTH_LONG).show();
                return;
            }
            User u = UserRepository.save(this, nombres, apellidos, email, password);
            Toast.makeText(this, "Registro completo: " + u.toString(), Toast.LENGTH_LONG).show();
        } catch (Exception e){
            Log.e(TAG, e.toString(), e);
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    private void routerRegisterToLogin() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }


}
