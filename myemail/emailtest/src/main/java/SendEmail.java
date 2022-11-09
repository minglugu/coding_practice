import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * 重新构造一个SendEmail class,将不确定的参数(emailFrom, emailTo, subject, message) 放在这个类里
 */

public class SendEmail {

    public void sendEmail(String emailFrom, String emailTo, String subject, String message) {
        SimpleEmail email = new SimpleEmail();
        // qq mail server's port number is 456
        email.setSslSmtpPort("465");
        // set host name
        email.setHostName("smtp.qq.com");
        // set authentication. qq email and "授权码" of SMTP. Sender's email and pwd
        email.setAuthentication(emailFrom, "gbpqohffqrjxgahi");
        // set character
        email.setCharset("uft8");

        // extended function: sending group emails:
        // 1. save all email addresses in a file, 1 email add per line
        // 2. save it in one kind of datatype, e.g. ArrayList
        // 3. String email = access an email address from ArrayList using for-loop.
        // 3. pass it to email.addTo()时

        // 查看simple email源代码，看是否有发送文件的功能，再次拓展这个群发email的功能

        try{
            // receiver's email address
            // email.addTo(email);
            email.addTo(emailTo);
            // sender's email address
            email.setFrom(emailFrom);
            email.setSubject(subject);
            email.setMsg(message);
            email.send();
        } catch(EmailException e) {
            e.printStackTrace();
        }
    }
}
