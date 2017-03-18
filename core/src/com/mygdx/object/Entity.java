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
    protected float r;
    protected float xVel;
    protected float yVel;
    
    protected ShapeRenderer shapeRenderer;
    
    public Entity(float x, float y){
        this.x = x;
        this.y = y;
        this.r = 10.0f;
        
        shapeRenderer = new ShapeRenderer();
    }
    
    // Checking circle collision
    public boolean isCircleCollision(Entity e1)
    {
        float xPos = e1.x - x;
        float yPos = e1.y - y;
        float distance = (float) Math.sqrt(Math.pow(xPos, 2) + Math.pow(yPos, 2));
        
        if(distance >= e1.r + r)
            return false;
        
        return true;
    }

    // checking square collision
    public boolean isColision(Entity e1)
    {
        float leftA, leftB;
        float rightA, rightB;
        float topA, topB;
        float bottomA, bottomB;

        leftA = e1.getX() - e1.getR();
        rightA = e1.getX() + e1.getR();
        topA =  e1.getY() - e1.getR();
        bottomA =  e1.getY() + e1.getR();

        leftB = x - r;
        rightB = x + r;
        topB = y - r;
        bottomB = y + r;
        
        if( bottomA <= topB )
        {
            return false;
        }

        if( topA >= bottomB )
        {
            return false;
        }

        if( rightA <= leftB )
        {
            return false;
        }

        if( leftA >= rightB )
        {
            return false;
        }

        return true;
    }
    
    /**
     * 
     * Getters and setters
     */

    public float getR()
    {
        return r;
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
