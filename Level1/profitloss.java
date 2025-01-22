public class profitloss{
    public static void main(String[] args) {
        int costPrice = 129;
        int sellingPrice = 191;
        int profit = sellingPrice - costPrice;
        int loss = costPrice - sellingPrice;
        double profitPercentage = ((double) profit / costPrice) * 100;
        double lossPercentage = ((double) loss / costPrice) * 100;
        System.out.println("Profit: " + profit);
        System.out.println("Loss: " + loss);
        System.out.println("Profit Percentage: " + profitPercentage + "%");
        System.out.println("Loss Percentage: " + lossPercentage + "%");
        }
}