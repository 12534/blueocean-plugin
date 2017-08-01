package io.jenkins.blueocean.blueocean_bitbucket_pipeline.cloud;

import com.cloudbees.jenkins.plugins.bitbucket.BitbucketSCMSource;
import hudson.Extension;
import hudson.model.Item;
import io.jenkins.blueocean.blueocean_bitbucket_pipeline.AbstractBitbucketScmContentProvider;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * @author cliffmeyers
 */
@Extension(ordinal = -100)
public class BitbucketCloudScmContentProvider extends AbstractBitbucketScmContentProvider {
    @Nonnull
    @Override
    public String getScmId() {
        return BitbucketCloudScm.ID;
    }

    @CheckForNull
    @Override
    public String getApiUrl(@Nonnull Item item) {
        BitbucketSCMSource source = getSourceFromItem(item);
        return source != null ? source.getServerUrl() : null;
    }

    @Override
    public boolean support(@Nonnull Item item) {
        BitbucketSCMSource source = getSourceFromItem(item);
        return source != null && source.getServerUrl().startsWith(BitbucketCloudScm.API_URL);
    }
}
