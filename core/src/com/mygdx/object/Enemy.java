/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.object.Entity;
import com.mygdx.util.Constants;

/**
 *
 * @author pawel_000
 */
public class Enemy extends Entity
{
    private int mobRank;
    private float color;
    
    private float alpha = 1.0f;
    
    public Enemy(int mobRank, float x, float y)
    {
        super(x, y);
        
        color = (mobRank * 80.0f) / 255.0f;
        
        this.mobRank = mobRank;
    }

    public int getMobRank()
    {
        return mobRank;
    }
    
    public void update(){
        x += xVel;
        y += yVel;

        xVel*=Constants.FRICTION;
        yVel*=Constants.FRICTION;
    }
    
    public void render(float delta) 
    {
        shapeRenderer.setColor(new Color(color, color, color, alpha));
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(x, y, 20.0f);
        shapeRenderer.end();
    }
}
