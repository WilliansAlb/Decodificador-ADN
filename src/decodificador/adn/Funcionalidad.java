/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decodificador.adn;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author yelbetto
 */
public class Funcionalidad {

    private String secuencia_adn_1 = "";
    private String secuencia_adn_2 = "";

    public Funcionalidad() {

    }

    /**
     * Metodo que le solicita al usuario que ingrese las secuencias por medio de la consola
     */
    public void Solicitar_Secuencias() {
        System.out.println("--------------Decodificador ADN-----------------");
        System.out.println("Ingresa la primera secuencia: ");
        Scanner ingreso = new Scanner(System.in);
        setSecuencia_adn_1(ingreso.nextLine());
        System.out.println("Ingresa la segunda secuencia: ");
        setSecuencia_adn_2(ingreso.nextLine());
        System.out.println(Decodificar_Version2(getSecuencia_adn_1(), getSecuencia_adn_2()));
    }

    /**
     *  Metodo que encuentra conjuntos ordenados que coinciden tanto en la secuencia A como la secuencia B y devuelve el de mayor tamaño
     * @param secuencia1 Secuencia A ingresada por el usuario
     * @param secuencia2 Secuencia B ingresada por el usuario
     * @return Retorna el conjunto ordenado de mayor tamaño existente en las dos secuencias
     */
    public String Decodificar(String secuencia1, String secuencia2) {
        String secuencia_temporal = secuencia1.charAt(0) + "";
        ArrayList<String> secuencias_encontradas = new ArrayList();
        for (int i = 1; i < (secuencia1.length()); i++) {
            if (secuencia2.contains(secuencia_temporal + secuencia1.charAt(i))) {
                if (i != (secuencia1.length() - 1)) {
                    if (secuencia2.contains(secuencia_temporal + secuencia1.charAt(i) + secuencia1.charAt(i + 1))) {
                        secuencia_temporal += secuencia1.charAt(i);
                    } else {
                        if (secuencia_temporal.length() > 1) {
                            secuencias_encontradas.add(secuencia_temporal + secuencia1.charAt(i));
                        }
                        secuencia_temporal = secuencia1.charAt(i) + "";
                    }
                } else {
                    secuencias_encontradas.add(secuencia_temporal + secuencia1.charAt(i));
                }

            } else {
                if (secuencia_temporal.length() > 1) {
                    secuencias_encontradas.add(secuencia_temporal);
                }
                secuencia_temporal = secuencia1.charAt(i) + "";
            }
        }
        int posicion_array = 0;
        int tamaño_mayor = 0;
        System.out.println(secuencias_encontradas.size());
        if (secuencias_encontradas.size() > 0) {
            for (int i = 0; i < secuencias_encontradas.size(); i++) {
                if (i == 0) {
                    tamaño_mayor = secuencias_encontradas.get(i).length();
                    posicion_array = i;
                } else {
                    if (tamaño_mayor <= secuencias_encontradas.get(i).length()) {
                        tamaño_mayor = secuencias_encontradas.get(i).length();
                        posicion_array = i;
                    }
                }
                System.out.println(secuencias_encontradas.get(i));
            }
            return secuencias_encontradas.get(posicion_array);
        } else {
            return "NO EXISTEN COINCIDENCIAS";
        }
    }

    public String getSecuencia_adn_1() {
        return secuencia_adn_1;
    }

    public void setSecuencia_adn_1(String secuencia_adn_1) {
        this.secuencia_adn_1 = secuencia_adn_1;
    }

    public String getSecuencia_adn_2() {
        return secuencia_adn_2;
    }

    public void setSecuencia_adn_2(String secuencia_adn_2) {
        this.secuencia_adn_2 = secuencia_adn_2;
    }
    /**
     * Segunda version del metodo que encuentra conjuntos ordenados que coinciden tanto en la secuencia A como la secuencia B y devuelve el de mayor tamaño
     * @param secuencia_a Secuencia A ingresada por el usuario
     * @param secuencia_b Secuencia B ingresada por el usuario
     * @return Retorna el conjunto ordenado de mayor tamaño existente en las dos secuencias
     */
    public String Decodificar_Version2(String secuencia_a, String secuencia_b) {
        ArrayList<String> secuencias_encontradas = new ArrayList();
        String secuencia1 = "";
        String secuencia2 = "";
        String secuencia_temporal = "";

        if (secuencia1.length() >= secuencia2.length()) {
            secuencia1 = secuencia_a;
            secuencia2 = secuencia_b;
        } else {
            secuencia1 = secuencia_b;
            secuencia2 = secuencia_a;
        }
        boolean completado = false;
        int posicion = 0;

        while (!completado) {
            secuencia_temporal = secuencia1.charAt(posicion) + "";
            for (int i = (posicion + 1); i < secuencia1.length(); i++) {
                if (secuencia2.contains(secuencia_temporal + secuencia1.charAt(i))) {
                    if (i != (secuencia1.length() - 1)) {
                        if (secuencia2.contains(secuencia_temporal + secuencia1.charAt(i) + secuencia1.charAt(i + 1))) {
                            secuencia_temporal += secuencia1.charAt(i);
                        } else {
                            secuencias_encontradas.add(secuencia_temporal + secuencia1.charAt(i));
                            posicion++;
                            break;
                        }
                    } else {
                        secuencias_encontradas.add(secuencia_temporal + secuencia1.charAt(i));
                        posicion++;
                        break;
                    }
                } else {
                    posicion++;
                    break;
                }
            }
            completado = posicion == (secuencia1.length() - 1);
        }
        int posicion_array = 0;
        int tamaño_mayor = 0;

        if (secuencias_encontradas.size() > 0) {
            for (int i = 0; i < secuencias_encontradas.size(); i++) {
                if (i == 0) {
                    tamaño_mayor = secuencias_encontradas.get(i).length();
                    posicion_array = i;
                } else {
                    if (tamaño_mayor <= secuencias_encontradas.get(i).length()) {
                        tamaño_mayor = secuencias_encontradas.get(i).length();
                        posicion_array = i;
                    }
                }
            }
            return secuencias_encontradas.get(posicion_array);
        } else {
            return "NO EXISTEN COINCIDENCIAS";
        }
    }
}
