package tarea1;

import java.awt.*;

public class pincel extends Canvas{ //herenda de canvas o lienzo
    
    int x=0,y=0,xa=0,ya=0,lims=0,limi=0,limsa=0,limia=0;//la mitad del lienzo
    int acceso=0;
    int limf=0;// variable para borrar
    
    //METODOS ESPECIFICOS PARA GRAFICACION
    
    public void transferencia(int vx, int vy){ // metodo para tarasfderencia de informacion
        
        xa=x;
        ya=y;
        x=vx; 
        y=vy;
         if (xa>x){
             xa=0;
         }
    }
    public void transferencialim(int limi,int lims){ // metodo para tarasfderencia de informacion
                
        limia=this.limi;
        limsa=this.lims;  
        this.limi=limi;
        this.lims=lims;
        acceso=3;
    }
    
    public void borrar (int f){
        acceso=f;        
    }
    
    public void paint (Graphics lapiz){// metodo propio de java
        
        lapiz.setColor(new Color (227,227,227));
        
        for (int i=0;i<=600;i=i+60){
            for(int j=0;j<=312;j=j+52){
                lapiz.drawLine(0, j, 600,j); //pinjtar los gradilla horizontal
                for (int p=0;p<600;p=p+12){
                    lapiz.setColor(new Color (0,0,0));
                    lapiz.drawLine(p, 152, p,158); //pinjtar los gradilla    
                }
                lapiz.setColor(new Color (227,227,227));
                lapiz.drawLine(i, 0, i,600); //pinjtar los gradilla horizontal
            }
            lapiz.drawLine(i, 0, i,600); //pinjtar los gradilla vertical
        }
        lapiz.setColor(new Color (0,0,0));
        lapiz.drawLine(0, 155, 600,155); //pinjtar los ejes x la esquina superior es 0.0
    }
    
    
    public void update (Graphics lapiz){
        
        if (acceso==0){ // tener encuenta los limites del canvas que se establecieron previamente
            lapiz.setColor(new Color (255,0,0));
            lapiz.drawLine(xa, ya, x, y);
        }  
        if (acceso==3){
            
            lapiz.setColor(new Color(255, 255, 255));
            lapiz.drawLine(0,limia,600, limia); //pinjtar los gradilla horizontal
            lapiz.drawLine(0, limsa, 600, limsa); //pinjtar los gradilla horizontal

            lapiz.setColor(new Color(0, 132, 0));
            lapiz.drawLine(0,limi,600, limi); //pinjtar los gradilla horizontal
            lapiz.setColor(new Color(0, 0, 255));
            lapiz.drawLine(0, lims, 600, lims); //pinjtar los gradilla horizontal
            acceso=0;
        }
        else if(acceso==1) {
            lapiz.clearRect(0, 0, 600, 312); // borra todo el canvas
            paint (lapiz);
            acceso=3;        
          }     
               
    }
    
    
    
}
