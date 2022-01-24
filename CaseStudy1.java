import java.util.*;


class Person{
    private String name;
    private String  dateOfBirth;
    private String  gender;
    private String  mobileNumber;
    private String  bloodGroup;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    
    public void displayPersonDetails(){
        System.out.println("Name : " + name);
        System.out.println("Date Of Birth : " + dateOfBirth);
        System.out.println("Gender : " + gender);
        System.out.println("Mobile Number : " + mobileNumber);
        System.out.println("Blood Group : " + bloodGroup);
    }
}

class Donor extends Person{
    private String  bloodBankName;
    private String  donorType;
    private String  donationDate;
    

    public String getBloodBankName() {
        return bloodBankName;
    }

    public void setBloodBankName(String bloodBankName) 
    {
        this.bloodBankName = bloodBankName;
    }

    public String getDonorType() {
        return donorType;
    }

    public void setDonorType(String donorType) {
        this.donorType = donorType;
    }

    public String getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(String donationDate) {
        this.donationDate = donationDate;
    }
    
    public void displayDonationDetails( ) {             
        System.out.println("Donation Details :");
        super.displayPersonDetails();
        System.out.println("Blood Bank Name : "+bloodBankName);
        System.out.println("Donor Type : "+donorType);
        System.out.println("Donation Date : "+donationDate);
        
    }
}
public class CaseStudy1 {
    public static void main(String args[]) {
      Donor d=new Donor();
    Scanner sc=new Scanner(System.in);

    System.out.println("Enter the name :");
    d.setName(sc.nextLine());
            
    System.out.println("Enter Date of Birth :");
    d.setDateOfBirth(sc.nextLine());
    System.out.println("Enter Gender :");
    d.setGender(sc.nextLine());
    
    System.out.println("Enter Mobile Number :");
    d.setMobileNumber(sc.nextLine());
    
    System.out.println("Enter Blood Group :");
    d.setBloodGroup(sc.nextLine());
    
    System.out.println("Enter Blood Bank Name :");
    
    d.setBloodBankName(sc.nextLine());
    
    System.out.println("Enter Donor Type :");
    
    d.setDonorType(sc.nextLine());
    
    System.out.println("Enter Donation Date :");
    
    d.setDonationDate(sc.nextLine());
    
    d.displayDonationDetails(); 
   
    sc.close();
    }
}