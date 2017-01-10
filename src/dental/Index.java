
package dental;
import database.*;
//import java.util.ArrayList;
import java.util.*;
public class Index extends patientdata{

	

	Index(String n, int a, char g) {
		super(n, a, g);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		database.login dummyobj = new database.login();
		int discount = 0;
		String uname;

		Scanner input= new Scanner(System.in);
		System.out.println("Please enter your login details");
		while(true)
		{
			System.out.println("Username: ");
			uname=input.next();
			System.out.println("Password: ");
			String passwd=input.next();
			//System.out.println(database.login.username[0]);
			int a=database.login.username.indexOf(uname);
			//System.out.println("come here");
			try
			{
		 if( Objects.equals(passwd, database.login.password.get(a)))
		 {
			 break;
			 
		 
		 }
			}
			catch (ArrayIndexOutOfBoundsException e)
			{}
			 System.out.println("inncorrect \n please enter proper details");
		 }
		
		System.out.println("--------------------------\n WELCOME "+uname+"\n patient registration\n");
		System.out.println("name:");
		String pname=input.next();
		System.out.println("age:");
		int page=input.nextInt();
		System.out.println("gender(M/F):");
		char pgender=input.next().charAt(0);
		patientdata patient=new patientdata(pname,page,pgender);
		//Runtime.getRuntime().exec("cls");
		//System.out.println("please select the treatment from the list\n NOTE:discount is automatically applied if eligible ");
		//System.out.println("	Name									price\n1.Treatment Price Exam and Evaluation:	177\n2.White composite Filling front:	285\n3.Root Canal Therapy from:		1575\n4.Regular extractions:			420\n5.Root/surgical extractions:		435\n6.Regular Cleaning:			600\n7.Dental Implant Placement		1800");
		for (int i=0;i < treatments.treatcost.length;i++)
		{
			System.out.println(i+1+"\t"+treatments.treatname[i]+"\t"+treatments.treatcost[i]);
		}
		System.out.println("*NOTE: use coma for sellecting multiple treatments");
		int treatin;
		int tlist[]=new int[100];
		int k=0;
		while((treatin=input.nextInt())<=(treatments.treatcost.length))
		{
			tlist[k++]=treatin;
		}
		
		//int i=0;
		//int m=0;
		//for (char ch: treatin.toCharArray()) {
		//		if(Character.isDigit(ch))
		//{
		//	tlist[m++]=ch;
		System.out.println(tlist);
		
		//}
		//}
		
		// bill generation
	System.out.println("---------THE BILL----------");
	System.out.println("patient's details");
	System.out.println("name:\t"+patient.name+"\nage:\t"+patient.age+"\ngender:\t"+patient.gender);
	System.out.println("----------------------------");
	int total=0;
	for (int j=0;j< k;j++)
	{
		System.out.println(j+1+"\t"+treatments.treatname[j]+"\t"+treatments.treatcost[j]);
		total=total+treatments.treatcost[j];
		
	}
	
	System.out.println("\tSubtotal\t\t\t"+total);
	if(tlist.length>2)
	{
		discount=10;
	}
	if(total>5000)
	{
		discount=15;
	}
	int discamt=(total/100)*discount;
	System.out.println("\tdiscount on sub total is "+discount+"%....."+discamt);
	total=total-discamt;
	System.out.println("\ttotal amount payable....."+total);
	System.out.println("-----------END-----------");
		}

	
	}


