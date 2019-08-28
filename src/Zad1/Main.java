package Zad1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static final String PATH = "stats.csv";
    public static void main(String[] args) {
        try {
            List<Player> players = getPlayers();
            players.sort(new ResultComparator());
            savePlayers(players);
            System.out.println("Dane posortowano i zapisano do pliku " + PATH);
        } catch (IOException e) {
            System.out.println("Sprawdz czy sciezka pliku jest poprawna");
        }catch (IndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Dane zawodnika sa niepoprawne");
        }
    }

    private static List<Player> getPlayers (){
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        String line = "";
        while (!line.toUpperCase().equals("STOP")){
            System.out.println("Podaj wyniki kolejnego gracza (lub stop):");
            line = scanner.nextLine();
            if(!line.toUpperCase().equals("STOP")){
                String[] split = line.split(" ");
                players.add(new Player(split[0], split[1], Integer.valueOf(split[2])));
            }
        }
        scanner.close();
        return players;
    }

    private static void savePlayers (List<Player> players) throws IOException {
        FileWriter fr = new FileWriter(new File(PATH));
        BufferedWriter br = new BufferedWriter(fr);
        for (Player player : players){
            br.write(player.toString() + "\n");
        }
        br.close();
        System.out.println();
    }
}
