/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kingsCurse;

/**
 *
 * @author LEONARDOESLABAOBARBO
 */
public class Inimigo {

    protected String nome;
    protected int forca;
    protected int vida;
    protected int agilidade;
    
    public Inimigo(String nome, int forca, int vida, int agilidade) {
        this.nome = nome;
        this.forca = forca;
        this.vida = vida;
        this.agilidade = agilidade;
    }

    public Inimigo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public void receberDano(int danoRecebido) {
        this.vida -= danoRecebido;
    }

    public int ataqueMelee(int armaduraJogador) {
        int rolagem = Dados.rolarDado(6);
        if ((rolagem + this.agilidade) > armaduraJogador) {
            return Dados.rolarDado(6) + this.forca;
        } else {
            return 0;
        }
    }
    
    public int ataqueRanged(int armaduraJogador) {
        int rolagem = Dados.rolarDado(6);
        if ((rolagem + this.agilidade) > armaduraJogador) {
            return Dados.rolarDado(6) + this.forca;
        } else {
            return 0;
        }
    }
}

