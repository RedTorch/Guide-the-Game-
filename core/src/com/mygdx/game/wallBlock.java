package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by missionbit on 6/25/15.
 */
public class wallBlock {
    private  Texture rockWall;
    public  Vector2 wallPosition;
    private  Vector2 wallDirection;
    private int getWidth;
    private  Vector2 motion;


    public wallBlock() {
        rockWall = new Texture("stationfloor copy.png");
        wallPosition = new Vector2();
        motion = new Vector2();
        wallDirection = new Vector2();

        wallPosition.set(0, 280);
        motion.set(2,0);
        wallDirection.set(10,0);
        getWidth = Gdx.graphics.getWidth();
    }
    /*
    public static void render() {
    }
*/
    public  void updateGame() {
        float delta = Gdx.graphics.getDeltaTime();
        if (wallPosition.x < 0) {
            wallPosition.x = 0;
            motion.x = 5;
        }
        else if (wallPosition.x + rockWall.getWidth() > getWidth) {
            wallPosition.x = getWidth-rockWall.getWidth();
            motion.x = -5;
        }
        wallDirection.add(motion);
        wallPosition.mulAdd(wallDirection,delta);
    }
    public  Texture getRockWall() {
        return rockWall;
    }
    public void setWallPosition(int a, int b){
        wallPosition.x = a;
        wallPosition.y = b;
    }
    public Vector2 getWallPosition() {
        return wallPosition;
    }

}
