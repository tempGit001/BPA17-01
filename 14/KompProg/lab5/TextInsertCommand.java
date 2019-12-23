package KompProg.lab6;

public class TextInsertCommand implements Command{
    Text text;
    String insertText;
    int index;

    public TextInsertCommand(Text text, String insertText, int index){
        this.text = text;
        this.insertText = insertText;
        this.index = index;
    }
    public void execute(){
        text.insert(insertText, index);
    }

}
