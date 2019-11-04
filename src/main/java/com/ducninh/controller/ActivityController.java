package com.ducninh.controller;

import com.ducninh.model.Activity;
import com.ducninh.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/activities")
    public ResponseEntity<List<Activity>> findAllActivity(){
        List<Activity> activities = (List<Activity>) activityService.findAll();
        if (activities.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @GetMapping("/activity/{id}")
    public ResponseEntity<Activity> findByIdActivity(@PathVariable("id") Long id  ){
        Activity activity = activityService.findById(id);
        if (activity == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @PostMapping("/activity")
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity){
        activityService.save(activity);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @PutMapping("/activity/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable("id")Long id, @RequestBody Activity activity){
        Activity currentActivity = activityService.findById(id);
        if (currentActivity == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentActivity.setActivity(activity.getActivity());
        activityService.save(currentActivity);
        return new ResponseEntity<>(currentActivity, HttpStatus.OK);
    }

    @DeleteMapping("/activity/{id}")
    public ResponseEntity<Activity> deleteActivity(@PathVariable("id")Long id){
        Activity activity = activityService.findById(id);
            if (activity == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            activityService.remove(id);
            return new ResponseEntity<>(activity, HttpStatus.NO_CONTENT);
    }























}
