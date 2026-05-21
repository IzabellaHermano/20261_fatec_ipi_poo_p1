import java.util.ArrayList;
import java.util.Random;

public abstract class PersonagemV2 {

    String nome;
    int energia; 
    int fome; 
    int sono;
    ArrayList<String> mochila; 
    ArrayList<Musica> repertorio;

    void cacar() {
        if (energia >= 2) { 
            System.out.printf("%s foi cacar...\n", nome);
            energia -= 2; 
            mochila(); 
        } else {
            System.out.printf("%s esta sem energia para cacar!\n", nome);
        }
         
        if (fome < 10) { 
            fome = fome + 1; 
        }
     
        sono = sono == 10 ? sono : sono + 1;
    }        

    void comer() {
        if (fome >= 1) {
            System.out.println(nome + " esta comendo...");
            energia = Math.min(energia + 1, 10);
            fome--;
        } else {
            System.out.println(nome + " esta sem fome!");
        }
    }

    void dormir() {
        if (sono >= 1) {
            System.out.print(nome + " foi dormir...\n");
            energia = energia == 10 ? energia : energia + 1;
            sono -= 1;
        } else {
            System.out.println(nome + " esta sem sono!");
        }
    }

    void mochila() {

        var gerador = new Random();
        var oQueFazer = gerador.nextInt(1, 6);

        switch (oQueFazer) {
            case 1:
                mochila.add("pena");
                break;
            case 2:
                mochila.add("couro");
                break;
            case 3:
                mochila.add("osso");
                break;
            case 4:
                mochila.add("presa");
                break;
            case 5:
                mochila.add("garra");
                break;
        }
    }

    boolean estaMorto() {
        return energia <= 0;
    }

    void aprenderMusica(ArrayList<Musica> disponiveis) {
        Random gerador = new Random();
        int indice = gerador.nextInt(disponiveis.size());

        Musica sorteada = disponiveis.get(indice);

        if (repertorio.contains(sorteada)) {
            System.out.println(nome + " ja conhece a musica " + sorteada.getTitulo());
        } else {
            repertorio.add(sorteada);
            System.out.println(nome + " aprendeu a musica " + sorteada.getTitulo());
        }
    }

    public abstract void realizarAcaoAleatorio();

}
