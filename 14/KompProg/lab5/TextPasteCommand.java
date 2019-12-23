package KompProg.lab6;

//Concrete Command
public class TextPasteCommand implements Command{
    Text text;
    int index;

    public TextPasteCommand(Text text, int index){
        this.text = text;
        this.index = index;
    }
    public void execute(){
        text.paste(index);
    }
}