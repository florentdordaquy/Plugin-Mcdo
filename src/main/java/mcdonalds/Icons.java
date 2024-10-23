package mcdonalds;

import javax.swing.ImageIcon;

public interface Icons {

    ImageIcon BURGER = new ImageIcon(Icons.class.getResource("/burger.gif"), "Burger");
    ImageIcon PANCARTE = new ImageIcon(Icons.class.getResource("/pancarte.gif"), "Pancarte");

    ImageIcon TRANSPARENT = new ImageIcon(Icons.class.getResource("/transparent.png"), "Transparent");
    ImageIcon LOGO = new ImageIcon(Icons.class.getResource("/mcdo_logo.png"), "Logo");

}
