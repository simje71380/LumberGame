

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

public class GameWindow {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel panel_usine;
	private JPanel panel_vehicule;
	private JPanel panel_vente;
	private JPanel panel_responsable;
	private static Player_data Player = new Player_data(10); //10 = nb de parcelles total

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_foret = new JPanel();
		tabbedPane.addTab("Forêt", null, panel_foret, null);
		
		panel_usine = new JPanel();
		tabbedPane.addTab("Usine", null, panel_usine, null);
		
		panel_vehicule = new JPanel();
		//FlowLayout fl_panel_vehicule = (FlowLayout) panel_vehicule.getLayout();
		tabbedPane.addTab("Véhicule", null, panel_vehicule, null);
		
		panel_vente = new JPanel();
		tabbedPane.addTab("Vente", null, panel_vente, null);
		
		panel_responsable = new JPanel();
		tabbedPane.addTab("Responsable", null, panel_responsable, null);
		frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	Player.save_data();
                System.exit(0);
            }
        });
	}
}
