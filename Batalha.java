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
    
    public boolean fugir(){
        Scanner sc = new Scanner(System.in);
        App.limparConsole();
        System.out.println("Para fugir voce deve passar em dois testes de agilidade.\nTecle ENTER para jogar os dados e tentar desengajar do combate.");
        sc.nextLine();
        int teste = Dados.rolarDado(6);
        int total = teste + this.jogador.getAgilidade();
        App.limparConsole();
        System.out.println("Voce rolou " + teste + " + Agilidade: " + this.jogador.getAgilidade() + "\nTotal: " + total);
        if(total >= 3 + this.inimigo.getAgilidade()){
            System.out.println("\n\nVoce coordena seus movimentos e escapa do proximo golpe do inimigo.\nTecle ENTER para jogar os dados e tentar fugir.");
            sc.nextLine();
            teste = Dados.rolarDado(6);
            total = teste + this.jogador.getAgilidade();
            if(total >= 4 + this.inimigo.getAgilidade()){
                System.out.println("Voce consegue se desvencilhar do combate com sucesso.");
                return true;
            } else {
                System.out.println("Voce tenta fugir, mas o inimigo apressa o passo e lhe alcanca.");
                return false;
            }
        }else {
            System.out.println("Voce tenta escapar do proximo golpe do inimigo, mas ele eh mais rapido e consegue prever seus movimentos.");
            return false;
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
    
    public void mostraHP(){
        System.out.println("Seu HP: " + this.jogador.getVida());
        if(this.jogador instanceof Arqueiro){
            System.out.println("Sua Mana: " + this.jogador.getMana());
        }
    }
    
    public void mostraInimigo(){
        System.out.println("\n\n\n\n\n" + this.inimigo.getNome());
        System.out.println("HP: " + this.inimigo.getVida());
        System.out.println("FOR: " + this.inimigo.getForca());
        System.out.println("DEX: " + this.inimigo.getAgilidade() + "\n\n\n\n\n");
    }

    public int iniciarBatalha() {
        Scanner sc = new Scanner(System.in);
        
        if(!this.jogador.getEspecialDisponivel()){
            this.jogador.recuperaEspecial();
        }

        while (!batalhaTermina()) {

            App.limparConsole();
            mostraHP();
            mostraInimigo();
            System.out.println("[1] Atacar com " + this.jogador.armaPrincipal.getNome() + "\n[2] Utilizar " + this.jogador.getNomeEspecial() + "\n[3] Fugir");
            int opcaoUsuario = sc.nextInt();
            App.limparConsole();
            switch (opcaoUsuario) {
                case 1:
                    this.atacarJogador();
                    break;
                case 2:
                    this.jogador.especial(inimigo);
                    this.jogador.gastaEspecial();
                    break;
                case 3:
                    boolean fuga = this.fugir();
                    if (fuga){
                        return 2;
                    }
                    break;
                default:
                    System.out.println("Opcao invalida, voce perdeu o turno.");
                    break;
            }
            sc.nextLine();
            if (batalhaTermina()) {
                break;
            }

            atacarInimigo();
            System.out.println("Tecle ENTER para continuar...");
            sc.nextLine();
        }

        if (jogador.getVida() > 0) {
            System.out.println(jogador.getNome() + " venceu a batalha!");
            return 1;
        } else {
            System.out.println(inimigo.getNome() + " venceu a batalha!");
            return 0;
        }

    }
}
