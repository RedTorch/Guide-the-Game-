package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by missionbit on 6/18/15.
 */
public class MyGestureListener implements GestureDetector.GestureListener {
    private float startx;
    private float starty;


    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        startx = x;
        starty = MyGdxGame.ballPosition.y;
        //starty = Gdx.graphics.getHeight() - y;
        System.out.println(startx + "hello" + starty);


        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {

        return false;
    }

    @Override
    public boolean longPress(float x, float y) {

        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        System.out.println("Fling is wprking"+ velocityX+" "+ velocityY);
        if(MyGdxGame.ballBounce.contains(startx,starty)) {
            System.out.println("Detected Fling");
            MyGdxGame.ballPosition.y += 65;
            MyGdxGame.ballBounce.y = MyGdxGame.ballPosition.y;
            return true;
        } else {
            System.out.println("Ignored Fling " + MyGdxGame.ballBounce.x + " "+ MyGdxGame.ballBounce.y);

            return false;

        }


    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {

        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {

        return false;
    }

    @Override
    public boolean zoom (float originalDistance, float currentDistance){

        return false;
    }

    @Override
    public boolean pinch (Vector2 initialFirstPointer, Vector2 initialSecondPointer, Vector2 firstPointer, Vector2 secondPointer){

        return false;
    }
}