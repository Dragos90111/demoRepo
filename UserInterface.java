
import java.util.Scanner;

public class UserInterface {

    private Recipes recipes;
    private Scanner scanner;

    public UserInterface(Recipes recipes, Scanner scanner) {
        this.recipes = recipes;
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("File to read: ");
        String fileName = scanner.nextLine();
        recipes.fileToRecipeBook(fileName);
        
        Loop:
        while (true) {
            System.out.println("Commands:" + "\n" + "list - lists the recipes"
                    + "\n" + "stop - stops the program"
                    + "\n" + "find name - searches recipes by name"
                    + "\n" + "find cooking time - searches recipes by cooking time"
                    + "\n" + "find ingredient - searches ripces by ingredient");
            System.out.println("Enter command: ");
            String command = scanner.nextLine();
            switch (command) {
                case "list":
                    recipes.list();
                    break;
                case "find name":
                    System.out.println("Searched word:");
                    String searched = scanner.nextLine();
                    recipes.findRecipeByName(searched);
                    break;
                case "find cooking time":
                    System.out.println("Max cooking time:");
                    int maxCooking = Integer.valueOf(scanner.nextLine());
                    recipes.findRecipeByTime(maxCooking);
                    break;
                case "find ingredient":
                    System.out.println("Ingredient:");
                    String ingredient  = scanner.nextLine();
                    recipes.findRecipeByIngredient(ingredient);
                    break;
                case "stop":
                    break Loop;
                default:
                    System.out.println("No such command");
                    break;
            }
        }

    }

}
