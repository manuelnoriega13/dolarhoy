package com.manoriega.dolarhoy.controller.swing;

import com.manoriega.dolarhoy.service.DolarService;
import com.manoriega.dolarhoy.service.EuroService;
import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resources;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Component
public class UI {

    @Autowired
    private DolarService dolarService;

    @Autowired
    private EuroService euroService;

    public void init() {
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


    public void trayIcon() throws AWTException, InterruptedException, IOException {
        TrayIcon icono = new TrayIcon(getImagen(), "Jonathan Melgoza Blog", this.crearMenu());
        icono.setImageAutoSize(true);
        SystemTray.getSystemTray().add(icono);
        Thread.sleep(5000);
        icono.displayMessage("Atencion", "Servidor corriendo", TrayIcon.MessageType.INFO);
    }

    public Image getImagen() throws IOException {
        File file = new ClassPathResource("icon/linux_tux.png").getFile();
        Image img = Toolkit.getDefaultToolkit().getImage(file.getAbsolutePath());
        return img;
    }

    public PopupMenu crearMenu() {
        PopupMenu menu = new PopupMenu();
        MenuItem salir = new MenuItem("Salir");
        MenuItem dolar = new MenuItem("Dolar");
        MenuItem euro = new MenuItem("Euro");

        salir.addActionListener(e -> System.exit(0));
        dolar.addActionListener(e -> System.out.println(dolarService.ultimo()));
        euro.addActionListener(e -> System.out.println(euroService.ultimo()));

        menu.add(salir);
        menu.add(dolar);
        menu.add(euro);
        return menu;
    }
}
