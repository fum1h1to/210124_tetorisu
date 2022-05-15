package tetorisu;

public class DownBlock extends Block {
    private int x;
    private int y;
    private int t;
    private int a;

    private int px;
    private int py;
    private int pa;

    private int count;
    private int waitCount;
    private boolean isGround;
    private boolean isSet;

    public DownBlock(int x, int y, int t, int a){
        this.x = x;
        this.y = y; 
        this.t = t;
        this.a = a;

        this.count = 0;
        this.waitCount = Tetorisu.WAIT;
        this.isGround = false;
        this.isSet = false;
    }

    public void update(Integer[][] screen){
        this.px = this.x;
        this.py = this.y;
        this.pa = this.a;

        if(count % 30 == 0){
            this.py += 1;
        }

        if(!this.getIsSet()){
            if(count % 5 == 0){
                if(MainFrame.keyA > -1) this.px -= 1;
                if(MainFrame.keyD > -1) this.px += 1;
                if(count % 30 != 0) if(MainFrame.keyS > -1) this.py += 1;
                if(MainFrame.keyF > -1) this.pa += 1;
            }
        }
        this.pa = this.pa % 4;

        if(!this.collision(this.px, this.y, this.t, this.a, screen)){
            this.x = this.px;
        }
        if(!this.collision(this.x, this.y + 1, this.t, this.a, screen)){
            this.y = this.py;
        }else{
            this.isGround = true;
        }
        if(!this.collision(this.x, this.y, this.t, this.pa, screen)){
            this.a = this.pa;
        }

        if(this.isGround){
            this.waitCount -= 1;
            if(waitCount <= 0) this.isSet = true;
        }

        this.count += 1;
        this.count = this.count % 60;
    }

    public boolean collision(int p_x, int p_y, int p_t, int p_a, Integer[][] screen){
        for(int j = 0; j < 4; j++){
            for(int i = 0; i < 4; i++){
                int[] px = new int[]{i, 3 - j, 3 - i,     j};
                int[] py = new int[]{j,     i, 3 - j, 3 - i};//すごいわ。地味に条件分岐のようなことを配列でやっている。
                if(super.pattern[p_t][py[p_a]][px[p_a]] == 0) continue;

                if(screen[p_y + j][p_x + i] != 7) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkGameOver(Integer[][] screen){
        return this.collision(this.x, this.y + 1, this.t, this.a, screen);
    }

    public void putDelete(boolean s, Integer[][] screen){
        super.putAndDelete(this.x, this.y, this.t, this.a, s, screen);
    }

    public boolean getIsSet(){
        return this.isSet;
    }
}
