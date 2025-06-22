/* Assume:
        futureValue(year) = currentValue × (1 + growthRate)^year
*/

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0)
            return currentValue;
        return (1 + growthRate) * calculateFutureValue(currentValue, growthRate, years - 1);
    }

    // Optimized Recursive Function for better Stack Safety
    public static double calculateFutureValueIterative(double currentValue, double growthRate, int years) {
        for (int i = 0; i < years; i++) {
            currentValue *= (1 + growthRate);
        }
        return currentValue;
    }    

    public static void main(String[] args) {
        double currentValue = 1000.0; // Initial investment
        double growthRate = 0.10; // 10% annual growth
        int years = 5;

        double futureValue = calculateFutureValue(currentValue, growthRate, years);
        System.out.println("Predicted future value after " + years + " years: " + futureValue);
    }
}
