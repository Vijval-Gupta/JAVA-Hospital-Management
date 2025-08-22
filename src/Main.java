import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int idcounter=0;
        System.out.println("----------------------------------------------------------");
        System.out.println("-              Welcome to Vijval Hospitals               -");
        System.out.println("----------------------------------------------------------");
        patient []patients=new patient[50];
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter number of patients : ");

        int n=sc.nextInt();
        System.out.println();
        for (int i=0;i<n;i++){
            System.out.println();
            System.out.println("--------Enter Records of Patient--------");
            System.out.println();
            System.out.print("Enter Name : ");
            sc.nextLine();
            String name=sc.nextLine();
            System.out.print("Enter Age : ");
            int age=sc.nextInt();
            System.out.print("Enter Gender : ");
            char c=sc.next().charAt(0);
            System.out.print("Enter Contact : ");
            int contact=sc.nextInt();
            System.out.println("Patient Registered Successfully !!!");
            ++idcounter;
            patients[i]=new patient(name,age,c,contact,idcounter);



        }System.out.println();
        for (int i=0;i<n;i++){

            patients[i].display();
            System.out.println();
        }

    }
}