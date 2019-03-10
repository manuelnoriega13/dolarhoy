package com.manoriega.dolarhoy.junit;

import org.junit.Test;

import java.io.*;

public class CommandTest {

    @Test
    public void testExecuteCommand() throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec("vlc");
        System.out.println("fin");
        p.waitFor();
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        stdInput.lines().filter(s -> s.contains("src")).findFirst().ifPresent(System.out::println);
        InputStream inputStream = new FileInputStream(new File(""));
        OutputStream outputStream = new FileOutputStream(new File(""));

    }
}
