/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

/**
 *
 * @author tuank
 */
public class Order {
    private int orderID, status, accID;
    private String orderDate, shipDate;

    public Order() {
    }
    public Order(int orderID, int status, int accID, String orderDate, String shipDate) {
        this.orderID = orderID;
        this.status = status;
        this.accID = accID;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
    }
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getAccID() {
        return accID;
    }
    public void setAccID(int accID) {
        this.accID = accID;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public String getShipDate() {
        return shipDate;
    }
    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", status=" + status + ", accID=" + accID + ", orderDate=" + orderDate + ", shipDate=" + shipDate + '}';
    }
    
    
}
