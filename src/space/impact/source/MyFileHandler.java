package space.impact.source;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class MyFileHandler {


    public MyFileHandler() {
        //
    }

    protected ArrayList<String> loadTemp(String path){
        ArrayList<String> result = new ArrayList<>();

        try (Scanner s = new Scanner(new FileReader(path))) {
            while (s.hasNext()) {
                result.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void save(String name, ArrayList<String> data){
        StringBuilder temp= new StringBuilder();
        for (String a: data){
            temp.append(a).append("\n");
        }
        try {
            FileWriter myWriter = new FileWriter(name);
            myWriter.write(temp.toString());
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> loadNama(String path, String pemisah){
        ArrayList<String> temp = loadTemp(path);
        ArrayList<String> nama = new ArrayList<>();
        for (String a: temp){
            nama.add(a.substring(0,a.indexOf(pemisah)));
        }
        return nama;
    }

    public ArrayList<Integer> loadScore(String path, String pemisah){
        ArrayList<String> temp = loadTemp(path);
        ArrayList<Integer> score = new ArrayList<>();
        for (String a: temp){
            score.add(Integer.parseInt(a.substring(a.indexOf(pemisah)+1)));
        }
        return score;
    }

}

