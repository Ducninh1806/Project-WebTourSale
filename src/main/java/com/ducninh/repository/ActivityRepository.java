package com.ducninh.repository;

import com.ducninh.model.Activity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ActivityRepository extends PagingAndSortingRepository<Activity, Long> {
}
