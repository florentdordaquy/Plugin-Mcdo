package mcdonalds.config;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import mcdonalds.McdoImg;


@State(
        name = "mcdonalds.config.ProgressBarSettingsState",
        storages = @Storage("ProgressBarPluginSettings.xml")
)
public class ProgressBarSettingsState implements PersistentStateComponent<ProgressBarSettingsState> {

    public McdoImg selectedCharacter = McdoImg.BURGER;
    public McdoImg selectedBackground = McdoImg.TRANSPARENT;

    @Nullable
    @Override
    public ProgressBarSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull ProgressBarSettingsState state) {
        this.selectedCharacter = state.selectedCharacter;
        this.selectedBackground = state.selectedBackground;
    }

    public static ProgressBarSettingsState getInstance() {
        return com.intellij.openapi.application.ApplicationManager.getApplication().getService(ProgressBarSettingsState.class);
    }
}