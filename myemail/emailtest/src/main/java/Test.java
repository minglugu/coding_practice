import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/*
 * author: Minglu Gu
 * reference url: 1.   https://www.cnblogs.com/zhaideyou/p/5851219.html
 *                2.   https://blog.csdn.net/littlegoldgold/article/details/124002442
 * description: sending email automatically to ppl on the mailing list
 * extended function: 1. 当用 qq 邮件服务器来自动群发邮件的时候，会有很多限制。
 *                    可以自己写邮件服务器或者第三方的邮件服务器代码。
 *                    2. 将这个功能结合到项目里，如果项目的哪个地方发生错误，可以触发此功能，发邮件提醒，
 *
 */
public class Test {
    public static void main(String[] args) throws EmailException {
        SimpleEmail email = new SimpleEmail();
        // SSL: Secure Sockets Layer; SMTP: Simple Mail Transfer Protocol
        // qq email server's port number is 456. other email server's port will be different.
        // IP address to identify a device on the internet or a local network.
        // Port number is to uniquely identify a connection endpoint and to direct data to a specific service.
        email.setSslSmtpPort("465");
        // set host name
        email.setHostName("smtp.qq.com");
        // set authentication. qq email and "授权码" of SMTP
        email.setAuthentication("1262913815@qq.com", "gbpqohffqrjxgahi");
        // set character
        email.setCharset("uft8");

        // extended function: sending group emails:
        // 1. save all email addresses in a file, 1 email add per line
        // 2. save it in one kind of datatype, e.g. ArrayList
        // 3. String email = access an email address from ArrayList using for-loop.
        // 3. pass it to email.addTo()

        // 查看simple email源代码，看是否有发送文件的功能，再次拓展这个群发email的功能

        try{
            // receiver's email address
            // email.addTo(email);
            email.addTo("1843309310@qq.com");
            // sender's email address
            email.setFrom("1262913815@qq.com");
            email.setSubject("Hi, there!");
            email.setMsg("Coding Genie!");
            email.send();
        } catch(EmailException e) {
            e.printStackTrace();
        }
    }
}
