/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kingsCurse;

import java.util.Random;

/**
 *
 * @author LEONARDOESLABAOBARBO
 */
public class Dados {

    private static final Random random = new Random();

    public static int rolarDado(int faces) {
        return random.nextInt(faces) + 1;
    }

    public static int rolarMultiplo(int faces, int vezes) {
        int soma = 0;
        for (int i = 0; i < vezes; i++) {
            soma += rolarDado(faces);
        }
        return soma;
    }
}
