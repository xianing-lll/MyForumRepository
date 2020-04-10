package cn.itcast.myforum.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public void sendMail(String myMail, String mailContent) {
		// �ռ��˵�������
	      String to = myMail;
	 
	      // �����˵�������
	      String from = "1941512303@qq.com";
	 
	      // ָ�������ʼ�������Ϊ smtp.qq.com
	      String host = "smtp.qq.com";  //QQ �ʼ�������
	 
	      // ��ȡϵͳ����
	      Properties properties = System.getProperties();
	 
	      // �����ʼ�������
	      properties.setProperty("mail.smtp.host", host);
	 
	      properties.put("mail.smtp.auth", "true");
	      // ��ȡĬ��session����
	      Session session = Session.getDefaultInstance(properties,new Authenticator(){
	        public PasswordAuthentication getPasswordAuthentication()
	        {
	         return new PasswordAuthentication("1941512303@qq.com", "ujayphzjsfzdibci"); //�������ʼ��û�������Ȩ��
	        }
	       });
	 
	      try{
	         // ����Ĭ�ϵ� MimeMessage ����
	         MimeMessage message = new MimeMessage(session);
	 
	         // Set From: ͷ��ͷ�ֶ�
	         message.setFrom(new InternetAddress(from));
	 
	         // Set To: ͷ��ͷ�ֶ�
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));
	 
	         // Set Subject: ͷ��ͷ�ֶ�
	         message.setSubject("��֤��");
	 
	         // ������Ϣ��
	         message.setText("������֤��Ϊ "+mailContent+" ,�뾡��������֤�룬�����������֤�뽲���ڣ�");
	 
	         // ������Ϣ
	         Transport.send(message);
	   
	      }catch (MessagingException mex) {
	    	  System.out.println("�ʼ�����ʧ�ܣ�");
	          mex.printStackTrace();
	      }
	}
}
