
public class Demo {
    public static void main(String[] args) {
        SendEmail email = new SendEmail();
        // Method 1. 调用该函数
        // 获取parameter，再传参
        // email.sendEmail(emailFrom, emailTo, subject, message);

        // Method 2. using static method
        // 如果觉得new 一个对象太麻烦，可以把endEmail是在 类里面，变成static，直接用类名来调用
        // SendEmail.sendEmail(emailFrom, emailTo, subject, message);
    }
}
