public class Mago extends Personagem {
    public Mago(String nome) {
        super(nome);
        this.forca = Dados.rolarMultiplo(6, 1) + 2;
        this.vida = Dados.rolarMultiplo(6, 4) + 2;
        this.mana = Dados.rolarMultiplo(6, 2) + 5;
        this.agilidade = Dados.rolarMultiplo(6, 1) + 3;
        this.aptidaoMagica = Dados.rolarMultiplo(6, 2) + 6;
        this.armaPrincipal = new Arma("Cajado", "magico", "ranged");
        this.especial = "Drenar vida";
    }
    
    @Override
    public int ataque(int armaduraInimigo){
        this.mana -= 1;
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
        if ((rolagem + this.aptidaoMagica) > armaduraInimigo){
            return Dados.rolarDado(6) + this.aptidaoMagica;
        } else {
            return 0;
        }
    }
    
    @Override
    public void especial(Inimigo inimigo){
        if (this.especialDisponivel) {
            this.gastaEspecial();
            int efeito = Dados.rolarMultiplo(4, 2) + 4;
            inimigo.setVida(inimigo.getVida() - efeito);
            System.out.println("Voce conjura um ritual antigo de necromancia. Parte da energia vital do inimigo eh absorvida por voce e convertida em Mana");
            System.out.println("A vida do inimigo foi diminuida em " + efeito);
            System.out.println("Voce recuperou " + efeito + " pontos de mana.");
            this.mana += efeito;
        } else {
            System.out.println("Especial indisponivel, voce perdeu o turno.");
        }
    }
}
