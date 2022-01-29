#include "mbed.h"
#include "DS1302.h"
#include "time.h"
using namespace std;
#include <ctime>
#include <string>


RawSerial pc(USBTX, USBRX);
AnalogIn Ain(A1);
DigitalOut lrojo (D7); 
DigitalOut lazul (D6);
DS1302 rtc (D15,D14,D13);


int ADCdata, serial=0,estado=0,datoSensor, lsup=0,linf=0;
string limiteinf="0",limitesup="0",datoReloj;
char msjeLimS[6];
char msjeLimI[6];
time_t tiempo = time(NULL);

void leer_serial()                                                               //Metodo de lectura
{
      if(pc.readable()) {

        for (int i=0; i<6; i++) {                                                //lectura limite superior
            msjeLimS[i]=pc.getc();
            if(msjeLimS[i]==35) {
                msjeLimS[i]= ' ';
                i=7;
            }

        }
      
      string limitesup(msjeLimS);
      //pc.printf ("lims %s\n",&limitesup);
      lsup=atoi(msjeLimS);
      lsup = (lsup*32767/156)+32767;
      // pc.printf ("%d\n",lsup);
      
      for (int j=0; j<6; j++) {                                                  //lectura limite inferior
            msjeLimI[j]=pc.getc();
            if(msjeLimI[j]==35) {
                msjeLimI[j]= ' ';
                j=7;
            }
        }
        
     string limiteinf(msjeLimI);
     linf=atoi(msjeLimI);
     linf = (linf*32767/156)+32767;
     // linf = (-((linf - 156) * 32767) /156);
     //pc.printf ("%d\n",linf);
      
      if (limitesup!=limiteinf){                                                 //Iniciar serial
            serial=1;
      }
    } 
}

void leer_sensor(){
     
        int valor=0;
        int vector[10];
        for (int i=0; i<10; i++) {
            vector[i]= Ain.read_u16();
            valor= valor +vector[i];                                             //Toma de datos
            wait (0.01);        
        }             
        ADCdata = valor/10;        
        datoSensor=900000+ADCdata;
        pc.printf ("%d",datoSensor);      
        wait (0.02);    
}

void inicializaserial()                                                          // Se inicializa comunicacion RS232
{
    pc.baud(115200);
    pc.attach(&leer_serial);
}

void reloj(){
    
     tiempo=rtc.time();                                                          //Toma datos reloj
     pc.printf("%d",tiempo);       
     wait(0.005);
     
} 

void comparacion(){ 

    if(ADCdata>= lsup){
        lrojo=1;
        lazul=0;
    }
    else if (ADCdata<=linf){
        lrojo=0;
        lazul=1;
    }
    
    if (((ADCdata<= linf) || (ADCdata>= lsup))&&(estado==0)) {

        reloj();
        estado=1;

    }
    else if (((ADCdata> linf) && (ADCdata< lsup))&&(estado==1)) {

        lrojo=0;
        lazul=0;
        reloj();
        estado=0;
    }
}

int main(){
    
    inicializaserial();    
    //rtc.set_time(1638907020);                                                     //Inicializacion RTC
    pc.printf ("%d",23000); 
    
    
    while (1) {
       if(serial==1){
        leer_sensor();
        comparacion();
        }
    }      
               
}
