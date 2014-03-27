import gnu.io.*;
import java.util.Enumeration;

public class Program {

    private static final String port = "/dev/tty.usbserial";
    static String message = "puto\\";


    public static void main(String[] args) {
        Listener listener = new Listener();
        try {
            final Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
            CommPortIdentifier portId = null;
            SerialPort serialPort = null;

            while (portId == null && portEnum.hasMoreElements()) {
                CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
                if (currPortId.getName().equals(port) || currPortId.getName().startsWith(port)) {
                    // Try to connect to the Arduino on this port
                    serialPort = (SerialPort)currPortId.open("", 1000);
                    portId = currPortId;
                    break;
                }
            }

            serialPort.setSerialPortParams(1, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

            serialPort.addEventListener(listener);
            serialPort.notifyOnDataAvailable(true);

//            listener.ini

            System.out.println(""+message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


