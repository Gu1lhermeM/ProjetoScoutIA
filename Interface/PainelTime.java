package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.List;

import MO.Time;

public class PainelTime extends JPanel implements ActionListener
{
    public List listaDeTimes = new List();
    private int i;
    
    public JLabel labelNomeT;
    public JTextField caixaNomeT;

    public JLabel labelSede;
    public JTextField caixaSede;

    public JLabel labelTecnico;
    public JTextField caixaTecnico;

    public JLabel labelRenda;
    public JTextField caixaRenda;

    public JLabel labelGastos;
    public JTextField caixaGastos;
    
    public JButton inserirTime;
    
    public JLabel timesInseridos;
    public JComboBox comboTime = new JComboBox();
    
    public PainelTime()
    {
        this.setSize(400, 300);
        this.setLayout(null);
        
        comboTime.setBounds(80, 230, 100, 20);
        comboTime.setVisible(true);
        this.add(comboTime);

        comboTime.addItem("-");
        
        labelNomeT = new JLabel("Nome do time: ");
        labelNomeT.setBounds(10, 10, 100, 20);
        labelNomeT.setVisible(true);
        this.add(labelNomeT);

        caixaNomeT = new JTextField();
        caixaNomeT.setBounds(120, 10, 100, 20);
        caixaNomeT.setVisible(true);
        this.add(caixaNomeT);

        labelSede = new JLabel("Sede: ");
        labelSede.setBounds(10, 40, 100, 20);
        labelSede.setVisible(true);
        this.add(labelSede);

        caixaSede = new JTextField();
        caixaSede.setBounds(120, 40, 100, 20);
        caixaSede.setVisible(true);
        this.add(caixaSede);

        labelTecnico = new JLabel("Tecnico: ");
        labelTecnico.setBounds(10, 70, 100, 20);
        labelTecnico.setVisible(true);
        this.add(labelTecnico);

        caixaTecnico = new JTextField();
        caixaTecnico.setBounds(120, 70, 100, 20);
        caixaTecnico.setVisible(true);
        this.add(caixaTecnico);

        labelRenda = new JLabel("Renda: ");
        labelRenda.setBounds(10, 100, 100, 20);
        labelRenda.setVisible(true);
        this.add(labelRenda);

        caixaRenda = new JTextField();
        caixaRenda.setBounds(120, 100, 100, 20);
        caixaRenda.setVisible(true);
        this.add(caixaRenda);

        labelGastos = new JLabel("Gastos: ");
        labelGastos.setBounds(10, 130, 100, 20);
        labelGastos.setVisible(true);
        this.add(labelGastos);

        caixaGastos = new JTextField();
        caixaGastos.setBounds(120, 130, 100, 20);
        caixaGastos.setVisible(true);
        this.add(caixaGastos);
        
        inserirTime = new JButton("Inserir Time");
        inserirTime.setBounds(10, 200, 200, 20);
        inserirTime.setVisible(true);
        this.add(inserirTime);
        inserirTime.addActionListener(this);
        
        timesInseridos = new JLabel("Times: ");
        timesInseridos.setBounds(10, 230, 100, 20);
        timesInseridos.setVisible(true);
        this.add(timesInseridos);
       
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Pressionou o Botão \"Inserir Time\"");
        
        Time novoTime = new Time();
        novoTime.setNome(caixaNomeT.getText());
        listaDeTimes.add(novoTime.getNome());
        comboTime.addItem(novoTime.getNome());


        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
