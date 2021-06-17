public class Main {
    public static void main(String[] args) {
        Thread s = new Thread(() -> st(5));
        s.start();
    }

    public static void st(int minute){
        minute*=60;
        for (int i = minute; i > 0; i--){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            StringBuilder s = new StringBuilder();
            s.append(i/60);
            s.append(':');
            if(i%60<10)
                s.append('0');
            s.append(i%60);
            
            System.out.println(s.toString());
        }

    }

}
