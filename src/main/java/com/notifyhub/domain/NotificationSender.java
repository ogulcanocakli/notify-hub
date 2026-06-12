package com.notifyhub.domain;

// Interface: "Bu işi yapabilirsin" sözleşmesi
// C#'taki interface ile aynı konsept
public interface NotificationSender {

    // Her implementasyon bu metodu yazmalı
    void send(Notification notification);

    // Default method (Java 8+) — implementasyon zorunlu değil
    default boolean supports(NotificationType type) {
        return false;
    }
}