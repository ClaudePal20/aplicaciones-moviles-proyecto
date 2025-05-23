package com.example.proyecto_aplicaciones_moviles;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

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
        findViewById(R.id.cartButton).setOnClickListener(v -> {
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
        });

    }

    private void openCategory(String category) {
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }

    private void sendCartByEmail() {
        List<Article> cartItems = CartManager.getInstance().getCartItems();

        if (cartItems.isEmpty()) {
            Toast.makeText(this, "El carrito está vacío.", Toast.LENGTH_SHORT).show();
            return; // Don't continue if cart is empty
        }

        StringBuilder orderSummary = new StringBuilder("Mi orden:\n\n");
        for (Article article : cartItems) {
            orderSummary.append("- ").append(article.getEmoji()).append(" ").append(article.getName()).append("\n");
        }

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", "orden@restaurante.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Mi Orden");
        emailIntent.putExtra(Intent.EXTRA_TEXT, orderSummary.toString());

        startActivity(Intent.createChooser(emailIntent, "Enviar correo..."));
    }


}
