package KompProg.lab6;

import java.util.ArrayList;
import java.util.List;

public class Statics {
    public static String copyBuffer;
    public static List<Status> status = new ArrayList<>();
    public static List<Status> redoStatus = new ArrayList<>();

    public void setCopyBuffer(String copyBuffer) {
        Statics.copyBuffer = copyBuffer;
    }

    public String getCopyBuffer() {
        return copyBuffer;
    }
}
