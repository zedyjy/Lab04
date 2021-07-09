package CS102.Lab04;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PotLuck extends JFrame implements ActionListener{

    private static JButton bomb1Button, bomb2Button, prizeButton;
    private static int bomb1, bomb2, prize, clickCount;
    private static final int LINE = 4;
    private static final int ROW = 4;
    JButton [] buttons;
    JPanel panel, panelContent;
    JLabel label;

    public PotLuck(){
        panelContent = new JPanel();
        buttons = new JButton[16];
        panel = new JPanel();

        setBounds(200, 500, 500, 500);
        panelContent.setLayout(new BorderLayout(0, 0));
        setContentPane(panelContent);

        label = new JLabel("Attempt no: "+clickCount);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panelContent.add(label, BorderLayout.NORTH);

        while (bomb1 == bomb2 ||  prize == bomb2 ||bomb1 == prize){
            prize = (int)(Math.random()*(ROW*LINE));
            bomb1 = (int)(Math.random()*(ROW*LINE));
            bomb2 = (int)(Math.random()*(ROW*LINE));
        }

        panelContent.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(ROW, LINE));

        for(int i = 0; i < (ROW*LINE); i++){
            if(i != bomb1 ||  i != bomb2 || i != prize){
                buttons[i] = new JButton("Click!");
                panel.add(buttons[i]);
                buttons[i].setBackground(Color.PINK);
                buttons[i].addActionListener(this);
            }
        }

        bomb1Button = (buttons[bomb1]);
        bomb2Button = (buttons[bomb2]);
        prizeButton = (buttons[prize]);
    }

    public void actionPerformed( ActionEvent event ){
        if(event.getSource() == bomb1Button || event.getSource() == bomb2Button){
            label.setText("Sorry! You are blown up at attempt " + (clickCount + 1));
            for(int i = 0; i < (ROW*LINE); i++){
                (panel.getComponent(i)).setEnabled(false);
            }
        }
        else if(event.getSource() == prizeButton){
            label.setText("You got it in " + (clickCount + 1) + " attempts!" );
            for(int i = 0; i < (ROW*LINE); i++){
                (panel.getComponent(i)).setEnabled(false);
            }
        }
        else{
            clickCount++;
            label.setText("You clicked "+clickCount+" times");
            ((JButton) event.getSource()).setEnabled(false);
        }
    }

    public static void main(String[] args){
        PotLuck frame = new PotLuck();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}