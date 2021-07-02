package Interface;

import MO.Jogador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelJogador extends JPanel implements ActionListener
{
    public ArrayList<Jogador> listaDeJogadores;
    private int index;
    
    public JLabel labelNomeJ;
    public JTextField caixaNomeJ;

    public JLabel labelAltura;
    public JTextField caixaAltura;

    public JLabel labelCamisa;
    public JTextField caixaCamisa;

    public JLabel labelIdade;
    public JTextField caixaIdade;

    public JLabel labelSalario;
    public JTextField caixaSalario;

    public JLabel labelPeso;
    public JTextField caixaPeso;
    
    public JButton inserirJogador;
    public JButton limparCampos;
    
    public JLabel jogadoresInseridos;
    public JComboBox comboJogador = new JComboBox();

    public PainelJogador()
    {
        this.setSize(800, 400);
        this.setLayout(null);
        listaDeJogadores = new ArrayList<Jogador>();
       
        comboJogador.setBounds(80, 240, 100, 20);
        comboJogador.setVisible(true);
        this.add(comboJogador);
        comboJogador.addActionListener(this);
        comboJogador.addItem("-");

        labelNomeJ = new JLabel("Nome do jogador: ");
        labelNomeJ.setBounds(0, 10, 120, 20);
        labelNomeJ.setVisible(true);
        this.add(labelNomeJ);

        caixaNomeJ = new JTextField();
        caixaNomeJ.setBounds(120, 10, 100, 20);
        caixaNomeJ.setVisible(true);
        this.add(caixaNomeJ);

        labelAltura = new JLabel("Altura: ");
        labelAltura.setBounds(10, 40, 100, 20);
        labelAltura.setVisible(true);
        this.add(labelAltura);

        caixaAltura = new JTextField();
        caixaAltura.setBounds(120, 40, 100, 20);
        caixaAltura.setVisible(true);
        this.add(caixaAltura);

        labelCamisa = new JLabel("Camisa: ");
        labelCamisa.setBounds(10, 70, 100, 20);
        labelCamisa.setVisible(true);
        this.add(labelCamisa);

        caixaCamisa = new JTextField();
        caixaCamisa.setBounds(120, 70, 100, 20);
        caixaCamisa.setVisible(true);
        this.add(caixaCamisa);

        labelIdade = new JLabel("Idade: ");
        labelIdade.setBounds(10, 100, 100, 20);
        labelIdade.setVisible(true);
        this.add(labelIdade);

        caixaIdade = new JTextField();
        caixaIdade.setBounds(120, 100, 100, 20);
        caixaIdade.setVisible(true);
        this.add(caixaIdade);

        labelSalario = new JLabel("Salario: ");
        labelSalario.setBounds(10, 130, 100, 20);
        labelSalario.setVisible(true);
        this.add(labelSalario);

        caixaSalario = new JTextField();
        caixaSalario.setBounds(120, 130, 100, 20);
        caixaSalario.setVisible(true);
        this.add(caixaSalario);

        labelPeso = new JLabel("Peso: ");
        labelPeso.setBounds(10, 160, 100, 20);
        labelPeso.setVisible(true);
        this.add(labelPeso);

        caixaPeso = new JTextField();
        caixaPeso.setBounds(120, 160, 100, 20);
        caixaPeso.setVisible(true);
        this.add(caixaPeso);
        
        inserirJogador = new JButton("Inserir Jogador");
        inserirJogador.setBounds(10, 200, 130, 20);
        inserirJogador.setVisible(true);
        this.add(inserirJogador);
        inserirJogador.addActionListener(this);
        
        limparCampos = new JButton("Limpar");
        limparCampos.setBounds(150, 200, 100, 20);
        limparCampos.setVisible(true);
        this.add(limparCampos);
        limparCampos.addActionListener(this);
        
        jogadoresInseridos = new JLabel("Jogadores: ");
        jogadoresInseridos.setBounds(10, 240, 100, 20);
        jogadoresInseridos.setVisible(true);
        this.add(jogadoresInseridos);
        
        this.setVisible(true);
        // this.setDefaultCloseOperation(ClosableFrame.DO_NOTHING_ON_CLOSE);
    }
    
    public void atualizaCombo() {
        comboJogador.removeAll();
        
        // for (int i=0; i < listaDeJogadores.size(); i++) {
        comboJogador.addItem(listaDeJogadores.get(index++).getNome());
        // }
    }
    
    public void limpar() {
        caixaNomeJ.setText("");
        caixaAltura.setText("");
        caixaCamisa.setText("");
        caixaIdade.setText("");
        caixaPeso.setText("");
        caixaSalario.setText("");
    }
            
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inserirJogador)
        {
            System.out.println("Pressionou o Botão \"Inserir Jogador\"");

            Jogador novoJogador = new Jogador();
            
            novoJogador.setNome(caixaNomeJ.getText());
            novoJogador.setAltura(Integer.parseInt(caixaAltura.getText()));
            novoJogador.setCamisa(Integer.parseInt(caixaCamisa.getText()));
            novoJogador.setIdade(Integer.parseInt(caixaIdade.getText()));
            novoJogador.setSalario(Float.parseFloat(caixaSalario.getText()));
            novoJogador.setPeso(Float.parseFloat(caixaPeso.getText()));

            listaDeJogadores.add(novoJogador);
            atualizaCombo();
            
            limpar();
        } else if (e.getSource() == comboJogador) {
            if (comboJogador.getSelectedIndex() > 0)
            {
                caixaNomeJ.setText(listaDeJogadores.get(comboJogador.getSelectedIndex()-1).getNome());
                caixaAltura.setText(Integer.toString(listaDeJogadores.get(comboJogador.getSelectedIndex()-1).getAltura()));
                caixaCamisa.setText(Integer.toString(listaDeJogadores.get(comboJogador.getSelectedIndex()-1).getCamisa()));
                caixaIdade.setText(Integer.toString(listaDeJogadores.get(comboJogador.getSelectedIndex()-1).getIdade()));
                caixaSalario.setText(Float.toString(listaDeJogadores.get(comboJogador.getSelectedIndex()-1).getSalario()));
                caixaPeso.setText(Float.toString(listaDeJogadores.get(comboJogador.getSelectedIndex()-1).getPeso()));
            }
        } else if (e.getSource() == limparCampos) {
            limpar();
        }

        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
