/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.equipment.generate;

import com.badlogic.gdx.utils.JsonValue;
import java.util.Random;

/**
 *
 * @author pawel_000
 */
public abstract class Creator 
{
    protected ItemLoader itemLoader;
    protected JsonValue jsonValue;
    protected Random random;
    
    public Creator()
    {
        init();
    }
    
    private void init()
    {
        jsonValue = null;
        itemLoader = new ItemLoader();
        random = new Random();
    }
    
    protected boolean isDrop()
    {
        int value = random.nextInt(9) + 1;
        
        if(value <= 2)
            return false;
        
        return true;
    }
    
    protected boolean isDrop(float chance)
    {
        float value = random.nextFloat();
        
        if(value <= chance / 100.0f)
            return false;
        
        return true;
    }
}
