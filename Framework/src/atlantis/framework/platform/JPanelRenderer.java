package atlantis.framework.platform;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import atlantis.framework.IDrawable;

public class JPanelRenderer extends JPanel {
	private static final long serialVersionUID = 9202978237731998998L;
	protected Color clearColor;
	private ArrayList<IDrawable> drawableCollection;
	
	public JPanelRenderer() {
		this.clearColor = Color.black;
		this.setDoubleBuffered(true);
		this.drawableCollection = new ArrayList<IDrawable>();
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		// Clear the screen
		graphics.setColor(clearColor);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		
		// Draw all drawable objects
		for (IDrawable drawable : this.drawableCollection) {
			drawable.draw(graphics);
		}
	}
	
	public void addDrawable(IDrawable drawable) {
		this.drawableCollection.add(drawable);
	}
	
	public void removeDrawable(IDrawable drawable) {
		this.drawableCollection.remove(drawable);
	}
	
	public IDrawable getDrawable(int position) {
		return this.drawableCollection.get(position);
	}
}