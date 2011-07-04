package TablaCaballero;


import java.util.HashMap;
import java.util.Map;

import nextapp.echo.app.ImageReference;
import nextapp.echo.app.ResourceImageReference;

public class ImageReferenceCache2 {

  private static ImageReferenceCache2 instance;

  private Map<String, ImageReference> imageReferenceMap = new HashMap<String, ImageReference>();

  // ----------------------------------------

  private ImageReferenceCache2() {
    // Empty
  }

  // ----------------------------------------

  public synchronized static ImageReferenceCache2 getInstance() {
    if (instance == null) {
      instance = new ImageReferenceCache2();
    }

    return instance;
  }

  // ----------------------------------------

  public ImageReference getImageReference(String name) {
    String key = ImageReference.class.getName() + ":" + name;

    ImageReference ret = imageReferenceMap.get(key);

    if (ret == null) {
      ret = new ResourceImageReference(name);
      imageReferenceMap.put(key, ret);
    }

    return ret;
  }
}

