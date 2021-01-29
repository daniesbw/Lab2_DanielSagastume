package lab2_danielsgastume;

import java.util.ArrayList;

public class Restaurante {

    private String nom_franquicia;
    private String nom_res;
    private String lugar;
    private int empleados;
    private boolean parqueo;
    private boolean juegos;
    private int mesas;
    private int cajeros;
    private String gerente;
    private String especialidad;
    private String estado;
    private ArrayList res;
    private boolean premiun;

    public Restaurante( String estado, String nom_franquicia, String nom_res, String lugar, int empleados, boolean parqueo, boolean juegos, int mesas, int cajeros, String gerente, String especialidad, ArrayList res, boolean premiun) {
        this.estado = estado;
        this.nom_franquicia = nom_franquicia;
        this.nom_res = nom_res;
        setLugar(lugar);
        this.empleados = empleados;
        this.parqueo = parqueo;
        this.juegos = juegos;
        this.mesas = mesas;
        this.res = res;
        this.cajeros = cajeros;
        this.gerente = gerente;
        this.especialidad = especialidad; 
        this.premiun=premiun;
    }

    public String getNom_franquicia() {
        return nom_franquicia;
    }

    public boolean isPremiun() {
        return premiun;
    }

    public void setPremiun(boolean premiun) {
        this.premiun = premiun;
    }

    public void setNom_franquicia(String nom_franquicia) {
        this.nom_franquicia = nom_franquicia;
    }

    public String getNom_res() {
        return nom_res;
    }

    public void setNom_res(String nom_res) {
        this.nom_res = nom_res;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar=lugar;
    }

    public int getEmpleados() {
        return empleados;
    }

    public void setEmpleados(int empleados) {
        this.empleados = empleados;
    }

    public boolean isParqueo() {
        return parqueo;
    }

    public void setParqueo(boolean parqueo) {
        this.parqueo = parqueo;
    }

    public boolean isJuegos() {
        return juegos;
    }

    public void setJuegos(boolean juegos) {
        this.juegos = juegos;
    }

    public int getMesas() {
        return mesas;
    }

    public void setMesas(int mesas) {
        this.mesas = mesas;
    }

    public int getCajeros() {
        return cajeros;
    }

    public void setCajeros(int cajeros) {
        this.cajeros = cajeros;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Franquicia=" + nom_franquicia+"\n" + ", Restaurante=" + nom_res+"\n"  + ", Ubicacion=" + lugar+"\n"  + ", Numero de Empleados=" + empleados+"\n"  + ", Parqueo=" + parqueo+"\n"  + ", Area de Juegos=" + juegos+"\n"  + ", Cantidad de mesas=" + mesas+"\n"  + ", Cantidad de cajeros=" + cajeros+"\n"  + ", Nombre del gerente=" + gerente+"\n"  + ", Especialidad=" + especialidad+"\n"  + ", Estado=" + estado+"\n"  + ", premiun=" + premiun+"\n";
    }

}
