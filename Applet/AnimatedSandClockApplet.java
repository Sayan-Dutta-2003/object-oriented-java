package Applet;

import java.applet.Applet ;
import java.awt.*;
import java.util.Random ;
public class AnimatedSandClockApplet extends Applet implements Runnable {
    private static final int NUM_GRAINS = 50;
    private int [] grainX = new int[ NUM_GRAINS ];
    private int [] grainY = new int[ NUM_GRAINS ];
    private boolean [] hasFallen = new boolean [ NUM_GRAINS ];
    private int fallenCount = 0;
    private Thread animator ;
    private Random rand = new Random () ;
    @Override
    public void init () {
        setSize (300 , 500) ;
// initialize grains at random positions inside the upper triangle
        for (int i = 0; i < NUM_GRAINS ; i ++) {
            spawnGrainAtTop ( i ) ;
            hasFallen [ i ] = false ;
        }
    }
    private void spawnGrainAtTop (int i ) {
// y between top rim (50) and neck (250)
        int y = 50 + rand . nextInt (200) ;
// compute x- range at this y within upper triangle
        float frac = ( float ) ( y - 50) / 200; // 0 at y=50 , 1 at y =250
        int xLeft = 100 + (int) (50 * frac ) ;
        int xRight = 200 - (int) (50 * frac ) ;
        int x = xLeft + rand . nextInt ( xRight - xLeft + 1) ;
        grainX [ i ] = x ;
        grainY [ i ] = y ;
    }
    @Override
    public void start () {
        animator = new Thread ( this ) ;
        animator . start () ;
    }
    @Override
    public void stop () {
        animator = null ;
    }
    @Override

    public void run () {
        while ( Thread . currentThread () == animator ) {
            for (int i = 0; i < NUM_GRAINS ; i ++) {
                if (! hasFallen [ i ]) {
                    grainY [ i ]++;
                    if ( grainY [ i ] > 450) {
                        hasFallen [ i ] = true ;
                        fallenCount ++;
                    }
                }
            }
            repaint () ;
// stop when all grains have fallen
            if ( fallenCount >= NUM_GRAINS ) {
                stop () ;
                break ;
            }
            try {
                Thread . sleep (50) ;
            } catch ( InterruptedException e ) {
                break ;
            }
        }
    }
    @Override
    public void paint ( Graphics g ) {
// Clear background
        g . setColor ( Color . WHITE ) ;
        g . fillRect (0 , 0 , getWidth () , getHeight () ) ;
// Draw hourglass outline
        g . setColor ( Color . BLACK ) ;
// Top and bottom rims
        g . drawLine (100 , 50 , 200 , 50) ;
        g . drawLine (100 , 450 , 200 , 450) ;
// Sides down to the neck
        g . drawLine (100 , 50 , 150 , 250) ;
        g . drawLine (200 , 50 , 150 , 250) ;
// Sides up from the neck
        g . drawLine (100 , 450 , 150 , 250) ;
        g . drawLine (200 , 450 , 150 , 250) ;
// Draw all grains that haven ’t fallen past bottom
        g . setColor (new Color (194 , 178 , 128) ) ;
        for (int i = 0; i < NUM_GRAINS ; i ++) {
            if (! hasFallen [ i ]) {
                int x = grainX [ i ];
                int y = grainY [ i ];
// clamp inside shape as before
                if ( y < 250) {
                    float frac = ( float ) ( y - 50) / 200;
                    int xLeft = 100 + (int) (50 * frac ) ;
                    int xRight = 200 - (int) (50 * frac ) ;
                    x = Math . max ( xLeft , Math . min (x , xRight ) ) ;
                } else {
                    float frac = ( float ) (450 - y ) / 200;
                    int xLeft = 100 + (int) (50 * frac ) ;
                    int xRight = 200 - (int) (50 * frac ) ;
                    x = Math . max ( xLeft , Math . min (x , xRight ) ) ;
                }
                g . fillOval ( x - 3 , y - 3 , 6 , 6) ;
            }
        }
    }
}