package space.impact.source;

import java.util.ArrayList;

public class TextClass extends MyFileHandler {

    public TextClass() {
        //
    }

    @Override
    public ArrayList<String> loadBefore(String path) {
        return super.loadBefore(path);
    }

    @Override
    public void save(String name, ArrayList<String> data) {
        super.save(name, data);
    }

    @Override
    public ArrayList<String> loadNama(String path, String pemisah) {
        return super.loadNama(path, pemisah);
    }

    @Override
    public ArrayList<Integer> loadScore(String path, String pemisah) {
        return super.loadScore(path, pemisah);
    }
}
