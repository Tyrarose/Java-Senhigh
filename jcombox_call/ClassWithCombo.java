import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
class ClassWithCombo extends JDialog {
    private static final String[] DATA = { "Mon", "Tues", "Wed", "Thurs", "Fri" };
    private JComboBox<String> combo = new JComboBox<>(DATA);

    public ClassWithCombo(JFrame frame) {
        // !! don't make it MODELESS
        // !! super(frame, "Holds Combo Dialog", ModalityType.MODELESS);
        // !! note the change. Made it APPLICATION_MODAL
        super(frame, "Holds Combo Dialog", ModalityType.APPLICATION_MODAL);

        JButton submitButton = new JButton(new AbstractAction("Submit") {
            // !! add an ActionListener to close window when the submit button
            // has been pressed.

            @Override
            public void actionPerformed(ActionEvent e) {
                ClassWithCombo.this.setVisible(false);
            }
        });

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(300, 250));
        add(combo);
        add(submitButton);
    }

    public String getSelectedItem() {
        return (String) combo.getSelectedItem();
    }

}