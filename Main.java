package tetorisu;

import java.awt.*;
import java.awt.geom.*;
;
public class Main {
    public static final int FIELD_WIDTH = 500;
    public static final int FIELD_HEIGHT = 500;
    public static final long FPS = 60;
    public static final long fpsMill = 1000 / FPS;

    public static MainFrame mainFrame;
    public static Graphics2D gra;

    public static Tetorisu tetorisu;
    public static void main(String[] args){
        mainFrame = new MainFrame();
        gra = mainFrame.gamePanel.base.createGraphics();
        tetorisu = new Tetorisu();

        gameLoop();
    }

    private static void gameLoop(){
        long prevCount = System.currentTimeMillis();
        int fps = 0;
        long delay = 0;
        while(true){
            long prev2Count = System.currentTimeMillis();
            tetorisu.update();
            tetorisu.disp();
            mainFrame.gamePanel.draw();
            try{
                long nowCount = System.currentTimeMillis();
                fps++;
                
                if((nowCount - prev2Count) <= fpsMill) delay = fpsMill - (nowCount - prev2Count);
                else delay = 0;

                Thread.sleep(delay);
                if(nowCount - prevCount > 1000){
                    // System.out.println(fps);s
                    prevCount = nowCount;
                    fps = 0;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
