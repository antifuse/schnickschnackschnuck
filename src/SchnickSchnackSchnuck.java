import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SchnickSchnackSchnuck {
    public static void main(String[] args) {
        Bewegung schere = new Bewegung("Schere");
        Bewegung stein = new Bewegung("Stein");
        Bewegung papier = new Bewegung("Papier");

        schere.getAliases().addAll(Arrays.asList("schere", "sch","Sch","sc","Sc"));
        stein.getAliases().addAll(Arrays.asList("stein","st","St"));
        papier.getAliases().addAll(Arrays.asList("papier","pap","p","Pap","P"));

        schere.getSchlaegt().add(papier);
        papier.getSchlaegt().add(stein);
        stein.getSchlaegt().add(schere);

        Spiel spiel = new Spiel(new Spieler("A"), new Spieler("B"));
        spiel.getMoves().addAll(Arrays.asList(schere,stein,papier));
        try {
            spiel.getA().spielen("st");
        } catch (InvalidMoveException e) {
            System.out.println("You tried to play: " + e.getTriedMove() + " but this was not recognized as a move name or alias. Your move has to be one of the following:" + e.getPossibleMoves().toString());
            System.exit(-1);
        }
        try {
            spiel.getB().spielen("pap");
        } catch (InvalidMoveException e) {
            System.out.println("You tried to play: " + e.getTriedMove() + " but this was not recognized as a move name or alias. Your move has to be one of the following:" + e.getPossibleMoves().toString());
            System.exit(-1);
        }
        System.out.println(spiel.eval().getName());


    }
}
