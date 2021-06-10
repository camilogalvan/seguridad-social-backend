package ufps.web.professionacare.backend.service;


public interface EmailService {

	public void sendMessageWithAttachment(String asunto, String mensaje, String destino);

	public void sendMessageWithError(Exception error);

	public void sendMessageWithWarning(String warning, Class<?> logger);

}
