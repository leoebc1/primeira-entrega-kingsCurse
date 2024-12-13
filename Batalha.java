/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kingsCurse;

import java.util.Scanner;

/**
 *
 * @author LEONARDOESLABAOBARBO
 */
public class Batalha {

    private Personagem jogador;
    private Inimigo inimigo;

    public Batalha(Personagem jogador, Inimigo inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    public void atacarJogador() {

        int dano = jogador.ataque(inimigo.getAgilidade());
        if (dano > 0) {
            System.out.println(jogador.getNome() + " atacou com sucesso! Dano causado: " + dano);
            inimigo.receberDano(dano);
        } else {
            System.out.println(jogador.getNome() + " falhou no ataque.");
        }
    }

    public void atacarInimigo() {
        int dano = inimigo.ataqueRanged(jogador.getAgilidade());
        if (dano > 0) {
            System.out.println(inimigo.getNome() + " atacou com sucesso! Dano causado: " + dano);
            jogador.receberDano(dano);
        } else {
            System.out.println(inimigo.getNome() + " falhou no ataque.");
        }
    }

    public boolean batalhaTermina() {
        if (jogador.getVida() <= 0) {
            System.out.println(jogador.getNome() + " foi derrotado!");
            return true;
        } else if (inimigo.getVida() <= 0) {
            System.out.println(inimigo.getNome() + " foi derrotado!");
            return true;
        }
        return false;
    }

    public boolean iniciarBatalha() {
        Scanner sc = new Scanner(System.in);

        while (!batalhaTermina()) {

            App.limparConsole();

            System.out.println("[1] Atacar com " + this.jogador.armaPrincipal.getNome() + "\n[2] Utilizar " + this.jogador.getNomeEspecial() + "\n[3] Fugir");
            int opcaoUsuario = sc.nextInt();
            switch (opcaoUsuario) {
                case 1:
                    this.atacarJogador();
                    break;
                case 2:
                    //usar especial
                    break;
                case 3:
                    //fugir
                    break;
            }
            sc.nextLine();
            atacarJogador();
            if (batalhaTermina()) {
                break;
            }

            atacarInimigo();
            System.out.println("Tecle ENTER para continuar...");
            sc.nextLine();
        }

        if (jogador.getVida() > 0) {
            System.out.println(jogador.getNome() + " venceu a batalha!");
            return true;
        } else {
            System.out.println(inimigo.getNome() + " venceu a batalha!");
            return false;
        }

    }
}
