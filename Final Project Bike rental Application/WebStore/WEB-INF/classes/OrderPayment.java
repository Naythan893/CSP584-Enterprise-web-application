import java.io.IOException;
import java.io.*;
import java.util.Date;


/*
	OrderPayment class contains class variables username,ordername,price,image,address,creditcardno.
	OrderPayment  class has a constructor with Arguments username,ordername,price,image,address,creditcardno

	OrderPayment  class contains getters and setters for username,ordername,price,image,address,creditcardno
*/

public class OrderPayment implements Serializable {
    private int orderId;
    private String userName;
    private String orderName;
    private double orderPrice;
    private String userAddress;
    private String creditCardNo;
    private int saleAmount;
    private Date orderTime;
    private String location;
    private double totalcost;
    private double days;
    private double totCostperday;

    public OrderPayment(int orderId, String userName, String orderName, double orderPrice, String userAddress, String creditCardNo,String location, Double totalcost, Double days) {
        this.orderId = orderId;
        this.userName = userName;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.userAddress = userAddress;
        this.creditCardNo = creditCardNo;
        this.location = location;
        this.totalcost = totalcost;
        this.days = days;
        this.totCostperday = totCostperday;

    }

    public OrderPayment(int orderId, String orderName, double orderPrice) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
    }

    public OrderPayment(int orderId, String orderName, double orderPrice, int saleAmount) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.saleAmount = saleAmount;
    }

    public OrderPayment(String orderName, double orderPrice, int saleAmount) {
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.saleAmount = saleAmount;
    }

    public OrderPayment(int saleAmount, Date orderTime) {
        this.saleAmount = saleAmount;
        this.orderTime = orderTime;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(int saleAmount) {
        this.saleAmount = saleAmount;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }
/////////////////////////////////////////////////////////////////
public double getTotalCost() {
    return totalcost;
}
public double getDays() {
    return days;
}
public void setTotalCost(Double totalcost) {
    this.totalcost = totalcost;
}
public void setDays(Double days) {
    this.days = days;
}
public String getLocation() {
    return location;
}
public void setLocation(String location) {
    this.location = location;
}

public OrderPayment(int saleAmount, Date orderTime, Double totCostperday) {
    this.saleAmount = saleAmount;
    this.orderTime = orderTime;
    this.totCostperday = totCostperday;
}
public double gettotCostperday() {
    return totCostperday;
}

public OrderPayment(String orderName, Double days, int saleAmount, Date orderTime, Double totCostperday, double orderPrice) {
    this.orderName= orderName;
    this.days = days;
    this.saleAmount = saleAmount;
    this.orderTime = orderTime;
    this.totCostperday = totCostperday;
    this.orderPrice = orderPrice;
}

}
