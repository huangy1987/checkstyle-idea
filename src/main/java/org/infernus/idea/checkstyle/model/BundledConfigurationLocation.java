package org.infernus.idea.checkstyle.model;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import org.infernus.idea.checkstyle.csapi.BundledConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


@SuppressWarnings("MethodDoesntCallSuperMethod")
public class BundledConfigurationLocation extends ConfigurationLocation
{
    @NotNull
    private final BundledConfig bundledConfig;


    BundledConfigurationLocation(@NotNull final BundledConfig pBundledConfig) {
        super(ConfigurationType.BUNDLED);
        super.setLocation(pBundledConfig.getLocation());
        super.setDescription(pBundledConfig.getDescription());
        bundledConfig = pBundledConfig;
    }


    @NotNull
    public BundledConfig getBundledConfig() {
        return bundledConfig;
    }

    @Override
    public Map<String, String> getProperties() {
        // the bundled configurations have no properties
        return Collections.emptyMap();
    }

    @Override
    public void setLocation(final String location) {
        // do nothing, we always use the hard-coded location
    }

    @Override
    public void setDescription(@Nullable final String description) {
        // do nothing, we always use the hard-coded description
    }

    @Override
    @NotNull
    protected InputStream resolveFile() {
        // This is impossible to resolve here, as this is possible only in the 'csaccess' source set.
        // Fortunately, it is also unnecessary, because the bundled configs always exist and contain no properties.
        throw new UnsupportedOperationException("load via CheckstyleActions.loadConfiguration() instead");
    }

    public boolean isEditableInConfigDialog() {
        return false;
    }


    @Override
    @NotNull
    public BundledConfigurationLocation clone() {
        return new BundledConfigurationLocation(bundledConfig);
    }
}
