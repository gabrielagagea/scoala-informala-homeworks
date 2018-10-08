package com.si.config;


import com.si.email.EmailSender;
import com.si.model.Notification;
import com.si.model.NotificationStatus;
import com.si.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Configuration
public class NotificationsProcessor {
    //create a listener that look in DB every 5 seconds and pick all new notifications and answer
    @Autowired
    EmailSender emailSender;

    @Autowired
    NotificationRepository notificationRepository;

    @Bean
    public QueuedEmailsDelivery queuedEmailsDelivery(
            final @Value("${notifications.processor.delay}") Integer delay
    ) {
        return new QueuedEmailsDelivery(delay);
    }

    final class QueuedEmailsDelivery {
        private final Integer delay;

        private QueuedEmailsDelivery(
                final Integer delay
        ) {
            this.delay = delay;
        }

        @EventListener({ContextRefreshedEvent.class})
        public void start() {
            Executors.newScheduledThreadPool(1, Thread::new)
                    .scheduleWithFixedDelay(notifier(), 0, delay, TimeUnit.SECONDS);
        }
    }

    private Runnable notifier() {
        return new Runnable() {

            @Override
            public void run() {
                System.out.println("========== update notifications");
                Iterable<Notification> notifications = notificationRepository.findAll();
                for (Notification notification : notifications) {
                    if (NotificationStatus.NEW.name().equals(notification.getStatus())) {
                        try {
                            emailSender.sendEmail("Company", notification.getEmail(), "Re:", "Thank you for your message. We will analyze your request and we will send you a response accordingly.\n Best regards!\n Company \n\n" + notification.getMessage());
                            System.out.println("Email sent: " + notification.getEmail());
                            notification.setStatus(NotificationStatus.ANSWERED.name());
                            notificationRepository.save(notification);
                            System.out.println("Notification answered: " + notification.getEmail());
                        } catch (MessagingException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
    }
}
