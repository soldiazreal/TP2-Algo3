package com.vista.clasesParaVista.vistaBloques;

public class VistaBloqueNulo extends VistaBloque{

    @Override
    public void asignarSiguiente(VistaBloque siguiente) {
    }

    @Override
    protected void asignarAnterior(VistaBloque anterior){
    }

    public VistaBloque ultimoSiguiente(){
        return this;
    }

    public boolean esNulo(){
        return true;
    }

    public VistaBloque copia(){
        return new VistaBloqueNulo();
    }
}
