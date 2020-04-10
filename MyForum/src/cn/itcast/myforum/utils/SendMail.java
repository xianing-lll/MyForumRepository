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
		// 收件人电子邮箱
	      String to = myMail;
	 
	      // 发件人电子邮箱
	      String from = "1941512303@qq.com";
	 
	      // 指定发送邮件的主机为 smtp.qq.com
	      String host = "smtp.qq.com";  //QQ 邮件服务器
	 
	      // 获取系统属性
	      Properties properties = System.getProperties();
	 
	      // 设置邮件服务器
	      properties.setProperty("mail.smtp.host", host);
	 
	      properties.put("mail.smtp.auth", "true");
	      // 获取默认session对象
	      Session session = Session.getDefaultInstance(properties,new Authenticator(){
	        public PasswordAuthentication getPasswordAuthentication()
	        {
	         return new PasswordAuthentication("1941512303@qq.com", "ujayphzjsfzdibci"); //发件人邮件用户名、授权码
	        }
	       });
	 
	      try{
	         // 创建默认的 MimeMessage 对象
	         MimeMessage message = new MimeMessage(session);
	 
	         // Set From: 头部头字段
	         message.setFrom(new InternetAddress(from));
	 
	         // Set To: 头部头字段
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));
	 
	         // Set Subject: 头部头字段
	         message.setSubject("验证码");
	 
	         // 设置消息体
	         message.setText("您的验证码为 "+mailContent+" ,请尽快输入验证码，超过五分钟验证码讲过期！");
	 
	         // 发送消息
	         Transport.send(message);
	   
	      }catch (MessagingException mex) {
	    	  System.out.println("邮件发送失败！");
	          mex.printStackTrace();
	      }
	}
}
