/*
*@file_Name: ClinicManagementProgram.java
*@Author: Shwetali
*@Date: 07-09-2016
*@purpose:  Clinic Management program for Patients and Doctors.
*/

package com.bridgelabz.clinic;
import com.bridgelabz.clinic.Doctor;
import com.bridgelabz.clinic.Patient;
import com.bridgelabz.clinic.UnOrderedNodeCreation;
import com.bridgelabz.clinic.ArrangeAppointment;
import java.util.ArrayList;
import java.util.Scanner;

public class ClinicManagementProgram{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int patientId = 1;
		ArrangeAppointment appointment = new ArrangeAppointment();

		ArrayList<Doctor> doctors = new ArrayList();
		ArrayList<Patient> patients = new ArrayList();

		//Creating doctors
		Doctor doctor1 = new Doctor("Dr. Joshi",1,"Heart","Morning");
		Doctor doctor2 = new Doctor("Dr. Patel",2,"Eyes","Morning");
		Doctor doctor3 = new Doctor("Dr. Naved",3,"Brain","Evening");
		Doctor doctor4 = new Doctor("Dr. Desai",4,"General","Morning/Evening");
		Doctor doctor5 = new Doctor("Dr. Jeet",5,"Skin","Evening");

		//Adding Doctors in ArrayList
		doctors.add(doctor1);
		doctors.add(doctor2);
		doctors.add(doctor3);
		doctors.add(doctor4);
		doctors.add(doctor5);

		//Adding patients and taking appointments
		Patient patient1 = new Patient("Mr. Patil",patientId,"9087645342",30);
		patients.add(patient1);
		appointment.takeAppoinment(patient1,1);
		patientId++;
		Patient patient2 = new Patient("Ms. Sandhya",patientId,"8456985426",20);
		patients.add(patient2);
		appointment.takeAppoinment(patient2,1);
		patientId++;
		Patient patient3 = new Patient("Mrs. Yadav",patientId,"7545865412",33);
		patients.add(patient3);
		appointment.takeAppoinment(patient3,5);


		//Display Options to perform operations.
		boolean check = true;
		while(check){
			System.out.println("\n\nWelcome, Please choose Your Option");
			System.out.println("1.Doctors List\n2.Patients List\n3.Search Doctor\n4.Search Patient");
			System.out.println("5.Take Appoinment\n6.Show All Appointments\n7.Popular Doctor \n8.Exit");
			int choice = sc.nextInt();			
			switch(choice){
				case 1:{
					System.out.println("List Of Available Doctors:");
					new Doctor().listOfDoctors(doctors);
					break;
				}
				case 2:{
					System.out.println("List of Patients in Clinic:");
					new Patient().listOfPatients(patients);
					break;
				}
				
				case 3:{
					System.out.println("Search Doctor By:");
					new Doctor().searchDoctor(doctors);
					break;
				}
				case 4:{
					System.out.println("Search Patient By:");
					new Patient().searchPatient(patients);
					break;
				}
				case 5:{
					//taking patient's info and appointment
					patientId++;
					boolean checkId = true;
					System.out.print("Please Enter Patient's Name: ");
					String name = sc.next();
					System.out.print("Please Enter Phone number: ");
					String number = sc.next();
					System.out.print("Please Enter Age: ");
					int age = sc.nextInt();

					Patient newPatient = new Patient(name,patientId,number,age);
					patients.add(newPatient);

					System.out.print("Please enter Doctors id: ");
					int docId = sc.nextInt();
					appointment.takeAppoinment(newPatient,docId);
					break;
				}
				case 6:{
					appointment.showAppointments();
					break;
				}
		
				case 7:{
					new Doctor().popularDoctor(doctors);
					break;
				}
				case 8:{
					check = false;
					break;
				}
				default:{
					System.out.println("Wrong Choice!!");
					break;
				}
			}//end of switch
		}//end of while
		
	}
}