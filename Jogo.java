
import java.util.Random;

public class Jogo {
    public static void main(String[] args) throws Exception{
        var gerador = new Random();
        
        var personagem01 = new Personagem("Tica");

        while (true) { 
            var oQueFazer = gerador.nextInt(1,4);

            if(!personagem01.estaMorto()){
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
                }
            }else{
                System.out.println("game over!");
            }


            System.out.println(personagem01);
            Thread.sleep(5000);
            System.out.println("*******************************");


        }

    }
}
