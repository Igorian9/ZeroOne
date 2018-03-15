package ua.i.igor_igorovuich;

import java.io.*;

public class OneCount {
    private File input;
    private File output;

    public OneCount(File input, File output) {
        this.input = input;
        this.output = output;
    }

    public File getInput() {
        return input;
    }

    public void setInput(File input) {
        this.input = input;
    }

    public File getOutput() {
        return output;
    }

    public void setOutput(File output) {
        this.output = output;
    }

    public String readFromFile() {
        BufferedReader reader = null;
        String result = "";
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(input)));
            result = reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void writeToFile(String result) {
        try (FileWriter writer = new FileWriter(output, false)) {
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void count() {
        String numbers = readFromFile();
        char[] buffer = numbers.toCharArray();
        int count = 1;
        int max = 0;
        if (buffer.length <= 100) {
            for (int i = 1; i < buffer.length; i++) {
                if (buffer[i] == '1' && buffer[i] == buffer[i - 1]) {
                    count += 1;
                    if (count > max)
                        max = count;
                } else {
                    count = 1;
                }
            }
        }
        writeToFile("" + max);
    }
}


