/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package kingsCurse;

import java.util.Scanner;

public class App {

    private static Personagem jogador;

    public static void main(String[] args) {
        Artes.titulo();
        criarPersonagem();
        Aventura aventura = new Aventura(jogador);
        aventura.evento01();
    }

    public static void limparConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    
    public static void escrever(String texto){
        System.out.println(texto);
    }

    public static void criarPersonagem() {
        Scanner sc = new Scanner(System.in);
        //limparConsole();
        boolean sustentaMenuCriarPersonagem = true;

        while (sustentaMenuCriarPersonagem) {
            escrever("Insira o nome do seu personagem: ");
            String nome = sc.nextLine();

            escrever("Escolha sua classe: \n1 - Guerreiro\n2 - Mago\n3 - Arqueiro\n4 - Clérigo");
            int opcaoUsuario = sc.nextInt();
            sc.nextLine();

            switch (opcaoUsuario) {
                case 1:
                    jogador = new Guerreiro(nome);
                    sustentaMenuCriarPersonagem = false;
                    break;
                case 2:
                    //jogador = new Mago(nome);
                    sustentaMenuCriarPersonagem = false;
                    break;
                case 3:
                    //jogador = new Arqueiro(nome); 
                    sustentaMenuCriarPersonagem = false;
                    break;
                case 4:
                    //jogador = new Clerigo(nome); 
                    sustentaMenuCriarPersonagem = false;
                    break;
                default:
                    escrever("Opção inválida, tente novamente!");
                    break;
            }
        }
        limparConsole();
        System.out.println("Tecle ENTER para rolar seus dados...");
        sc.nextLine();
        limparConsole();
        escrever("Este eh voce: ");
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Pontos de vida: " + jogador.getVida());
        System.out.println("Pontos de mana: " + jogador.getMana());
        System.out.println("Forca: " + jogador.getForca());
        System.out.println("Agilidade: " + jogador.getAgilidade());
        System.out.println("Aptidao magica: " + jogador.getAptidaoMagica());
        System.out.println("\n\nTecle ENTER para comecar sua aventura...");
        sc.nextLine();
    }
}