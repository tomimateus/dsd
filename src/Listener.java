import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Listener implements SerialPortEventListener {

    SerialPort serialPort = null;
    private BufferedReader input;

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        //System.out.println("Event received: " + oEvent.toString());
        try {
            switch (serialPortEvent.getEventType() ) {
                case SerialPortEvent.DATA_AVAILABLE:
                    if ( input == null ) {
                        input = new BufferedReader(
                                new InputStreamReader(
                                        serialPort.getInputStream()));
                    }
                    String inputLine = input.readLine();
                    System.out.println(inputLine);
                    break;

                default:
                    break;
            }
        }
        catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
