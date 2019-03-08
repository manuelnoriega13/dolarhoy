package com.manoriega.dolarhoy.junit;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandTest {

    @Test
    public void testExecuteCommand() throws  IOException {
        String s = null;
        Process p = Runtime.getRuntime().exec("vlc");
        System.out.println("fin");
//        p.waitFor();
//        BufferedReader stdInput = new BufferedReader(new
//                InputStreamReader(p.getInputStream()));
//        while ((s = stdInput.readLine()) != null) {
//            if (s.contains("src")) {
//                System.out.println(s);
//                break;
//            }
//        }
    }
}
