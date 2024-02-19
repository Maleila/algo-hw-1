package algo.hw;

//Lu Henry-Mitchell

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVhelper {

    public static void main(String[] args) {

    }

    public static void processData(String[][] data, String output) {
        String[] header = {"N", "sample_num", "time_ns"};
        String csvFile = output;

        // Write data to csv file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            // Add a header
            writeLine(writer, header);

            for(int i = 0; i <data.length; i++){
                String[] temp = data[i];
                writeLine(writer, temp);
            }

            System.out.println("CSV file created successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeLine(BufferedWriter writer, String[] data) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            if (i < data.length - 1) {
                sb.append(",");
            }
        }
        sb.append("\n");
        writer.write(sb.toString());
    }
}