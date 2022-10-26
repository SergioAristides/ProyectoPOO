/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game3.utilidades;

/**
 *
 * @author sergi
 */
public class Vector2D {
    private double x,y;

    public Vector2D(double x,double y) {
        this.x=x;
        this.y=y;
    }
    public Vector2D(Vector2D v) {
        this.x=v.x;
        this.y=v.y;
    }

    public Vector2D() {
        x=0;
        y=0;
    }
    
    //resta de vectores
     public Vector2D restar(Vector2D v){
        return new Vector2D(x-v.getX(),y-v.getY());
        
    }
    
    
    public Vector2D vector_unitario(){
        double magnitud=MagnitudVector();
        return new Vector2D(x/magnitud,y/magnitud);
    }
    
    
    /*
    limite el recorrido de la nave
    si la magnitud del vector es muy grande cambiamos ese vector por uno unitario y le multiplicamos 
    su escalar para asi limitar la velocidad
    */
    public Vector2D limit(double value){
        if(MagnitudVector()>value){
            return this.vector_unitario().scale(value);
        }
        return this;
        
    }
    
    //vector por un escalar esto servira para modificar la magnitud del vector
    //direccion de diferentes objetos movibles
    //direccion (heading) 
    public Vector2D scale(double value){
        return new Vector2D(x*value,y*value);
        
    }
    
    /*
    suma de vectores
    */
    public Vector2D add(Vector2D v){
        return new Vector2D(x+v.getX(),y+v.getY());
        
    }
    
    /*
    retur la magnitud del vector
    */
    public double MagnitudVector(){
        return Math.sqrt((x*x)+(y*y));
    }
    /*
    param= angle
    return el valor de x y el valor de y
    nos muestra el valor de x y y dependiendo del angulo
    */
    public Vector2D setDirection(double angle){
        double magnitud=MagnitudVector();
        return new Vector2D(Math.cos(angle)*magnitud, Math.sin(angle)*magnitud);
    }
    /*
    return= el angulo sabiendo las coordenadas de x y y el angulo nos da la direccion
    */
    public double returnAngle(){
       double angle= Math.atan(y/x);
       return angle;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    
    
    
}
