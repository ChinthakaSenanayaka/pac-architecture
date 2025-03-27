package com.example.pac_architecture.OrderPAC;

import com.example.pac_architecture.LandingPAC.LandingController;
import com.example.pac_architecture.ViewHandler.ViewHandler;

public class OrderController {
    private final OrderAbstraction orderAbstraction;
    private LandingController landingController;
    private ViewHandler viewHandler;

    public OrderController() {
        this.orderAbstraction = new OrderAbstraction();
    }

    public void subscribe(ViewHandler view) {
        this.viewHandler = view;
    }

    public void notify(Object frame) {
        this.viewHandler.display(frame);
    }

    public void setLandingController(LandingController landingController){
        this.landingController = landingController;
    }
}
