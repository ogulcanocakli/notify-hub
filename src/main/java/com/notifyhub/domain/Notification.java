package com.notifyhub.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Data = @Getter + @Setter + @ToString + @EqualsAndHashCode
// @Builder = Builder pattern (Notification.builder().title("...").build())
// @NoArgsConstructor = boş constructor
// @AllArgsConstructor = tüm alanları alan constructor
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private Long id;
    private String title;
    private String message;
    private NotificationType type;
    private String recipientEmail;
    private boolean sent;
}
