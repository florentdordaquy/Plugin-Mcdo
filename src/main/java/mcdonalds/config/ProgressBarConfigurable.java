package mcdonalds.config;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;
import javax.swing.JComponent;

public class ProgressBarConfigurable implements Configurable {

  private ProgressBarSettingsComponent mySettingsComponent;

  @Nls(capitalization = Nls.Capitalization.Title)
  @Override
  public String getDisplayName() {
    return "Mcdo Plugin";
  }

  @Override
  public JComponent getPreferredFocusedComponent() {
    return mySettingsComponent.getPreferredFocusedComponent();
  }

  @Nullable
  @Override
  public JComponent createComponent() {
    mySettingsComponent = new ProgressBarSettingsComponent();
    return mySettingsComponent.getPanel();
  }

  @Override
  public boolean isModified() {
    ProgressBarSettingsState settings = ProgressBarSettingsState.getInstance();
      return !mySettingsComponent.getChosenCharacter().equals(settings.selectedCharacter) || !mySettingsComponent.getChosenBackground().equals(settings.selectedBackground);
  }

  @Override
  public void apply() {
    ProgressBarSettingsState settings = ProgressBarSettingsState.getInstance();
    settings.selectedCharacter = mySettingsComponent.getChosenCharacter();
    settings.selectedBackground = mySettingsComponent.getChosenBackground();
  }

  @Override
  public void reset() {
    ProgressBarSettingsState settings = ProgressBarSettingsState.getInstance();
    mySettingsComponent.setChosenCharacter(settings.selectedCharacter);
    mySettingsComponent.setChosenBackground(settings.selectedBackground);
  }

  @Override
  public void disposeUIResources() {
    mySettingsComponent = null;
  }

}