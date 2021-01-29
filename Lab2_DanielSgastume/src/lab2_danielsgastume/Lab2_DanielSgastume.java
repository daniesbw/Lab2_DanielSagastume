/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_danielsgastume;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Lab2_DanielSgastume {

    static ArrayList res = new ArrayList();

    public static void main(String[] args) {
        String usuario = "david";
        String contraseña = "99";

        String user = JOptionPane.showInputDialog("Ingrese su nombre de usuario: ");
        while (!usuario.equals(user)) {//Validacion usuario
            JOptionPane.showMessageDialog(null, "Usuario incorrecta");
            user = JOptionPane.showInputDialog("Ingrese su nombre de usuario: ");
        }
        String contra = JOptionPane.showInputDialog("Ingrese su contraseña: ");
        while (!contra.equals(contraseña)) {//Validacion
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            contra = JOptionPane.showInputDialog("Ingrese su nombre de usuario: ");
        }
        int op = 0;
        while (op != 3) {
            op = Integer.parseInt(JOptionPane.showInputDialog("1. Reporte de restaurantes\n"
                    + "2. Manejo de restaurante\n"
                    + "3. Salir"));
            switch (op) {
                case 1://Reporte
                    int op_report = 0;
                    while (op_report != 5) {
                        op_report = Integer.parseInt(JOptionPane.showInputDialog("1. Reporte 1\n"
                                + "2. Reporte 2\n"
                                + "3. Reporte 3\n"
                                + "4. Extra\n"
                                + "5. Regresar al menu principal"));
                        switch (op_report) {
                            case 1:
                                int op_status = 0;
                                while (op_status != 4) {
                                    op_status = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el estado del restaurante que quiere ver\n"
                                            + "1. Funcional\n"
                                            + "2. Demolicion\n"
                                            + "3. Remoledacion\n"
                                            + "4. Regresar al menu principal"));
                                    switch (op_status) {
                                        case 1://Reporte funcional
                                            String salida = "";
                                            for (int i = 0; i < res.size(); i++) {
                                                if (((Restaurante) res.get(i)).getEstado().equals("Funcional")) {
                                                    salida += res.get(i);
                                                }
                                            }
                                            JOptionPane.showMessageDialog(null, salida);
                                            break;
                                        case 2://Reporte demolicion
                                            String salida1 = "";
                                            for (int i = 0; i < res.size(); i++) {
                                                if (((Restaurante) res.get(i)).getEstado().equals("Demolicion")) {
                                                    salida1 += res.get(i);
                                                }
                                            }
                                            JOptionPane.showMessageDialog(null, salida1);
                                            break;
                                        case 3:
                                            String salida2 = "";
                                            for (int i = 0; i < res.size(); i++) {
                                                if (((Restaurante) res.get(i)).getEstado().equals("Remoledacion")) {
                                                    salida2 += res.get(i);
                                                }
                                            }
                                            JOptionPane.showMessageDialog(null, salida2);
                                            break;
                                    }
                                }//Fin menu statius
                            case 2://Reporte premiun
                                String salida = "";
                                for (int i = 0; i < res.size(); i++) {
                                    if (((Restaurante) res.get(i)).isPremiun() == true) {
                                        salida += "===================================\n";
                                        salida += "Nombre del restaurante: " + ((Restaurante) res.get(i)).getNom_res() + "\n";
                                        salida += "Ubicacion: " + ((Restaurante) res.get(i)).getLugar() + "\n";
                                        salida += "Especialidad: " + ((Restaurante) res.get(i)).getEspecialidad() + "\n";
                                    }
                                }
                                JOptionPane.showMessageDialog(null, salida);
                                break;
                            case 3:
                                String salida1 = "";
                                for (int i = 0; i < res.size(); i++) {
                                    String franquicia = ((Restaurante) res.get(i)).getNom_franquicia();
                                    for (int j = 0; j < res.size(); i++) {
                                        if (((Restaurante) res.get(j)).getNom_franquicia().equals(franquicia)) {
                                            salida1 += "===================================\n";
                                            salida1 += "Nombre del restaurante: " + ((Restaurante) res.get(j)).getNom_res() + "\n";
                                            salida1 += "Ubicacion: " + ((Restaurante) res.get(j)).getLugar() + "\n";
                                            salida1 += "Especialidad: " + ((Restaurante) res.get(j)).getEspecialidad() + "\n";
                                        }
                                    }
                                }
                                JOptionPane.showMessageDialog(null, salida1);
                                break;
                            case 4:
                                String salida2 = "";
                                for (int i = 0; i < res.size(); i++) {
                                    int cont = 0;
                                    String nom = ((Restaurante) res.get(i)).getGerente();
                                    for (int j = 1; j < res.size(); j++) {//Que recorra todo las franquicias buscando al gerente
                                        if (((Restaurante) res.get(j)).getGerente().equals(nom)) {
                                            {
                                                cont++;
                                            }
                                        }
                                        if (cont >= 2) {
                                            salida2 += nom;
                                        }
                                    }
                                    JOptionPane.showMessageDialog(null, salida2);
                                    break;
                                }
                                break;//Break reporte
                        }
                    }
                case 2://Agregar, modificar y eliminar
                    int op_res = 0;
                    while (op_res != 5) {
                        op_res = Integer.parseInt(JOptionPane.showInputDialog("1. Crear restaurante\n"
                                + "2. Listar restaurante\n"
                                + "3. Modificar\n"
                                + "4. Eliminar\n"
                                + "5. Regresar al menu principal"));
                        switch (op_res) {
                            case 1:
                                int ess = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el estado de su restaurante: \n"
                                        + "1. Funcional\n"
                                        + "2. Remoledacion\n"
                                        + "3. Demolicion\n"));
                                if (ess == 1) {
                                    preguntaFuncional();
                                } else if (ess == 2) {
                                    String estado = "Remoledacion";
                                    preguntaDemoRemo(estado);
                                } else if (ess == 3) {
                                    String estado = "Demolicion";
                                    preguntaDemoRemo(estado);
                                }
                                break;//Agregar restaurante fin
                            case 2:
                                imprimirRes(res);
                                break;
                            case 3://Modificar
                                String salida = "";//Para que el usuario vea las posiciones
                                for (Object t : res) {
                                    if (t instanceof Restaurante) {
                                        salida += res.indexOf(t) + "- " + t + "\n";
                                    }
                                }
                                int p = Integer.parseInt(JOptionPane.showInputDialog(salida + "\n" + "Ingrese la poscion del restaurante que quiere modificar: "));
                                if (res.get(p) instanceof Restaurante) {
                                    int opTemp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese que quiere modificar: \n"
                                            + "1. Franquicia\n"
                                            + "2. Nombre del restaurante\n"
                                            + "3. Ubicacion\n"
                                            + "4. Cantidad de empleados\n"
                                            + "5. Parqueo\n"
                                            + "6. Area de juegos\n"
                                            + "7. Cantidad de mesas\n"
                                            + "8. Cantidad de cajeros\n"
                                            + "9. Nombre del gerente\n"
                                            + "10. Especialidad\n"));
                                    if (opTemp == 1) {
                                        String nom_fran = JOptionPane.showInputDialog("Ingrese el nombre de la franquicia: ");
                                        ((Restaurante) res.get(p)).setNom_franquicia(nom_fran);
                                    } else if (opTemp == 2) {
                                        String nom_res = JOptionPane.showInputDialog("Ingrese el nombre del restaurante: ");
                                        ((Restaurante) res.get(p)).setNom_res(nom_res);
                                    } else if (opTemp == 3) {
                                        String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicacion del restaurante ");
                                        int cont_iguales = 0;
                                        for (int i = 0; i < res.size(); i++) {
                                            if (ubicacion.equals(((Restaurante) res.get(i)).getLugar())) {
                                                cont_iguales++;
                                            }
                                        }
                                        if (cont_iguales == 0) {
                                            ubicacion = ubicacion;
                                        } else {
                                            boolean igual = true;
                                            while (igual = true) {
                                                ubicacion = JOptionPane.showInputDialog(null, "Hay un restaurante con la misma ubicacion\n"
                                                        + "Ingrese una nueva ubicacion:");
                                                int iguales = 0;
                                                for (int i = 0; i < res.size(); i++) {
                                                    if (ubicacion.equals(((Restaurante) res.get(i)).getLugar())) {
                                                        iguales++;
                                                    }
                                                }
                                                if (iguales == 0) {
                                                    igual = false;
                                                    ubicacion = ubicacion;
                                                }
                                            }
                                        }
                                        ((Restaurante) res.get(p)).setLugar(ubicacion);
                                    }//Fin opcion 3
                                    else if (opTemp == 4) {
                                        int empleados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de empleados: "));
                                        ((Restaurante) res.get(p)).setEmpleados(empleados);
                                    } else if (opTemp == 5) {
                                        String par = JOptionPane.showInputDialog("Tiene parque su restaurante(s/n): ");
                                        char pars = par.charAt(0);
                                        boolean parqueo = false;
                                        if (pars == 's' || pars == 'S') {
                                            parqueo = true;
                                        }
                                        ((Restaurante) res.get(p)).setParqueo(parqueo);
                                    } else if (opTemp == 6) {
                                        String games = JOptionPane.showInputDialog("Tiene area de juegos su restaurante(s/n): ");
                                        char g = games.charAt(0);
                                        boolean juegos = false;
                                        if (g == 's' || g == 'S') {
                                            juegos = true;
                                        }
                                        ((Restaurante) res.get(p)).setJuegos(juegos);
                                    } else if (opTemp == 7) {
                                        if (!((Restaurante) res.get(p)).getGerente().equals("N")) {//Si es funcional
                                            int mesas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de mesas: "));
                                            ((Restaurante) res.get(p)).setMesas(mesas);
                                        }
                                    } else if (opTemp == 8) {
                                        int cajeros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de cajeros: "));
                                        ((Restaurante) res.get(p)).setCajeros(cajeros);
                                    } else if (opTemp == 9) {
                                        if (!((Restaurante) res.get(p)).getGerente().equals("N")) {//If para saber si el estado es funcional para cambiar
                                            String gerente = JOptionPane.showInputDialog("Ingrese el nombre del gerente: ");
                                            int cont_iguales3 = 0;
                                            for (int i = 0; i < res.size(); i++) {
                                                if (gerente.equals(((Restaurante) res.get(i)).getGerente())) {
                                                    cont_iguales3++;
                                                }
                                            }
                                            if (cont_iguales3 < 2) {//Si hay menos de 2 entonces si
                                                gerente = gerente;
                                            } else {
                                                boolean igual = true;
                                                while (igual = true) {
                                                    gerente = JOptionPane.showInputDialog(null, "Hay un restaurante con la misma ubicacion\n"
                                                            + "Ingrese una nueva ubicacion:");
                                                    int iguales = 0;
                                                    for (int i = 0; i < res.size(); i++) {
                                                        if (gerente.equals(((Restaurante) res.get(i)).getGerente())) {
                                                            iguales++;
                                                        }
                                                    }
                                                    if (iguales < 2) {//Si hay menos de 2 entonces si
                                                        igual = false;
                                                        gerente = gerente;
                                                    }
                                                }
                                            }
                                            ((Restaurante) res.get(p)).setGerente(gerente);
                                        }

                                    }//Fin opcion 9
                                    else if (opTemp == 10) {
                                        if (!((Restaurante) res.get(p)).getGerente().equals("N")) {
                                            String especialidad = JOptionPane.showInputDialog("Ingrese la especialidad del restaurante: ");
                                            int cont_iguales2 = 0;
                                            for (int i = 0; i < res.size(); i++) {//Validacion especialidad

                                                if (((Restaurante) res.get(i)).getNom_franquicia().equals(((Restaurante) res.get(i)).getNom_franquicia()) && especialidad.equals(((Restaurante) res.get(i)).getEspecialidad())) {
                                                    cont_iguales2++;
                                                }
                                            }
                                            if (cont_iguales2 == 0) {
                                                especialidad = especialidad;
                                            } else {
                                                boolean igual = true;
                                                while (igual = true) {
                                                    especialidad = JOptionPane.showInputDialog(null, "Hay un restaurante con la especialidad\n"
                                                            + "Ingrese una nueva especialidad:");
                                                    int iguales = 0;
                                                    for (int i = 0; i < res.size(); i++) {
                                                        if (((Restaurante) res.get(i)).getNom_franquicia().equals(((Restaurante) res.get(i)).getNom_franquicia()) && especialidad.equals(((Restaurante) res.get(i)).getLugar())) {
                                                            iguales++;
                                                        }
                                                    }
                                                    if (iguales == 0) {
                                                        igual = false;
                                                        especialidad = especialidad;
                                                    }
                                                }

                                            }
                                            ((Restaurante) res.get(p)).setEspecialidad(especialidad);
                                        }
                                    }//fin opcion 10
                                    if (((Restaurante) res.get(p)).isJuegos() == true && ((Restaurante) res.get(p)).isParqueo() == true) {
                                        ((Restaurante) res.get(p)).setPremiun(true);
                                    }
                                }
                            case 4://Eliminar
                                String salida2 = "";//Para que el usuario vea las posiciones
                                for (Object t : res) {
                                    if (t instanceof Restaurante) {
                                        salida2 += res.indexOf(t) + "- " + t + "\n";
                                    }
                                }
                                int p2 = Integer.parseInt(JOptionPane.showInputDialog(salida2 + "\n" + "Ingrese la poscion del restaurante que quiere eliminar: "));
                                if (res.get(p2) instanceof Restaurante) {
                                    res.remove(p2);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Posicion incorrecta");
                                }
                                break;
                        }
                    }
                    break;//Agregar, modificar, eliminar
            }
        }//Fin while menu principal
    }//Fin del main

    static void imprimirRes(ArrayList res) {
        String salida = "";
        for (Object t : res) {
            salida += res.indexOf(t) + "- " + t + "\n";
        }
        JOptionPane.showMessageDialog(null, salida);
    }

    static void preguntaFuncional() {
        String estado = "Funcional";
        String nom_fran = JOptionPane.showInputDialog("Ingrese el nombre de la franquicia: ");
        String nom_res = JOptionPane.showInputDialog("Ingrese el nombre del restaurante: ");
        String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicacion del restaurante ");
        int cont_iguales = 0;
        if (res.size() > 0) {
            for (int i = 0; i < res.size()-1; i++) {
                if (ubicacion.equals(((Restaurante) res.get(i)).getLugar())) {
                    cont_iguales++;
                }
            }
            if (cont_iguales == 0) {
                ubicacion = ubicacion;
            } else {
                boolean igual = true;
                while (igual == true) {
                     ubicacion = JOptionPane.showInputDialog(null, "Hay un restaurante con la misma ubicacion\n"
                            + "Ingrese una nueva ubicacion:");
                    int iguales = 0;
                    for (int i = 0; i < res.size()-1; i++) {
                        if (ubicacion.equals(((Restaurante) res.get(i)).getLugar())) {
                            iguales++;
                        }
                    }
                    if (iguales == 0) {
                        igual = false;
                        ubicacion = ubicacion;
                    }
                }
            }
        }
        int empleados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de empleados: "));
        String par = JOptionPane.showInputDialog("Tiene parque su restaurante(s/n): ");
        char pars = par.charAt(0);
        boolean parqueo = false;
        if (pars == 's' || pars == 'S') {
            parqueo = true;
        }
        String games = JOptionPane.showInputDialog("Tiene area de juegos su restaurante(s/n): ");
        char g = games.charAt(0);
        boolean juegos = false;
        if (g == 's' || g == 'S') {
            juegos = true;
        }
        int mesas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de mesas: "));
        int cajeros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de cajeros: "));
        String gerente = JOptionPane.showInputDialog("Ingrese el nombre del gerente: ");
        int cont_iguales3 = 0;
        for (int i = 0; i < res.size(); i++) {
            if (gerente.equals(((Restaurante) res.get(i)).getGerente())) {
                cont_iguales3++;
            }
        }
        if (cont_iguales3 < 2) {//Si hay menos de 2 entonces si
            gerente = gerente;
        } else {
            boolean igual = true;
            while (igual == true) {
                gerente = JOptionPane.showInputDialog(null, "Hay un restaurante con la misma ubicacion\n"
                        + "Ingrese una nueva ubicacion:");
                int iguales = 0;
                for (int i = 0; i < res.size()-1; i++) {
                    if (gerente.equals(((Restaurante) res.get(i)).getGerente())) {
                        iguales++;
                    }
                }
                if (iguales < 2) {//Si hay menos de 2 entonces si
                    igual = false;
                    gerente = gerente;
                }
            }
        }
        String especialidad = JOptionPane.showInputDialog("Ingrese la especialidad del restaurante: ");
        int cont_iguales2 = 0;
        for (int i = 0; i < res.size()-1; i++) {//Validacion especialidad

            if (nom_fran.equals(((Restaurante) res.get(i)).getNom_franquicia()) && especialidad.equals(((Restaurante) res.get(i)).getEspecialidad())) {
                cont_iguales2++;
            }
        }
        if (cont_iguales2 == 0) {
            especialidad = especialidad;
        } else {
            boolean igual = true;
            while (igual == true) {//Mientras sea verdad
                especialidad = JOptionPane.showInputDialog(null, "Hay un restaurante con la especialidad\n"
                        + "Ingrese una nueva especialidad:");
                int iguales = 0;
                for (int i = 0; i < res.size()-1; i++) {//Chequea
                    if (nom_fran.equals(((Restaurante) res.get(i)).getNom_franquicia()) && especialidad.equals(((Restaurante) res.get(i)).getEspecialidad())) {
                        iguales++;
                    }
                }
                if (iguales == 0) {//Si no hay iguales lo asigna
                    igual = false;
                    especialidad = especialidad;
                }
            }

        }
        boolean premiun = false;
        if (juegos == true && parqueo == true) {
            premiun = true;
        }
        res.add(new Restaurante(estado, nom_fran, nom_res, ubicacion, empleados, parqueo, juegos, mesas,
                cajeros, gerente, especialidad, res, premiun));
    }

    static void preguntaDemoRemo(String estado1) {
        String estado = estado1;
        String nom_fran = JOptionPane.showInputDialog("Ingrese el nombre de la franquicia: ");
        String nom_res = JOptionPane.showInputDialog("Ingrese el nombre del restaurante: ");
        String ubicacion = JOptionPane.showInputDialog("Ingrese la ubicacion del restaurante ");
        int cont_iguales = 0;
        for (int i = 0; i < res.size()-1; i++) {
            if (ubicacion.equals(((Restaurante) res.get(i)).getLugar())) {
                cont_iguales++;
            }
        }
        if (cont_iguales == 0) {
            ubicacion = ubicacion;
        } else {
            boolean igual = true;
            while (igual == true) {
                ubicacion = JOptionPane.showInputDialog(null, "Hay un restaurante con la misma ubicacion\n"
                        + "Ingrese una nueva ubicacion:");
                int iguales = 0;
                for (int i = 0; i < res.size()-1; i++) {
                    if (ubicacion.equals(((Restaurante) res.get(i)).getLugar())) {
                        iguales++;
                    }
                }
                if (iguales == 0) {
                    igual = false;
                    ubicacion = ubicacion;
                }
            }

        }
        int empleados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de empleados: "));
        String par = JOptionPane.showInputDialog("Tiene parque su restaurante(s/n): ");
        char pars = par.charAt(0);
        boolean parqueo = false;
        if (pars == 's' || pars == 'S') {
            parqueo = true;
        }
        String games = JOptionPane.showInputDialog("Tiene area de juegos su restaurante(s/n): ");
        char g = games.charAt(0);
        boolean juegos = false;
        if (g == 's' || g == 'S') {
            juegos = true;
        }
        int mesas = 0;
        int cajeros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de cajeros: "));
        String gerente = "N";
        String especialidad = "N";

        boolean premiun = false;//Para saber si el res es premiun
        if (juegos == true && parqueo == true) {
            premiun = true;
        }
        res.add(new Restaurante(estado, nom_fran, nom_res, ubicacion, empleados, parqueo, juegos, mesas,
                cajeros, gerente, especialidad, res, premiun));
    }
}
