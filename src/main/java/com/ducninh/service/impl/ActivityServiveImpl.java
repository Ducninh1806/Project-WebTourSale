package com.ducninh.service.impl;

import com.ducninh.model.Activity;
import com.ducninh.repository.ActivityRepository;
import com.ducninh.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;

public class ActivityServiveImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Iterable<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    public Activity findById(Long id) {
        return activityRepository.findOne(id);
    }

    @Override
    public void save(Activity activity) {
        activityRepository.save(activity);
    }

    @Override
    public void remove(Long id) {
        activityRepository.delete(id);
    }
}
