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
public class Aventura {

    private Personagem jogador;
    private Scanner sc;

    public Aventura(Personagem jogador) {
        this.jogador = jogador;
        this.sc = new Scanner(System.in);
    }

    public int exibirMenu(String... opcoes) {
        int opcaoUsuario = -1; 

        while (true) {
            System.out.println("\nEscolha uma das opções:");

            for (int i = 0; i < opcoes.length; i++) {
                System.out.println("[" + (i + 1) + "] - " + opcoes[i]);
            }

            try {
                opcaoUsuario = sc.nextInt();
                if (opcaoUsuario >= 1 && opcaoUsuario <= opcoes.length) {
                    break;
                } else {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.nextLine(); 
            }
        }

        // Retorna a opção válida escolhida pelo usuário
        return opcaoUsuario;
    }

    public void evento01() {
        boolean loopEvento01 = true;
        while (loopEvento01) {
            App.limparConsole();
            System.out.println("Aventura 'A Taverna de Tennefort' iniciada!\n"
                    + "Voce esta em uma taverna movimentada na cidade de Tennefort.\n"
                    + "Voce eh " + this.jogador.getNome() + ", um mercenario de Vail Scaedu, um lugar distante, onde a sobrevivencia eh dificil.\n"
                    + "No entanto, apos semanas tentando encontrar trabalho, voce esta sem dinheiro e em busca de uma oportunidade.\n"
                    + "A cidade de Tennefort tem sido sua casa temporaria, mas o movimento esta fraco nos últimos tempos, e voce nao conseguiu emprego nas ultimas duas semanas.\n"
                    + "Voce esta sentado em uma mesa da taverna, observando as poucas pessoas que passam. O que voce fara agora?");
            System.out.println("\n\n [1] - Acenar para o taverneiro\n[2] - Olhar em volta\n[3] - Levantar-se e sair");
            int opcaoUsuario = this.sc.nextInt();
            switch (opcaoUsuario) {
                case 1:
                    evento02();
                    loopEvento01 = false;
                    break;
                case 2:
                    evento03();
                    loopEvento01 = false;
                    break;
                case 3:
                    evento04();
                    loopEvento01 = false;
                    break;
                default:
                    System.out.println("Opcao invalida, tente de novo");
            }
        }
    }

    //acenar para o taverneiro - concluido
    private void evento02() {
        App.limparConsole();
        System.out.println("O taverneiro, um homem gordo, careca e com um grande bigode loiro,");
        System.out.println("usando um avental de couro, se aproxima de voce com certa indiferenca");
        System.out.println("e pergunta: ");
        System.out.println("\"Hoje temos sopa de peixe com cebola e assado de texugo, o que vai ser?\"");
        int opcaoUsuario = exibirMenu("Pedir sopa de cebola", "Pedir assado de texugo", "Dispensar o taverneiro", "Perguntar sobre trabalho");
        switch (opcaoUsuario) {
            case 1:
                evento05();
                break;
            case 2:
                evento06();
                break;
            case 3:
                evento07();
                break;
            case 4:
                evento08();
                break;
        }
    }

    private void evento03() {
        System.out.println("Voce olha em volta na taverna.");
        System.out.println("O taverneiro, um homem gordo e careca, com um grande bigode, resmunga com um cliente bebedo,");
        System.out.println("enquanto o cozinheiro, um homem alto e de avental manchado, traz duas tigelas com alguma refeicao fumegante");
        System.out.println("e as larga em cima do balcao de madeira envelhecida.");
        System.out.println("O cheiro da comida mistura-se com o do rum e do tabaco que preenche o ambiente.");

        System.out.println("\nEm cima da lareira, um par de espadas curtas, velhas e enferrujadas,");
        System.out.println("enfeitam a parede de tabuas, refletindo o brilho das chamas que dançam no fogo.");
        System.out.println("Ao fundo, algumas risadas altas e o som de copos se chocando fazem a taverna parecer ainda mais viva.");

        System.out.println("\nA noite esta caindo, e o movimento na taverna esta aumentando.");
        System.out.println("Voce percebe que varias pessoas, cansadas de um longo dia de trabalho, chegam e se acomodam nas mesas.");
        System.out.println("Ao mesmo tempo, alguns beberroes entram, com os olhos injetados de alcool e o espirito pronto para arrumar confusao.");

        System.out.println("\nVoce nota alguns homens com rostos fechados e olhares desafiadores, sentados em uma mesa no canto.");
        System.out.println("Eles parecem estar aguardando alguma oportunidade.");
        System.out.println("Talvez valha a pena ficar atento a este pessoal, caso o clima fique ainda mais pesado.");

        FatoresDeDecisao.evento03Atento = true;

        int opcaoUsuario = exibirMenu("Acenar para o taverneiro", "Levantar-se e sair");
        switch (opcaoUsuario) {
            case 1:
                evento02();
                break;
            case 2:
                evento04();
                break;
        }

    }

    private void evento04() {
        App.limparConsole();
        System.out.println("Voce se levanta lentamente da mesa, sentindo o ambiente da taverna vibrar com risos e conversas animadas.");
        System.out.println("Decide que talvez seja hora de sair, entao comeca a caminhar em direcao a porta.");
        System.out.println("A medida que voce se aproxima da saida, a porta da taverna se abre com um estrondo e tres homens entram abruptamente.");

        System.out.println("\nUm dos homens, com uma mascara que cobre o rosto e uma faca afiada na mao, grita:");
        System.out.println("\"E um assalto! Todos no chao, agora!\"");
        System.out.println("O taverneiro, surpreso, e rapidamente rendido e um dos assaltantes comeca a vasculhar o balcao, pegando as moedas.");

        System.out.println("\nO outro assaltante, com um olhar furioso, comeca a gritar com os aldeoes, tentando amedronta-los.");
        System.out.println("A taverna se enche de tensao, as pessoas gritam e se agacham, mas e claro que a situacao esta completamente fora de controle.");

        System.out.println("\nO terceiro homem, que observa a cena com um olhar calculista, nota voce na porta.");
        System.out.println("Seu olhar se estreita enquanto avalia seu porte e sua postura. Algo em voce chama sua atencao.");
        System.out.println("\"Voce nao e um aldeao comum...\" ele murmura, e imediatamente se prepara para avancar em sua direcao.");

        System.out.println("\nEle avanca rapidamente, puxando uma lamina enquanto um sorriso cruel se espalha por seu rosto.");
        System.out.println("Voce sente o peso do momento. Esta na hora de se preparar.");

        System.out.println("\nVocê rapidamente se posiciona, pronto para enfrentar o assaltante e qualquer outro que se aproxime.");
        System.out.println("\nPressione ENTER para preparar-se para a batalha.");

        this.sc.nextLine();
        this.sc.nextLine();

        System.out.println("A batalha está prestes a começar...");

        Inimigo inimigo = new Inimigo("Assaltante", Dados.rolarDado(6), Dados.rolarMultiplo(6, 3), Dados.rolarDado(6));


        Batalha batalhaEvento04 = new Batalha(this.jogador, inimigo);
        
        boolean batalhaVencida = batalhaEvento04.iniciarBatalha();
    }

    //pedir sopa de peixe com cebola
    private void evento05() {
        App.limparConsole();
        System.out.println("O taverneiro vai ate atras do balcao e entao retorna com uma cumbuca");
        System.out.println("de sopa de peixe com cebola, que tem um cheiro forte e desagradavel de peixe.");
        System.out.println("Mas quando voce experimenta, o sabor e suave e agradavel, perfeito para quem");
        System.out.println("esta com bastante fome.");
        this.sc.nextLine();
        evento04();
    }

    //pedir assado de texugo
    private void evento06() {
        System.out.println("O taverneiro vai ate atras do balcao e grita algo para algum funcionario na cozinha.");
        System.out.println("Ele parece estar irritado, mas logo retorna com um prato contendo um pedaço de carne");
        System.out.println("de texugo assada com batatas amassadas. O cheiro e forte e o prato solta bastante vapor.");
        System.out.println("Ao experimentar, a carne e borrachuda e com um sabor muito presente de gordura");
        System.out.println("e um sabor terroso e silvestre, distinto de outras carnes de caça. Nao e exatamente");
        System.out.println("agradavel, mas mata a fome.");
        evento09();
    }

    private void evento07() {
        System.out.println("Acha que eu estou brincando? O taverneiro resmunga para voce, com um estalar");
        System.out.println("de beicos, enquanto da meia volta. 'Da proxima vez va voce ate o balcao, seu");
        System.out.println("fanfarrão,' diz ele, retornando a passos firmes para tras do bar.");
        evento09();
    }

    private void evento08() {
        System.out.println("O taverneiro cruza os bracos e tenta se recordar sem fazer muito esforço.");
        System.out.println("\"Aqui nao precisamos de mais funcionarios,\" apressa-se em dizer. \"Mas se me");
        System.out.println("recordo bem, o ferreiro Fintch estava precisando de um ajudante. E tambem");
        System.out.println("existe a possibilidade de voce trabalhar juntando bosta de cavalo na mansao");
        System.out.println("do Barao,\" diz com um sorriso amarelo e debochado. \"Nao e grandes coisa, e");
        System.out.println("tambem nao paga bem. Mas e melhor do que passar fome... ou nao.\"");
        System.out.println("E entao, o homem gordo e grande da meia volta rindo, retira seu pano de cima");
        System.out.println("do ombro, atira-o por cima do balcao e volta para seus afazeres.");
        evento09();
    }

    private void evento09() {

    }

}
