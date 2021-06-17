/**
 * Class that allows to sort a given Array of Students to be sorted by their ages as well as by their names.
 */
public class Sort {

    /**
     * Array to be sorted
     */
    private Student[] student_array;

    public Sort(Student[] student_array) {
        this.student_array = student_array;
    }

    /**
     * Sorts the students array by age in ascending order
     */
    public void sortByAgeAscending(Student[] student_array, int i, int j){

        if (i >= j){
            return;
        }
        int p = (int)Math.floor((i+j)/2);
        Student floor = new Student(p, "");

        sortByAgeAscending(student_array, i, p);
        sortByAgeAscending(student_array, p+1, j);

        if (student_array[j].getAge() < student_array[p].getAge()){
            swap(j, p);
        }
        sortByAgeAscending(student_array, i, j-1);
    }

    /**
     * Sorts the students array by name in ascending order
     */
    public void sortByNameAscending(Student[] student_array, int i, int j){

        if (i >= j){
            return;
        }
        int p = (int) Math.floor((i+j)/2);

        sortByNameAscending(student_array, i, p);
        sortByNameAscending(student_array, p+1, j);

        if (0 > student_array[j].getName().compareToIgnoreCase(student_array[p].getName())){
            swap(j, p);
        }
        sortByNameAscending(student_array, i, j-1);
    }

    /**
     * Sorts the students array by age in descending order
     */
    public void sortByAgeDescending(Student[] student_array, int i, int j){

        if (i >= j){
            return;
        }
        int p = (int) Math.floor((i+j)/2);

        sortByAgeDescending(student_array, i, p);
        sortByAgeDescending(student_array, p+1, j);

        if (student_array[j].getAge() > student_array[p].getAge()){
            swap(j, p);
        }
        sortByAgeDescending(student_array, i, j-1);
    }

    /**
     * Sorts the students array by name in descending order
     */
    public void sortByNameDescending(Student[] student_array, int i, int j){

        if (i >= j){
            return;
        }
        int p = (int) Math.floor((i+j)/2);

        sortByNameDescending(student_array, i, p);
        sortByNameDescending(student_array, p+1, j);

        if (0 < student_array[j].getName().compareToIgnoreCase(student_array[p].getName())){
            swap(j, p);
        }
        sortByNameDescending(student_array, i, j-1);
    }

    /**
     * Swaps two elements within the array based on the indices i and j
     * @param i first index
     * @param j second index
     */
    public void swap(int i, int j){
        Student tmp=student_array[j];
        student_array[j]=student_array[i];
        student_array[i]=tmp;
    }

    /**
     * Returns a String representation of the sorted Array
     * using only the Students' names
     * @return String representation of the array
     */
    public String getNamesAsString(){
        StringBuilder result= new StringBuilder();
        for(Student student:student_array){
            result.append(student.getName());
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * Returns a String representation of the sorted Array
     * using only the Students' age
     * @return String representation of the array
     */
    public String getAgesAsString(){
        StringBuilder result= new StringBuilder();
        for(Student student:student_array){
            result.append(student.getAge());
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * Sets the students array
     * @param students student array
     */
    public void setStudent_array(Student [] students){
        this.student_array=students;
    }

}
