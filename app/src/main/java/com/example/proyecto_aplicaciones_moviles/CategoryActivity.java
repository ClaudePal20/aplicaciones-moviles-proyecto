package com.example.proyecto_aplicaciones_moviles;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    private List<Article> articleList;

    @Override
    public boolean onSupportNavigateUp() {
        finish();  // Termina esta actividad y vuelve a la anterior
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // Configurar el ActionBar con botón "back"
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getIntent().getStringExtra("category"));  // Opcional, título dinámico
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        articleList = new ArrayList<>();
        adapter = new ArticleAdapter(articleList);
        recyclerView.setAdapter(adapter);

        String category = getIntent().getStringExtra("category");
        loadArticles(category);
    }


    private void loadArticles(String category) {
        articleList.clear();  // Vacía la lista existente

        switch (category) {
            case "Bebidas":
                articleList.add(new Article("", ""));
                articleList.add(new Article("Coca Cola", "🥤"));
                articleList.add(new Article("Jugo de Naranja", "🍊"));
                break;

            case "Desayunos":
                articleList.add(new Article("", ""));
                articleList.add(new Article("Huevos Revueltos", "🍳"));
                articleList.add(new Article("Panqueques", "🥞"));
                articleList.add(new Article("Tostadas", "🍞"));
                articleList.add(new Article("Café", "☕"));
                articleList.add(new Article("Fruta", "🍉"));
                break;

            case "Comidas":
                articleList.add(new Article("", ""));
                articleList.add(new Article("Hamburguesa", "🍔"));
                articleList.add(new Article("Pizza", "🍕"));
                articleList.add(new Article("Sushi", "🍣"));
                articleList.add(new Article("Ensalada", "🥗"));
                articleList.add(new Article("Tacos", "🌮"));

            case "Cenas":
                articleList.add(new Article("", ""));
                articleList.add(new Article("Pasta Alfredo", "🍝"));
                articleList.add(new Article("Pollo Asado", "🍗"));
                articleList.add(new Article("Sopa de Tomate", "🥣"));
                articleList.add(new Article("Sandwich", "🥪"));
                articleList.add(new Article("Filete", "🥩"));

            case "Postres":
                articleList.add(new Article("", ""));
                articleList.add(new Article("Pastel de Chocolate", "🍫"));
                articleList.add(new Article("Helado de Vainilla", "🍨"));
                articleList.add(new Article("Pay de Manzana", "🥧"));
                articleList.add(new Article("Galletas", "🍪"));
                articleList.add(new Article("Flan", "🍮"));
                break;

            case "Promociones":
                articleList.add(new Article("", ""));
                articleList.add(new Article("2x1 en Pizzas", "🔥"));
                articleList.add(new Article("Bebida Gratis", "🥤"));
                articleList.add(new Article("Postre Incluido", "🍰"));
                articleList.add(new Article("Descuento 20%", "💸"));
                articleList.add(new Article("Combo Especial", "🎁"));
                break;

        }
        adapter.notifyDataSetChanged();  // Notifica al adapter del cambio
    }

}
