/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author sergi
 */
public class Tablero implements InterfaceGame2{
 
 public  Cpacman               pacman; 
 public  ArrayList <Muro>     cuadritos;
 public  ArrayList <Bomba>    bombas; 
 public  ArrayList <Moneda>   coins; 
 public  ArrayList <Fantasma> fantasmitas;
 public  boolean               isBomba = false;
 
 
 private int iMatrizObj [][] = { {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                 {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 4, 4, 4, 1},
                                 {1, 0, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 1},
                                 {1, 0, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 2, 0, 0, 0, 0, 0, 0, 4, 4, 4, 1},
                                 {1, 2, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 0, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1},
                                 {1, 0, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 4, 4, 4, 4, 4, 1, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 1, 2, 1, 4, 4, 2, 4, 4, 4, 4, 4, 1, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 2, 0, 1, 4, 1, 4, 4, 4, 4, 4, 1, 1, 1, 1, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 1, 4, 1, 4, 4, 4, 4, 4, 4, 4, 4, 1, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 1, 4, 4, 4, 4, 4, 4, 0, 1, 4, 4, 1, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1, 1, 1, 1, 1, 4, 4, 1},
                                 {1, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 4, 1, 4, 4, 4, 1, 4, 4, 1},
                                 {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 1},
                                 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
                               };
 
 public Tablero()
 {
   
    pacman      = new Cpacman();
    cuadritos   = new ArrayList<>();
    bombas      = new ArrayList<>();
    coins       = new ArrayList<>();   
    fantasmitas = new ArrayList<>();
    
     int nMuros = 0;
     int nGhost = 0;
     int nCoins = 0;
    
    for(int i=0; i < 23; i++)
    {
        for(int j=0; j < 23; j++)
        {
           switch(iMatrizObj[i][j])
           {
               case 1:
//                   Es muro
                   cuadritos.add(nMuros,new Muro(j*25,i*25) );
                   nMuros++;
                   break;
               case 2:
//                   Es un ghost
                    fantasmitas.add(nGhost,new Fantasma( j*25, i*25,this.getRandomColor()));
                    nGhost++;
                   break;
               case 3:
//                   Es pacman
                     pacman.setPosx(j*25);
                     pacman.setPosy(i*25);
                     pacman.setDirection(LEFT );
                   break;
               case 4:
//                   Es moneda
                     coins.add(nCoins,new Moneda(j*25,i*25));
                     nCoins++;
                   break;
           }
        }
    }
 }
    
    public Color getRandomColor()
    {
        Color c = Color.BLACK;
        
        Random rnd = new Random();
        
        switch (rnd.nextInt(6))
        {
            case 0:
                c = Color.BLACK;
                break;
            case 1:
                 c = Color.BLUE;
                break;
            case 2:
                 c = Color.GREEN;
                break;
            case 3:
                 c = Color.PINK;
                break;
            case 4:
                 c = Color.RED;
                break;
            case 5:
                 c = Color.WHITE;
                break;
                  
        }
        
        return c;
    }
    
    public int getObject(int iFila, int iCol)
    {
      return  iMatrizObj [iFila][iCol];   
    }
    
    public void setObject(int obj,int iFila, int iCol)
    {
        iMatrizObj [iFila][iCol] = obj; 
    }
    
    public void moverPacman()
    {
      iMatrizObj [ pacman.getPosy() ][ pacman.getPosx() ] = 0;  
      pacman.moverElemento( pacman.getDirection() );
      iMatrizObj [ pacman.getPosy() ][ pacman.getPosx() ] = 3;  
    }
    
    private void moverGhost(int iPos)
    {
      iMatrizObj [ fantasmitas.get(iPos).getPosy() ][fantasmitas.get(iPos).getPosx()] = 0;
      fantasmitas.get(iPos).moverElemento( fantasmitas.get(iPos).getDireccion() );
      iMatrizObj [ fantasmitas.get(iPos).getPosy() ][fantasmitas.get(iPos).getPosx()] = 2;
    }
    
    
    public void moverFantasmas(int iTiempo)
    {
            for(int i = 0; i < fantasmitas.size(); i++)
            {
                switch(fantasmitas.get(i).getDireccion())
                {
                    case UP:
                        
                           if( iMatrizObj[ fantasmitas.get(i).getPosy() - 1 ][ fantasmitas.get(i).getPosx() ] != 1 && iTiempo < 10)
                           {
                             moverGhost(i);  
                           }
                           else
                           {
                              fantasmitas.get(i).setDireccion( this.getRandomDirection() );
                           }
                               
                        break;
                        
                    case DOWN:
                           
                          if(iMatrizObj[ fantasmitas.get(i).getPosy() + 1][fantasmitas.get(i).getPosx()] != 1 && iTiempo < 10)
                          {
                             moverGhost(i);   
                          }
                          else
                          {
                              fantasmitas.get(i).setDireccion( this.getRandomDirection() );
                          }
                        
                        break;
                    case LEFT:
                         
                          if(iMatrizObj[ fantasmitas.get(i).getPosy()][fantasmitas.get(i).getPosx() - 1] != 1 && iTiempo < 10)
                          {
                             moverGhost(i);   
                          }
                          else
                          {
                              fantasmitas.get(i).setDireccion( this.getRandomDirection() );
                          }
                        break;
                        
                    case RIGHT:
                        
                        if(iMatrizObj[ fantasmitas.get(i).getPosy() ][fantasmitas.get(i).getPosx() + 1] != 1 && iTiempo < 10)
                          {
                             moverGhost(i);   
                          }
                          else
                          {
                              fantasmitas.get(i).setDireccion( this.getRandomDirection() );
                          }
                        
                        break;
                }
                
                
                    for(int m=0; m < bombas.size(); m++)
                    {
                             if( fantasmitas.get(i).getPosx() == bombas.get(m).getPosx() && fantasmitas.get(i).getPosy() == bombas.get(m).getPosy())
                            {

                                iMatrizObj [fantasmitas.get(i).getPosy()][ fantasmitas.get(i).getPosx()] = 0;

                                fantasmitas.remove(i);
                                bombas.remove(m); 

                            }
                    }  
            }    
    }
    
     public boolean isPlaying()
     {
          boolean bFinish = false;
          
          
          
            for(int i=0;i < fantasmitas.size() ;i++)
            {
                  if( fantasmitas.get(i).getPosx() == pacman.getPosx() &&  fantasmitas.get(i).getPosy() == pacman.getPosy())
                  {
                     bFinish = true;
                  }
             
            }
            
          
          
          return bFinish;
     }
     
    public void setRandomDirectionGhosts()
    {
      for(int i = 0;i <  fantasmitas.size() ; i++)
      {  
        fantasmitas.get(i).setDireccion( this.getRandomDirection() );
      }
    }
           
    public boolean esGanador()
    {  
//        si se acaban las monedas ganas
        checkCoins();
        return coins.isEmpty();
    } 

    
    public void checkCoins()
    {
       for(int i=0; i < coins.size() ;i++)
       {
            if( pacman.getPosx() == coins.get(i).getPosx() && pacman.getPosy() == coins.get(i).getPosy())
            {
                coins.remove(i);//libera la memoria y elimina el objeto
            }
       } 
    }
    
    public int getRandomDirection()
    {
         Random rnd = new Random();
         return (rnd.nextInt(4)+1);
    }

    @Override
    public void moverElemento(int iEstado) {
//        No se utiliza 
    }
    
}
