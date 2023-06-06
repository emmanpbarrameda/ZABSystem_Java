// ©  M A D E		B Y		E M M A N		B A R R A M E D A  © //

package Main_ZAB_Packages;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Frame;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.BalloonTipStyle;
import net.java.balloontip.styles.EdgedBalloonStyle;

/**
 *
 * @author Emmanuel Peñaflorida Barrameda
 */
public final class MainZABSystem extends javax.swing.JFrame {

    //main name of popups
    static String mainnameString = "ZAB System";
    //main name of popups errors
    static String mainErrorString = "ZAB System | Error";

    //for Zodiac Sign names
    static String[] signs = {"Aquarius", "Pisces", "Aries", "Taurus",
        "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn"
    };

    //for Birthstone names
    static final String[] birthstoneSigns = {"Garnet", "Amethyst", "Aquamarine", "Diamond",
        "Emerald", "Pearl", "Ruby", "Peridot", "Sapphire", "Opal", "Topaz", "Turquoise"
    };

    //for Zodiac Sign dates
    // Aquarius start date
    private static final GregorianCalendar[] signStartDates = {
        new GregorianCalendar(2002, 0, 20),
        new GregorianCalendar(2002, 1, 19), // Pisces start date
        new GregorianCalendar(2002, 2, 21), // Aries start date
        new GregorianCalendar(2002, 3, 20), // Taurus start date
        new GregorianCalendar(2002, 4, 21), // Gemini start date
        new GregorianCalendar(2002, 5, 21), // Cancer start date
        new GregorianCalendar(2002, 6, 23), // Leo start date
        new GregorianCalendar(2002, 7, 23), // Virgo start date
        new GregorianCalendar(2002, 8, 23), // Libra start date
        new GregorianCalendar(2002, 9, 23), // Scorpio start date
        new GregorianCalendar(2002, 10, 22), // Sagittarius start date
        new GregorianCalendar(2002, 11, 22), // Capricorn start date
    };

    //gregorian calendar static variable
    private static final GregorianCalendar calendar = new GregorianCalendar();

    //name of every months and variables
    public static final String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    // Date formatter for displaying dates
    public static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);

    //check if the input dates is advanced than the system time
    Calendar checkInputBirthdate = Calendar.getInstance();

    /**
     * Creates new form MainClockTimerStopwatchGUI
     */
    public MainZABSystem() {
        initComponents();
        setLocationRelativeTo(null); //<-- center to the screen the frame
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/MAINICON_128px.png")).getImage()); //<-- set the icon for this frame
        MainZABSystem.this.getRootPane().setBorder(new MatteBorder(0, 1, 1, 1, (new Color(50, 27, 140)))); //<-- set border for this frame

        //disable copy passte on Input fields using noCopyPaste() void
        noCopyPaste();

        //--------------------- DISABLE the AUTO TAB AND SHIFT in JTextFields UI ---------------------// 
        //this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, null);
        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.<KeyStroke>emptySet());
        this.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, Collections.<KeyStroke>emptySet());
        this.setFocusTraversalKeys(KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS, Collections.<KeyStroke>emptySet());
        this.setFocusTraversalKeys(KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, Collections.<KeyStroke>emptySet());

        this.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.setFocusTraversalKeys(KeyboardFocusManager.DOWN_CYCLE_TRAVERSAL_KEYS, Collections.EMPTY_SET);
        this.setFocusTraversalKeys(KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, Collections.EMPTY_SET);

        //auto type the request type input in the monthTF
        monthTF.requestFocusInWindow();
    }

    //clear the Insert and Result panel
    public static void clearInputs() {
        monthTF.requestFocusInWindow();
        monthTF.setText("");
        dayTF.setText("");
        yearTF.setText("");
        ageTF.setText("");
        answerzodiacTF.setText("");
        calculatedageTF.setText("");
        gemstoneTF.setText("");
        birthdateTF.setText("");

        new Thread(() -> {
            try {
                //start thread
                answerzodiacTF.setText("");
                ageTF.setText("");
                calculatedageTF.setText("");
                gemstoneTF.setText("");
                birthdateTF.setText("");
                answerzodiacTF.setVisible(false);
                ageTF.setVisible(false);
                calculatedageTF.setVisible(false);
                gemstoneTF.setVisible(false);
                birthdateTF.setVisible(false);
                Thread.sleep(100); //<-- sleep in 100 milliseconds
            } catch (InterruptedException e) {
            }
            //closing thread
            answerzodiacTF.setText("");
            ageTF.setText("");
            calculatedageTF.setText("");
            gemstoneTF.setText("");
            birthdateTF.setText("");
            answerzodiacTF.setVisible(true);
            ageTF.setVisible(true);
            calculatedageTF.setVisible(true);
            gemstoneTF.setVisible(true);
            birthdateTF.setVisible(true);

            okBTN.setEnabled(false);
            dayTF.setEditable(false);
            yearTF.setEditable(false);
            monthTF.setEditable(true);
            monthTF.requestFocusInWindow();
        }).start();
    }

    //clear the result panel only
    public static void clearResultPanelOnly() {
        //clear text
        birthdateTF.setText("");
        answerzodiacTF.setText("");
        ageTF.setText("");
        calculatedageTF.setText("");
        gemstoneTF.setText("");
        
        //setEditable(false)
        birthdateTF.setEditable(false);
        answerzodiacTF.setEditable(false);
        ageTF.setEditable(false);
        calculatedageTF.setEditable(false);
        gemstoneTF.setEditable(false);
    }
    
    //clear the INSERT panel only
    public static void clearInsertPanelOnly() {
        //clear text
        monthTF.setText("");
        dayTF.setText("");
        yearTF.setText("");
    }
    
    //display the BalloonTip on dayTF field
    public void BalloonTipDay() {
        BalloonTipStyle style = new EdgedBalloonStyle(new Color(249, 250, 253), (new Color(50, 27, 140))); //<-- set the color; background then the border.
        BalloonTip tip = new BalloonTip(dayTF, "Day values must be between 1 and 31. Please Try again."); //<-- shop tooltip in dayTF field with message.
        new Thread(() -> {
            try {
                //start thread
                tip.setStyle(style); //<-- set the style from BalloonTipStyle
                tip.setCloseButton(null); //<-- remove the close button on tooltip
                tip.setVisible(true);
                Thread.sleep(1300); //<-- sleep in 1300 milliseconds
            } catch (InterruptedException e) {
            }
            //closing thread
            tip.setVisible(false);
            //dayTF.requestFocusInWindow(); //focus in dayTF field after tipDay is disabled.
        }).start();
    }

    //display the BalloonTip on dayTF field
    public void BalloonTipDay1() {
        BalloonTipStyle style = new EdgedBalloonStyle(new Color(249, 250, 253), (new Color(50, 27, 140))); //<-- set the color; background then the border.
        BalloonTip tip = new BalloonTip(dayTF, "<html><center>You must enter numeric values (01-31) only!</html></center>"); //<-- shop tooltip in dayTF field with message.
        new Thread(() -> {
            try {
                //start thread
                tip.setStyle(style); //<-- set the style from BalloonTipStyle
                tip.setCloseButton(null); //<-- remove the close button on tooltip
                tip.setVisible(true);
                Thread.sleep(2000); //<-- sleep in 2000 milliseconds
            } catch (InterruptedException e) {
            }
            //closing thread
            tip.setVisible(false);
            //dayTF.requestFocusInWindow(); //focus in dayTF field after tipDay is disabled.
        }).start();
    }

    //display the BalloonTip on monthTF field
    public void BalloonTipMonth() {
        BalloonTipStyle style = new EdgedBalloonStyle(new Color(249, 250, 253), (new Color(50, 27, 140))); //<-- set the color; background then the border.
        BalloonTip tip = new BalloonTip(monthTF, "The month value must be from 1 to 12. Try again."); //<-- shop tooltip in monthTF field with message.
        new Thread(() -> {
            try {
                //start thread
                tip.setStyle(style); //<-- set the style from BalloonTipStyle
                tip.setCloseButton(null); //<-- remove the close button on tooltip
                tip.setVisible(true);
                Thread.sleep(1300); //<-- sleep in 1300 milliseconds
            } catch (InterruptedException e) {
            }
            //closing thread
            tip.setVisible(false);
            //monthTF.requestFocusInWindow(); //focus in monthTF field after tipDay is disabled.
        }).start();
    }

    //display the BalloonTip on monthTF field
    public void BalloonTipMonth1() {
        BalloonTipStyle style = new EdgedBalloonStyle(new Color(249, 250, 253), (new Color(50, 27, 140))); //<-- set the color; background then the border.
        BalloonTip tip = new BalloonTip(monthTF, "<html><center>You must enter numeric values (01-12) only! <br>January is 01, December is 12 <br>e.g: 07</html></center>"); //<-- shop tooltip in monthTF field with message.

        new Thread(() -> {
            try {
                //start thread
                tip.setStyle(style); //<-- set the style from BalloonTipStyle
                tip.setCloseButton(null); //<-- remove the close button on tooltip
                tip.setVisible(true);
                Thread.sleep(2000); //<-- sleep in 2000 milliseconds
            } catch (InterruptedException e) {
            }
            //closing thread
            tip.setVisible(false);
            //monthTF.requestFocusInWindow(); //focus in monthTF field after tipDay is disabled.
        }).start();
    }
    
    //display the BalloonTip on yearTF field
    public void BalloonTipYear() {
        BalloonTipStyle style = new EdgedBalloonStyle(new Color(249, 250, 253), (new Color(50, 27, 140))); //<-- set the color; background then the border.
        BalloonTip tip = new BalloonTip(yearTF, "<html><center>You must enter numeric values only! <br>e.g: 2002</br></html></center>"); //<-- shop tooltip in yearTF field with message.

        new Thread(() -> {
            try {
                //start thread
                tip.setStyle(style); //<-- set the style from BalloonTipStyle
                tip.setCloseButton(null); //<-- remove the close button on tooltip
                tip.setVisible(true);
                Thread.sleep(1000); //<-- sleep in 2000 milliseconds
            } catch (InterruptedException e) {
            }
            //closing thread
            tip.setVisible(false);
            //yearTF.requestFocusInWindow(); //focus in yearTF field after tipDay is disabled.
        }).start();
    }
    
    //display the BalloonTip on yearTF field
    public void BalloonTipYear1() {
        BalloonTipStyle style = new EdgedBalloonStyle(new Color(249, 250, 253), (new Color(50, 27, 140))); //<-- set the color; background then the border.
        BalloonTip tip = new BalloonTip(yearTF, "<html><center>You must enter 4 numeric characters exactly! <br>e.g: 2002</br></html></center>"); //<-- shop tooltip in yearTF field with message.

        new Thread(() -> {
            try {
                //start thread
                tip.setStyle(style); //<-- set the style from BalloonTipStyle
                tip.setCloseButton(null); //<-- remove the close button on tooltip
                tip.setVisible(true);
                Thread.sleep(1000); //<-- sleep in 2000 milliseconds
            } catch (InterruptedException e) {
            }
            //closing thread
            tip.setVisible(false);
            //yearTF.requestFocusInWindow(); //focus in yearTF field after tipDay is disabled.
        }).start();
    }

    public void noCopyPaste() {
        //disable copy, cut and paste
        monthTF.setTransferHandler(null);
        dayTF.setTransferHandler(null);
        yearTF.setTransferHandler(null);

        birthdateTF.setTransferHandler(null);
        answerzodiacTF.setTransferHandler(null);
        ageTF.setTransferHandler(null);
        calculatedageTF.setTransferHandler(null);
        gemstoneTF.setTransferHandler(null);
    }

    //paste the Birthstone in birthstone field using Void
    public void birthstone() {
        gemstoneTF.setText(""); //<-- clear the birthstone field first before getting data from if-else statements

        //January birthstone
        if ((monthTF.getText().equalsIgnoreCase("1") || monthTF.getText().equalsIgnoreCase("01"))) {
            gemstoneTF.setText("Garnet");

            //January birthstone - duplicate
        } else if ((monthTF.getText().equalsIgnoreCase("1") || monthTF.getText().equalsIgnoreCase("01"))) {
            gemstoneTF.setText("Garnet");

            //February birthstone  
        } else if ((monthTF.getText().equalsIgnoreCase("2") || monthTF.getText().equalsIgnoreCase("02"))) {
            gemstoneTF.setText("Amethyst");

            //March birthstone  
        } else if ((monthTF.getText().equalsIgnoreCase("3") || monthTF.getText().equalsIgnoreCase("03"))) {
            gemstoneTF.setText("Aquamarine");

            //April birthstone  
        } else if ((monthTF.getText().equalsIgnoreCase("4") || monthTF.getText().equalsIgnoreCase("04"))) {
            gemstoneTF.setText("Diamond");

            //May birthstone  
        } else if ((monthTF.getText().equalsIgnoreCase("5") || monthTF.getText().equalsIgnoreCase("05"))) {
            gemstoneTF.setText("Emerald");

            //June birthstone  
        } else if ((monthTF.getText().equalsIgnoreCase("6") || monthTF.getText().equalsIgnoreCase("06"))) {
            gemstoneTF.setText("Pearl or Alexandrite");

            //July birthstone  
        } else if ((monthTF.getText().equalsIgnoreCase("7") || monthTF.getText().equalsIgnoreCase("07"))) {
            gemstoneTF.setText("Ruby");

            //August birthstone  
        } else if ((monthTF.getText().equalsIgnoreCase("8") || monthTF.getText().equalsIgnoreCase("08"))) {
            gemstoneTF.setText("Peridot");

            //September birthstone  
        } else if ((monthTF.getText().equalsIgnoreCase("9") || monthTF.getText().equalsIgnoreCase("09"))) {
            gemstoneTF.setText("Sapphire");

            //October birthstone  
        } else if ((monthTF.getText().equalsIgnoreCase("10") || monthTF.getText().equalsIgnoreCase("October"))) {
            gemstoneTF.setText("Tourmaline or Opal");

            //November birthstone  
        } else if ((monthTF.getText().equalsIgnoreCase("11") || monthTF.getText().equalsIgnoreCase("November"))) {
            gemstoneTF.setText("Topaz or Citrine");

            //December birthstone  
        } else if ((monthTF.getText().equalsIgnoreCase("12") || monthTF.getText().equalsIgnoreCase("December"))) {
            gemstoneTF.setText("Turquoise");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlTop = new javax.swing.JPanel();
        guiTitle = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();
        minimizeButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        pnlMainObjects = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        integer_ver_text = new javax.swing.JLabel();
        pnlInsertData = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        monthTF = new rojerusan.RSMetroTextPlaceHolder();
        dayTF = new rojerusan.RSMetroTextPlaceHolder();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        yearTF = new rojerusan.RSMetroTextPlaceHolder();
        clearBTN = new rojerusan.RSMaterialButtonRectangle();
        okBTN = new rojerusan.RSMaterialButtonRectangle();
        jSeparator2 = new javax.swing.JSeparator();
        pnlResult = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        answerzodiacTF = new rojerusan.RSMetroTextPlaceHolder();
        ageTF = new rojerusan.RSMetroTextPlaceHolder();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        calculatedageTF = new rojerusan.RSMetroTextPlaceHolder();
        jLabel13 = new javax.swing.JLabel();
        gemstoneTF = new rojerusan.RSMetroTextPlaceHolder();
        jLabel14 = new javax.swing.JLabel();
        birthdateTF = new rojerusan.RSMetroTextPlaceHolder();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ZAB SYSTEM");
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(249, 250, 253));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTop.setBackground(new java.awt.Color(50, 27, 140));
        pnlTop.setPreferredSize(new java.awt.Dimension(116, 30));
        pnlTop.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTopMouseDragged(evt);
            }
        });
        pnlTop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTopMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTopMousePressed(evt);
            }
        });
        pnlTop.setLayout(null);

        guiTitle.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        guiTitle.setForeground(new java.awt.Color(255, 255, 255));
        guiTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MAINICON_18px.png"))); // NOI18N
        guiTitle.setText(" ZAB SYSTEM");
        guiTitle.setIconTextGap(2);
        guiTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                guiTitleMouseDragged(evt);
            }
        });
        guiTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guiTitleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                guiTitleMousePressed(evt);
            }
        });
        pnlTop.add(guiTitle);
        guiTitle.setBounds(5, 0, 200, 30);

        exitButton.setBackground(new java.awt.Color(50, 27, 140));
        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_multiply_18px_1.png"))); // NOI18N
        exitButton.setBorder(null);
        exitButton.setBorderPainted(false);
        exitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitButton.setDefaultCapable(false);
        exitButton.setFocusPainted(false);
        exitButton.setFocusable(false);
        exitButton.setIconTextGap(0);
        exitButton.setRequestFocusEnabled(false);
        exitButton.setVerifyInputWhenFocusTarget(false);
        exitButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                exitButtonMouseMoved(evt);
            }
        });
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButtonMouseExited(evt);
            }
        });
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        pnlTop.add(exitButton);
        exitButton.setBounds(950, 0, 20, 30);

        minimizeButton.setBackground(new java.awt.Color(50, 27, 140));
        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_minus_18px_1.png"))); // NOI18N
        minimizeButton.setBorder(null);
        minimizeButton.setBorderPainted(false);
        minimizeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizeButton.setDefaultCapable(false);
        minimizeButton.setFocusPainted(false);
        minimizeButton.setFocusable(false);
        minimizeButton.setIconTextGap(0);
        minimizeButton.setRequestFocusEnabled(false);
        minimizeButton.setVerifyInputWhenFocusTarget(false);
        minimizeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeButtonMouseExited(evt);
            }
        });
        minimizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeButtonActionPerformed(evt);
            }
        });
        pnlTop.add(minimizeButton);
        minimizeButton.setBounds(920, 0, 18, 30);

        aboutButton.setBackground(new java.awt.Color(50, 27, 140));
        aboutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings_18px.png"))); // NOI18N
        aboutButton.setBorder(null);
        aboutButton.setBorderPainted(false);
        aboutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aboutButton.setDefaultCapable(false);
        aboutButton.setFocusPainted(false);
        aboutButton.setFocusable(false);
        aboutButton.setIconTextGap(0);
        aboutButton.setInheritsPopupMenu(true);
        aboutButton.setRequestFocusEnabled(false);
        aboutButton.setVerifyInputWhenFocusTarget(false);
        aboutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutButtonMouseExited(evt);
            }
        });
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });
        pnlTop.add(aboutButton);
        aboutButton.setBounds(890, 0, 18, 30);

        jPanel1.add(pnlTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));

        pnlMainObjects.setBackground(new java.awt.Color(249, 250, 253));
        pnlMainObjects.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(76, 41, 211));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MAIN_TOP_ICON_32px.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Zodiac Sign,");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 8, 150, 30));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Age Calculator");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 8, 190, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("& Birthstone");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 8, 160, 30));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("System");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 8, 90, 30));

        integer_ver_text.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        integer_ver_text.setForeground(new java.awt.Color(255, 255, 255));
        integer_ver_text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        integer_ver_text.setText("Integer ver.");
        jPanel2.add(integer_ver_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 32, 70, 20));

        pnlMainObjects.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));

        pnlInsertData.setBackground(new java.awt.Color(249, 250, 253));
        pnlInsertData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Please Insert Your Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Month");

        monthTF.setBackground(new java.awt.Color(249, 250, 253));
        monthTF.setForeground(new java.awt.Color(51, 51, 51));
        monthTF.setBorderColor(new java.awt.Color(204, 204, 204));
        monthTF.setPhColor(new java.awt.Color(153, 153, 153));
        monthTF.setPlaceholder("MM format (1-12)");
        monthTF.setxDarkIcon(true);
        monthTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                monthTFKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                monthTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                monthTFKeyTyped(evt);
            }
        });

        dayTF.setEditable(false);
        dayTF.setBackground(new java.awt.Color(249, 250, 253));
        dayTF.setForeground(new java.awt.Color(51, 51, 51));
        dayTF.setBorderColor(new java.awt.Color(204, 204, 204));
        dayTF.setPhColor(new java.awt.Color(153, 153, 153));
        dayTF.setPlaceholder("DD format (1-31)");
        dayTF.setxDarkIcon(true);
        dayTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dayTFKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dayTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dayTFKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Day");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Year");

        yearTF.setEditable(false);
        yearTF.setBackground(new java.awt.Color(249, 250, 253));
        yearTF.setForeground(new java.awt.Color(51, 51, 51));
        yearTF.setBorderColor(new java.awt.Color(204, 204, 204));
        yearTF.setPhColor(new java.awt.Color(153, 153, 153));
        yearTF.setPlaceholder("YYYY format");
        yearTF.setxDarkIcon(true);
        yearTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                yearTFKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                yearTFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                yearTFKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlInsertDataLayout = new javax.swing.GroupLayout(pnlInsertData);
        pnlInsertData.setLayout(pnlInsertDataLayout);
        pnlInsertDataLayout.setHorizontalGroup(
            pnlInsertDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInsertDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlInsertDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInsertDataLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(monthTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInsertDataLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(dayTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInsertDataLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(yearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlInsertDataLayout.setVerticalGroup(
            pnlInsertDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInsertDataLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlInsertDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInsertDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInsertDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pnlMainObjects.add(pnlInsertData, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 420, 230));

        clearBTN.setBackground(new java.awt.Color(0, 102, 204));
        clearBTN.setText("CLEAR");
        clearBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBTN.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        clearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBTNActionPerformed(evt);
            }
        });
        clearBTN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                clearBTNKeyPressed(evt);
            }
        });
        pnlMainObjects.add(clearBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 120, 50));

        okBTN.setBackground(new java.awt.Color(0, 204, 102));
        okBTN.setText("OK");
        okBTN.setEnabled(false);
        okBTN.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        okBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBTNActionPerformed(evt);
            }
        });
        okBTN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                okBTNKeyPressed(evt);
            }
        });
        pnlMainObjects.add(okBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 120, 50));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        pnlMainObjects.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 10, 400));

        pnlResult.setBackground(new java.awt.Color(249, 250, 253));
        pnlResult.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Result", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Zodiac Sign");

        answerzodiacTF.setEditable(false);
        answerzodiacTF.setBackground(new java.awt.Color(249, 250, 253));
        answerzodiacTF.setForeground(new java.awt.Color(51, 51, 51));
        answerzodiacTF.setBorderColor(new java.awt.Color(204, 204, 204));
        answerzodiacTF.setPhColor(new java.awt.Color(153, 153, 153));
        answerzodiacTF.setPlaceholder("Zodiac Sign");

        ageTF.setEditable(false);
        ageTF.setBackground(new java.awt.Color(249, 250, 253));
        ageTF.setForeground(new java.awt.Color(51, 51, 51));
        ageTF.setBorderColor(new java.awt.Color(204, 204, 204));
        ageTF.setPhColor(new java.awt.Color(153, 153, 153));
        ageTF.setPlaceholder("Age");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Age");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Calculated Age");

        calculatedageTF.setEditable(false);
        calculatedageTF.setBackground(new java.awt.Color(249, 250, 253));
        calculatedageTF.setForeground(new java.awt.Color(51, 51, 51));
        calculatedageTF.setBorderColor(new java.awt.Color(204, 204, 204));
        calculatedageTF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        calculatedageTF.setPhColor(new java.awt.Color(153, 153, 153));
        calculatedageTF.setPlaceholder("Year, Month and Day of your Age");
        calculatedageTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculatedageTFActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Birthstone");

        gemstoneTF.setEditable(false);
        gemstoneTF.setBackground(new java.awt.Color(249, 250, 253));
        gemstoneTF.setForeground(new java.awt.Color(51, 51, 51));
        gemstoneTF.setBorderColor(new java.awt.Color(204, 204, 204));
        gemstoneTF.setPhColor(new java.awt.Color(153, 153, 153));
        gemstoneTF.setPlaceholder("Birthstone");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Birthdate");

        birthdateTF.setEditable(false);
        birthdateTF.setBackground(new java.awt.Color(249, 250, 253));
        birthdateTF.setForeground(new java.awt.Color(51, 51, 51));
        birthdateTF.setBorderColor(new java.awt.Color(204, 204, 204));
        birthdateTF.setPhColor(new java.awt.Color(153, 153, 153));
        birthdateTF.setPlaceholder("Month/Day/Year");

        javax.swing.GroupLayout pnlResultLayout = new javax.swing.GroupLayout(pnlResult);
        pnlResult.setLayout(pnlResultLayout);
        pnlResultLayout.setHorizontalGroup(
            pnlResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultLayout.createSequentialGroup()
                .addGroup(pnlResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlResultLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlResultLayout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(ageTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlResultLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(calculatedageTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlResultLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(answerzodiacTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResultLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(birthdateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pnlResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gemstoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlResultLayout.setVerticalGroup(
            pnlResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResultLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(birthdateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answerzodiacTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(calculatedageTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gemstoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlMainObjects.add(pnlResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 420, 350));

        jPanel1.add(pnlMainObjects, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 980, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(980, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int xy, xx; //<-- for pnlTop
    private void exitButtonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseMoved

    }//GEN-LAST:event_exitButtonMouseMoved

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseEntered
        setColor1(exitButton);
        resetColor1(minimizeButton);
        resetColor1(aboutButton);
    }//GEN-LAST:event_exitButtonMouseEntered

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseExited
        resetColor1(exitButton);
        resetColor1(minimizeButton);
        resetColor1(aboutButton);
    }//GEN-LAST:event_exitButtonMouseExited

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // Exit/Close Button code:
        setColor1(exitButton);
        resetColor1(minimizeButton);
        resetColor1(aboutButton);

        //JOptionPane for Exit Confirm jop
        int p = JOptionPane.showConfirmDialog(this, "Do You Want To Exit?", mainnameString, JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            System.exit(0);
        } else {
            resetColor1(exitButton);
            resetColor1(minimizeButton);
            resetColor1(aboutButton);
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void minimizeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseEntered
        resetColor2(exitButton);
        resetColor2(aboutButton);
        setColor2(minimizeButton);
    }//GEN-LAST:event_minimizeButtonMouseEntered

    private void minimizeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeButtonMouseExited
        resetColor2(exitButton);
        resetColor2(minimizeButton);
        resetColor2(aboutButton);
    }//GEN-LAST:event_minimizeButtonMouseExited

    private void minimizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizeButtonActionPerformed
        // Minimize Button code:
        resetColor2(exitButton);
        resetColor2(aboutButton);
        setColor2(minimizeButton);

        MainZABSystem.this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonActionPerformed

    private void pnlTopMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_pnlTopMouseDragged

    private void pnlTopMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_pnlTopMousePressed

    private void aboutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseEntered
        resetColor2(exitButton);
        setColor2(aboutButton);
        resetColor2(minimizeButton);
    }//GEN-LAST:event_aboutButtonMouseEntered

    private void aboutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseExited
        resetColor2(exitButton);
        resetColor2(minimizeButton);
        resetColor2(aboutButton);
    }//GEN-LAST:event_aboutButtonMouseExited

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // Minimize Button code:
        resetColor2(exitButton);
        resetColor2(minimizeButton);
        setColor2(aboutButton);

        //for ABOUT
        final JPopupMenu popup = new JPopupMenu();
        final JMenuItem menuAuthor = new JMenuItem("Developer Information");
        final JMenuItem menuLight = new JMenuItem("Light Mode");
        final JMenuItem menuDark = new JMenuItem("Dark Mode");

        //ActionListener for Clicking the About Panel
        ActionListener openAuthor
                = (ActionEvent e) -> {
                    AboutAuthorZAB aboutpanel = new AboutAuthorZAB();
                    aboutpanel.setVisible(true);
                };

        //light mode theme action Click
        ActionListener lightmodeAction
                = (ActionEvent e) -> {
                    System.out.println("light");
                    try {
                        UIManager.setLookAndFeel(new FlatLightLaf());
                        SwingUtilities.updateComponentTreeUI(this);
                        this.pack();
                    } catch (UnsupportedLookAndFeelException ex) {
                        System.err.println("Failed to initialize modern Light LaF " + ex);
                    }
                };

        //dark mode theme action Click
        ActionListener darkmodeAction
                = (ActionEvent e) -> {
                    System.out.println("dark");
                    try {
                        UIManager.setLookAndFeel(new FlatDarkLaf());
                        SwingUtilities.updateComponentTreeUI(this);
                        this.pack();
                    } catch (UnsupportedLookAndFeelException ex) {
                        System.err.println("Failed to initialize modern Dark LaF " + ex);
                    }
                };

        //Add action listener to JMenus
        menuAuthor.addActionListener(openAuthor);
        menuLight.addActionListener(lightmodeAction);
        menuDark.addActionListener(darkmodeAction);

        //Add the JMenu panel to JPopup panel
        popup.add(menuAuthor);
        //popup.addSeparator();
        //popup.add(menuLight);
        //popup.add(menuDark);

        //set the Light Weight Popup
        popup.setLightWeightPopupEnabled(true);

        //open the Popup when about button is click
        popup.show(aboutButton, aboutButton.getWidth() / 2, aboutButton.getHeight() / 1);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void clearBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBTNActionPerformed
        //clear btn click
        monthTF.requestFocusInWindow();
        monthTF.setText("");
        dayTF.setText("");
        yearTF.setText("");
        ageTF.setText("");
        answerzodiacTF.setText("");
        calculatedageTF.setText("");
        gemstoneTF.setText("");
        birthdateTF.setText("");

        okBTN.setEnabled(false);
        dayTF.setEditable(false);
        yearTF.setEditable(false);
        monthTF.setEditable(true);
    }//GEN-LAST:event_clearBTNActionPerformed

    private void okBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBTNActionPerformed
        //OK BTN code

        //get the Typed text of yearTF, monthTF, and dayTF to their Integer parseInt
        int yearInt = Integer.parseInt(yearTF.getText());
        int monthInt = Integer.parseInt(monthTF.getText());
        int dayInt = Integer.parseInt(dayTF.getText());

        //get the lenght of the Typed numbers in Year Field. 4 Characters only.
        String yearlenght = yearTF.getText();

        //check the year if it is valid from the current year
        checkInputBirthdate.set(yearInt, monthInt, dayInt);

        //check if the day, month and year field is empty or not. = NOT WORKING!
        if ((dayTF.getText().length() == 0 || (monthTF.getText().length() == 0 || (yearTF.getText().length() == 0)))) {
            JOptionPane.showMessageDialog(null, "One of the required field is empty!", mainErrorString, JOptionPane.ERROR_MESSAGE);
            System.out.println("Empty.");

            //check if the month entered is valid from validMonth static void
        } else if (monthTF.getText().equals(validMonth(--monthInt))) {
            System.out.println("1");

            //check if the day entered is valid from validDay static void
        } else if (dayTF.getText().equals(validDay(dayInt, monthInt, yearInt))) {
            System.out.println("2");

            //yearTF field length checker. 4 characters only
        } else if (!(yearlenght.length() > 3)) {
            JOptionPane.showMessageDialog(null, "<html><center>Year field must have 4 characters exactly! <br>e.g: 2002</center></html>", mainErrorString, JOptionPane.ERROR_MESSAGE);
            yearTF.setText("");
            yearTF.requestFocusInWindow();

            //for CAPRICORN zodiac sign (DECEMBER 12 - 31)
        } else if ((monthTF.getText().equals("12") && dayInt >= 22 && dayInt <= 31)) {
            try {
                answerzodiacTF.setText("Capricorn"); //zodiac sign
                birthdateTF.setText("December " + dayTF.getText() + ", " + yearTF.getText() + ""); //set this to Birthdate Field

                //for Pasting Current Calculated Age to Calculated Age Field
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date birthDate = null;
                birthDate = sdf.parse("" + dayTF.getText() + "/" + monthTF.getText() + "/" + yearTF.getText() + "");
                AgeYearsMonthsDays_Constructor age = calculateAgeYearsMonthsDays(birthDate); //based on the AgeYearsMonthsDays_Constructor Java Class
                calculatedageTF.setText("" + age); //paste the Calculated Age
                System.out.println(age);

                //for Pasting Current Exact Age to Age Field
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                Date birthDate1 = sdf1.parse("" + dayTF.getText() + "/" + monthTF.getText() + "/" + yearTF.getText() + "");
                AgeYearsOnly_Constructor age1 = calculateAgeOnly(birthDate1); //based on the AgeYearsOnly_Constructor Java Class
                ageTF.setText("" + age1); //paste the exact Age
                System.out.println(age1);

                //for birthstone pasting
                birthstone();

                System.out.println("check age: " + checkTheAge_Year(checkInputBirthdate.getTime())); //check if the age is valid from the current year = NOT NEED

            } catch (ParseException ex) {
                Logger.getLogger(MainZABSystem.class.getName()).log(Level.SEVERE, null, ex);
            }

            //for CAPRICORN zodiac sign (JANUARY 1 - 19)
        } else if ((monthTF.getText().equals("1") || (monthTF.getText().equals("01") && dayInt >= 1 && dayInt <= 19))) {
            try {
                answerzodiacTF.setText("Capricorn"); //zodiac sign
                birthdateTF.setText("January " + dayTF.getText() + ", " + yearTF.getText() + ""); //set this to Birthdate Field

                //for Pasting Current Calculated Age to Calculated Age Field
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date birthDate = null;
                birthDate = sdf.parse("" + dayTF.getText() + "/" + monthTF.getText() + "/" + yearTF.getText() + "");
                AgeYearsMonthsDays_Constructor age = calculateAgeYearsMonthsDays(birthDate); //based on the AgeYearsMonthsDays_Constructor Java Class
                calculatedageTF.setText("" + age); //paste the Calculated Age
                System.out.println(age);

                //for Pasting Current Age to Age Field
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                Date birthDate1 = sdf1.parse("" + dayTF.getText() + "/" + monthTF.getText() + "/" + yearTF.getText() + "");
                AgeYearsOnly_Constructor age1 = calculateAgeOnly(birthDate1); //based on the AgeYearsOnly_Constructor Java Class
                ageTF.setText("" + age1); //paste the exact Age
                System.out.println(age1);

                //for birthstone pasting
                birthstone();

                System.out.println("check age: " + checkTheAge_Year(checkInputBirthdate.getTime())); //check if the age is valid from the current year = NOT NEED

            } catch (ParseException ex) {
                Logger.getLogger(MainZABSystem.class.getName()).log(Level.SEVERE, null, ex);
            }

            //paste the zodiac signs and birthstone in this else code (RIGHT WAY)
        } else {
            // determine the sign
            calendar.set(yearInt, monthInt, dayInt);
            // Match the year for the sign start dates
            for (int i = 0; i < signStartDates.length; ++i) {
                signStartDates[i].set(GregorianCalendar.YEAR, yearInt);
            }

            for (int i = 0; i < signStartDates.length; ++i) {
                if (calendar.after(signStartDates[i])
                        && calendar.before(signStartDates[(i + 1) % signStartDates.length])) {
                    try {
                        //print the age, calculated age and others
                        System.out.println(dateFormat.format(calendar.getTime()) + " is in the sign of " + signs[i]);
                        birthdateTF.setText(dateFormat.format(calendar.getTime()));
                        answerzodiacTF.setText(signs[i]);

                        //for Pasting Current Calculated Age to Calculated Age Field
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date birthDate = sdf.parse("" + dayTF.getText() + "/" + monthTF.getText() + "/" + yearTF.getText() + "");
                        AgeYearsMonthsDays_Constructor age = calculateAgeYearsMonthsDays(birthDate); //based on the AgeYearsMonthsDays_Constructor Java Class
                        calculatedageTF.setText("" + age); //paste the calculated Age

                        //for Pasting Current Exact Age to Age Field
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                        Date birthDate1 = sdf1.parse("" + dayTF.getText() + "/" + monthTF.getText() + "/" + yearTF.getText() + "");
                        AgeYearsOnly_Constructor age1 = calculateAgeOnly(birthDate1); //based on the AgeYearsOnly_Constructor Java Class
                        ageTF.setText("" + age1); //paste the exact Age
                        System.out.println("check age: " + checkTheAge_Year(checkInputBirthdate.getTime())); //check if the age is valid from the current year = NOT NEED
                        break;

                    } catch (ParseException ex) {
                        Logger.getLogger(MainZABSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            //print the birthstone in the field.
            birthstone();
        }
    }//GEN-LAST:event_okBTNActionPerformed

    private void calculatedageTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculatedageTFActionPerformed
    }//GEN-LAST:event_calculatedageTFActionPerformed

    private void monthTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_monthTFKeyPressed
        //ENTER and TAB Key Event
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            dayTF.requestFocusInWindow();
        }
    }//GEN-LAST:event_monthTFKeyPressed

    private void dayTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dayTFKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            yearTF.requestFocusInWindow();
        }
    }//GEN-LAST:event_dayTFKeyPressed

    private void yearTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTFKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            okBTN.requestFocusInWindow();
            okBTN.doClick(); //button only
        }
    }//GEN-LAST:event_yearTFKeyPressed

    private void clearBTNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_clearBTNKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            monthTF.requestFocusInWindow();
        }
    }//GEN-LAST:event_clearBTNKeyPressed

    private void okBTNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_okBTNKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_TAB) {
            clearBTN.requestFocusInWindow();
            clearBTN.doClick(); //button only
        }
    }//GEN-LAST:event_okBTNKeyPressed

    private void monthTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_monthTFKeyTyped

        //disable copy, cut and paste
        monthTF.setTransferHandler(null);

        try {
            //numbers only.
            char c = evt.getKeyChar();
            if (!((c >= '0') && (c <= '9')
                    || (c == KeyEvent.VK_BACK_SPACE)
                    || (c == KeyEvent.VK_DELETE)
                    || (c == KeyEvent.VK_ENTER)
                    || (c == KeyEvent.VK_CONTROL)
                    || (c == KeyEvent.VK_CAPS_LOCK)
                    || (c == KeyEvent.VK_INSERT)
                    || (c == KeyEvent.VK_UNDO)
                    || (c == KeyEvent.VK_TAB))) {
                evt.consume();
                BalloonTipMonth1();
                //JOptionPane.showMessageDialog(null, "<html><center>You must enter numeric values (01-12) only! <br>January is 01, December is 12 <br>e.g: 07</html></center>", mainErrorString, JOptionPane.ERROR_MESSAGE);
                monthTF.requestFocusInWindow();

                // if on the text field the numbers are bigger than 12, consumes the last number typed    
            } else if (Integer.parseInt(monthTF.getText() + c) > 12) {
                evt.consume();
                BalloonTipMonth();
                monthTF.requestFocusInWindow();
            }
        } catch (NumberFormatException e) {
        }

        //limit the number length
        String l = monthTF.getText();
        if (!(l.length() < 2)) {
            evt.consume();
        }

        /*    
        try {
            if (Integer.parseInt(monthTF.getText() + c) > 12) {
                evt.consume(); // if on the text field the numbers are bigger 
                                 // than 12, consumes the last number typed    
                System.out.println("No greater than 12 numbers can insert here");
            }
        } catch (NumberFormatException e) {
        }*/

    }//GEN-LAST:event_monthTFKeyTyped

    private void dayTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dayTFKeyTyped

        //disable copy, cut and paste
        dayTF.setTransferHandler(null);

        try {
            //numbers only.
            char c = evt.getKeyChar();
            if (!((c >= '0') && (c <= '9')
                    || (c == KeyEvent.VK_BACK_SPACE)
                    || (c == KeyEvent.VK_DELETE)
                    || (c == KeyEvent.VK_ENTER)
                    || (c == KeyEvent.VK_CONTROL)
                    || (c == KeyEvent.VK_CAPS_LOCK)
                    || (c == KeyEvent.VK_INSERT)
                    || (c == KeyEvent.VK_UNDO)
                    || (c == KeyEvent.VK_TAB))) {
                evt.consume();
                BalloonTipDay1();
                //JOptionPane.showMessageDialog(null, "<html><center>You must enter numeric values (01-12) only! <br>January is 01, December is 12 <br>e.g: 07</html></center>", mainErrorString, JOptionPane.ERROR_MESSAGE);
                dayTF.requestFocusInWindow();

                // if on the text field the numbers are bigger than 31, consumes the last number typed    
            } else if (Integer.parseInt(dayTF.getText() + c) > 31) {
                evt.consume();
                BalloonTipDay();
                dayTF.requestFocusInWindow();
            }
        } catch (NumberFormatException e) {
        }

        //limit the number length
        String l = dayTF.getText();
        if (!(l.length() < 2)) {
            evt.consume();
        }
    }//GEN-LAST:event_dayTFKeyTyped

    private void yearTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTFKeyTyped

        //disable copy, cut and paste
        yearTF.setTransferHandler(null);

        //numbers only.
        char c = evt.getKeyChar();
        //if (!(Character.isDigit(c1))) {
        if (!((c >= '0') && (c <= '9')
                || (c == KeyEvent.VK_CONTROL)
                || (c == KeyEvent.VK_COPY)
                || (c == KeyEvent.VK_CUT)
                || (c == KeyEvent.VK_PASTE)
                || (c == KeyEvent.VK_UNDO)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_ENTER)
                || (c == KeyEvent.VK_TAB))) {
            evt.consume();
            BalloonTipYear(); //get the warning
            yearTF.requestFocusInWindow();
        }

        //limit the number length
        String l = yearTF.getText();
        if (!(l.length() < 4)) {
            evt.consume();
        }
    }//GEN-LAST:event_yearTFKeyTyped

    private void dayTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dayTFKeyReleased
        //check if the jtextfield is empty or not
        String checkTFlength = dayTF.getText(); //getText from the CURRENT field dayTF
        if (checkTFlength.trim().length() < 1) { //lessthan 1 so EQUALS 0 or EMPTY
            yearTF.setEditable(false); //disabled the next textfield Year if DAY FIELD is EMPTY
            dayTF.requestFocusInWindow(); //request the TYPE CURSOR on the dayTF field
            //okBTN.setEnabled(false);
        } else {
            yearTF.setEditable(true); //yearTF will be automatically editable if the dayTF have objects (numbers typed)
        }

        String checklengthMONTH = monthTF.getText();
        String checklengthDAY = dayTF.getText();
        String checklengthYEAR = yearTF.getText();
        //if the field is LessThan the number declared here, the OKBTN will be DISABLED automatically.
        if (checklengthMONTH.trim().length() < 1
                | monthTF.getText().equals("0")
                | monthTF.getText().equals("00")
                | checklengthDAY.trim().length() < 1
                | dayTF.getText().equals("0")
                | dayTF.getText().equals("00")
                | checklengthYEAR.trim().length() < 1
                | yearTF.getText().equals("0")
                | yearTF.getText().equals("00")
                | yearTF.getText().equals("000")
                | yearTF.getText().equals("0000")) {
            okBTN.setEnabled(false); //okBTN will be disabled if the one of the fields is empty.
            clearResultPanelOnly(); //* automatic clear if the date is invalid

            //if the field is GreaterThan the number declared here, the OKBTN will be ENABLED automatically.
        } else if (checklengthMONTH.trim().length() > 1 | checklengthDAY.trim().length() > 1 | checklengthYEAR.trim().length() > 3) {
            okBTN.setEnabled(true); //okBTN will be enabled if the fields have an NUMBERS typed.
            
            okBTN.doClick(); //* automatic click the OK BUTTON automatically
        }
    }//GEN-LAST:event_dayTFKeyReleased

    private void monthTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_monthTFKeyReleased
        //check if the jtextfield is empty or not
        String checkTFlength = monthTF.getText(); //getText from the CURRENT field monthTF
        if (checkTFlength.trim().length() < 1) { //lessthan 1 so EQUALS 0 or EMPTY
            dayTF.setEditable(false); //disabled the next textfield Day if MONTH FIELD is EMPTY
            monthTF.requestFocusInWindow(); //request the TYPE CURSOR on the monthTF field
            //okBTN.setEnabled(false);
        } else {
            dayTF.setEditable(true); //dayTF will be automatically editable if the monthTF have objects (numbers typed)
        }

        String checklengthMONTH = monthTF.getText();
        String checklengthDAY = dayTF.getText();
        String checklengthYEAR = yearTF.getText();
        //if the field is LessThan the number declared here, the OKBTN will be DISABLED automatically.
        if (checklengthMONTH.trim().length() < 1
                | monthTF.getText().equals("0")
                | monthTF.getText().equals("00")
                | checklengthDAY.trim().length() < 1
                | dayTF.getText().equals("0")
                | dayTF.getText().equals("00")
                | checklengthYEAR.trim().length() < 1
                | yearTF.getText().equals("0")
                | yearTF.getText().equals("00")
                | yearTF.getText().equals("000")
                | yearTF.getText().equals("0000")) {
            okBTN.setEnabled(false); //okBTN will be disabled if the one of the fields is empty.
            clearResultPanelOnly(); //* automatic clear if the date is invalid

            //if the field is GreaterThan the number declared here, the OKBTN will be ENABLED automatically.
        } else if (checklengthMONTH.trim().length() > 1 | checklengthDAY.trim().length() > 1 | checklengthYEAR.trim().length() > 3) {
            okBTN.setEnabled(true); //okBTN will be enabled if the fields have an NUMBERS typed.  
            
            okBTN.doClick(); //* automatic click the OK BUTTON automatically
        }
    }//GEN-LAST:event_monthTFKeyReleased

    private void yearTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearTFKeyReleased
        //check if the jtextfield is empty or not
        String checkTFlength = yearTF.getText(); //getText from the CURRENT field yearTF
        if (checkTFlength.trim().length() < 3) { //lessthan 3
            yearTF.requestFocusInWindow(); //request the TYPE CURSOR on the yearTF field
            okBTN.setEnabled(false);
        } else if (checkTFlength.trim().length() > 3) { //greater than 3 or 4 numbers in yearTF
            okBTN.setEnabled(true);
        }

        String checklengthMONTH = monthTF.getText();
        String checklengthDAY = dayTF.getText();
        String checklengthYEAR = yearTF.getText();
        //if the field is LessThan the number declared here, the OKBTN will be DISABLED automatically.
        if (checklengthMONTH.trim().length() < 1
                | monthTF.getText().equals("0")
                | monthTF.getText().equals("00")
                | checklengthDAY.trim().length() < 1
                | dayTF.getText().equals("0")
                | dayTF.getText().equals("00")
                | checklengthYEAR.trim().length() < 4
                | //lessthan 3 characters - or Year number will not accepted (ONLY 1000 > )
                yearTF.getText().equals("0")
                | yearTF.getText().equals("00")
                | yearTF.getText().equals("000")
                | yearTF.getText().equals("0000")) {
            okBTN.setEnabled(false); //okBTN will be disabled if the one of the fields is empty.
            clearResultPanelOnly(); //* automatic clear if the date is invalid

            //if the field is GreaterThan the number declared here, the OKBTN will be ENABLED automatically.
        } else if (checklengthMONTH.trim().length() > 1 | checklengthDAY.trim().length() > 1 | checklengthYEAR.trim().length() > 4) {
            okBTN.setEnabled(true); //okBTN will be enabled if the fields have an NUMBERS typed.  
            
            okBTN.doClick(); //* automatic click the OK BUTTON automatically
        }
    }//GEN-LAST:event_yearTFKeyReleased

    private void pnlTopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopMouseClicked
        //for SHORTCUTS
        final JPopupMenu popupRightClick = new JPopupMenu();
        final JMenuItem menuMinimize = new JMenuItem("Minimize");
        final JMenuItem menuClose = new JMenuItem("Close Permanently");
        final JMenuItem menuRestore = new JMenuItem("Restore to Default Location");

        JLabel ShortcutsLBL = new JLabel();
        ShortcutsLBL.setText(" Shortcuts");
        ShortcutsLBL.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10));

        if (SwingUtilities.isRightMouseButton(evt)) {

            //------------------------------------------//
            //restore
            ActionListener restoreActionListener
                    = (ActionEvent e) -> {
                        this.setLocationRelativeTo(null);
                    };
            menuRestore.addActionListener(restoreActionListener);

            //------------------------------------------//
            //minimize
            ActionListener minimizeActionListener
                    = (ActionEvent e) -> {
                        MainZABSystem.this.setState(Frame.ICONIFIED);
                    };
            menuMinimize.addActionListener(minimizeActionListener);

            //------------------------------------------//
            //close taskbar
            ActionListener closeActionListener
                    = (ActionEvent e) -> {
                        exitButton.doClick();
                    };
            menuClose.addActionListener(closeActionListener);

            //----------------------------------------------------------//
            //set jmenus cursor
            menuRestore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            menuMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            menuClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            //set popup background
            popupRightClick.setBackground(new Color(249, 250, 253));

            //add popup on click
            popupRightClick.removeAll();
            popupRightClick.add(menuRestore);
            popupRightClick.addSeparator();
            popupRightClick.add(ShortcutsLBL);
            popupRightClick.add(menuMinimize);
            popupRightClick.add(menuClose);
            popupRightClick.updateUI();

            //show popup on right click.
            //popupRightClick.show(pnlTop, evt.getXOnScreen(), evt.getYOnScreen()/3);
            popupRightClick.show(pnlTop, evt.getX(), evt.getY() / 3);
        }
    }//GEN-LAST:event_pnlTopMouseClicked

    private void guiTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guiTitleMouseClicked
        //for SHORTCUTS
        final JPopupMenu popupRightClick = new JPopupMenu();
        final JMenuItem menuMinimize = new JMenuItem("Minimize");
        final JMenuItem menuClose = new JMenuItem("Close Permanently");
        final JMenuItem menuRestore = new JMenuItem("Restore to Default Location");

        JLabel ShortcutsLBL = new JLabel();
        ShortcutsLBL.setText(" Shortcuts");
        ShortcutsLBL.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10));

        if (SwingUtilities.isRightMouseButton(evt)) {

            //------------------------------------------//
            //restore
            ActionListener restoreActionListener
                    = (ActionEvent e) -> {
                        this.setLocationRelativeTo(null);
                    };
            menuRestore.addActionListener(restoreActionListener);

            //------------------------------------------//
            //minimize
            ActionListener minimizeActionListener
                    = (ActionEvent e) -> {
                        MainZABSystem.this.setState(Frame.ICONIFIED);
                    };
            menuMinimize.addActionListener(minimizeActionListener);

            //------------------------------------------//
            //close taskbar
            ActionListener closeActionListener
                    = (ActionEvent e) -> {
                        exitButton.doClick();
                    };
            menuClose.addActionListener(closeActionListener);

            //----------------------------------------------------------//
            //set jmenus cursor
            menuRestore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            menuMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            menuClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            //set popup background
            popupRightClick.setBackground(new Color(249, 250, 253));

            //add popup on click
            popupRightClick.removeAll();
            popupRightClick.add(menuRestore);
            popupRightClick.addSeparator();
            popupRightClick.add(ShortcutsLBL);
            popupRightClick.add(menuMinimize);
            popupRightClick.add(menuClose);
            popupRightClick.updateUI();

            //show popup on right click.
            //popupRightClick.show(guiTitle, evt.getXOnScreen(), evt.getYOnScreen()/3);
            popupRightClick.show(guiTitle, evt.getX(), evt.getY() / 3);
        }
    }//GEN-LAST:event_guiTitleMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.setState(Frame.NORMAL);
        this.setEnabled(true);
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setState(Frame.NORMAL);
        this.setEnabled(true);
    }//GEN-LAST:event_formWindowOpened

    private void guiTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guiTitleMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_guiTitleMousePressed

    private void guiTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guiTitleMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_guiTitleMouseDragged

    // set Color to pnlTop (EXIT)
    void setColor1(JButton btn1) {
        btn1.setBackground(new Color(255, 51, 51));
    }

    void resetColor1(JButton btn1) {
        btn1.setBackground(new Color(50, 27, 140));
    }

    // set Color to pnlTop (MINIMIZE, SETTINGS)
    void setColor2(JButton btn2) {
        btn2.setBackground(new Color(155, 135, 231));
    }

    void resetColor2(JButton btn2) {
        btn2.setBackground(new Color(50, 27, 140));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize modern LaF" + ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainZABSystem().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private static rojerusan.RSMetroTextPlaceHolder ageTF;
    private static rojerusan.RSMetroTextPlaceHolder answerzodiacTF;
    private static rojerusan.RSMetroTextPlaceHolder birthdateTF;
    private static rojerusan.RSMetroTextPlaceHolder calculatedageTF;
    private rojerusan.RSMaterialButtonRectangle clearBTN;
    private static rojerusan.RSMetroTextPlaceHolder dayTF;
    private javax.swing.JButton exitButton;
    private static rojerusan.RSMetroTextPlaceHolder gemstoneTF;
    private javax.swing.JLabel guiTitle;
    private javax.swing.JLabel integer_ver_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton minimizeButton;
    private static rojerusan.RSMetroTextPlaceHolder monthTF;
    private static rojerusan.RSMaterialButtonRectangle okBTN;
    private javax.swing.JPanel pnlInsertData;
    private javax.swing.JPanel pnlMainObjects;
    private javax.swing.JPanel pnlResult;
    private javax.swing.JPanel pnlTop;
    private static rojerusan.RSMetroTextPlaceHolder yearTF;
    // End of variables declaration//GEN-END:variables

    //check if the month is Valid
    private static boolean validMonth(int month) {
        if (month >= 0 && month <= 11) {
            return true;
        } else //System.out.println("The month value must be from 1 to 12. Try again.");
        {
            JOptionPane.showMessageDialog(null, "The month value must be from 1 to 12. Try again.", mainErrorString, JOptionPane.ERROR_MESSAGE);
        }
        clearInputs();
        return false;
    }

    // Validate the day value for the month and year
    private static boolean validDay(int day, int month, int year) {
        /*
		 * A valid day must be: - between 1 and 31 - less than 31 when the month is
		 * April, June, September, or November - less than 29 when the month is February
		 * and it is not a leap year - less than 30 when the month is February and it is
		 * a leap year
         */
        if (day < 1 || day > 31) {
            //System.out.println("Day values must be between 1 and 31. Please Try again.");
            JOptionPane.showMessageDialog(null, "Day values must be between 1 and 31. Please Try again.", mainErrorString, JOptionPane.ERROR_MESSAGE);
            clearInputs();
            return false;
        }

        if (day > 30 && (month == 3 || month == 5 || month == 8 || month == 10)) {
            //System.out.println("Day values must be less than 31 when the month is " + monthNames[month] + ". Please Try again.");
            JOptionPane.showMessageDialog(null, "Day values must be less than 31 when the month is " + monthNames[month] + ". Please Try again.", mainErrorString, JOptionPane.ERROR_MESSAGE);
            clearInputs();
            return false;
        }

        if (day > 28 && month == 1 && !calendar.isLeapYear(year)) {
            //System.out.println(year + " is not a leap year so day values must be less than 29. Try again.");
            JOptionPane.showMessageDialog(null, year + " is not a leap year so day values must be less than 29. Try again.", mainErrorString, JOptionPane.ERROR_MESSAGE);
            clearInputs();
            return false;
        }

        if (day > 29 && month == 1 && calendar.isLeapYear(year)) {
            clearInputs();
            return false;
        }
        return true;
    }

    //get the Calculated Age. E.G: 18y/o, 9mo., & 15 days Alive
    private static AgeYearsMonthsDays_Constructor calculateAgeYearsMonthsDays(Date birthDate) {
        int years = 0;
        int months = 0;
        int days = 0;

        //create calendar object for birth day
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(birthDate.getTime());

        //create calendar object for current day
        long currentTime = System.currentTimeMillis();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(currentTime);

        //Get difference between years
        years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        int currMonth = now.get(Calendar.MONTH) + 1;
        int birthMonth = birthDay.get(Calendar.MONTH) + 1;

        //Get difference between months
        months = currMonth - birthMonth;

        //if month difference is in negative then reduce years by one 
        //and calculate the number of months.
        if (months < 0) {
            years--;
            months = 12 - birthMonth + currMonth;
            if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
                months--;
            }
        } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            years--;
            months = 11;
        }

        //Calculate the days
        if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE)) {
            days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
        } else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            int today = now.get(Calendar.DAY_OF_MONTH);
            now.add(Calendar.MONTH, -1);
            days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
        } else {
            days = 0;
            if (months == 12) {
                years++;
                months = 0;
            }
        }
        //Create new AgeYearsMonthsDays_Constructor object 
        return new AgeYearsMonthsDays_Constructor(days, months, years);
    }

    //get the Exact Age. E.G: 18 years old.
    private static AgeYearsOnly_Constructor calculateAgeOnly(Date birthDate) {
        int years = 0;
        int months = 0;
        int days = 0;

        //create calendar object for birth day
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(birthDate.getTime());

        //create calendar object for current day
        long currentTime = System.currentTimeMillis();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(currentTime);

        //Get difference between years
        years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        int currMonth = now.get(Calendar.MONTH) + 1;
        int birthMonth = birthDay.get(Calendar.MONTH) + 1;

        //Get difference between months
        months = currMonth - birthMonth;

        //if month difference is in negative then reduce years by one 
        //and calculate the number of months.
        if (months < 0) {
            years--;
            months = 12 - birthMonth + currMonth;
            if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
                months--;
            }
        } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            years--;
            months = 11;
        }

        //Calculate the days
        if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE)) {
            days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
        } else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            int today = now.get(Calendar.DAY_OF_MONTH);
            now.add(Calendar.MONTH, -1);
            days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
        } else {
            days = 0;
            if (months == 12) {
                years++;
                months = 0;
            }
        }
        //Create new AgeYearsMonthsDays_Constructor object 
        return new AgeYearsOnly_Constructor(days, months, years);
    }

    //check if the Entered Year in the yearTF is Valid from the current year.
    public static int checkTheAge_Year(Date dateOfBirth) {
        
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(dateOfBirth);
        
        if (birthDate.after(today)) {
            new Thread(() -> {
                try {
                    //start thread
                    clearResultPanelOnly(); //clear the result panel first
                    Thread.sleep(100); //<-- sleep in 100 milliseconds
                } catch (InterruptedException e) {
                }
                //closing thread
                yearTF.setText(""); //clear the year Input Text
                JOptionPane.showMessageDialog(null, "<html><center>You don't exist yet.<br>Please try again!</br></center></html>", mainErrorString, JOptionPane.ERROR_MESSAGE);
                yearTF.requestFocusInWindow(); //focus the type cursor to Year Input Text
            }).start();
        }

        int todayYear = today.get(Calendar.YEAR);
        int birthDateYear = birthDate.get(Calendar.YEAR);
        int todayDayOfYear = today.get(Calendar.DAY_OF_YEAR);
        int birthDateDayOfYear = birthDate.get(Calendar.DAY_OF_YEAR);
        int todayMonth = today.get(Calendar.MONTH);
        int birthDateMonth = birthDate.get(Calendar.MONTH);
        int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);
        int birthDateDayOfMonth = birthDate.get(Calendar.DAY_OF_MONTH);
        int age = todayYear - birthDateYear;

        // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year
        if ((birthDateDayOfYear - todayDayOfYear > 3) || (birthDateMonth > todayMonth)) {
            age--;

            // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
        } else if ((birthDateMonth == todayMonth) && (birthDateDayOfMonth > todayDayOfMonth)) {
            age--;
        }
        return age;
    }
}
