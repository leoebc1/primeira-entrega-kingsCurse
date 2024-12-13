/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kingsCurse;

/**
 *
 * @author LEONARDOESLABAOBARBO
 */
public class Guerreiro extends Personagem {

    public Guerreiro(String nome) {
        super(nome);
        this.forca = Dados.rolarMultiplo(6, 2) + 3;
        this.vida = Dados.rolarMultiplo(6, 5) + 5;
        this.mana = Dados.rolarDado(6) - 2;
        this.agilidade = Dados.rolarDado(6);
        this.aptidaoMagica = Dados.rolarDado(6) - 3;
        this.armaPrincipal = new Arma("Espada", "comum", "melee");
        this.especial = "Intimidacao";
        this.especialDisponivel = true;
    }

    @Override
    public int ataque(int armaduraInimigo) {
        int rolagem = Dados.rolarDado(6);
        System.out.println("Voce golpeia com " + this.armaPrincipal.getNome());
        if ((rolagem + this.agilidade) > armaduraInimigo) {
            return Dados.rolarDado(6) + this.forca;
        } else {
            return 0;
        }
    }

    
    @Override
    public void especial(Inimigo inimigo) {
        if (this.especialDisponivel) {
            int efeito = Dados.rolarDado(4);
            inimigo.setAgilidade(inimigo.getAgilidade() - efeito);
            System.out.println("Voce assume uma postura confiante e alveja o inimigo com um olhar furioso.");
            System.out.println("A agilidade do inimigo foi diminuida em " + efeito);
        } else {
            System.out.println("Especial indisponivel");
        }

    }

}
