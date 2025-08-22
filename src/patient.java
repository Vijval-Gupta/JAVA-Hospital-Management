public class patient {
    String name;
    int age;
    char gender;
    int mobile;
    int id;


    patient (String name , int age ,char gender , int mobile, int id){
        this.name =name;
        this.gender=gender;
        this.age=age;
        this.mobile=mobile;
        this.id=id;
    }
    void display(){
        System.out.println("Name : "+name);
        System.out.println("Patient Id : "+id);
        System.out.println("Age : "+age);
        System.out.println("Gender : "+gender);
        System.out.println("Contact : "+mobile);
    }
}
