package com.example.proyecto_aplicaciones_moviles;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnBebidas).setOnClickListener(v -> openCategory("Bebidas"));
        findViewById(R.id.btnDesayunos).setOnClickListener(v -> openCategory("Desayunos"));
        findViewById(R.id.btnComidas).setOnClickListener(v -> openCategory("Comidas"));
        findViewById(R.id.btnCenas).setOnClickListener(v -> openCategory("Cenas"));
        findViewById(R.id.btnPostres).setOnClickListener(v -> openCategory("Postres"));
        findViewById(R.id.btnPromociones).setOnClickListener(v -> openCategory("Promociones"));
        findViewById(R.id.cartButton).setOnClickListener(v -> sendCartByEmail());
    }

    private void openCategory(String category) {
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }

    private void sendCartByEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","orden@restaurante.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Mi Orden");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Aquí está mi orden...");
        startActivity(Intent.createChooser(emailIntent, "Enviar correo..."));
    }
}
