package tetorisu;

import java.io.*;
import java.awt.Image;
import java.awt.image.*;
import java.awt.Graphics2D;
import javax.imageio.*;

public class Block{
    BufferedImage img = null;

    int[][][] pattern = new int[][][]{
        {
            {1, 1, 1, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        },
        {
            {0, 0, 0, 0},
            {0, 1, 1, 1},
            {0, 1, 0, 0},
            {0, 0, 0, 0}
        },
        {
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        },
        {
            {0, 0, 0, 0},
            {1, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        },
        {
            {0, 0, 0, 0},
            {1, 1, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0}
        },
        {
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {1, 1, 0, 0},
            {0, 0, 0, 0}
        },
        {
            {0, 0, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 0}
        },
    };

    public Block(){
        try{
            img = ImageIO.read(new File("./tetorisu/img/tile.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void drawTile(Graphics2D gra, int tileNum, int x, int y, int w, int h){
        BufferedImage subImg = img.getSubimage(tileNum * 18, 0, 18, 18);
        gra.drawImage(subImg, x, y, w, h, null);
    }

    public void putAndDelete(int x, int y, int t, int a, boolean s, Integer[][] screen){
        for(int j = 0; j < 4; j++){
            for(int i = 0; i < 4; i++){
                int[] px = new int[]{i, 3 - j, 3 - i,     j};
                int[] py = new int[]{j,     i, 3 - j, 3 - i};//すごいわ。地味に条件分岐のようなことを配列でやっている。
                if(pattern[t][py[a]][px[a]] == 0) continue;

                int v = t;
                if(!s) v = 7;
                
                screen[y + j][x + i] = v;
            }
        }
    }
}
