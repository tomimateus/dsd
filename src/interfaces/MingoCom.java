package interfaces;

/**
 * Created by Administrator on 4/24/14.
 */
public interface MingoCom {

    public MingoCom cilindroVertical(boolean estado);

    public MingoCom cilindroRadial(boolean estado);

    public MingoCom actuadorDeGiro(boolean estado);
    public MingoCom manoApertura(boolean estado);
    public MingoCom manoGiro(boolean estado);
    public MingoCom cilindroTope(boolean estado);


    public MingoCom ignorarSensores(boolean estado);
    public MingoCom sensorCilindroRadial(boolean estado);
    public MingoCom sensorGiroDerecho(boolean estado);
    public MingoCom sensorGiroIzquierdo(boolean estado);
    public MingoCom sensorCilindroVertical(boolean estado);

    public MingoCom timeout(int milliseconds);

    public MingoCom sensorTope(boolean estado);

    public char[] serializeState();

    //TODO hacer los demas metodods para comunicacion
}
