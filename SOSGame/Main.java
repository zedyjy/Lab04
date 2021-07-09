package CS102.Lab04.SOSGame;

import cs101.sosgame.SOS;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("SOS Game");

        SOS sos = new SOS(3);

        frame.add(new SOSGUIPanel(sos, "Player 1", "Player 2"), BorderLayout.NORTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}