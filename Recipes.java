
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Recipes {

    private String recipeName;
    private int cookingTime;
    private ArrayList<String> ingredients;
    RecipesBook recipesList = new RecipesBook();

    public Recipes() {

    }

    public Recipes(String recipeName, int cookingTime, ArrayList<String> ingredients) {
        this.recipeName = recipeName;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
    }

    public void list() {
        recipesList.printRecipesBook();
    }
    
        public void findRecipeByName(String name) {
           recipesList.searchRecipeByName(name);
            
    }
        public void findRecipeByTime (int time) {
            recipesList.searchRecipeByTime(time);
        }
        
        public void findRecipeByIngredient (String ingredient) {
            recipesList.searchRecipeByIngredient(ingredient);
        }
        
    

   public void fileToRecipeBook(String recipe) {
        System.out.println("");

        try (Scanner scanner = new Scanner(Paths.get(recipe))) {

            ArrayList<String> fileLines = new ArrayList<>();

            while (scanner.hasNextLine()) {

                String row = scanner.nextLine();

                if (row.equals("") || !(scanner.hasNext())) {
                    //store first string as name
                    String name = fileLines.get(0);
                    // store second int as cooking time
                    int time = Integer.valueOf(fileLines.get(1));
                    // store ingredients in ArrayList
                    ArrayList<String> ingredientList = new ArrayList<>();

                    for (int i = 2; i < fileLines.size(); i++) {
                        ingredientList.add(fileLines.get(i));
                    }

                    // add the created Recipes object in the recipeList ArrayList of Recipes objects
                    recipesList.addRecipe(new Recipes(name, time, ingredientList));

                    //remove content from ArrayList
                    fileLines.removeAll(fileLines);

                } else {
                    fileLines.add(row);

                }

            }

            //should scanner be closed?
            
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

   public String getRecipeName () {
       return this.recipeName;
   }
   
   public int getCookingTime () {
       return this.cookingTime;
   }

   public ArrayList getIngredient() {
       return this.ingredients;
   }

    @Override
    public String toString() {
        return this.recipeName + ", cooking time: " + this.cookingTime;
    }

}
