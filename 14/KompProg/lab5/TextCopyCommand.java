package KompProg.lab6;

//Concrete Command
public class TextCopyCommand implements Command{
    Text text;
    int indexStart;
    int indexEnd;

    public TextCopyCommand(Text text, int indexStart, int indexEnd){
        this.text = text;
        this.indexStart = indexStart;
        this.indexEnd = indexEnd;
    }

    public void execute(){
        text.copy(indexStart, indexEnd);
    }
}