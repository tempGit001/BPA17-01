package KompProg.lab6;

import static KompProg.lab6.Client.statics;

//Receiver
public class Text {
    public String text;

    public Text(String text){
        this.text = text;
        statics.status.add(new Status(text));
    }

    public void copy(int indexStart, int indexEnd){
        statics.setCopyBuffer(text.substring(indexStart, indexEnd));
    }

    public void paste(int index){
        this.text = text.substring(0, index) + statics.getCopyBuffer() + text.substring(index);
    }

    public void insert(String insertText, int index){
        this.text = text.substring(0, index) + insertText + text.substring(index);
    }

    public void delete(int indexStart, int indexEnd){
        this.text = text.substring(0, indexStart) + text.substring(indexEnd);
    }

    public void undo(){
        if (statics.redoStatus.size() == 0){
            statics.redoStatus.add(statics.status.get(statics.status.size() - 1));
        }

        statics.status.remove(statics.status.size() - 1);
        statics.redoStatus.add(statics.status.get(statics.status.size() - 1));
        this.text = statics.status.get(statics.status.size() - 1).getTextStatus();
    }

    public void redo(){
        statics.redoStatus.remove(statics.redoStatus.size() - 1);
        this.text = statics.redoStatus.get(statics.redoStatus.size() - 1).getTextStatus();
    }


    public void print(){
        System.out.println("\n" + text);
    }
}