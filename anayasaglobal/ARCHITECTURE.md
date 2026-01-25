# PROJECT ARCHITECTURE: PATIDOST

## PATTERN
- Clean Architecture (MVVM + Repository Pattern)

## LAYERS
1. **:app** -> DI Root, UI Host.
2. **:data** -> API, DB, Repository Impl.
3. **:domain** -> Business Logic, UseCases (Pure Kotlin).
4. **:core** -> Shared Utils.

## DEPENDENCY RULES
- :data depends on :domain.
- :domain MUST NOT have Android dependencies.
