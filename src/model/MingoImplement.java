package model;

import interfaces.MingoCom;

import java.util.ArrayList;

/**
 * Created by Administrator on 4/24/14.
 */
public class MingoImplement implements MingoCom {

    ArrayList<Boolean> actuadores;
    ArrayList<Boolean> sensores;
    int miliseconds;

    public MingoImplement() {
        actuadores=new ArrayList<Boolean>();
        sensores=new ArrayList<Boolean>();
        for(int i=0;i<8;i++){
            actuadores.add(false);
            sensores.add(false);
        }
    }

    @Override
    public MingoCom cilindroVertical(boolean estado) {
        actuadores.set(5,estado);
        return this;
    }

    @Override
    public MingoCom cilindroRadial(boolean estado) {
        actuadores.set(4,estado);
        return this;
    }

    @Override
    public MingoCom actuadorDeGiro(boolean estado) {
        actuadores.set(3,estado);
        return this;
    }

    @Override
    public MingoCom manoApertura(boolean estado) {
        actuadores.set(2,estado);
        return this;
    }

    @Override
    public MingoCom manoGiro(boolean estado) {
        actuadores.set(1,estado);
        return this;
    }

    @Override
    public MingoCom cilindroTope(boolean estado) {
        actuadores.set(0,estado);
        return this;
    }

    @Override
    public MingoCom ignorarSensores(boolean estado) {
        sensores.set(5,estado);
        return this;
    }

    @Override
    public MingoCom sensorCilindroRadial(boolean estado) {
        sensores.set(4,estado);
        return this;
    }

    @Override
    public MingoCom sensorGiroDerecho(boolean estado) {
        sensores.set(3,estado);
        return this;
    }

    @Override
    public MingoCom sensorGiroIzquierdo(boolean estado) {
        sensores.set(2,estado);
        return this;
    }

    @Override
    public MingoCom sensorCilindroVertical(boolean estado) {
        sensores.set(1,estado);
        return this;
    }

    @Override
    public MingoCom timeout(int milliseconds) {
        this.miliseconds=milliseconds;
        return this;
    }

    @Override
    public MingoCom sensorTope(boolean estado) {
        sensores.set(0,estado);
        return this;
    }

    @Override
    public char[] serializeState() {
        int intActuadores=0;
        for(int i=0;i<actuadores.size();i++){
            intActuadores+=Math.pow(10,7-i)*(actuadores.get(i)?1:0);
        }
        int intSensores=0;
        for(int i=0;i<sensores.size();i++){
            intSensores+=Math.pow(10,7-i)*(sensores.get(i)?1:0);
        }
    //    String ret=""+(intActuadores+Math.pow(10,8)*intSensores);

       // return String.format("%016d",(long)(intActuadores+Math.pow(10,8)*intSensores))+miliseconds.byteValue();
        char [] ret= new char[3];
        //String cuasi= String.format("%08d",(long)(intActuadores));
        ret[0]=(char) Integer.parseInt(String.format("%08d",(long)(intActuadores)),2);
        ret[1]=(char) Integer.parseInt(String.format("%08d",(long)(intSensores)),2);
        ret[2]=(char) miliseconds;
         return ret;
    }


    public static void main(String[] args) {
          MingoCom mi=new MingoImplement();
        mi=mi.cilindroVertical(true).ignorarSensores(true).sensorGiroIzquierdo(true).cilindroTope(true).manoGiro(true).actuadorDeGiro(true).timeout(33);
        System.out.println(mi.serializeState());
                         //          Byte b= Byte.decode("1001");
//        System.out.println(b);
//        System.out.println(((Byte)Byte.parseByte(mi.serializeState())).byteValue());
        //System.out.println(Long.MAX_VALUE);
    }
}

