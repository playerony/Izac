/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 *
 * @author pawel_000
 */
public class Entity
{
    protected float x;
    protected float y;
    protected float xVel;
    protected float yVel;
    
    protected ShapeRenderer shapeRenderer;
    
    public Entity(float x, float y){
        this.x = x;
        this.y = y;
        
        shapeRenderer = new ShapeRenderer();
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public float getxVel()
    {
        return xVel;
    }

    public float getyVel()
    {
        return yVel;
    }
    
    
}
