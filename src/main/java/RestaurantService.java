import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName){
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        for (Restaurant bI:restaurants) {
            if (restaurantName.equals(bI.getName())) {
                return bI;
            }
        }
        return  null;
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    // TDD method that returns the order value
    public int getOrderValue(List<Item> selectedMenu) {
        int totalValue = 0;
        for (Item bI:selectedMenu) {
            totalValue += bI.getPrice();
        }
        return totalValue;
    }
}
