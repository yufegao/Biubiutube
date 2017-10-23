package biz.Components;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Stream;

public class SalesPerson extends Account {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getTotalSalesRevenue() {
        double revenue = 0;
        for (Order order: Business.getInstance().getOrderDirectory().getElementArrayList()) {
            if (order.getSoldBy().equals(this) && order.getStatus().equals("Placed")) {
                revenue += order.getRevenue();
            }
        }
        return revenue;
    }
    
    public double getSalesRevenue(Market market) {
        return mapOrderAndAcc(market, o -> o.getRevenue());
    }
    
    public double getSalesGap(Market market) {
         return mapOrderAndAcc(market, o -> o.getGap());
    }
    
    private double mapOrderAndAcc(Market market, Function<Order, Double> mapper) {
        return Business.getInstance().getOrderDirectory().getElementArrayList()
                .stream()
                .filter(o -> o.getSoldBy().equals(this))
                .filter(o -> o.getStatus().equals("Placed"))
                .filter(o -> o.getBoughtBy().getMarket().equals(market))
                .map(mapper)
                .reduce(.0, (a, b) -> a + b);
    }
        
    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
