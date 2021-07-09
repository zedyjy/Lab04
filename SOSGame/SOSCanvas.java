package CS102.Lab04.SOSGame;

import cs101.sosgame.SOS;

import javax.swing.*;
import java.awt.*;

public class SOSCanvas extends JPanel {

    SOS sos;
    final int size = 500;

    public SOSCanvas(cs101.sosgame.SOS sos){
        this.sos = sos;
        this.setPreferredSize(new Dimension(size,size));
        this.setBackground(Color.PINK);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        int dimension = sos.getDimension();

        for(int i = 0; i <= dimension; i++){
            int xDraw = i*(size/dimension);
            int yDraw = i*(size/dimension);
            g.drawLine(xDraw,0, xDraw, size );//draw lines on x
            g.drawLine(0, yDraw,size,yDraw); //draw lines on y

            for(int j = 0; j <= dimension; j++){
                if(i != sos.getDimension() && j != sos.getDimension()) {
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
                    g.drawString("" + sos.getCellContents(i, j), (int)((2*i+1)/(double)2*size/dimension),
                            (int)((2*j+1)/(double)2*size/dimension));
                }
            }
        }
    }
}
