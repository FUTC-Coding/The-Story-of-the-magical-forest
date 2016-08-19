/**
 * Created by feliumla16 on 17.08.2016.
 */

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.tiled.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyTiledMap {

    private TiledMap map;
    int mapY = -2900;
    private ArrayList<Rectangle> blocks;

    public boolean block[][] = new boolean[464][3344];

    int layer = 1;

    public void getCollisionTiles(){
        for (int i = 0; i < 29; i++){
            for (int j = 0; j < 209; j++){
                int tileID = map.getTileId(i, j, layer); //http://gamedev.stackexchange.com/questions/59308/how-do-i-detect-and-handle-collisions-using-a-tile-property-with-slick2d
                String value = map.getTileProperty(tileID, "blocked", "false");
                if (value.equals("true")){
                    block[i][j] = true;
                    blocks.add(new Rectangle((float)i * 16,(float)j * 16, 16, 16));
                }
            }
        }
    }


    public ArrayList<Rectangle> getBlocks(){
        return blocks;
    }


    public MyTiledMap() {
        loadMap();
        blocks = new ArrayList<Rectangle>();
    }

    private boolean loadMap(){
        try
        {
            map = new TiledMap("map/overworld - Kopie.tmx", "map");
            return true;
        } catch (SlickException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void update() {
        /*if (mapY > 3000){
            mapY = 3000;
        }*/
        map.render(0,mapY);
    }

    public int getMapY(){
        return mapY;
    }

    public void setMapY(int y){
        this.mapY = y;
    }
}