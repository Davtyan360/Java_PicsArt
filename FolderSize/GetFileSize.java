package FolderSize;

import java.io.File;

public class GetFileSize {
    public int sizeByKb = 0;
    public boolean working = true;

    public void getSize(File folder) {
        for (File file : folder.listFiles()) {
            if (file.isDirectory())
                getSize(file);
            else
                sizeByKb += file.length()/1024;
        }
        working = false;
    }
}
