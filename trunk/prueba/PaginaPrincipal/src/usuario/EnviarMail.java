package usuario;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EnviarMail {
	private String correo;
	private String nick;
	private String nombre;
	private String pass;
	private String asunto;

	public static void Email(String correo, String asunto, String nombre, String nick, String pass) {
		try {
			// Propiedades de la conexión
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.user", "greedtreasure@gmail.com");
			props.setProperty("mail.smtp.auth", "true");

			// Preparamos la sesion
			Session session = Session.getDefaultInstance(props);

			// Construimos el mensaje
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("greed Treasure <greedtreasure@gmail.com>"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					" "+correo));
			message.setSubject(" "+asunto);
			message.setText("Hola "+nombre+ ", tus datos de conexión son:\n"+"\nNick/Apodo: "+nick+"\nContraseña: "+pass);

			// Lo enviamos.
			Transport t = session.getTransport("smtp");
			t.connect("greedtreasure@gmail.com", "xyz3zsw9");
			t.sendMessage(message, message.getAllRecipients());

			// Cierre.
			t.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
