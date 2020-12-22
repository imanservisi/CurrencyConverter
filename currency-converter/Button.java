import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener {

    JButton Button = new JButton();
    public Button(String text)
    {
        this.setText(text);
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        System.out.println(this.getText() + " clicked");

    }

}