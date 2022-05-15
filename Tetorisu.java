package tetorisu;

import java.awt.*;

import tetorisu.Main;

public class Tetorisu {
    public static final int FIELD_SIZE = 25;
    public static final int WAIT = 60;

    private Graphics2D gra;
    private boolean gameOver = false;
    
    private Integer[][] screen;
    private Block block;
    private DownBlock db;
    private DownBlock nextDb;
    private int waitCount;

    public Tetorisu(){
        gra = Main.gra;
        block = new Block();
        db = new DownBlock(8, 0, (int)(Math.random() * 7), 0);
        waitCount = WAIT / 2;
    
        this.init();
    }

    public void update(){
        if(!gameOver){
            if(db.getIsSet()){
                waitCount -= 1;
                if(waitCount == 0) next();
                
                if(waitCount == WAIT / 2 - 1){
                    for(int y = 18; y > 2; y--){
                        int n = 0;
                        for(int x = 4; x < 16; x++){
                            if(screen[y][x] < 7){
                                n++;
                            }
                        }
                        if(n != 12) continue;

                        for(int x = 4; x < 16; x++){
                            screen[y][x] = 10;
                        }
                    }
                }
                if(waitCount == 1){
                    for(int y = 18; y > 2; y--){
                        if(screen[y][5] != 10) continue;
                        for(int i = y; i > 3; i--){
                            for(int x = 4; x < 16; x++){
                                screen[i][x] = screen[i - 1][x];
                            }
                        }
                        for(int x = 4; x < 16; x++){
                            screen[3][x] = 7;
                        }
                    }
                }
            }else{
                db.putDelete(false, screen);
                db.update(screen);
                db.putDelete(true, screen);
            }
        }
    }

    public void next(){
        db = null;
        db = new DownBlock(8, 0, (int)(Math.random() * 7), 0);
        if(db.checkGameOver(screen)) gameOver = true;
        waitCount = WAIT / 2;
    }

    public void disp(){
        for(int i = 0; i < screen.length; i++){
            for(int j = 0; j < screen[i].length; j++){
                block.drawTile(gra, screen[j][i], i * FIELD_SIZE, j * FIELD_SIZE, FIELD_SIZE, FIELD_SIZE);
            }
        }
    }

    public void init(){
        // screen = new int[Main.FIELD_WIDTH / FIELD_SIZE][Main.FIELD_HEIGHT / FIELD_SIZE];
        screen = new Integer[][]{
            {9, 9, 9, 9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9, 9, 9, 9},
            {9, 9, 9, 9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9, 9, 9, 9},
            {9, 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 9, 9},
            {9, 9, 9, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9}
        };
    }
}
