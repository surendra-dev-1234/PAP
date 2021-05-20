package com.Service.Goals.Users.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Service.Goals.Users.Entity.GoalDescription;

@Repository
public interface GoalDescriptionRepository extends JpaRepository<GoalDescription, Long> {

}
