package Level2;

public class DistanceAndTime {
    public static void main(String[] args) {
        String name = "Eric";
        String fromCity = "Chennai", viaCity = "Vellore", finalCity = "Bangalore";

        // distance fromCity to viaCity in kilometers

        double fromToviaDistance = 156.6;

        // distance viaCity to finalCity in kilometers
        double viaTofinalDistance = 211.8;

        // calculate Total Distance from Chennai to Bangalore
        double totalDistance = fromToviaDistance + viaTofinalDistance;

        // Time taken fromCity to viaCity
        double fromToviaTime = 4 * 60 + 4;

        // Time taken viaCity to finalCity
        double viaTofinalTime = 4 * 60 + 25;

        // Total time taken from chennai to bangalore in minutes
        double totalTime = fromToviaTime + viaTofinalTime;

        System.out.println("The Total Distance travelled by " + name + " from " + 
                         fromCity + " to " + finalCity + " via " + viaCity +
                         " is " + totalDistance + " km and " +
                         "the Total Time taken is " + totalTime + " minutes");
    }
}
