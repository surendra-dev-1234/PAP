package com.Service.Goals.Users.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Service.Goals.Users.Entity.Unfreeze;
import com.Service.Goals.Users.Repository.UnfreezeRepository;

@Service
public class UnfreezeService {

	@Autowired
	UnfreezeRepository unfreezerepository;

	public void hrunfreezeuser(int year, int quarter_id, int user_id, String unfreezefor, int unfreezedays, String unfreezedata, int unfreezeby) {
		Unfreeze unfreeze= new Unfreeze();
		unfreeze.setYear(year);
		unfreeze.setQuarter_id(quarter_id);
		unfreeze.setUser_id(user_id);
		unfreeze.setUnfreezefor(unfreezefor);
		unfreeze.setUnfreezedays(unfreezedays);
		unfreeze.setUnfreezedata(unfreezedata);
		unfreeze.setUnfreezeby(unfreezeby);
		LocalDate date = LocalDate.now();   
		LocalDate tomorrow = date.plusDays(unfreeze.getUnfreezedays());  
		unfreeze.setUnfreezedate(date.toString());
		unfreeze.setFreezedate(tomorrow.toString());
		System.out.println("Today date: "+date);  
		System.out.println("Tommorow date: "+tomorrow);  
		unfreeze.setFlag(1);
		unfreezerepository.save(unfreeze);
	}
}
