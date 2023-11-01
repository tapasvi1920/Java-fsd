package CameraRentalApplication;
import java.lang.String;
import java.util.ArrayList;
import java.util.Scanner;
public class CameraRentalApplication {
	static Scanner sc=new Scanner(System.in);
	static double money=1000;
	static int cam_id;
	static ArrayList<CameraRentalApplication > list=new ArrayList<>();
	int camera_id;
	String brand;
	String model;
	double price;
	String status;
	public CameraRentalApplication (int camera_id, String brand, String model, double price, String status) {
		super();
		this.camera_id = camera_id;
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.status = status;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list.add(new CameraRentalApplication(1,"Samsung","Ds123",500,"Available"));
		cam_id++;
		list.add(new CameraRentalApplication(2,"Sony","HD214",500,"Available"));
		cam_id++;
		list.add(new CameraRentalApplication(3,"Panasonic","XC",500,"Available"));
		cam_id++;
		list.add(new CameraRentalApplication(4,"Canon","XLR",500,"Available"));
		cam_id++;
		list.add(new CameraRentalApplication(5,"Fujitsu","J5",500,"Available"));
		cam_id++;
		list.add(new CameraRentalApplication(6,"LG","L123",500,"Available"));
		cam_id++;
		System.out.println("+**************************************+");
		System.out.println("| WELCOME TO CAMERA RENTAL APPLICATION |"); 
		System.out.println("+**************************************+");
		System.out.println("PLEASE LOGIN TO CONTINUE ");
		System.out.print("Enter USERNAME: "); 
		String username=sc.next();
		System.out.print("Enter PASSWORD: ");
		String password=sc.next();
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin123")){
			options();
		}
		else {
			System.out.println("Invalid Credentials");
		}
	}

private static void options(){
	System.out.println("Choose an option:");
	System.out.println("1.MY CAMERA\n"
			+ "2.RENT A CAMERA\n"
			+ "3.VIEW ALL CAMERA\n"
			+ "4.MY WALLET\n"
			+ "5.EXIT");
	int option=sc.nextInt();
switch(option) {
case 1:
	mycamera();
	break;
case 2: 
	System.out.println("FOLLOWING IS THE AVAILABLE LIST OF CAMERA(S) - ");
	System.out.printf("%-12s%-15s%-10s%-10s%5s\n","CAMERA ID","BRAND","MODEL","PRICE","STATUS");
	for(int i=0;i<list.size();i++) {
		CameraRentalApplication c=list.get(i);
		if(c.status=="Available") {
		System.out.printf("%-12d%-15s%-10s%-10s%5s\n",list.get(i).camera_id,list.get(i).brand,list.get(i).model,list.get(i).price,
				list.get(i).status);
	}
	}
	System.out.print("ENTER THE CAMERA ID YOU WANT TO RENT - ");
	int id=sc.nextInt();
	for(int i=0;i<list.size();i++) {
		if(list.get(i).camera_id==id) {
		if(list.get(i).status.contains("Available")) {
		if(money>=(list.get(i).price)) {
			money=money-(list.get(i).price);
			System.out.println("YOUR TRANSACTION FOR CAMERA - "+list.get(i).brand+" with rent INR."+list.get(i).price+" HAS SUCCESSFULLY COMPLETED\n");
			list.get(i).status="RENTED";
			options();
		}
		else {
			System.out.println("TRANSACTION FAILED DUE TO INSUFFICIENT WALLET BALANCE.PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET\n");
			options();
		}
	}
	else {
		System.out.println("RENTAL CAMERA IS NOT AVAILABLE\n");
		options();
	}
	}
	}
	System.out.println("INVALID CAMERA ID...");
	options();
	break;
case 3:
	displaycamera();
	options();
	break;
case 4:
	System.out.println("YOUR CURRENT WALLET BALANCE IS - INR."+money);
	System.out.println("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET?(1.YES 2.NO)");
	int dep=sc.nextInt();
	if(dep==1) {
		System.out.print("Enter THE AMOUNT (INR) - ");
		double addmoney=sc.nextDouble();
		System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY.CURRENT WALLET BALANCE - INR.\n"+(money+addmoney));
	}
	options();
	break;
case 5:
	System.out.println("Thank you. Please visit again");
	break;
default:
	System.out.println("invaild option \npls try again");
}
}	
private static void mycamera() {
	System.out.println("1.ADD\n"
			+ "2.REMOVE\n"
			+ "3.VIEW MY CAMERAS\n"
			+ "4.GO TO PREVIOUS MENU");
	int opt1=sc.nextInt();
	switch(opt1) {
	case 1:
		System.out.println("ENTER THE CAMERA ID - ");
		int camera_id=sc.nextInt();
		System.out.println("ENTER THE CAMERA BRAND - ");
		String brand=sc.next();
		System.out.println("ENTER THE MODEL - ");
		String model=sc.next();
		System.out.println("ENTER THE PER DAY PRICE - ");
		double price=sc.nextInt();
		String status="Available";
		list.add(new CameraRentalApplication(++cam_id,brand,model,price,status));
		System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST\n");
		mycamera();
		break;
	case 2:
		displaycamera();
		System.out.print("ENTER THE CAMERA ID TO REMOVE - ");
		int id=sc.nextInt();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).camera_id==id) {
				list.remove(i);
				System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST\n");
				mycamera();
			}
		}
		System.out.println("INVALID CAMERA ID");
		mycamera();
		break;
	case 3:
		displaycamera();
		mycamera();
		break;
	case 4:
		options();
		break;
	default: 
		System.out.println("invaild option\npls try again");
		mycamera();
}
}


 private static void displaycamera() {
	System.out.printf("%-12s%-15s%-10s%-10s%5s\n","CAMERA ID","BRAND","MODEL","PRICE","STATUS");
	for(int i=0;i<list.size();i++) {
		System.out.printf("%-12d%-15s%-10s%-10s%5s\n",list.get(i).camera_id,list.get(i).brand,list.get(i).model,list.get(i).price,
				list.get(i).status);
	}
	System.out.println();
}


}

