package com.Service.Goals.Users.Controller;

import Services.EmailNotificationService;

public class Test {

	public static void main(String args[]) {
		try {
			EmailNotificationService emailnotificationservie=new EmailNotificationService();
			emailnotificationservie.SendAddMISUserNotification("monikaj@quantira.com","monika jain");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
