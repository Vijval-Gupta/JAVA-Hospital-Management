public class patient {
    String name;
    int age;
    String gender;
    String mobile;
    int id;
    String issue;


    patient (String name , int age ,String gender , String mobile, int id , String issue){
        this.name =name;
        this.gender=gender;
        this.age=age;
        this.mobile=mobile;
        this.id=id;
        this.issue =issue;
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
