package mcdonalds.config;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBRadioButton;
import com.intellij.util.ui.FormBuilder;
import com.intellij.util.ui.UIUtil;
import org.jetbrains.annotations.NotNull;
import mcdonalds.McdoImg;
import static mcdonalds.McdoImg.PANCARTE;
import static mcdonalds.McdoImg.TRANSPARENT;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;


public class ProgressBarSettingsComponent {

    private final JPanel configMainPanel;

    private final List<JBRadioButton> backgroundsRadioButtons = new ArrayList<>();
    private final List<JBRadioButton> charactersRadioButtons = new ArrayList<>();

    public ProgressBarSettingsComponent() {
        JBLabel chooseCharacterTitle = new JBLabel("Choisissez votre personnage :", UIUtil.ComponentStyle.REGULAR);
        JBLabel chooseBackgroundTitle = new JBLabel("Choisissez votre image de fond pour les chargements déterminés:", UIUtil.ComponentStyle.REGULAR);

        ButtonGroup characterSelectGroup = new ButtonGroup();
        ButtonGroup backgroundSelectGroup = new ButtonGroup();

        FormBuilder formBuilder = FormBuilder.createFormBuilder().addComponent(chooseCharacterTitle);

        for (McdoImg character : McdoImg.getCharacters()) {
            JBRadioButton radioButton = new JBRadioButton(character.getDisplayName());
            characterSelectGroup.add(radioButton);
            charactersRadioButtons.add(radioButton);
            formBuilder.addLabeledComponent(new JLabel(character.getIcon()), radioButton);
        }

        formBuilder.addSeparator();
        formBuilder.addComponent(chooseBackgroundTitle);
        for (McdoImg background : McdoImg.getBackgrounds()) {
            JBRadioButton radioButton = new JBRadioButton(background.getDisplayName());
            backgroundSelectGroup.add(radioButton);
            backgroundsRadioButtons.add(radioButton);
            formBuilder.addLabeledComponent(new JLabel(background.getIcon()), radioButton);
        }

        configMainPanel = formBuilder.addComponentFillVertically(new JPanel(), 0).getPanel();
    }


    public JComponent getPreferredFocusedComponent() {
        try {
            return backgroundsRadioButtons.get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public JPanel getPanel() {
        return configMainPanel;
    }

    @NotNull
    public McdoImg getChosenCharacter() {
        return charactersRadioButtons.stream()
                .filter(AbstractButton::isSelected).findFirst()
                .map(radioButton -> McdoImg.valueOf(radioButton.getText().toUpperCase()))
                .orElse(PANCARTE);
    }

    public void setChosenCharacter(@NotNull McdoImg character) {
        for (JBRadioButton charactersRadioButton : charactersRadioButtons) {
            charactersRadioButton.setSelected(character.name().equals(charactersRadioButton.getText().toUpperCase()));
        }
    }


    @NotNull
    public McdoImg getChosenBackground() {
        return backgroundsRadioButtons.stream()
                .filter(AbstractButton::isSelected).findFirst()
                .map(radioButton -> McdoImg.valueOf(radioButton.getText().toUpperCase()))
                .orElse(TRANSPARENT);
    }

    public void setChosenBackground(@NotNull McdoImg background) {
        for (JBRadioButton backgroundsRadioButton : backgroundsRadioButtons) {
            backgroundsRadioButton.setSelected(background.name().equals(backgroundsRadioButton.getText().toUpperCase()));
        }
    }


}