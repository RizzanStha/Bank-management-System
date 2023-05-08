package coursework.components;

import javax.swing.*;

public class MyCustomTextField extends JTextField {

    public MyCustomTextField(String text){
        super(text);
        setColumns(10);
        setMargin(new java.awt.Insets(10, 10, 10, 10));
    }
}
