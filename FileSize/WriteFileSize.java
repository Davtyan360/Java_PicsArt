package FileSize;

import java.io.File;

public class WriteFileSize {
    public void writeSize(String path) {
        File folder = new File(path);
        if (!folder.isDirectory())
            return;
        GetFileSize s = new GetFileSize();
        while (s.working) {
            s.getSize(folder);
            try {
                System.out.println(s.sizeByKb + "Kb");
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
