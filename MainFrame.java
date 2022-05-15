package tetorisu;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements KeyListener{
    GamePanel gamePanel = new GamePanel();

    //keyが押されたかどうか
    static int keyA = -1;
    static int keyS = -1;
    static int keyD = -1;
    static int keyF = -1;
    
    public MainFrame(){
        this.add(gamePanel);

        this.addKeyListener(this);

        this.setTitle("Tetorisu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setSize(Main.FIELD_WIDTH, Main.FIELD_HEIGHT);
        // this.setLayout(null);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e){

    }
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyChar() == 'a') keyA += 1;
        if(e.getKeyChar() == 's') keyS += 1;
        if(e.getKeyChar() == 'd') keyD += 1;
        if(e.getKeyChar() == 'f') keyF += 1;
    }
    @Override 
    public void keyReleased(KeyEvent e){
        if(e.getKeyChar() == 'a') keyA = -1;
        if(e.getKeyChar() == 's') keyS = -1;
        if(e.getKeyChar() == 'd') keyD = -1;
        if(e.getKeyChar() == 'f') keyF = -1;
    }
}