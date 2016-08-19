/**
 * Created by feliumla16 on 14.08.2016.
 */

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MainClass extends StateBasedGame{

    public static final String gamename = "The story of the magical Forest";
    public static final int play = 0;
    public static final int xSize = 480;
    public static final int ySize = 360;


    public MainClass(String gamename){
        super(gamename);
        this.addState(new Play());
    }

    public void initStatesList(GameContainer gc) throws SlickException{
        this.getState(play).init(gc, this);
        this.enterState(play);
    }

    public static void main(String[] args){
        AppGameContainer appgc;
        try{
            appgc = new AppGameContainer(new MainClass(gamename));
            appgc.setDisplayMode(xSize, ySize, false);
            appgc.setTargetFrameRate(60);
            appgc.start();
        }catch(SlickException e) {
            e.printStackTrace();
        }
    }
}
