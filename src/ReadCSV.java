import java.io.BufferedReader;
import java.io.FileReader;

public class ReadCSV {

    public String filename;

    public ReadCSV(String filename) {
        this.filename = filename;
    }

    public String readLine(){

        String lineText = "";
        String dataText = "";

        try (BufferedReader br =
                     new BufferedReader(new FileReader(filename))) {

            while((lineText = br.readLine()) != null) {
                dataText += lineText + ",";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataText;
    }

    public String[] splitDataText(String dataText) {
        String[] dataArray = dataText.split(",");
        return dataArray;
    }
}

