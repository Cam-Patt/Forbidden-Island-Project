import java.awt.image.*;
public class specialActionCardObject extends treasureCardObject{
	private String type;
	public specialActionCardObject(BufferedImage i, String t, String type) {
		super(i,t);
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public boolean isShoreUP() {
		if(type.equals("shoreUp")) {
			return true;
		}else {
			return false;
		}
	}
	public boolean isHelicopter() {
		if(type.equals("helicoper")) {
			return true;
		}else {
			return false;
		}
	}
}
