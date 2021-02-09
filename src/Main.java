import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*double guaranteedRewards = 10;
        for (int i = 0; i < guaranteedRewards; i++) {
            System.out.println(i);
        }*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Recipes");

        List<String> rawRecipes = new ArrayList<>();

        boolean looking = false;
        String n = scanner.nextLine();
        rawRecipes.add(n);
        //System.out.println(n);
        looking = true;
        while (looking) {
            if (scanner.hasNext()) {
                String s = scanner.nextLine();
                if (s.equalsIgnoreCase("END")) {
                    looking = false;
                    rawRecipes.add(s);
                    break;
                }
                rawRecipes.add(s);
            } else {
                looking = false;
                break;
            }

        }

        boolean recipeComplete = false;

        boolean workingOnRecipe = false;
        int recipeLine = 0;

        String recipeName = "";
        String material_1 = "";
        String material_2 = "";
        String material_3 = "";
        String material_4 = "";
        String material_5 = "";
        String material_6 = "";
        String material_7 = "";
        String material_8 = "";
        String material_9 = "";

        HashMap<String, String> ingredients = new HashMap<>();

        for (String s : rawRecipes) {
            //System.out.println("Check: " + s + " Length: " + s.length());
            /*if (recipeComplete) {
                System.out.println("ShapedRecipe " + recipeName + " = new ShapedRecipe(" + recipeName + ");");
                System.out.println(recipeName + ".shape(\"" + material_1 + material_2 + material_3 + "\", \"" + material_4 + material_5 + material_6 + "\",\"" + material_7 + material_8 + material_9 + "\");");
                for (Map.Entry<String, String> e : ingredients.entrySet()) {
                    System.out.println(recipeName + ".setIngredient('" + e.getKey() + "', Material.matchMaterial(" + e.getValue() + ");");
                }
                continue;
            }*/
            if (s.length() == 0) {
                continue;
            }
            if (s.startsWith("Recipe: ") || s.equals("END")) {
                // New Recipe
                if (workingOnRecipe) {
                    // Last Recipe Completed
                    // COMPILE CODE
                    System.out.println("ShapedRecipe " + recipeName + " = new ShapedRecipe(itemManager.getItem(\n" + recipeName + "\n));");
                    System.out.println(recipeName + ".shape(\"" + material_1 + material_2 + material_3 + "\", \"" + material_4 + material_5 + material_6 + "\",\"" + material_7 + material_8 + material_9 + "\");");
                    for (Map.Entry<String, String> e : ingredients.entrySet()) {
                        System.out.println(recipeName + ".setIngredient('" + e.getKey() + "', Material.matchMaterial(\"" + e.getValue() + "\");");
                    }

                    System.out.println("\n");

                }
                if (!s.equals("END")) {
                    recipeName = s.replace("Recipe: ", "").replace(" ", "");
                    //System.out.println("Recipe NAME: " + recipeName);
                    workingOnRecipe = true;
                    continue;
                }
            }
            if (recipeLine < 3) {
                recipeLine++;

                String[] items = s.split(" ");
                if (recipeLine == 1) {
                    material_1 = items[0];
                    material_2 = items[1];
                    material_3 = items[2];
                } else if (recipeLine == 2) {
                    material_4 = items[0];
                    material_5 = items[1];
                    material_6 = items[2];
                } else if (recipeLine == 3) {
                    material_7 = items[0];
                    material_8 = items[1];
                    material_9 = items[2];
                }

            } else {
                // Ingredients Finished

                //System.out.println(s);

                String[] ingKey = s.replace(" =", "").split(" ");
                if (ingKey.length == 2) {
                    ingredients.put(ingKey[0], ingKey[1]);
                }



            }
        }

    }

}
