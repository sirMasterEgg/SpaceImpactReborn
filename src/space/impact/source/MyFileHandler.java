package space.impact.source;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public abstract class MyFileHandler {


    public MyFileHandler() {
        //
    }

    public ArrayList<String> loadBefore(String path){
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

    public ArrayList<String> sortByScore (ArrayList<String> data){
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            String a = data.get(i);
            arr.add(Integer.parseInt(a.substring(a.indexOf(Path.pemisahHighscore)+1)));
        }

        int n = arr.size();
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (arr.get(j) < arr.get(j+1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1,temp);

                    String tempS = data.get(j);
                    data.set(j, data.get(j+1));
                    data.set(j+1,tempS);
                }
            }
        }

        return data;
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
        ArrayList<String> temp = loadBefore(path);
        ArrayList<String> nama = new ArrayList<>();
        for (String a: temp){
            nama.add(a.substring(0,a.indexOf(pemisah)));
        }
        return nama;
    }

    public ArrayList<Integer> loadScore(String path, String pemisah){
        ArrayList<String> temp = loadBefore(path);
        ArrayList<Integer> score = new ArrayList<>();
        for (String a: temp){
            score.add(Integer.parseInt(a.substring(a.indexOf(pemisah)+1)));
        }
        return score;
    }

}

