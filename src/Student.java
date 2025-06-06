import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.sql.*;

class StudentDetails {
    protected String name , email = null;
    protected int roll_Number, grade;
}

class StudentManagementSystem extends StudentDetails{
    Scanner input = new Scanner(System.in);
    Connection con;
    PreparedStatement query;
    ResultSet result;

    public StudentManagementSystem(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentSystem", "root", "pradeesh");

        }
        catch(Exception _){}
    }

    private boolean validateRollNumber(int roll) throws Exception{
        PreparedStatement statement = con.prepareStatement("SELECT roll_no FROM STUDENTS");
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            if(rs.getInt("roll_no") == roll){
                return false;
            }
        }
        return true;
    }

    public void addStudent(){
        System.out.print("Enter the number of students to add: ");
        int numberOfStudents = input.nextInt();
        input.nextLine();
        try{
            query = con.prepareStatement("INSERT INTO students VALUES(?,?,?,?)");
            for(int i = 1 ; i <= numberOfStudents ; i++){
                System.out.print("Enter student roll number: ");
                roll_Number = input.nextInt();
                input.nextLine();
                while(roll_Number <= 0 || !validateRollNumber(roll_Number)){
                    if(roll_Number <= 0){
                        System.out.print("Enter valid roll number: ");

                    }
                    else{
                        System.out.println("Roll number exists");
                        System.out.print("Enter valid roll number: ");

                    }
                    roll_Number = input.nextInt();
                    input.nextLine();
                }
                System.out.print("Enter the student name: ");
                name = input.nextLine();
                while(name.isEmpty()){
                    System.out.print("Enter the valid student name: ");
                    name = input.nextLine();
                }
                System.out.print("Enter student grade: ");
                grade = input.nextInt();
                input.nextLine();
                while(grade <= 0 || grade > 12){
                    System.out.print("Enter valid grade: ");
                    grade = input.nextInt();
                    input.nextLine();
                }
                System.out.print("Enter student email (if exists or null): ");
                email = input.nextLine();
                String pattern = "^[a-zA-z0-9.+]+@[a-zA-Z]+\\.[a-zA-Z]{2,4}$";
                if(!email.equalsIgnoreCase("null")){
                    while(!email.matches(pattern)){
                        System.out.print("Enter valid email: ");
                        email = input.nextLine();
                    }
                }
                else email = null;
                query.setInt(1,roll_Number);
                query.setString(2,name);
                query.setString(3,email);
                query.setInt(4,grade);
                query.executeUpdate();
                System.out.println("Student Added");
            }
        }
        catch(Exception _){
            System.err.println("Invalid Input");
        }
    }

    public void removeStudent(){
        try {
            System.out.print("Enter the student roll number to remove: ");
            roll_Number = input.nextInt();
            input.nextLine();
            while(roll_Number <= 0 || validateRollNumber(roll_Number)){
                if(roll_Number <= 0){
                    System.out.print("Enter valid roll number: ");

                }
                else{
                    System.out.println("Roll number does not exists");
                    System.out.print("Enter valid roll number: ");

                }
                roll_Number = input.nextInt();
                input.nextLine();
            }
            query = con.prepareStatement("DELETE FROM STUDENTS WHERE roll_no = ?");
            query.setInt(1,roll_Number);
            if(query.executeUpdate() == 1){
                System.out.println("Student record deleted.");
            }
        }
        catch (Exception _) {
            System.err.println("Invalid Input");
        }
    }

    public void updateStudent(){
        try{
            System.out.print("Enter the student roll number to update: ");
            roll_Number = input.nextInt();
            input.nextLine();
            while(roll_Number <= 0 || validateRollNumber(roll_Number)){
                if(roll_Number <= 0){
                    System.out.print("Enter valid roll number: ");

                }
                else{
                    System.out.println("Roll number does not exists");
                    System.out.print("Enter valid roll number: ");

                }
                roll_Number = input.nextInt();
                input.nextLine();
            }
            char ans = 'y';
            System.out.println("Select the detail you want to update: ");
            do{
                System.out.println("\t1.Roll number");
                System.out.println("\t2.Name");
                System.out.println("\t3.E-mail");
                System.out.println("\t4.Grade");
                System.out.print("Enter the option: ");
                int choice = input.nextInt();
                input.nextLine();
                switch (choice){
                    case 1:
                        System.out.print("Enter the new roll number: ");
                        int new_roll_Number = input.nextInt();
                        input.nextLine();
                        while(new_roll_Number <= 0 || !validateRollNumber(new_roll_Number)){
                            if(roll_Number <= 0){
                                System.out.print("Enter valid roll number: ");

                            }
                            else{
                                System.out.println("Roll number exists");
                                System.out.print("Enter valid roll number: ");

                            }
                            new_roll_Number = input.nextInt();
                            input.nextLine();
                        }
                        try{
                            query = con.prepareStatement("UPDATE STUDENTS SET roll_no = ? WHERE roll_no = ?");
                            query.setInt(1,new_roll_Number);
                            query.setInt(2,roll_Number);
                            if(query.executeUpdate() == 1){
                                System.out.println("Detail updated.");
                            }
                            roll_Number = new_roll_Number;
                        } catch (Exception _) {}
                        break;
                    case 2:
                        try{
                            System.out.print("Enter the new student name: ");
                            name = input.nextLine();
                            while(name.isEmpty()){
                                System.out.print("Enter the valid student name: ");
                                name = input.nextLine();
                            }
                            query = con.prepareStatement("UPDATE STUDENTS SET name = ? WHERE roll_no = ?");
                            query.setString(1,name);
                            query.setInt(2,roll_Number);
                            if(query.executeUpdate() == 1){
                                System.out.println("Detail updated.");
                            }
                        } catch (Exception _) {}
                        break;
                    case 3:
                        try{
                            System.out.print("Enter new student email (if exists or null): ");
                            email = input.nextLine();
                            String pattern = "^[a-zA-z0-9.+]+@[a-zA-Z]+\\.[a-zA-Z]{2,4}$";
                            if(!email.equalsIgnoreCase("null")){
                                while(!email.matches(pattern)){
                                    System.out.print("Enter valid email: ");
                                    email = input.nextLine();
                                }
                            }
                            else email = null;
                            query = con.prepareStatement("UPDATE STUDENTS SET email = ? WHERE roll_no = ?");
                            query.setString(1,email);
                            query.setInt(2,roll_Number);
                            if(query.executeUpdate() == 1){
                                System.out.println("Detail updated.");
                            }
                        }
                        catch(Exception _){}
                        break;
                    case 4:
                        try{
                            System.out.print("Enter new student grade: ");
                            grade = input.nextInt();
                            input.nextLine();
                            while(grade <= 0 || grade > 12){
                                System.out.print("Enter valid grade: ");
                                grade = input.nextInt();
                                input.nextLine();
                            }
                            query = con.prepareStatement("UPDATE STUDENTS SET grade = ? WHERE roll_no = ?");
                            query.setInt(1,grade);
                            query.setInt(2,roll_Number);
                        } catch (Exception _) {}
                        break;
                }
                System.out.print("Do you want to update any other details?(Y/N) : ");
                ans = (char) new BufferedReader(new InputStreamReader(System.in)).read();

            }while(Character.toLowerCase(ans) != 'n');
        }
        catch(Exception _){}
    }

    public void displayStudent(){
        try{
            System.out.print("Enter the roll number of the student: ");
            roll_Number = input.nextInt();
            input.nextLine();
            while(roll_Number <= 0 || validateRollNumber(roll_Number)){
                if(roll_Number <= 0){
                    System.out.print("Enter valid roll number: ");

                }
                else{
                    System.out.println("Roll number does not exists");
                    System.out.print("Enter valid roll number: ");

                }
                roll_Number = input.nextInt();
                input.nextLine();
            }
            query = con.prepareStatement("SELECT * FROM STUDENTS WHERE roll_no = ?");
            query.setInt(1,roll_Number);
            result = query.executeQuery();
            if(result.next()){
                System.out.println("Student details:");
                System.out.println("Roll Number: " + result.getInt("roll_no"));
                System.out.println("Name: " + result.getString("name"));
                System.out.println("E-mail: " + ((result.getString("email") == null)? "NIL" : result.getString("email")));
                System.out.println("Grade: " + result.getInt("grade"));
            }
        }
        catch(Exception _){}
    }
}



public class Student{
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        int choice;
        do{
            System.out.println("1.Add Student");
            System.out.println("2.Remove Student");
            System.out.println("3.Update Student");
            System.out.println("4.Display Student");
            System.out.println("5.Exit");
            System.out.print("Enter your choice: ");
            choice = new Scanner(System.in).nextInt();
            switch (choice){
                case 1:
                    System.out.println("----------");
                    system.addStudent();
                    System.out.println("----------");
                    break;
                case 2:
                    System.out.println("----------");
                    system.removeStudent();
                    System.out.println("----------");
                    break;
                case 3:
                    System.out.println("----------");
                    system.updateStudent();
                    System.out.println("----------");
                    break;
                case 4:
                    System.out.println("----------");
                    system.displayStudent();
                    System.out.println("----------");
                    break;
                case 5:
                    System.out.println("THANK YOU!");
                    System.exit(0);
            }
        }while(choice <= 5);
    }
}
