
import java.util.ArrayList;
import java.util.Random;

public class JogoV2 {

    public static void main(String[] args) throws Exception {
        var gerador = new Random();

        var personagem01 = new Personagem("Arlequina Assassina");
        var personagem02 = new Personagem("Tico Trovador", 3, 8, 8);
        personagem02.addMusicaAutoral(new Musica("Thriller do Trovador"));

        ArrayList<Musica> musicas = new ArrayList<>();

        //lista de musicas
        musicas.add(new Musica("Bad romance"));
        musicas.add(new Musica("Hello"));
        musicas.add(new Musica("God is a woman"));
        musicas.add(new Musica("Confident"));
        musicas.add(new Musica("StarBoy"));
        musicas.add(new Musica("Cool for the summer"));
        musicas.add(new Musica("Abracadabra"));
        musicas.add(new Musica("Bring me to life"));
        musicas.add(new Musica("I wish you roses"));
        musicas.add(new Musica("Back in black"));

        boolean campeao = false;

        System.out.println("*******************************");


        do {
            if (!personagem01.estaMorto()) {
                var oQueFazer = gerador.nextInt(1, 5);

                switch (oQueFazer) {
                    case 1:
                        personagem01.cacar();
                        break;
                    case 2:
                        personagem01.comer();
                        break;
                    case 3:
                        personagem01.dormir();
                        break;
                    case 4:
                        personagem01.aprenderMusica(musicas);
                        break;
                }
                System.out.println(personagem01);
            }
            
            System.out.println("*******************************");

            if (!personagem02.estaMorto()) {
                var oQueFazer = gerador.nextInt(1, 11);
                switch (oQueFazer) {
                    case 1, 2:
                        personagem02.cacar();
                        personagem02.aprenderMusica(musicas);
                        break;
                    case 3, 4:
                        personagem02.comer();
                        personagem02.aprenderMusica(musicas);
                        break;
                    case 5, 6, 7, 8, 9, 10:
                        personagem02.dormir();
                        personagem02.aprenderMusica(musicas);
                        break;

                }
                System.out.println(personagem02);
            }
            
            System.out.println("*******************************");

            if (!personagem01.estaMorto() && !personagem02.estaMorto()) {
                var quemChamaDuelo = gerador.nextInt(1, 3);

                if (quemChamaDuelo == 1) {
                    System.out.println(personagem01.nome + " chamou " + personagem02.nome + " para um duelo musical!");
                    personagem01.dueloMusical(personagem02);
                }
                else {
                    System.out.println(personagem02.nome + " chamou " + personagem01.nome + " para um duelo musical!");
                    personagem02.dueloMusical(personagem01);
                }
            }

            if (!campeao) {
                if (personagem01.estaMorto() && !personagem02.estaMorto()) {
                    System.out.println(personagem01.nome + " morreu!");
                    System.out.println(personagem02.nome + " venceu o duelo musical!");
                    campeao = true;
                }
                else if (personagem02.estaMorto() && !personagem01.estaMorto()) {
                    System.out.println(personagem02.nome + " morreu!");
                    System.out.println(personagem01.nome + " venceu o duelo musical!");
                    campeao = true;
                }
            }

            Thread.sleep(5000);
            System.out.println("*******************************");

            

        } while (!personagem01.estaMorto() || !personagem02.estaMorto());

        System.out.println("Nao restaram personagens vivos...");
        System.out.println("Game Over!");
    }
}
