package com.example.pac_architecture.LandingPAC;

import com.example.pac_architecture.OrderPAC.OrderController;

public class LandingController {
    /**
     * 
     */
    public enum Mode {
        Customer,
        Seller
    };

    /**
     * 
     */
    private LandingAbstraction userAbstraction;
    private OrderController orderController;

    public LandingController() {
        this.userAbstraction = new LandingAbstraction();
    }

    /**
     * 
     */
    public int registration(String login, String password, Mode mode) {
        return this.userAbstraction.setUser(login, password, mode);
    }

    /**
     * 
     * @param login
     * @param password
     * @param mode
     * @return
     */
    public int login(String login, String password, Mode mode, Object frame) {
        final int res = this.userAbstraction.getUser(login, password, mode);
        if (res == 1) {
            switch (mode) {
                case Seller :
                    // notify seller menu
                    break;

                case Customer :
                    this.orderController.notify();
                    break;
            }
        }
        
        return res;
    }

    /**
     * Set the orderController for the Landing part
     * 
     * @param orderController the order controller to set
     */
    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }
}
