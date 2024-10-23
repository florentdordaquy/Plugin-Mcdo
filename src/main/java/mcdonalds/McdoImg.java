package mcdonalds;

import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum McdoImg {

    TRANSPARENT(Icons.TRANSPARENT, true),
    LOGO(Icons.LOGO, true),
    BURGER(Icons.BURGER, false),
    PANCARTE(Icons.PANCARTE, false);


    private final ImageIcon icon;
    private final boolean isBackground;

    McdoImg(ImageIcon icon, boolean isBackground) {
        this.icon = icon;
        this.isBackground = isBackground;
    }

    public String getDisplayName() {
        return icon.getDescription();
    }

    public boolean isBackground() {
        return isBackground;
    }

    public ImageIcon getIcon(){
        return icon;
    }

    public static List<McdoImg> getBackgrounds() {
        return Arrays.stream(McdoImg.values())
                .filter(McdoImg::isBackground)
                .collect(Collectors.toList());
    }

    public static List<McdoImg> getCharacters() {
        return Arrays.stream(McdoImg.values())
                .filter(img -> !img.isBackground)
                .collect(Collectors.toList());
    }


    public BufferedImage toBufferedImage() {
        Image img = icon.getImage();

        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }
}
