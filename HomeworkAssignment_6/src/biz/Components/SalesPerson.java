package biz.Components;

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
        double revenue = 0;
        for (Order order: Business.getInstance().getOrderDirectory().getElementArrayList()) {
            if (order.getSoldBy().equals(this) && order.getBoughtBy().getMarket().equals(market) && order.getStatus().equals("Placed")) {
                revenue += order.getRevenue();
            }
        }
        return revenue;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
