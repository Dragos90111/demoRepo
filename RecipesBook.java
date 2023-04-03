
import java.util.ArrayList;


public class RecipesBook {
    
    private ArrayList <Recipes> recipes;
    
    public RecipesBook() {
        this.recipes = new ArrayList<>();
    }
    
    public void addRecipe (Recipes recipe) {
        this.recipes.add(recipe);
    }
    
    
    public void printRecipesBook() {
        for (Recipes e: this.recipes) {
            System.out.println(e);
        }
    }
    
    
    public void searchRecipeByName(String name) {
        for (Recipes e: this.recipes) {
            if (e.getRecipeName().contains(name)) {
                System.out.println(e);
            }
        }
        
    }
    
    public void searchRecipeByTime (int time) {
        for (Recipes e: this.recipes){
            if (e.getCookingTime() <= time) {
                System.out.println(e);
            }
        }
    }
    
    public void searchRecipeByIngredient (String ingredient) {
        for (Recipes e: this.recipes ) {
            if (e.getIngredient().contains(ingredient)) {
                System.out.println(e);
            }


        }
    }
    
    
}
