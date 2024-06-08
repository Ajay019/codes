import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Wav2{
    static byte[] delimiter = {(byte) 96, (byte) 240, (byte) 96, (byte) 240};
    static byte[] beatDelimiter = {(byte) 160, (byte) 15};

    public static void main(String[] args) {
        readTwo();
    }

    static void readTwo() {
        try {
            FileInputStream file = new FileInputStream("D:\\ajay\\Vishwactf\\TunePocket-Rock-Guitar-Power-Intro-Preview.wav");
            List<Integer> output = new ArrayList<>();
            List<Integer> intermediary = new ArrayList<>();
            int data;
            while ((data = file.read()) != -1) {
                if (data == delimiter[0]) {
                    int nextByte1 = file.read();
                    int nextByte2 = file.read();
                    int nextByte3 = file.read();
                    if (nextByte1 == delimiter[1] && nextByte2 == delimiter[2] && nextByte3 == delimiter[3]) {
                        intermediary = splitIntermediary(intermediary);
                        output.add(soundCount(intermediary));
                        intermediary.clear();
                    }
                }
                intermediary.add(data);
            }
            output.add(soundCount(intermediary) - 1);
            System.out.println(output);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<Integer> splitIntermediary(List<Integer> inter) {
        int iL = inter.size();
        for (int i = 0; i < iL; i++) {
            if (i + 2 >= iL) {
                break;
            }
            if (inter.get(i) == (byte) 160 && inter.get(i + 1) == (byte) 15 && inter.get(i + 2) == (byte) 160) {
                return inter.subList(0, i + 1);
            }
        }
        return new ArrayList<>();
    }

    static int soundCount(List<Integer> sounds) {
        int s = 0;
        int sL = sounds.size();
        for (int i = 0; i < sL; i++) {
            if (sounds.get(i) == beatDelimiter[0]) {
                if (i + 1 >= sL) {
                    break;
                }
                if (sounds.get(i + 1) == beatDelimiter[1]) {
                    s++;
                }
            }
        }
        return s + 1;
    }
}
