import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JButton;
import java.awt.Container;
import javax.swing.*;
import java.util.*;
import java.util.Arrays;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;

public class CurrencyConverter extends JFrame{
    private String title;
    private int height;
    private int width;
    private double eurotodoll;


    public CurrencyConverter(String title, int height, int width) {
        super(title);
        this.title = title;
        this.height = height;
        this.width = width;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //panel contenant tout
        JPanel top = new JPanel();
        BoxLayout border = new BoxLayout(top, BoxLayout.Y_AXIS);
        top.setLayout(border);

        //boite pour components dollar
        JPanel pldollar = new JPanel();
        BoxLayout boxdollar = new BoxLayout(pldollar, BoxLayout.X_AXIS);
        pldollar.setLayout(boxdollar);
        ImageIcon icondollar = new ImageIcon("images/usd.png");
        Image iresizedd = icondollar.getImage();
        Image newid = iresizedd.getScaledInstance(45,23, Image.SCALE_DEFAULT);
        ImageIcon lastdol = new ImageIcon(newid);
        JLabel labeld = new JLabel(lastdol);
        pldollar.add(labeld);
        pldollar.add(Box.createRigidArea(new Dimension(5,0)));
        Button dollar = new Button("USD");
        pldollar.add(dollar);
        pldollar.add(Box.createRigidArea(new Dimension(5,0)));
        JTextField toptextd = new JTextField("0");
        toptextd.setPreferredSize(new Dimension(2,5));
        pldollar.add(toptextd);
        //boite pour components euro
        JPanel pleuro = new JPanel();
        BoxLayout boxeuro = new BoxLayout(pleuro, BoxLayout.X_AXIS);
        pleuro.setLayout(boxeuro);
        ImageIcon iconeuro = new ImageIcon("images/euro.png");
        Image iresized = iconeuro.getImage();
        Image newi = iresized.getScaledInstance(46,28, Image.SCALE_DEFAULT);
        ImageIcon lasteuro = new ImageIcon(newi);
        JLabel label = new JLabel(lasteuro); //afficher le symbole €
        pleuro.add(label);
        pleuro.add(Box.createRigidArea(new Dimension(5,0)));
        Button euro = new Button("EUR");
        pleuro.add(euro);
        pleuro.add(Box.createRigidArea(new Dimension(5,0)));
        JTextField toptext = new JTextField("0");
        toptext.setPreferredSize(new Dimension(2,5));
        pleuro.add(toptext);

        //action listener CurrencyConverter
        euro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Converting to double
                double d = Double.parseDouble(toptext.getText());

                //converting euros to USD
                double d1 = (d / eurotodoll);

                //get the value in string + place in the text box
                String str1 = String.valueOf(d1);
                toptextd.setText(str1);

            }
        });
        dollar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Converting to double
                double d2 = Double.parseDouble(toptextd.getText());

                //converting euros to USD
                double d3 = (d2 * eurotodoll);

                //get the value in string + place in the text box
                String str2 = String.valueOf(d3);
                toptext.setText(str2);

            }
        });


        //boite du bas
        JPanel down = new JPanel();
        border = new BoxLayout(down, BoxLayout.Y_AXIS);
        down.setLayout(border);
        label = new JLabel("South");
        down.add(label);
        JTextField downtext = new JTextField();
        down.add(downtext);
        //ajout des boites dans top
        top.add(pleuro);
        top.add(pldollar);
        top.add(down);

        setContentPane(top);
        setVisible(true);


    }

    public double getEurotodoll() {
        return this.eurotodoll;
    }

    public void setEurotodoll(double eurotodoll) {
        this.eurotodoll = eurotodoll;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public static void main(String[] args) {
        JFrame window = new Rates();
    }


}