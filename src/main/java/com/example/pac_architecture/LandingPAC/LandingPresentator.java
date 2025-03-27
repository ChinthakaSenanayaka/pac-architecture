package com.example.pac_architecture.LandingPAC;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;

public class LandingPresentator {
    /**
     * Frame for the GUI
     */
    private JFrame frame;

    /**
     * Controller element of the PAC
     */
    private final LandingController controller;

    public LandingPresentator() {
        this.controller = new LandingController();
    }
    
    /**
     * 
     */
    private void sellerMenu() {
        frame.getContentPane().removeAll();
        JTextField textFieldlog = new JTextField(20);
        JTextField textFieldpass = new JTextField(20);
        JButton connect = new JButton("Login");
        JButton register = new JButton("Register");
        JButton back = new JButton("Back");

        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = textFieldlog.getText();
                String password = textFieldpass.getText();

                controller.login(login, password, LandingController.Mode.Seller, frame);
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = textFieldlog.getText();
                String password = textFieldpass.getText();

                controller.registration(login, password, LandingController.Mode.Seller);
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startMenu();
            }
        });

         JPanel connectPanel = new JPanel();
         connectPanel.setLayout(new GridBagLayout());
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.gridx = 0; // Colonne 0
         gbc.gridy = 0; // Ligne 0
         gbc.insets = new Insets(5, 5, 5, 5);
         
         connectPanel.add(new JLabel("Seller menu"), gbc);
         gbc.gridy++;
         connectPanel.add(new JLabel("Login :"), gbc);
         gbc.gridx++;
         connectPanel.add(textFieldlog, gbc);
         gbc.gridy++;
         gbc.gridx = 0;
         connectPanel.add(new JLabel("Password :"), gbc);
         gbc.gridx++;
         connectPanel.add(textFieldpass, gbc);
         gbc.gridy++;
         gbc.gridx = 0;
         connectPanel.add(connect, gbc);
         gbc.gridx++;
         connectPanel.add(register, gbc);
         gbc.gridx++;
         connectPanel.add(back, gbc);

        frame.add(connectPanel);
        frame.setVisible(true);
    }

    private void custommerMenu() {
        frame.getContentPane().removeAll();
        JTextField textFieldlog = new JTextField(20);
        JTextField textFieldpass = new JTextField(20);
        JButton connect = new JButton("Login");
        JButton register = new JButton("Register");
        JButton back = new JButton("Back");

        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = textFieldlog.getText();
                String password = textFieldpass.getText();

                controller.login(login, password, LandingController.Mode.Customer, frame);
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = textFieldlog.getText();
                String password = textFieldpass.getText();

                controller.registration(login, password, LandingController.Mode.Customer);
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startMenu();
            }
        });

        JPanel connectPanel = new JPanel();
        connectPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Colonne 0
        gbc.gridy = 0; // Ligne 0
        gbc.insets = new Insets(5, 5, 5, 5);
        
        connectPanel.add(new JLabel("Customers menu"), gbc);
        gbc.gridy++;
        connectPanel.add(new JLabel("Login :"), gbc);
        gbc.gridx++;
        connectPanel.add(textFieldlog, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        connectPanel.add(new JLabel("Password :"), gbc);
        gbc.gridx++;
        connectPanel.add(textFieldpass, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        connectPanel.add(connect, gbc);
        gbc.gridx++;
        connectPanel.add(register, gbc);
        gbc.gridx++;
        connectPanel.add(back, gbc);

        frame.add(connectPanel);
        frame.setVisible(true);
    }

    private void startMenu() {
        frame.getContentPane().removeAll();
    
        JButton button1 = new JButton("Custommers Mode");
        JButton button2 = new JButton("Sellers Mode");
    
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                custommerMenu();
            }
        });
    
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sellerMenu();
            }
        });
    
        JPanel connectPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(5, 5, 5, 5); 
        gbc.gridx = 0; // Toujours dans la colonne 0
    
        // Ajouter le label
        gbc.gridy = 0; // Ligne 0
        connectPanel.add(new JLabel("E-Commerce Application"), gbc);
    
        // Ajouter le bouton 1
        gbc.gridy = 1; // Ligne 1
        connectPanel.add(button1, gbc);
    
        // Ajouter le bouton 2
        gbc.gridy = 2; // Ligne 2
        connectPanel.add(button2, gbc);
    
        frame.add(connectPanel);
        
        frame.setVisible(true);
    }


    public void showLoginUser() {
        this.frame = new JFrame("E-commerce appilcation");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 

        startMenu();
    }
}