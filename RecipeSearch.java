
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        
        Recipes recipes = new Recipes();
        Scanner scanner = new Scanner(System.in);
        
        UserInterface ui = new UserInterface ( recipes, scanner);
        ui.start();
    }

}
