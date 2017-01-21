package entities;
/* ##############Purpose####################
 * This is the interface that the enemy entities use
 * This is created for both the enemy and player to detect each other
 */
import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface EntityE {
	/*####################Description##########################
	 * This interface is made so that all the classes that implements this
	 * will be mandatory  to have these methods
	 * This interface is also created to distinguish the player and enemy entities
	 */
	/* All classes that implements this interface will be required to have
	 * the update() method, the draw(graphics2D) method, the rectangle outline
	 * method, and lastly the getting x and y methods
	 */
	public void update();
	public void draw(Graphics2D g2d);
	public Rectangle getOutline();
	
	public double getx();
	public double gety();
}
