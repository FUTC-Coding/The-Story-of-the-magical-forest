import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Transform;

/**
 * Created by feliumla16 on 17.08.2016.
 */
public class Character {

    int x, y;
    private SpriteSheet s;
    int duration;
    float scale = 1.0f;
    Direction direction;
    boolean moving;
    Animation up, down, left, right;
    Shape shape;

    public Character(int x, int y) {
        this.x = x;
        this.y = y;
        moving = false;
        direction = Direction.DOWN;
        duration = 200;
        try {
            s = new SpriteSheet("res/boySpriteSheet.png", 33, 36);
        } catch (SlickException e) {
            e.printStackTrace();
        }
        up = new Animation();
        up.addFrame(s.getSubImage(0, 2).getScaledCopy(scale), duration);
        up.addFrame(s.getSubImage(2, 2).getScaledCopy(scale), duration);
        down = new Animation();
        down.addFrame(s.getSubImage(0, 0).getScaledCopy(scale), duration);
        down.addFrame(s.getSubImage(2, 0).getScaledCopy(scale), duration);
        right = new Animation();
        right.addFrame(s.getSubImage(0, 1).getScaledCopy(scale), duration);
        right.addFrame(s.getSubImage(1, 1).getScaledCopy(scale), duration);
        right.addFrame(s.getSubImage(2, 1).getScaledCopy(scale), duration);
        left = new Animation();
        duration = 100;
        left.addFrame(s.getSubImage(0, 3).getScaledCopy(scale), duration);
        left.addFrame(s.getSubImage(1, 3).getScaledCopy(scale), duration);
        left.addFrame(s.getSubImage(2, 3).getScaledCopy(scale), duration);
        left.addFrame(s.getSubImage(1, 3).getScaledCopy(scale), duration);

        shape = new Rectangle(x, y, 33, 36);
    }

    public Shape getShape() {
        return shape;
    }

    public void setDirection(Direction d){
        direction = d;
    }

    public void setMoving(boolean m){
        moving = m;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
        shape.setX(x);
    }

    public void setY(int f){
        this.y = f;
    }

    public enum Direction {
        UP,DOWN,LEFT,RIGHT;
    }

    public void update(){
        if (direction == Direction.UP){
            if (moving){
                up.draw(x,y);
            }else{
                s.getSubImage(1, 2).draw(x, y);
            }
        }
        if (direction == Direction.DOWN){
            if (moving){
                down.draw(x,y);
            }else {
                s.getSubImage(1, 0).draw(x, y);
            }
        }
        if(direction == Direction.LEFT){
            if(moving){
                left.draw(x, y);
            } else {
                s.getSubImage(1, 3).draw(x, y);
            }
        }
        if(direction == Direction.RIGHT){
            if(moving){
                right.draw(x, y);
            } else {
                s.getSubImage(1, 1).draw(x,y);
            }
        }

        //s.draw(x,y);
    }
}
