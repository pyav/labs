/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 *
 * Output:
 * ------
 * A
 * AB
 * ZY
 * CYNI
 * AZ
 */

public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        String result = "";

        while(columnNumber > 0) {
            if (columnNumber % 26  == 0) {
                result = "Z" + result;
                columnNumber /= 26;
                columnNumber--;
            } else {
                result = Character.toString('A' + ((columnNumber % 26)-1)) + result;
                columnNumber /= 26;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(1));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(28));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(701));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(70001));
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(52));
    }

}

