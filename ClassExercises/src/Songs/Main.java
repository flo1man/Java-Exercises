package Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer n = Integer.parseInt(scanner.nextLine());
        List<Song> songList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("_");
            String typeList = input[0];
            String name = input[1];
            String time = input[2];

            Song song = new Song(typeList,name,time);
            songList.add(song);
        }

        String type = scanner.nextLine();

        if (type.equals("all")){
            for (var song : songList){
                System.out.println(song.getName());
            }
        }
        else {
            for (var song : songList.stream().filter(x -> x.getTypeList().equals(type)).collect(Collectors.toList())){
                System.out.println(song.getName());
            }
        }
    }
}
