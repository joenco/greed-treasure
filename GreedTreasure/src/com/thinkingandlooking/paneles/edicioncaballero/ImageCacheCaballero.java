package com.thinkingandlooking.paneles.edicioncaballero;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import com.thinkingandlooking.database.SessionHibernate;
import com.thinkingandlooking.database.Usuario;

public class ImageCacheCaballero {

	private static ImageCacheCaballero instance;

	private Map<String, BufferedImage> BufferedImageMap = new HashMap<String, BufferedImage>();

	// ----------------------------------------

	private  ImageCacheCaballero() {
		// Empty
	}

	// ----------------------------------------

	public synchronized static ImageCacheCaballero getInstance() {
		if (instance == null) {
			instance = new ImageCacheCaballero();
		}

		return instance;
	}

	// ----------------------------------------

	public BufferedImage getBufferedImage(String login)throws IOException  {

		if(login.isEmpty())
			return null;
		
		Session session = null;
		session = SessionHibernate.getInstance().openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Usuario.class).add(
				Restrictions.eq("login", login));
		Usuario usuario = (Usuario) criteria.uniqueResult();
		session.close();

		String key = BufferedImage.class.getName() + ":" +usuario.getCaballero().getModeloCaballeroRef().getNombreModelo();

		BufferedImage ret = BufferedImageMap.get(key);

		if (ret == null) {


			byte[] imagenByte = usuario.getCaballero().getModeloCaballeroRef().getImgEdicion();
			InputStream in = new ByteArrayInputStream(imagenByte);
			ret = ImageIO.read(in);

			
			BufferedImageMap.put(key, ret);
		}

		return ret;
	}


}


