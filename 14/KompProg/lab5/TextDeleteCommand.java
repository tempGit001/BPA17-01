package KompProg.lab6;

public class TextDeleteCommand implements Command{
    Text text;
    int indexStart;
    int indexEnd;

    public TextDeleteCommand(Text text, int indexStart, int indexEnd){
        this.text = text;
        this.indexStart = indexStart;
        this.indexEnd = indexEnd;
    }
    public void execute(){
        text.delete(this.indexStart, this.indexEnd);
    }
}

