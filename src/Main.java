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
        int count=0;
        while(count<3){
            System.out.print("Enter Password : ");
            int pass=sc.nextInt();
            if (pass==911){
                int patient_counter=0;
                Set<Integer> patient_ids=new HashSet<>();
                ArrayList<patient> patients=new ArrayList<>();
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
                                    patients.add(new patient(name , age,gender,mobile,patient_counter ,issue));
                                    patient_ids.add(patient_counter);
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

                        }
                        else if (initial_choice ==3) {

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