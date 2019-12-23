package KompProg.lab6;

public class TextRedoCommand implements Command{
    Text text;
    public TextRedoCommand(Text text){
        this.text = text;
    }
    public void execute(){
        text.redo();
    }
}

