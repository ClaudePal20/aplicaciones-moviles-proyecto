package com.example.proyecto_aplicaciones_moviles;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
public class CartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Habilita botón de regresar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Carrito");
        }

        TextView cartTextView = findViewById(R.id.cartTextView);

        List<Article> cartItems = CartManager.getInstance().getCartItems();
        if (cartItems.isEmpty()) {
            cartTextView.setText("Tu carrito está vacío.");
        } else {
            StringBuilder sb = new StringBuilder("Tu orden:\n\n");
            for (Article item : cartItems) {
                sb.append("- ").append(item.getEmoji()).append(" ").append(item.getName()).append("\n");
            }
            cartTextView.setText(sb.toString());
        }
        Button btnComprar = findViewById(R.id.btnComprar);
        btnComprar.setOnClickListener(v -> {
            DBHelper dbHelper = new DBHelper(CartActivity.this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            List<Article> cartItemsList = CartManager.getInstance().getCartItems();

            if (cartItemsList.isEmpty()) {
                Toast.makeText(this, "No hay artículos para comprar.", Toast.LENGTH_SHORT).show();
                return;
            }

            for (Article article : cartItemsList) {
                db.execSQL("INSERT INTO cart (item_id) VALUES (?)", new Object[]{article.getId()});
            }

            CartManager.getInstance().clearCart();
            cartTextView.setText("Gracias por tu compra. Tu pedido ha sido guardado.");
            Toast.makeText(this, "Compra realizada con éxito.", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // vuelve a la pantalla anterior
        return true;
    }
}
