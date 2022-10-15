import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare1();
        addItems();
         
    }
    
    private void prepare1(){
        for(int x = 18; x<600; x+=28){
            Pared pared = new Pared();
            addObject(pared,x,18);
            pared = new Pared();
            addObject(pared,x,382);
        }
        
        for(int y = 46; y<150; y+=28){
            Pared pared = new Pared();
            addObject(pared,18,y);
            pared = new Pared();
            addObject(pared,578,y);
        }
        
        for(int y = 240; y<400; y+=28){
            Pared pared = new Pared();
            addObject(pared,18,y);
            pared = new Pared();
            addObject(pared,578,y);
        }
        
        Pacman pacman = new Pacman();
        addObject(pacman,82,94);
        
    }
    
    private void addItems(){
        addObject(new Apple(), 180, 150);
        addObject(new Apple(), 180, 300);
        addObject(new Apple(), 380, 100);
        
        addObject(new Banana(), 180, 100);
        addObject(new Banana(), 500, 100);
        addObject(new Banana(), 380, 150);
        
        addObject(new Cereza(), 300, 150);
        addObject(new Cereza(), 300, 210);
        addObject(new Cereza(), 300, 310);
        
        addObject(new Ghost(), 180, 250);
        addObject(new Ghost(), 400, 310);
    }
}
