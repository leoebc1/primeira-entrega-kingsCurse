/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kingsCurse;

/**
 *
 * @author LEONARDOESLABAOBARBO
 */
public class Arqueiro extends Personagem {

    public Arqueiro(String nome) {
        super(nome);
        this.forca = Dados.rolarMultiplo(6, 2);
        this.vida = Dados.rolarMultiplo(6, 5) + 3;
        this.mana = Dados.rolarDado(6) - 2;
        this.agilidade = Dados.rolarMultiplo(6, 2) + 3;
        this.aptidaoMagica = Dados.rolarDado(6) - 3;
        this.armaPrincipal = new Arma("Arco", "comum", "ranged");
        this.especial = "Arrow To The Knee";
    }

    @Override
    public int ataque(int armaduraInimigo) {
        int rolagem = Dados.rolarDado(6);
        if (this.armaPrincipal.getDistancia().equals("ranged")) {
            if (this.armaPrincipal.getTipo().equals("magico")) {
                System.out.println("Voce lança uma magia com " + this.armaPrincipal.getNome());
            } else {
                System.out.println("Voce dispara com " + this.armaPrincipal.getNome());
            }
        } else { 
            if (this.armaPrincipal.getTipo().equals("magico")) {
                System.out.println("Voce conjura uma magia com " + this.armaPrincipal.getNome());
            } else {
                System.out.println("Voce golpeia com " + this.armaPrincipal.getNome());
            }
        }
        if ((rolagem + this.agilidade) > armaduraInimigo) {
            return Dados.rolarDado(6) + this.agilidade;
        } else {
            return 0;
        }
    }

    @Override
    public void especial(Inimigo inimigo) {
        if (this.especialDisponivel) {
            int efeito = Dados.rolarDado(4);
            inimigo.setForca(inimigo.getForca() - efeito);
            System.out.println("Voce dispara uma flecha no joelho do inimigo, prejudicando suas manobras e a execução de seus golpes.");
            System.out.println("A forca do inimigo foi diminuida em " + efeito);
        } else {
            System.out.println("Especial indisponivel, voce perdeu o turno.");
        }
    }
}
