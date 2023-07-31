package com.cybertrend.registrasi.serviceimpl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cybertrend.registrasi.model.User;

@Service
public class EmailServiceImpl{
    @Autowired 
    private JavaMailSender javaMailSender;
 
    @Value("${spring.mail.username}") 
    private String sender;
 
    // Method 1
    // To send a simple email
    public String sendSimpleMail(User user)
    {
        String text = "<b>Halo pelanggan</b>, <br><br>"
            +"<b>Berikut kami sampaikan detail informasi terkait akun anda</b> <br>"
            +"<b>Nama          : [[nama]] </b> <br>"
            +"<b>Nomor Telpon  : [[telp]] </b> <br>"
            +"<b>Alamat Email  : [[email]] </b> <br>"
            +"<b>Status        : Aktif </b> <br>"
            +"<b>Demikian informasi yang kami sampaikan, </b> <br>"
            +"<b>Terima kasih, </b> <br><br>"
            +"<b>Regards, </b> <br>"
            +"<b>Cybertrend Indonesia </b>";
 
        // Try block to check for exceptions
        try {
 
            // Creating a simple mail message
            MimeMessage message = javaMailSender.createMimeMessage();
		    MimeMessageHelper helper = new MimeMessageHelper(message);
 
            // Setting up necessary details
            helper.setFrom(sender);
            helper.setTo(user.getEmail());
            text = text.replace("[[nama]]", user.getNama()).replace("[[telp]]", user.getTelp()).replace("[[email]]", user.getEmail());
            helper.setText(text,true);
            helper.setSubject("Pemberitahuan Aktivasi Akun");
 
            // Sending the mail
            javaMailSender.send(message);
            return "Mail Sent Successfully...";
        }
        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
 
    
}
