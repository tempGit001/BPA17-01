package KompProg.lab4;

public class OOP {
    private int[] result;

    public OOP(){
        this.result = null;
    }

    public void setResult(int[] result) {
        this.result = result;
    }

    public int[] getResult() {
        return result;
    }

    // Complete the breakingRecords function below.
    public int[] breakingRecords(int[] scores) {
        int record = scores[0];
        int loseResult = 0;
        int breakingRecord = 0;
        for (int i = 0; i < scores.length - 1; i++){
            if (scores[i] > scores[i + 1]){
                loseResult++;
            }
            if (scores[i] > record){
                breakingRecord++;
                record = scores[i];
            }
        }
        if (scores[scores.length - 1] > record){
            breakingRecord++;
        }

        int[] result = {breakingRecord, loseResult};
        return result;
    }
}
