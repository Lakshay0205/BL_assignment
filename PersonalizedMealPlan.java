import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getName();
    List<String> getRecipes();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getName() {
        return "Vegetarian Meal";
    }

    @Override
    public List<String> getRecipes() {
        List<String> recipes = new ArrayList<>();
        recipes.add("Vegetable Curry");
        recipes.add("Spinach and Ricotta Stuffed Shells");
        return recipes;
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getName() {
        return "Vegan Meal";
    }

    @Override
    public List<String> getRecipes() {
        List<String> recipes = new ArrayList<>();
        recipes.add("Lentil Soup");
        recipes.add("Vegan Pad Thai");
        return recipes;
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getName() {
        return "Keto Meal";
    }

    @Override
    public List<String> getRecipes() {
        List<String> recipes = new ArrayList<>();
        recipes.add("Steak with Asparagus");
        recipes.add("Avocado Salad");
        return recipes;
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getName() {
        return "High-Protein Meal";
    }

    @Override
    public List<String> getRecipes() {
        List<String> recipes = new ArrayList<>();
        recipes.add("Grilled Chicken Breast");
        recipes.add("Salmon with Quinoa");
        return recipes;
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public void displayMealPlan() {
        System.out.println("Meal Plan: " + mealPlan.getName());
        System.out.println("Recipes:");
        for (String recipe : mealPlan.getRecipes()) {
            System.out.println("- " + recipe);
        }
    }
}

class MealPlanGenerator {

    public <T extends MealPlan> Meal<T> generateMealPlan(Class<T> mealType) {
        try {
            T mealPlan = mealType.getDeclaredConstructor().newInstance();
            return new Meal<>(mealPlan);
        } catch (Exception e) {
            System.out.println("Error generating meal plan: " + e.getMessage());
            return null;
        }
    }
}

public class PersonalizedMealPlan {
    public static void main(String[] args) {
        MealPlanGenerator generator = new MealPlanGenerator();

        Meal<VegetarianMeal> vegetarianMeal = generator.generateMealPlan(VegetarianMeal.class);
        if (vegetarianMeal != null) {
            vegetarianMeal.displayMealPlan();
        }

        System.out.println();

        Meal<VeganMeal> veganMeal = generator.generateMealPlan(VeganMeal.class);
        if (veganMeal != null) {
            veganMeal.displayMealPlan();
        }

        System.out.println();
        Meal<KetoMeal> ketoMeal = generator.generateMealPlan(KetoMeal.class);
        if (ketoMeal != null) {
            ketoMeal.displayMealPlan();
        }

        System.out.println();
        Meal<HighProteinMeal> highProteinMeal = generator.generateMealPlan(HighProteinMeal.class);
        if (highProteinMeal != null) {
            highProteinMeal.displayMealPlan();
        }
    }
}