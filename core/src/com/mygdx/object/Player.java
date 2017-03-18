/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.controller.AbilityController;
import com.mygdx.equipment.Equipment;
import com.mygdx.util.Constants;

/**
 *
 * @author pawel_000
 */
public class Player extends Entity
{   
    private boolean clicked = false;
    
    private AbilityController abilityController;
    private Equipment equipment;
    
    private final float speed = 5.2f;
    
    public Player(float x, float y)
    {
        super(x, y);
        
        init();
    }
    
    private void init()
    {
        this.xVel = 0.0f;
        this.yVel = 0.0f;
        
        equipment = new Equipment();
        abilityController = new AbilityController(this);
    }
    
    public void update()
    {
        handleInput();
        
        x += xVel;
        y += yVel;
        
        xVel *= Constants.FRICTION;
        yVel *= Constants.FRICTION;
        
        abilityController.update();
    }
    
    public void render(float delta)
    {
        shapeRenderer.setColor(Color.GOLDENROD);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(x, y, 20.0f);
        shapeRenderer.end();
        
        abilityController.render(delta);
    }
    
    private void handleInput()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            this.xVel = -speed;
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            this.xVel = speed;
        else if(Gdx.input.isKeyPressed(Input.Keys.UP))
            this.yVel = speed;
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            this.yVel = -speed;
        
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
            abilityController.shoot(equipment.getSpellCard());
    }

    public AbilityController getAbilityController()
    {
        return abilityController;
    }

    public Equipment getEquipment()
    {
        return equipment;
    }
}
