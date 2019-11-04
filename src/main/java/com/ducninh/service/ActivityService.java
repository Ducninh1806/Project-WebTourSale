package com.ducninh.service;

import com.ducninh.model.Activity;

public interface ActivityService {
    Iterable<Activity> findAll();

    Activity findById(Long id);

    void save (Activity activity);

    void remove(Long id);
}
