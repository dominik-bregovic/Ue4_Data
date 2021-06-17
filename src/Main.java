import java.util.List;

/**
 * Main Class
 *
 * Recommendation: Do not change this.
 *
 * @author Koitz-Hristov
 */
public class Main {



    public static void main(String[] args) {


        if (args.length != 1) {
            System.err.println("Error: Please specify an input file");
            System.exit(-1);
        }

        IOHandler ioHandler=new IOHandler();
        List<String> input = ioHandler.readInput(args[0]);
        System.out.println("Input File: " + args[0]);

        // retrieve task, e.g. sortByAgeAscending
        String task = input.remove(0);

        // parse students
        Student[] students=new Student[input.size()];
        int counter=0;
        for(String line:input){
            String[] tokens = line.split(":");
            Student student=new Student(Integer.parseInt(tokens[0]),tokens[1]);
            students[counter]=student;
            counter++;
        }

        Sort my_sort=new Sort(students);
        String result="";
        switch(task){
            case "sortByAgeAscending":
                my_sort.sortByAgeAscending(students,0,students.length-1);
                result = my_sort.getAgesAsString();
                break;
            case "sortByNameAscending":
                my_sort.sortByNameAscending(students,0,students.length-1);
                result = my_sort.getNamesAsString();
                break;
            case "sortByAgeDescending":
                my_sort.sortByAgeDescending(students,0,students.length-1);
                result = my_sort.getAgesAsString();
                break;

            case "sortByNameDescending":
                my_sort.sortByNameDescending(students,0,students.length-1);
                result = my_sort.getNamesAsString();
                break;
        }

        ioHandler.printResultToOutputFile(result,args[0],false);
    }

}
