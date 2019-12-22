import java.util.Scanner;

public class SchnickSchnackSchnuck {

    private static Spiel spiel;
    private static Scanner cons = new Scanner(System.in);

    public static void main(String[] args) {
        Bewegung schere = new Bewegung("Schere");
        Bewegung stein = new Bewegung("Stein");
        Bewegung papier = new Bewegung("Papier");
        Bewegung nils = new Bewegung("Nils");

        schere.setAliases(new String[]{"schere", "sch","Sch","sc","Sc","scissors","Scissors"});
        stein.setAliases(new String[]{"stein","st","St","rock","Rock","r","R"});
        papier.setAliases(new String[]{"papier", "pap", "Pap", "P", "p","paper","Paper"});
        nils.setAliases(new String[]{"nils","ni","Ni","n","N","Nils312"});

        schere.getSchlaegt().add(papier);
        schere.getSchlaegt().add(nils);
        papier.getSchlaegt().add(stein);
        papier.getSchlaegt().add(nils);
        stein.getSchlaegt().add(schere);
        stein.getSchlaegt().add(nils);

        spiel = new Spiel(new Spieler("A"), new Spieler("B"));
        spiel.setMoves(new Bewegung[]{schere,stein,papier,nils});


        requestMove(spiel.getA());
        requestMove(spiel.getB());
        Spieler winner = spiel.winner();
        if (winner != null) {
            winner.setPunkte(winner.getPunkte() + 1);
            System.out.println(winner.getName() + " gewinnt! Er hat nun " + winner.getPunkte() + " Punkt/e.");
            if (spiel.loser().getAktuelle().equals(nils)) System.out.println("Nils wurde soeben geschlagen!");
        } else {
            System.out.println("Es ist eine Krawatte! Tja.");
        }





    }

    private static void requestMove(Spieler spieler) {
        String input;
        do {
            System.out.println(spieler.getName() + ", gib deine Bewegung ein. Möglich sind: " + spiel.getMoves().toString());
            input = cons.nextLine();
            if (input.equals("exit") || input.equals("Exit")) System.exit(0);
        } while (!spiel.isValidMove(input));

        try {
            spieler.spielen(input);
        } catch (InvalidMoveException e) {
            System.exit(-1);
        }
    }
}
