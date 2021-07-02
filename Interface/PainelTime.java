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
import java.util.ArrayList;

public class PainelTime extends JPanel implements ActionListener
{
    public ArrayList<Time> listaDeTimes;
    private int index;
    
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
    public JButton limparCampos;
    
    public JLabel timesInseridos;
    public JComboBox comboTime = new JComboBox();
    
    public PainelTime()
    {
        this.setSize(800, 400);
        this.setLayout(null);
        listaDeTimes = new ArrayList<Time>();
        
        comboTime.setBounds(80, 240, 100, 20);
        comboTime.setVisible(true);
        this.add(comboTime);
        comboTime.addActionListener(this);
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
        inserirTime.setBounds(10, 200, 130, 20);
        inserirTime.setVisible(true);
        this.add(inserirTime);
        inserirTime.addActionListener(this);
        
        limparCampos = new JButton("Limpar");
        limparCampos.setBounds(150, 200, 100, 20);
        limparCampos.setVisible(true);
        this.add(limparCampos);
        limparCampos.addActionListener(this);
        
        timesInseridos = new JLabel("Times: ");
        timesInseridos.setBounds(10, 240, 100, 20);
        timesInseridos.setVisible(true);
        this.add(timesInseridos);
       
        this.setVisible(true);
    }
    
    public void atualizaCombo() {
        comboTime.removeAll();
        
        // for (int i=0; i < listaDeTimes.size(); i++) {
        comboTime.addItem(listaDeTimes.get(index++).getNome());
        // }
    }
    
    public void limpar() {
        caixaNomeT.setText("");
        caixaSede.setText("");
        caixaTecnico.setText("");
        caixaRenda.setText("");
        caixaGastos.setText("");
    }
            
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inserirTime)
        {
            System.out.println("Pressionou o Botão \"Inserir Jogador\"");

            Time novoTime = new Time();
            
            novoTime.setNome(caixaNomeT.getText());
            novoTime.setSede(caixaSede.getText());
            novoTime.setTecnico(caixaTecnico.getText());
            novoTime.setRenda(Float.parseFloat(caixaRenda.getText()));
            novoTime.setGastos(Float.parseFloat(caixaGastos.getText()));

            listaDeTimes.add(novoTime);
            atualizaCombo();
            
            limpar();
        } else if (e.getSource() == comboTime) {
            if (comboTime.getSelectedIndex() > 0)
            {
                caixaNomeT.setText(listaDeTimes.get(comboTime.getSelectedIndex()-1).getNome());
                caixaSede.setText(listaDeTimes.get(comboTime.getSelectedIndex()-1).getSede());
                caixaTecnico.setText(listaDeTimes.get(comboTime.getSelectedIndex()-1).getTecnico());
                caixaRenda.setText(Float.toString(listaDeTimes.get(comboTime.getSelectedIndex()-1).getRenda()));
                caixaGastos.setText(Float.toString(listaDeTimes.get(comboTime.getSelectedIndex()-1).getGastos()));
            }
        } else if (e.getSource() == limparCampos) {
            limpar();
        }
    }
}
