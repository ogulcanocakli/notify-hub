package com.notifyhub.domain;

public class SmsNotificationSender implements NotificationSender {

    @Override
    public void send(Notification notification) {
        System.out.println("📱 SMS gönderiliyor: " + notification.getRecipientEmail());
    }

    @Override
    public boolean supports(NotificationType type) {
        return type == NotificationType.SMS;
    }
}
