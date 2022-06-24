
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagConstraints;
import javax.swing.JLayeredPane;
import java.awt.Font;

public class GameWindow {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel panel_usine;
	private JPanel panel_vehicule;
	private JPanel panel_vente;
	private JPanel panel_responsable;
	private static Player_data Player = new Player_data(10); //10 = nb de parcelles total
	private JButton btnAmeliorerBucheron;
	private JButton btnRecruterBucheron;
	private JButton btnAmeliorerPlanteur;
	private JButton btnRecruterPlanteur;
	private JButton btnParcelle;
	private JLabel labelBucheron;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				System.out.println("\n");
				System.out.println("Working Directory = " + System.getProperty("user.dir"));
				System.out.println("\n");
				try {
					GameWindow window = new GameWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Engine game_eng = new Engine(Player, 1);
		
	}

	/**
	 * Create the application.
	 */
	public GameWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		UIManager.put("TabbedPane.tabAreaInsets", new Insets(2, 20, 0, 6) );
		UIManager.getLookAndFeelDefaults().put("TabbedPane:TabbedPaneTab.contentMargins", new Insets(10, 100, 10, 10));
		
		frame = new JFrame();
		frame.setBounds(100, 100, 867, 683);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		panel_usine = new JPanel();
		tabbedPane.addTab("Usine", null, panel_usine, null);
		
		panel_vehicule = new JPanel();
		//FlowLayout fl_panel_vehicule = (FlowLayout) panel_vehicule.getLayout();
		tabbedPane.addTab("Véhicule", null, panel_vehicule, null);
		
		panel_vente = new JPanel();
		tabbedPane.addTab("Vente", null, panel_vente, null);
		
		panel_responsable = new JPanel();
		tabbedPane.addTab("Responsable", null, panel_responsable, null);
		
		JPanel panel_foret = new JPanel();
		tabbedPane.addTab("Forêt", null, panel_foret, null);
		panel_foret.setLayout(null);
		
		btnAmeliorerBucheron = new JButton("Améliorer");
		btnAmeliorerBucheron.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAmeliorerBucheron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAmeliorerBucheron.setBounds(572, 78, 173, 54);
		panel_foret.add(btnAmeliorerBucheron);
		
		btnRecruterBucheron = new JButton("Recruter");
		btnRecruterBucheron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRecruterBucheron.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRecruterBucheron.setBounds(572, 158, 173, 54);
		panel_foret.add(btnRecruterBucheron);
		
		btnAmeliorerPlanteur = new JButton("Am\u00E9liorer");
		btnAmeliorerPlanteur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAmeliorerPlanteur.setBounds(572, 308, 173, 54);
		panel_foret.add(btnAmeliorerPlanteur);
		
		btnRecruterPlanteur = new JButton("Recruter");
		btnRecruterPlanteur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRecruterPlanteur.setBounds(572, 388, 173, 54);
		panel_foret.add(btnRecruterPlanteur);
		
		btnParcelle = new JButton("Ajouter une parcelle");
		btnParcelle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnParcelle.setBounds(572, 528, 173, 54);
		panel_foret.add(btnParcelle);
		
		JLabel labelPlanteur = new JLabel("Planteur");
		labelPlanteur.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelPlanteur.setBounds(617, 260, 76, 37);
		panel_foret.add(labelPlanteur);
		
		labelBucheron = new JLabel("B\u00FBcheron");
		labelBucheron.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelBucheron.setBounds(617, 30, 87, 37);
		panel_foret.add(labelBucheron);
		
		
		frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	Player.save_data();
                System.exit(0);
            }
        });
	}
}
