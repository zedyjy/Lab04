package CS102.Lab04.SOSGame;

import cs101.sosgame.SOS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SOSGUIPanel extends JPanel {

    JPanel panel;
    JLabel label1, label2;
    String playerOne, playerTwo;
    SOS sos;
    JComboBox options;
    String[] opts = {"s", "o"};
    SOSCanvas canvas;

    public SOSGUIPanel(SOS sos, String playerOne, String playerTwo) {
        this.sos = sos;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        options = new JComboBox(opts);
        label1 = new JLabel(playerOne + ": " + sos.getPlayerScore1());
        label2 = new JLabel(playerTwo + ": " + sos.getPlayerScore2());
        panel = new JPanel();
        panel.add(options,BorderLayout.NORTH);
        panel.add(label1,BorderLayout.NORTH);
        panel.add(label2,BorderLayout.CENTER);
        label1.setForeground(Color.BLACK);
        label2.setForeground(Color.BLACK);
        canvas = new SOSCanvas(sos);
        add(canvas,BorderLayout.CENTER);
        add(panel,BorderLayout.NORTH);

        canvas.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e){

                String s = "";
                String letterSelected = (String) options.getSelectedItem();
                sos.play(letterSelected.charAt(0), (e.getX() / (canvas.getWidth() / sos.getDimension())) + 1,
                        (e.getY() / (canvas.getHeight() / sos.getDimension())) + 1);

                label1.setText(playerOne + ": " + sos.getPlayerScore1());
                label2.setText(playerTwo + ": " + sos.getPlayerScore2());

                if (sos.getTurn() == 1){
                    label1.setForeground(Color.blue);
                    label2.setForeground(Color.BLACK);
                }
                else{
                    label1.setForeground(Color.BLACK);
                    label2.setForeground(Color.blue);
                }

                canvas.repaint();

                if (sos.isGameOver()){
                    int score1 = sos.getPlayerScore1();
                    int score2 = sos.getPlayerScore2();

                    if(score1 > score2) {
                        s += playerOne + " won!";
                    }
                    else if(score1 < score2) {
                        s += playerTwo + " won!";
                    }
                    else {
                        s += "Its a tie";
                    }
                    JOptionPane.showMessageDialog(null, s,"GAME OVER", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
