package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by alexfranklin on 7/9/15.
 */
public class Credits {

    private Texture gameBackround;
    SpriteBatch batch;
    private int height;
    private int width;


    public void create() {

        gameBackround = new Texture("grayCrossTextureBigger.png");
        height = Gdx.graphics.getHeight();
        width  = Gdx.graphics.getWidth();
        batch = new SpriteBatch();

        }

      public void draw() {

          batch.begin();
          batch.draw(gameBackround, 0, 0, 2*width, 3*height);
          batch.end();
    }
}
