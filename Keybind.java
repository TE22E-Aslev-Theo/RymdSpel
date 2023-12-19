import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Keybind implements KeyListener{
	public boolean wkey;
	public boolean akey;
	public boolean skey;
	public boolean dkey;
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		char keycode = e.getKeyChar();
		
		if(keycode == 'w') {
			wkey = true;
		}
		if(keycode == 'a') {
			akey = true;
		}
		if(keycode == 's') {
			skey = true;
		}
		if(keycode == 'd') {
			dkey = true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		char keycode = e.getKeyChar();
		
		if(keycode == 'w') {
			wkey = false;
		}
		if(keycode == 'a') {
			akey = false;
		}
		if(keycode == 's') {
			skey = false;
		}
		if(keycode == 'd') {
			dkey = false;
		}
	}
}