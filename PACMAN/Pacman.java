import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    private static final int OFFSET = 10;
    
    private String []images = new String[]{
        "images/Pacman-cerrado.png",
        "images/Pacman-abierto.png"
    };
    
    private int currentImage = 0;
    private int delaymouth = 0;
    private int offsetX = 0;
    private int offsetY = 0;
    
    private int score;
    
    Pacman(){
        setImage(images[currentImage]);
    }
    
    public void act()
    {
        moveMouth();
        Movement();
        moveIfNoCollision(offsetX, offsetY);
        showHud();
        eatItems();
    }
    
    private void Movement(){
        if(Greenfoot.isKeyDown("Right")){
            offsetY = 0;
            offsetX = OFFSET;
        } else if(Greenfoot.isKeyDown("Left")){
            offsetY = 0;
            offsetX = -OFFSET; 
        } else if(Greenfoot.isKeyDown("Up")){
            offsetX = 0;
            offsetY = -OFFSET;
        } else if(Greenfoot.isKeyDown("Down")){
            offsetX = 0;
            offsetY = OFFSET;
        }
    }
    
    private void moveIfNoCollision(int dx, int dy){
        if(this.getOneObjectAtOffset(dx *2, dy*2, Pared.class) == null){
            setLocation(getX() + dx, getY() + dy);
        }
    }
    
    private void moveMouth(){    
        delaymouth++;
        if(delaymouth == 10){
            currentImage = (currentImage +1) % images.length;
            setImage(images[currentImage]);
            delaymouth = 0;
        }
    }
    
    private void showHud(){
        getWorld().showText(Integer.toString(score), 500, 30);
    }
    
    private void eatItems(){
        Actor actor = getOneIntersectingObject (Apple.class);
        
        if(actor != null){
            score += 2;
            getWorld().removeObject(actor);
        }
        
        actor = getOneIntersectingObject (Banana.class);
        
        if(actor != null){
            score += 15;
            getWorld().removeObject(actor);
        }
        
        actor = getOneIntersectingObject (Cereza.class);
        
        if(actor != null){
            score += 20;
            getWorld().removeObject(actor);
        }
        
        actor = getOneIntersectingObject (Ghost.class);
        
        if(actor != null){
            score -= 20;
            getWorld().removeObject(actor);
        }
        
    }
}
