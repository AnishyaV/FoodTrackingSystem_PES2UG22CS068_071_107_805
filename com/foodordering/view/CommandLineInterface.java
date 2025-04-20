package com.foodordering.view;

import com.foodordering.controller.OrderController;
import java.util.Scanner;

public class CommandLineInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderController controller = new OrderController();
		int q=0;
		while(q==0){
			System.out.println("1. Place Order\n2. Track Order\n3. Complete Delivery\n4. Review Order\n5. Quit");
			int choice = sc.nextInt();		
				switch (choice) {
					case 1:
						System.out.print("Enter User ID, Restaurant ID, and Order Type: ");
						int userId = sc.nextInt();
						int restaurantId = sc.nextInt();
						String type = sc.next();
						controller.placeOrder(userId, restaurantId, type);
						break;
					case 2:
						System.out.print("Enter your User ID: ");
						int trackUserId = sc.nextInt();
						System.out.print("Enter time elapsed since order placed (in minutes): ");
						int elapsedTime = sc.nextInt();
						controller.trackOrder(trackUserId, elapsedTime);
						break;

					case 3:
						System.out.print("Enter Order ID: ");
						int oid = sc.nextInt();
						controller.completeDelivery(oid);  // Calls completeDelivery() to handle input and update DB
						break;

					case 4:       
						System.out.print("Enter Order ID: ");
						int revOrderId = sc.nextInt();
						System.out.print("Enter Your User ID: ");
						int revUserId = sc.nextInt();
						controller.reviewOrder(revOrderId, revUserId);
						break;
					case 5: 
						q=1;
						break;	
				}
		}
			sc.close();
    }
}