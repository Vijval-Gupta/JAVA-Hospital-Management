public class Patient {
    String name;
    int age;
    String gender;
    String mobile;
    int id;
    String issue;
    int doctorid=-1;
    String appointment_date="";
    String appointment_time="";


    Patient(String name , int age , String gender , String mobile, int id , String issue){
        this.name =name.toUpperCase();
        this.gender=gender.toLowerCase();
        this.age=age;
        this.mobile=mobile;
        this.id=id;
        this.issue =issue.toLowerCase();
    }
    void display(){
        System.out.println();
        System.out.println("Name : "+name);
        System.out.println("Id : "+id+1);
        System.out.println("Age : "+age);
        System.out.println("Gender : "+gender);
        System.out.println("Contact : "+mobile);
        System.out.println("Issue by patient : "+ issue);
        System.out.println();
    }

}
