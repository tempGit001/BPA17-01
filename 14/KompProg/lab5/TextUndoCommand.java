package KompProg.lab6;

public class TextUndoCommand implements Command{
    Text text;

    public TextUndoCommand(Text text){
        this.text = text;
    }
    public void execute(){
        text.undo();
    }
}

