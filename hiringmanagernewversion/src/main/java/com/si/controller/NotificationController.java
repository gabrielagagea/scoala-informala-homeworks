package com.si.controller;

import com.si.model.Notification;
import com.si.model.NotificationStatus;
import com.si.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationRepository notificationRepository;

    public NotificationController() {
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public String getNotifications(Model model, HttpServletRequest request) {
        //get all notifications from DB
        List<Notification> notifications = (List<Notification>) notificationRepository.findAll();
        model.addAttribute("notifications", notifications);
        return "notifications";
    }

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST
    )
    public String createNotification(HttpServletRequest request) {
        //create and save the notification in DB
        Notification notification = new Notification(
                request.getParameter("emailAddress"),
                request.getParameter("subject"),
                request.getParameter("message"),
                NotificationStatus.NEW.name());
        notificationRepository.save(notification);
        System.out.println("Created notification: " + notification);
        return "home";
    }
    @RequestMapping(
            value = "/create",
            method = RequestMethod.GET
    )
    public String getNotification(Model model, HttpServletRequest request) {
        System.out.println("Get notification");
        return "notification";
    }
}
