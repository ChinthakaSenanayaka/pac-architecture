package com.example.pac_architecture.OrderPAC;

import javax.swing.JFrame;

import com.example.pac_architecture.ViewHandler.ViewHandler;

public class OrderPresentator implements ViewHandler {
    private final OrderController orderController;

    private JFrame frame;

    public OrderPresentator() {
        this.orderController = new OrderController();
        this.orderController.subscribe(this);
    }

    public void showLatestOrders() {

    }

    @Override
    public void display(Object frame) {
        this.frame = (JFrame)frame;
    }
}
