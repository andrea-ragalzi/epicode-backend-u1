package es3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {
    Presenza[] presenze;

    public RegistroPresenze(Presenza[] presenze) {
        this.presenze = presenze;
    }

    public Presenza[] getPresenze() {
        return this.presenze;
    }

    public void leggiPresenze() throws IOException {
        String data = FileUtils.readFileToString(new File("src/es3/presenze.txt"), "UTF-8");
        String[] presenzeString = data.split("#");
        Presenza[] presenze = new Presenza[presenzeString.length];
        for (int i = 0; i < presenzeString.length; i++) {
            Presenza presenza = new Presenza(presenzeString[i].split("@")[0],
                    Integer.parseInt(presenzeString[i].trim().split("@")[1]));
            presenze[i] = presenza;
        }
        this.presenze = presenze;
    }

    public void salvaPresenze() throws IOException {
        String presenzeString = this.toString();
        FileUtils.writeStringToFile(new File("src/es3/presenze.txt"), presenzeString, "UTF-8");
    }

    @Override
    public String toString() {
        String result = "";
        for (Presenza presenza : presenze) {
            result += presenza + "#";
        }
        return result.substring(0, result.length() - 1) + "\n";
    }
}
