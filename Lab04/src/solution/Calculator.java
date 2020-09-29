package solution;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Reece Pollard
 * @version 2/12/2020
 */
public class Calculator
{
    
    private JFrame frame;
    
    private JButton addButton;
    private JButton subButton;
    private JButton multButton;
    private JButton divButton;
    
    private JTextField leftOperand;
    private JTextField rightOperand;
    
    private JPanel button = new JPanel();
    private JPanel result = new JPanel();
    private JPanel input = new JPanel();
   
    private JLabel resultLabel;
    private JLabel jlr;
   
    private String first;
    private String second;
    
    double number1;
    double number2;
    double r;
    
    /**
     * Method Calculator.
     */
    public Calculator()
    {
        frame = new JFrame();
        frame.setSize(400, 400);
        frame.setLocation(100, 100); 
        frame.setTitle("Calculator");
        
        initializeComponents();
               
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Method initalizeComponents.
     */
    public void initializeComponents()
    { 
        addButton = new JButton("ADD");
        addButton.setName("addButton"); 
        button.add(addButton);
        
        subButton = new JButton("SUB");
        subButton.setName("subButton");
        button.add(subButton);
        
        multButton = new JButton("MULT");
        multButton.setName("multButton");
        button.add(multButton);
        
        divButton = new JButton("DIV");
        divButton.setName("divButton");
        button.add(divButton);
        
        resultLabel = new JLabel(" ");
        resultLabel.setName("resultLabel");
        result.add(resultLabel);
        
        jlr = new JLabel("Result = ");
        jlr.setName("jlr");
        result.add(jlr);
        
        leftOperand = new JTextField("", 10);
        leftOperand.setName("leftOperand");
        input.add(leftOperand);
        
        rightOperand = new JTextField("", 10);
        rightOperand.setName("rightOperand"); 
        input.add(rightOperand);
        
        frame.add(input, BorderLayout.NORTH);
        frame.add(result, BorderLayout.WEST);
        frame.add(button, BorderLayout.SOUTH);
               
        addActionListeners(null);
    }
    
    /**
     * method addActionListeners.
     * @param AvtionEvent e ActionEvent e
     */
    public void addActionListeners(ActionEvent e)
    {
        addButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                addition();
            }
        });
        
        subButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                subtraction();
            }
        });
        
        multButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                multiplication();
            }
        });
        
        divButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                division();
            }
        });
        
        
    }
    
    /**
     * method getFrame.
     * @return frame.
     */
    public JFrame getFrame()
    {
        return frame;
    }
    
    /**
     * Method addClicked.
     */
    public void addition()
    {
        first = leftOperand.getText();
        second = rightOperand.getText();
      
        if (first.matches("[0-9.-]+") 
            && second.matches("[0-9.-]+"))
        {
            number1 = Double.parseDouble(first);
            number2 = Double.parseDouble(second);
            r = number1 + number2;
            resultLabel.setText("" + r);
        }
        else
        {
            resultLabel.setText("Error");
        }

    }
    
    /**
     * Method subtraction.
     */
    public void subtraction()
    {
        first = leftOperand.getText();
        second = rightOperand.getText();
       
        if (first.matches("[0-9.-]+") 
            && second.matches("[0-9.-]+"))
        {
            number1 = Double.parseDouble(first);
            number2 = Double.parseDouble(second);
            r = number1 - number2;
            resultLabel.setText("" + r);
        }
        else
        {
            resultLabel.setText("Error");
        }
    }
    
    /**
     * Method multiplication.
     */
    public void multiplication()
    {
        first = leftOperand.getText();
        second = rightOperand.getText();
        
        if (first.matches("[0-9.-]+") 
            && second.matches("[0-9.-]+"))
        {
            number1 = Double.parseDouble(first);
            number2 = Double.parseDouble(second);
            r = number1 * number2;
            resultLabel.setText("" + r);
        }
        else
        {
            resultLabel.setText("Error");
        }
    }
    
    /**
     * Method division.
     */
    public void division()
    {
        first = leftOperand.getText();
        second = rightOperand.getText();
        
        if (first.matches("[0-9.-]+") 
            && second.matches("[1-9.-]+"))
        {
            number1 = Double.parseDouble(first);
            number2 = Double.parseDouble(second);
            r = number1 / number2;
            resultLabel.setText("" + r);
        } 
        else
        {
            resultLabel.setText("Error");
        }
    }
    
    /**
     * Main method.
     * @param args string array of args.
     */
    public static void main(String[] args)
    {
        Calculator calc = new Calculator();
    }
}
