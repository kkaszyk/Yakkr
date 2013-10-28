import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

class yakkrguiLayout implements LayoutManager {

	public yakkrguiLayout() {
	}

	public void addLayoutComponent(String name, Component comp) {
	}

	public void removeLayoutComponent(Component comp) {
	}

	public Dimension preferredLayoutSize(Container parent) {
		Dimension dim = new Dimension(0, 0);

		Insets insets = parent.getInsets();
		dim.width = 340 + insets.left + insets.right;
		dim.height = 510 + insets.top + insets.bottom;

		return dim;
	}

	public Dimension minimumLayoutSize(Container parent) {
		Dimension dim = new Dimension(0, 0);
		return dim;
	}

	public void layoutContainer(Container parent) {
		Insets insets = parent.getInsets();

		Component c;
		c = parent.getComponent(0);
		if (c.isVisible()) {
			c.setBounds(insets.left + 20, insets.top + 316, 300, 136);
		}
		c = parent.getComponent(1);
		if (c.isVisible()) {
			c.setBounds(insets.left + 65, insets.top + 452, 255, 24);
		}
		c = parent.getComponent(2);
		if (c.isVisible()) {
			c.setBounds(insets.left + 20, insets.top + 480, 300, 24);
		}
		c = parent.getComponent(3);
		if (c.isVisible()) {
			c.setBounds(insets.left + 20, insets.top + 6, 300, 300);
		}

		c = parent.getComponent(4);
		if (c.isVisible())
		{c.setBounds(insets.left+20,insets.top+452,60,24);}
	}
}


