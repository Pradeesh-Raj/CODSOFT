import java.util.*;

class Grades{
    private final HashMap<String,Integer> marks;
    private int total;
    private double average;

    public Grades(){
        total = 0;
        average = 0;
        marks = new HashMap<>();
    }

    public void enterMarks(){
        Scanner scan = new Scanner(System.in);
        String subjectName;
        int mark;
        String line;
        String[] comps;
        System.out.print("Enter the number of subjects : ");
        int subjects = scan.nextInt();
        scan.nextLine();
        if(subjects <= 0){
            System.out.println("Number of subjects must be atleast 1");
            return;
        }
        System.out.println("Enter the Subjects and Marks (Subject Mark) :");
        Subjects:for(int i = 1 ; i <= subjects ; i++){
            line = scan.nextLine();
            comps = line.split(" ");
            subjectName = comps[0];
            Set<String> keys = marks.keySet();
            for(String key : keys){
                if(key.equalsIgnoreCase(subjectName)){
                    System.out.println("Subject already exist");
                    i--;
                    continue Subjects;
                }
            }
            mark = Integer.parseInt(comps[1]);
            while(mark < 0 || mark > 100){
                System.out.println("Invalid mark, Please enter value within 0-100.");
                System.out.print("Enter mark for " + subjectName + " : ");
                mark = scan.nextInt();
                scan.nextLine();
            }
            marks.put(subjectName,mark);
        }
    }

    public void calculateAverage(){
        total = 0;
        Collection<Integer> coll =  marks.values();
        ArrayList<Integer> values = new ArrayList<>(coll);
        for(Integer i : values){
            total+=i;
        }
        average = (double)total / (values.size());
    }

    public char assignGrade(){
        if(average >= 90) return 'A';
        else if(average >= 80) return 'B';
        else if(average >= 60) return 'C';
        else if(average >=50) return 'D';
        else return 'F';
    }

    public void displayDetails(){
        calculateAverage();
        Set<Map.Entry<String,Integer>> details = marks.entrySet();
        System.out.println("The marks obtained are : ");
        for(Map.Entry<String,Integer> detail : details){
            System.out.println("\t" + detail.getKey() + " = " + detail.getValue());
        }
        System.out.println("Total Marks = " + total);
        System.out.printf("Average Percentage = %.2f\n",average);
        System.out.println("Grade = " + assignGrade());
    }
}



public class GradeCalculator {
    public static void main(String[] args){
        int choice;
        Scanner scan = new Scanner(System.in);
        Grades grade = new Grades();
        Menu:do{
            System.out.println("1.Add marks");
            System.out.println("2.Display Details");
            System.out.println("3.Exit");
            System.out.print("Enter your choice : ");
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.println("---------------");
                    grade.enterMarks();
                    System.out.println("---------------");
                    break;
                case 2:
                    System.out.println("---------------");
                    grade.displayDetails();
                    System.out.println("---------------");
                    break;
                case 3:
                    System.out.println("THANK YOU");
                    break Menu;
            }
        }while(choice < 4);
    }
}
