package com.manoriega.dolarhoy.controller.swing;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class UI {
    public void init(){
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        System.out.println("UI.init()");
    }
}
