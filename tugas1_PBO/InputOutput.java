import javax.swing.JOptionPane;

public class InputOutput {
    public static void main(String[] args) {
        // Input
        String belajar = JOptionPane.showInputDialog("Anda sedang belajar apa?");

        // Output
        JOptionPane.showMessageDialog(null, 
            "Belajar " + belajar + " sangat mudah");
    }
}