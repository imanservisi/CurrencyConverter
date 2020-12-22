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

public class Window extends JFrame{
    private String title;
    private int height;
    private int width;
    private double eurotodol;
    private double eurotochf;
    private double doltochf;

    public Window(String title, int height, int width) {
        super(title);
        this.title = title;
        this.height = height;
        this.width = width;

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(l);
        setSize(height, width);

        JPanel top = new JPanel();
        BoxLayout box = new BoxLayout(top, BoxLayout.Y_AXIS);
        top.setLayout(box);

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
        JTextField toptextd = new JTextField();
        toptextd.setPreferredSize(new Dimension(2,5));
        pldollar.add(toptextd);
        //boite pour components suisse
        JPanel plsuisse = new JPanel();
        BoxLayout boxsuisse = new BoxLayout(plsuisse, BoxLayout.X_AXIS);
        plsuisse.setLayout(boxsuisse);
        ImageIcon iconsuisse = new ImageIcon("images/suisse.png");
        Image iresizeds = iconsuisse.getImage();
        Image newis = iresizeds.getScaledInstance(45,23, Image.SCALE_DEFAULT);
        ImageIcon lastsuisse = new ImageIcon(newis);
        JLabel labels = new JLabel(lastsuisse);
        plsuisse.add(labels);
        plsuisse.add(Box.createRigidArea(new Dimension(5,0)));
        Button suisse = new Button("CHF");
        plsuisse.add(suisse);
        plsuisse.add(Box.createRigidArea(new Dimension(7,0)));
        JTextField toptexts = new JTextField();
        toptexts.setPreferredSize(new Dimension(2,5));
        plsuisse.add(toptexts);
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
        JTextField toptext = new JTextField();
        toptext.setPreferredSize(new Dimension(2,5));
        pleuro.add(toptext);
       /* //boite pour component GBK
        JPanel plpound = new JPanel();
        BoxLayout boxpound = new BoxLayout(plpound, BoxLayout.X_AXIS);
        plpound.setLayout(boxpound);
        ImageIcon iconpound = new ImageIcon("images/anglais.png");
        Image iresizedp = iconpound.getImage();
        Image newip = iresizedp.getScaledInstance(45,23, Image.SCALE_DEFAULT);
        ImageIcon lastpound = new ImageIcon(newip);
        JLabel labelp = new JLabel(lastpound);
        plpound.add(labelp);
        plpound.add(Box.createRigidArea(new Dimension(5,0)));
        Button pound = new Button("GBK");
        plpound.add(pound);
        plpound.add(Box.createRigidArea(new Dimension(5,0)));
        JTextField toptextp = new JTextField();
        toptextp.setPreferredSize(new Dimension(2,5));
        plpound.add(toptextp);*/

        //action listener CurrencyConverter
        euro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Converting to double
                double d = Double.parseDouble(toptext.getText());

                //converting euros to USD
                double d1 = (d / eurotodol);
                //converting euros to CHF
                double f1 = (d * eurotochf);

                //get the value in string + place in the text box
                String streuro = String.valueOf(d1);
                String strchf = String.valueOf(f1);
                toptextd.setText(streuro);
                toptexts.setText(strchf);
            }
        });
        dollar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Converting to double
                double d2 = Double.parseDouble(toptextd.getText());

                //converting USD to euros
                double d3 = (d2 * eurotodol);
                //converting USD to CHF
                double f3 = (d2 * doltochf);

                //get the value in string + place in the text box
                String strdol = String.valueOf(d3);
                String strsui = String.valueOf(f3);
                toptext.setText(strdol);
                toptexts.setText(strsui);
            }
        });
        suisse.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Converting to double
                double d4 = Double.parseDouble(toptexts.getText());

                //converting CHF to others
                double d5 = (d4 / doltochf);
                double f5 = (d4 / eurotochf);

                //get the value in string + place in the text box
                String strdl = String.valueOf(d5);
                String streur = String.valueOf(f5);
                toptextd.setText(strdl);
                toptext.setText(streur);
            }
        });


        //box Calculator
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 4, 4));
        JLabel result = new JLabel("0");
        result.setBackground(Color.ORANGE);
        result.setFont(new Font("Serif", Font.BOLD, 50));
        panel.add(result);

        Button z = new Button("0");
        Button b = new Button("1");
        Button c = new Button("2");
        Button d = new Button("3");
        Button e = new Button("4");
        Button f = new Button("5");
        Button g = new Button("6");
        Button h = new Button("7");
        Button i = new Button("8");
        Button j = new Button("9");
        Button k = new Button("=");
        Button m = new Button("Reset");
        Button add = new Button("+");
        Button subtract = new Button("-");
        Button multiply = new Button("*");
        Button divide = new Button("/");

        //action listener Calculator
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(result.getText()=="0"){
                    result.setText(add.getText());
                }else{
                    result.setText(result.getText() + add.getText());
                }
            }
        });
        subtract.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(result.getText()=="0"){
                    result.setText(subtract.getText());
                }else{
                    result.setText(result.getText() + subtract.getText());
                }
            }
        });
        multiply.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(result.getText()=="0"){
                    result.setText(multiply.getText());
                }else{
                    result.setText(result.getText() + multiply.getText());
                }
            }
        });
        divide.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(result.getText()=="0"){
                    result.setText(divide.getText());
                }else{
                    result.setText(result.getText() + divide.getText());
                }
            }
        });z.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(result.getText()=="0"){
                    result.setText(z.getText());
                }else{
                    result.setText(result.getText() + z.getText());
                }
            }
        });
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(result.getText()=="0"){
                    result.setText(b.getText());
                }else{
                    result.setText(result.getText() + b.getText());
                }
            }
        });
        c.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(result.getText()=="0"){
                    result.setText(c.getText());
                }else{
                    result.setText(result.getText() + c.getText());
                }
            }
        });
        d.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(result.getText()=="0"){
                    result.setText(d.getText());
                }else{
                    result.setText(result.getText() + d.getText());
                }
            }
        });
        e.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(result.getText()=="0"){
                    result.setText(e.getText());
                }else{
                    result.setText(result.getText() + e.getText());
                }
            }
        });
        f.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(result.getText()=="0"){
                    result.setText(f.getText());
                }else{
                    result.setText(result.getText() + f.getText());
                }
            }
        });
        g.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(result.getText()=="0"){
                    result.setText(g.getText());
                }else{
                    result.setText(result.getText() + g.getText());
                }
            }
        });
        h.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(result.getText()=="0"){
                    result.setText(h.getText());
                }else{
                    result.setText(result.getText() + h.getText());
                }
            }
        });
        i.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(result.getText()=="0"){
                    result.setText(i.getText());
                }else{
                    result.setText(result.getText() + i.getText());
                }
            }
        });
        k.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){

                String operation=result.getText();
                String tab []=operation.split("[/*+-]");

                int processed_value = 0;
                double somme=Double.parseDouble(tab[0]);

                for(int i=1;i<operation.length();i++)
                {
                    char operator = operation.charAt(i);

                    switch(operator)
                    {
                        case '+':
                            processed_value++;
                            somme += Integer.parseInt(tab[processed_value]);
                            break;
                        case '-':
                            processed_value++;
                            somme -= Integer.parseInt(tab[processed_value]);
                            break;
                        case '*':
                            processed_value++;
                            somme = somme * Integer.parseInt(tab[processed_value]);
                            break;
                        case '/':
                            processed_value++;
                            somme = somme / Integer.parseInt(tab[processed_value]);
                            break;
                        default:
                            //Si on tombe ici c'est que operator est un chiffre (aucune opération à faire);
                    }
                }

                result.setText(String.valueOf(somme));
            }
        });
        m.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                result.setText("0");
            }
        });
        j.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                if(result.getText()=="0"){
                    result.setText(j.getText());
                }else{
                    result.setText(result.getText() + j.getText());
                }
            }
        });

        panel.add(z);
        panel.add(b);
        panel.add(c);
        panel.add(d);
        panel.add(e);
        panel.add(f);
        panel.add(g);
        panel.add(h);
        panel.add(i);
        panel.add(j);
        panel.add(add);
        panel.add(subtract);
        panel.add(multiply);
        panel.add(divide);
        panel.add(k);
        panel.add(m);

        //ajout des boites dans top
        top.add(pleuro);
        top.add(plsuisse);
        top.add(pldollar);
      //  top.add(plpound);
        top.add(panel);

        setContentPane(top);
        setVisible(true);
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

    public double getEurotodol() {
        return eurotodol;
    }

    public void setEurotodol(double eurotodol) {
        this.eurotodol = eurotodol;
    }

    public double getEurotochf() {
        return eurotochf;
    }

    public void setEurotochf(double eurotochf) {
        this.eurotochf = eurotochf;
    }

    public double getDoltochf() {
        return doltochf;
    }

    public void setDoltochf(double doltochf) {
        this.doltochf = doltochf;
    }

    public static void main(String[] args) {
        JFrame window = new Rates();
    }


}