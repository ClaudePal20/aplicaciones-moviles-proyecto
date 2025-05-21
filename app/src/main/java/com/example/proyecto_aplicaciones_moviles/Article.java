package com.example.proyecto_aplicaciones_moviles;
public class Article {
    private String name;
    private String emoji;

    public Article(String name, String emoji) {
        this.name = name;
        this.emoji = emoji;
    }

    public String getName() {
        return name;
    }

    public String getEmoji() {
        return emoji;
    }
}
