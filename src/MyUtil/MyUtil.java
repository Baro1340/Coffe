/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MyUtil;

import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author LEGION 5 PRO
 */
public class MyUtil {

    public static void setJTableColumnsWidth(JTable table, int tablePreferredWidth,
            double... percentages) {
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }

        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth( (int)(tablePreferredWidth * (percentages[i] / total)));
        }
    }
    public static NumberFormat FormatNumber(){
        Locale lc = new Locale("vi", "VN");
        NumberFormat numf = NumberFormat.getInstance(lc);
        return numf;
    }
}
