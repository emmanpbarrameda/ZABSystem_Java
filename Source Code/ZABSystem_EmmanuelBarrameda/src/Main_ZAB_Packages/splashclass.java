// ©  M A D E		B Y		E M M A N		B A R R A M E D A  © //

package Main_ZAB_Packages;

import com.formdev.flatlaf.FlatLightLaf;

/**
 *
 * @author EMMANUEL BARRAMEDA
 */
public final class splashclass {

    public static void main(String args[]) {
        FlatLightLaf.install();
        SplashGUI sp = new SplashGUI();
        sp.setVisible(true);
        MainZABSystem lg = new MainZABSystem();
        try {
            for (int i = 0; i <= 101; i++) {
                Thread.sleep(30);
                sp.jLabel1.setText(Integer.toString(i) + "%");
                sp.progress.setValue(i);
                //sp.jLabel5.setValue(i);
                if (i == 101) {
                    sp.setVisible(false);
                    lg.setVisible(true);

                } else if (i <= 1) {
                    sp.mainAnimatedIcon.setVisible(false);
                    sp.jLabel1.setText("" + Integer.toString(i) + "%");
                    Thread.sleep(100);

                } else if (i >= 1 && i <= 5) {
                    sp.mainAnimatedIcon.setVisible(true);
                    sp.jLabel1.setText("" + Integer.toString(i) + "%");
                    Thread.sleep(50);

                } else if (i >= 6 && i <= 30) {
                    sp.jLabel1.setText("" + Integer.toString(i) + "%");
                    Thread.sleep(10);

                } else if (i >= 31 && i <= 80) {
                    sp.jLabel1.setText("" + Integer.toString(i) + "%");
                    Thread.sleep(1);

                } else if (i >= 81 && i <= 92) {
                    sp.jLabel1.setText("" + Integer.toString(i) + "%");
                    Thread.sleep(50);
                } else if (i >= 92 && i <= 99) {
                    sp.jLabel1.setText("" + Integer.toString(i) + "%");

                } else if (i == 100) {
                    sp.jLabel1.setText("" + Integer.toString(i) + "%");
                    Thread.sleep(500);
                    sp.jLabel1.setText("" + Integer.toString(i) + "%");
                    sp.mainAnimatedIcon.setAnchoProgress(i);
                    Thread.sleep(600);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

}
