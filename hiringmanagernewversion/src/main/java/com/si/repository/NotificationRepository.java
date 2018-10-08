package com.si.repository;

import com.si.model.Notification;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository <Notification, String>{
}
