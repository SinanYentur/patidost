package com.patidost.feature.pet_detail;

import androidx.lifecycle.SavedStateHandle;
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
public final class PetDetailViewModel_Factory implements Factory<PetDetailViewModel> {
  private final Provider<DiscoveryRepository> discoveryRepositoryProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public PetDetailViewModel_Factory(Provider<DiscoveryRepository> discoveryRepositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.discoveryRepositoryProvider = discoveryRepositoryProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public PetDetailViewModel get() {
    return newInstance(discoveryRepositoryProvider.get(), savedStateHandleProvider.get());
  }

  public static PetDetailViewModel_Factory create(
      Provider<DiscoveryRepository> discoveryRepositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new PetDetailViewModel_Factory(discoveryRepositoryProvider, savedStateHandleProvider);
  }

  public static PetDetailViewModel newInstance(DiscoveryRepository discoveryRepository,
      SavedStateHandle savedStateHandle) {
    return new PetDetailViewModel(discoveryRepository, savedStateHandle);
  }
}
