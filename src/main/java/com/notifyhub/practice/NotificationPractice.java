package com.notifyhub.practice;

import com.notifyhub.domain.Notification;
import com.notifyhub.domain.NotificationType;

import java.util.*;
import java.util.stream.Collectors;

public class NotificationPractice {
    public static void main(String[] args) {

        // Test verisi oluştur
        List<Notification> notifications = Arrays.asList(
                Notification.builder().id(1L).title("Sipariş Onayı").type(NotificationType.EMAIL).sent(true).recipientEmail("ali@test.com").build(),
                Notification.builder().id(2L).title("Kargo Bildirimi").type(NotificationType.SMS).sent(false).recipientEmail("veli@test.com").build(),
                Notification.builder().id(3L).title("İndirim Fırsatı").type(NotificationType.EMAIL).sent(false).recipientEmail("ali@test.com").build(),
                Notification.builder().id(4L).title("Ödeme Alındı").type(NotificationType.PUSH).sent(true).recipientEmail("ahmet@test.com").build()
        );

        // GÖREV 1: Sadece gönderilmemiş bildirimleri listele
        System.out.println("=== Gönderilmemiş Bildirimler ===");
        notifications.stream()
                .filter(n -> !n.isSent())
                .forEach(n -> System.out.println("- " + n.getTitle()));

        // GÖREV 2: Tip bazında grupla ve kaç tane olduğunu yazdır
        System.out.println("\n=== Tip Bazında Sayım ===");
        notifications.stream()
                .collect(Collectors.groupingBy(Notification::getType, Collectors.counting()))
                .forEach((type, count) -> System.out.println(type + ": " + count));

        // GÖREV 3: ali@test.com'a ait bildirimlerin başlıklarını listele
        System.out.println("\n=== Ali'nin Bildirimleri ===");
        notifications.stream()
                .filter(n -> "ali@test.com".equals(n.getRecipientEmail()))
                .map(Notification::getTitle)
                .forEach(System.out::println);

        // GÖREV 4: Kaç tanesi gönderildi?
        long sentCount = notifications.stream().filter(Notification::isSent).count();
        System.out.println("\nGönderilen: " + sentCount + "/" + notifications.size());
    }
}
