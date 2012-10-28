package ch16.ex16_11;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class Sanmoku extends JFrame implements ActionListener {

	private Button B[];
	private Label ML;
	private boolean F;

	public Sanmoku() {
		super("TicTacToe");
		int i;
		setSize(200, 200);
		Panel P = new Panel(new GridLayout(3, 3));
		add(P, BorderLayout.CENTER);
		for (i = 0, B = new Button[9]; i < 9; i++) {
			B[i] = new Button();
			B[i].addActionListener(this);
			B[i].setActionCommand(Integer.toString(i));
			P.add(B[i]);
		}
		;
		ML = new Label();
		add(ML, BorderLayout.SOUTH);
		F = true;
	};

	synchronized boolean SetF(boolean nf) {
		boolean of = F;
		F = nf;
		return (of);
	};

	@Override
	public void actionPerformed(ActionEvent ae) {

		int n, i;
		if (!SetF(false))
			return;

		try {
			n = Integer.parseInt(ae.getActionCommand());
			System.out.println(n);
			if ((n >= 0) && (n < 9))
				if (B[n].getLabel().length() == 0) {
					B[n].setLabel("o");
					if (WinCheck(n, "o")) {
						ML.setText("You Win");
						return;
					} else {
						n = (int) (Math.random() * 9.0);
						for (i = 0; i < 9; i++, n++){
							if (B[++n >= 9 ? n = 0 : n].getLabel().length() == 0)
								break;
						}
						if (i == 9) {
							ML.setText("Even");
							return;
						}
						;
						B[n].setLabel("x");
						if (WinCheck(n, "x")) {
							ML.setText("I Win");
							return;
						}
						;
					}
					;
				}
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
		;

		SetF(true);

	};

	private static final int CI[][] = { { -2, -1, 1, 2 }, { -40, -20, 20, 40 },
			{ -42, -21, 21, 42 }, { -38, -19, 19, 38 } };

	private boolean WinCheck(int n, String s) {

		int[][] patern ={
				{0,1,2},
				{3,4,5},
				{6,7,8},
				{0,4,8},
				{2,4,6},
				{0,3,6},
				{1,4,7},
				{2,5,8}
		};
		for(int i = 0; i < 8; i++){
			for(int j = 0, flag = 0; j < 3; j++){
				if (B[patern[i][j]].getLabel().equals(s))flag++;

				if(j == 2 && flag == 3)return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {

		Sanmoku S = new Sanmoku();
		S.setVisible(true);

	};

}