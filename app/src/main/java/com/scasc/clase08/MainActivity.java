package com.scasc.clase08;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //variables
    private EditText etNombre,etApellido,etDireccion,etCiudad,etPais,etTelefono,etEmail,etCPostal;
    private Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etNombre=(EditText) findViewById(R.id.etNombre);
        etApellido=(EditText) findViewById(R.id.etApellido);
        etCiudad=(EditText) findViewById(R.id.etCiudad);
        etDireccion=(EditText) findViewById(R.id.etDireccion);
        etPais=(EditText) findViewById(R.id.etPais);
        etTelefono=(EditText) findViewById(R.id.etTelMovil);
        etEmail=(EditText) findViewById(R.id.etEmail);
        etCPostal=(EditText) findViewById(R.id.etCPostal);
        btnEnviar=(Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validar(etNombre) && validar(etApellido) && validar(etCiudad) && validar(etDireccion) && validar(etPais) && validar(etTelefono) && validar(etEmail)){
                    Toast.makeText(getApplicationContext(),"Registro exitoso",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean validar(EditText campo){
        //Verificar contenido del campo (Elemento view)
        if(campo.getText().toString().trim().isEmpty()) {
            campo.setError("Favor completar datos!");
            campo.requestFocus();
            return false;
        }else{
            return true;
        }
    }
}