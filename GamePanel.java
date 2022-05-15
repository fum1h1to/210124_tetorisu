package tetorisu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    public BufferedImage base;

    public GamePanel(){
        // this.setBounds(0, 0, Main.FIELD_WIDTH, Main.FIELD_HEIGHT);
        this.setPreferredSize(new Dimension(Main.FIELD_WIDTH, Main.FIELD_HEIGHT));
        // this.setBackground(Color.black);
        base = new BufferedImage(Main.FIELD_WIDTH, Main.FIELD_HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(base, 0, 0, this);
        /*
        第四引数は1imageOvserverインターフェース。
        このインターフェースはcomponentクラスに実装されているから、無論Jpanelにも搭載されている。
        こいつは画像の読み込みとかをいろいろやっているっぽい。正直よく分からない。
        */
    }

    public void draw(){
        repaint();
    }
}
