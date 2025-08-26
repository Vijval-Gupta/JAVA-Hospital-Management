/*
So the main idea is we will have two modes admin mode and user mode
In admin mode , this mode will be for hospital employees . they can edit the every detail .
In user mode , this mode will be for patients . they can only see and register patient details and book appointments but cannot change any doctor related detail
*/


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------------------------------------");
        System.out.println("-              Welcome to Vijval Hospitals               -");
        System.out.println("----------------------------------------------------------");
        int count=1;
        while(count<=3){
            System.out.print("Enter Password : ");
            int pass=sc.nextInt();
            if (pass==911){
                int patient_counter=0;
                Set<Integer> patient_ids=new HashSet<>();
                ArrayList<Patient> patients=new ArrayList<>();
                ArrayList<Doctor> doctors=new ArrayList<>();
                Set<Integer> doctor_ids=new HashSet<>();

                System.out.println();
                System.out.println();
                System.out.println("Press : ");
                System.out.println("      1 --> User Mode ");
                System.out.println("      2 --> Admin Mode ");
                System.out.println();
                System.out.print("Enter choice : ");
                int mode_choice=sc.nextInt();
                System.out.println();
                if (mode_choice==1) {
                    System.out.println("---- USER MODE ----");
                    System.out.println();
                    boolean isrunning=true;
                    while (isrunning) {
                        System.out.println("Press : ");
                        System.out.println("      1 --> Patient Manager");
                        System.out.println("      2 --> Doctor Viewer ");
                        System.out.println("      3 --> Appointment Related ");
                        System.out.println("      4 --> Bill Receipt ");
                        System.out.println("      5 --> EXIT   ");
                        System.out.println();
                        System.out.print("Enter choice : ");
                        int initial_choice = sc.nextInt();
                        if (initial_choice == 1) {
                            boolean ispatient_manager_running=true;
                            while (ispatient_manager_running) {
                                System.out.println();
                                System.out.println("Press : ");
                                System.out.println("      1 --> Add patient details");
                                System.out.println("      2 --> View patient details");
                                System.out.println("      3 --> Return to Main menu  ");
                                System.out.print("Enter choice : ");
                                int patientmanager_choice = sc.nextInt();
                                if (patientmanager_choice == 1) {
                                    System.out.println();
                                    System.out.println("--- Enter patient details ----");
                                    System.out.print("Enter Full Name : ");
                                    sc.nextLine();
                                    String name =sc.nextLine();
                                    System.out.print("Enter Age : ");
                                    int age = sc.nextInt();
                                    System.out.print("Enter Gender (male/female): ");
                                    String gender = sc.next();
                                    if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")){
                                        ispatient_manager_running=false;
                                        break;
                                    }
                                    System.out.print("Enter mobile number : ");
                                    String mobile = sc.next();
                                    if (!mobile.matches("[0-9]{10}")){
                                        ispatient_manager_running=false;
                                        break;
                                    }
                                    sc.nextLine();
                                    System.out.print("Enter your Issue : ");
                                    String issue=sc.nextLine();
                                    patients.add(new Patient(name , age,gender,mobile,patient_counter ,issue));
                                    patient_ids.add(patient_counter);

                                    System.out.println();
                                    System.out.println("Patient registered successfully ...");
                                    System.out.println("Your ID : "+(patient_counter+1));
                                    patient_counter++;

                                } else if (patientmanager_choice == 2) {
                                    System.out.println("Enter patient ID : ");
                                    int id_request=sc.nextInt();
                                    if (patient_ids.contains(id_request-1)){
                                        patients.get(id_request-1).display();
                                    }
                                    else {
                                        System.out.println();
                                        System.out.println("There is no patient with such id !!!");
                                        System.out.println();
                                    }


                                } else if (patientmanager_choice == 3) {
                                    ispatient_manager_running=false;
                                    break;
                                } else {
                                    System.out.println("Enter Valid choice !!!!");
                                }
                            }

                        }
                        else if (initial_choice ==2) {
                            boolean isdoctor_manager_running=true;
                            while(isdoctor_manager_running){
                                System.out.println();
                                System.out.println("Press : ");
                                System.out.println("      1 --> View all doctors");
                                System.out.println("      2 --> View available doctors");
                                System.out.println("      3 --> Search doctor by Id");
                                System.out.println("      4 --> Return to MAIN MENU");
                                System.out.print("Enter choice : ");
                                int doctormanager=sc.nextInt();
                                if (doctormanager==1){
                                    if (doctors.isEmpty()){
                                        System.out.println();
                                        System.out.println("No Doctors registered !!");
                                        System.out.println();
                                    }
                                    else {
                                        int doc=0;
                                        System.out.println();
                                        System.out.println("---- Doctors Registered ----");
                                        System.out.println();
                                        while(doc<doctors.size()){
                                            doctors.get(doc).display();
                                            doc++;
                                        }
                                    }
                                }
                                else if (doctormanager==2){
                                    int available_flag=0;
                                    int doc=0;
                                    while(doc<doctors.size()){
                                        System.out.println();
                                        System.out.println("---- Doctors Available -----");
                                        System.out.println();
                                        if (doctors.get(doc).is_available=="yes"){
                                            doctors.get(doc).display();
                                            available_flag=1;
                                        }
                                        doc++;
                                    }
                                    if (available_flag==0){
                                        System.out.println();
                                        System.out.println("No Doctors Available !!!");
                                        System.out.println();
                                    }
                                }
                                else if (doctormanager==3){
                                    System.out.println("Enter doctor ID : ");
                                    int doc_id=sc.nextInt();
                                    if (doctor_ids.contains(doc_id)){
                                        System.out.println();
                                        System.out.println("---- Doctor Details ----");
                                        doctors.get(doc_id).display();
                                    }
                                    else {
                                        System.out.println();
                                        System.out.println("No Doctor with this ID ...!");
                                    }
                                }
                                else if (doctormanager==4){
                                    isdoctor_manager_running=false;
                                    break;
                                }
                                else {
                                    System.out.println();
                                    System.out.println("Invalid Choice !!!");
                                    System.out.println();
                                }
                            }
                        }
                        else if (initial_choice ==3) {
                            boolean is_appointing=true;
                            while(is_appointing){
                                System.out.print("Enter Patient ID : ");
                                int pat_id=sc.nextInt();
                                if (!patient_ids.contains(pat_id)){
                                    System.out.println();
                                    System.out.println("No Patient registered with this ID !!");
                                    break;
                                }
                                System.out.println();
                                System.out.println();
                                System.out.println("Press : ");
                                System.out.println("      1 --> Book Appointment ");
                                System.out.println("      2 --> To View Appointment");
                                System.out.println("      3 --> @@@  # currently not available (Edit) ");
                                System.out.println("      4 --> To Cancel Appointment");
                                System.out.println("      5 --> Return to MAIN MENU ");
                                System.out.print("Enter choice : ");
                                int appoint_choice=sc.nextInt();
                                if (appoint_choice==1){
                                    if (!patient_ids.contains(pat_id)){
                                        System.out.println("Patient Not Found !!!");
                                    }
                                    else {
                                        if (patients.get(pat_id).doctorid!=-1){
                                            System.out.println("Patient already has Appointment with a Doctor ");
                                            System.out.println("Cannot Book Another Appointment !!!! ");
                                            System.out.println();
                                        }
                                        else {
                                            System.out.println();
                                            System.out.println("PRESS : ");
                                            System.out.println("       1 --> To assign any doctor available with particular speciality ");
                                            System.out.println("       2 --> To get preferred doctor ");
                                            int spec=sc.nextInt();
                                            if (spec==1){
                                                System.out.println("Enter speciality of which you need a doctor ");
                                                String particular_speciality=sc.next();
                                                int found_flag=0;
                                                int spec_flag=0;
                                                for (int i=0;i<doctors.size();i++){
                                                    if (doctors.get(i).speciality.equals(particular_speciality)){
                                                        if (doctors.get(i).is_available.equals("yes")){
                                                            System.out.println("Appointment Booked Successfully ");
                                                            System.out.println();
                                                            System.out.println("---- Doctor Detail ----");
                                                            doctors.get(i).display();
                                                            found_flag=1;
                                                            break;
                                                        }
                                                        spec_flag=1;
                                                    }
                                                }
                                                if (spec_flag==0){
                                                    System.out.println();
                                                    System.out.println("No Doctor with this speciality is available in our Hospital !!! ");
                                                    System.out.println("Please visit reception for more clarification ...");
                                                    System.out.println();
                                                }
                                                else if (found_flag==0&&spec_flag==1){
                                                    System.out.println("No doctor with this speciality is available !!");
                                                    System.out.println();
                                                }
                                            }
                                            else if (spec==2){
                                                System.out.println();
                                                System.out.println("Enter ID of Doctor : ");
                                                int doc_id =sc.nextInt();
                                                if (!doctor_ids.contains(doc_id-1)){
                                                    System.out.println();
                                                    System.out.println("No Doctor with id - "+doc_id+" registered !!");
                                                    System.out.println();
                                                }
                                                else {
                                                    patients.get(pat_id).doctorid=doc_id-1;
                                                    System.out.println("Appointment Booked Successfully with preferred Doctor ...");
                                                    System.out.println("---- Doctor Details ----");
                                                    doctors.get(doc_id-1).display();
                                                    System.out.println();
                                                }
                                            }
                                            else {
                                                System.out.println();
                                                System.out.println("Invalid Choice !!!");
                                                System.out.println();
                                            }
                                        }
                                    }
                                }
                                else if (appoint_choice==2){
                                    int docid=patients.get(pat_id).doctorid;
                                    if (docid==-1){
                                        System.out.println();
                                        System.out.println("No Appointment Scheduled !!!");
                                    }
                                    else {
                                        doctors.get(docid).display();
                                    }
                                }
                                else if (appoint_choice==4){
                                    patients.get(pat_id).doctorid=-1;
                                    System.out.println();
                                    System.out.println("Appointment Cancelled Successfully ...!");
                                }
                                else if (appoint_choice==5){
                                    is_appointing=false;
                                    break;
                                }
                                else {
                                    System.out.println();
                                    System.out.println("Invalid Choice !!!");
                                    System.out.println();
                                }
                            }

                        }
                        else if (initial_choice ==4) {

                        }
                        else if (initial_choice ==5) {
                            isrunning=false;
                        }
                        else {
                            System.out.println("Enter a Valid choice !!!!");
                        }

                    }
                }
                else if (mode_choice==2){

                }
                else {
                    System.out.println();
                    System.out.println("Invalid Choice !!!");
                    System.out.println();
                }


                break;
            }
            else{
                System.out.println();
                System.out.println("WRONG PASSWORD !!!");
                System.out.println(3-count+" try remaining !!");
                System.out.println();

                count++;
            }
        }
        System.out.println();
        System.out.println("EXITING HOSPITAL MANAGEMENT SYSTEM !!!");
        System.out.println("# Take Care ");




    }
}