public class Doctor {
    String name;
    String speciality;
    String is_available;
    String mobile;
    int id;


    Doctor(String name,String speciality,String is_available,String mobile,int id){
        this.name=name.toUpperCase();
        this.speciality=speciality;
        this.is_available=is_available.toLowerCase();
        this.mobile=mobile;
        this.id=id;
    }

    void display(){
        System.out.println();
        System.out.println("Name : "+name);
        System.out.println("Contact : "+mobile);
        System.out.println("Speciality : "+speciality);
        System.out.println("Availability : "+is_available);
        System.out.println();
    }
}
