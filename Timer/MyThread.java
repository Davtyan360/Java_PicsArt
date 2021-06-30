package Timer;

public class MyThread extends Thread {
    public static int second;

    public MyThread(int second) {
        this.second = second;
    }

    @Override
    public void run() {
        System.out.println(second);
        for (int i = second; i > 0; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            StringBuilder s = new StringBuilder();
            if (i / 60 < 10)
                s.append('0');
            s.append(i / 60);
            s.append(':');
            if (i % 60 < 10)
                s.append('0');
            s.append(i % 60);
            Panel.label.setText(s.toString());
            System.out.println(s.toString());
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Panel.label.setText("00:00");
        second = 0;
    }

}
