
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;

public class SevenSegmentTester {
	
	
  public static void main(String[] args)
  {
    JFrame w = new JFrame("Seven Segment Simulation");
    w.setBounds(100, 100, 480, 640);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    FileIO accessor = new FileIO();
    SevenSegment panel = (SevenSegment)accessor.readObject("sevseg.wau");
    
//    final SevenSegment panel = new SevenSegment();
    if (panel == null) {
    	panel = new SevenSegment();
    } else {
    	panel.initializeGUI();
    }
    
    final SevenSegment 
    
    w.addWindowListener(panel);
    
    w.add(panel);
    w.setResizable(true);
    w.setVisible(true);
    panel.initializeSegments();
    panel.startCounting();
    w.addComponentListener(new ComponentAdapter() {
		public void componentResized(ComponentEvent arg0) {
			panel.initializeSegments();
		}});
  }
  
	
}
