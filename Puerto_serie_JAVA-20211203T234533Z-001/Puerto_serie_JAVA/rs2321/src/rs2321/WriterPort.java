package rs2321;

/*
 * WriterPort.java
 *
 * 
 */
import gnu.io.*;
import java.io.*;


/**
 *
 * 
 */
public class WriterPort {
    OutputStream outputStream;
    SerialPort serialPort;
    Thread readThread;
    public static WriterPort writerPort;

    /** Creates a new instance of WriterPort */
    private WriterPort(SerialPort serialPort) {
        //System.out.println("WriterPort "+Cronus._Velocidad);
        this.serialPort = serialPort;
        try {
            outputStream = serialPort.getOutputStream();
        } catch (IOException e) {}
        serialPort.notifyOnDataAvailable(true);
        try {
            
            serialPort.setSerialPortParams(115200,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);
        } catch (UnsupportedCommOperationException e) {}
    }
    
    public static WriterPort getInstance()
    {
        if (writerPort != null )
            return writerPort;
        
        writerPort  = new WriterPort(CronusPort.getAbailablePort());

        return writerPort;
    
    }

    public void escribir(String strDatos) throws IOException{
        try
        {
            this.outputStream.write(strDatos.getBytes());
        } catch (IOException e) {
            throw e;
        
        }
    }
}
