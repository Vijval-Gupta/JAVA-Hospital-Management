/*
So the main idea is we will have two modes admin mode and user mode
In admin mode , this mode will be for hospital employees . they can edit the every detail .
In user mode , this mode will be for patients . they can only see and register patient details and book appointments but cannot change any doctor related detail
*/


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

///  break ki jagah continue use karke dekho



public class Main {


    static boolean contact_checker(String contact){
        if (!contact.matches("[0-9]{10}")){
            return false;
        }
        return true;
    }

    static boolean gender_check(String gender){
        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")){
            return false;
        }
        return true;
    }

    static boolean datechecker(String date){
        if (date.length()!=10){
            return false;
        }
        try {
            int day=Integer.parseInt(date.substring(0,2));
            if (day>31||day<1){
                return false;
            }
            int month=Integer.parseInt(date.substring(3,5));
            if (month<1||month>12){
                return false;
            }
            if (day==31){
                if (!(month==1||month==3||month==5||month==7||month==8||month==10||month==12)){
                    return false;
                }
            }
            int year=Integer.parseInt(date.substring(7));
            if (year<2025){
                return false;
            }
            if (year==2025){
                if (month<10){
                    return false;
                }
                if (month==10&&day<17){
                    return false;
                }
            }

        }
        catch (Exception e){
            return false;
        }

        return true;
    }

    static int  timechecker(String time){

        // returns -1 indicating invalid time format
        // returns 1 if everything is fine
        // returns 2 if hospital is not open at that time
        if (time.length()!=5){
            return -1;
        }
        try{
            int hour =Integer.parseInt(time.substring(0,2));
            if(hour==24){
                return 2;
            }
            if(hour>24){
                return -1;
            }
            int minute=Integer.parseInt(time.substring(3));
            if (minute>59){
                return -1;
            }

            if (hour<8||hour>20){
                return 2;
            }
        }
        catch (Exception e ){
            return -1;
        }

        return 1;
    }


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
                    System.out.println();
                    System.out.println("---- USER MODE ----");
                    System.out.println();
                    boolean isrunning=true;
                    while (isrunning) {
                        System.out.println();
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
                                    if(age<0){
                                        System.out.println();
                                        System.out.println("Invalid Age !!");
                                        ispatient_manager_running=false;
                                        break;
                                    }
                                    System.out.print("Enter Gender (male/female): ");
                                    String gender = sc.next();
                                    if(!gender_check(gender)){
                                        System.out.println();
                                        System.out.println("Invalid Gender !!");
                                        System.out.println();
                                        ispatient_manager_running=false;
                                        break;
                                    }

                                    System.out.print("Enter mobile number : ");
                                    String mobile = sc.next();
                                    if(!contact_checker(mobile)){
                                        System.out.println();
                                        System.out.println("Invalid Contact Number !!");
                                        System.out.println();
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

                                }
                                else if (patientmanager_choice == 2) {
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
                                System.out.println("      3 --> Edit Appointment ");
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
                                                            System.out.print("Enter the date you want to get appointment (dd/mm/yy) : ");
                                                            String date=sc.next();
                                                            if (!datechecker(date)){
                                                                System.out.println("Invalid !!! .. check format and date again ...");
                                                                break;
                                                            }
                                                            System.out.print("Enter time (in 24 hr format {09:00}) you want to come on "+date+" (appointments are only between 08:00 and 20:00) : ");
                                                            String time=sc.next();
                                                            if(timechecker(time)==1){
                                                                patients.get(pat_id).appointment_date=date;
                                                                patients.get(pat_id).appointment_time=time;
                                                                System.out.println();
                                                                System.out.println("Appointment Booked Successfully ");
                                                                System.out.println();
                                                                System.out.println("---- Doctor Details ----");
                                                                doctors.get(i).display();
                                                            }
                                                            else if(timechecker(time)==-1){
                                                                System.out.println("Invalid time format !!");
                                                                break;
                                                            }
                                                            else {
                                                                System.out.println("Doctor does not sit at that time !! Please take appointment for another time..");
                                                                break;
                                                            }

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
                                        System.out.println("Appointment Date : "+patients.get(pat_id).appointment_date);
                                        System.out.println("Appointment Date : "+patients.get(pat_id).appointment_time);
                                        System.out.println();
                                        doctors.get(docid).display();
                                    }
                                }
                                else if (appoint_choice==3){
                                    System.out.println("Enter new Date : ");
                                    String date=sc.next();
                                    if (!datechecker(date)){
                                        System.out.println("Invalid Date !!");
                                        break;
                                    }
                                    if(patients.get(pat_id).appointment_date==date){
                                        System.out.println("Old date and new date cannot be same ..");
                                        break;
                                    }
                                    System.out.println("Enter Time : ");
                                    String time=sc.next();
                                    if(timechecker(time)==-1){
                                        patients.get(pat_id).appointment_date=date;
                                        patients.get(pat_id).appointment_time=time;
                                        System.out.println();
                                        System.out.println("Appointment Changed Successfully ..");
                                        System.out.println();
                                    }
                                    else if(timechecker(time)==-1){
                                        System.out.println("Invalid time format !!");
                                        break;
                                    }
                                    else {
                                        System.out.println("Doctor does not sit at that time !! Please take appointment for another time..");
                                        break;
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
                            System.out.print("ENTER PATIENT ID: ");
                            int pd = sc.nextInt();
                            if (pd <= 0 || pd > patients.size()) {
                                System.out.println("Invalid Patient ID!");
                            } else {
                                Patient p = patients.get(pd - 1);
                                System.out.println();
                                System.out.println();
                                System.out.println("===============================================================================================");
                                System.out.println("                                     VIJVAL HOSPITALS                                         ");
                                System.out.println("                                           BILL                                               ");
                                System.out.println("-----------------------------------------------------------------------------------------------");
                                System.out.println("Patient Name   : " + p.name);
                                System.out.println("Patient ID     : " + (p.id + 1));
                                System.out.println("Age            : " + p.age );
                                System.out.println("Gender         : " +p.gender);
                                System.out.println("Mobile         : " + p.mobile);
                                System.out.println("Issue          : " + p.issue);

                                if (p.doctorid != -1 && p.doctorid < doctors.size()) {
                                    Doctor d = doctors.get(p.doctorid);
                                    System.out.println("Consulting Dr. : " + d.name + " (Speciality: " + d.speciality + ")");
                                } else {
                                    System.out.println("Consulting Dr. : Not Assigned");
                                }
                                System.out.println();
                                System.out.println("Consultation Fee : ");
                                System.out.println();
                                System.out.println();
                                System.out.println("-----------------------------------------------------------------------------------------------");
                                System.out.println("                THANK YOU FOR VISITING VIJVAL HOSPITALS – GET WELL SOON!                       ");
                                System.out.println("===============================================================================================");
                                System.out.println();
                                System.out.println();
                            }
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
                    System.out.println();
                    boolean isrunning=true;
                    while (isrunning){
                        System.out.println();
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
                                    if(age<0){
                                        System.out.println();
                                        System.out.println("Invalid Age !!");
                                        ispatient_manager_running=false;
                                        break;
                                    }
                                    System.out.print("Enter Gender (male/female): ");
                                    String gender = sc.next();
                                    if(!gender_check(gender)){
                                        System.out.println();
                                        System.out.println("Invalid Gender !!");
                                        System.out.println();
                                        ispatient_manager_running=false;
                                        break;
                                    }

                                    System.out.print("Enter mobile number : ");
                                    String mobile = sc.next();
                                    if(!contact_checker(mobile)){
                                        System.out.println();
                                        System.out.println("Invalid Contact Number !!");
                                        System.out.println();
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

                                }
                                else if (patientmanager_choice == 2) {
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


                                }
                                else if (patientmanager_choice==3){
                                    System.out.print("Enter patient Id : ");
                                    int pat_id=sc.nextInt();
                                    if(!patient_ids.contains(pat_id)){
                                        System.out.println("No patient with ID - "+pat_id);
                                        System.out.println();
                                    }
                                    else{
                                        System.out.println();
                                        System.out.println("Press : ");
                                        System.out.println("      1 --> Edit patient name ");
                                        System.out.println("      2 --> Edit patient gender ");
                                        System.out.println("      3 --> Edit patient mobile number ");
                                        System.out.println("      4 --> Edit patient age ");
                                        System.out.println("      5 --> Edit patient appointment date ");
                                        System.out.println("      6 --> Edit patient appointment time ");
                                        System.out.println("      7 --> Edit All patient basic details ");
                                        System.out.println("      8 --> Return to Main Menu ");
                                        System.out.println();

                                        int edit_choice=sc.nextInt();
                                        if(edit_choice==1){
                                            System.out.print("Enter updated name : ");
                                            patients.get(pat_id).name=sc.nextLine();
                                            System.out.println();
                                            System.out.println("Updated Name successfully ...");
                                            System.out.println();
                                        }
                                        else if(edit_choice==2){
                                            System.out.print("Enter Updated Gender (male/female): ");
                                            String gender = sc.next();
                                            if(!gender_check(gender)){
                                                System.out.println();
                                                System.out.println("Invalid Gender !!");
                                                System.out.println();
                                                ispatient_manager_running=false;
                                                break;
                                            }
                                            else{
                                                patients.get(pat_id).gender=gender;
                                                System.out.println();
                                                System.out.println("Updated Gender successfully ...");
                                                System.out.println();
                                            }
                                        }
                                        else if(edit_choice==3){
                                            System.out.print("Enter updated contact number : ");
                                            String mobile = sc.next();
                                            if(!contact_checker(mobile)){
                                                System.out.println();
                                                System.out.println("Invalid Contact Number !!");
                                                System.out.println();
                                                ispatient_manager_running=false;
                                                break;
                                            }
                                            else{
                                                patients.get(pat_id).mobile=mobile;
                                                System.out.println();
                                                System.out.println("Updated Mobile Number Successfully ...");
                                            }
                                        }
                                        else if(edit_choice==4){
                                            System.out.print("Enter updated age : ");
                                            int age = sc.nextInt();
                                            if(age<0){
                                                System.out.println();
                                                System.out.println("Invalid Age !!");
                                                System.out.println();
                                                ispatient_manager_running=false;
                                                break;
                                            }
                                            else{
                                                patients.get(pat_id).age=sc.nextInt();
                                                System.out.println();
                                                System.out.println("Updated Age Successfully ...");
                                                System.out.println();
                                            }

                                        }
                                        else if(edit_choice==5){
                                            System.out.print("Enter updated appointment date (dd/mm/yy): ");
                                            String date=sc.next();
                                            if(!datechecker(date)){
                                                System.out.println();
                                                System.out.println("Invalid date format or Invalid date !!!");
                                                System.out.println();
                                                ispatient_manager_running=false;
                                                break;
                                            }
                                            else{
                                                patients.get(pat_id).appointment_date=date;
                                                System.out.println();
                                                System.out.println("Updated Appointment Date Successfully ...");
                                                System.out.println();
                                            }
                                        }
                                        else if(edit_choice==6){
                                            System.out.print("Enter time (in 24 hr format {09:00}) you want to come on "+patients.get(pat_id).appointment_date+" (appointments are only between 08:00 and 20:00) : ");
                                            String time=sc.next();
                                            if(timechecker(time)==1){
                                                patients.get(pat_id).appointment_time=time;
                                                System.out.println();
                                                System.out.println("Updated Appointment Successfully ... ");
                                                System.out.println();
                                            }
                                            else if(timechecker(time)==-1){
                                                System.out.println("Invalid time format !!");
                                                break;
                                            }
                                            else {
                                                System.out.println("Doctor does not sit at that time !! Please take appointment for another time..");
                                                break;
                                            }

                                        }
                                        else if (edit_choice==7){
                                            System.out.println();
                                            System.out.print("Enter Full Name : ");
                                            sc.nextLine();
                                            String name =sc.nextLine();
                                            System.out.print("Enter Updated Age : ");
                                            int age = sc.nextInt();
                                            if(age<0){
                                                System.out.println();
                                                System.out.println("Invalid Age !!");
                                                ispatient_manager_running=false;
                                                break;
                                            }
                                            System.out.print("Enter Updated Gender (male/female): ");
                                            String gender = sc.next();
                                            if(!gender_check(gender)){
                                                System.out.println();
                                                System.out.println("Invalid Gender !!");
                                                System.out.println();
                                                ispatient_manager_running=false;
                                                break;
                                            }

                                            System.out.print("Enter Updated mobile number : ");
                                            String mobile = sc.next();
                                            if(!contact_checker(mobile)){
                                                System.out.println();
                                                System.out.println("Invalid Contact Number !!");
                                                System.out.println();
                                                ispatient_manager_running=false;
                                                break;
                                            }
                                        }
                                        else if (edit_choice==8){
                                            ispatient_manager_running=false;
                                            break;
                                        }
                                        else{
                                            System.out.println();
                                            System.out.println("Invalid choice !!!");
                                            System.out.println();
                                        }
                                    }
                                }

                                else if (patientmanager_choice == 4) {
                                    ispatient_manager_running=false;
                                    break;
                                } else {
                                    System.out.println("Enter Valid choice !!!!");
                                }
                            }

                        }





                    }
































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