package com.example.pj_v;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;
import java.util.zip.GZIPInputStream;

public class MainActivity extends AppCompatActivity {
EditText txt_tema;
EditText txt_precio;
Spinner spin1;
Button btnGuardar;

    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase= FirebaseDatabase.getInstance().getReference("Compras");

        txt_tema=(EditText)findViewById(R.id.txt_tema);
        txt_precio=(EditText)findViewById(R.id.txt_precio);
        spin1=(Spinner)findViewById(R.id.spin1);
        btnGuardar=(Button)findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Guardar();
            }

        });

}
    public void Guardar(){

        String tema=txt_tema.getText().toString();
        String cantidad=txt_precio.getText().toString();
        if (!TextUtils.isEmpty(tema)){
            String id = mDatabase.push().getKey();
            Clases leccion=new Clases(id,tema,cantidad);
            mDatabase.child("Lista").child(id).setValue(leccion);

            Toast.makeText(this,"Lista Guardada",Toast.LENGTH_LONG).show();


        }else{
            Toast.makeText(this,"Lista no Guardada",Toast.LENGTH_LONG).show();


        }
    }
}