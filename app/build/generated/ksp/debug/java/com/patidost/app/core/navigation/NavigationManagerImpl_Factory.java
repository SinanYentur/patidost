package com.patidost.app.core.navigation;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class NavigationManagerImpl_Factory implements Factory<NavigationManagerImpl> {
  @Override
  public NavigationManagerImpl get() {
    return newInstance();
  }

  public static NavigationManagerImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NavigationManagerImpl newInstance() {
    return new NavigationManagerImpl();
  }

  private static final class InstanceHolder {
    private static final NavigationManagerImpl_Factory INSTANCE = new NavigationManagerImpl_Factory();
  }
}
