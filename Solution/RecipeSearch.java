import java.io.File;

import java.util.ArrayList;

import java.util.Scanner;

 

public class RecipeSearch {

 

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

 

        ArrayList<Recipe> recipes = new ArrayList<>();

        System.out.println("File to read:");

        String file = scanner.nextLine();

 

        try (Scanner fileReader = new Scanner(new File(file))) {

 

            // read recipes and ingredients

            while (fileReader.hasNextLine()) {

                // read a recipe and create an object to represent it

                String recipeName = fileReader.nextLine();

                int recipeTime = Integer.valueOf(fileReader.nextLine());

                Recipe recipe = new Recipe(recipeName, recipeTime);

 

                // add recipe to the list

                recipes.add(recipe);

 

                // add ingredients for the recipe

                while (fileReader.hasNextLine()) {

                    String ingredient = fileReader.nextLine();

 

                    // ingredients end with an empty line

                    if (ingredient.isEmpty()) {

                        // exit from this while loop

                        // (the outer loop is not exited)

                        break;

                    }

 

                    recipe.addIngredient(ingredient);

                }

 

            }

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }

 

        System.out.println("Commands:\n"

                + "list - lists the recipes\n"

                + "stop - stops the program\n"

                + "find name - searches recipes by name\n"

                + "find cooking time - searches recipes by cooking time\n"

                + "find ingredient - searches recipes by ingredient");

 

        while (true) {

            System.out.print("Enter command: ");

            String command = scanner.nextLine();

            if (command.equals("stop")) {

                break;

            }

 

            if (command.equals("list")) {

                System.out.println("Recipes:");

                for (Recipe recipe : recipes) {

                    System.out.println(recipe);

                }

            }

 

            if (command.equals("find name")) {

                System.out.print("Searched word: ");

                String searchedFor = scanner.nextLine();

                for (Recipe recipe : recipes) {

                    if (recipe.nameContains(searchedFor)) {

                        System.out.println(recipe);

                    }

                }

            }

 

            if (command.equals("find cooking time")) {

                System.out.print("Max cooking time: ");

                int max = Integer.valueOf(scanner.nextLine());

 

                for (Recipe recipe : recipes) {

                    if (recipe.cookingTimeAtMost(max)) {

                        System.out.println(recipe);

                    }

                }

            }

 

            if (command.equals("find ingredient")) {

                System.out.print("Ingredient: ");

                String ingredient = scanner.nextLine();

 

                for (Recipe recipe : recipes) {

                    if (recipe.containsIngredient(ingredient)) {

                        System.out.println(recipe);

                    }

                }

            }

        }

 

    }

 

}
