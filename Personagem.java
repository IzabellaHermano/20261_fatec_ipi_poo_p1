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
       
        System.out.println("Construindo primeiro personagem... ");
        
        this.nome = nome;
        energia = 10;
        fome = 0;
        sono = 0;
        mochila = new ArrayList<>();
        repertorio = new ArrayList<>();
    }

    Personagem(String nome,int energia, int fome, int sono) {
        
        System.out.println("Construindo segundo personagem... ");
        this.nome = nome;
        this.energia = energia < 0 || energia > 10 ? 10 : energia;
        this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        this.sono = sono >= 0 && sono <= 10 ? sono : 0;
        mochila = new ArrayList<>(); 
        repertorio = new ArrayList<>(); 

    }

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

    void addMusicaAutoral(Musica musica) {
    repertorio.add(musica);
    }

    boolean jaConheceMusica(Musica musica) {
        for (int i = 0; i < repertorio.size(); i++) {
            if (repertorio.get(i).getTitulo().equals(musica.getTitulo())) {
                return true;
            }
        }
        return false;
    }

    void dueloMusical(Personagem adversario) {
        Random gerador = new Random();

        if(repertorio.size() == 0) {
            System.out.println(nome + " ainda nao conhece nenhuma musica. Duelo cancelado!");
        }
        else {
            int indice = gerador.nextInt(repertorio.size());
            Musica sorteada = repertorio.get(indice);
            System.out.println(nome + " comecou o duelo com: " + sorteada.getTitulo());

            if (adversario.jaConheceMusica(sorteada)) {
                energia = energia - 1;
                adversario.energia = adversario.energia - 1;

                System.out.println(adversario.nome + " ja conhecia a musica");
                System.out.println("Os dois perderam 1 ponto de energia");
            }
            else {
                adversario.energia = adversario.energia - 1;
                adversario.repertorio.add(sorteada);

                System.out.println(adversario.nome + " nao conhecia a musica");
                System.out.println(adversario.nome + " perdeu 1 ponto de energia, mas aprendeu a musica " + sorteada.getTitulo());
            }
        }
    }

    public String toString() {
        return String.format(
                "%s: energia: %d, fome: %d, sono: %d, itens: %s, repertorio: %s",
                nome, energia, fome, sono, mochila, repertorio
        );
    }
}
