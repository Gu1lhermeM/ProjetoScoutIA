package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame implements ActionListener
{
	public PainelJogador painelJ;
        public JButton jogador;
        
        public PainelTime painelT;
        public JButton time;
	
	public Janela()
	{
		super("Cadastro");
		this.setSize(800, 600);
		this.setLayout(null);
		
		painelJ = new PainelJogador();
		painelJ.setBounds(100, 100, 400, 300);
		painelJ.setVisible(false);
		this.getContentPane().add(painelJ);
		
		jogador = new JButton("Jogador");
		jogador.setBounds(10, 10, 100, 20);
		jogador.setVisible(true);
		this.getContentPane().add(jogador);
		jogador.addActionListener(this);
		
                painelT = new PainelTime();
                painelT.setBounds(100, 100, 400, 300);
		painelT.setVisible(false);
		this.getContentPane().add(painelT);
                
                time = new JButton("Time");
		time.setBounds(150, 10, 100, 20);
		time.setVisible(true);
		this.getContentPane().add(time);
		time.addActionListener(this);
                
		this.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) 
	{
            if(e.getSource() == jogador)
            {
                painelJ.setVisible(true);
                painelT.setVisible(false);
            } 
            else if (e.getSource() == time)
            {
                painelT.setVisible(true);
                painelJ.setVisible(false);
            }
        }
}
