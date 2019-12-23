package KompProg.lab6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Client
public class Client{
    public final static Statics statics = new Statics();

    public static List<String> readFile(String path) throws IOException {
        String userHome = System.getProperty("user.home");
        File file = new File(userHome + path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        List<String> text = new ArrayList();
        while((line = br.readLine()) != null){
            text.add(line);
        }

        return text;
    }

    public static void writeFile(String path, Text text) throws IOException {
        String userHome = System.getProperty("user.home");
        File file = new File(userHome + path);

        // Создание объекта FileWriter
        FileWriter writer = new FileWriter(file);

        // Запись содержимого в файл
        writer.write(text.text);
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Text text = new Text(readFile("/Desktop/temp.txt").get(0));
        List<String> commands = readFile("/Desktop/commands.txt");

        RemoteControl control = new RemoteControl();

        for (int i = 0; i < commands.size(); i++){
            String temp = commands.get(i).replaceAll(",", "").toLowerCase();
            String[] tempArray = temp.split(" ");

            Command command = null;
            if (tempArray[0].equals("copy")){
                command = new TextCopyCommand(text, Integer.parseInt(tempArray[1]), Integer.parseInt(tempArray[2]));
            }else if (tempArray[0].equals("paste")){
                command = new TextPasteCommand(text, Integer.parseInt(tempArray[1]));
            }else if (tempArray[0].equals("delete")){
                command = new TextDeleteCommand(text, Integer.parseInt(tempArray[1]), Integer.parseInt(tempArray[2]));
            }else if (tempArray[0].equals("insert")){
                command = new TextInsertCommand(text, tempArray[1].replace("\"", ""), Integer.parseInt(tempArray[2]));
            }else if (tempArray[0].equals("undo")){
                command = new TextUndoCommand(text);
            }else if (tempArray[0].equals("redo")){
                command = new TextRedoCommand(text);
            }

            control.setCommand(command);
            control.pressButton();
            if (!tempArray[0].equals("undo") && !tempArray[0].equals("redo")){
                statics.status.add(new Status(text.text));
                statics.redoStatus.clear();
            }
            writeFile("/Desktop/temp.txt", text);
        }
    }
}