import java.awt.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class jokenpo extends JPanel {

    public jokenpo() {
        inicializar();
        Eventos();
    }

    //Variaveis a serem usados
    String selecionado;
    int placarP1 = 0;
    int placarP2 = 0;
    //Define as Labels dos jogadores
    JLabel lbJogador1, lbJogador2;
    //Define as imagens a serem usadas nas Labels dos jogadores
    ImageIcon imgPedra, imgPapel, imgTesoura, imgNull;
    //Define o título/ quem ganhou
    JLabel lbTitulo;
    //Define o placar de cada jogador
    JLabel lbPlacarJgd1, lbPlacarJgd2;
    //Define o Botão de jogar
    JButton btnJogar;
    //Define as opções de jogada
    JRadioButton rbPedra, rbPapel, rbTesoura;
    //Define o Button group das opções
    ButtonGroup btgOpcs;


    public void inicializar() {
        setLayout(null);

        //Instanciando os elementos
        imgNull = new ImageIcon(getClass().getResource("null.png"));
        imgPedra = new ImageIcon(getClass().getResource("pedra.png"));
        imgPapel = new ImageIcon(getClass().getResource("papel.png"));
        imgTesoura = new ImageIcon(getClass().getResource("tesoura.png"));

        lbJogador1 = new JLabel(imgNull);
        lbJogador2 = new JLabel(imgNull);


        lbTitulo = new JLabel("Escolha uma opção e clicke em \"jogar\"");

        lbPlacarJgd1 = new JLabel(""+placarP1);
        lbPlacarJgd2 = new JLabel(""+placarP2);

        btnJogar = new JButton("JOGAR");

        rbPedra = new JRadioButton("Pedra");
        rbPapel = new JRadioButton("Papel");
        rbTesoura = new JRadioButton("Tesoura");

        btgOpcs = new ButtonGroup();

        //Adicionando elementos ao JPanel
        add(lbJogador1);
        add(lbJogador2);

        add(lbTitulo);

        add(lbPlacarJgd1);
        add(lbPlacarJgd2);

        add(rbPedra);
        add(rbPapel);
        add(rbTesoura);

        btgOpcs.add(rbPedra);
        btgOpcs.add(rbPapel);
        btgOpcs.add(rbTesoura);

        add(btnJogar);


        //Definindo o posicionamento dos elementos

        lbJogador1.setBounds(105,113,275,220);
        lbJogador2.setBounds(539,113,275,220);

        lbTitulo.setBounds(337,12,300,56);

        lbPlacarJgd1.setBounds(226,68,24,34);
        lbPlacarJgd2.setBounds(665,68,24,34);

        rbPedra.setBounds(105,349,81,12);
        rbPapel.setBounds(202,349,81,12);
        rbTesoura.setBounds(299,349,100,12);

        btnJogar.setBounds(380,397,159,54);

    }

    public void Eventos() {

        rbPedra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Verifica()) {
                    lbJogador1.setIcon(imgPedra);
                    selecionado = "Pedra";
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione ao menos uma opção");
                }
            }
        });
        rbPapel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lbJogador1.setIcon(imgPapel);
                selecionado = "Papel";

            }
        });
        rbTesoura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    lbJogador1.setIcon(imgTesoura);
                    selecionado = "Tesoura";
            }
        });

        btnJogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bot = null;

                if (Verifica()) {
                    int sorteio = (int) (Math.random() * 3) + 1;

                    if (sorteio == 1){
                        lbJogador2.setIcon(imgPedra);
                        bot = "Pedra";
                    }

                    else if (sorteio == 2){
                        lbJogador2.setIcon(imgPapel);
                        bot = "Papel";
                    }
                    else if (sorteio == 3){
                        lbJogador2.setIcon(imgTesoura);
                        bot = "Tesoura";
                    }
                    //Condições para o player 2 vencer
                    if (selecionado.equals("Pedra") && bot.equals("Papel")){
                        lbTitulo.setText("Player 2 venceu!");
                        placarP1+= 1;
                        Placar();
                    }
                    else if (selecionado.equals("Papel") && bot.equals("Tesoura")){
                        lbTitulo.setText("Player 2 venceu!");
                        placarP1+= 1;
                        Placar();
                    }
                    else if (selecionado.equals("Tesoura") && bot.equals("Pedra")){
                        lbTitulo.setText("Player 2 venceu!");
                        placarP1+= 1;
                        Placar();
                    }
                    //Condições para o player 1 vencer
                    if (bot.equals("Pedra") && selecionado.equals("Papel")){
                        lbTitulo.setText("Player 1 venceu!");
                        placarP2+= 1;
                        Placar();
                    }
                    else if (bot.equals("Papel") && selecionado.equals("Tesoura")){
                        lbTitulo.setText("Player 1 venceu!");
                        placarP2+= 1;
                        Placar();
                    }
                    else if (bot.equals("Tesoura") && selecionado.equals("Pedra")){
                        lbTitulo.setText("Player 1 venceu!");
                        placarP2+= 1;
                        Placar();
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione ao menos uma opção");
                }
            }
        });


    }

    public boolean Verifica(){
        return (rbPedra.isSelected()||rbPapel.isSelected()||rbTesoura.isSelected()) ? true : false;
    }

    public void Placar(){
        lbPlacarJgd1.setText(""+placarP1);
        lbPlacarJgd2.setText(""+placarP2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("jokenpo");
        frame.getContentPane().add(new jokenpo());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 900, 500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
//        frame.setBackground(new Color(0x1B1A19));


    }
}