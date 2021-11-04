package opgave1_2dobbelArray;

public class Opgave1DobbelArray {

    public static void main(String[] args) {
        int[][] values = {{0,4,3,9,6}, {1,3,5,2,2}, {3,3,1,0,1}, {0,0,9,7,1}};

        DobbelArrayMethods da = new DobbelArrayMethods();
        System.out.println("Værdien af tabellen udskrives");
        da.udskrivArray(values);
        int v = da.getValueAt(values, 1, 2);
        int rowsum = da.sumRow(values, 1);
        int colsum = da.sumCol(values, 1);
        int overallsum = da.sum(values);

        System.out.println("************************");
        System.out.println(v);
        System.out.println(rowsum);
        System.out.println(colsum);
        System.out.println(overallsum);

        //TODO Tilføj kode der afprøver metoderne du programmerer i klassen DobbelArray til opgave 1

    }




}
