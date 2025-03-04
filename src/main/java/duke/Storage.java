package duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    protected String inp;
    public Storage() {
    }
    public Storage(String inp) {
        this.inp = inp;
    }
    private Task task;

    String home = System.getProperty("user.home");
    java.nio.file.Path path = java.nio.file.Paths.get(home, "data.txt");
    String absolute_filepath = path.toString();
    File f = new File(absolute_filepath);

    private static void printFileContents(String filePath) throws FileNotFoundException {
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            System.out.println(s.nextLine());
        }
    }

    private static void appendToFile(String absolute_filePath, String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(absolute_filePath, true); // create a FileWriter in append mode
        fw.write(textToAppend + "\n");
        fw.close();
    }

    private static List<String> ReadFileContents(String filePath) throws FileNotFoundException {
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        List<String> arraytemp = new ArrayList<String>();
        String arrayList;
        while (s.hasNext()) {
            arrayList = s.nextLine();
            arraytemp.add(arrayList);
        }
        return arraytemp;
    }

    public void Storedata(Task task) throws IOException {
        //Task task = new Task(inp);
        try {
            appendToFile(f.getAbsolutePath(), task.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public List<String> getdata() throws IOException {
        List<String> arraytemp = new ArrayList<String>();
        try {
            arraytemp = ReadFileContents(f.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return arraytemp;
    }

    public void Retrievedata() throws IOException {
        //Task task = new Task(inp);
        try {
            printFileContents(f.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}

