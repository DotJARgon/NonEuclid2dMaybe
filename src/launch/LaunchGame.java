package launch;

import graphics.App;

public class LaunchGame {
    public static void main(String[] args) {
        App app = new App();
        //drives the refresh
        while(true) {
            app.gui.repaint();
//            try {
////                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
