package com.notifyhub.domain;

// Interface'i implement ediyoruz
public class EmailNotificationSender implements NotificationSender {

    @Override
    public void send(Notification notification) {
        // Gerçek implementasyonda burada SMTP/SES olur
        System.out.println("📧 Email gönderiliyor: " + notification.getRecipientEmail());
        System.out.println("   Konu: " + notification.getTitle());
    }

    @Override
    public boolean supports(NotificationType type) {
        return type == NotificationType.EMAIL;  // Sadece EMAIL destekliyor
    }
}