package atlantis.engine.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import atlantis.framework.GameTime;
import atlantis.framework.IDrawable;
import atlantis.framework.IUpdateable;
import atlantis.framework.Rectangle;
import atlantis.framework.Vector2;
import atlantis.framework.content.ContentManager;
import atlantis.framework.graphics.Texture2D;

/**
 * Define a basic entity who is updated and drawn on each frame
 * @author Yannick
 */
public class Entity implements IUpdateable, IDrawable {
	protected boolean enabled;
	protected boolean visible;
	protected Rectangle rectangle;
	protected Vector2 position;
	protected Texture2D texture;
	protected String textureName;
	protected boolean initialized;
	protected boolean assetLoaded;
	protected String name;
	private static int entityCounter = 0;
	
	public Entity() {
		this.enabled = true;
		this.visible = true;
		this.rectangle = new Rectangle();
		this.position = new Vector2();
		this.initialized = false;
		this.assetLoaded = false;
		this.texture = null;
		this.textureName = "";
		this.name = "Entity_" + entityCounter++;
	}
	
	public Entity(String textureName) {
		this();
		this.textureName = textureName;
	}
	
	public void initialize() {
		this.initialized = true;
	}
	
	public void loadContent(ContentManager content) {
		if (this.textureName != "" && this.assetLoaded == false) {
			this.texture = content.loadImage(this.textureName);
			this.rectangle.setWidth(this.texture.getWidth());
			this.rectangle.setHeight(this.texture.getHeight());
			this.assetLoaded = true;
		}
	}
	
	@Override
	public void draw(Graphics graphics) {
        if (this.visible) {
            graphics.drawImage(this.texture.getTexture(), this.rectangle.getX(), this.rectangle.getY(), this.rectangle.getWidth(), this.rectangle.getHeight(), null);
        }
	}

	@Override
	public void update(GameTime gameTime) {
		// TODO Auto-generated method stub
		
	}
	
	public void setPosition(int x, int y) {
		this.position.setX(x);
		this.position.setY(y);
		this.rectangle.setX(x);
		this.rectangle.setY(y);
	}
	
	public void setSize(int width, int height) {
		this.rectangle.setWidth(width);
		this.rectangle.setHeight(height);
	}
	
	public void setX(int x) {
		this.position.setX(x);
		this.rectangle.setX(x);
	}
	
	public void setY(int y) {
		this.position.setY(y);
		this.rectangle.setY(y);
	}
	
	public void setWidth(int width) {
		this.rectangle.setWidth(width);
	}
	
	public void setHeight(int height) {
		this.rectangle.setHeight(height);
	}

	public int getX() {
		return this.rectangle.getX();
	}
	
	public int getY() {
		return this.rectangle.getY();
	}
	
	public int getWidth() {
		return this.rectangle.getWidth();
	}
	
	public int getHeight() {
		return this.rectangle.getHeight();
	}
}