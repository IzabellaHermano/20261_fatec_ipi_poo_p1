
import java.util.ArrayList;
import java.util.Random;

public class Personagem {

    String nome;
    private int energia;
    private int fome;
    private int sono;
    private ArrayList<String> mochila;
    private ArrayList<Musica> repertorio;

    Personagem(String nome) {
        System.out.println("Construindo novo personagem");
        this.nome = nome;
        energia = 10;
        fome = 0;
        sono = 0;
        mochila = new ArrayList<>();
        repertorio = new ArrayList<>();
    }

    Personagem(String nome,int energia, int fome, int sono) {
        System.out.println("Construindo novo personagem");
        this.nome = nome;
        this.energia = energia < 0 || energia > 10 ? 10 : energia;
        this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        this.sono = sono >= 0 && sono <= 10 ? sono : 0;
        mochila = new ArrayList<>();
        repertorio = new ArrayList<>();

    }

    void cacar() {

        if (energia >= 2) {
            System.out.printf("%s caçando\n", nome);
            energia -= 2; // energia = energia - 2 
            mochila();
        } else {
            System.out.printf(
                    "%s sem energia para caçar\n",
                    nome
            );
        }
        // fome +=1 fome++ ++fome 
        if (fome < 10) {
            fome = fome + 1;
        }
        // sono = sono + 1 > 10 ? sono : sono + 1; 
        sono = sono == 10 ? sono : sono + 1;
    }

    //método comer 
    void comer() {
        if (fome >= 1) {
            System.out.println(nome + " comendo");
            energia = Math.min(energia + 1, 10);
            fome--;
        } else {
            System.out.println(nome + " sem fome");
        }
    }
    //método dormir 

    void dormir() {
        if (sono >= 1) {
            System.out.print(nome + " dormindo\n");
            energia = energia == 10 ? energia : energia + 1;
            sono -= 1;
        } else {
            System.out.println(nome + " sem sono");
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
            System.out.println(nome + " já conhece: " + sorteada.getTitulo());
        } else {
            repertorio.add(sorteada);
            System.out.println(nome + " aprendeu: " + sorteada.getTitulo());
        }
    }
    void addMusicaAutoral(Musica musica) {
    repertorio.add(musica);
}

    public String toString() {
//nome: e:5, f:4, s:8 
        return String.format(
                "%s: e:%d, f:%d, s:%d, m:%s, repertorio: %s",
                nome, energia, fome, sono, mochila,repertorio
        );
    }
}
