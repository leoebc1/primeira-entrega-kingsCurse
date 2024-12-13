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
        this.agilidade = Dados.rolarDado(6) + 3;
        this.aptidaoMagica = Dados.rolarDado(6) - 3;
        this.armaPrincipal = new Arma("Arco", "comum", "ranged");
    }
    
    
    public int ataque(int armaduraInimigo, int arma){
        int rolagem = Dados.rolarDado(6);
        if(this.armaPrincipal.getDistancia() == "ranged"){
            System.out.println("Voce dispara com " + this.armaPrincipal.getNome());
        } else {
            System.out.println("Voce golpeia com " + this.armaPrincipal.getNome());
        }
        if ((rolagem + this.agilidade) > armaduraInimigo){
            return Dados.rolarDado(6) + this.forca;
        } else {
            return 0;
        }
    }
}
