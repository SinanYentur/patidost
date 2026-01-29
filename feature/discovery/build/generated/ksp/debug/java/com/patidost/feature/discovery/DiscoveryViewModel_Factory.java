package com.patidost.feature.discovery;

import com.patidost.core.domain.repository.DiscoveryRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class DiscoveryViewModel_Factory implements Factory<DiscoveryViewModel> {
  private final Provider<DiscoveryRepository> discoveryRepositoryProvider;

  public DiscoveryViewModel_Factory(Provider<DiscoveryRepository> discoveryRepositoryProvider) {
    this.discoveryRepositoryProvider = discoveryRepositoryProvider;
  }

  @Override
  public DiscoveryViewModel get() {
    return newInstance(discoveryRepositoryProvider.get());
  }

  public static DiscoveryViewModel_Factory create(
      Provider<DiscoveryRepository> discoveryRepositoryProvider) {
    return new DiscoveryViewModel_Factory(discoveryRepositoryProvider);
  }

  public static DiscoveryViewModel newInstance(DiscoveryRepository discoveryRepository) {
    return new DiscoveryViewModel(discoveryRepository);
  }
}
