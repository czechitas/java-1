package cz.czechitas.angrybirds.engine.util;

import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import cz.czechitas.angrybirds.engine.tiles.*;
import net.sevecek.util.*;

public class GameUtils {

    public static void notifyVisualListener(Runnable notification) {
        SwingUtilities.invokeLater(notification);
    }

    private static Map<String, Icon> spriteCache = new HashMap<>();


    public synchronized static Icon loadSprite(String spriteName) {
        Icon sprite = spriteCache.get(spriteName);
        if (sprite != null) {
            return sprite;
        }

        String spriteFilename = "../../images/" + spriteName;
        try (InputStream stream = GenericTile.class.getResourceAsStream(spriteFilename)) {
            sprite = new ImageIcon(ImageIO.read(stream));
            spriteCache.put(spriteName, sprite);
            return sprite;
        } catch (IOException ex) {
            throw new ApplicationPublicException(ex, "Nepodařilo se nahrát sprite {0}", spriteName);
        }
    }
}
