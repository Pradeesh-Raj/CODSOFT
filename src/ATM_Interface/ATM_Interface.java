package ATM_Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Interface {
    JTextField display;
    JButton withdraw;
    JButton deposit;
    JButton balance;
    JButton num1;
    JButton num2;
    JButton num3;
    JButton num4;
    JButton num5;
    JButton num6;
    JButton num7;
    JButton num8;
    JButton num9;
    JButton num0;
    JButton cancel;
    JButton enter;
    JButton clear;
    ATM_Back back_end;

    Interface(){
        JFrame frame = new JFrame("Interface");
        back_end = new ATM_Back();
        {
            num1 = new JButton("1");
            num2 = new JButton("2");
            num3 = new JButton("3");
            num4 = new JButton("4");
            num5 = new JButton("5");
            num6 = new JButton("6");
            num7 = new JButton("7");
            num8 = new JButton("8");
            num9 = new JButton("9");
            num0 = new JButton("0");
            clear = new JButton("CLEAR");
            cancel = new JButton("CANCEL");
            enter = new JButton("ENTER");

            num1.setBounds(600,425,60,60);
            num2.setBounds(680,425,60,60);
            num3.setBounds(760,425,60,60);
            cancel.setBounds(840,425,100,60);

            num4.setBounds(600,505,60,60);
            num5.setBounds(680,505,60,60);
            num6.setBounds(760,505,60,60);
            clear.setBounds(840,505,100,60);

            num7.setBounds(600,585,60,60);
            num8.setBounds(680,585,60,60);
            num9.setBounds(760,585,60,60);
            enter.setBounds(840,585,100,60);

            num0.setBounds(680,665,60,60);

            frame.add(num1);
            frame.add(num2);
            frame.add(num3);
            frame.add(cancel);
            frame.add(num4);
            frame.add(num5);
            frame.add(num6);
            frame.add(clear);
            frame.add(num7);
            frame.add(num8);
            frame.add(num9);
            frame.add(enter);
            frame.add(num0);

            num1.setVisible(true);
            num2.setVisible(true);
            num3.setVisible(true);
            num4.setVisible(true);
            num5.setVisible(true);
            num6.setVisible(true);
            num7.setVisible(true);
            num8.setVisible(true);
            num9.setVisible(true);
            num0.setVisible(true);
            cancel.setVisible(true);
            clear.setVisible(true);
            enter.setVisible(true);

            num1.addActionListener((ActionEvent e)->numpadFunctions(e));
            num2.addActionListener((ActionEvent e)->numpadFunctions(e));
            num3.addActionListener((ActionEvent e)->numpadFunctions(e));
            num4.addActionListener((ActionEvent e)->numpadFunctions(e));
            num5.addActionListener((ActionEvent e)->numpadFunctions(e));
            num6.addActionListener((ActionEvent e)->numpadFunctions(e));
            num7.addActionListener((ActionEvent e)->numpadFunctions(e));
            num8.addActionListener((ActionEvent e)->numpadFunctions(e));
            num9.addActionListener((ActionEvent e)->numpadFunctions(e));
            num0.addActionListener((ActionEvent e)->numpadFunctions(e));
            cancel.addActionListener((ActionEvent e)->numpadFunctions(e));
            clear.addActionListener((ActionEvent e)->numpadFunctions(e));
            enter.addActionListener((ActionEvent e)->numpadFunctions(e));

        }

        display = new JTextField();
        display.setBounds(600,300,340,100);
        display.setEditable(false);
        display.setText("Enter your card number: ");

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(720,430,100,50);
        withdraw.addActionListener((ActionEvent e)-> homeFunctions(e));

        deposit = new JButton("Deposit");
        deposit.setBounds(720,500,100,50);
        deposit.addActionListener((ActionEvent e)-> homeFunctions(e));

        balance = new JButton("Balance");
        balance.setBounds(720,570,100,50);
        balance.addActionListener((ActionEvent e)-> homeFunctions(e));



        frame.add(display);
        frame.add(withdraw);
        frame.add(deposit);
        frame.add(balance);

        withdraw.setVisible(false);
        deposit.setVisible(false);
        balance.setVisible(false);


        frame.setLayout(null);
        frame.setSize(1440,900);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);

    }

    private void homeFunctions(ActionEvent home){
        if(home.getSource().equals(withdraw)){
            withdraw.setVisible(false);
            deposit.setVisible(false);
            balance.setVisible(false);
            num1.setVisible(true);
            num2.setVisible(true);
            num3.setVisible(true);
            num4.setVisible(true);
            num5.setVisible(true);
            num6.setVisible(true);
            num7.setVisible(true);
            num8.setVisible(true);
            num9.setVisible(true);
            num0.setVisible(true);
            cancel.setVisible(true);
            clear.setVisible(true);
            enter.setVisible(true);

            display.setText("Enter amount to withdraw: ");

        }
        else if(home.getSource().equals(deposit)){
            withdraw.setVisible(false);
            deposit.setVisible(false);
            balance.setVisible(false);
            num1.setVisible(true);
            num2.setVisible(true);
            num3.setVisible(true);
            num4.setVisible(true);
            num5.setVisible(true);
            num6.setVisible(true);
            num7.setVisible(true);
            num8.setVisible(true);
            num9.setVisible(true);
            num0.setVisible(true);
            cancel.setVisible(true);
            clear.setVisible(true);
            enter.setVisible(true);

            display.setText("Enter amount to deposit: ");
        }
        else if(home.getSource().equals(balance)){
            display.setText("Balance " + back_end.checkBalance());
        }
    }

    private void numpadFunctions(ActionEvent numpad){
        Object source = numpad.getSource();
        if(source.equals(num1)){
            display.setText(display.getText()+"1");
        }
        else if(numpad.getSource().equals(num2)){
            display.setText(display.getText()+"2");
        }
        else if(source.equals(num3)){
            display.setText(display.getText()+"3");
        }
        else if(source.equals(num4)){
            display.setText(display.getText()+"4");
        }
        else if(source.equals(num5)){
            display.setText(display.getText()+"5");
        }
        else if(source.equals(num6)){
            display.setText(display.getText()+"6");
        }
        else if(source.equals(num7)){
            display.setText(display.getText()+"7");
        }
        else if(source.equals(num8)){
            display.setText(display.getText()+"8");
        }
        else if(source.equals(num9)){
            display.setText(display.getText()+"9");
        }
        else if(source.equals(num0)){
            display.setText(display.getText()+"0");
        }
        else if(source.equals(cancel)){
            display.setText("Enter your card number: ");
            withdraw.setVisible(false);
            deposit.setVisible(false);
            balance.setVisible(false);
            num1.setVisible(true);
            num2.setVisible(true);
            num3.setVisible(true);
            num4.setVisible(true);
            num5.setVisible(true);
            num6.setVisible(true);
            num7.setVisible(true);
            num8.setVisible(true);
            num9.setVisible(true);
            num0.setVisible(true);
            cancel.setVisible(true);
            clear.setVisible(true);
            enter.setVisible(true);
        }
        else if(source.equals(clear)){
            String content = display.getText();
            if(!content.isEmpty()){
                display.setText(content.substring(0,content.length()-1));
            }
        }
        else if(source.equals(enter)){
            String content = display.getText();
            String[] components = content.split(":");
            if(content.contains("card")){
                display.setText(back_end.validateUser(Integer.parseInt(components[1].trim())));
                if(display.getText().contains("Invalid")){
                    SwingUtilities.invokeLater(()->{
                        Timer interval = new Timer(1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                cancel.doClick();
                            }
                        });
                        interval.setRepeats(false);
                        interval.start();
                    });
                }
                else{
                    withdraw.setVisible(true);
                    deposit.setVisible(true);
                    balance.setVisible(true);
                    num1.setVisible(false);
                    num2.setVisible(false);
                    num3.setVisible(false);
                    num4.setVisible(false);
                    num5.setVisible(false);
                    num6.setVisible(false);
                    num7.setVisible(false);
                    num8.setVisible(false);
                    num9.setVisible(false);
                    num0.setVisible(false);
                    cancel.setVisible(false);
                    clear.setVisible(false);
                    enter.setVisible(false);
                }
            }
            else if(content.contains("withdraw")){
                String result = back_end.withdraw(Integer.parseInt(components[1].trim()));
                display.setText(result);
                Timer interval = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cancel.doClick();
                    }
                });
                interval.setRepeats(false);
                interval.start();
            }
            else if(content.contains("deposit")){
                String result = back_end.deposit(Integer.parseInt(components[1].trim()));
                display.setText(result);
                Timer interval = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cancel.doClick();
                    }
                });
                interval.setRepeats(false);
                interval.start();
            }
        }
    }
}


public class ATM_Interface {
    public static void main(String[] args) {
        new Interface();
    }
}
