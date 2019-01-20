package model;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String name;
    private String description;
    private List<String> ingredients;
    private String recipe;

    public Dish(String name) {
        this.name = name;
        this.description = "";
        this.ingredients = new ArrayList<>();
        this.recipe = "";
    }

    public Dish(String name, String description, List<String> ingredients, String recipe) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }
}
