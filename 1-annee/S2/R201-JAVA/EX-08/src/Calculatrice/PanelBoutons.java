package Calculatrice;

import java.awt.GridLayout;

import javax.swing.*;

public class PanelBoutons extends JPanel{
	JButton BTN0;
	JButton BTN1;
	JButton BTN2;
	JButton BTN3;
	JButton BTN4;
	JButton BTN5;
	JButton BTN6;
	JButton BTN7;
	JButton BTN8;
	JButton BTN9;
	JButton BTNAdd;
	JButton BTNMin;
	JButton BTNTim;
	JButton BTNDiv;
	JButton BTNCe;
	JButton BTNEqual;
	
	public PanelBoutons() {
		BTN0 = new JButton("0");
		BTN1 = new JButton("1");
		BTN2 = new JButton("2");
		BTN3 = new JButton("3");
		BTN4 = new JButton("4");
		BTN5 = new JButton("5");
		BTN6 = new JButton("6");
		BTN7 = new JButton("7");
		BTN8 = new JButton("8");
		BTN9 = new JButton("9");
		BTNAdd = new JButton("+");
		BTNMin = new JButton("-");
		BTNTim = new JButton("x");
		BTNDiv = new JButton("/");
		BTNCe = new JButton("C/CE");
		BTNEqual = new JButton("=");
		setLayout(new GridLayout(4,4));
		add(BTN0);
		add(BTN1);
		add(BTN2);
		add(BTN3);
		add(BTN4);
		add(BTN5);
		add(BTN6);
		add(BTN7);
		add(BTN8);
		add(BTN9);
		add(BTNAdd);
		add(BTNMin);
		add(BTNTim);
		add(BTNDiv);
		add(BTNCe);
		add(BTNEqual);
		
	}
	
	
}
