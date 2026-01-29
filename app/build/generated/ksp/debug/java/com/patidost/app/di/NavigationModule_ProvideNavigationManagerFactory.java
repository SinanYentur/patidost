package com.patidost.app.di;

import com.patidost.app.core.navigation.NavigationManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class NavigationModule_ProvideNavigationManagerFactory implements Factory<NavigationManager> {
  @Override
  public NavigationManager get() {
    return provideNavigationManager();
  }

  public static NavigationModule_ProvideNavigationManagerFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NavigationManager provideNavigationManager() {
    return Preconditions.checkNotNullFromProvides(NavigationModule.INSTANCE.provideNavigationManager());
  }

  private static final class InstanceHolder {
    private static final NavigationModule_ProvideNavigationManagerFactory INSTANCE = new NavigationModule_ProvideNavigationManagerFactory();
  }
}
