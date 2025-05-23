package com.example.proyecto_aplicaciones_moviles;
public class Article {
    private int id;
    private String name;
    private String category;
    private double price;
    private String emoji;

    // Constructor completo
    public Article(int id, String name, String category, double price, String emoji) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.emoji = emoji;
    }

    // ✅ Constructor para cargar artículos rápido (como en CategoryActivity)
    public Article(String name, String emoji) {
        this.name = name;
        this.emoji = emoji;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
