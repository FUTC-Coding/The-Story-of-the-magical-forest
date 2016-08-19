/**
 * Created by feliumla16 on 16.08.2016.
 */

import org.newdawn.slick.*;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.Rectangle;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;

public class Play extends BasicGameState {

    private MyTiledMap map;
    Character boy;
    TextField textField;
    Font font;
    boolean isInCollision = false;

    public Play(){
    }
    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {
        map = new MyTiledMap();
        boy = new Character(200,185);
        font = new UnicodeFont(new java.awt.Font(java.awt.Font.SANS_SERIF, java.awt.Font.ITALIC, 26));
        textField = new TextField(gc, gc.getDefaultFont(), 0, 250, 480, 110);
        updateText("test");
        map.getCollisionTiles();
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {
        map.update();
        boy.update();
        textField.render(gc, g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta)
            throws SlickException {
            loopCheckCollision();
            handelInput(gc.getInput());
    }

    public void loopCheckCollision(){
        isInCollision = false;
        ArrayList<Rectangle> rectangles = map.getBlocks();
        for (int i=0; i<rectangles.size(); i++) {
            Rectangle rect = rectangles.get(i);

            if(rect.intersects(boy.getShape())){
                isInCollision = true;
            }
        }
    }

    public void handelInput(Input input){
        boy.setMoving(false);
        float oldXPos = boy.getX();
        float oldYPos = boy.getY();

        if (input.isKeyDown(Input.KEY_UP) && !isInCollision){
            boy.setMoving(true);
            boy.setDirection(Character.Direction.UP);
            //boy.setY(boy.getY() - 1);
            map.setMapY(map.getMapY() + 1);
        }
        if (input.isKeyDown(Input.KEY_DOWN) && !isInCollision){
            boy.setMoving(true);
            boy.setDirection(Character.Direction.DOWN);
            //boy.setY(boy.getY() + 1);
            map.setMapY(map.getMapY() - 1);
        }
        if (input.isKeyDown(Input.KEY_LEFT) && !isInCollision){
            boy.setMoving(true);
            boy.setDirection(Character.Direction.LEFT);
            boy.setX(boy.getX() - 1);
        }
        if (input.isKeyDown(input.KEY_RIGHT) && !isInCollision){
            boy.setMoving(true);
            boy.setDirection(Character.Direction.RIGHT);
            boy.setX(boy.getX() + 1);
        }
    }

    public int getID() {
        return 0;
    }

    public void updateText(String s){
        textField.setText(s);
    }
}
