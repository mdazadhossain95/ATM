import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleAwtGui implements ActionListener {
        private static final int button_count = 10;

        // Declare a Frame type variable
        Frame frame;
        MenuBar menuBar;
        Menu fileMenu, optionsMenu, helpMenu;
        Panel panelUpperSection, panelLowerSection;
        Label labelButtonPressHeading, labelButtonPressed;

        // Create an array of Button type Objects
        Button[] button = new Button[button_count];

        public SimpleAwtGui() {
            // Create Frame Object and pass in the Frame Name / title
            frame = new Frame("AWT GUI EXAMPLE");

            // Create MenuBar Object
            menuBar = new MenuBar();

            createPanels();
            createLabels();
            createButtons();
            createMenu();
        }

        private void createMenu() {
            // Create Menu objects to add to the MenuBar
            fileMenu = new Menu("File");
            optionsMenu = new Menu("Options");
            helpMenu = new Menu("Help");
        }

        private void createPanels() {
            // Create a panel object for organizing content
            panelUpperSection = new Panel();
            panelLowerSection = new Panel();
        }

        private void createLabels() {
            // create Label
            labelButtonPressHeading = new Label();
            labelButtonPressed = new Label();
        }

        private void createButtons() {
            // Use for loop to instantiate every button object
            for (int i = 0; i < button_count; ++i) {
                button[i] = new Button("" + i);
                button[i].setActionCommand("" + i);

                // if i is odd then change the button color
                if (i % 2 == 1) {
                    button[i].setBackground(Color.BLACK);
                    button[i].setForeground(Color.WHITE);
                }
            }
        }


        // Not necessary but good practice all codes inside this can be written inside main
        public void showFrame() {
            // set the size of the window
            frame.setSize(400, 400);

            // set the layout for the window
            frame.setLayout(new GridLayout(2, 1));

            addPanels();

            addLabels();

            // Add all of the buttons to the layout
            for (int i = 0; i < button_count; ++i) {
                panelLowerSection.add(button[i]);
                button[i].addActionListener(this);
            }

            // handles various window events
            handleWindowEvents();

            // Add Menu to MenuBar
            addMenuBarMenus();

            // Add MenuItem to Menu
            addMenuItems();

            // Add MenuBar to the Frame
            frame.setMenuBar(menuBar);

            // set the frame visible otherwise nothing will be shown
            frame.setVisible(true);
        }

        private void addPanels() {
            // Add panel to the frame
            frame.add(panelUpperSection);
            frame.add(panelLowerSection);

            // Set Layout for the panels
            panelUpperSection.setLayout(new BorderLayout());
            panelLowerSection.setLayout(new GridLayout());

            // Add Label to Panel
            panelUpperSection.add(labelButtonPressHeading, BorderLayout.NORTH);
            panelUpperSection.add(labelButtonPressed, BorderLayout.CENTER);
        }

        private void addLabels() {
            labelButtonPressHeading.setBackground(Color.BLACK);
            labelButtonPressHeading.setText("Buttons clicked will be shown Below:");
            labelButtonPressHeading.setForeground(Color.WHITE);

            labelButtonPressed.setBackground(Color.DARK_GRAY);
            labelButtonPressed.setForeground(Color.WHITE);
        }

        private void handleWindowEvents() {
            // Register window listener event to the frame without implementing WindowListener
            frame.addWindowListener(
                    new WindowAdapter() {
                        public void windowClosing(WindowEvent e) {
                            System.exit(0);
                        }
                    }
            );
        }

        private void addMenuBarMenus() {
            // Add Menu to the MenuBar
            menuBar.add(fileMenu);
            menuBar.add(optionsMenu);
            menuBar.add(helpMenu);
        }

        private void addMenuItems() {
            // Add items to File Menu
            fileMenu.add(new MenuItem("New"));
            fileMenu.add(new MenuItem("Open"));
            fileMenu.add(new MenuItem("Help"));

            // Add items to File Menu
            optionsMenu.add(new MenuItem("Options"));

            // Add items to File Menu
            helpMenu.add(new MenuItem("Help"));
            helpMenu.add(new MenuItem("About"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = Integer.parseInt(e.getActionCommand());

            if (i % 2 == 1) {
                labelButtonPressed.setText("Odd buttons Pressed");
            } else {
                labelButtonPressed.setText("Even buttons Pressed");
            }
        }

        public static void main(String[] args) {

            // Create an instance of SimpleAwtGui
            SimpleAwtGui gapp = new SimpleAwtGui();

            // call the showFrame() function to display the window
            gapp.showFrame();

        }

    }
